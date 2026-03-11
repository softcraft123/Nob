package com.armmc.app;

import android.view.View;
import android.widget.ImageView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda6 implements View.OnClickListener {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ BottomSheetDialog f$1;
    public final /* synthetic */ MaterialCardView f$2;
    public final /* synthetic */ MaterialCardView f$3;
    public final /* synthetic */ ImageView f$4;
    public final /* synthetic */ ImageView f$5;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda6(MainActivity mainActivity, BottomSheetDialog bottomSheetDialog, MaterialCardView materialCardView, MaterialCardView materialCardView2, ImageView imageView, ImageView imageView2) {
        this.f$0 = mainActivity;
        this.f$1 = bottomSheetDialog;
        this.f$2 = materialCardView;
        this.f$3 = materialCardView2;
        this.f$4 = imageView;
        this.f$5 = imageView2;
    }

    public final void onClick(View view) {
        MainActivity.showTunnelRegionDialog$lambda$11(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, view);
    }
}
