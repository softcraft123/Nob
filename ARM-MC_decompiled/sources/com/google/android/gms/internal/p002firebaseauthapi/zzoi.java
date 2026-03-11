package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzoi extends zzcb {
    private final zzqe zza;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza.zza(), this.zza.zzc()});
    }

    public final zzqe zzb() {
        return this.zza;
    }

    public final String toString() {
        String str;
        String zzf = this.zza.zza().zzf();
        int i = zzoh.zza[this.zza.zza().zzd().ordinal()];
        if (i == 1) {
            str = "TINK";
        } else if (i == 2) {
            str = "LEGACY";
        } else if (i == 3) {
            str = "RAW";
        } else if (i != 4) {
            str = "UNKNOWN";
        } else {
            str = "CRUNCHY";
        }
        return String.format("(typeUrl=%s, outputPrefixType=%s)", new Object[]{zzf, str});
    }

    public zzoi(zzqe zzqe) {
        this.zza = zzqe;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzoi)) {
            return false;
        }
        zzqe zzqe = ((zzoi) obj).zza;
        if (!this.zza.zza().zzd().equals(zzqe.zza().zzd()) || !this.zza.zza().zzf().equals(zzqe.zza().zzf()) || !this.zza.zza().zze().equals(zzqe.zza().zze())) {
            return false;
        }
        return true;
    }

    public final boolean zza() {
        return this.zza.zza().zzd() != zzxz.RAW;
    }
}
