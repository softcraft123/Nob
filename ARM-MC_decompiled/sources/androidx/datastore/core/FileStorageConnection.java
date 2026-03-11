package androidx.datastore.core;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0016JX\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0001\u0010\u00162B\u0010\u0017\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0018¢\u0006\u0002\b H@¢\u0006\u0002\u0010!J=\u0010\"\u001a\u00020\u000b2-\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0#¢\u0006\u0002\b H@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020\u000b*\u00020\u0004H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/datastore/core/FileStorageConnection;", "T", "Landroidx/datastore/core/StorageConnection;", "file", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "onClose", "Lkotlin/Function0;", "", "(Ljava/io/File;Landroidx/datastore/core/Serializer;Landroidx/datastore/core/InterProcessCoordinator;Lkotlin/jvm/functions/Function0;)V", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "transactionMutex", "Lkotlinx/coroutines/sync/Mutex;", "checkNotClosed", "close", "readScope", "R", "block", "Lkotlin/Function3;", "Landroidx/datastore/core/ReadScope;", "", "Lkotlin/ParameterName;", "name", "locked", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeScope", "Lkotlin/Function2;", "Landroidx/datastore/core/WriteScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createParentDirectories", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FileStorage.kt */
public final class FileStorageConnection<T> implements StorageConnection<T> {
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final InterProcessCoordinator coordinator;
    private final File file;
    private final Function0<Unit> onClose;
    private final Serializer<T> serializer;
    private final Mutex transactionMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    public FileStorageConnection(File file2, Serializer<T> serializer2, InterProcessCoordinator interProcessCoordinator, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(file2, "file");
        Intrinsics.checkNotNullParameter(serializer2, "serializer");
        Intrinsics.checkNotNullParameter(interProcessCoordinator, "coordinator");
        Intrinsics.checkNotNullParameter(function0, "onClose");
        this.file = file2;
        this.serializer = serializer2;
        this.coordinator = interProcessCoordinator;
        this.onClose = function0;
    }

    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        kotlin.ExceptionsKt.addSuppressed(r9, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0091, code lost:
        r9 = th;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:32:0x0081, B:36:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0081 A[SYNTHETIC, Splitter:B:32:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <R> java.lang.Object readScope(kotlin.jvm.functions.Function3<? super androidx.datastore.core.ReadScope<T>, ? super java.lang.Boolean, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super R> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.datastore.core.FileStorageConnection$readScope$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            androidx.datastore.core.FileStorageConnection$readScope$1 r0 = (androidx.datastore.core.FileStorageConnection$readScope$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.FileStorageConnection$readScope$1 r0 = new androidx.datastore.core.FileStorageConnection$readScope$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            boolean r8 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            androidx.datastore.core.Closeable r1 = (androidx.datastore.core.Closeable) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.FileStorageConnection r0 = (androidx.datastore.core.FileStorageConnection) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0035 }
            goto L_0x0071
        L_0x0035:
            r9 = move-exception
            goto L_0x0088
        L_0x0037:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r9)
            r7.checkNotClosed()
            kotlinx.coroutines.sync.Mutex r9 = r7.transactionMutex
            boolean r9 = kotlinx.coroutines.sync.Mutex.DefaultImpls.tryLock$default(r9, r4, r3, r4)
            androidx.datastore.core.FileReadScope r2 = new androidx.datastore.core.FileReadScope     // Catch:{ all -> 0x0093 }
            java.io.File r5 = r7.file     // Catch:{ all -> 0x0093 }
            androidx.datastore.core.Serializer<T> r6 = r7.serializer     // Catch:{ all -> 0x0093 }
            r2.<init>(r5, r6)     // Catch:{ all -> 0x0093 }
            androidx.datastore.core.Closeable r2 = (androidx.datastore.core.Closeable) r2     // Catch:{ all -> 0x0093 }
            r5 = r2
            androidx.datastore.core.FileReadScope r5 = (androidx.datastore.core.FileReadScope) r5     // Catch:{ all -> 0x0082 }
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)     // Catch:{ all -> 0x0082 }
            r0.L$0 = r7     // Catch:{ all -> 0x0082 }
            r0.L$1 = r2     // Catch:{ all -> 0x0082 }
            r0.Z$0 = r9     // Catch:{ all -> 0x0082 }
            r0.label = r3     // Catch:{ all -> 0x0082 }
            java.lang.Object r8 = r8.invoke(r5, r6, r0)     // Catch:{ all -> 0x0082 }
            if (r8 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
            r1 = r2
        L_0x0071:
            r1.close()     // Catch:{ all -> 0x0076 }
            r1 = r4
            goto L_0x0077
        L_0x0076:
            r1 = move-exception
        L_0x0077:
            if (r1 != 0) goto L_0x0081
            if (r8 == 0) goto L_0x0080
            kotlinx.coroutines.sync.Mutex r8 = r0.transactionMutex
            kotlinx.coroutines.sync.Mutex.DefaultImpls.unlock$default(r8, r4, r3, r4)
        L_0x0080:
            return r9
        L_0x0081:
            throw r1     // Catch:{ all -> 0x0091 }
        L_0x0082:
            r8 = move-exception
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
            r1 = r2
        L_0x0088:
            r1.close()     // Catch:{ all -> 0x008c }
            goto L_0x0090
        L_0x008c:
            r1 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r9, r1)     // Catch:{ all -> 0x0091 }
        L_0x0090:
            throw r9     // Catch:{ all -> 0x0091 }
        L_0x0091:
            r9 = move-exception
            goto L_0x0098
        L_0x0093:
            r8 = move-exception
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
        L_0x0098:
            if (r8 == 0) goto L_0x009f
            kotlinx.coroutines.sync.Mutex r8 = r0.transactionMutex
            kotlinx.coroutines.sync.Mutex.DefaultImpls.unlock$default(r8, r4, r3, r4)
        L_0x009f:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileStorageConnection.readScope(kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c5 A[SYNTHETIC, Splitter:B:37:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0101 A[SYNTHETIC, Splitter:B:49:0x0101] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object writeScope(kotlin.jvm.functions.Function2<? super androidx.datastore.core.WriteScope<T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            java.lang.String r0 = "Unable to rename "
            boolean r1 = r12 instanceof androidx.datastore.core.FileStorageConnection$writeScope$1
            if (r1 == 0) goto L_0x0016
            r1 = r12
            androidx.datastore.core.FileStorageConnection$writeScope$1 r1 = (androidx.datastore.core.FileStorageConnection$writeScope$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r12 = r1.label
            int r12 = r12 - r3
            r1.label = r12
            goto L_0x001b
        L_0x0016:
            androidx.datastore.core.FileStorageConnection$writeScope$1 r1 = new androidx.datastore.core.FileStorageConnection$writeScope$1
            r1.<init>(r10, r12)
        L_0x001b:
            java.lang.Object r12 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 2
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L_0x005f
            if (r3 == r5) goto L_0x004c
            if (r3 != r4) goto L_0x0044
            java.lang.Object r11 = r1.L$3
            androidx.datastore.core.Closeable r11 = (androidx.datastore.core.Closeable) r11
            java.lang.Object r2 = r1.L$2
            java.io.File r2 = (java.io.File) r2
            java.lang.Object r3 = r1.L$1
            kotlinx.coroutines.sync.Mutex r3 = (kotlinx.coroutines.sync.Mutex) r3
            java.lang.Object r1 = r1.L$0
            androidx.datastore.core.FileStorageConnection r1 = (androidx.datastore.core.FileStorageConnection) r1
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0041 }
            goto L_0x00bb
        L_0x0041:
            r12 = move-exception
            goto L_0x0106
        L_0x0044:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x004c:
            java.lang.Object r11 = r1.L$2
            kotlinx.coroutines.sync.Mutex r11 = (kotlinx.coroutines.sync.Mutex) r11
            java.lang.Object r3 = r1.L$1
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            java.lang.Object r5 = r1.L$0
            androidx.datastore.core.FileStorageConnection r5 = (androidx.datastore.core.FileStorageConnection) r5
            kotlin.ResultKt.throwOnFailure(r12)
            r9 = r3
            r3 = r11
            r11 = r9
            goto L_0x007d
        L_0x005f:
            kotlin.ResultKt.throwOnFailure(r12)
            r10.checkNotClosed()
            java.io.File r12 = r10.file
            r10.createParentDirectories(r12)
            kotlinx.coroutines.sync.Mutex r12 = r10.transactionMutex
            r1.L$0 = r10
            r1.L$1 = r11
            r1.L$2 = r12
            r1.label = r5
            java.lang.Object r3 = r12.lock(r6, r1)
            if (r3 != r2) goto L_0x007b
            goto L_0x00b7
        L_0x007b:
            r5 = r10
            r3 = r12
        L_0x007d:
            java.io.File r12 = new java.io.File     // Catch:{ all -> 0x011d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x011d }
            r7.<init>()     // Catch:{ all -> 0x011d }
            java.io.File r8 = r5.file     // Catch:{ all -> 0x011d }
            java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ all -> 0x011d }
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x011d }
            java.lang.String r8 = ".tmp"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x011d }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x011d }
            r12.<init>(r7)     // Catch:{ all -> 0x011d }
            androidx.datastore.core.FileWriteScope r7 = new androidx.datastore.core.FileWriteScope     // Catch:{ IOException -> 0x0112 }
            androidx.datastore.core.Serializer<T> r8 = r5.serializer     // Catch:{ IOException -> 0x0112 }
            r7.<init>(r12, r8)     // Catch:{ IOException -> 0x0112 }
            androidx.datastore.core.Closeable r7 = (androidx.datastore.core.Closeable) r7     // Catch:{ IOException -> 0x0112 }
            r8 = r7
            androidx.datastore.core.FileWriteScope r8 = (androidx.datastore.core.FileWriteScope) r8     // Catch:{ all -> 0x0102 }
            r1.L$0 = r5     // Catch:{ all -> 0x0102 }
            r1.L$1 = r3     // Catch:{ all -> 0x0102 }
            r1.L$2 = r12     // Catch:{ all -> 0x0102 }
            r1.L$3 = r7     // Catch:{ all -> 0x0102 }
            r1.label = r4     // Catch:{ all -> 0x0102 }
            java.lang.Object r11 = r11.invoke(r8, r1)     // Catch:{ all -> 0x0102 }
            if (r11 != r2) goto L_0x00b8
        L_0x00b7:
            return r2
        L_0x00b8:
            r2 = r12
            r1 = r5
            r11 = r7
        L_0x00bb:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0041 }
            r11.close()     // Catch:{ all -> 0x00c2 }
            r11 = r6
            goto L_0x00c3
        L_0x00c2:
            r11 = move-exception
        L_0x00c3:
            if (r11 != 0) goto L_0x0101
            boolean r11 = r2.exists()     // Catch:{ IOException -> 0x010f }
            if (r11 == 0) goto L_0x00f9
            java.io.File r11 = r1.file     // Catch:{ IOException -> 0x010f }
            boolean r11 = androidx.datastore.core.FileMoves_androidKt.atomicMoveTo(r2, r11)     // Catch:{ IOException -> 0x010f }
            if (r11 == 0) goto L_0x00d4
            goto L_0x00f9
        L_0x00d4:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ IOException -> 0x010f }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x010f }
            r12.<init>(r0)     // Catch:{ IOException -> 0x010f }
            java.lang.StringBuilder r12 = r12.append(r2)     // Catch:{ IOException -> 0x010f }
            java.lang.String r0 = " to "
            java.lang.StringBuilder r12 = r12.append(r0)     // Catch:{ IOException -> 0x010f }
            java.io.File r0 = r1.file     // Catch:{ IOException -> 0x010f }
            java.lang.StringBuilder r12 = r12.append(r0)     // Catch:{ IOException -> 0x010f }
            java.lang.String r0 = ". This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file."
            java.lang.StringBuilder r12 = r12.append(r0)     // Catch:{ IOException -> 0x010f }
            java.lang.String r12 = r12.toString()     // Catch:{ IOException -> 0x010f }
            r11.<init>(r12)     // Catch:{ IOException -> 0x010f }
            throw r11     // Catch:{ IOException -> 0x010f }
        L_0x00f9:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x011d }
            r3.unlock(r6)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0101:
            throw r11     // Catch:{ IOException -> 0x010f }
        L_0x0102:
            r11 = move-exception
            r2 = r12
            r12 = r11
            r11 = r7
        L_0x0106:
            r11.close()     // Catch:{ all -> 0x010a }
            goto L_0x010e
        L_0x010a:
            r11 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r12, r11)     // Catch:{ IOException -> 0x010f }
        L_0x010e:
            throw r12     // Catch:{ IOException -> 0x010f }
        L_0x010f:
            r11 = move-exception
            r12 = r2
            goto L_0x0113
        L_0x0112:
            r11 = move-exception
        L_0x0113:
            boolean r0 = r12.exists()     // Catch:{ all -> 0x011d }
            if (r0 == 0) goto L_0x011c
            r12.delete()     // Catch:{ all -> 0x011d }
        L_0x011c:
            throw r11     // Catch:{ all -> 0x011d }
        L_0x011d:
            r11 = move-exception
            r3.unlock(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileStorageConnection.writeScope(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.".toString());
        }
    }

    private final void createParentDirectories(File file2) {
        File parentFile = file2.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException("Unable to create parent directories of " + file2);
            }
        }
    }
}
