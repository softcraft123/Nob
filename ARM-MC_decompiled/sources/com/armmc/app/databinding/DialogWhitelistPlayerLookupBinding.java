package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;
import com.google.android.material.card.MaterialCardView;

public final class DialogWhitelistPlayerLookupBinding implements ViewBinding {
    public final Button addButton;
    public final Button cancelButton;
    public final ProgressBar loadingIndicator;
    public final TextView playerNameText;
    public final TextView playerUuidText;
    public final MaterialCardView resultContainer;
    private final NestedScrollView rootView;
    public final ImageButton searchButton;
    public final TextView statusText;
    public final EditText usernameInput;

    private DialogWhitelistPlayerLookupBinding(NestedScrollView nestedScrollView, Button button, Button button2, ProgressBar progressBar, TextView textView, TextView textView2, MaterialCardView materialCardView, ImageButton imageButton, TextView textView3, EditText editText) {
        this.rootView = nestedScrollView;
        this.addButton = button;
        this.cancelButton = button2;
        this.loadingIndicator = progressBar;
        this.playerNameText = textView;
        this.playerUuidText = textView2;
        this.resultContainer = materialCardView;
        this.searchButton = imageButton;
        this.statusText = textView3;
        this.usernameInput = editText;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static DialogWhitelistPlayerLookupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogWhitelistPlayerLookupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_whitelist_player_lookup, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogWhitelistPlayerLookupBinding bind(View view) {
        int i = R.id.addButton;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.cancelButton;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.loadingIndicator;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                if (progressBar != null) {
                    i = R.id.playerNameText;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.playerUuidText;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.resultContainer;
                            MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, i);
                            if (materialCardView != null) {
                                i = R.id.searchButton;
                                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
                                if (imageButton != null) {
                                    i = R.id.statusText;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.usernameInput;
                                        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                        if (editText != null) {
                                            return new DialogWhitelistPlayerLookupBinding((NestedScrollView) view, button, button2, progressBar, textView, textView2, materialCardView, imageButton, textView3, editText);
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
