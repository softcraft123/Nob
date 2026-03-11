package androidx.datastore.core.okio;

import androidx.datastore.core.ReadScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okio.FileSystem;
import okio.Path;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0004J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0015\u001a\u00028\u0000H@¢\u0006\u0002\u0010\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Landroidx/datastore/core/okio/OkioReadScope;", "T", "Landroidx/datastore/core/ReadScope;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;)V", "closed", "Landroidx/datastore/core/okio/AtomicBoolean;", "getFileSystem", "()Lokio/FileSystem;", "getPath", "()Lokio/Path;", "getSerializer", "()Landroidx/datastore/core/okio/OkioSerializer;", "checkClose", "", "close", "readData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OkioStorage.kt */
public class OkioReadScope<T> implements ReadScope<T> {
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final FileSystem fileSystem;
    private final Path path;
    private final OkioSerializer<T> serializer;

    public Object readData(Continuation<? super T> continuation) {
        return readData$suspendImpl(this, continuation);
    }

    public OkioReadScope(FileSystem fileSystem2, Path path2, OkioSerializer<T> okioSerializer) {
        Intrinsics.checkNotNullParameter(fileSystem2, "fileSystem");
        Intrinsics.checkNotNullParameter(path2, "path");
        Intrinsics.checkNotNullParameter(okioSerializer, "serializer");
        this.fileSystem = fileSystem2;
        this.path = path2;
        this.serializer = okioSerializer;
    }

    /* access modifiers changed from: protected */
    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    /* access modifiers changed from: protected */
    public final Path getPath() {
        return this.path;
    }

    /* access modifiers changed from: protected */
    public final OkioSerializer<T> getSerializer() {
        return this.serializer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0079 A[SYNTHETIC, Splitter:B:29:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097 A[Catch:{ FileNotFoundException -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009b A[Catch:{ FileNotFoundException -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00cb A[SYNTHETIC, Splitter:B:57:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T> java.lang.Object readData$suspendImpl(androidx.datastore.core.okio.OkioReadScope<T> r8, kotlin.coroutines.Continuation<? super T> r9) {
        /*
            boolean r0 = r9 instanceof androidx.datastore.core.okio.OkioReadScope$readData$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            androidx.datastore.core.okio.OkioReadScope$readData$1 r0 = (androidx.datastore.core.okio.OkioReadScope$readData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.okio.OkioReadScope$readData$1 r0 = new androidx.datastore.core.okio.OkioReadScope$readData$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x004c
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r8 = r0.L$0
            java.io.Closeable r8 = (java.io.Closeable) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0033 }
            goto L_0x00c9
        L_0x0033:
            r9 = move-exception
            goto L_0x00d5
        L_0x0036:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003e:
            java.lang.Object r8 = r0.L$1
            java.io.Closeable r8 = (java.io.Closeable) r8
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.okio.OkioReadScope r2 = (androidx.datastore.core.okio.OkioReadScope) r2
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x004a }
            goto L_0x0077
        L_0x004a:
            r9 = move-exception
            goto L_0x0086
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r9)
            r8.checkClose()
            okio.FileSystem r9 = r8.fileSystem     // Catch:{ FileNotFoundException -> 0x009c }
            okio.Path r2 = r8.path     // Catch:{ FileNotFoundException -> 0x009c }
            okio.Source r9 = r9.source(r2)     // Catch:{ FileNotFoundException -> 0x009c }
            okio.BufferedSource r9 = okio.Okio.buffer((okio.Source) r9)     // Catch:{ FileNotFoundException -> 0x009c }
            java.io.Closeable r9 = (java.io.Closeable) r9     // Catch:{ FileNotFoundException -> 0x009c }
            r2 = r9
            okio.BufferedSource r2 = (okio.BufferedSource) r2     // Catch:{ all -> 0x0081 }
            androidx.datastore.core.okio.OkioSerializer<T> r6 = r8.serializer     // Catch:{ all -> 0x0081 }
            r0.L$0 = r8     // Catch:{ all -> 0x0081 }
            r0.L$1 = r9     // Catch:{ all -> 0x0081 }
            r0.label = r4     // Catch:{ all -> 0x0081 }
            java.lang.Object r2 = r6.readFrom(r2, r0)     // Catch:{ all -> 0x0081 }
            if (r2 != r1) goto L_0x0073
            goto L_0x00c5
        L_0x0073:
            r7 = r2
            r2 = r8
            r8 = r9
            r9 = r7
        L_0x0077:
            if (r8 == 0) goto L_0x007f
            r8.close()     // Catch:{ all -> 0x007d }
            goto L_0x007f
        L_0x007d:
            r8 = move-exception
            goto L_0x0095
        L_0x007f:
            r8 = r5
            goto L_0x0095
        L_0x0081:
            r2 = move-exception
            r7 = r2
            r2 = r8
            r8 = r9
            r9 = r7
        L_0x0086:
            if (r8 == 0) goto L_0x0093
            r8.close()     // Catch:{ all -> 0x008c }
            goto L_0x0093
        L_0x008c:
            r8 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r9, r8)     // Catch:{ FileNotFoundException -> 0x0091 }
            goto L_0x0093
        L_0x0091:
            r8 = r2
            goto L_0x009c
        L_0x0093:
            r8 = r9
            r9 = r5
        L_0x0095:
            if (r8 != 0) goto L_0x009b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch:{ FileNotFoundException -> 0x0091 }
            goto L_0x00f0
        L_0x009b:
            throw r8     // Catch:{ FileNotFoundException -> 0x0091 }
        L_0x009c:
            okio.FileSystem r9 = r8.fileSystem
            okio.Path r2 = r8.path
            boolean r9 = r9.exists(r2)
            if (r9 == 0) goto L_0x00e9
            okio.FileSystem r9 = r8.fileSystem
            okio.Path r2 = r8.path
            okio.Source r9 = r9.source(r2)
            okio.BufferedSource r9 = okio.Okio.buffer((okio.Source) r9)
            java.io.Closeable r9 = (java.io.Closeable) r9
            r2 = r9
            okio.BufferedSource r2 = (okio.BufferedSource) r2     // Catch:{ all -> 0x00d1 }
            androidx.datastore.core.okio.OkioSerializer<T> r8 = r8.serializer     // Catch:{ all -> 0x00d1 }
            r0.L$0 = r9     // Catch:{ all -> 0x00d1 }
            r0.L$1 = r5     // Catch:{ all -> 0x00d1 }
            r0.label = r3     // Catch:{ all -> 0x00d1 }
            java.lang.Object r8 = r8.readFrom(r2, r0)     // Catch:{ all -> 0x00d1 }
            if (r8 != r1) goto L_0x00c6
        L_0x00c5:
            return r1
        L_0x00c6:
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x00c9:
            if (r8 == 0) goto L_0x00e2
            r8.close()     // Catch:{ all -> 0x00cf }
            goto L_0x00e2
        L_0x00cf:
            r5 = move-exception
            goto L_0x00e2
        L_0x00d1:
            r8 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x00d5:
            if (r8 == 0) goto L_0x00df
            r8.close()     // Catch:{ all -> 0x00db }
            goto L_0x00df
        L_0x00db:
            r8 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r9, r8)
        L_0x00df:
            r7 = r5
            r5 = r9
            r9 = r7
        L_0x00e2:
            if (r5 != 0) goto L_0x00e8
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            goto L_0x00f0
        L_0x00e8:
            throw r5
        L_0x00e9:
            androidx.datastore.core.okio.OkioSerializer<T> r8 = r8.serializer
            java.lang.Object r8 = r8.getDefaultValue()
            r9 = r8
        L_0x00f0:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioReadScope.readData$suspendImpl(androidx.datastore.core.okio.OkioReadScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void close() {
        this.closed.set(true);
    }

    /* access modifiers changed from: protected */
    public final void checkClose() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.".toString());
        }
    }
}
