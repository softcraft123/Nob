package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentClaimSubdomainBinding implements ViewBinding {
    public final ImageView availabilityIcon;
    public final ProgressBar availabilityLoading;
    public final LinearLayout availabilityStatus;
    public final TextView availabilityText;
    public final MaterialButton cancelButton;
    public final MaterialButton claimButton;
    public final ImageView dnsIcon;
    public final ConstraintLayout dnsInfoCard;
    public final TextView dnsText;
    public final TextView dnsTitle;
    public final ImageView headerIcon;
    public final ConstraintLayout inputCard;
    public final TextView inputLabel;
    public final ProgressBar loadingIndicator;
    private final ScrollView rootView;
    public final EditText subdomainInput;
    public final LinearLayout subdomainInputContainer;
    public final TextView subtitle;
    public final TextView title;
    public final ConstraintLayout warningCard;
    public final ImageView warningIcon;
    public final TextView warningText;
    public final TextView warningTitle;

    private FragmentClaimSubdomainBinding(ScrollView scrollView, ImageView imageView, ProgressBar progressBar, LinearLayout linearLayout, TextView textView, MaterialButton materialButton, MaterialButton materialButton2, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView2, TextView textView3, ImageView imageView3, ConstraintLayout constraintLayout2, TextView textView4, ProgressBar progressBar2, EditText editText, LinearLayout linearLayout2, TextView textView5, TextView textView6, ConstraintLayout constraintLayout3, ImageView imageView4, TextView textView7, TextView textView8) {
        this.rootView = scrollView;
        this.availabilityIcon = imageView;
        this.availabilityLoading = progressBar;
        this.availabilityStatus = linearLayout;
        this.availabilityText = textView;
        this.cancelButton = materialButton;
        this.claimButton = materialButton2;
        this.dnsIcon = imageView2;
        this.dnsInfoCard = constraintLayout;
        this.dnsText = textView2;
        this.dnsTitle = textView3;
        this.headerIcon = imageView3;
        this.inputCard = constraintLayout2;
        this.inputLabel = textView4;
        this.loadingIndicator = progressBar2;
        this.subdomainInput = editText;
        this.subdomainInputContainer = linearLayout2;
        this.subtitle = textView5;
        this.title = textView6;
        this.warningCard = constraintLayout3;
        this.warningIcon = imageView4;
        this.warningText = textView7;
        this.warningTitle = textView8;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentClaimSubdomainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentClaimSubdomainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_claim_subdomain, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentClaimSubdomainBinding bind(View view) {
        View view2 = view;
        int i = R.id.availabilityIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
        if (imageView != null) {
            i = R.id.availabilityLoading;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, i);
            if (progressBar != null) {
                i = R.id.availabilityStatus;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                if (linearLayout != null) {
                    i = R.id.availabilityText;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                    if (textView != null) {
                        i = R.id.cancelButton;
                        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                        if (materialButton != null) {
                            i = R.id.claimButton;
                            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                            if (materialButton2 != null) {
                                i = R.id.dnsIcon;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                if (imageView2 != null) {
                                    i = R.id.dnsInfoCard;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                    if (constraintLayout != null) {
                                        i = R.id.dnsText;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView2 != null) {
                                            i = R.id.dnsTitle;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                            if (textView3 != null) {
                                                i = R.id.headerIcon;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                if (imageView3 != null) {
                                                    i = R.id.inputCard;
                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                    if (constraintLayout2 != null) {
                                                        i = R.id.inputLabel;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                        if (textView4 != null) {
                                                            i = R.id.loadingIndicator;
                                                            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, i);
                                                            if (progressBar2 != null) {
                                                                i = R.id.subdomainInput;
                                                                EditText editText = (EditText) ViewBindings.findChildViewById(view2, i);
                                                                if (editText != null) {
                                                                    i = R.id.subdomainInputContainer;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                    if (linearLayout2 != null) {
                                                                        i = R.id.subtitle;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                        if (textView5 != null) {
                                                                            i = R.id.title;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                            if (textView6 != null) {
                                                                                i = R.id.warningCard;
                                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                                                if (constraintLayout3 != null) {
                                                                                    i = R.id.warningIcon;
                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                                    if (imageView4 != null) {
                                                                                        i = R.id.warningText;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                        if (textView7 != null) {
                                                                                            i = R.id.warningTitle;
                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                            if (textView8 != null) {
                                                                                                return new FragmentClaimSubdomainBinding((ScrollView) view2, imageView, progressBar, linearLayout, textView, materialButton, materialButton2, imageView2, constraintLayout, textView2, textView3, imageView3, constraintLayout2, textView4, progressBar2, editText, linearLayout2, textView5, textView6, constraintLayout3, imageView4, textView7, textView8);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
