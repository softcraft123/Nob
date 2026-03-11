package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzalp<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzalq> zza;

    public final zzalq zza() {
        return this.zza.getValue();
    }

    public final K getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        throw new NoSuchMethodError();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzamm) {
            return this.zza.getValue().zza((zzamm) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    private zzalp(Map.Entry<K, zzalq> entry) {
        this.zza = entry;
    }
}
