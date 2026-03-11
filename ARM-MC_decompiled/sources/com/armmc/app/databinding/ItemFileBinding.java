package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;
import com.google.android.material.card.MaterialCardView;

public final class ItemFileBinding implements ViewBinding {
    public final ImageView fileIcon;
    public final TextView fileName;
    public final TextView fileSubtitle;
    public final FrameLayout iconContainer;
    public final ImageButton overflowButton;
    private final MaterialCardView rootView;

    private ItemFileBinding(MaterialCardView materialCardView, ImageView imageView, TextView textView, TextView textView2, FrameLayout frameLayout, ImageButton imageButton) {
        this.rootView = materialCardView;
        this.fileIcon = imageView;
        this.fileName = textView;
        this.fileSubtitle = textView2;
        this.iconContainer = frameLayout;
        this.overflowButton = imageButton;
    }

    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static ItemFileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemFileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_file, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemFileBinding bind(View view) {
        int i = R.id.fileIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.fileName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.fileSubtitle;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.iconContainer;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = R.id.overflowButton;
                        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
                        if (imageButton != null) {
                            return new ItemFileBinding((MaterialCardView) view, imageView, textView, textView2, frameLayout, imageButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
