package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzeg;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzdz extends zzcw {
    private final zzeg zza;
    private final zzaal zzb;
    private final zzaaj zzc;
    @Nullable
    private final Integer zzd;

    public final /* synthetic */ zzcb zza() {
        return (zzeg) zza();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdz$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static class zza {
        @Nullable
        private zzeg zza;
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

        public final zza zza(zzeg zzeg) {
            this.zza = zzeg;
            return this;
        }

        public final zzdz zza() throws GeneralSecurityException {
            zzaaj zzb2;
            zzeg zzeg = this.zza;
            if (zzeg == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            } else if (zzeg.zzb() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            } else if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzc == null) {
                if (this.zza.zzd() == zzeg.zzb.zzc) {
                    zzb2 = zzpe.zza;
                } else if (this.zza.zzd() == zzeg.zzb.zzb) {
                    zzb2 = zzpe.zza(this.zzc.intValue());
                } else if (this.zza.zzd() == zzeg.zzb.zza) {
                    zzb2 = zzpe.zzb(this.zzc.intValue());
                } else {
                    throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: " + String.valueOf(this.zza.zzd()));
                }
                return new zzdz(this.zza, this.zzb, zzb2, this.zzc);
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

    public final /* synthetic */ zzcy zzc() {
        return this.zza;
    }

    public static zza zze() {
        return new zza();
    }

    public final zzaaj zzd() {
        return this.zzc;
    }

    public final zzaal zzf() {
        return this.zzb;
    }

    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    private zzdz(zzeg zzeg, zzaal zzaal, zzaaj zzaaj, @Nullable Integer num) {
        this.zza = zzeg;
        this.zzb = zzaal;
        this.zzc = zzaaj;
        this.zzd = num;
    }
}
