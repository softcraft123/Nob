package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.armmc.app.R;
import com.google.android.material.card.MaterialCardView;

public final class ItemOnboardingPage1Binding implements ViewBinding {
    public final TextView cpuLabel;
    public final ProgressBar cpuProgress;
    public final TextView cpuValue;
    public final TextView descriptionText;
    public final View divider1;
    public final View divider2;
    public final View divider3;
    public final View onlineIndicator;
    public final TextView playersLabel;
    public final TextView playersValue;
    private final ConstraintLayout rootView;
    public final MaterialCardView serverCard;
    public final ImageView serverIcon;
    public final TextView serverName;
    public final TextView serverVersion;
    public final TextView statusLabel;
    public final TextView statusValue;
    public final TextView titleText;

    private ItemOnboardingPage1Binding(ConstraintLayout constraintLayout, TextView textView, ProgressBar progressBar, TextView textView2, TextView textView3, View view, View view2, View view3, View view4, TextView textView4, TextView textView5, MaterialCardView materialCardView, ImageView imageView, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        this.rootView = constraintLayout;
        this.cpuLabel = textView;
        this.cpuProgress = progressBar;
        this.cpuValue = textView2;
        this.descriptionText = textView3;
        this.divider1 = view;
        this.divider2 = view2;
        this.divider3 = view3;
        this.onlineIndicator = view4;
        this.playersLabel = textView4;
        this.playersValue = textView5;
        this.serverCard = materialCardView;
        this.serverIcon = imageView;
        this.serverName = textView6;
        this.serverVersion = textView7;
        this.statusLabel = textView8;
        this.statusValue = textView9;
        this.titleText = textView10;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemOnboardingPage1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemOnboardingPage1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_onboarding_page1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        r1 = com.armmc.app.R.id.divider2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        r1 = com.armmc.app.R.id.divider3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        r1 = com.armmc.app.R.id.onlineIndicator;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.armmc.app.R.id.divider1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.armmc.app.databinding.ItemOnboardingPage1Binding bind(android.view.View r22) {
        /*
            r0 = r22
            int r1 = com.armmc.app.R.id.cpuLabel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x00c0
            int r1 = com.armmc.app.R.id.cpuProgress
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ProgressBar r6 = (android.widget.ProgressBar) r6
            if (r6 == 0) goto L_0x00c0
            int r1 = com.armmc.app.R.id.cpuValue
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x00c0
            int r1 = com.armmc.app.R.id.descriptionText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x00c0
            int r1 = com.armmc.app.R.id.divider1
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r9 == 0) goto L_0x00c0
            int r1 = com.armmc.app.R.id.divider2
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r10 == 0) goto L_0x00c0
            int r1 = com.armmc.app.R.id.divider3
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r11 == 0) goto L_0x00c0
            int r1 = com.armmc.app.R.id.onlineIndicator
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r12 == 0) goto L_0x00c0
            int r1 = com.armmc.app.R.id.playersLabel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x00c0
            int r1 = com.armmc.app.R.id.playersValue
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00c0
            int r1 = com.armmc.app.R.id.serverCard
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            com.google.android.material.card.MaterialCardView r15 = (com.google.android.material.card.MaterialCardView) r15
            if (r15 == 0) goto L_0x00c0
            int r1 = com.armmc.app.R.id.serverIcon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.ImageView r16 = (android.widget.ImageView) r16
            if (r16 == 0) goto L_0x00c0
            int r1 = com.armmc.app.R.id.serverName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00c0
            int r1 = com.armmc.app.R.id.serverVersion
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00c0
            int r1 = com.armmc.app.R.id.statusLabel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00c0
            int r1 = com.armmc.app.R.id.statusValue
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00c0
            int r1 = com.armmc.app.R.id.titleText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00c0
            com.armmc.app.databinding.ItemOnboardingPage1Binding r3 = new com.armmc.app.databinding.ItemOnboardingPage1Binding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r3
        L_0x00c0:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.databinding.ItemOnboardingPage1Binding.bind(android.view.View):com.armmc.app.databinding.ItemOnboardingPage1Binding");
    }
}
