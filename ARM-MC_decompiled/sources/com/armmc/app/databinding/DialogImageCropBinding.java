package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;
import com.armmc.app.ui.servers.CropImageView;

public final class DialogImageCropBinding implements ViewBinding {
    public final LinearLayout buttonContainer;
    public final Button cancelButton;
    public final Button confirmButton;
    public final CropImageView cropView;
    public final LinearLayout header;
    private final ConstraintLayout rootView;

    private DialogImageCropBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, Button button, Button button2, CropImageView cropImageView, LinearLayout linearLayout2) {
        this.rootView = constraintLayout;
        this.buttonContainer = linearLayout;
        this.cancelButton = button;
        this.confirmButton = button2;
        this.cropView = cropImageView;
        this.header = linearLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogImageCropBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogImageCropBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_image_crop, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogImageCropBinding bind(View view) {
        int i = R.id.buttonContainer;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = R.id.confirmButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                if (button2 != null) {
                    i = R.id.cropView;
                    CropImageView cropImageView = (CropImageView) ViewBindings.findChildViewById(view, i);
                    if (cropImageView != null) {
                        i = R.id.header;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            return new DialogImageCropBinding((ConstraintLayout) view, linearLayout, button, button2, cropImageView, linearLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
