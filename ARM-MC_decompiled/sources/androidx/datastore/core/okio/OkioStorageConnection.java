package androidx.datastore.core.okio;

import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.StorageConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.FileSystem;
import okio.Path;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0016JX\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0001\u0010\u00182B\u0010\u0019\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001a¢\u0006\u0002\b\"H@¢\u0006\u0002\u0010#J=\u0010$\u001a\u00020\r2-\u0010\u0019\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0 \u0012\u0006\u0012\u0004\u0018\u00010!0%¢\u0006\u0002\b\"H@¢\u0006\u0002\u0010'R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/datastore/core/okio/OkioStorageConnection;", "T", "Landroidx/datastore/core/StorageConnection;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "onClose", "Lkotlin/Function0;", "", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;Landroidx/datastore/core/InterProcessCoordinator;Lkotlin/jvm/functions/Function0;)V", "closed", "Landroidx/datastore/core/okio/AtomicBoolean;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "transactionMutex", "Lkotlinx/coroutines/sync/Mutex;", "checkNotClosed", "close", "readScope", "R", "block", "Lkotlin/Function3;", "Landroidx/datastore/core/ReadScope;", "", "Lkotlin/ParameterName;", "name", "locked", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeScope", "Lkotlin/Function2;", "Landroidx/datastore/core/WriteScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OkioStorage.kt */
public final class OkioStorageConnection<T> implements StorageConnection<T> {
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final InterProcessCoordinator coordinator;
    private final FileSystem fileSystem;
    private final Function0<Unit> onClose;
    private final Path path;
    private final OkioSerializer<T> serializer;
    private final Mutex transactionMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    public OkioStorageConnection(FileSystem fileSystem2, Path path2, OkioSerializer<T> okioSerializer, InterProcessCoordinator interProcessCoordinator, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(fileSystem2, "fileSystem");
        Intrinsics.checkNotNullParameter(path2, "path");
        Intrinsics.checkNotNullParameter(okioSerializer, "serializer");
        Intrinsics.checkNotNullParameter(interProcessCoordinator, "coordinator");
        Intrinsics.checkNotNullParameter(function0, "onClose");
        this.fileSystem = fileSystem2;
        this.path = path2;
        this.serializer = okioSerializer;
        this.coordinator = interProcessCoordinator;
        this.onClose = function0;
    }

    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        kotlin.ExceptionsKt.addSuppressed(r10, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0093, code lost:
        r10 = th;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:32:0x0083, B:36:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0083 A[SYNTHETIC, Splitter:B:32:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <R> java.lang.Object readScope(kotlin.jvm.functions.Function3<? super androidx.datastore.core.ReadScope<T>, ? super java.lang.Boolean, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super R> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.okio.OkioStorageConnection$readScope$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            androidx.datastore.core.okio.OkioStorageConnection$readScope$1 r0 = (androidx.datastore.core.okio.OkioStorageConnection$readScope$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.okio.OkioStorageConnection$readScope$1 r0 = new androidx.datastore.core.okio.OkioStorageConnection$readScope$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            boolean r9 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            androidx.datastore.core.Closeable r1 = (androidx.datastore.core.Closeable) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.okio.OkioStorageConnection r0 = (androidx.datastore.core.okio.OkioStorageConnection) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0035 }
            goto L_0x0073
        L_0x0035:
            r10 = move-exception
            goto L_0x008a
        L_0x0037:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r10)
            r8.checkNotClosed()
            kotlinx.coroutines.sync.Mutex r10 = r8.transactionMutex
            boolean r10 = kotlinx.coroutines.sync.Mutex.DefaultImpls.tryLock$default(r10, r4, r3, r4)
            androidx.datastore.core.okio.OkioReadScope r2 = new androidx.datastore.core.okio.OkioReadScope     // Catch:{ all -> 0x0095 }
            okio.FileSystem r5 = r8.fileSystem     // Catch:{ all -> 0x0095 }
            okio.Path r6 = r8.path     // Catch:{ all -> 0x0095 }
            androidx.datastore.core.okio.OkioSerializer<T> r7 = r8.serializer     // Catch:{ all -> 0x0095 }
            r2.<init>(r5, r6, r7)     // Catch:{ all -> 0x0095 }
            androidx.datastore.core.Closeable r2 = (androidx.datastore.core.Closeable) r2     // Catch:{ all -> 0x0095 }
            r5 = r2
            androidx.datastore.core.okio.OkioReadScope r5 = (androidx.datastore.core.okio.OkioReadScope) r5     // Catch:{ all -> 0x0084 }
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)     // Catch:{ all -> 0x0084 }
            r0.L$0 = r8     // Catch:{ all -> 0x0084 }
            r0.L$1 = r2     // Catch:{ all -> 0x0084 }
            r0.Z$0 = r10     // Catch:{ all -> 0x0084 }
            r0.label = r3     // Catch:{ all -> 0x0084 }
            java.lang.Object r9 = r9.invoke(r5, r6, r0)     // Catch:{ all -> 0x0084 }
            if (r9 != r1) goto L_0x006e
            return r1
        L_0x006e:
            r0 = r10
            r10 = r9
            r9 = r0
            r0 = r8
            r1 = r2
        L_0x0073:
            r1.close()     // Catch:{ all -> 0x0078 }
            r1 = r4
            goto L_0x0079
        L_0x0078:
            r1 = move-exception
        L_0x0079:
            if (r1 != 0) goto L_0x0083
            if (r9 == 0) goto L_0x0082
            kotlinx.coroutines.sync.Mutex r9 = r0.transactionMutex
            kotlinx.coroutines.sync.Mutex.DefaultImpls.unlock$default(r9, r4, r3, r4)
        L_0x0082:
            return r10
        L_0x0083:
            throw r1     // Catch:{ all -> 0x0093 }
        L_0x0084:
            r9 = move-exception
            r0 = r10
            r10 = r9
            r9 = r0
            r0 = r8
            r1 = r2
        L_0x008a:
            r1.close()     // Catch:{ all -> 0x008e }
            goto L_0x0092
        L_0x008e:
            r1 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r10, r1)     // Catch:{ all -> 0x0093 }
        L_0x0092:
            throw r10     // Catch:{ all -> 0x0093 }
        L_0x0093:
            r10 = move-exception
            goto L_0x009a
        L_0x0095:
            r9 = move-exception
            r0 = r10
            r10 = r9
            r9 = r0
            r0 = r8
        L_0x009a:
            if (r9 == 0) goto L_0x00a1
            kotlinx.coroutines.sync.Mutex r9 = r0.transactionMutex
            kotlinx.coroutines.sync.Mutex.DefaultImpls.unlock$default(r9, r4, r3, r4)
        L_0x00a1:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioStorageConnection.readScope(kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0114 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d7 A[SYNTHETIC, Splitter:B:39:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ee A[SYNTHETIC, Splitter:B:47:0x00ee] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object writeScope(kotlin.jvm.functions.Function2<? super androidx.datastore.core.WriteScope<T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.okio.OkioStorageConnection$writeScope$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.datastore.core.okio.OkioStorageConnection$writeScope$1 r0 = (androidx.datastore.core.okio.OkioStorageConnection$writeScope$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.okio.OkioStorageConnection$writeScope$1 r0 = new androidx.datastore.core.okio.OkioStorageConnection$writeScope$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0061
            if (r2 == r5) goto L_0x004b
            if (r2 != r4) goto L_0x0043
            java.lang.Object r10 = r0.L$3
            androidx.datastore.core.Closeable r10 = (androidx.datastore.core.Closeable) r10
            java.lang.Object r1 = r0.L$2
            okio.Path r1 = (okio.Path) r1
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.okio.OkioStorageConnection r0 = (androidx.datastore.core.okio.OkioStorageConnection) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0040 }
            goto L_0x00cd
        L_0x0040:
            r11 = move-exception
            goto L_0x00f5
        L_0x0043:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x004b:
            java.lang.Object r10 = r0.L$3
            kotlinx.coroutines.sync.Mutex r10 = (kotlinx.coroutines.sync.Mutex) r10
            java.lang.Object r2 = r0.L$2
            okio.Path r2 = (okio.Path) r2
            java.lang.Object r5 = r0.L$1
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            java.lang.Object r7 = r0.L$0
            androidx.datastore.core.okio.OkioStorageConnection r7 = (androidx.datastore.core.okio.OkioStorageConnection) r7
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r10
            r10 = r5
            goto L_0x0088
        L_0x0061:
            kotlin.ResultKt.throwOnFailure(r11)
            r9.checkNotClosed()
            okio.Path r11 = r9.path
            okio.Path r2 = r11.parent()
            if (r2 == 0) goto L_0x011a
            okio.FileSystem r11 = r9.fileSystem
            r11.createDirectories(r2, r3)
            kotlinx.coroutines.sync.Mutex r11 = r9.transactionMutex
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r2
            r0.L$3 = r11
            r0.label = r5
            java.lang.Object r5 = r11.lock(r6, r0)
            if (r5 != r1) goto L_0x0087
            goto L_0x00c8
        L_0x0087:
            r7 = r9
        L_0x0088:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            r5.<init>()     // Catch:{ all -> 0x0115 }
            okio.Path r8 = r7.path     // Catch:{ all -> 0x0115 }
            java.lang.String r8 = r8.name()     // Catch:{ all -> 0x0115 }
            java.lang.StringBuilder r5 = r5.append(r8)     // Catch:{ all -> 0x0115 }
            java.lang.String r8 = ".tmp"
            java.lang.StringBuilder r5 = r5.append(r8)     // Catch:{ all -> 0x0115 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0115 }
            okio.Path r2 = r2.resolve((java.lang.String) r5)     // Catch:{ all -> 0x0115 }
            okio.FileSystem r5 = r7.fileSystem     // Catch:{ IOException -> 0x0106 }
            r5.delete(r2, r3)     // Catch:{ IOException -> 0x0106 }
            androidx.datastore.core.okio.OkioWriteScope r3 = new androidx.datastore.core.okio.OkioWriteScope     // Catch:{ IOException -> 0x0106 }
            okio.FileSystem r5 = r7.fileSystem     // Catch:{ IOException -> 0x0106 }
            androidx.datastore.core.okio.OkioSerializer<T> r8 = r7.serializer     // Catch:{ IOException -> 0x0106 }
            r3.<init>(r5, r2, r8)     // Catch:{ IOException -> 0x0106 }
            androidx.datastore.core.Closeable r3 = (androidx.datastore.core.Closeable) r3     // Catch:{ IOException -> 0x0106 }
            r5 = r3
            androidx.datastore.core.okio.OkioWriteScope r5 = (androidx.datastore.core.okio.OkioWriteScope) r5     // Catch:{ all -> 0x00ef }
            r0.L$0 = r7     // Catch:{ all -> 0x00ef }
            r0.L$1 = r11     // Catch:{ all -> 0x00ef }
            r0.L$2 = r2     // Catch:{ all -> 0x00ef }
            r0.L$3 = r3     // Catch:{ all -> 0x00ef }
            r0.label = r4     // Catch:{ all -> 0x00ef }
            java.lang.Object r10 = r10.invoke(r5, r0)     // Catch:{ all -> 0x00ef }
            if (r10 != r1) goto L_0x00c9
        L_0x00c8:
            return r1
        L_0x00c9:
            r1 = r2
            r10 = r3
            r0 = r7
            r2 = r11
        L_0x00cd:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0040 }
            r10.close()     // Catch:{ all -> 0x00d4 }
            r10 = r6
            goto L_0x00d5
        L_0x00d4:
            r10 = move-exception
        L_0x00d5:
            if (r10 != 0) goto L_0x00ee
            okio.FileSystem r10 = r0.fileSystem     // Catch:{ IOException -> 0x0101 }
            boolean r10 = r10.exists(r1)     // Catch:{ IOException -> 0x0101 }
            if (r10 == 0) goto L_0x00e6
            okio.FileSystem r10 = r0.fileSystem     // Catch:{ IOException -> 0x0101 }
            okio.Path r11 = r0.path     // Catch:{ IOException -> 0x0101 }
            r10.atomicMove(r1, r11)     // Catch:{ IOException -> 0x0101 }
        L_0x00e6:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00fe }
            r2.unlock(r6)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00ee:
            throw r10     // Catch:{ IOException -> 0x0101 }
        L_0x00ef:
            r10 = move-exception
            r1 = r2
            r0 = r7
            r2 = r11
            r11 = r10
            r10 = r3
        L_0x00f5:
            r10.close()     // Catch:{ all -> 0x00f9 }
            goto L_0x00fd
        L_0x00f9:
            r10 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r11, r10)     // Catch:{ IOException -> 0x0101 }
        L_0x00fd:
            throw r11     // Catch:{ IOException -> 0x0101 }
        L_0x00fe:
            r10 = move-exception
            r11 = r2
            goto L_0x0116
        L_0x0101:
            r10 = move-exception
            r7 = r0
            r11 = r2
            r2 = r1
            goto L_0x0107
        L_0x0106:
            r10 = move-exception
        L_0x0107:
            okio.FileSystem r0 = r7.fileSystem     // Catch:{ all -> 0x0115 }
            boolean r0 = r0.exists(r2)     // Catch:{ all -> 0x0115 }
            if (r0 == 0) goto L_0x0114
            okio.FileSystem r0 = r7.fileSystem     // Catch:{ IOException -> 0x0114 }
            r0.delete(r2)     // Catch:{ IOException -> 0x0114 }
        L_0x0114:
            throw r10     // Catch:{ all -> 0x0115 }
        L_0x0115:
            r10 = move-exception
        L_0x0116:
            r11.unlock(r6)
            throw r10
        L_0x011a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "must have a parent path"
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioStorageConnection.writeScope(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.".toString());
        }
    }

    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }
}
