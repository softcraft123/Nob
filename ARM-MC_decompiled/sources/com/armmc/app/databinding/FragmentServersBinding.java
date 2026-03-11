package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;

public final class FragmentServersBinding implements ViewBinding {
    public final Button createInstanceButton;
    private final ConstraintLayout rootView;
    public final RecyclerView serversRecyclerView;

    private FragmentServersBinding(ConstraintLayout constraintLayout, Button button, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.createInstanceButton = button;
        this.serversRecyclerView = recyclerView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentServersBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentServersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_servers, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentServersBinding bind(View view) {
        int i = R.id.createInstanceButton;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.serversRecyclerView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                return new FragmentServersBinding((ConstraintLayout) view, button, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
