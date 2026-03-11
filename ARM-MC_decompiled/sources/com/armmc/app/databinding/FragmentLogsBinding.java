package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;

public final class FragmentLogsBinding implements ViewBinding {
    public final View chipsDivider;
    public final LinearLayout commandChipsContainer;
    public final HorizontalScrollView commandChipsScroll;
    public final EditText commandInput;
    public final LinearLayout commandInputLayout;
    public final LinearLayout liveOutputHeader;
    public final RecyclerView logsRecyclerView;
    private final ConstraintLayout rootView;
    public final ImageButton sendCommandButton;

    private FragmentLogsBinding(ConstraintLayout constraintLayout, View view, LinearLayout linearLayout, HorizontalScrollView horizontalScrollView, EditText editText, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView, ImageButton imageButton) {
        this.rootView = constraintLayout;
        this.chipsDivider = view;
        this.commandChipsContainer = linearLayout;
        this.commandChipsScroll = horizontalScrollView;
        this.commandInput = editText;
        this.commandInputLayout = linearLayout2;
        this.liveOutputHeader = linearLayout3;
        this.logsRecyclerView = recyclerView;
        this.sendCommandButton = imageButton;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentLogsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentLogsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_logs, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentLogsBinding bind(View view) {
        int i = R.id.chipsDivider;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.commandChipsContainer;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.commandChipsScroll;
                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, i);
                if (horizontalScrollView != null) {
                    i = R.id.commandInput;
                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText != null) {
                        i = R.id.commandInputLayout;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = R.id.liveOutputHeader;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout3 != null) {
                                i = R.id.logsRecyclerView;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                if (recyclerView != null) {
                                    i = R.id.sendCommandButton;
                                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
                                    if (imageButton != null) {
                                        return new FragmentLogsBinding((ConstraintLayout) view, findChildViewById, linearLayout, horizontalScrollView, editText, linearLayout2, linearLayout3, recyclerView, imageButton);
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
