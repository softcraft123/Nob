package com.google.android.play.core.splitinstall.testing;

import java.util.List;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final /* synthetic */ class zzm implements Runnable {
    public final /* synthetic */ FakeSplitInstallManager zza;
    public final /* synthetic */ List zzb;
    public final /* synthetic */ List zzc;

    public /* synthetic */ zzm(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2) {
        this.zza = fakeSplitInstallManager;
        this.zzb = list;
        this.zzc = list2;
    }

    public final void run() {
        this.zza.zzi(this.zzb, this.zzc);
    }
}
