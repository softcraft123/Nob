package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzamb implements zzamj {
    private zzamj[] zza;

    public final zzamk zza(Class<?> cls) {
        for (zzamj zzamj : this.zza) {
            if (zzamj.zzb(cls)) {
                return zzamj.zza(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
    }

    zzamb(zzamj... zzamjArr) {
        this.zza = zzamjArr;
    }

    public final boolean zzb(Class<?> cls) {
        for (zzamj zzb : this.zza) {
            if (zzb.zzb(cls)) {
                return true;
            }
        }
        return false;
    }
}
