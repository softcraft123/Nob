package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final /* synthetic */ class zzf implements Runnable {
    public final /* synthetic */ FakeSplitInstallManager zza;
    public final /* synthetic */ SplitInstallSessionState zzb;

    public /* synthetic */ zzf(FakeSplitInstallManager fakeSplitInstallManager, SplitInstallSessionState splitInstallSessionState) {
        this.zza = fakeSplitInstallManager;
        this.zzb = splitInstallSessionState;
    }

    public final void run() {
        this.zza.zzg(this.zzb);
    }
}
