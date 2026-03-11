package com.google.android.play.core.splitinstall.testing;

import java.util.List;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final /* synthetic */ class zzi implements Runnable {
    public final /* synthetic */ FakeSplitInstallManager zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ List zzc;
    public final /* synthetic */ List zzd;
    public final /* synthetic */ List zze;

    public /* synthetic */ zzi(FakeSplitInstallManager fakeSplitInstallManager, long j, List list, List list2, List list3) {
        this.zza = fakeSplitInstallManager;
        this.zzb = j;
        this.zzc = list;
        this.zzd = list2;
        this.zze = list3;
    }

    public final void run() {
        this.zza.zzf(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
