package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzame  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzame<K, V> {
    static <K, V> int zza(zzamd<K, V> zzamd, K k, V v) {
        return zzakx.zza(zzamd.zza, 1, k) + zzakx.zza(zzamd.zzc, 2, v);
    }

    static <K, V> void zza(zzakn zzakn, zzamd<K, V> zzamd, K k, V v) throws IOException {
        zzakx.zza(zzakn, zzamd.zza, 1, k);
        zzakx.zza(zzakn, zzamd.zzc, 2, v);
    }
}
