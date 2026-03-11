package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.armmc.app.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public final class DialogAlphaWarningBinding implements ViewBinding {
    public final TextView buildVersionText;
    public final TextView descriptionText;
    public final View handleBar;
    public final MaterialCardView incompleteGameplayCard;
    public final MaterialCardView noMobAiCard;
    private final NestedScrollView rootView;
    public final TextView titleText;
    public final MaterialButton understandButton;
    public final CheckBox understandCheckbox;
    public final ImageView warningIcon;
    public final View warningIconBackground;

    private DialogAlphaWarningBinding(NestedScrollView nestedScrollView, TextView textView, TextView textView2, View view, MaterialCardView materialCardView, MaterialCardView materialCardView2, TextView textView3, MaterialButton materialButton, CheckBox checkBox, ImageView imageView, View view2) {
        this.rootView = nestedScrollView;
        this.buildVersionText = textView;
        this.descriptionText = textView2;
        this.handleBar = view;
        this.incompleteGameplayCard = materialCardView;
        this.noMobAiCard = materialCardView2;
        this.titleText = textView3;
        this.understandButton = materialButton;
        this.understandCheckbox = checkBox;
        this.warningIcon = imageView;
        this.warningIconBackground = view2;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static DialogAlphaWarningBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogAlphaWarningBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_alpha_warning, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0060, code lost:
        r0 = com.armmc.app.R.id.warningIconBackground;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.armmc.app.R.id.handleBar;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.armmc.app.databinding.DialogAlphaWarningBinding bind(android.view.View r14) {
        /*
            int r0 = com.armmc.app.R.id.buildVersionText
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0071
            int r0 = com.armmc.app.R.id.descriptionText
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0071
            int r0 = com.armmc.app.R.id.handleBar
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r6 == 0) goto L_0x0071
            int r0 = com.armmc.app.R.id.incompleteGameplayCard
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r7 = r1
            com.google.android.material.card.MaterialCardView r7 = (com.google.android.material.card.MaterialCardView) r7
            if (r7 == 0) goto L_0x0071
            int r0 = com.armmc.app.R.id.noMobAiCard
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r8 = r1
            com.google.android.material.card.MaterialCardView r8 = (com.google.android.material.card.MaterialCardView) r8
            if (r8 == 0) goto L_0x0071
            int r0 = com.armmc.app.R.id.titleText
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0071
            int r0 = com.armmc.app.R.id.understandButton
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r10 = r1
            com.google.android.material.button.MaterialButton r10 = (com.google.android.material.button.MaterialButton) r10
            if (r10 == 0) goto L_0x0071
            int r0 = com.armmc.app.R.id.understandCheckbox
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r11 = r1
            android.widget.CheckBox r11 = (android.widget.CheckBox) r11
            if (r11 == 0) goto L_0x0071
            int r0 = com.armmc.app.R.id.warningIcon
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r12 = r1
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x0071
            int r0 = com.armmc.app.R.id.warningIconBackground
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r13 == 0) goto L_0x0071
            com.armmc.app.databinding.DialogAlphaWarningBinding r2 = new com.armmc.app.databinding.DialogAlphaWarningBinding
            r3 = r14
            androidx.core.widget.NestedScrollView r3 = (androidx.core.widget.NestedScrollView) r3
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r2
        L_0x0071:
            android.content.res.Resources r14 = r14.getResources()
            java.lang.String r14 = r14.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r14 = r1.concat(r14)
            r0.<init>(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.databinding.DialogAlphaWarningBinding.bind(android.view.View):com.armmc.app.databinding.DialogAlphaWarningBinding");
    }
}
