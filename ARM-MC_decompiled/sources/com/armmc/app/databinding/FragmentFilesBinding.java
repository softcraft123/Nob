package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;

public final class FragmentFilesBinding implements ViewBinding {
    public final LinearLayout breadcrumbContainer;
    public final HorizontalScrollView breadcrumbScroll;
    public final TextView emptyText;
    public final RecyclerView fileRecyclerView;
    private final LinearLayout rootView;
    public final EditText searchField;

    private FragmentFilesBinding(LinearLayout linearLayout, LinearLayout linearLayout2, HorizontalScrollView horizontalScrollView, TextView textView, RecyclerView recyclerView, EditText editText) {
        this.rootView = linearLayout;
        this.breadcrumbContainer = linearLayout2;
        this.breadcrumbScroll = horizontalScrollView;
        this.emptyText = textView;
        this.fileRecyclerView = recyclerView;
        this.searchField = editText;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentFilesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentFilesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_files, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentFilesBinding bind(View view) {
        int i = R.id.breadcrumbContainer;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.breadcrumbScroll;
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, i);
            if (horizontalScrollView != null) {
                i = R.id.emptyText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.fileRecyclerView;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R.id.searchField;
                        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText != null) {
                            return new FragmentFilesBinding((LinearLayout) view, linearLayout, horizontalScrollView, textView, recyclerView, editText);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
