package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final /* synthetic */ class zzn implements Callable {
    public final /* synthetic */ SplitInstallSessionState zza;
    public final /* synthetic */ SplitInstallRequest zzb;

    public /* synthetic */ zzn(SplitInstallSessionState splitInstallSessionState, SplitInstallRequest splitInstallRequest) {
        this.zza = splitInstallSessionState;
        this.zzb = splitInstallRequest;
    }

    public final Object call() {
        SplitInstallSessionState splitInstallSessionState = this.zza;
        SplitInstallRequest splitInstallRequest = this.zzb;
        int i = FakeSplitInstallManager.zza;
        if (splitInstallSessionState == null || splitInstallSessionState.hasTerminalStatus()) {
            int i2 = 1;
            if (splitInstallSessionState != null) {
                i2 = 1 + splitInstallSessionState.sessionId();
            }
            return SplitInstallSessionState.create(i2, 1, 0, 0, 0, splitInstallRequest.getModuleNames(), new ArrayList());
        }
        throw new SplitInstallException(-1);
    }
}
