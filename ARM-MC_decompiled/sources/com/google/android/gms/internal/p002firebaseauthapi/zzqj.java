package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzqj {
    private final Class<?> zza;
    private final Class<? extends zzqf> zzb;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        return simpleName + " with serialization type: " + this.zzb.getSimpleName();
    }

    private zzqj(Class<?> cls, Class<? extends zzqf> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzqj)) {
            return false;
        }
        zzqj zzqj = (zzqj) obj;
        if (!zzqj.zza.equals(this.zza) || !zzqj.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }
}
