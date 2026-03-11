package com.armmc.app.billing;

import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UserSubscriptionManager$$ExternalSyntheticLambda10 implements Function1 {
    public final /* synthetic */ FirebaseUser f$0;
    public final /* synthetic */ Function1 f$1;

    public /* synthetic */ UserSubscriptionManager$$ExternalSyntheticLambda10(FirebaseUser firebaseUser, Function1 function1) {
        this.f$0 = firebaseUser;
        this.f$1 = function1;
    }

    public final Object invoke(Object obj) {
        return UserSubscriptionManager.initializeUserDocument$lambda$7$lambda$4(this.f$0, this.f$1, (Void) obj);
    }
}
