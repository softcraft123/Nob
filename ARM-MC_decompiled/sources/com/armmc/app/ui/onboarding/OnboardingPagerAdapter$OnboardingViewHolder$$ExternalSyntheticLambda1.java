package com.armmc.app.ui.onboarding;

import android.animation.ValueAnimator;
import android.widget.TextView;
import com.armmc.app.ui.onboarding.OnboardingPagerAdapter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OnboardingPagerAdapter$OnboardingViewHolder$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ TextView f$0;

    public /* synthetic */ OnboardingPagerAdapter$OnboardingViewHolder$$ExternalSyntheticLambda1(TextView textView) {
        this.f$0 = textView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        OnboardingPagerAdapter.OnboardingViewHolder.bind$animateToggleState$lambda$6$lambda$5(this.f$0, valueAnimator);
    }
}
