package com.armmc.app.ui.servers;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetDialog;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ServersFragment$$ExternalSyntheticLambda18 implements View.OnClickListener {
    public final /* synthetic */ BottomSheetDialog f$0;
    public final /* synthetic */ ServersFragment f$1;

    public /* synthetic */ ServersFragment$$ExternalSyntheticLambda18(BottomSheetDialog bottomSheetDialog, ServersFragment serversFragment) {
        this.f$0 = bottomSheetDialog;
        this.f$1 = serversFragment;
    }

    public final void onClick(View view) {
        ServersFragment.showServerBusyDialog$lambda$17(this.f$0, this.f$1, view);
    }
}
