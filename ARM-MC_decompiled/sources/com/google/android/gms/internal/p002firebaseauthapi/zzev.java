package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzev  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzev extends zzcy {
    private final String zza;
    private final zza zzb;

    public final int hashCode() {
        return Objects.hash(new Object[]{zzev.class, this.zza, this.zzb});
    }

    public final zza zzb() {
        return this.zzb;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzev$zza */
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

    public static zzev zza(String str, zza zza2) {
        return new zzev(str, zza2);
    }

    public final String zzc() {
        return this.zza;
    }

    public final String toString() {
        String str = this.zza;
        return "LegacyKmsAead Parameters (keyUri: " + str + ", variant: " + String.valueOf(this.zzb) + ")";
    }

    private zzev(String str, zza zza2) {
        this.zza = str;
        this.zzb = zza2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzev)) {
            return false;
        }
        zzev zzev = (zzev) obj;
        if (!zzev.zza.equals(this.zza) || !zzev.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final boolean zza() {
        return this.zzb != zza.zzb;
    }
}
