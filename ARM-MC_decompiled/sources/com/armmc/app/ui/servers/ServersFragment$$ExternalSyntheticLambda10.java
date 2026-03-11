package com.armmc.app.ui.servers;

import android.content.DialogInterface;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ServersFragment$$ExternalSyntheticLambda10 implements DialogInterface.OnClickListener {
    public final /* synthetic */ ServerData f$0;
    public final /* synthetic */ ServersFragment f$1;

    public /* synthetic */ ServersFragment$$ExternalSyntheticLambda10(ServerData serverData, ServersFragment serversFragment) {
        this.f$0 = serverData;
        this.f$1 = serversFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ServersFragment.deleteServer$lambda$77(this.f$0, this.f$1, dialogInterface, i);
    }
}
