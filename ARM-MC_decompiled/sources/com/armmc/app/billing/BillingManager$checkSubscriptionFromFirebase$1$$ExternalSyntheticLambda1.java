package com.armmc.app.billing;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BillingManager$checkSubscriptionFromFirebase$1$$ExternalSyntheticLambda1 implements OnSuccessListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ BillingManager$checkSubscriptionFromFirebase$1$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onSuccess(Object obj) {
        BillingManager$checkSubscriptionFromFirebase$1.invokeSuspend$lambda$1(this.f$0, obj);
    }
}
