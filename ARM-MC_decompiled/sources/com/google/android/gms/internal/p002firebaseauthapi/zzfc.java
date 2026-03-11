package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzfc extends zzcy {
    private final zzc zza;
    private final String zzb;
    private final zza zzc;
    private final zzcy zzd;

    public final int hashCode() {
        return Objects.hash(new Object[]{zzfc.class, this.zzb, this.zzc, this.zzd, this.zza});
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfc$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static class zzb {
        @Nullable
        private zzc zza;
        @Nullable
        private String zzb;
        @Nullable
        private zza zzc;
        @Nullable
        private zzcy zzd;

        public final zzb zza(zzcy zzcy) {
            this.zzd = zzcy;
            return this;
        }

        public final zzb zza(zza zza2) {
            this.zzc = zza2;
            return this;
        }

        public final zzb zza(String str) {
            this.zzb = str;
            return this;
        }

        public final zzb zza(zzc zzc2) {
            this.zza = zzc2;
            return this;
        }

        public final zzfc zza() throws GeneralSecurityException {
            if (this.zza == null) {
                this.zza = zzc.zzb;
            }
            if (this.zzb == null) {
                throw new GeneralSecurityException("kekUri must be set");
            } else if (this.zzc != null) {
                zzcy zzcy = this.zzd;
                if (zzcy == null) {
                    throw new GeneralSecurityException("dekParametersForNewKeys must be set");
                } else if (!zzcy.zza()) {
                    zza zza2 = this.zzc;
                    zzcy zzcy2 = this.zzd;
                    if ((zza2.equals(zza.zza) && (zzcy2 instanceof zzdx)) || ((zza2.equals(zza.zzc) && (zzcy2 instanceof zzem)) || ((zza2.equals(zza.zzb) && (zzcy2 instanceof zzge)) || ((zza2.equals(zza.zzd) && (zzcy2 instanceof zzdi)) || ((zza2.equals(zza.zze) && (zzcy2 instanceof zzdq)) || (zza2.equals(zza.zzf) && (zzcy2 instanceof zzeg))))))) {
                        return new zzfc(this.zza, this.zzb, this.zzc, this.zzd);
                    }
                    String zza3 = this.zzc.toString();
                    throw new GeneralSecurityException("Cannot use parsing strategy " + zza3 + " when new keys are picked according to " + String.valueOf(this.zzd) + ".");
                } else {
                    throw new GeneralSecurityException("dekParametersForNewKeys must not have ID Requirements");
                }
            } else {
                throw new GeneralSecurityException("dekParsingStrategy must be set");
            }
        }

        private zzb() {
        }
    }

    public final zzcy zzb() {
        return this.zzd;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfc$zzc */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zzc {
        public static final zzc zza = new zzc("TINK");
        public static final zzc zzb = new zzc("NO_PREFIX");
        private final String zzc;

        public final String toString() {
            return this.zzc;
        }

        private zzc(String str) {
            this.zzc = str;
        }
    }

    public final zzc zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final String toString() {
        String str = this.zzb;
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        return "LegacyKmsEnvelopeAead Parameters (kekUri: " + str + ", dekParsingStrategy: " + valueOf + ", dekParametersForNewKeys: " + valueOf2 + ", variant: " + String.valueOf(this.zza) + ")";
    }

    private zzfc(zzc zzc2, String str, zza zza2, zzcy zzcy) {
        this.zza = zzc2;
        this.zzb = str;
        this.zzc = zza2;
        this.zzd = zzcy;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfc$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza {
        public static final zza zza = new zza("ASSUME_AES_GCM");
        public static final zza zzb = new zza("ASSUME_XCHACHA20POLY1305");
        public static final zza zzc = new zza("ASSUME_CHACHA20POLY1305");
        public static final zza zzd = new zza("ASSUME_AES_CTR_HMAC");
        public static final zza zze = new zza("ASSUME_AES_EAX");
        public static final zza zzf = new zza("ASSUME_AES_GCM_SIV");
        private final String zzg;

        public final String toString() {
            return this.zzg;
        }

        private zza(String str) {
            this.zzg = str;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfc)) {
            return false;
        }
        zzfc zzfc = (zzfc) obj;
        if (!zzfc.zzc.equals(this.zzc) || !zzfc.zzd.equals(this.zzd) || !zzfc.zzb.equals(this.zzb) || !zzfc.zza.equals(this.zza)) {
            return false;
        }
        return true;
    }

    public final boolean zza() {
        return this.zza != zzc.zzb;
    }
}
