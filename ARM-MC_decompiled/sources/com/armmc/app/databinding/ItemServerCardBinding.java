package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.armmc.app.R;
import com.armmc.app.ui.components.SparklineView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public final class ItemServerCardBinding implements ViewBinding {
    public final Barrier buttonTopBarrier;
    public final TextView cpuPercentage;
    public final ProgressBar cpuProgress;
    public final LinearLayout cpuUsageSection;
    public final MaterialButton deleteButton;
    public final MaterialButton ipAddressButton;
    public final SparklineView ramSparkline;
    public final TextView ramUsageLabel;
    public final MaterialCardView ramUsageSection;
    public final TextView ramUsageValue;
    public final ImageView ramWarningIcon;
    public final ConstraintLayout resourceUsageContainer;
    private final MaterialCardView rootView;
    public final ImageView serverIcon;
    public final MaterialCardView serverIconCard;
    public final TextView serverInfo;
    public final TextView serverName;
    public final MaterialButton settingsButton;
    public final MaterialButton startButton;
    public final View statusIndicator;
    public final TextView statusText;

    private ItemServerCardBinding(MaterialCardView materialCardView, Barrier barrier, TextView textView, ProgressBar progressBar, LinearLayout linearLayout, MaterialButton materialButton, MaterialButton materialButton2, SparklineView sparklineView, TextView textView2, MaterialCardView materialCardView2, TextView textView3, ImageView imageView, ConstraintLayout constraintLayout, ImageView imageView2, MaterialCardView materialCardView3, TextView textView4, TextView textView5, MaterialButton materialButton3, MaterialButton materialButton4, View view, TextView textView6) {
        this.rootView = materialCardView;
        this.buttonTopBarrier = barrier;
        this.cpuPercentage = textView;
        this.cpuProgress = progressBar;
        this.cpuUsageSection = linearLayout;
        this.deleteButton = materialButton;
        this.ipAddressButton = materialButton2;
        this.ramSparkline = sparklineView;
        this.ramUsageLabel = textView2;
        this.ramUsageSection = materialCardView2;
        this.ramUsageValue = textView3;
        this.ramWarningIcon = imageView;
        this.resourceUsageContainer = constraintLayout;
        this.serverIcon = imageView2;
        this.serverIconCard = materialCardView3;
        this.serverInfo = textView4;
        this.serverName = textView5;
        this.settingsButton = materialButton3;
        this.startButton = materialButton4;
        this.statusIndicator = view;
        this.statusText = textView6;
    }

    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static ItemServerCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemServerCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_server_card, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cf, code lost:
        r1 = com.armmc.app.R.id.statusIndicator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.armmc.app.databinding.ItemServerCardBinding bind(android.view.View r25) {
        /*
            r0 = r25
            int r1 = com.armmc.app.R.id.buttonTopBarrier
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.Barrier r5 = (androidx.constraintlayout.widget.Barrier) r5
            if (r5 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.cpuPercentage
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.cpuProgress
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ProgressBar r7 = (android.widget.ProgressBar) r7
            if (r7 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.cpuUsageSection
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.deleteButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.google.android.material.button.MaterialButton r9 = (com.google.android.material.button.MaterialButton) r9
            if (r9 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.ipAddressButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            com.google.android.material.button.MaterialButton r10 = (com.google.android.material.button.MaterialButton) r10
            if (r10 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.ramSparkline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            com.armmc.app.ui.components.SparklineView r11 = (com.armmc.app.ui.components.SparklineView) r11
            if (r11 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.ramUsageLabel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.ramUsageSection
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            com.google.android.material.card.MaterialCardView r13 = (com.google.android.material.card.MaterialCardView) r13
            if (r13 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.ramUsageValue
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.ramWarningIcon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            if (r15 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.resourceUsageContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.constraintlayout.widget.ConstraintLayout r16 = (androidx.constraintlayout.widget.ConstraintLayout) r16
            if (r16 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.serverIcon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.ImageView r17 = (android.widget.ImageView) r17
            if (r17 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.serverIconCard
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            com.google.android.material.card.MaterialCardView r18 = (com.google.android.material.card.MaterialCardView) r18
            if (r18 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.serverInfo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.serverName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.settingsButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            com.google.android.material.button.MaterialButton r21 = (com.google.android.material.button.MaterialButton) r21
            if (r21 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.startButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            com.google.android.material.button.MaterialButton r22 = (com.google.android.material.button.MaterialButton) r22
            if (r22 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.statusIndicator
            android.view.View r23 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r23 == 0) goto L_0x00ec
            int r1 = com.armmc.app.R.id.statusText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x00ec
            com.armmc.app.databinding.ItemServerCardBinding r3 = new com.armmc.app.databinding.ItemServerCardBinding
            r4 = r0
            com.google.android.material.card.MaterialCardView r4 = (com.google.android.material.card.MaterialCardView) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r3
        L_0x00ec:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.databinding.ItemServerCardBinding.bind(android.view.View):com.armmc.app.databinding.ItemServerCardBinding");
    }
}
