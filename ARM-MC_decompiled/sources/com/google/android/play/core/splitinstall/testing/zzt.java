package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.internal.zzbz;
import com.google.android.play.core.splitinstall.internal.zzcb;
import com.google.android.play.core.splitinstall.zzad;
import com.google.android.play.core.splitinstall.zzs;
import java.io.File;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final class zzt implements zzcb {
    private final zzcb zza;
    private final zzcb zzb;
    private final zzcb zzc;
    private final zzcb zzd;

    public zzt(zzcb zzcb, zzcb zzcb2, zzcb zzcb3, zzcb zzcb4) {
        this.zza = zzcb;
        this.zzb = zzcb2;
        this.zzc = zzcb3;
        this.zzd = zzcb4;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        return new FakeSplitInstallManager(((zzad) this.zza).zzb(), (File) this.zzb.zza(), (zzs) this.zzc.zza(), zzbz.zzb(this.zzd));
    }
}
