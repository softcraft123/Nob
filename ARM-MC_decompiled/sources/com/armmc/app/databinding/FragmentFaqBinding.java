package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;

public final class FragmentFaqBinding implements ViewBinding {
    public final RecyclerView faqRecyclerView;
    private final LinearLayout rootView;
    public final EditText searchInput;

    private FragmentFaqBinding(LinearLayout linearLayout, RecyclerView recyclerView, EditText editText) {
        this.rootView = linearLayout;
        this.faqRecyclerView = recyclerView;
        this.searchInput = editText;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentFaqBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentFaqBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_faq, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentFaqBinding bind(View view) {
        int i = R.id.faqRecyclerView;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.searchInput;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                return new FragmentFaqBinding((LinearLayout) view, recyclerView, editText);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
