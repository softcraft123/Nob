package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdi;
import com.google.android.gms.internal.p002firebaseauthapi.zzdx;
import com.google.android.gms.internal.p002firebaseauthapi.zzjf;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzkb extends zzlg {
    /* access modifiers changed from: private */
    public static final Set<zzcb> zza = ((Set) zzql.zza(new zzkd()));
    private final zzc zzb;
    private final zzb zzc;
    @Nullable
    private final zze zzd;
    private final zzd zze;
    private final zzcb zzf;
    @Nullable
    private final zzaaj zzg;

    public final int hashCode() {
        return Objects.hash(new Object[]{zzkb.class, this.zzb, this.zzc, this.zzd, this.zzf, this.zze, this.zzg});
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkb$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza {
        private zzc zza;
        private zzb zzb;
        private zze zzc;
        private zzcb zzd;
        private zzd zze;
        @Nullable
        private zzaaj zzf;

        public final zza zza(zzc zzc2) {
            this.zza = zzc2;
            return this;
        }

        public final zza zza(zzcb zzcb) throws GeneralSecurityException {
            if (zzkb.zza.contains(zzcb)) {
                this.zzd = zzcb;
                return this;
            }
            throw new GeneralSecurityException("Invalid DEM parameters " + String.valueOf(zzcb) + "; only AES128_GCM_RAW, AES256_GCM_RAW, AES128_CTR_HMAC_SHA256_RAW, AES256_CTR_HMAC_SHA256_RAW XCHACHA20_POLY1305_RAW and AES256_SIV_RAW are currently supported.");
        }

        public final zza zza(zzb zzb2) {
            this.zzb = zzb2;
            return this;
        }

        public final zza zza(zze zze2) {
            this.zzc = zze2;
            return this;
        }

        public final zza zza(zzaaj zzaaj) {
            if (zzaaj.zza() == 0) {
                this.zzf = null;
                return this;
            }
            this.zzf = zzaaj;
            return this;
        }

        public final zza zza(zzd zzd2) {
            this.zze = zzd2;
            return this;
        }

        public final zzkb zza() throws GeneralSecurityException {
            zzc zzc2 = this.zza;
            if (zzc2 == null) {
                throw new GeneralSecurityException("Elliptic curve type is not set");
            } else if (this.zzb == null) {
                throw new GeneralSecurityException("Hash type is not set");
            } else if (this.zzd == null) {
                throw new GeneralSecurityException("DEM parameters are not set");
            } else if (this.zze == null) {
                throw new GeneralSecurityException("Variant is not set");
            } else if (zzc2 != zzc.zzd && this.zzc == null) {
                throw new GeneralSecurityException("Point format is not set");
            } else if (this.zza != zzc.zzd || this.zzc == null) {
                return new zzkb(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
            } else {
                throw new GeneralSecurityException("For Curve25519 point format must not be set");
            }
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = zzd.zzc;
            this.zzf = null;
        }
    }

    public final zzcb zzb() {
        return this.zzf;
    }

    public static zza zzc() {
        return new zza();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkb$zzd */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zzd {
        public static final zzd zza = new zzd("TINK");
        public static final zzd zzb = new zzd("CRUNCHY");
        public static final zzd zzc = new zzd("NO_PREFIX");
        private final String zzd;

        public final String toString() {
            return this.zzd;
        }

        private zzd(String str) {
            this.zzd = str;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkb$zze */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zze {
        public static final zze zza = new zze("COMPRESSED");
        public static final zze zzb = new zze("UNCOMPRESSED");
        public static final zze zzc = new zze("LEGACY_UNCOMPRESSED");
        private final String zzd;

        public final String toString() {
            return this.zzd;
        }

        private zze(String str) {
            this.zzd = str;
        }
    }

    public final zzc zzd() {
        return this.zzb;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkb$zzc */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zzc {
        public static final zzc zza = new zzc("NIST_P256");
        public static final zzc zzb = new zzc("NIST_P384");
        public static final zzc zzc = new zzc("NIST_P521");
        public static final zzc zzd = new zzc("X25519");
        private final String zze;

        public final String toString() {
            return this.zze;
        }

        private zzc(String str) {
            this.zze = str;
        }
    }

    public final zzb zze() {
        return this.zzc;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkb$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zzb {
        public static final zzb zza = new zzb("SHA1");
        public static final zzb zzb = new zzb("SHA224");
        public static final zzb zzc = new zzb("SHA256");
        public static final zzb zzd = new zzb("SHA384");
        public static final zzb zze = new zzb("SHA512");
        private final String zzf;

        public final String toString() {
            return this.zzf;
        }

        private zzb(String str) {
            this.zzf = str;
        }
    }

    @Nullable
    public final zze zzf() {
        return this.zzd;
    }

    public final zzd zzg() {
        return this.zze;
    }

    @Nullable
    public final zzaaj zzh() {
        return this.zzg;
    }

    public final String toString() {
        return String.format("EciesParameters(curveType=%s, hashType=%s, pointFormat=%s, demParameters=%s, variant=%s, salt=%s)", new Object[]{this.zzb, this.zzc, this.zzd, this.zzf, this.zze, this.zzg});
    }

    static /* synthetic */ Set zzj() throws Exception {
        HashSet hashSet = new HashSet();
        hashSet.add(zzdx.zze().zza(12).zzb(16).zzc(16).zza(zzdx.zza.zzc).zza());
        hashSet.add(zzdx.zze().zza(12).zzb(32).zzc(16).zza(zzdx.zza.zzc).zza());
        hashSet.add(zzdi.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdi.zza.zzc).zza(zzdi.zzc.zzc).zza());
        hashSet.add(zzdi.zzf().zza(32).zzb(32).zzd(32).zzc(16).zza(zzdi.zza.zzc).zza(zzdi.zzc.zzc).zza());
        hashSet.add(zzge.zzc());
        hashSet.add(zzjf.zzc().zza(64).zza(zzjf.zza.zzc).zza());
        return Collections.unmodifiableSet(hashSet);
    }

    private zzkb(zzc zzc2, zzb zzb2, @Nullable zze zze2, zzcb zzcb, zzd zzd2, zzaaj zzaaj) {
        this.zzb = zzc2;
        this.zzc = zzb2;
        this.zzd = zze2;
        this.zzf = zzcb;
        this.zze = zzd2;
        this.zzg = zzaaj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzkb)) {
            return false;
        }
        zzkb zzkb = (zzkb) obj;
        if (!Objects.equals(zzkb.zzb, this.zzb) || !Objects.equals(zzkb.zzc, this.zzc) || !Objects.equals(zzkb.zzd, this.zzd) || !Objects.equals(zzkb.zzf, this.zzf) || !Objects.equals(zzkb.zze, this.zze) || !Objects.equals(zzkb.zzg, this.zzg)) {
            return false;
        }
        return true;
    }

    public final boolean zza() {
        return this.zze != zzd.zzc;
    }
}
