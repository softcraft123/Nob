package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.armmc.app.R;
import com.google.android.material.card.MaterialCardView;

public final class DialogMotdBuilderBinding implements ViewBinding {
    public final Button applyButton;
    public final LinearLayout buttonsContainer;
    public final Button cancelButton;
    public final TextView charCountText;
    public final LinearLayout colorsContainer;
    public final TextView colorsLabel;
    public final HorizontalScrollView colorsScrollView;
    public final View handleBar;
    public final EditText motdEditText;
    public final TextView motdPreview;
    public final MaterialCardView previewCard;
    private final NestedScrollView rootView;
    public final LinearLayout stylesContainer;
    public final TextView stylesLabel;
    public final HorizontalScrollView stylesScrollView;
    public final TextView subtitleText;
    public final TextView titleText;

    private DialogMotdBuilderBinding(NestedScrollView nestedScrollView, Button button, LinearLayout linearLayout, Button button2, TextView textView, LinearLayout linearLayout2, TextView textView2, HorizontalScrollView horizontalScrollView, View view, EditText editText, TextView textView3, MaterialCardView materialCardView, LinearLayout linearLayout3, TextView textView4, HorizontalScrollView horizontalScrollView2, TextView textView5, TextView textView6) {
        this.rootView = nestedScrollView;
        this.applyButton = button;
        this.buttonsContainer = linearLayout;
        this.cancelButton = button2;
        this.charCountText = textView;
        this.colorsContainer = linearLayout2;
        this.colorsLabel = textView2;
        this.colorsScrollView = horizontalScrollView;
        this.handleBar = view;
        this.motdEditText = editText;
        this.motdPreview = textView3;
        this.previewCard = materialCardView;
        this.stylesContainer = linearLayout3;
        this.stylesLabel = textView4;
        this.stylesScrollView = horizontalScrollView2;
        this.subtitleText = textView5;
        this.titleText = textView6;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static DialogMotdBuilderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogMotdBuilderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_motd_builder, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r1 = com.armmc.app.R.id.handleBar;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.armmc.app.databinding.DialogMotdBuilderBinding bind(android.view.View r21) {
        /*
            r0 = r21
            int r1 = com.armmc.app.R.id.applyButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.Button r5 = (android.widget.Button) r5
            if (r5 == 0) goto L_0x00bd
            int r1 = com.armmc.app.R.id.buttonsContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x00bd
            int r1 = com.armmc.app.R.id.cancelButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.Button r7 = (android.widget.Button) r7
            if (r7 == 0) goto L_0x00bd
            int r1 = com.armmc.app.R.id.charCountText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x00bd
            int r1 = com.armmc.app.R.id.colorsContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x00bd
            int r1 = com.armmc.app.R.id.colorsLabel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x00bd
            int r1 = com.armmc.app.R.id.colorsScrollView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.HorizontalScrollView r11 = (android.widget.HorizontalScrollView) r11
            if (r11 == 0) goto L_0x00bd
            int r1 = com.armmc.app.R.id.handleBar
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r12 == 0) goto L_0x00bd
            int r1 = com.armmc.app.R.id.motdEditText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.EditText r13 = (android.widget.EditText) r13
            if (r13 == 0) goto L_0x00bd
            int r1 = com.armmc.app.R.id.motdPreview
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00bd
            int r1 = com.armmc.app.R.id.previewCard
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            com.google.android.material.card.MaterialCardView r15 = (com.google.android.material.card.MaterialCardView) r15
            if (r15 == 0) goto L_0x00bd
            int r1 = com.armmc.app.R.id.stylesContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.LinearLayout r16 = (android.widget.LinearLayout) r16
            if (r16 == 0) goto L_0x00bd
            int r1 = com.armmc.app.R.id.stylesLabel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00bd
            int r1 = com.armmc.app.R.id.stylesScrollView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.HorizontalScrollView r18 = (android.widget.HorizontalScrollView) r18
            if (r18 == 0) goto L_0x00bd
            int r1 = com.armmc.app.R.id.subtitleText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00bd
            int r1 = com.armmc.app.R.id.titleText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00bd
            com.armmc.app.databinding.DialogMotdBuilderBinding r3 = new com.armmc.app.databinding.DialogMotdBuilderBinding
            r4 = r0
            androidx.core.widget.NestedScrollView r4 = (androidx.core.widget.NestedScrollView) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r3
        L_0x00bd:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.databinding.DialogMotdBuilderBinding.bind(android.view.View):com.armmc.app.databinding.DialogMotdBuilderBinding");
    }
}
