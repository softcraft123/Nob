package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;
import com.google.android.material.button.MaterialButton;

public final class DialogSetupPermissionsBinding implements ViewBinding {
    public final View handleBar;
    private final NestedScrollView rootView;
    public final MaterialButton setupBatteryButton;
    public final MaterialButton setupContinueButton;
    public final ViewFlipper setupFlipper;
    public final MaterialButton setupNotificationButton;

    private DialogSetupPermissionsBinding(NestedScrollView nestedScrollView, View view, MaterialButton materialButton, MaterialButton materialButton2, ViewFlipper viewFlipper, MaterialButton materialButton3) {
        this.rootView = nestedScrollView;
        this.handleBar = view;
        this.setupBatteryButton = materialButton;
        this.setupContinueButton = materialButton2;
        this.setupFlipper = viewFlipper;
        this.setupNotificationButton = materialButton3;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static DialogSetupPermissionsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogSetupPermissionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_setup_permissions, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogSetupPermissionsBinding bind(View view) {
        int i = R.id.handleBar;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.setupBatteryButton;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.setupContinueButton;
                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton2 != null) {
                    i = R.id.setupFlipper;
                    ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, i);
                    if (viewFlipper != null) {
                        i = R.id.setupNotificationButton;
                        MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                        if (materialButton3 != null) {
                            return new DialogSetupPermissionsBinding((NestedScrollView) view, findChildViewById, materialButton, materialButton2, viewFlipper, materialButton3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
