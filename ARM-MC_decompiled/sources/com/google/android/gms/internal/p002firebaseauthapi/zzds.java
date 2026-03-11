package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdx;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzds  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzds extends zzcw {
    private final zzdx zza;
    private final zzaal zzb;
    private final zzaaj zzc;
    @Nullable
    private final Integer zzd;

    public final /* synthetic */ zzcb zza() {
        return (zzdx) zza();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzds$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static class zza {
        @Nullable
        private zzdx zza;
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

        public final zza zza(zzdx zzdx) {
            this.zza = zzdx;
            return this;
        }

        public final zzds zza() throws GeneralSecurityException {
            zzaaj zzb2;
            zzdx zzdx = this.zza;
            if (zzdx == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            } else if (zzdx.zzc() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            } else if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzc == null) {
                if (this.zza.zzf() == zzdx.zza.zzc) {
                    zzb2 = zzpe.zza;
                } else if (this.zza.zzf() == zzdx.zza.zzb) {
                    zzb2 = zzpe.zza(this.zzc.intValue());
                } else if (this.zza.zzf() == zzdx.zza.zza) {
                    zzb2 = zzpe.zzb(this.zzc.intValue());
                } else {
                    throw new IllegalStateException("Unknown AesGcmParameters.Variant: " + String.valueOf(this.zza.zzf()));
                }
                return new zzds(this.zza, this.zzb, zzb2, this.zzc);
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

    private zzds(zzdx zzdx, zzaal zzaal, zzaaj zzaaj, @Nullable Integer num) {
        this.zza = zzdx;
        this.zzb = zzaal;
        this.zzc = zzaaj;
        this.zzd = num;
    }
}
