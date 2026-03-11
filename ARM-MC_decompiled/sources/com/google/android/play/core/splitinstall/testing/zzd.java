package com.google.android.play.core.splitinstall.testing;

import java.util.List;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final /* synthetic */ class zzd implements Runnable {
    public final /* synthetic */ FakeSplitInstallManager zza;
    public final /* synthetic */ List zzb;
    public final /* synthetic */ List zzc;
    public final /* synthetic */ List zzd;
    public final /* synthetic */ long zze;

    public /* synthetic */ zzd(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2, List list3, long j) {
        this.zza = fakeSplitInstallManager;
        this.zzb = list;
        this.zzc = list2;
        this.zzd = list3;
        this.zze = j;
    }

    public final void run() {
        this.zza.zzh(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
