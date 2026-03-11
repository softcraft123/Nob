package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjf;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzja  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzja extends zzjk {
    private final zzjf zza;
    private final zzaal zzb;
    private final zzaaj zzc;
    @Nullable
    private final Integer zzd;

    public final /* synthetic */ zzcb zza() {
        return (zzjf) zza();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzja$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static class zza {
        @Nullable
        private zzjf zza;
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

        public final zza zza(zzjf zzjf) {
            this.zza = zzjf;
            return this;
        }

        public final zzja zza() throws GeneralSecurityException {
            zzaaj zzb2;
            zzjf zzjf = this.zza;
            if (zzjf == null || this.zzb == null) {
                throw new IllegalArgumentException("Cannot build without parameters and/or key material");
            } else if (zzjf.zzb() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            } else if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzc == null) {
                if (this.zza.zzd() == zzjf.zza.zzc) {
                    zzb2 = zzpe.zza;
                } else if (this.zza.zzd() == zzjf.zza.zzb) {
                    zzb2 = zzpe.zza(this.zzc.intValue());
                } else if (this.zza.zzd() == zzjf.zza.zza) {
                    zzb2 = zzpe.zzb(this.zzc.intValue());
                } else {
                    throw new IllegalStateException("Unknown AesSivParameters.Variant: " + String.valueOf(this.zza.zzd()));
                }
                return new zzja(this.zza, this.zzb, zzb2, this.zzc);
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

    public final /* synthetic */ zzjj zzd() {
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

    private zzja(zzjf zzjf, zzaal zzaal, zzaaj zzaaj, @Nullable Integer num) {
        this.zza = zzjf;
        this.zzb = zzaal;
        this.zzc = zzaaj;
        this.zzd = num;
    }
}
