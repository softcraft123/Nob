package com.armmc.app.billing;

import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UserSubscriptionManager$$ExternalSyntheticLambda0 implements EventListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ UserSubscriptionManager$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
        UserSubscriptionManager.listenToSubscriptionStatus$lambda$13(this.f$0, (DocumentSnapshot) obj, firebaseFirestoreException);
    }
}
