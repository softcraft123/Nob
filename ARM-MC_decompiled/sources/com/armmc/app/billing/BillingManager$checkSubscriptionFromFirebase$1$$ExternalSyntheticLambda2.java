package com.armmc.app.billing;

import com.google.android.gms.tasks.OnFailureListener;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BillingManager$checkSubscriptionFromFirebase$1$$ExternalSyntheticLambda2 implements OnFailureListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ BillingManager$checkSubscriptionFromFirebase$1$$ExternalSyntheticLambda2(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onFailure(Exception exc) {
        BillingManager$checkSubscriptionFromFirebase$1.invokeSuspend$lambda$2(this.f$0, exc);
    }
}
