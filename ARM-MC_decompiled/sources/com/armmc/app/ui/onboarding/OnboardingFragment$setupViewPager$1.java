package com.armmc.app.ui.onboarding;

import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/armmc/app/ui/onboarding/OnboardingFragment$setupViewPager$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: OnboardingFragment.kt */
public final class OnboardingFragment$setupViewPager$1 extends ViewPager2.OnPageChangeCallback {
    final /* synthetic */ OnboardingFragment this$0;

    OnboardingFragment$setupViewPager$1(OnboardingFragment onboardingFragment) {
        this.this$0 = onboardingFragment;
    }

    public void onPageSelected(int i) {
        this.this$0.updatePageIndicators(i);
        this.this$0.updateUIForPage(i);
    }
}
