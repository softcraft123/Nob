package com.armmc.app;

import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda7 implements Runnable {
    public final /* synthetic */ BottomSheetDialog f$0;
    public final /* synthetic */ Long f$1;
    public final /* synthetic */ TextView f$2;
    public final /* synthetic */ MainActivity f$3;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda7(BottomSheetDialog bottomSheetDialog, Long l, TextView textView, MainActivity mainActivity) {
        this.f$0 = bottomSheetDialog;
        this.f$1 = l;
        this.f$2 = textView;
        this.f$3 = mainActivity;
    }

    public final void run() {
        MainActivity.showTunnelRegionDialog$lambda$9$lambda$8(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
