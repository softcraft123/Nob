package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentSubscriptionBinding implements ViewBinding {
    public final TextView bestValueBadge;
    public final TextView billingInfo;
    public final ImageView closeButton;
    public final LinearLayout feature1;
    public final LinearLayout feature2;
    public final LinearLayout feature3;
    public final LinearLayout footerLinks;
    public final ImageView headerBackground;
    public final TextView helpButton;
    public final TextView planTitle;
    public final LinearLayout priceContainer;
    public final ConstraintLayout pricingCard;
    public final TextView privacyPolicyButton;
    public final TextView restorePurchasesButton;
    private final NestedScrollView rootView;
    public final MaterialButton subscribeButton;
    public final TextView subscriptionPrice;
    public final TextView supporterStatusLabel;
    public final TextView termsOfServiceButton;
    public final TextView title;
    public final TextView unlockLabel;

    private FragmentSubscriptionBinding(NestedScrollView nestedScrollView, TextView textView, TextView textView2, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ImageView imageView2, TextView textView3, TextView textView4, LinearLayout linearLayout5, ConstraintLayout constraintLayout, TextView textView5, TextView textView6, MaterialButton materialButton, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = nestedScrollView;
        this.bestValueBadge = textView;
        this.billingInfo = textView2;
        this.closeButton = imageView;
        this.feature1 = linearLayout;
        this.feature2 = linearLayout2;
        this.feature3 = linearLayout3;
        this.footerLinks = linearLayout4;
        this.headerBackground = imageView2;
        this.helpButton = textView3;
        this.planTitle = textView4;
        this.priceContainer = linearLayout5;
        this.pricingCard = constraintLayout;
        this.privacyPolicyButton = textView5;
        this.restorePurchasesButton = textView6;
        this.subscribeButton = materialButton;
        this.subscriptionPrice = textView7;
        this.supporterStatusLabel = textView8;
        this.termsOfServiceButton = textView9;
        this.title = textView10;
        this.unlockLabel = textView11;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentSubscriptionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSubscriptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_subscription, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentSubscriptionBinding bind(View view) {
        View view2 = view;
        int i = R.id.bestValueBadge;
        TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
        if (textView != null) {
            i = R.id.billingInfo;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
            if (textView2 != null) {
                i = R.id.closeButton;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
                if (imageView != null) {
                    i = R.id.feature1;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                    if (linearLayout != null) {
                        i = R.id.feature2;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                        if (linearLayout2 != null) {
                            i = R.id.feature3;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                            if (linearLayout3 != null) {
                                i = R.id.footerLinks;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                if (linearLayout4 != null) {
                                    i = R.id.headerBackground;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                    if (imageView2 != null) {
                                        i = R.id.helpButton;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView3 != null) {
                                            i = R.id.planTitle;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                                            if (textView4 != null) {
                                                i = R.id.priceContainer;
                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                if (linearLayout5 != null) {
                                                    i = R.id.pricingCard;
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                    if (constraintLayout != null) {
                                                        i = R.id.privacyPolicyButton;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                        if (textView5 != null) {
                                                            i = R.id.restorePurchasesButton;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                            if (textView6 != null) {
                                                                i = R.id.subscribeButton;
                                                                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                                                                if (materialButton != null) {
                                                                    i = R.id.subscriptionPrice;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                    if (textView7 != null) {
                                                                        i = R.id.supporterStatusLabel;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                        if (textView8 != null) {
                                                                            i = R.id.termsOfServiceButton;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                            if (textView9 != null) {
                                                                                i = R.id.title;
                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                if (textView10 != null) {
                                                                                    i = R.id.unlockLabel;
                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                    if (textView11 != null) {
                                                                                        return new FragmentSubscriptionBinding((NestedScrollView) view2, textView, textView2, imageView, linearLayout, linearLayout2, linearLayout3, linearLayout4, imageView2, textView3, textView4, linearLayout5, constraintLayout, textView5, textView6, materialButton, textView7, textView8, textView9, textView10, textView11);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
