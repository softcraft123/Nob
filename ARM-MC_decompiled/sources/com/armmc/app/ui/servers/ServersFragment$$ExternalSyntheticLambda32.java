package com.armmc.app.ui.servers;

import android.view.View;
import android.widget.CheckBox;
import com.google.android.material.bottomsheet.BottomSheetDialog;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ServersFragment$$ExternalSyntheticLambda32 implements View.OnClickListener {
    public final /* synthetic */ CheckBox f$0;
    public final /* synthetic */ ServersFragment f$1;
    public final /* synthetic */ BottomSheetDialog f$2;
    public final /* synthetic */ ServerData f$3;

    public /* synthetic */ ServersFragment$$ExternalSyntheticLambda32(CheckBox checkBox, ServersFragment serversFragment, BottomSheetDialog bottomSheetDialog, ServerData serverData) {
        this.f$0 = checkBox;
        this.f$1 = serversFragment;
        this.f$2 = bottomSheetDialog;
        this.f$3 = serverData;
    }

    public final void onClick(View view) {
        ServersFragment.showAlphaWarningDialog$lambda$14(this.f$0, this.f$1, this.f$2, this.f$3, view);
    }
}
