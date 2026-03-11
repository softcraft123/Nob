package com.armmc.app.billing;

import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UserSubscriptionManager$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ UserSubscriptionManager$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    public final Object invoke(Object obj) {
        return UserSubscriptionManager.getSubscriptionStatus$lambda$10(this.f$0, (DocumentSnapshot) obj);
    }
}
