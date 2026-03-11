package com.armmc.app;

import com.google.firebase.auth.FirebaseAuth;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda0 implements FirebaseAuth.AuthStateListener {
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda0(MainActivity mainActivity) {
        this.f$0 = mainActivity;
    }

    public final void onAuthStateChanged(FirebaseAuth firebaseAuth) {
        MainActivity.authStateListener$lambda$5(this.f$0, firebaseAuth);
    }
}
