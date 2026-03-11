package com.armmc.app.billing;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.billing.BillingManager$onBillingSetupFinished$1", f = "BillingManager.kt", i = {}, l = {105, 106}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BillingManager.kt */
final class BillingManager$onBillingSetupFinished$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BillingManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingManager$onBillingSetupFinished$1(BillingManager billingManager, Continuation<? super BillingManager$onBillingSetupFinished$1> continuation) {
        super(2, continuation);
        this.this$0 = billingManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BillingManager$onBillingSetupFinished$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BillingManager$onBillingSetupFinished$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        if (r4.this$0.queryExistingPurchases(r4) == r0) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        if (r4.this$0.querySubscriptionProducts(r4) == r0) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003d
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x002f
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r5)
            com.armmc.app.billing.BillingManager r5 = r4.this$0
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4.label = r3
            java.lang.Object r5 = r5.querySubscriptionProducts(r1)
            if (r5 != r0) goto L_0x002f
            goto L_0x003c
        L_0x002f:
            com.armmc.app.billing.BillingManager r5 = r4.this$0
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4.label = r2
            java.lang.Object r5 = r5.queryExistingPurchases(r1)
            if (r5 != r0) goto L_0x003d
        L_0x003c:
            return r0
        L_0x003d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.billing.BillingManager$onBillingSetupFinished$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
