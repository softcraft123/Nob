package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzfz extends zzcy {
    private final zza zza;
    private final int zzb;

    public final int zzb() {
        return this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzfz.class, this.zza, Integer.valueOf(this.zzb)});
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfz$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza {
        public static final zza zza = new zza("TINK");
        public static final zza zzb = new zza("NO_PREFIX");
        private final String zzc;

        public final String toString() {
            return this.zzc;
        }

        private zza(String str) {
            this.zzc = str;
        }
    }

    public final zza zzc() {
        return this.zza;
    }

    public static zzfz zza(zza zza2, int i) throws GeneralSecurityException {
        if (i >= 8 && i <= 12) {
            return new zzfz(zza2, i);
        }
        throw new GeneralSecurityException("Salt size must be between 8 and 12 bytes");
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return "X-AES-GCM Parameters (variant: " + valueOf + "salt_size_bytes: " + this.zzb + ")";
    }

    private zzfz(zza zza2, int i) {
        this.zza = zza2;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfz)) {
            return false;
        }
        zzfz zzfz = (zzfz) obj;
        if (zzfz.zza == this.zza && zzfz.zzb == this.zzb) {
            return true;
        }
        return false;
    }

    public final boolean zza() {
        return this.zza != zza.zzb;
    }
}
