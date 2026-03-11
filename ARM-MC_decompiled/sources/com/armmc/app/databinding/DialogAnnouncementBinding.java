package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.armmc.app.R;
import com.google.android.material.button.MaterialButton;

public final class DialogAnnouncementBinding implements ViewBinding {
    public final CardView announcementCard;
    public final MaterialButton announcementDismissButton;
    public final View announcementHeaderBar;
    public final ImageView announcementIcon;
    public final TextView announcementMessage;
    public final TextView announcementTitle;
    private final CardView rootView;

    private DialogAnnouncementBinding(CardView cardView, CardView cardView2, MaterialButton materialButton, View view, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = cardView;
        this.announcementCard = cardView2;
        this.announcementDismissButton = materialButton;
        this.announcementHeaderBar = view;
        this.announcementIcon = imageView;
        this.announcementMessage = textView;
        this.announcementTitle = textView2;
    }

    public CardView getRoot() {
        return this.rootView;
    }

    public static DialogAnnouncementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogAnnouncementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_announcement, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r0 = com.armmc.app.R.id.announcement_header_bar;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.armmc.app.databinding.DialogAnnouncementBinding bind(android.view.View r8) {
        /*
            r1 = r8
            androidx.cardview.widget.CardView r1 = (androidx.cardview.widget.CardView) r1
            int r0 = com.armmc.app.R.id.announcement_dismiss_button
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r3 = r2
            com.google.android.material.button.MaterialButton r3 = (com.google.android.material.button.MaterialButton) r3
            if (r3 == 0) goto L_0x003e
            int r0 = com.armmc.app.R.id.announcement_header_bar
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r4 == 0) goto L_0x003e
            int r0 = com.armmc.app.R.id.announcement_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x003e
            int r0 = com.armmc.app.R.id.announcement_message
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r2
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x003e
            int r0 = com.armmc.app.R.id.announcement_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r7 = r2
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x003e
            com.armmc.app.databinding.DialogAnnouncementBinding r0 = new com.armmc.app.databinding.DialogAnnouncementBinding
            r2 = r1
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r0
        L_0x003e:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.databinding.DialogAnnouncementBinding.bind(android.view.View):com.armmc.app.databinding.DialogAnnouncementBinding");
    }
}
