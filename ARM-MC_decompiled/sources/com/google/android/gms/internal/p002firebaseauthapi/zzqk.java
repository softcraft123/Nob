package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzqk {
    private final Class<? extends zzqf> zza;
    private final zzaaj zzb;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        return simpleName + ", object identifier: " + String.valueOf(this.zzb);
    }

    private zzqk(Class<? extends zzqf> cls, zzaaj zzaaj) {
        this.zza = cls;
        this.zzb = zzaaj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzqk)) {
            return false;
        }
        zzqk zzqk = (zzqk) obj;
        if (!zzqk.zza.equals(this.zza) || !zzqk.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }
}
