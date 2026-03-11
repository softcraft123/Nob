package com.google.android.play.core.splitinstall;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final class zzc {
    private zzac zza;

    private zzc() {
    }

    /* synthetic */ zzc(zzb zzb) {
    }

    public final zzc zza(zzac zzac) {
        this.zza = zzac;
        return this;
    }

    public final zzp zzb() {
        zzac zzac = this.zza;
        if (zzac != null) {
            return new zze(zzac, (zzd) null);
        }
        throw new IllegalStateException(String.valueOf(zzac.class.getCanonicalName()).concat(" must be set"));
    }
}
