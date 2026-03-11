package com.armmc.app.ui.onboarding;

import android.animation.ValueAnimator;
import com.armmc.app.ui.onboarding.OnboardingPagerAdapter;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OnboardingPagerAdapter$OnboardingViewHolder$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ SwitchMaterial f$0;

    public /* synthetic */ OnboardingPagerAdapter$OnboardingViewHolder$$ExternalSyntheticLambda0(SwitchMaterial switchMaterial) {
        this.f$0 = switchMaterial;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        OnboardingPagerAdapter.OnboardingViewHolder.bind$animateToggleState$lambda$4$lambda$3(this.f$0, valueAnimator);
    }
}
