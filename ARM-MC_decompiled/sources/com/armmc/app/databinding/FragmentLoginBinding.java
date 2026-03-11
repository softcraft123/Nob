package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class FragmentLoginBinding implements ViewBinding {
    public final ImageView backButton;
    public final MaterialButton continueGoogleButton;
    public final EditText emailInput;
    public final TextView emailLabel;
    public final TextView errorText;
    public final TextView forgotPasswordLink;
    public final ProgressBar loadingProgress;
    public final MaterialButton loginButton;
    public final ImageView logoText;
    public final LinearLayout orDivider;
    public final FrameLayout passwordContainer;
    public final EditText passwordInput;
    public final TextView passwordLabel;
    public final ImageView passwordToggle;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final LinearLayout signUpContainer;
    public final TextView signUpLink;
    public final TextView subtitleText;
    public final TextView titleText;

    private FragmentLoginBinding(ConstraintLayout constraintLayout, ImageView imageView, MaterialButton materialButton, EditText editText, TextView textView, TextView textView2, TextView textView3, ProgressBar progressBar, MaterialButton materialButton2, ImageView imageView2, LinearLayout linearLayout, FrameLayout frameLayout, EditText editText2, TextView textView4, ImageView imageView3, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.backButton = imageView;
        this.continueGoogleButton = materialButton;
        this.emailInput = editText;
        this.emailLabel = textView;
        this.errorText = textView2;
        this.forgotPasswordLink = textView3;
        this.loadingProgress = progressBar;
        this.loginButton = materialButton2;
        this.logoText = imageView2;
        this.orDivider = linearLayout;
        this.passwordContainer = frameLayout;
        this.passwordInput = editText2;
        this.passwordLabel = textView4;
        this.passwordToggle = imageView3;
        this.rootLayout = constraintLayout2;
        this.signUpContainer = linearLayout2;
        this.signUpLink = textView5;
        this.subtitleText = textView6;
        this.titleText = textView7;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_login, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentLoginBinding bind(View view) {
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
                            i = R.id.forgotPasswordLink;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                            if (textView3 != null) {
                                i = R.id.loadingProgress;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, i);
                                if (progressBar != null) {
                                    i = R.id.loginButton;
                                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view2, i);
                                    if (materialButton2 != null) {
                                        i = R.id.logoText;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                        if (imageView2 != null) {
                                            i = R.id.orDivider;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                            if (linearLayout != null) {
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
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) view2;
                                                                i = R.id.signUpContainer;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                if (linearLayout2 != null) {
                                                                    i = R.id.signUpLink;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                    if (textView5 != null) {
                                                                        i = R.id.subtitleText;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.titleText;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                            if (textView7 != null) {
                                                                                return new FragmentLoginBinding(constraintLayout, imageView, materialButton, editText, textView, textView2, textView3, progressBar, materialButton2, imageView2, linearLayout, frameLayout, editText2, textView4, imageView3, constraintLayout, linearLayout2, textView5, textView6, textView7);
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
