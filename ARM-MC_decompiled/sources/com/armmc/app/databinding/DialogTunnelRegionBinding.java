package com.armmc.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.armmc.app.R;
import com.google.android.material.card.MaterialCardView;

public final class DialogTunnelRegionBinding implements ViewBinding {
    public final MaterialCardView regionAmericaCard;
    public final MaterialCardView regionAsiaCard;
    public final MaterialCardView regionEuropeCard;
    public final ImageView regionEuropeCheck;
    public final TextView regionEuropePing;
    public final MaterialCardView regionLocalCard;
    public final ImageView regionLocalCheck;
    private final NestedScrollView rootView;
    public final MaterialCardView tunnelInfoCard;
    public final ImageView tunnelInfoIcon;
    public final TextView tunnelInfoText;

    private DialogTunnelRegionBinding(NestedScrollView nestedScrollView, MaterialCardView materialCardView, MaterialCardView materialCardView2, MaterialCardView materialCardView3, ImageView imageView, TextView textView, MaterialCardView materialCardView4, ImageView imageView2, MaterialCardView materialCardView5, ImageView imageView3, TextView textView2) {
        this.rootView = nestedScrollView;
        this.regionAmericaCard = materialCardView;
        this.regionAsiaCard = materialCardView2;
        this.regionEuropeCard = materialCardView3;
        this.regionEuropeCheck = imageView;
        this.regionEuropePing = textView;
        this.regionLocalCard = materialCardView4;
        this.regionLocalCheck = imageView2;
        this.tunnelInfoCard = materialCardView5;
        this.tunnelInfoIcon = imageView3;
        this.tunnelInfoText = textView2;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static DialogTunnelRegionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogTunnelRegionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_tunnel_region, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogTunnelRegionBinding bind(View view) {
        int i = R.id.regionAmericaCard;
        MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, i);
        if (materialCardView != null) {
            i = R.id.regionAsiaCard;
            MaterialCardView materialCardView2 = (MaterialCardView) ViewBindings.findChildViewById(view, i);
            if (materialCardView2 != null) {
                i = R.id.regionEuropeCard;
                MaterialCardView materialCardView3 = (MaterialCardView) ViewBindings.findChildViewById(view, i);
                if (materialCardView3 != null) {
                    i = R.id.regionEuropeCheck;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.regionEuropePing;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.regionLocalCard;
                            MaterialCardView materialCardView4 = (MaterialCardView) ViewBindings.findChildViewById(view, i);
                            if (materialCardView4 != null) {
                                i = R.id.regionLocalCheck;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null) {
                                    i = R.id.tunnelInfoCard;
                                    MaterialCardView materialCardView5 = (MaterialCardView) ViewBindings.findChildViewById(view, i);
                                    if (materialCardView5 != null) {
                                        i = R.id.tunnelInfoIcon;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            i = R.id.tunnelInfoText;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                return new DialogTunnelRegionBinding((NestedScrollView) view, materialCardView, materialCardView2, materialCardView3, imageView, textView, materialCardView4, imageView2, materialCardView5, imageView3, textView2);
                                            }
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
