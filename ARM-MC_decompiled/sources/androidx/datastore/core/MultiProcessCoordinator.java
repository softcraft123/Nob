package androidx.datastore.core;

import com.google.firebase.firestore.util.ExponentialBackoff;
import java.io.File;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 42\u00020\u0001:\u00014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\bH\u0002J\u000e\u0010\"\u001a\u00020#H@¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020#H@¢\u0006\u0002\u0010$J2\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\u001c\u0010(\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0*\u0012\u0006\u0012\u0004\u0018\u00010+0)H@¢\u0006\u0002\u0010,J8\u0010-\u001a\u0002H'\"\u0004\b\u0000\u0010'2\"\u0010(\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0*\u0012\u0006\u0012\u0004\u0018\u00010+0.H@¢\u0006\u0002\u00100J:\u00101\u001a\u0002H'\"\u0004\b\u0000\u0010'2$\b\u0004\u0010(\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0*\u0012\u0006\u0012\u0004\u0018\u00010+0.HH¢\u0006\u0002\u00100J\f\u00102\u001a\u00020\u001d*\u00020\u0005H\u0002J\f\u00103\u001a\u00020\u001d*\u00020\u0005H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0013\u0010\fR\u001b\u0010\u0016\u001a\u00020\u00118BX\u0002¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a*\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00065"}, d2 = {"Landroidx/datastore/core/MultiProcessCoordinator;", "Landroidx/datastore/core/InterProcessCoordinator;", "context", "Lkotlin/coroutines/CoroutineContext;", "file", "Ljava/io/File;", "(Lkotlin/coroutines/CoroutineContext;Ljava/io/File;)V", "LOCK_ERROR_MESSAGE", "", "LOCK_SUFFIX", "VERSION_SUFFIX", "getFile", "()Ljava/io/File;", "inMemoryMutex", "Lkotlinx/coroutines/sync/Mutex;", "lazySharedCounter", "Lkotlin/Lazy;", "Landroidx/datastore/core/SharedCounter;", "lockFile", "getLockFile", "lockFile$delegate", "Lkotlin/Lazy;", "sharedCounter", "getSharedCounter$delegate", "(Landroidx/datastore/core/MultiProcessCoordinator;)Ljava/lang/Object;", "getSharedCounter", "()Landroidx/datastore/core/SharedCounter;", "updateNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "getUpdateNotifications", "()Lkotlinx/coroutines/flow/Flow;", "fileWithSuffix", "suffix", "getVersion", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementAndGetVersion", "lock", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLock", "Lkotlin/Function2;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withLazyCounter", "createIfNotExists", "createParentDirectories", "Companion", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MultiProcessCoordinator.android.kt */
public final class MultiProcessCoordinator implements InterProcessCoordinator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String DEADLOCK_ERROR_MESSAGE = "Resource deadlock would occur";
    /* access modifiers changed from: private */
    public static final long INITIAL_WAIT_MILLIS = 10;
    /* access modifiers changed from: private */
    public static final long MAX_WAIT_MILLIS = ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS;
    private final String LOCK_ERROR_MESSAGE = "fcntl failed: EAGAIN";
    /* access modifiers changed from: private */
    public final String LOCK_SUFFIX = ".lock";
    /* access modifiers changed from: private */
    public final String VERSION_SUFFIX = ".version";
    private final CoroutineContext context;
    private final File file;
    private final Mutex inMemoryMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    private final Lazy<SharedCounter> lazySharedCounter = LazyKt.lazy(new MultiProcessCoordinator$lazySharedCounter$1(this));
    private final Lazy lockFile$delegate = LazyKt.lazy(new MultiProcessCoordinator$lockFile$2(this));
    private final Flow<Unit> updateNotifications;

    public MultiProcessCoordinator(CoroutineContext coroutineContext, File file2) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(file2, "file");
        this.context = coroutineContext;
        this.file = file2;
        this.updateNotifications = MulticastFileObserver.Companion.observe(file2);
    }

    /* access modifiers changed from: protected */
    public final File getFile() {
        return this.file;
    }

    public Flow<Unit> getUpdateNotifications() {
        return this.updateNotifications;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c1 A[SYNTHETIC, Splitter:B:44:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00db A[SYNTHETIC, Splitter:B:57:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.lang.Object lock(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r10, kotlin.coroutines.Continuation<? super T> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.MultiProcessCoordinator$lock$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.datastore.core.MultiProcessCoordinator$lock$1 r0 = (androidx.datastore.core.MultiProcessCoordinator$lock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.MultiProcessCoordinator$lock$1 r0 = new androidx.datastore.core.MultiProcessCoordinator$lock$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0071
            if (r2 == r5) goto L_0x005f
            if (r2 == r4) goto L_0x0049
            if (r2 != r3) goto L_0x0041
            java.lang.Object r10 = r0.L$2
            java.nio.channels.FileLock r10 = (java.nio.channels.FileLock) r10
            java.lang.Object r1 = r0.L$1
            java.io.Closeable r1 = (java.io.Closeable) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x003e }
            goto L_0x00bf
        L_0x003e:
            r11 = move-exception
            goto L_0x00d9
        L_0x0041:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0049:
            java.lang.Object r10 = r0.L$2
            java.io.Closeable r10 = (java.io.Closeable) r10
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0059 }
            goto L_0x00aa
        L_0x0059:
            r11 = move-exception
            r1 = r10
            r0 = r2
        L_0x005c:
            r10 = r6
            goto L_0x00d9
        L_0x005f:
            java.lang.Object r10 = r0.L$2
            kotlinx.coroutines.sync.Mutex r10 = (kotlinx.coroutines.sync.Mutex) r10
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r5 = r0.L$0
            androidx.datastore.core.MultiProcessCoordinator r5 = (androidx.datastore.core.MultiProcessCoordinator) r5
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r10
            r10 = r2
            goto L_0x0086
        L_0x0071:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.sync.Mutex r11 = r9.inMemoryMutex
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r11
            r0.label = r5
            java.lang.Object r2 = r11.lock(r6, r0)
            if (r2 != r1) goto L_0x0085
            goto L_0x00ba
        L_0x0085:
            r5 = r9
        L_0x0086:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x00eb }
            java.io.File r5 = r5.getLockFile()     // Catch:{ all -> 0x00eb }
            r2.<init>(r5)     // Catch:{ all -> 0x00eb }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x00eb }
            r5 = r2
            java.io.FileOutputStream r5 = (java.io.FileOutputStream) r5     // Catch:{ all -> 0x00e4 }
            androidx.datastore.core.MultiProcessCoordinator$Companion r7 = Companion     // Catch:{ all -> 0x00d4 }
            r0.L$0 = r10     // Catch:{ all -> 0x00d4 }
            r0.L$1 = r11     // Catch:{ all -> 0x00d4 }
            r0.L$2 = r2     // Catch:{ all -> 0x00d4 }
            r0.label = r4     // Catch:{ all -> 0x00d4 }
            java.lang.Object r4 = r7.getExclusiveFileLockWithRetryIfDeadlock(r5, r0)     // Catch:{ all -> 0x00d4 }
            if (r4 != r1) goto L_0x00a5
            goto L_0x00ba
        L_0x00a5:
            r8 = r4
            r4 = r10
            r10 = r2
            r2 = r11
            r11 = r8
        L_0x00aa:
            java.nio.channels.FileLock r11 = (java.nio.channels.FileLock) r11     // Catch:{ all -> 0x0059 }
            r0.L$0 = r2     // Catch:{ all -> 0x00ce }
            r0.L$1 = r10     // Catch:{ all -> 0x00ce }
            r0.L$2 = r11     // Catch:{ all -> 0x00ce }
            r0.label = r3     // Catch:{ all -> 0x00ce }
            java.lang.Object r0 = r4.invoke(r0)     // Catch:{ all -> 0x00ce }
            if (r0 != r1) goto L_0x00bb
        L_0x00ba:
            return r1
        L_0x00bb:
            r1 = r10
            r10 = r11
            r11 = r0
            r0 = r2
        L_0x00bf:
            if (r10 == 0) goto L_0x00c4
            r10.release()     // Catch:{ all -> 0x00df }
        L_0x00c4:
            kotlin.io.CloseableKt.closeFinally(r1, r6)     // Catch:{ all -> 0x00cb }
            r0.unlock(r6)
            return r11
        L_0x00cb:
            r10 = move-exception
            r11 = r0
            goto L_0x00ec
        L_0x00ce:
            r0 = move-exception
            r1 = r10
            r10 = r11
            r11 = r0
            r0 = r2
            goto L_0x00d9
        L_0x00d4:
            r10 = move-exception
            r0 = r11
            r1 = r2
            r11 = r10
            goto L_0x005c
        L_0x00d9:
            if (r10 == 0) goto L_0x00e3
            r10.release()     // Catch:{ all -> 0x00df }
            goto L_0x00e3
        L_0x00df:
            r10 = move-exception
            r11 = r0
            r2 = r1
            goto L_0x00e5
        L_0x00e3:
            throw r11     // Catch:{ all -> 0x00df }
        L_0x00e4:
            r10 = move-exception
        L_0x00e5:
            throw r10     // Catch:{ all -> 0x00e6 }
        L_0x00e6:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r10)     // Catch:{ all -> 0x00eb }
            throw r0     // Catch:{ all -> 0x00eb }
        L_0x00eb:
            r10 = move-exception
        L_0x00ec:
            r11.unlock(r6)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.lock(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e7 A[SYNTHETIC, Splitter:B:59:0x00e7] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.lang.Object tryLock(kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r19, kotlin.coroutines.Continuation<? super T> r20) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r0 = r20
            boolean r3 = r0 instanceof androidx.datastore.core.MultiProcessCoordinator$tryLock$1
            if (r3 == 0) goto L_0x001a
            r3 = r0
            androidx.datastore.core.MultiProcessCoordinator$tryLock$1 r3 = (androidx.datastore.core.MultiProcessCoordinator$tryLock$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r0 = r3.label
            int r0 = r0 - r5
            r3.label = r0
            goto L_0x001f
        L_0x001a:
            androidx.datastore.core.MultiProcessCoordinator$tryLock$1 r3 = new androidx.datastore.core.MultiProcessCoordinator$tryLock$1
            r3.<init>(r1, r0)
        L_0x001f:
            java.lang.Object r0 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x005b
            if (r5 == r7) goto L_0x004e
            if (r5 != r6) goto L_0x0046
            boolean r2 = r3.Z$0
            java.lang.Object r4 = r3.L$2
            java.nio.channels.FileLock r4 = (java.nio.channels.FileLock) r4
            java.lang.Object r5 = r3.L$1
            java.io.Closeable r5 = (java.io.Closeable) r5
            java.lang.Object r3 = r3.L$0
            kotlinx.coroutines.sync.Mutex r3 = (kotlinx.coroutines.sync.Mutex) r3
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0043 }
            goto L_0x00e5
        L_0x0043:
            r0 = move-exception
            goto L_0x00fa
        L_0x0046:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004e:
            boolean r2 = r3.Z$0
            java.lang.Object r3 = r3.L$0
            kotlinx.coroutines.sync.Mutex r3 = (kotlinx.coroutines.sync.Mutex) r3
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0058 }
            goto L_0x007b
        L_0x0058:
            r0 = move-exception
            goto L_0x0114
        L_0x005b:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlinx.coroutines.sync.Mutex r5 = r1.inMemoryMutex
            boolean r9 = r5.tryLock(r8)
            r10 = 0
            if (r9 != 0) goto L_0x0081
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)     // Catch:{ all -> 0x0111 }
            r3.L$0 = r5     // Catch:{ all -> 0x0111 }
            r3.Z$0 = r9     // Catch:{ all -> 0x0111 }
            r3.label = r7     // Catch:{ all -> 0x0111 }
            java.lang.Object r0 = r2.invoke(r0, r3)     // Catch:{ all -> 0x0111 }
            if (r0 != r4) goto L_0x0079
            goto L_0x00e0
        L_0x0079:
            r3 = r5
            r2 = r9
        L_0x007b:
            if (r2 == 0) goto L_0x0080
            r3.unlock(r8)
        L_0x0080:
            return r0
        L_0x0081:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ all -> 0x0111 }
            java.io.File r11 = r1.getLockFile()     // Catch:{ all -> 0x0111 }
            r0.<init>(r11)     // Catch:{ all -> 0x0111 }
            r11 = r0
            java.io.Closeable r11 = (java.io.Closeable) r11     // Catch:{ all -> 0x0111 }
            r0 = r11
            java.io.FileInputStream r0 = (java.io.FileInputStream) r0     // Catch:{ all -> 0x0106 }
            java.nio.channels.FileChannel r12 = r0.getChannel()     // Catch:{ IOException -> 0x00a9 }
            r15 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r17 = 1
            r13 = 0
            java.nio.channels.FileLock r0 = r12.tryLock(r13, r15, r17)     // Catch:{ IOException -> 0x00a9 }
            r12 = r0
            goto L_0x00c8
        L_0x00a3:
            r0 = move-exception
            r3 = r5
            r4 = r8
            r2 = r9
            r5 = r11
            goto L_0x00fa
        L_0x00a9:
            r0 = move-exception
            java.lang.String r12 = r0.getMessage()     // Catch:{ all -> 0x00a3 }
            if (r12 == 0) goto L_0x00b9
            java.lang.String r13 = r1.LOCK_ERROR_MESSAGE     // Catch:{ all -> 0x00a3 }
            boolean r12 = kotlin.text.StringsKt.startsWith$default(r12, r13, r10, r6, r8)     // Catch:{ all -> 0x00a3 }
            if (r12 != r7) goto L_0x00b9
            goto L_0x00c7
        L_0x00b9:
            java.lang.String r12 = r0.getMessage()     // Catch:{ all -> 0x00a3 }
            if (r12 == 0) goto L_0x00f9
            java.lang.String r13 = DEADLOCK_ERROR_MESSAGE     // Catch:{ all -> 0x00a3 }
            boolean r12 = kotlin.text.StringsKt.startsWith$default(r12, r13, r10, r6, r8)     // Catch:{ all -> 0x00a3 }
            if (r12 != r7) goto L_0x00f9
        L_0x00c7:
            r12 = r8
        L_0x00c8:
            if (r12 == 0) goto L_0x00cb
            goto L_0x00cc
        L_0x00cb:
            r7 = r10
        L_0x00cc:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)     // Catch:{ all -> 0x00f3 }
            r3.L$0 = r5     // Catch:{ all -> 0x00f3 }
            r3.L$1 = r11     // Catch:{ all -> 0x00f3 }
            r3.L$2 = r12     // Catch:{ all -> 0x00f3 }
            r3.Z$0 = r9     // Catch:{ all -> 0x00f3 }
            r3.label = r6     // Catch:{ all -> 0x00f3 }
            java.lang.Object r0 = r2.invoke(r0, r3)     // Catch:{ all -> 0x00f3 }
            if (r0 != r4) goto L_0x00e1
        L_0x00e0:
            return r4
        L_0x00e1:
            r3 = r5
            r2 = r9
            r5 = r11
            r4 = r12
        L_0x00e5:
            if (r4 == 0) goto L_0x00ea
            r4.release()     // Catch:{ all -> 0x0100 }
        L_0x00ea:
            kotlin.io.CloseableKt.closeFinally(r5, r8)     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x00f2
            r3.unlock(r8)
        L_0x00f2:
            return r0
        L_0x00f3:
            r0 = move-exception
            r3 = r5
            r2 = r9
            r5 = r11
            r4 = r12
            goto L_0x00fa
        L_0x00f9:
            throw r0     // Catch:{ all -> 0x00a3 }
        L_0x00fa:
            if (r4 == 0) goto L_0x0105
            r4.release()     // Catch:{ all -> 0x0100 }
            goto L_0x0105
        L_0x0100:
            r0 = move-exception
            r9 = r2
            r11 = r5
            r2 = r0
            goto L_0x0109
        L_0x0105:
            throw r0     // Catch:{ all -> 0x0100 }
        L_0x0106:
            r0 = move-exception
            r2 = r0
            r3 = r5
        L_0x0109:
            throw r2     // Catch:{ all -> 0x010a }
        L_0x010a:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r11, r2)     // Catch:{ all -> 0x010f }
            throw r0     // Catch:{ all -> 0x010f }
        L_0x010f:
            r0 = move-exception
            goto L_0x0113
        L_0x0111:
            r0 = move-exception
            r3 = r5
        L_0x0113:
            r2 = r9
        L_0x0114:
            if (r2 == 0) goto L_0x0119
            r3.unlock(r8)
        L_0x0119:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.tryLock(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final File getLockFile() {
        return (File) this.lockFile$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SharedCounter getSharedCounter() {
        return this.lazySharedCounter.getValue();
    }

    private static Object getSharedCounter$delegate(MultiProcessCoordinator multiProcessCoordinator) {
        return multiProcessCoordinator.lazySharedCounter;
    }

    /* access modifiers changed from: private */
    public final File fileWithSuffix(String str) {
        return new File(this.file.getAbsolutePath() + str);
    }

    /* access modifiers changed from: private */
    public final void createIfNotExists(File file2) {
        createParentDirectories(file2);
        if (!file2.exists()) {
            file2.createNewFile();
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

    private final <T> Object withLazyCounter(Function2<? super SharedCounter, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (this.lazySharedCounter.isInitialized()) {
            return function2.invoke(getSharedCounter(), continuation);
        }
        return BuildersKt.withContext(this.context, new MultiProcessCoordinator$withLazyCounter$2(function2, this, (Continuation<? super MultiProcessCoordinator$withLazyCounter$2>) null), continuation);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH@¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/datastore/core/MultiProcessCoordinator$Companion;", "", "()V", "DEADLOCK_ERROR_MESSAGE", "", "INITIAL_WAIT_MILLIS", "", "MAX_WAIT_MILLIS", "getExclusiveFileLockWithRetryIfDeadlock", "Ljava/nio/channels/FileLock;", "lockFileStream", "Ljava/io/FileOutputStream;", "(Ljava/io/FileOutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MultiProcessCoordinator.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004c A[SYNTHETIC, Splitter:B:15:0x004c] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0088  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object getExclusiveFileLockWithRetryIfDeadlock(java.io.FileOutputStream r14, kotlin.coroutines.Continuation<? super java.nio.channels.FileLock> r15) {
            /*
                r13 = this;
                boolean r0 = r15 instanceof androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1
                if (r0 == 0) goto L_0x0014
                r0 = r15
                androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 r0 = (androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L_0x0014
                int r15 = r0.label
                int r15 = r15 - r2
                r0.label = r15
                goto L_0x0019
            L_0x0014:
                androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 r0 = new androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1
                r0.<init>(r13, r15)
            L_0x0019:
                java.lang.Object r15 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x003a
                if (r2 != r4) goto L_0x0032
                long r5 = r0.J$0
                java.lang.Object r14 = r0.L$0
                java.io.FileOutputStream r14 = (java.io.FileOutputStream) r14
                kotlin.ResultKt.throwOnFailure(r15)
                r15 = r0
                goto L_0x0084
            L_0x0032:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r15)
                throw r14
            L_0x003a:
                kotlin.ResultKt.throwOnFailure(r15)
                long r5 = androidx.datastore.core.MultiProcessCoordinator.INITIAL_WAIT_MILLIS
                r15 = r0
            L_0x0042:
                long r7 = androidx.datastore.core.MultiProcessCoordinator.MAX_WAIT_MILLIS
                int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                java.lang.String r2 = "lockFileStream.getChanne…LUE, /* shared= */ false)"
                if (r0 > 0) goto L_0x0088
                java.nio.channels.FileChannel r7 = r14.getChannel()     // Catch:{ IOException -> 0x0060 }
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r12 = 0
                r8 = 0
                java.nio.channels.FileLock r0 = r7.lock(r8, r10, r12)     // Catch:{ IOException -> 0x0060 }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ IOException -> 0x0060 }
                return r0
            L_0x0060:
                r0 = move-exception
                java.lang.String r2 = r0.getMessage()
                if (r2 == 0) goto L_0x0087
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.String r7 = androidx.datastore.core.MultiProcessCoordinator.DEADLOCK_ERROR_MESSAGE
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                r8 = 0
                r9 = 0
                boolean r2 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r2, (java.lang.CharSequence) r7, (boolean) r8, (int) r3, (java.lang.Object) r9)
                if (r2 != r4) goto L_0x0087
                r15.L$0 = r14
                r15.J$0 = r5
                r15.label = r4
                java.lang.Object r0 = kotlinx.coroutines.DelayKt.delay(r5, r15)
                if (r0 != r1) goto L_0x0084
                return r1
            L_0x0084:
                long r7 = (long) r3
                long r5 = r5 * r7
                goto L_0x0042
            L_0x0087:
                throw r0
            L_0x0088:
                java.nio.channels.FileChannel r7 = r14.getChannel()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r12 = 0
                r8 = 0
                java.nio.channels.FileLock r14 = r7.lock(r8, r10, r12)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r2)
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.Companion.getExclusiveFileLockWithRetryIfDeadlock(java.io.FileOutputStream, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    public Object getVersion(Continuation<? super Integer> continuation) {
        return this.lazySharedCounter.isInitialized() ? Boxing.boxInt(getSharedCounter().getValue()) : BuildersKt.withContext(this.context, new MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(this, (Continuation) null), continuation);
    }

    public Object incrementAndGetVersion(Continuation<? super Integer> continuation) {
        return this.lazySharedCounter.isInitialized() ? Boxing.boxInt(getSharedCounter().incrementAndGetValue()) : BuildersKt.withContext(this.context, new MultiProcessCoordinator$incrementAndGetVersion$$inlined$withLazyCounter$1(this, (Continuation) null), continuation);
    }
}
