package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;

public final class ItemWhitelistPlayerBinding implements ViewBinding {
    public final TextView playerName;
    public final ImageButton removeButton;
    private final LinearLayout rootView;

    private ItemWhitelistPlayerBinding(LinearLayout linearLayout, TextView textView, ImageButton imageButton) {
        this.rootView = linearLayout;
        this.playerName = textView;
        this.removeButton = imageButton;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemWhitelistPlayerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemWhitelistPlayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_whitelist_player, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemWhitelistPlayerBinding bind(View view) {
        int i = R.id.playerName;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.removeButton;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
            if (imageButton != null) {
                return new ItemWhitelistPlayerBinding((LinearLayout) view, textView, imageButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
