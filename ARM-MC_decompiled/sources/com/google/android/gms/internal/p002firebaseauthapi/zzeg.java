package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzeg extends zzcy {
    private final int zza;
    private final zzb zzb;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeg$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza {
        @Nullable
        private Integer zza;
        private zzb zzb;

        public final zza zza(int i) throws GeneralSecurityException {
            if (i == 16 || i == 32) {
                this.zza = Integer.valueOf(i);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
        }

        public final zza zza(zzb zzb2) {
            this.zzb = zzb2;
            return this;
        }

        public final zzeg zza() throws GeneralSecurityException {
            if (this.zza == null) {
                throw new GeneralSecurityException("Key size is not set");
            } else if (this.zzb != null) {
                return new zzeg(this.zza.intValue(), this.zzb);
            } else {
                throw new GeneralSecurityException("Variant is not set");
            }
        }

        private zza() {
            this.zza = null;
            this.zzb = zzb.zzc;
        }
    }

    public final int zzb() {
        return this.zza;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzeg.class, Integer.valueOf(this.zza), this.zzb});
    }

    public static zza zzc() {
        return new zza();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeg$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zzb {
        public static final zzb zza = new zzb("TINK");
        public static final zzb zzb = new zzb("CRUNCHY");
        public static final zzb zzc = new zzb("NO_PREFIX");
        private final String zzd;

        public final String toString() {
            return this.zzd;
        }

        private zzb(String str) {
            this.zzd = str;
        }
    }

    public final zzb zzd() {
        return this.zzb;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        return "AesGcmSiv Parameters (variant: " + valueOf + ", " + this.zza + "-byte key)";
    }

    private zzeg(int i, zzb zzb2) {
        this.zza = i;
        this.zzb = zzb2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzeg)) {
            return false;
        }
        zzeg zzeg = (zzeg) obj;
        if (zzeg.zza == this.zza && zzeg.zzb == this.zzb) {
            return true;
        }
        return false;
    }

    public final boolean zza() {
        return this.zzb != zzb.zzc;
    }
}
