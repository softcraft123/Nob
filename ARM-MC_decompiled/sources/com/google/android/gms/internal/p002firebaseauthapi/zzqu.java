package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzqu extends zzrn {
    private final int zza;
    private final int zzb;
    private final zza zzc;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqu$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zzb {
        @Nullable
        private Integer zza;
        @Nullable
        private Integer zzb;
        private zza zzc;

        public final zzb zza(int i) throws GeneralSecurityException {
            if (i == 16 || i == 32) {
                this.zza = Integer.valueOf(i);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", new Object[]{Integer.valueOf(i << 3)}));
        }

        public final zzb zzb(int i) throws GeneralSecurityException {
            if (i < 10 || 16 < i) {
                throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i);
            }
            this.zzb = Integer.valueOf(i);
            return this;
        }

        public final zzb zza(zza zza2) {
            this.zzc = zza2;
            return this;
        }

        public final zzqu zza() throws GeneralSecurityException {
            if (this.zza == null) {
                throw new GeneralSecurityException("key size not set");
            } else if (this.zzb == null) {
                throw new GeneralSecurityException("tag size not set");
            } else if (this.zzc != null) {
                return new zzqu(this.zza.intValue(), this.zzb.intValue(), this.zzc);
            } else {
                throw new GeneralSecurityException("variant not set");
            }
        }

        private zzb() {
            this.zza = null;
            this.zzb = null;
            this.zzc = zza.zzd;
        }
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    private final int zzf() {
        int i;
        if (this.zzc == zza.zzd) {
            return this.zzb;
        }
        if (this.zzc == zza.zza) {
            i = this.zzb;
        } else if (this.zzc == zza.zzb) {
            i = this.zzb;
        } else if (this.zzc == zza.zzc) {
            i = this.zzb;
        } else {
            throw new IllegalStateException("Unknown variant");
        }
        return i + 5;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqu$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza {
        public static final zza zza = new zza("TINK");
        public static final zza zzb = new zza("CRUNCHY");
        public static final zza zzc = new zza("LEGACY");
        public static final zza zzd = new zza("NO_PREFIX");
        private final String zze;

        public final String toString() {
            return this.zze;
        }

        private zza(String str) {
            this.zze = str;
        }
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzqu.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc});
    }

    public static zzb zzd() {
        return new zzb();
    }

    public final zza zze() {
        return this.zzc;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        int i = this.zzb;
        return "AES-CMAC Parameters (variant: " + valueOf + ", " + i + "-byte tags, and " + this.zza + "-byte key)";
    }

    private zzqu(int i, int i2, zza zza2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zza2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzqu)) {
            return false;
        }
        zzqu zzqu = (zzqu) obj;
        if (zzqu.zza == this.zza && zzqu.zzf() == zzf() && zzqu.zzc == this.zzc) {
            return true;
        }
        return false;
    }

    public final boolean zza() {
        return this.zzc != zza.zzd;
    }
}
