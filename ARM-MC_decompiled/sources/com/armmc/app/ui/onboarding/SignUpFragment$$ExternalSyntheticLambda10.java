package com.armmc.app.ui.onboarding;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SignUpFragment$$ExternalSyntheticLambda10 implements OnCompleteListener {
    public final /* synthetic */ SignUpFragment f$0;

    public /* synthetic */ SignUpFragment$$ExternalSyntheticLambda10(SignUpFragment signUpFragment) {
        this.f$0 = signUpFragment;
    }

    public final void onComplete(Task task) {
        SignUpFragment.firebaseAuthWithGoogle$lambda$13(this.f$0, task);
    }
}
