package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0, 0}, l = {123}, m = "invokeSuspend", n = {"second", "collectJob"}, s = {"L$0", "L$1"})
/* compiled from: Combine.kt */
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T1> $flow;
    final /* synthetic */ Flow<T2> $flow2;
    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$1$1(Flow<? extends T2> flow, Flow<? extends T1> flow2, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super CombineKt$zipImpl$1$1> continuation) {
        super(2, continuation);
        this.$flow2 = flow;
        this.$flow = flow2;
        this.$this_unsafeFlow = flowCollector;
        this.$transform = function3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.$flow2, this.$flow, this.$this_unsafeFlow, this.$transform, continuation);
        combineKt$zipImpl$1$1.L$0 = obj;
        return combineKt$zipImpl$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$zipImpl$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: kotlinx.coroutines.CompletableJob} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a8, code lost:
        r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ab, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ac, code lost:
        r5 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ab A[ExcHandler: all (th java.lang.Throwable), Splitter:B:11:0x005b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            r23 = this;
            r1 = r23
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x002b
            if (r2 != r3) goto L_0x0023
            java.lang.Object r0 = r1.L$1
            r2 = r0
            kotlinx.coroutines.CompletableJob r2 = (kotlinx.coroutines.CompletableJob) r2
            java.lang.Object r0 = r1.L$0
            r5 = r0
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            kotlin.ResultKt.throwOnFailure(r24)     // Catch:{ AbortFlowException -> 0x0020 }
            goto L_0x00a3
        L_0x001d:
            r0 = move-exception
            goto L_0x00b7
        L_0x0020:
            r0 = move-exception
            goto L_0x00b0
        L_0x0023:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r24)
            java.lang.Object r2 = r1.L$0
            r5 = r2
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1 r2 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1
            kotlinx.coroutines.flow.Flow<T2> r6 = r1.$flow2
            r2.<init>(r6, r4)
            r8 = r2
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            kotlinx.coroutines.channels.ReceiveChannel r15 = kotlinx.coroutines.channels.ProduceKt.produce$default(r5, r6, r7, r8, r9, r10)
            kotlinx.coroutines.CompletableJob r2 = kotlinx.coroutines.JobKt.Job$default((kotlinx.coroutines.Job) r4, (int) r3, (java.lang.Object) r4)
            java.lang.String r6 = "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15, r6)
            r6 = r15
            kotlinx.coroutines.channels.SendChannel r6 = (kotlinx.coroutines.channels.SendChannel) r6
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$1 r7 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$1
            r7.<init>(r2)
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r6.invokeOnClose(r7)
            kotlin.coroutines.CoroutineContext r13 = r5.getCoroutineContext()     // Catch:{ AbortFlowException -> 0x00ae, all -> 0x00ab }
            java.lang.Object r14 = kotlinx.coroutines.internal.ThreadContextKt.threadContextElements(r13)     // Catch:{ AbortFlowException -> 0x00ae, all -> 0x00ab }
            kotlin.coroutines.CoroutineContext r5 = r5.getCoroutineContext()     // Catch:{ AbortFlowException -> 0x00ae, all -> 0x00ab }
            r6 = r2
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6     // Catch:{ AbortFlowException -> 0x00ae, all -> 0x00ab }
            kotlin.coroutines.CoroutineContext r5 = r5.plus(r6)     // Catch:{ AbortFlowException -> 0x00ae, all -> 0x00ab }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ AbortFlowException -> 0x00ae, all -> 0x00ab }
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2 r11 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2     // Catch:{ AbortFlowException -> 0x00ae, all -> 0x00ab }
            kotlinx.coroutines.flow.Flow<T1> r12 = r1.$flow     // Catch:{ AbortFlowException -> 0x00ae, all -> 0x00ab }
            kotlinx.coroutines.flow.FlowCollector<R> r7 = r1.$this_unsafeFlow     // Catch:{ AbortFlowException -> 0x00ae, all -> 0x00ab }
            kotlin.jvm.functions.Function3<T1, T2, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r8 = r1.$transform     // Catch:{ AbortFlowException -> 0x00ae, all -> 0x00ab }
            r19 = 0
            r18 = r2
            r16 = r7
            r17 = r8
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ AbortFlowException -> 0x00a7, all -> 0x00ab }
            r19 = r11
            kotlin.jvm.functions.Function2 r19 = (kotlin.jvm.functions.Function2) r19     // Catch:{ AbortFlowException -> 0x00ae, all -> 0x00ab }
            r20 = r1
            kotlin.coroutines.Continuation r20 = (kotlin.coroutines.Continuation) r20     // Catch:{ AbortFlowException -> 0x00ae, all -> 0x00ab }
            r1.L$0 = r15     // Catch:{ AbortFlowException -> 0x00ae, all -> 0x00ab }
            r1.L$1 = r2     // Catch:{ AbortFlowException -> 0x00ae, all -> 0x00ab }
            r1.label = r3     // Catch:{ AbortFlowException -> 0x00ae, all -> 0x00ab }
            r18 = 0
            r21 = 4
            r22 = 0
            r16 = r5
            r17 = r6
            java.lang.Object r2 = kotlinx.coroutines.flow.internal.ChannelFlowKt.withContextUndispatched$default(r16, r17, r18, r19, r20, r21, r22)     // Catch:{ AbortFlowException -> 0x00ae, all -> 0x00ab }
            if (r2 != r0) goto L_0x00a2
            return r0
        L_0x00a2:
            r5 = r15
        L_0x00a3:
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default((kotlinx.coroutines.channels.ReceiveChannel) r5, (java.util.concurrent.CancellationException) r4, (int) r3, (java.lang.Object) r4)
            goto L_0x00b4
        L_0x00a7:
            r0 = move-exception
            r2 = r18
            goto L_0x00af
        L_0x00ab:
            r0 = move-exception
            r5 = r15
            goto L_0x00b7
        L_0x00ae:
            r0 = move-exception
        L_0x00af:
            r5 = r15
        L_0x00b0:
            kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(r0, r2)     // Catch:{ all -> 0x001d }
            goto L_0x00a3
        L_0x00b4:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00b7:
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default((kotlinx.coroutines.channels.ReceiveChannel) r5, (java.util.concurrent.CancellationException) r4, (int) r3, (java.lang.Object) r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
