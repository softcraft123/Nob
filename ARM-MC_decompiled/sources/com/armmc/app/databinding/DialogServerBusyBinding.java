package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.armmc.app.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public final class DialogServerBusyBinding implements ViewBinding {
    public final ImageView busyIcon;
    public final TextView descriptionText;
    public final MaterialButton dismissButton;
    public final View handleBar;
    public final View iconBackground;
    private final NestedScrollView rootView;
    public final MaterialCardView supporterBenefitCard;
    public final TextView titleText;
    public final MaterialButton upgradeButton;

    private DialogServerBusyBinding(NestedScrollView nestedScrollView, ImageView imageView, TextView textView, MaterialButton materialButton, View view, View view2, MaterialCardView materialCardView, TextView textView2, MaterialButton materialButton2) {
        this.rootView = nestedScrollView;
        this.busyIcon = imageView;
        this.descriptionText = textView;
        this.dismissButton = materialButton;
        this.handleBar = view;
        this.iconBackground = view2;
        this.supporterBenefitCard = materialCardView;
        this.titleText = textView2;
        this.upgradeButton = materialButton2;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static DialogServerBusyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogServerBusyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_server_busy, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.armmc.app.R.id.handleBar;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        r0 = com.armmc.app.R.id.iconBackground;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.armmc.app.databinding.DialogServerBusyBinding bind(android.view.View r12) {
        /*
            int r0 = com.armmc.app.R.id.busyIcon
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x005b
            int r0 = com.armmc.app.R.id.descriptionText
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x005b
            int r0 = com.armmc.app.R.id.dismissButton
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            com.google.android.material.button.MaterialButton r6 = (com.google.android.material.button.MaterialButton) r6
            if (r6 == 0) goto L_0x005b
            int r0 = com.armmc.app.R.id.handleBar
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r7 == 0) goto L_0x005b
            int r0 = com.armmc.app.R.id.iconBackground
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r8 == 0) goto L_0x005b
            int r0 = com.armmc.app.R.id.supporterBenefitCard
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r9 = r1
            com.google.android.material.card.MaterialCardView r9 = (com.google.android.material.card.MaterialCardView) r9
            if (r9 == 0) goto L_0x005b
            int r0 = com.armmc.app.R.id.titleText
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x005b
            int r0 = com.armmc.app.R.id.upgradeButton
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            com.google.android.material.button.MaterialButton r11 = (com.google.android.material.button.MaterialButton) r11
            if (r11 == 0) goto L_0x005b
            com.armmc.app.databinding.DialogServerBusyBinding r2 = new com.armmc.app.databinding.DialogServerBusyBinding
            r3 = r12
            androidx.core.widget.NestedScrollView r3 = (androidx.core.widget.NestedScrollView) r3
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r2
        L_0x005b:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.databinding.DialogServerBusyBinding.bind(android.view.View):com.armmc.app.databinding.DialogServerBusyBinding");
    }
}
