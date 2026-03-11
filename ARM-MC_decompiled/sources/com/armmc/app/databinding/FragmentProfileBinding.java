package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.google.android.material.imageview.ShapeableImageView;

public final class FragmentProfileBinding implements ViewBinding {
    public final ConstraintLayout accountStatusCard;
    public final TextView accountStatusTitle;
    public final ConstraintLayout authMethodCard;
    public final ImageView authMethodIcon;
    public final LinearLayout authMethodInfo;
    public final TextView authMethodTitle;
    public final ImageView authProviderIcon;
    public final TextView authProviderText;
    public final FrameLayout avatarContainer;
    public final TextView benefitDescription;
    public final ImageView benefitIcon;
    public final TextView benefitLabel;
    public final TextView benefitTitle;
    public final MaterialButton claimSubdomainButton;
    public final LinearLayout claimedSubdomainContainer;
    public final TextView claimedSubdomainText;
    public final MaterialButton faqButton;
    public final MaterialButton logoutButton;
    public final TextView methodLabel;
    public final TextView planTierLabel;
    public final ShapeableImageView profileAvatar;
    public final ConstraintLayout publicDomainBenefitCard;
    private final ScrollView rootView;
    public final ImageView sessionIcon;
    public final ConstraintLayout sessionLimitCard;
    public final TextView sessionLimitDescription;
    public final TextView sessionLimitTitle;
    public final ProgressBar sessionProgressBar;
    public final MaterialButton signUpBenefitButton;
    public final ConstraintLayout subdomainCard;
    public final ImageView subdomainIcon;
    public final TextView subdomainLabel;
    public final ProgressBar subdomainLoading;
    public final TextView subdomainTitle;
    public final TextView tierBadge;
    public final LinearLayout unclaimedSubdomainContainer;
    public final LinearLayout upgradeButton;
    public final TextView usageLabel;
    public final TextView userEmail;
    public final TextView userRole;
    public final TextView versionText;

    private FragmentProfileBinding(ScrollView scrollView, ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ImageView imageView, LinearLayout linearLayout, TextView textView2, ImageView imageView2, TextView textView3, FrameLayout frameLayout, TextView textView4, ImageView imageView3, TextView textView5, TextView textView6, MaterialButton materialButton, LinearLayout linearLayout2, TextView textView7, MaterialButton materialButton2, MaterialButton materialButton3, TextView textView8, TextView textView9, ShapeableImageView shapeableImageView, ConstraintLayout constraintLayout3, ImageView imageView4, ConstraintLayout constraintLayout4, TextView textView10, TextView textView11, ProgressBar progressBar, MaterialButton materialButton4, ConstraintLayout constraintLayout5, ImageView imageView5, TextView textView12, ProgressBar progressBar2, TextView textView13, TextView textView14, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView15, TextView textView16, TextView textView17, TextView textView18) {
        this.rootView = scrollView;
        this.accountStatusCard = constraintLayout;
        this.accountStatusTitle = textView;
        this.authMethodCard = constraintLayout2;
        this.authMethodIcon = imageView;
        this.authMethodInfo = linearLayout;
        this.authMethodTitle = textView2;
        this.authProviderIcon = imageView2;
        this.authProviderText = textView3;
        this.avatarContainer = frameLayout;
        this.benefitDescription = textView4;
        this.benefitIcon = imageView3;
        this.benefitLabel = textView5;
        this.benefitTitle = textView6;
        this.claimSubdomainButton = materialButton;
        this.claimedSubdomainContainer = linearLayout2;
        this.claimedSubdomainText = textView7;
        this.faqButton = materialButton2;
        this.logoutButton = materialButton3;
        this.methodLabel = textView8;
        this.planTierLabel = textView9;
        this.profileAvatar = shapeableImageView;
        this.publicDomainBenefitCard = constraintLayout3;
        this.sessionIcon = imageView4;
        this.sessionLimitCard = constraintLayout4;
        this.sessionLimitDescription = textView10;
        this.sessionLimitTitle = textView11;
        this.sessionProgressBar = progressBar;
        this.signUpBenefitButton = materialButton4;
        this.subdomainCard = constraintLayout5;
        this.subdomainIcon = imageView5;
        this.subdomainLabel = textView12;
        this.subdomainLoading = progressBar2;
        this.subdomainTitle = textView13;
        this.tierBadge = textView14;
        this.unclaimedSubdomainContainer = linearLayout3;
        this.upgradeButton = linearLayout4;
        this.usageLabel = textView15;
        this.userEmail = textView16;
        this.userRole = textView17;
        this.versionText = textView18;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentProfileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_profile, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentProfileBinding bind(View view) {
        View view2 = view;
        int i = R.id.accountStatusCard;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
        if (constraintLayout != null) {
            i = R.id.accountStatusTitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
            if (textView != null) {
                i = R.id.authMethodCard;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                if (constraintLayout2 != null) {
                    i = R.id.authMethodIcon;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
                    if (imageView != null) {
                        i = R.id.authMethodInfo;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                        if (linearLayout != null) {
                            i = R.id.authMethodTitle;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                            if (textView2 != null) {
                                i = R.id.authProviderIcon;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                if (imageView2 != null) {
                                    i = R.id.authProviderText;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                    if (textView3 != null) {
                                        i = R.id.avatarContainer;
                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                                        if (frameLayout != null) {
                                            i = R.id.benefitDescription;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                                            if (textView4 != null) {
                                                i = R.id.benefitIcon;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                if (imageView3 != null) {
                                                    i = R.id.benefitLabel;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                    if (textView5 != null) {
                                                        i = R.id.benefitTitle;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                        if (textView6 != null) {
                                                            i = R.id.claimSubdomainButton;
                                                            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                                                            if (materialButton != null) {
                                                                i = R.id.claimedSubdomainContainer;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                if (linearLayout2 != null) {
                                                                    i = R.id.claimedSubdomainText;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                    if (textView7 != null) {
                                                                        i = R.id.faqButton;
                                                                        MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                                                                        if (materialButton2 != null) {
                                                                            i = R.id.logoutButton;
                                                                            MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                                                                            if (materialButton3 != null) {
                                                                                i = R.id.methodLabel;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.planTierLabel;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                    if (textView9 != null) {
                                                                                        i = R.id.profileAvatar;
                                                                                        ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(view2, i);
                                                                                        if (shapeableImageView != null) {
                                                                                            i = R.id.publicDomainBenefitCard;
                                                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                                                            if (constraintLayout3 != null) {
                                                                                                i = R.id.sessionIcon;
                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                                                if (imageView4 != null) {
                                                                                                    i = R.id.sessionLimitCard;
                                                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                                                                    if (constraintLayout4 != null) {
                                                                                                        i = R.id.sessionLimitDescription;
                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                        if (textView10 != null) {
                                                                                                            i = R.id.sessionLimitTitle;
                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                            if (textView11 != null) {
                                                                                                                i = R.id.sessionProgressBar;
                                                                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, i);
                                                                                                                if (progressBar != null) {
                                                                                                                    i = R.id.signUpBenefitButton;
                                                                                                                    MaterialButton materialButton4 = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                                                                                                                    if (materialButton4 != null) {
                                                                                                                        i = R.id.subdomainCard;
                                                                                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                                                                                        if (constraintLayout5 != null) {
                                                                                                                            i = R.id.subdomainIcon;
                                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                                                                            if (imageView5 != null) {
                                                                                                                                i = R.id.subdomainLabel;
                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                if (textView12 != null) {
                                                                                                                                    i = R.id.subdomainLoading;
                                                                                                                                    ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, i);
                                                                                                                                    if (progressBar2 != null) {
                                                                                                                                        i = R.id.subdomainTitle;
                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                        if (textView13 != null) {
                                                                                                                                            i = R.id.tierBadge;
                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                            if (textView14 != null) {
                                                                                                                                                i = R.id.unclaimedSubdomainContainer;
                                                                                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                if (linearLayout3 != null) {
                                                                                                                                                    i = R.id.upgradeButton;
                                                                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                    if (linearLayout4 != null) {
                                                                                                                                                        i = R.id.usageLabel;
                                                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                        if (textView15 != null) {
                                                                                                                                                            i = R.id.userEmail;
                                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                i = R.id.userRole;
                                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                if (textView17 != null) {
                                                                                                                                                                    i = R.id.versionText;
                                                                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                    if (textView18 != null) {
                                                                                                                                                                        return new FragmentProfileBinding((ScrollView) view2, constraintLayout, textView, constraintLayout2, imageView, linearLayout, textView2, imageView2, textView3, frameLayout, textView4, imageView3, textView5, textView6, materialButton, linearLayout2, textView7, materialButton2, materialButton3, textView8, textView9, shapeableImageView, constraintLayout3, imageView4, constraintLayout4, textView10, textView11, progressBar, materialButton4, constraintLayout5, imageView5, textView12, progressBar2, textView13, textView14, linearLayout3, linearLayout4, textView15, textView16, textView17, textView18);
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
