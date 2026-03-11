package com.armmc.app.billing;

import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BillingManager$checkSubscriptionFromFirebase$1$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ BillingManager f$0;
    public final /* synthetic */ FirebaseUser f$1;
    public final /* synthetic */ Function1 f$2;

    public /* synthetic */ BillingManager$checkSubscriptionFromFirebase$1$$ExternalSyntheticLambda0(BillingManager billingManager, FirebaseUser firebaseUser, Function1 function1) {
        this.f$0 = billingManager;
        this.f$1 = firebaseUser;
        this.f$2 = function1;
    }

    public final Object invoke(Object obj) {
        return BillingManager$checkSubscriptionFromFirebase$1.invokeSuspend$lambda$0(this.f$0, this.f$1, this.f$2, (DocumentSnapshot) obj);
    }
}
