package com.armmc.app.ui.servers;

import android.view.View;
import android.widget.ViewFlipper;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ServersFragment$$ExternalSyntheticLambda26 implements View.OnClickListener {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ ViewFlipper f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ ServersFragment f$3;

    public /* synthetic */ ServersFragment$$ExternalSyntheticLambda26(boolean z, ViewFlipper viewFlipper, boolean z2, ServersFragment serversFragment) {
        this.f$0 = z;
        this.f$1 = viewFlipper;
        this.f$2 = z2;
        this.f$3 = serversFragment;
    }

    public final void onClick(View view) {
        ServersFragment.showSetupPermissionsDialog$lambda$21(this.f$0, this.f$1, this.f$2, this.f$3, view);
    }
}
