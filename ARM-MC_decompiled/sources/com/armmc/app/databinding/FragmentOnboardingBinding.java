package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.armmc.app.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentOnboardingBinding implements ViewBinding {
    public final ImageView backButton;
    public final ImageView logoText;
    public final MaterialButton nextButton;
    public final ViewPager2 onboardingViewPager;
    public final LinearLayout pageIndicatorContainer;
    private final ConstraintLayout rootView;
    public final TextView skipButton;

    private FragmentOnboardingBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, MaterialButton materialButton, ViewPager2 viewPager2, LinearLayout linearLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.backButton = imageView;
        this.logoText = imageView2;
        this.nextButton = materialButton;
        this.onboardingViewPager = viewPager2;
        this.pageIndicatorContainer = linearLayout;
        this.skipButton = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentOnboardingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentOnboardingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentOnboardingBinding bind(View view) {
        int i = R.id.backButton;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.logoText;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.nextButton;
                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton != null) {
                    i = R.id.onboardingViewPager;
                    ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                    if (viewPager2 != null) {
                        i = R.id.pageIndicatorContainer;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.skipButton;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                return new FragmentOnboardingBinding((ConstraintLayout) view, imageView, imageView2, materialButton, viewPager2, linearLayout, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
