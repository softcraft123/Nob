package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzrh;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzra  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzra extends zzrk {
    private final zzrh zza;
    private final zzaal zzb;
    private final zzaaj zzc;
    @Nullable
    private final Integer zzd;

    public final /* synthetic */ zzcb zza() {
        return (zzrh) zza();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzra$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static class zza {
        @Nullable
        private zzrh zza;
        @Nullable
        private zzaal zzb;
        @Nullable
        private Integer zzc;

        public final zza zza(@Nullable Integer num) {
            this.zzc = num;
            return this;
        }

        public final zza zza(zzaal zzaal) {
            this.zzb = zzaal;
            return this;
        }

        public final zza zza(zzrh zzrh) {
            this.zza = zzrh;
            return this;
        }

        public final zzra zza() throws GeneralSecurityException {
            zzaaj zza2;
            zzrh zzrh = this.zza;
            if (zzrh == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            } else if (zzrh.zzc() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            } else if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzc == null) {
                if (this.zza.zzf() == zzrh.zzc.zzd) {
                    zza2 = zzpe.zza;
                } else if (this.zza.zzf() == zzrh.zzc.zzc || this.zza.zzf() == zzrh.zzc.zzb) {
                    zza2 = zzpe.zza(this.zzc.intValue());
                } else if (this.zza.zzf() == zzrh.zzc.zza) {
                    zza2 = zzpe.zzb(this.zzc.intValue());
                } else {
                    throw new IllegalStateException("Unknown HmacParameters.Variant: " + String.valueOf(this.zza.zzf()));
                }
                return new zzra(this.zza, this.zzb, zza2, this.zzc);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }
    }

    public static zza zzc() {
        return new zza();
    }

    public final /* synthetic */ zzrn zzd() {
        return this.zza;
    }

    public final zzaaj zze() {
        return this.zzc;
    }

    public final zzaal zzf() {
        return this.zzb;
    }

    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    private zzra(zzrh zzrh, zzaal zzaal, zzaaj zzaaj, @Nullable Integer num) {
        this.zza = zzrh;
        this.zzb = zzaal;
        this.zzc = zzaaj;
        this.zzd = num;
    }
}
