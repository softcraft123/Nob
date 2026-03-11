package com.google.android.gms.internal.fido;

import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzay {
    private final String zza;
    private final Set zzb;
    private final boolean zzc;

    public zzay(String str) {
        this("com.google.android.gms.fido", zzcf.zzk(), false, false, false, false, false);
    }

    private zzay(String str, Set set, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.zza = "com.google.android.gms.fido";
        this.zzb = set;
        this.zzc = z4;
    }

    public final zzaq zza(String str, long j) {
        Class<Long> cls = Long.class;
        Long valueOf = Long.valueOf(j);
        zzav zzav = zzav.zza;
        Objects.requireNonNull(cls);
        return new zzaq(this.zza, str, valueOf, new zzak(false, false, false, this.zzc, false, this.zzb, zzav, new zzaw(cls)), true);
    }

    public final zzaq zzb(String str, String str2) {
        Class<String> cls = String.class;
        zzat zzat = zzat.zza;
        Objects.requireNonNull(cls);
        zzak zzak = new zzak(false, false, false, this.zzc, false, this.zzb, zzat, new zzau(cls));
        return new zzaq(this.zza, str, str2, zzak, true);
    }

    public final zzaq zzc(String str, boolean z) {
        Class<Boolean> cls = Boolean.class;
        Boolean valueOf = Boolean.valueOf(z);
        zzar zzar = zzar.zza;
        Objects.requireNonNull(cls);
        return new zzaq(this.zza, str, valueOf, new zzak(false, false, false, this.zzc, false, this.zzb, zzar, new zzas(cls)), true);
    }

    public final zzay zzd() {
        return new zzay(this.zza, this.zzb, false, false, false, true, false);
    }

    public final zzay zze(Set set) {
        return new zzay(this.zza, set, false, false, false, this.zzc, false);
    }
}
