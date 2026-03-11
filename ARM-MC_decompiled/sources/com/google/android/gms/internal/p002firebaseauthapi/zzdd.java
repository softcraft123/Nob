package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdi;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzdd extends zzcw {
    private final zzdi zza;
    private final zzaal zzb;
    private final zzaal zzc;
    private final zzaaj zzd;
    @Nullable
    private final Integer zze;

    public final /* synthetic */ zzcb zza() {
        return (zzdi) zza();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdd$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static class zza {
        @Nullable
        private zzdi zza;
        @Nullable
        private zzaal zzb;
        @Nullable
        private zzaal zzc;
        @Nullable
        private Integer zzd;

        public final zza zza(zzaal zzaal) {
            this.zzb = zzaal;
            return this;
        }

        public final zza zzb(zzaal zzaal) {
            this.zzc = zzaal;
            return this;
        }

        public final zza zza(@Nullable Integer num) {
            this.zzd = num;
            return this;
        }

        public final zza zza(zzdi zzdi) {
            this.zza = zzdi;
            return this;
        }

        public final zzdd zza() throws GeneralSecurityException {
            zzaaj zzb2;
            zzdi zzdi = this.zza;
            if (zzdi == null) {
                throw new GeneralSecurityException("Cannot build without parameters");
            } else if (this.zzb == null || this.zzc == null) {
                throw new GeneralSecurityException("Cannot build without key material");
            } else if (zzdi.zzb() != this.zzb.zza()) {
                throw new GeneralSecurityException("AES key size mismatch");
            } else if (this.zza.zzc() != this.zzc.zza()) {
                throw new GeneralSecurityException("HMAC key size mismatch");
            } else if (this.zza.zza() && this.zzd == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzd == null) {
                if (this.zza.zzh() == zzdi.zzc.zzc) {
                    zzb2 = zzpe.zza;
                } else if (this.zza.zzh() == zzdi.zzc.zzb) {
                    zzb2 = zzpe.zza(this.zzd.intValue());
                } else if (this.zza.zzh() == zzdi.zzc.zza) {
                    zzb2 = zzpe.zzb(this.zzd.intValue());
                } else {
                    throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: " + String.valueOf(this.zza.zzh()));
                }
                return new zzdd(this.zza, this.zzb, this.zzc, zzb2, this.zzd);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
        }
    }

    public final /* synthetic */ zzcy zzc() {
        return this.zza;
    }

    public static zza zze() {
        return new zza();
    }

    public final zzaaj zzd() {
        return this.zzd;
    }

    public final zzaal zzf() {
        return this.zzb;
    }

    public final zzaal zzg() {
        return this.zzc;
    }

    @Nullable
    public final Integer zzb() {
        return this.zze;
    }

    private zzdd(zzdi zzdi, zzaal zzaal, zzaal zzaal2, zzaaj zzaaj, @Nullable Integer num) {
        this.zza = zzdi;
        this.zzb = zzaal;
        this.zzc = zzaal2;
        this.zzd = zzaaj;
        this.zze = num;
    }
}
