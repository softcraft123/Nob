package com.armmc.app.ui.servers;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CreateServerFragment$installModuleAndSave$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ CreateServerFragment f$0;
    public final /* synthetic */ SplitInstallSessionState f$1;

    public /* synthetic */ CreateServerFragment$installModuleAndSave$1$$ExternalSyntheticLambda0(CreateServerFragment createServerFragment, SplitInstallSessionState splitInstallSessionState) {
        this.f$0 = createServerFragment;
        this.f$1 = splitInstallSessionState;
    }

    public final void run() {
        CreateServerFragment$installModuleAndSave$1.onRequiresUserConfirmation$lambda$4(this.f$0, this.f$1);
    }
}
