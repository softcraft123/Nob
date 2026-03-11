package com.google.android.gms.internal.fido;

import java.util.Set;
import java.util.logging.Level;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzer implements zzek {
    private final String zza;
    private final zzdn zzb;
    private final Level zzc;
    private final Set zzd;
    private final zzea zze;

    private zzer() {
        this("", true, zzdo.NO_OP, Level.ALL, false, zzeu.zza, zzeu.zzb);
    }

    private zzer(String str, boolean z, zzdn zzdn, Level level, boolean z2, Set set, zzea zzea) {
        this.zza = "";
        this.zzb = zzdn;
        this.zzc = level;
        this.zzd = set;
        this.zze = zzea;
    }

    public final zzdp zza(String str) {
        return new zzeu(this.zza, str, true, this.zzb, this.zzc, this.zzd, this.zze, (zzet) null);
    }

    public final zzer zzb(boolean z) {
        Set set = this.zzd;
        zzea zzea = this.zze;
        return new zzer(this.zza, true, this.zzb, Level.OFF, false, set, zzea);
    }

    /* synthetic */ zzer(zzeq zzeq) {
        this("", true, zzdo.NO_OP, Level.ALL, false, zzeu.zza, zzeu.zzb);
    }
}
