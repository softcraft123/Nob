package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;
import com.google.android.material.card.MaterialCardView;

public final class ItemServerTemplateBinding implements ViewBinding {
    private final MaterialCardView rootView;
    public final Button selectTemplateButton;
    public final TextView templateDescription;
    public final ImageView templateImage;
    public final TextView templateName;

    private ItemServerTemplateBinding(MaterialCardView materialCardView, Button button, TextView textView, ImageView imageView, TextView textView2) {
        this.rootView = materialCardView;
        this.selectTemplateButton = button;
        this.templateDescription = textView;
        this.templateImage = imageView;
        this.templateName = textView2;
    }

    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static ItemServerTemplateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemServerTemplateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_server_template, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemServerTemplateBinding bind(View view) {
        int i = R.id.selectTemplateButton;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.templateDescription;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.templateImage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.templateName;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new ItemServerTemplateBinding((MaterialCardView) view, button, textView, imageView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
