package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzge;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzgb extends zzcw {
    private final zzge zza;
    private final zzaal zzb;
    private final zzaaj zzc;
    @Nullable
    private final Integer zzd;

    public final /* synthetic */ zzcb zza() {
        return (zzge) zza();
    }

    public final /* synthetic */ zzcy zzc() {
        return this.zza;
    }

    public static zzgb zza(zzge.zza zza2, zzaal zzaal, @Nullable Integer num) throws GeneralSecurityException {
        zzaaj zzaaj;
        if (zza2 != zzge.zza.zzc && num == null) {
            throw new GeneralSecurityException("For given Variant " + String.valueOf(zza2) + " the value of idRequirement must be non-null");
        } else if (zza2 == zzge.zza.zzc && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzaal.zza() == 32) {
            zzge zza3 = zzge.zza(zza2);
            if (zza3.zzb() == zzge.zza.zzc) {
                zzaaj = zzpe.zza;
            } else if (zza3.zzb() == zzge.zza.zzb) {
                zzaaj = zzpe.zza(num.intValue());
            } else if (zza3.zzb() == zzge.zza.zza) {
                zzaaj = zzpe.zzb(num.intValue());
            } else {
                throw new IllegalStateException("Unknown Variant: " + String.valueOf(zza3.zzb()));
            }
            return new zzgb(zza3, zzaal, zzaaj, num);
        } else {
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zzaal.zza());
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

    private zzgb(zzge zzge, zzaal zzaal, zzaaj zzaaj, @Nullable Integer num) {
        this.zza = zzge;
        this.zzb = zzaal;
        this.zzc = zzaaj;
        this.zzd = num;
    }
}
