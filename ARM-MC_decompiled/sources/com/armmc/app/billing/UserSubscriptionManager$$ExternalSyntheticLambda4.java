package com.armmc.app.billing;

import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UserSubscriptionManager$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ FirebaseUser f$0;
    public final /* synthetic */ DocumentReference f$1;
    public final /* synthetic */ Function1 f$2;

    public /* synthetic */ UserSubscriptionManager$$ExternalSyntheticLambda4(FirebaseUser firebaseUser, DocumentReference documentReference, Function1 function1) {
        this.f$0 = firebaseUser;
        this.f$1 = documentReference;
        this.f$2 = function1;
    }

    public final Object invoke(Object obj) {
        return UserSubscriptionManager.initializeUserDocument$lambda$7(this.f$0, this.f$1, this.f$2, (DocumentSnapshot) obj);
    }
}
