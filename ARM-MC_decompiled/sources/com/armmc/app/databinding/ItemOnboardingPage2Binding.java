package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;
import com.google.android.material.card.MaterialCardView;

public final class ItemOnboardingPage2Binding implements ViewBinding {
    public final MaterialCardView consoleCard;
    public final TextView descriptionText;
    public final MaterialCardView propertiesButton;
    public final ProgressBar ramProgress;
    public final TextView ramValue;
    public final MaterialCardView resourceCard;
    public final TextView resourceLabel;
    private final ConstraintLayout rootView;
    public final TextView titleText;

    private ItemOnboardingPage2Binding(ConstraintLayout constraintLayout, MaterialCardView materialCardView, TextView textView, MaterialCardView materialCardView2, ProgressBar progressBar, TextView textView2, MaterialCardView materialCardView3, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.consoleCard = materialCardView;
        this.descriptionText = textView;
        this.propertiesButton = materialCardView2;
        this.ramProgress = progressBar;
        this.ramValue = textView2;
        this.resourceCard = materialCardView3;
        this.resourceLabel = textView3;
        this.titleText = textView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemOnboardingPage2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemOnboardingPage2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_onboarding_page2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemOnboardingPage2Binding bind(View view) {
        int i = R.id.consoleCard;
        MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, i);
        if (materialCardView != null) {
            i = R.id.descriptionText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.propertiesButton;
                MaterialCardView materialCardView2 = (MaterialCardView) ViewBindings.findChildViewById(view, i);
                if (materialCardView2 != null) {
                    i = R.id.ramProgress;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                    if (progressBar != null) {
                        i = R.id.ramValue;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.resourceCard;
                            MaterialCardView materialCardView3 = (MaterialCardView) ViewBindings.findChildViewById(view, i);
                            if (materialCardView3 != null) {
                                i = R.id.resourceLabel;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.titleText;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        return new ItemOnboardingPage2Binding((ConstraintLayout) view, materialCardView, textView, materialCardView2, progressBar, textView2, materialCardView3, textView3, textView4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
