package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfz;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzfw extends zzcw {
    private final zzfz zza;
    private final zzaal zzb;
    private final zzaaj zzc;
    @Nullable
    private final Integer zzd;

    public final /* synthetic */ zzcb zza() {
        return (zzfz) zza();
    }

    public final /* synthetic */ zzcy zzc() {
        return this.zza;
    }

    public static zzfw zza(zzfz zzfz, zzaal zzaal, @Nullable Integer num) throws GeneralSecurityException {
        zzaaj zzaaj;
        if (zzfz.zzc() != zzfz.zza.zzb && num == null) {
            throw new GeneralSecurityException("For given Variant " + String.valueOf(zzfz.zzc()) + " the value of idRequirement must be non-null");
        } else if (zzfz.zzc() == zzfz.zza.zzb && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzaal.zza() == 32) {
            if (zzfz.zzc() == zzfz.zza.zzb) {
                zzaaj = zzpe.zza;
            } else if (zzfz.zzc() == zzfz.zza.zza) {
                zzaaj = zzpe.zzb(num.intValue());
            } else {
                throw new IllegalStateException("Unknown Variant: " + String.valueOf(zzfz.zzc()));
            }
            return new zzfw(zzfz, zzaal, zzaaj, num);
        } else {
            throw new GeneralSecurityException("XAesGcmKey key must be constructed with key of length 32 bytes, not " + zzaal.zza());
        }
    }

    public final zzaaj zzd() {
        return this.zzc;
    }

    public final zzaal zze() {
        return this.zzb;
    }

    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    private zzfw(zzfz zzfz, zzaal zzaal, zzaaj zzaaj, @Nullable Integer num) {
        this.zza = zzfz;
        this.zzb = zzaal;
        this.zzc = zzaaj;
        this.zzd = num;
    }
}
