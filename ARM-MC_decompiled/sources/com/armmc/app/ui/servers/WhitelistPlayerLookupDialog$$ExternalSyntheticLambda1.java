package com.armmc.app.ui.servers;

import com.armmc.app.MinecraftApiService;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WhitelistPlayerLookupDialog$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ WhitelistPlayerLookupDialog f$0;
    public final /* synthetic */ MinecraftApiService.LookupResult f$1;

    public /* synthetic */ WhitelistPlayerLookupDialog$$ExternalSyntheticLambda1(WhitelistPlayerLookupDialog whitelistPlayerLookupDialog, MinecraftApiService.LookupResult lookupResult) {
        this.f$0 = whitelistPlayerLookupDialog;
        this.f$1 = lookupResult;
    }

    public final void run() {
        WhitelistPlayerLookupDialog.performSearch$lambda$7$lambda$6(this.f$0, this.f$1);
    }
}
