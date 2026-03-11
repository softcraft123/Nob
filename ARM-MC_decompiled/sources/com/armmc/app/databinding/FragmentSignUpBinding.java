package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentSignUpBinding implements ViewBinding {
    public final ImageView backButton;
    public final MaterialButton continueGoogleButton;
    public final EditText emailInput;
    public final TextView emailLabel;
    public final TextView errorText;
    public final ProgressBar loadingProgress;
    public final TextView logInLink;
    public final LinearLayout loginContainer;
    public final ImageView logoText;
    public final LinearLayout orDivider;
    public final FrameLayout passwordContainer;
    public final EditText passwordInput;
    public final TextView passwordLabel;
    public final ImageView passwordToggle;
    public final TextView privacyLink;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final MaterialButton signUpButton;
    public final TextView subtitleText;
    public final LinearLayout termsContainer;
    public final TextView termsLink;
    public final TextView titleText;
    public final CheckBox tosCheckbox;

    private FragmentSignUpBinding(ConstraintLayout constraintLayout, ImageView imageView, MaterialButton materialButton, EditText editText, TextView textView, TextView textView2, ProgressBar progressBar, TextView textView3, LinearLayout linearLayout, ImageView imageView2, LinearLayout linearLayout2, FrameLayout frameLayout, EditText editText2, TextView textView4, ImageView imageView3, TextView textView5, ConstraintLayout constraintLayout2, MaterialButton materialButton2, TextView textView6, LinearLayout linearLayout3, TextView textView7, TextView textView8, CheckBox checkBox) {
        this.rootView = constraintLayout;
        this.backButton = imageView;
        this.continueGoogleButton = materialButton;
        this.emailInput = editText;
        this.emailLabel = textView;
        this.errorText = textView2;
        this.loadingProgress = progressBar;
        this.logInLink = textView3;
        this.loginContainer = linearLayout;
        this.logoText = imageView2;
        this.orDivider = linearLayout2;
        this.passwordContainer = frameLayout;
        this.passwordInput = editText2;
        this.passwordLabel = textView4;
        this.passwordToggle = imageView3;
        this.privacyLink = textView5;
        this.rootLayout = constraintLayout2;
        this.signUpButton = materialButton2;
        this.subtitleText = textView6;
        this.termsContainer = linearLayout3;
        this.termsLink = textView7;
        this.titleText = textView8;
        this.tosCheckbox = checkBox;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSignUpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSignUpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_sign_up, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentSignUpBinding bind(View view) {
        View view2 = view;
        int i = R.id.backButton;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
        if (imageView != null) {
            i = R.id.continueGoogleButton;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view2, i);
            if (materialButton != null) {
                i = R.id.emailInput;
                EditText editText = (EditText) ViewBindings.findChildViewById(view2, i);
                if (editText != null) {
                    i = R.id.emailLabel;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                    if (textView != null) {
                        i = R.id.errorText;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                        if (textView2 != null) {
                            i = R.id.loadingProgress;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, i);
                            if (progressBar != null) {
                                i = R.id.logInLink;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                if (textView3 != null) {
                                    i = R.id.loginContainer;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                    if (linearLayout != null) {
                                        i = R.id.logoText;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                        if (imageView2 != null) {
                                            i = R.id.orDivider;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                            if (linearLayout2 != null) {
                                                i = R.id.passwordContainer;
                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                                                if (frameLayout != null) {
                                                    i = R.id.passwordInput;
                                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view2, i);
                                                    if (editText2 != null) {
                                                        i = R.id.passwordLabel;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                        if (textView4 != null) {
                                                            i = R.id.passwordToggle;
                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                            if (imageView3 != null) {
                                                                i = R.id.privacyLink;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                if (textView5 != null) {
                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) view2;
                                                                    i = R.id.signUpButton;
                                                                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                                                                    if (materialButton2 != null) {
                                                                        i = R.id.subtitleText;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.termsContainer;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                            if (linearLayout3 != null) {
                                                                                i = R.id.termsLink;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.titleText;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.tosCheckbox;
                                                                                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view2, i);
                                                                                        if (checkBox != null) {
                                                                                            return new FragmentSignUpBinding(constraintLayout, imageView, materialButton, editText, textView, textView2, progressBar, textView3, linearLayout, imageView2, linearLayout2, frameLayout, editText2, textView4, imageView3, textView5, constraintLayout, materialButton2, textView6, linearLayout3, textView7, textView8, checkBox);
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
