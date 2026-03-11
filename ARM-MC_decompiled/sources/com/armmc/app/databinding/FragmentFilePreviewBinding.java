package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;

public final class FragmentFilePreviewBinding implements ViewBinding {
    public final ImageButton backButton;
    public final ImageView imageContent;
    public final ScrollView imageScrollView;
    public final TextView previewError;
    public final TextView previewFileName;
    public final TextView previewFileType;
    public final ProgressBar previewProgress;
    private final LinearLayout rootView;
    public final TextView textContent;
    public final ScrollView textScrollView;

    private FragmentFilePreviewBinding(LinearLayout linearLayout, ImageButton imageButton, ImageView imageView, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, ProgressBar progressBar, TextView textView4, ScrollView scrollView2) {
        this.rootView = linearLayout;
        this.backButton = imageButton;
        this.imageContent = imageView;
        this.imageScrollView = scrollView;
        this.previewError = textView;
        this.previewFileName = textView2;
        this.previewFileType = textView3;
        this.previewProgress = progressBar;
        this.textContent = textView4;
        this.textScrollView = scrollView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentFilePreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentFilePreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_file_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentFilePreviewBinding bind(View view) {
        int i = R.id.backButton;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R.id.imageContent;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.imageScrollView;
                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                if (scrollView != null) {
                    i = R.id.previewError;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.previewFileName;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.previewFileType;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.previewProgress;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                if (progressBar != null) {
                                    i = R.id.textContent;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.textScrollView;
                                        ScrollView scrollView2 = (ScrollView) ViewBindings.findChildViewById(view, i);
                                        if (scrollView2 != null) {
                                            return new FragmentFilePreviewBinding((LinearLayout) view, imageButton, imageView, scrollView, textView, textView2, textView3, progressBar, textView4, scrollView2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
