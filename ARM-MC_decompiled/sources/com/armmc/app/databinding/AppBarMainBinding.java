package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;

public final class AppBarMainBinding implements ViewBinding {
    public final MaterialButton addServerButton;
    public final AppBarLayout appBarLayout;
    public final MaterialButton discordButton;
    private final CoordinatorLayout rootView;
    public final Toolbar toolbar;
    public final ImageView toolbarLogo;
    public final TextView toolbarTitle;
    public final LinearLayout tunnelRegionButton;
    public final TextView tunnelRegionText;

    private AppBarMainBinding(CoordinatorLayout coordinatorLayout, MaterialButton materialButton, AppBarLayout appBarLayout2, MaterialButton materialButton2, Toolbar toolbar2, ImageView imageView, TextView textView, LinearLayout linearLayout, TextView textView2) {
        this.rootView = coordinatorLayout;
        this.addServerButton = materialButton;
        this.appBarLayout = appBarLayout2;
        this.discordButton = materialButton2;
        this.toolbar = toolbar2;
        this.toolbarLogo = imageView;
        this.toolbarTitle = textView;
        this.tunnelRegionButton = linearLayout;
        this.tunnelRegionText = textView2;
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static AppBarMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AppBarMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.app_bar_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AppBarMainBinding bind(View view) {
        int i = R.id.addServerButton;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.appBarLayout;
            AppBarLayout appBarLayout2 = (AppBarLayout) ViewBindings.findChildViewById(view, i);
            if (appBarLayout2 != null) {
                i = R.id.discordButton;
                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton2 != null) {
                    i = R.id.toolbar;
                    Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, i);
                    if (toolbar2 != null) {
                        i = R.id.toolbar_logo;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.toolbar_title;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tunnelRegionButton;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.tunnelRegionText;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        return new AppBarMainBinding((CoordinatorLayout) view, materialButton, appBarLayout2, materialButton2, toolbar2, imageView, textView, linearLayout, textView2);
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
