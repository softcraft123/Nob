package com.google.firebase.firestore.core;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.LimboDocumentChange;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.DocumentSet;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class View {
    private boolean current;
    private DocumentSet documentSet;
    private ImmutableSortedSet<DocumentKey> limboDocuments;
    private ImmutableSortedSet<DocumentKey> mutatedKeys;
    private final Query query;
    private ViewSnapshot.SyncState syncState = ViewSnapshot.SyncState.NONE;
    private ImmutableSortedSet<DocumentKey> syncedDocuments;

    public static class DocumentChanges {
        final DocumentViewChangeSet changeSet;
        final DocumentSet documentSet;
        final ImmutableSortedSet<DocumentKey> mutatedKeys;
        /* access modifiers changed from: private */
        public final boolean needsRefill;

        /* synthetic */ DocumentChanges(DocumentSet documentSet2, DocumentViewChangeSet documentViewChangeSet, ImmutableSortedSet immutableSortedSet, boolean z, AnonymousClass1 r5) {
            this(documentSet2, documentViewChangeSet, immutableSortedSet, z);
        }

        private DocumentChanges(DocumentSet documentSet2, DocumentViewChangeSet documentViewChangeSet, ImmutableSortedSet<DocumentKey> immutableSortedSet, boolean z) {
            this.documentSet = documentSet2;
            this.changeSet = documentViewChangeSet;
            this.mutatedKeys = immutableSortedSet;
            this.needsRefill = z;
        }

        public boolean needsRefill() {
            return this.needsRefill;
        }
    }

    public View(Query query2, ImmutableSortedSet<DocumentKey> immutableSortedSet) {
        this.query = query2;
        this.documentSet = DocumentSet.emptySet(query2.comparator());
        this.syncedDocuments = immutableSortedSet;
        this.limboDocuments = DocumentKey.emptyKeySet();
        this.mutatedKeys = DocumentKey.emptyKeySet();
    }

    public ViewSnapshot.SyncState getSyncState() {
        return this.syncState;
    }

    public DocumentChanges computeDocChanges(ImmutableSortedMap<DocumentKey, Document> immutableSortedMap) {
        return computeDocChanges(immutableSortedMap, (DocumentChanges) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f4, code lost:
        if (r8.compare(r10, r4) > 0) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fc, code lost:
        if (r8.compare(r10, r7) < 0) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012b, code lost:
        if (r7 == null) goto L_0x011a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0159 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.firestore.core.View.DocumentChanges computeDocChanges(com.google.firebase.database.collection.ImmutableSortedMap<com.google.firebase.firestore.model.DocumentKey, com.google.firebase.firestore.model.Document> r18, com.google.firebase.firestore.core.View.DocumentChanges r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            if (r1 == 0) goto L_0x0009
            com.google.firebase.firestore.core.DocumentViewChangeSet r2 = r1.changeSet
            goto L_0x000e
        L_0x0009:
            com.google.firebase.firestore.core.DocumentViewChangeSet r2 = new com.google.firebase.firestore.core.DocumentViewChangeSet
            r2.<init>()
        L_0x000e:
            r5 = r2
            if (r1 == 0) goto L_0x0014
            com.google.firebase.firestore.model.DocumentSet r2 = r1.documentSet
            goto L_0x0016
        L_0x0014:
            com.google.firebase.firestore.model.DocumentSet r2 = r0.documentSet
        L_0x0016:
            if (r1 == 0) goto L_0x001b
            com.google.firebase.database.collection.ImmutableSortedSet<com.google.firebase.firestore.model.DocumentKey> r3 = r1.mutatedKeys
            goto L_0x001d
        L_0x001b:
            com.google.firebase.database.collection.ImmutableSortedSet<com.google.firebase.firestore.model.DocumentKey> r3 = r0.mutatedKeys
        L_0x001d:
            com.google.firebase.firestore.core.Query r4 = r0.query
            com.google.firebase.firestore.core.Query$LimitType r4 = r4.getLimitType()
            com.google.firebase.firestore.core.Query$LimitType r6 = com.google.firebase.firestore.core.Query.LimitType.LIMIT_TO_FIRST
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x003f
            int r4 = r2.size()
            long r7 = (long) r4
            com.google.firebase.firestore.core.Query r4 = r0.query
            long r9 = r4.getLimit()
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 != 0) goto L_0x003f
            com.google.firebase.firestore.model.Document r4 = r2.getLastDocument()
            goto L_0x0040
        L_0x003f:
            r4 = 0
        L_0x0040:
            com.google.firebase.firestore.core.Query r7 = r0.query
            com.google.firebase.firestore.core.Query$LimitType r7 = r7.getLimitType()
            com.google.firebase.firestore.core.Query$LimitType r8 = com.google.firebase.firestore.core.Query.LimitType.LIMIT_TO_LAST
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0062
            int r7 = r2.size()
            long r7 = (long) r7
            com.google.firebase.firestore.core.Query r9 = r0.query
            long r9 = r9.getLimit()
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x0062
            com.google.firebase.firestore.model.Document r7 = r2.getFirstDocument()
            goto L_0x0063
        L_0x0062:
            r7 = 0
        L_0x0063:
            com.google.firebase.firestore.core.Query r8 = r0.query
            java.util.Comparator r8 = r8.comparator()
            java.util.Iterator r9 = r18.iterator()
            r11 = r2
            r12 = 0
        L_0x006f:
            boolean r13 = r9.hasNext()
            if (r13 == 0) goto L_0x015f
            java.lang.Object r13 = r9.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            java.lang.Object r15 = r13.getKey()
            com.google.firebase.firestore.model.DocumentKey r15 = (com.google.firebase.firestore.model.DocumentKey) r15
            com.google.firebase.firestore.model.Document r6 = r2.getDocument(r15)
            com.google.firebase.firestore.core.Query r14 = r0.query
            java.lang.Object r16 = r13.getValue()
            r10 = r16
            com.google.firebase.firestore.model.Document r10 = (com.google.firebase.firestore.model.Document) r10
            boolean r10 = r14.matches(r10)
            if (r10 == 0) goto L_0x009c
            java.lang.Object r10 = r13.getValue()
            com.google.firebase.firestore.model.Document r10 = (com.google.firebase.firestore.model.Document) r10
            goto L_0x009d
        L_0x009c:
            r10 = 0
        L_0x009d:
            if (r6 == 0) goto L_0x00ad
            com.google.firebase.database.collection.ImmutableSortedSet<com.google.firebase.firestore.model.DocumentKey> r13 = r0.mutatedKeys
            com.google.firebase.firestore.model.DocumentKey r14 = r6.getKey()
            boolean r13 = r13.contains(r14)
            if (r13 == 0) goto L_0x00ad
            r13 = 1
            goto L_0x00ae
        L_0x00ad:
            r13 = 0
        L_0x00ae:
            if (r10 == 0) goto L_0x00ca
            boolean r14 = r10.hasLocalMutations()
            if (r14 != 0) goto L_0x00c8
            com.google.firebase.database.collection.ImmutableSortedSet<com.google.firebase.firestore.model.DocumentKey> r14 = r0.mutatedKeys
            com.google.firebase.firestore.model.DocumentKey r1 = r10.getKey()
            boolean r1 = r14.contains(r1)
            if (r1 == 0) goto L_0x00ca
            boolean r1 = r10.hasCommittedMutations()
            if (r1 == 0) goto L_0x00ca
        L_0x00c8:
            r1 = 1
            goto L_0x00cb
        L_0x00ca:
            r1 = 0
        L_0x00cb:
            if (r6 == 0) goto L_0x010b
            if (r10 == 0) goto L_0x010b
            com.google.firebase.firestore.model.ObjectValue r14 = r6.getData()
            r16 = r2
            com.google.firebase.firestore.model.ObjectValue r2 = r10.getData()
            boolean r2 = r14.equals(r2)
            if (r2 != 0) goto L_0x00ff
            boolean r1 = r0.shouldWaitForSyncedDocument(r6, r10)
            if (r1 != 0) goto L_0x012f
            com.google.firebase.firestore.core.DocumentViewChange$Type r1 = com.google.firebase.firestore.core.DocumentViewChange.Type.MODIFIED
            com.google.firebase.firestore.core.DocumentViewChange r1 = com.google.firebase.firestore.core.DocumentViewChange.create(r1, r10)
            r5.addChange(r1)
            if (r4 == 0) goto L_0x00f6
            int r1 = r8.compare(r10, r4)
            if (r1 > 0) goto L_0x012d
        L_0x00f6:
            if (r7 == 0) goto L_0x011a
            int r1 = r8.compare(r10, r7)
            if (r1 >= 0) goto L_0x011a
            goto L_0x012d
        L_0x00ff:
            if (r13 == r1) goto L_0x012f
            com.google.firebase.firestore.core.DocumentViewChange$Type r1 = com.google.firebase.firestore.core.DocumentViewChange.Type.METADATA
            com.google.firebase.firestore.core.DocumentViewChange r1 = com.google.firebase.firestore.core.DocumentViewChange.create(r1, r10)
            r5.addChange(r1)
            goto L_0x011a
        L_0x010b:
            r16 = r2
            if (r6 != 0) goto L_0x011c
            if (r10 == 0) goto L_0x011c
            com.google.firebase.firestore.core.DocumentViewChange$Type r1 = com.google.firebase.firestore.core.DocumentViewChange.Type.ADDED
            com.google.firebase.firestore.core.DocumentViewChange r1 = com.google.firebase.firestore.core.DocumentViewChange.create(r1, r10)
            r5.addChange(r1)
        L_0x011a:
            r14 = 1
            goto L_0x0130
        L_0x011c:
            if (r6 == 0) goto L_0x012f
            if (r10 != 0) goto L_0x012f
            com.google.firebase.firestore.core.DocumentViewChange$Type r1 = com.google.firebase.firestore.core.DocumentViewChange.Type.REMOVED
            com.google.firebase.firestore.core.DocumentViewChange r1 = com.google.firebase.firestore.core.DocumentViewChange.create(r1, r6)
            r5.addChange(r1)
            if (r4 != 0) goto L_0x012d
            if (r7 == 0) goto L_0x011a
        L_0x012d:
            r12 = 1
            goto L_0x011a
        L_0x012f:
            r14 = 0
        L_0x0130:
            if (r14 == 0) goto L_0x0159
            if (r10 == 0) goto L_0x0150
            com.google.firebase.firestore.model.DocumentSet r11 = r11.add(r10)
            boolean r1 = r10.hasLocalMutations()
            if (r1 == 0) goto L_0x0147
            com.google.firebase.firestore.model.DocumentKey r1 = r10.getKey()
            com.google.firebase.database.collection.ImmutableSortedSet r1 = r3.insert(r1)
            goto L_0x0158
        L_0x0147:
            com.google.firebase.firestore.model.DocumentKey r1 = r10.getKey()
            com.google.firebase.database.collection.ImmutableSortedSet r1 = r3.remove(r1)
            goto L_0x0158
        L_0x0150:
            com.google.firebase.firestore.model.DocumentSet r11 = r11.remove(r15)
            com.google.firebase.database.collection.ImmutableSortedSet r1 = r3.remove(r15)
        L_0x0158:
            r3 = r1
        L_0x0159:
            r1 = r19
            r2 = r16
            goto L_0x006f
        L_0x015f:
            com.google.firebase.firestore.core.Query r1 = r0.query
            boolean r1 = r1.hasLimit()
            if (r1 == 0) goto L_0x01ac
            int r1 = r11.size()
            long r1 = (long) r1
            com.google.firebase.firestore.core.Query r4 = r0.query
            long r6 = r4.getLimit()
        L_0x0172:
            long r1 = r1 - r6
            r6 = 0
            int r4 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x01ac
            com.google.firebase.firestore.core.Query r4 = r0.query
            com.google.firebase.firestore.core.Query$LimitType r4 = r4.getLimitType()
            com.google.firebase.firestore.core.Query$LimitType r6 = com.google.firebase.firestore.core.Query.LimitType.LIMIT_TO_FIRST
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x018c
            com.google.firebase.firestore.model.Document r4 = r11.getLastDocument()
            goto L_0x0190
        L_0x018c:
            com.google.firebase.firestore.model.Document r4 = r11.getFirstDocument()
        L_0x0190:
            com.google.firebase.firestore.model.DocumentKey r6 = r4.getKey()
            com.google.firebase.firestore.model.DocumentSet r11 = r11.remove(r6)
            com.google.firebase.firestore.model.DocumentKey r6 = r4.getKey()
            com.google.firebase.database.collection.ImmutableSortedSet r3 = r3.remove(r6)
            com.google.firebase.firestore.core.DocumentViewChange$Type r6 = com.google.firebase.firestore.core.DocumentViewChange.Type.REMOVED
            com.google.firebase.firestore.core.DocumentViewChange r4 = com.google.firebase.firestore.core.DocumentViewChange.create(r6, r4)
            r5.addChange(r4)
            r6 = 1
            goto L_0x0172
        L_0x01ac:
            r6 = r3
            r4 = r11
            if (r12 == 0) goto L_0x01b5
            if (r19 != 0) goto L_0x01b3
            goto L_0x01b5
        L_0x01b3:
            r14 = 0
            goto L_0x01b6
        L_0x01b5:
            r14 = 1
        L_0x01b6:
            java.lang.String r1 = "View was refilled using docs that themselves needed refilling."
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.google.firebase.firestore.util.Assert.hardAssert(r14, r1, r2)
            com.google.firebase.firestore.core.View$DocumentChanges r3 = new com.google.firebase.firestore.core.View$DocumentChanges
            r8 = 0
            r7 = r12
            r3.<init>(r4, r5, r6, r7, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.core.View.computeDocChanges(com.google.firebase.database.collection.ImmutableSortedMap, com.google.firebase.firestore.core.View$DocumentChanges):com.google.firebase.firestore.core.View$DocumentChanges");
    }

    private boolean shouldWaitForSyncedDocument(Document document, Document document2) {
        return document.hasLocalMutations() && document2.hasCommittedMutations() && !document2.hasLocalMutations();
    }

    public ViewChange applyChanges(DocumentChanges documentChanges) {
        return applyChanges(documentChanges, (TargetChange) null);
    }

    public ViewChange applyChanges(DocumentChanges documentChanges, TargetChange targetChange) {
        return applyChanges(documentChanges, targetChange, false);
    }

    public ViewChange applyChanges(DocumentChanges documentChanges, TargetChange targetChange, boolean z) {
        ViewSnapshot viewSnapshot;
        boolean z2;
        DocumentChanges documentChanges2 = documentChanges;
        TargetChange targetChange2 = targetChange;
        Assert.hardAssert(!documentChanges2.needsRefill, "Cannot apply changes that need a refill", new Object[0]);
        DocumentSet documentSet2 = this.documentSet;
        this.documentSet = documentChanges2.documentSet;
        this.mutatedKeys = documentChanges2.mutatedKeys;
        List<DocumentViewChange> changes = documentChanges2.changeSet.getChanges();
        Collections.sort(changes, new View$$ExternalSyntheticLambda0(this.query.comparator()));
        applyTargetChange(targetChange2);
        List<LimboDocumentChange> emptyList = z ? Collections.emptyList() : updateLimboDocuments();
        ViewSnapshot.SyncState syncState2 = (this.limboDocuments.size() != 0 || !this.current || z) ? ViewSnapshot.SyncState.LOCAL : ViewSnapshot.SyncState.SYNCED;
        boolean z3 = syncState2 != this.syncState;
        this.syncState = syncState2;
        if (changes.size() != 0 || z3) {
            boolean z4 = syncState2 == ViewSnapshot.SyncState.LOCAL;
            if (targetChange2 != null && !targetChange2.getResumeToken().isEmpty()) {
                z2 = true;
            } else {
                z2 = false;
            }
            viewSnapshot = new ViewSnapshot(this.query, documentChanges2.documentSet, documentSet2, changes, z4, documentChanges2.mutatedKeys, z3, false, z2);
        } else {
            viewSnapshot = null;
        }
        return new ViewChange(viewSnapshot, emptyList);
    }

    static /* synthetic */ int lambda$applyChanges$0(Comparator comparator, DocumentViewChange documentViewChange, DocumentViewChange documentViewChange2) {
        int compare = Integer.compare(changeTypeOrder(documentViewChange), changeTypeOrder(documentViewChange2));
        if (compare != 0) {
            return compare;
        }
        return comparator.compare(documentViewChange.getDocument(), documentViewChange2.getDocument());
    }

    public ViewChange applyOnlineStateChange(OnlineState onlineState) {
        if (!this.current || onlineState != OnlineState.OFFLINE) {
            return new ViewChange((ViewSnapshot) null, Collections.emptyList());
        }
        this.current = false;
        return applyChanges(new DocumentChanges(this.documentSet, new DocumentViewChangeSet(), this.mutatedKeys, false, (AnonymousClass1) null));
    }

    private void applyTargetChange(TargetChange targetChange) {
        if (targetChange != null) {
            Iterator<DocumentKey> it = targetChange.getAddedDocuments().iterator();
            while (it.hasNext()) {
                this.syncedDocuments = this.syncedDocuments.insert(it.next());
            }
            Iterator<DocumentKey> it2 = targetChange.getModifiedDocuments().iterator();
            while (it2.hasNext()) {
                DocumentKey next = it2.next();
                Assert.hardAssert(this.syncedDocuments.contains(next), "Modified document %s not found in view.", next);
            }
            Iterator<DocumentKey> it3 = targetChange.getRemovedDocuments().iterator();
            while (it3.hasNext()) {
                this.syncedDocuments = this.syncedDocuments.remove(it3.next());
            }
            this.current = targetChange.isCurrent();
        }
    }

    private List<LimboDocumentChange> updateLimboDocuments() {
        if (!this.current) {
            return Collections.emptyList();
        }
        ImmutableSortedSet<DocumentKey> immutableSortedSet = this.limboDocuments;
        this.limboDocuments = DocumentKey.emptyKeySet();
        Iterator<Document> it = this.documentSet.iterator();
        while (it.hasNext()) {
            Document next = it.next();
            if (shouldBeLimboDoc(next.getKey())) {
                this.limboDocuments = this.limboDocuments.insert(next.getKey());
            }
        }
        ArrayList arrayList = new ArrayList(immutableSortedSet.size() + this.limboDocuments.size());
        Iterator<DocumentKey> it2 = immutableSortedSet.iterator();
        while (it2.hasNext()) {
            DocumentKey next2 = it2.next();
            if (!this.limboDocuments.contains(next2)) {
                arrayList.add(new LimboDocumentChange(LimboDocumentChange.Type.REMOVED, next2));
            }
        }
        Iterator<DocumentKey> it3 = this.limboDocuments.iterator();
        while (it3.hasNext()) {
            DocumentKey next3 = it3.next();
            if (!immutableSortedSet.contains(next3)) {
                arrayList.add(new LimboDocumentChange(LimboDocumentChange.Type.ADDED, next3));
            }
        }
        return arrayList;
    }

    private boolean shouldBeLimboDoc(DocumentKey documentKey) {
        Document document;
        if (!this.syncedDocuments.contains(documentKey) && (document = this.documentSet.getDocument(documentKey)) != null && !document.hasLocalMutations()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet<DocumentKey> getLimboDocuments() {
        return this.limboDocuments;
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet<DocumentKey> getSyncedDocuments() {
        return this.syncedDocuments;
    }

    /* renamed from: com.google.firebase.firestore.core.View$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.firebase.firestore.core.DocumentViewChange$Type[] r0 = com.google.firebase.firestore.core.DocumentViewChange.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type = r0
                com.google.firebase.firestore.core.DocumentViewChange$Type r1 = com.google.firebase.firestore.core.DocumentViewChange.Type.ADDED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.firebase.firestore.core.DocumentViewChange$Type r1 = com.google.firebase.firestore.core.DocumentViewChange.Type.MODIFIED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.firebase.firestore.core.DocumentViewChange$Type r1 = com.google.firebase.firestore.core.DocumentViewChange.Type.METADATA     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.firebase.firestore.core.DocumentViewChange$Type r1 = com.google.firebase.firestore.core.DocumentViewChange.Type.REMOVED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.core.View.AnonymousClass1.<clinit>():void");
        }
    }

    private static int changeTypeOrder(DocumentViewChange documentViewChange) {
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[documentViewChange.getType().ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (!(i == 2 || i == 3)) {
                if (i == 4) {
                    return 0;
                }
                throw new IllegalArgumentException("Unknown change type: " + documentViewChange.getType());
            }
        }
        return i2;
    }
}
