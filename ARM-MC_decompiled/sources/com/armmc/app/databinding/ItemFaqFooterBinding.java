package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;
import com.google.android.material.button.MaterialButton;

public final class ItemFaqFooterBinding implements ViewBinding {
    public final MaterialButton discordButton;
    private final LinearLayout rootView;

    private ItemFaqFooterBinding(LinearLayout linearLayout, MaterialButton materialButton) {
        this.rootView = linearLayout;
        this.discordButton = materialButton;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemFaqFooterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemFaqFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_faq_footer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemFaqFooterBinding bind(View view) {
        int i = R.id.discordButton;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            return new ItemFaqFooterBinding((LinearLayout) view, materialButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
