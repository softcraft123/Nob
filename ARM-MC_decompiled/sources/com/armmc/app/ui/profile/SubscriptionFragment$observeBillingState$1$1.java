package com.armmc.app.ui.profile;

import android.widget.Toast;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.navigation.fragment.FragmentKt;
import com.armmc.app.billing.BillingManager;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.armmc.app.ui.profile.SubscriptionFragment$observeBillingState$1$1", f = "SubscriptionFragment.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SubscriptionFragment.kt */
final class SubscriptionFragment$observeBillingState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BillingManager $manager;
    int label;
    final /* synthetic */ SubscriptionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionFragment$observeBillingState$1$1(SubscriptionFragment subscriptionFragment, BillingManager billingManager, Continuation<? super SubscriptionFragment$observeBillingState$1$1> continuation) {
        super(2, continuation);
        this.this$0 = subscriptionFragment;
        this.$manager = billingManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubscriptionFragment$observeBillingState$1$1(this.this$0, this.$manager, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SubscriptionFragment$observeBillingState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.armmc.app.ui.profile.SubscriptionFragment$observeBillingState$1$1$1", f = "SubscriptionFragment.kt", i = {}, l = {192}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.armmc.app.ui.profile.SubscriptionFragment$observeBillingState$1$1$1  reason: invalid class name */
    /* compiled from: SubscriptionFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(billingManager, subscriptionFragment, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<BillingManager.BillingState> billingState = billingManager.getBillingState();
                final SubscriptionFragment subscriptionFragment = subscriptionFragment;
                final BillingManager billingManager = billingManager;
                this.label = 1;
                if (billingState.collect(new FlowCollector() {
                    public final Object emit(BillingManager.BillingState billingState, Continuation<? super Unit> continuation) {
                        if (billingState instanceof BillingManager.BillingState.PurchaseSuccess) {
                            Toast.makeText(subscriptionFragment.getContext(), "Thank you for becoming a Supporter! 🎉", 1).show();
                            billingManager.resetBillingState();
                            Boxing.boxBoolean(FragmentKt.findNavController(subscriptionFragment).navigateUp());
                        } else if (billingState instanceof BillingManager.BillingState.PurchaseError) {
                            Toast.makeText(subscriptionFragment.getContext(), ((BillingManager.BillingState.PurchaseError) billingState).getMessage(), 0).show();
                            subscriptionFragment.getBinding().subscribeButton.setEnabled(true);
                            subscriptionFragment.getBinding().subscribeButton.setText("Get Started Now");
                            billingManager.resetBillingState();
                        } else if (billingState instanceof BillingManager.BillingState.PurchaseInProgress) {
                            subscriptionFragment.getBinding().subscribeButton.setEnabled(false);
                            subscriptionFragment.getBinding().subscribeButton.setText("Processing...");
                        } else if (billingState instanceof BillingManager.BillingState.Unavailable) {
                            subscriptionFragment.getBinding().subscribeButton.setEnabled(false);
                            subscriptionFragment.getBinding().subscribeButton.setText("Not Available");
                            Toast.makeText(subscriptionFragment.getContext(), "Google Play is not available on this device. Please use a device with Google Play to subscribe.", 1).show();
                        } else if (billingState instanceof BillingManager.BillingState.Error) {
                            Toast.makeText(subscriptionFragment.getContext(), ((BillingManager.BillingState.Error) billingState).getMessage(), 0).show();
                            subscriptionFragment.getBinding().subscribeButton.setEnabled(true);
                            subscriptionFragment.getBinding().subscribeButton.setText("Get Started Now");
                        } else {
                            subscriptionFragment.getBinding().subscribeButton.setEnabled(true);
                            subscriptionFragment.getBinding().subscribeButton.setText("Get Started Now");
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

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Lifecycle.State state = Lifecycle.State.STARTED;
            final BillingManager billingManager = this.$manager;
            final SubscriptionFragment subscriptionFragment = this.this$0;
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1((Continuation<? super AnonymousClass1>) null), (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
