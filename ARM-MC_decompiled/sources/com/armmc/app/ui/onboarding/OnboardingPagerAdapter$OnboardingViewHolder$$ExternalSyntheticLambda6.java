package com.armmc.app.ui.onboarding;

import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.armmc.app.ui.onboarding.OnboardingPagerAdapter;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OnboardingPagerAdapter$OnboardingViewHolder$$ExternalSyntheticLambda6 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ SwitchMaterial f$2;
    public final /* synthetic */ TextView f$3;
    public final /* synthetic */ ImageView f$4;

    public /* synthetic */ OnboardingPagerAdapter$OnboardingViewHolder$$ExternalSyntheticLambda6(int i, int i2, SwitchMaterial switchMaterial, TextView textView, ImageView imageView) {
        this.f$0 = i;
        this.f$1 = i2;
        this.f$2 = switchMaterial;
        this.f$3 = textView;
        this.f$4 = imageView;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        OnboardingPagerAdapter.OnboardingViewHolder.bind$lambda$9(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, compoundButton, z);
    }
}
