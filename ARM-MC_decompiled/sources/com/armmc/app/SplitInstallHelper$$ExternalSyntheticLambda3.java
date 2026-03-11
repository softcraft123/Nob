package com.armmc.app;

import com.armmc.app.SplitInstallHelper;
import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SplitInstallHelper$$ExternalSyntheticLambda3 implements OnFailureListener {
    public final /* synthetic */ SplitInstallHelper f$0;
    public final /* synthetic */ SplitInstallHelper.InstallCallback f$1;

    public /* synthetic */ SplitInstallHelper$$ExternalSyntheticLambda3(SplitInstallHelper splitInstallHelper, SplitInstallHelper.InstallCallback installCallback) {
        this.f$0 = splitInstallHelper;
        this.f$1 = installCallback;
    }

    public final void onFailure(Exception exc) {
        SplitInstallHelper.installModule$lambda$3(this.f$0, this.f$1, exc);
    }
}
