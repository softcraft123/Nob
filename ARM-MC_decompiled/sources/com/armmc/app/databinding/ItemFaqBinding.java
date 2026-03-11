package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.armmc.app.R;

public final class ItemFaqBinding implements ViewBinding {
    public final TextView answerText;
    public final ImageView chevronIcon;
    public final View divider;
    public final LinearLayout questionRow;
    public final TextView questionText;
    private final LinearLayout rootView;

    private ItemFaqBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, View view, LinearLayout linearLayout2, TextView textView2) {
        this.rootView = linearLayout;
        this.answerText = textView;
        this.chevronIcon = imageView;
        this.divider = view;
        this.questionRow = linearLayout2;
        this.questionText = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemFaqBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemFaqBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_faq, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.armmc.app.R.id.divider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.armmc.app.databinding.ItemFaqBinding bind(android.view.View r9) {
        /*
            int r0 = com.armmc.app.R.id.answerText
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x003d
            int r0 = com.armmc.app.R.id.chevronIcon
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x003d
            int r0 = com.armmc.app.R.id.divider
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r6 == 0) goto L_0x003d
            int r0 = com.armmc.app.R.id.questionRow
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x003d
            int r0 = com.armmc.app.R.id.questionText
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x003d
            com.armmc.app.databinding.ItemFaqBinding r2 = new com.armmc.app.databinding.ItemFaqBinding
            r3 = r9
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r2
        L_0x003d:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.databinding.ItemFaqBinding.bind(android.view.View):com.armmc.app.databinding.ItemFaqBinding");
    }
}
