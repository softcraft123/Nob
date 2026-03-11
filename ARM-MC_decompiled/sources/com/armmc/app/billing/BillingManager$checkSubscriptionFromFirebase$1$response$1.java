package com.armmc.app.billing;

import com.armmc.app.api.SubscriptionApiService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/armmc/app/api/SubscriptionApiService$SubscriptionStatusResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.billing.BillingManager$checkSubscriptionFromFirebase$1$response$1", f = "BillingManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BillingManager.kt */
final class BillingManager$checkSubscriptionFromFirebase$1$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SubscriptionApiService.SubscriptionStatusResponse>, Object> {
    final /* synthetic */ String $idToken;
    int label;
    final /* synthetic */ BillingManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingManager$checkSubscriptionFromFirebase$1$response$1(BillingManager billingManager, String str, Continuation<? super BillingManager$checkSubscriptionFromFirebase$1$response$1> continuation) {
        super(2, continuation);
        this.this$0 = billingManager;
        this.$idToken = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BillingManager$checkSubscriptionFromFirebase$1$response$1(this.this$0, this.$idToken, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SubscriptionApiService.SubscriptionStatusResponse> continuation) {
        return ((BillingManager$checkSubscriptionFromFirebase$1$response$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.subscriptionApiService.getSubscriptionStatus(this.$idToken);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
