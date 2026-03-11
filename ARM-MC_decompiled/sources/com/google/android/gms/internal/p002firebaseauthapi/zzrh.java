package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzrh extends zzrn {
    private final int zza;
    private final int zzb;
    private final zzc zzc;
    private final zza zzd;

    public final int zzb() {
        return this.zzb;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrh$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zzb {
        @Nullable
        private Integer zza;
        @Nullable
        private Integer zzb;
        private zza zzc;
        private zzc zzd;

        public final zzb zza(zza zza2) {
            this.zzc = zza2;
            return this;
        }

        public final zzb zza(int i) throws GeneralSecurityException {
            this.zza = Integer.valueOf(i);
            return this;
        }

        public final zzb zzb(int i) throws GeneralSecurityException {
            this.zzb = Integer.valueOf(i);
            return this;
        }

        public final zzb zza(zzc zzc2) {
            this.zzd = zzc2;
            return this;
        }

        public final zzrh zza() throws GeneralSecurityException {
            Integer num = this.zza;
            if (num == null) {
                throw new GeneralSecurityException("key size is not set");
            } else if (this.zzb == null) {
                throw new GeneralSecurityException("tag size is not set");
            } else if (this.zzc == null) {
                throw new GeneralSecurityException("hash type is not set");
            } else if (this.zzd == null) {
                throw new GeneralSecurityException("variant is not set");
            } else if (num.intValue() >= 16) {
                int intValue = this.zzb.intValue();
                zza zza2 = this.zzc;
                if (intValue >= 10) {
                    if (zza2 == zza.zza) {
                        if (intValue > 20) {
                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", new Object[]{Integer.valueOf(intValue)}));
                        }
                    } else if (zza2 == zza.zzb) {
                        if (intValue > 28) {
                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", new Object[]{Integer.valueOf(intValue)}));
                        }
                    } else if (zza2 == zza.zzc) {
                        if (intValue > 32) {
                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", new Object[]{Integer.valueOf(intValue)}));
                        }
                    } else if (zza2 == zza.zzd) {
                        if (intValue > 48) {
                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", new Object[]{Integer.valueOf(intValue)}));
                        }
                    } else if (zza2 != zza.zze) {
                        throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
                    } else if (intValue > 64) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", new Object[]{Integer.valueOf(intValue)}));
                    }
                    return new zzrh(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc);
                }
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", new Object[]{Integer.valueOf(intValue)}));
            } else {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", new Object[]{this.zza}));
            }
        }

        private zzb() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = zzc.zzd;
        }
    }

    public final int zzc() {
        return this.zza;
    }

    private final int zzg() {
        int i;
        if (this.zzc == zzc.zzd) {
            return this.zzb;
        }
        if (this.zzc == zzc.zza) {
            i = this.zzb;
        } else if (this.zzc == zzc.zzb) {
            i = this.zzb;
        } else if (this.zzc == zzc.zzc) {
            i = this.zzb;
        } else {
            throw new IllegalStateException("Unknown variant");
        }
        return i + 5;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrh$zzc */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zzc {
        public static final zzc zza = new zzc("TINK");
        public static final zzc zzb = new zzc("CRUNCHY");
        public static final zzc zzc = new zzc("LEGACY");
        public static final zzc zzd = new zzc("NO_PREFIX");
        private final String zze;

        public final String toString() {
            return this.zze;
        }

        private zzc(String str) {
            this.zze = str;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrh$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza {
        public static final zza zza = new zza("SHA1");
        public static final zza zzb = new zza("SHA224");
        public static final zza zzc = new zza("SHA256");
        public static final zza zzd = new zza("SHA384");
        public static final zza zze = new zza("SHA512");
        private final String zzf;

        public final String toString() {
            return this.zzf;
        }

        private zza(String str) {
            this.zzf = str;
        }
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzrh.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public static zzb zzd() {
        return new zzb();
    }

    public final zza zze() {
        return this.zzd;
    }

    public final zzc zzf() {
        return this.zzc;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        int i = this.zzb;
        return "HMAC Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + i + "-byte tags, and " + this.zza + "-byte key)";
    }

    private zzrh(int i, int i2, zzc zzc2, zza zza2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzc2;
        this.zzd = zza2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzrh)) {
            return false;
        }
        zzrh zzrh = (zzrh) obj;
        if (zzrh.zza == this.zza && zzrh.zzg() == zzg() && zzrh.zzc == this.zzc && zzrh.zzd == this.zzd) {
            return true;
        }
        return false;
    }

    public final boolean zza() {
        return this.zzc != zzc.zzd;
    }
}
