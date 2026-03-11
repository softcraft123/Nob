package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.proto.MaybeDocument;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.BackgroundQueue;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

final class SQLiteRemoteDocumentCache implements RemoteDocumentCache {
    static final int BINDS_PER_STATEMENT = 9;
    private final SQLitePersistence db;
    private final DocumentTypeBackfiller documentTypeBackfiller = new DocumentTypeBackfiller();
    private IndexManager indexManager;
    private final LocalSerializer serializer;

    SQLiteRemoteDocumentCache(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer) {
        this.db = sQLitePersistence;
        this.serializer = localSerializer;
    }

    public void setIndexManager(IndexManager indexManager2) {
        this.indexManager = indexManager2;
    }

    private enum DocumentType {
        NO_DOCUMENT(1),
        FOUND_DOCUMENT(2),
        UNKNOWN_DOCUMENT(3),
        INVALID_DOCUMENT(4);
        
        final int dbValue;

        private DocumentType(int i) {
            this.dbValue = i;
        }

        static DocumentType forMutableDocument(MutableDocument mutableDocument) {
            if (mutableDocument.isNoDocument()) {
                return NO_DOCUMENT;
            }
            if (mutableDocument.isFoundDocument()) {
                return FOUND_DOCUMENT;
            }
            if (mutableDocument.isUnknownDocument()) {
                return UNKNOWN_DOCUMENT;
            }
            Assert.hardAssert(!mutableDocument.isValidDocument(), "MutableDocument has an unknown type", new Object[0]);
            return INVALID_DOCUMENT;
        }
    }

    public void add(MutableDocument mutableDocument, SnapshotVersion snapshotVersion) {
        Assert.hardAssert(!snapshotVersion.equals(SnapshotVersion.NONE), "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        DocumentKey key = mutableDocument.getKey();
        Timestamp timestamp = snapshotVersion.getTimestamp();
        this.db.execute("INSERT OR REPLACE INTO remote_documents (path, path_length, read_time_seconds, read_time_nanos, document_type, contents) VALUES (?, ?, ?, ?, ?, ?)", EncodedPath.encode(key.getPath()), Integer.valueOf(key.getPath().length()), Long.valueOf(timestamp.getSeconds()), Integer.valueOf(timestamp.getNanoseconds()), Integer.valueOf(DocumentType.forMutableDocument(mutableDocument).dbValue), this.serializer.encodeMaybeDocument(mutableDocument).toByteArray());
        this.indexManager.addToCollectionParentIndex(mutableDocument.getKey().getCollectionPath());
    }

    public void removeAll(Collection<DocumentKey> collection) {
        if (!collection.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ImmutableSortedMap<DocumentKey, Document> emptyDocumentMap = DocumentCollections.emptyDocumentMap();
            for (DocumentKey next : collection) {
                arrayList.add(EncodedPath.encode(next.getPath()));
                emptyDocumentMap = emptyDocumentMap.insert(next, MutableDocument.newNoDocument(next, SnapshotVersion.NONE));
            }
            SQLitePersistence.LongQuery longQuery = new SQLitePersistence.LongQuery(this.db, "DELETE FROM remote_documents WHERE path IN (", arrayList, ")");
            while (longQuery.hasMoreSubqueries()) {
                longQuery.executeNextSubquery();
            }
            this.indexManager.updateIndexEntries(emptyDocumentMap);
        }
    }

    public MutableDocument get(DocumentKey documentKey) {
        return getAll(Collections.singletonList(documentKey)).get(documentKey);
    }

    public Map<DocumentKey, MutableDocument> getAll(Iterable<DocumentKey> iterable) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (DocumentKey next : iterable) {
            arrayList.add(EncodedPath.encode(next.getPath()));
            hashMap.put(next, MutableDocument.newInvalidDocument(next));
        }
        SQLitePersistence.LongQuery longQuery = new SQLitePersistence.LongQuery(this.db, "SELECT contents, read_time_seconds, read_time_nanos, document_type, path FROM remote_documents WHERE path IN (", arrayList, ") ORDER BY path");
        BackgroundQueue backgroundQueue = new BackgroundQueue();
        while (longQuery.hasMoreSubqueries()) {
            longQuery.performNextSubquery().forEach(new SQLiteRemoteDocumentCache$$ExternalSyntheticLambda2(this, backgroundQueue, hashMap));
        }
        backgroundQueue.drain();
        this.documentTypeBackfiller.backfill(this.db);
        synchronized (hashMap) {
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getAll$0$com-google-firebase-firestore-local-SQLiteRemoteDocumentCache  reason: not valid java name */
    public /* synthetic */ void m450lambda$getAll$0$comgooglefirebasefirestorelocalSQLiteRemoteDocumentCache(BackgroundQueue backgroundQueue, Map map, Cursor cursor) {
        processRowInBackground(backgroundQueue, map, cursor, (Function<MutableDocument, Boolean>) null);
    }

    public Map<DocumentKey, MutableDocument> getAll(String str, FieldIndex.IndexOffset indexOffset, int i) {
        List<ResourcePath> collectionParents = this.indexManager.getCollectionParents(str);
        ArrayList arrayList = new ArrayList(collectionParents.size());
        for (ResourcePath append : collectionParents) {
            arrayList.add((ResourcePath) append.append(str));
        }
        if (arrayList.isEmpty()) {
            return Collections.emptyMap();
        }
        if (arrayList.size() * 9 < 900) {
            return getAll(arrayList, indexOffset, i, (Function<MutableDocument, Boolean>) null);
        }
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int i3 = i2 + 100;
            hashMap.putAll(getAll(arrayList.subList(i2, Math.min(arrayList.size(), i3)), indexOffset, i, (Function<MutableDocument, Boolean>) null));
            i2 = i3;
        }
        return Util.firstNEntries(hashMap, i, FieldIndex.IndexOffset.DOCUMENT_COMPARATOR);
    }

    private Map<DocumentKey, MutableDocument> getAll(List<ResourcePath> list, FieldIndex.IndexOffset indexOffset, int i, @Nullable DocumentType documentType, @Nullable Function<MutableDocument, Boolean> function, @Nullable QueryContext queryContext) {
        String str;
        DocumentType documentType2 = documentType;
        Timestamp timestamp = indexOffset.getReadTime().getTimestamp();
        DocumentKey documentKey = indexOffset.getDocumentKey();
        StringBuilder sb = new StringBuilder("SELECT contents, read_time_seconds, read_time_nanos, document_type, path FROM remote_documents WHERE path >= ? AND path < ? AND path_length = ? ");
        if (documentType2 == null) {
            str = "";
        } else {
            str = " AND (document_type IS NULL OR document_type = ?) ";
        }
        StringBuilder repeatSequence = Util.repeatSequence(sb.append(str).append("AND (read_time_seconds > ? OR ( read_time_seconds = ? AND read_time_nanos > ?) OR ( read_time_seconds = ? AND read_time_nanos = ? and path > ?)) ").toString(), list.size(), " UNION ");
        repeatSequence.append("ORDER BY read_time_seconds, read_time_nanos, path LIMIT ?");
        int i2 = 0;
        Object[] objArr = new Object[((((documentType2 != null ? 1 : 0) + 9) * list.size()) + 1)];
        for (ResourcePath next : list) {
            String encode = EncodedPath.encode(next);
            objArr[i2] = encode;
            objArr[i2 + 1] = EncodedPath.prefixSuccessor(encode);
            int i3 = i2 + 3;
            objArr[i2 + 2] = Integer.valueOf(next.length() + 1);
            if (documentType2 != null) {
                objArr[i3] = Integer.valueOf(documentType2.dbValue);
                i3 = i2 + 4;
            }
            objArr[i3] = Long.valueOf(timestamp.getSeconds());
            objArr[i3 + 1] = Long.valueOf(timestamp.getSeconds());
            objArr[i3 + 2] = Integer.valueOf(timestamp.getNanoseconds());
            objArr[i3 + 3] = Long.valueOf(timestamp.getSeconds());
            objArr[i3 + 4] = Integer.valueOf(timestamp.getNanoseconds());
            objArr[i3 + 5] = EncodedPath.encode(documentKey.getPath());
            i2 = i3 + 6;
        }
        objArr[i2] = Integer.valueOf(i);
        BackgroundQueue backgroundQueue = new BackgroundQueue();
        HashMap hashMap = new HashMap();
        this.db.query(repeatSequence.toString()).binding(objArr).forEach(new SQLiteRemoteDocumentCache$$ExternalSyntheticLambda1(this, backgroundQueue, hashMap, function, queryContext));
        backgroundQueue.drain();
        this.documentTypeBackfiller.backfill(this.db);
        synchronized (hashMap) {
            try {
            } catch (Throwable th) {
                throw th;
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getAll$1$com-google-firebase-firestore-local-SQLiteRemoteDocumentCache  reason: not valid java name */
    public /* synthetic */ void m451lambda$getAll$1$comgooglefirebasefirestorelocalSQLiteRemoteDocumentCache(BackgroundQueue backgroundQueue, Map map, Function function, QueryContext queryContext, Cursor cursor) {
        processRowInBackground(backgroundQueue, map, cursor, function);
        if (queryContext != null) {
            queryContext.incrementDocumentReadCount();
        }
    }

    private Map<DocumentKey, MutableDocument> getAll(List<ResourcePath> list, FieldIndex.IndexOffset indexOffset, int i, @Nullable Function<MutableDocument, Boolean> function) {
        return getAll(list, indexOffset, i, (DocumentType) null, function, (QueryContext) null);
    }

    private void processRowInBackground(BackgroundQueue backgroundQueue, Map<DocumentKey, MutableDocument> map, Cursor cursor, @Nullable Function<MutableDocument, Boolean> function) {
        SQLiteRemoteDocumentCache$$ExternalSyntheticLambda0 sQLiteRemoteDocumentCache$$ExternalSyntheticLambda0 = new SQLiteRemoteDocumentCache$$ExternalSyntheticLambda0(this, cursor.getBlob(0), cursor.getInt(1), cursor.getInt(2), cursor.isNull(3), cursor.getString(4), function, map);
        if (!cursor.isFirst() || !cursor.isLast()) {
            backgroundQueue.submit(sQLiteRemoteDocumentCache$$ExternalSyntheticLambda0);
        } else {
            sQLiteRemoteDocumentCache$$ExternalSyntheticLambda0.run();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$processRowInBackground$2$com-google-firebase-firestore-local-SQLiteRemoteDocumentCache  reason: not valid java name */
    public /* synthetic */ void m452lambda$processRowInBackground$2$comgooglefirebasefirestorelocalSQLiteRemoteDocumentCache(byte[] bArr, int i, int i2, boolean z, String str, Function function, Map map) {
        MutableDocument decodeMaybeDocument = decodeMaybeDocument(bArr, i, i2);
        if (z) {
            this.documentTypeBackfiller.enqueue(str, i, i2, decodeMaybeDocument);
        }
        if (function == null || ((Boolean) function.apply(decodeMaybeDocument)).booleanValue()) {
            synchronized (map) {
                map.put(decodeMaybeDocument.getKey(), decodeMaybeDocument);
            }
        }
    }

    public Map<DocumentKey, MutableDocument> getDocumentsMatchingQuery(Query query, FieldIndex.IndexOffset indexOffset, @Nonnull Set<DocumentKey> set) {
        return getDocumentsMatchingQuery(query, indexOffset, set, (QueryContext) null);
    }

    public Map<DocumentKey, MutableDocument> getDocumentsMatchingQuery(Query query, FieldIndex.IndexOffset indexOffset, @Nonnull Set<DocumentKey> set, @Nullable QueryContext queryContext) {
        return getAll(Collections.singletonList(query.getPath()), indexOffset, Integer.MAX_VALUE, DocumentType.FOUND_DOCUMENT, new SQLiteRemoteDocumentCache$$ExternalSyntheticLambda3(query, set), queryContext);
    }

    static /* synthetic */ Boolean lambda$getDocumentsMatchingQuery$3(Query query, Set set, MutableDocument mutableDocument) {
        return Boolean.valueOf(query.matches(mutableDocument) || set.contains(mutableDocument.getKey()));
    }

    private MutableDocument decodeMaybeDocument(byte[] bArr, int i, int i2) {
        try {
            return this.serializer.decodeMaybeDocument(MaybeDocument.parseFrom(bArr)).setReadTime(new SnapshotVersion(new Timestamp((long) i, i2)));
        } catch (InvalidProtocolBufferException e) {
            throw Assert.fail("MaybeDocument failed to parse: %s", e);
        }
    }

    private static class DocumentTypeBackfiller {
        private final ConcurrentHashMap<BackfillKey, DocumentType> documentTypeByBackfillKey;

        private DocumentTypeBackfiller() {
            this.documentTypeByBackfillKey = new ConcurrentHashMap<>();
        }

        /* access modifiers changed from: package-private */
        public void enqueue(String str, int i, int i2, MutableDocument mutableDocument) {
            this.documentTypeByBackfillKey.putIfAbsent(new BackfillKey(str, i, i2), DocumentType.forMutableDocument(mutableDocument));
        }

        /* access modifiers changed from: package-private */
        public void backfill(SQLitePersistence sQLitePersistence) {
            while (true) {
                BackfillSqlInfo calculateBackfillSql = calculateBackfillSql();
                if (calculateBackfillSql != null) {
                    sQLitePersistence.execute(calculateBackfillSql.sql, calculateBackfillSql.bindings);
                } else {
                    return;
                }
            }
        }

        private static class BackfillSqlInfo {
            final Object[] bindings;
            final int numDocumentsAffected;
            final String sql;

            BackfillSqlInfo(String str, Object[] objArr, int i) {
                this.sql = str;
                this.bindings = objArr;
                this.numDocumentsAffected = i;
            }
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public BackfillSqlInfo calculateBackfillSql() {
            if (this.documentTypeByBackfillKey.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            Iterator<BackfillKey> it = this.documentTypeByBackfillKey.keySet().iterator();
            int i = 0;
            while (it.hasNext() && arrayList.size() < 900) {
                BackfillKey next = it.next();
                DocumentType remove = this.documentTypeByBackfillKey.remove(next);
                if (remove != null) {
                    i++;
                    arrayList.add(next.path);
                    int size = arrayList.size();
                    arrayList.add(Integer.valueOf(next.readTimeSeconds));
                    int size2 = arrayList.size();
                    arrayList.add(Integer.valueOf(next.readTimeNanos));
                    int size3 = arrayList.size();
                    arrayList.add(Integer.valueOf(remove.dbValue));
                    sb.append(" WHEN path=?").append(size).append(" AND read_time_seconds=?").append(size2).append(" AND read_time_nanos=?").append(size3).append(" THEN ?").append(arrayList.size());
                    if (sb2.length() > 0) {
                        sb2.append(" OR");
                    }
                    sb2.append(" (path=?").append(size).append(" AND read_time_seconds=?").append(size2).append(" AND read_time_nanos=?").append(size3).append(')');
                }
            }
            if (i == 0) {
                return null;
            }
            return new BackfillSqlInfo("UPDATE remote_documents SET document_type = CASE" + sb + " ELSE NULL END WHERE" + sb2, arrayList.toArray(), i);
        }

        private static class BackfillKey {
            final String path;
            final int readTimeNanos;
            final int readTimeSeconds;

            BackfillKey(String str, int i, int i2) {
                this.path = str;
                this.readTimeSeconds = i;
                this.readTimeNanos = i2;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof BackfillKey)) {
                    return false;
                }
                BackfillKey backfillKey = (BackfillKey) obj;
                return this.readTimeSeconds == backfillKey.readTimeSeconds && this.readTimeNanos == backfillKey.readTimeNanos && Objects.equals(this.path, backfillKey.path);
            }

            public int hashCode() {
                return Objects.hash(new Object[]{this.path, Integer.valueOf(this.readTimeSeconds), Integer.valueOf(this.readTimeNanos)});
            }

            public String toString() {
                return "DocumentTypeBackfiller.BackfillKey(path=" + this.path + ", readTimeSeconds=" + this.readTimeSeconds + ", readTimeNanos=" + this.readTimeNanos + ")";
            }
        }
    }
}
