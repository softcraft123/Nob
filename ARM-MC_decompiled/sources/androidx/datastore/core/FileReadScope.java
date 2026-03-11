package androidx.datastore.core;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0004J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0011\u001a\u00028\u0000H@¢\u0006\u0002\u0010\u0012R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Landroidx/datastore/core/FileReadScope;", "T", "Landroidx/datastore/core/ReadScope;", "file", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "(Ljava/io/File;Landroidx/datastore/core/Serializer;)V", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getFile", "()Ljava/io/File;", "getSerializer", "()Landroidx/datastore/core/Serializer;", "checkNotClosed", "", "close", "readData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FileStorage.kt */
public class FileReadScope<T> implements ReadScope<T> {
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final File file;
    private final Serializer<T> serializer;

    public Object readData(Continuation<? super T> continuation) {
        return readData$suspendImpl(this, continuation);
    }

    public FileReadScope(File file2, Serializer<T> serializer2) {
        Intrinsics.checkNotNullParameter(file2, "file");
        Intrinsics.checkNotNullParameter(serializer2, "serializer");
        this.file = file2;
        this.serializer = serializer2;
    }

    /* access modifiers changed from: protected */
    public final File getFile() {
        return this.file;
    }

    /* access modifiers changed from: protected */
    public final Serializer<T> getSerializer() {
        return this.serializer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0077, code lost:
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0083, code lost:
        throw r4;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:28:0x0073, B:35:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T> java.lang.Object readData$suspendImpl(androidx.datastore.core.FileReadScope<T> r8, kotlin.coroutines.Continuation<? super T> r9) {
        /*
            boolean r0 = r9 instanceof androidx.datastore.core.FileReadScope$readData$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            androidx.datastore.core.FileReadScope$readData$1 r0 = (androidx.datastore.core.FileReadScope$readData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.FileReadScope$readData$1 r0 = new androidx.datastore.core.FileReadScope$readData$1
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
            goto L_0x00ac
        L_0x0033:
            r9 = move-exception
            goto L_0x00b4
        L_0x0036:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003e:
            java.lang.Object r8 = r0.L$1
            java.io.Closeable r8 = (java.io.Closeable) r8
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.FileReadScope r2 = (androidx.datastore.core.FileReadScope) r2
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x004a }
            goto L_0x0073
        L_0x004a:
            r9 = move-exception
            goto L_0x007e
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r9)
            r8.checkNotClosed()
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0084 }
            java.io.File r2 = r8.file     // Catch:{ FileNotFoundException -> 0x0084 }
            r9.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0084 }
            java.io.Closeable r9 = (java.io.Closeable) r9     // Catch:{ FileNotFoundException -> 0x0084 }
            r2 = r9
            java.io.FileInputStream r2 = (java.io.FileInputStream) r2     // Catch:{ all -> 0x0079 }
            androidx.datastore.core.Serializer<T> r6 = r8.serializer     // Catch:{ all -> 0x0079 }
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x0079 }
            r0.L$0 = r8     // Catch:{ all -> 0x0079 }
            r0.L$1 = r9     // Catch:{ all -> 0x0079 }
            r0.label = r4     // Catch:{ all -> 0x0079 }
            java.lang.Object r2 = r6.readFrom(r2, r0)     // Catch:{ all -> 0x0079 }
            if (r2 != r1) goto L_0x006f
            goto L_0x00a8
        L_0x006f:
            r7 = r2
            r2 = r8
            r8 = r9
            r9 = r7
        L_0x0073:
            kotlin.io.CloseableKt.closeFinally(r8, r5)     // Catch:{ FileNotFoundException -> 0x0077 }
            return r9
        L_0x0077:
            r8 = r2
            goto L_0x0084
        L_0x0079:
            r2 = move-exception
            r7 = r2
            r2 = r8
            r8 = r9
            r9 = r7
        L_0x007e:
            throw r9     // Catch:{ all -> 0x007f }
        L_0x007f:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r9)     // Catch:{ FileNotFoundException -> 0x0077 }
            throw r4     // Catch:{ FileNotFoundException -> 0x0077 }
        L_0x0084:
            java.io.File r9 = r8.file
            boolean r9 = r9.exists()
            if (r9 == 0) goto L_0x00ba
            java.io.FileInputStream r9 = new java.io.FileInputStream
            java.io.File r2 = r8.file
            r9.<init>(r2)
            java.io.Closeable r9 = (java.io.Closeable) r9
            r2 = r9
            java.io.FileInputStream r2 = (java.io.FileInputStream) r2     // Catch:{ all -> 0x00b0 }
            androidx.datastore.core.Serializer<T> r8 = r8.serializer     // Catch:{ all -> 0x00b0 }
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x00b0 }
            r0.L$0 = r9     // Catch:{ all -> 0x00b0 }
            r0.L$1 = r5     // Catch:{ all -> 0x00b0 }
            r0.label = r3     // Catch:{ all -> 0x00b0 }
            java.lang.Object r8 = r8.readFrom(r2, r0)     // Catch:{ all -> 0x00b0 }
            if (r8 != r1) goto L_0x00a9
        L_0x00a8:
            return r1
        L_0x00a9:
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x00ac:
            kotlin.io.CloseableKt.closeFinally(r8, r5)
            return r9
        L_0x00b0:
            r8 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x00b4:
            throw r9     // Catch:{ all -> 0x00b5 }
        L_0x00b5:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r9)
            throw r0
        L_0x00ba:
            androidx.datastore.core.Serializer<T> r8 = r8.serializer
            java.lang.Object r8 = r8.getDefaultValue()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileReadScope.readData$suspendImpl(androidx.datastore.core.FileReadScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void close() {
        this.closed.set(true);
    }

    /* access modifiers changed from: protected */
    public final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.".toString());
        }
    }
}
