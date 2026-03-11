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
import com.armmc.app.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.switchmaterial.SwitchMaterial;

public final class ItemOnboardingPage3Binding implements ViewBinding {
    public final MaterialCardView accessCard;
    public final MaterialButton continueGoogleButton;
    public final TextView copyHint;
    public final TextView descriptionText;
    public final LinearLayout onlineStatusRow;
    public final LinearLayout page3Indicators;
    public final TextView publicAccessLabel;
    public final SwitchMaterial publicAccessToggle;
    public final TextView publicUrlLabel;
    private final ConstraintLayout rootView;
    public final TextView serverStatusLabel;
    public final MaterialButton signUpEmailButton;
    public final TextView skipForNowText;
    public final TextView titleText;
    public final MaterialCardView urlCard;
    public final ImageView urlIcon;
    public final TextView urlText;

    private ItemOnboardingPage3Binding(ConstraintLayout constraintLayout, MaterialCardView materialCardView, MaterialButton materialButton, TextView textView, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView3, SwitchMaterial switchMaterial, TextView textView4, TextView textView5, MaterialButton materialButton2, TextView textView6, TextView textView7, MaterialCardView materialCardView2, ImageView imageView, TextView textView8) {
        this.rootView = constraintLayout;
        this.accessCard = materialCardView;
        this.continueGoogleButton = materialButton;
        this.copyHint = textView;
        this.descriptionText = textView2;
        this.onlineStatusRow = linearLayout;
        this.page3Indicators = linearLayout2;
        this.publicAccessLabel = textView3;
        this.publicAccessToggle = switchMaterial;
        this.publicUrlLabel = textView4;
        this.serverStatusLabel = textView5;
        this.signUpEmailButton = materialButton2;
        this.skipForNowText = textView6;
        this.titleText = textView7;
        this.urlCard = materialCardView2;
        this.urlIcon = imageView;
        this.urlText = textView8;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemOnboardingPage3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemOnboardingPage3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_onboarding_page3, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemOnboardingPage3Binding bind(View view) {
        View view2 = view;
        int i = R.id.accessCard;
        MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view2, i);
        if (materialCardView != null) {
            i = R.id.continueGoogleButton;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view2, i);
            if (materialButton != null) {
                i = R.id.copyHint;
                TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                if (textView != null) {
                    i = R.id.descriptionText;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                    if (textView2 != null) {
                        i = R.id.onlineStatusRow;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                        if (linearLayout != null) {
                            i = R.id.page3Indicators;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                            if (linearLayout2 != null) {
                                i = R.id.publicAccessLabel;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                if (textView3 != null) {
                                    i = R.id.publicAccessToggle;
                                    SwitchMaterial switchMaterial = (SwitchMaterial) ViewBindings.findChildViewById(view2, i);
                                    if (switchMaterial != null) {
                                        i = R.id.publicUrlLabel;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView4 != null) {
                                            i = R.id.serverStatusLabel;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                            if (textView5 != null) {
                                                i = R.id.signUpEmailButton;
                                                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                                                if (materialButton2 != null) {
                                                    i = R.id.skipForNowText;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                    if (textView6 != null) {
                                                        i = R.id.titleText;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                        if (textView7 != null) {
                                                            i = R.id.urlCard;
                                                            MaterialCardView materialCardView2 = (MaterialCardView) ViewBindings.findChildViewById(view2, i);
                                                            if (materialCardView2 != null) {
                                                                i = R.id.urlIcon;
                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                if (imageView != null) {
                                                                    i = R.id.urlText;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                    if (textView8 != null) {
                                                                        return new ItemOnboardingPage3Binding((ConstraintLayout) view2, materialCardView, materialButton, textView, textView2, linearLayout, linearLayout2, textView3, switchMaterial, textView4, textView5, materialButton2, textView6, textView7, materialCardView2, imageView, textView8);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
