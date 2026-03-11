package com.armmc.app.ui.onboarding;

import android.animation.ValueAnimator;
import android.widget.ImageView;
import com.armmc.app.ui.onboarding.OnboardingPagerAdapter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OnboardingPagerAdapter$OnboardingViewHolder$$ExternalSyntheticLambda2 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ImageView f$0;

    public /* synthetic */ OnboardingPagerAdapter$OnboardingViewHolder$$ExternalSyntheticLambda2(ImageView imageView) {
        this.f$0 = imageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        OnboardingPagerAdapter.OnboardingViewHolder.bind$animateToggleState$lambda$8$lambda$7(this.f$0, valueAnimator);
    }
}
