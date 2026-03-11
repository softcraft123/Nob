package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.internal.zzbz;
import com.google.android.play.core.splitinstall.internal.zzcb;
import com.google.android.play.core.splitinstall.testing.zzt;
import java.io.File;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zze implements zzp {
    private final zze zza = this;
    private final zzcb zzb;
    private final zzcb zzc;
    private final zzcb zzd;
    private final zzcb zze;
    private final zzcb zzf;
    private final zzcb zzg;
    private final zzcb zzh;
    private final zzcb zzi;
    private final zzcb zzj;
    private final zzcb zzk;
    private final zzcb zzl;

    /* synthetic */ zze(zzac zzac, zzd zzd2) {
        zzad zzad = new zzad(zzac);
        this.zzb = zzad;
        zzcb zzc2 = zzbz.zzc(new zzbd(zzad));
        this.zzc = zzc2;
        zzcb zzc3 = zzbz.zzc(new zzag(zzac));
        this.zzd = zzc3;
        zzcb zzc4 = zzbz.zzc(new zzt(zzad));
        this.zze = zzc4;
        zzcb zzc5 = zzbz.zzc(new zzbf(zzad));
        this.zzf = zzc5;
        zzcb zzc6 = zzbz.zzc(new zzab(zzc2, zzc3, zzc4, zzc5));
        this.zzg = zzc6;
        zzcb zzc7 = zzbz.zzc(new zzaf(zzad));
        this.zzh = zzc7;
        zzae zzae = new zzae(zzc7);
        this.zzi = zzae;
        zzcb zzc8 = zzbz.zzc(new zzt(zzad, zzc7, zzc4, zzae));
        this.zzj = zzc8;
        zzcb zzc9 = zzbz.zzc(new zzm(zzc6, zzc8, zzc7));
        this.zzk = zzc9;
        this.zzl = zzbz.zzc(new zzah(zzac, zzc9));
    }

    public final SplitInstallManager zza() {
        return (SplitInstallManager) this.zzl.zza();
    }

    public final File zzb() {
        return (File) this.zzh.zza();
    }
}
