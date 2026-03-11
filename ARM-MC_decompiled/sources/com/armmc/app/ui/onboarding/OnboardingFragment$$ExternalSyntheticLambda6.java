package com.armmc.app.ui.onboarding;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OnboardingFragment$$ExternalSyntheticLambda6 implements OnCompleteListener {
    public final /* synthetic */ OnboardingFragment f$0;

    public /* synthetic */ OnboardingFragment$$ExternalSyntheticLambda6(OnboardingFragment onboardingFragment) {
        this.f$0 = onboardingFragment;
    }

    public final void onComplete(Task task) {
        OnboardingFragment.firebaseAuthWithGoogle$lambda$13(this.f$0, task);
    }
}
