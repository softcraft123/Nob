package com.armmc.app.ui.onboarding;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LoginFragment$$ExternalSyntheticLambda0 implements OnCompleteListener {
    public final /* synthetic */ LoginFragment f$0;

    public /* synthetic */ LoginFragment$$ExternalSyntheticLambda0(LoginFragment loginFragment) {
        this.f$0 = loginFragment;
    }

    public final void onComplete(Task task) {
        LoginFragment.attemptLogin$lambda$10(this.f$0, task);
    }
}
