package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u0005H@¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u0005H¤@¢\u0006\u0002\u0010\tJ\u000e\u0010\u000b\u001a\u00020\u0005H@¢\u0006\u0002\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/datastore/core/RunOnce;", "", "()V", "didRun", "Lkotlinx/coroutines/CompletableDeferred;", "", "runMutex", "Lkotlinx/coroutines/sync/Mutex;", "awaitComplete", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doRun", "runIfNeeded", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DataStoreImpl.kt */
public abstract class RunOnce {
    private final CompletableDeferred<Unit> didRun = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    private final Mutex runMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    /* access modifiers changed from: protected */
    public abstract Object doRun(Continuation<? super Unit> continuation);

    public final Object awaitComplete(Continuation<? super Unit> continuation) {
        Object await = this.didRun.await(continuation);
        return await == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? await : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073 A[Catch:{ all -> 0x0095 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079 A[SYNTHETIC, Splitter:B:30:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runIfNeeded(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.datastore.core.RunOnce$runIfNeeded$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = (androidx.datastore.core.RunOnce$runIfNeeded$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = new androidx.datastore.core.RunOnce$runIfNeeded$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x004d
            if (r2 == r4) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.RunOnce r0 = (androidx.datastore.core.RunOnce) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0036 }
            goto L_0x0088
        L_0x0036:
            r7 = move-exception
            goto L_0x0098
        L_0x0038:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0040:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r4 = r0.L$0
            androidx.datastore.core.RunOnce r4 = (androidx.datastore.core.RunOnce) r4
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r2
            goto L_0x006b
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.CompletableDeferred<kotlin.Unit> r7 = r6.didRun
            boolean r7 = r7.isCompleted()
            if (r7 == 0) goto L_0x005b
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x005b:
            kotlinx.coroutines.sync.Mutex r7 = r6.runMutex
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r2 = r7.lock(r5, r0)
            if (r2 != r1) goto L_0x006a
            goto L_0x0085
        L_0x006a:
            r4 = r6
        L_0x006b:
            kotlinx.coroutines.CompletableDeferred<kotlin.Unit> r2 = r4.didRun     // Catch:{ all -> 0x0095 }
            boolean r2 = r2.isCompleted()     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x0079
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0095 }
            r7.unlock(r5)
            return r0
        L_0x0079:
            r0.L$0 = r4     // Catch:{ all -> 0x0095 }
            r0.L$1 = r7     // Catch:{ all -> 0x0095 }
            r0.label = r3     // Catch:{ all -> 0x0095 }
            java.lang.Object r0 = r4.doRun(r0)     // Catch:{ all -> 0x0095 }
            if (r0 != r1) goto L_0x0086
        L_0x0085:
            return r1
        L_0x0086:
            r1 = r7
            r0 = r4
        L_0x0088:
            kotlinx.coroutines.CompletableDeferred<kotlin.Unit> r7 = r0.didRun     // Catch:{ all -> 0x0036 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0036 }
            r7.complete(r0)     // Catch:{ all -> 0x0036 }
            r1.unlock(r5)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0095:
            r0 = move-exception
            r1 = r7
            r7 = r0
        L_0x0098:
            r1.unlock(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.RunOnce.runIfNeeded(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
