package com.armmc.app.billing;

import com.google.android.gms.tasks.OnFailureListener;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UserSubscriptionManager$$ExternalSyntheticLambda6 implements OnFailureListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ UserSubscriptionManager$$ExternalSyntheticLambda6(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onFailure(Exception exc) {
        UserSubscriptionManager.initializeUserDocument$lambda$9(this.f$0, exc);
    }
}
