package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;

public final class NavHeaderMainBinding implements ViewBinding {
    public final ImageView imageView;
    private final LinearLayout rootView;
    public final TextView textView;

    private NavHeaderMainBinding(LinearLayout linearLayout, ImageView imageView2, TextView textView2) {
        this.rootView = linearLayout;
        this.imageView = imageView2;
        this.textView = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NavHeaderMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NavHeaderMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.nav_header_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NavHeaderMainBinding bind(View view) {
        int i = R.id.imageView;
        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView2 != null) {
            i = R.id.textView;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                return new NavHeaderMainBinding((LinearLayout) view, imageView2, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
