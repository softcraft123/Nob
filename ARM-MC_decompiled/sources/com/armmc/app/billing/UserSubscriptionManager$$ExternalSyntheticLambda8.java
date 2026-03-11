package com.armmc.app.billing;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UserSubscriptionManager$$ExternalSyntheticLambda8 implements OnSuccessListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ UserSubscriptionManager$$ExternalSyntheticLambda8(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onSuccess(Object obj) {
        UserSubscriptionManager.initializeUserDocument$lambda$7$lambda$2(this.f$0, obj);
    }
}
