package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqu;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzqp extends zzrk {
    private final zzqu zza;
    private final zzaal zzb;
    private final zzaaj zzc;
    @Nullable
    private final Integer zzd;

    public final /* synthetic */ zzcb zza() {
        return (zzqu) zza();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqp$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static class zza {
        @Nullable
        private zzqu zza;
        @Nullable
        private zzaal zzb;
        @Nullable
        private Integer zzc;

        public final zza zza(zzaal zzaal) throws GeneralSecurityException {
            this.zzb = zzaal;
            return this;
        }

        public final zza zza(@Nullable Integer num) {
            this.zzc = num;
            return this;
        }

        public final zza zza(zzqu zzqu) {
            this.zza = zzqu;
            return this;
        }

        public final zzqp zza() throws GeneralSecurityException {
            zzaaj zza2;
            zzqu zzqu = this.zza;
            if (zzqu == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            } else if (zzqu.zzc() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            } else if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzc == null) {
                if (this.zza.zze() == zzqu.zza.zzd) {
                    zza2 = zzpe.zza;
                } else if (this.zza.zze() == zzqu.zza.zzc || this.zza.zze() == zzqu.zza.zzb) {
                    zza2 = zzpe.zza(this.zzc.intValue());
                } else if (this.zza.zze() == zzqu.zza.zza) {
                    zza2 = zzpe.zzb(this.zzc.intValue());
                } else {
                    throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: " + String.valueOf(this.zza.zze()));
                }
                return new zzqp(this.zza, this.zzb, zza2, this.zzc);
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

    private zzqp(zzqu zzqu, zzaal zzaal, zzaaj zzaaj, @Nullable Integer num) {
        this.zza = zzqu;
        this.zzb = zzaal;
        this.zzc = zzaaj;
        this.zzd = num;
    }
}
