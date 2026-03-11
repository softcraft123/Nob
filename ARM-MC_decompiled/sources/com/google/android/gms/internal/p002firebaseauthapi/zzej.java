package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzem;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzej  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzej extends zzcw {
    private final zzem zza;
    private final zzaal zzb;
    private final zzaaj zzc;
    @Nullable
    private final Integer zzd;

    public final /* synthetic */ zzcb zza() {
        return (zzem) zza();
    }

    public final /* synthetic */ zzcy zzc() {
        return this.zza;
    }

    public static zzej zza(zzem.zza zza2, zzaal zzaal, @Nullable Integer num) throws GeneralSecurityException {
        zzaaj zzaaj;
        if (zza2 != zzem.zza.zzc && num == null) {
            throw new GeneralSecurityException("For given Variant " + String.valueOf(zza2) + " the value of idRequirement must be non-null");
        } else if (zza2 == zzem.zza.zzc && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzaal.zza() == 32) {
            zzem zza3 = zzem.zza(zza2);
            if (zza3.zzb() == zzem.zza.zzc) {
                zzaaj = zzpe.zza;
            } else if (zza3.zzb() == zzem.zza.zzb) {
                zzaaj = zzpe.zza(num.intValue());
            } else if (zza3.zzb() == zzem.zza.zza) {
                zzaaj = zzpe.zzb(num.intValue());
            } else {
                throw new IllegalStateException("Unknown Variant: " + String.valueOf(zza3.zzb()));
            }
            return new zzej(zza3, zzaal, zzaaj, num);
        } else {
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zzaal.zza());
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

    private zzej(zzem zzem, zzaal zzaal, zzaaj zzaaj, @Nullable Integer num) {
        this.zza = zzem;
        this.zzb = zzaal;
        this.zzc = zzaaj;
        this.zzd = num;
    }
}
