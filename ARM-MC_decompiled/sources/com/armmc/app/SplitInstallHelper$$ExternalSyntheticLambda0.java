package com.armmc.app;

import com.armmc.app.SplitInstallHelper;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SplitInstallHelper$$ExternalSyntheticLambda0 implements SplitInstallStateUpdatedListener {
    public final /* synthetic */ SplitInstallHelper f$0;
    public final /* synthetic */ SplitInstallHelper.InstallCallback f$1;

    public /* synthetic */ SplitInstallHelper$$ExternalSyntheticLambda0(SplitInstallHelper splitInstallHelper, SplitInstallHelper.InstallCallback installCallback) {
        this.f$0 = splitInstallHelper;
        this.f$1 = installCallback;
    }

    public final void onStateUpdate(Object obj) {
        SplitInstallHelper.installModule$lambda$0(this.f$0, this.f$1, (SplitInstallSessionState) obj);
    }
}
