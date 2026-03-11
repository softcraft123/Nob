package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzamx {
    private static final zzamx zza = new zzamx();
    private final zzane zzb = new zzama();
    private final ConcurrentMap<Class<?>, zzanb<?>> zzc = new ConcurrentHashMap();

    public static zzamx zza() {
        return zza;
    }

    public final <T> zzanb<T> zza(Class<T> cls) {
        zzalh.zza(cls, "messageType");
        zzanb<T> zzanb = (zzanb) this.zzc.get(cls);
        if (zzanb == null) {
            zzanb = this.zzb.zza(cls);
            zzalh.zza(cls, "messageType");
            zzalh.zza(zzanb, "schema");
            zzanb<T> putIfAbsent = this.zzc.putIfAbsent(cls, zzanb);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
        }
        return zzanb;
    }

    public final <T> zzanb<T> zza(T t) {
        return zza(t.getClass());
    }

    private zzamx() {
    }
}
