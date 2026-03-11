package com.armmc.app.ui.profile;

import com.armmc.app.billing.BillingManager;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.ui.profile.SubscriptionFragment$setupUI$1$2", f = "SubscriptionFragment.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SubscriptionFragment.kt */
final class SubscriptionFragment$setupUI$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BillingManager $manager;
    int label;
    final /* synthetic */ SubscriptionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionFragment$setupUI$1$2(BillingManager billingManager, SubscriptionFragment subscriptionFragment, Continuation<? super SubscriptionFragment$setupUI$1$2> continuation) {
        super(2, continuation);
        this.$manager = billingManager;
        this.this$0 = subscriptionFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubscriptionFragment$setupUI$1$2(this.$manager, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SubscriptionFragment$setupUI$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<BillingManager.BillingState> billingState = this.$manager.getBillingState();
            final SubscriptionFragment subscriptionFragment = this.this$0;
            final BillingManager billingManager = this.$manager;
            this.label = 1;
            if (billingState.collect(new FlowCollector() {
                public final Object emit(BillingManager.BillingState billingState, Continuation<? super Unit> continuation) {
                    if (billingState instanceof BillingManager.BillingState.Unavailable) {
                        subscriptionFragment.getBinding().subscriptionPrice.setText("N/A");
                        subscriptionFragment.getBinding().billingInfo.setText("Google Play not available on this device");
                    } else if (billingState instanceof BillingManager.BillingState.Error) {
                        subscriptionFragment.getBinding().subscriptionPrice.setText("N/A");
                        subscriptionFragment.getBinding().billingInfo.setText("Unable to load pricing");
                    } else if (billingState instanceof BillingManager.BillingState.Disconnected) {
                        subscriptionFragment.getBinding().subscriptionPrice.setText("...");
                        subscriptionFragment.getBinding().billingInfo.setText("Connecting to Google Play...");
                    } else if (billingState instanceof BillingManager.BillingState.Connecting) {
                        subscriptionFragment.getBinding().subscriptionPrice.setText("...");
                        subscriptionFragment.getBinding().billingInfo.setText("Connecting to Google Play...");
                    } else if (!(billingState instanceof BillingManager.BillingState.Connected)) {
                        subscriptionFragment.getBinding().billingInfo.setText("Billed monthly. Cancel anytime.");
                    } else if (billingManager.getSubscriptionPrice().getValue() == null) {
                        subscriptionFragment.getBinding().billingInfo.setText("Loading price...");
                    } else {
                        subscriptionFragment.getBinding().billingInfo.setText("Billed monthly. Cancel anytime.");
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
