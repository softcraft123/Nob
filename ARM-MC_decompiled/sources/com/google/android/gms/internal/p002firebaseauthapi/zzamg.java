package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzamg<K, V> extends LinkedHashMap<K, V> {
    private static final zzamg<?, ?> zza;
    private boolean zzb = true;

    private static int zza(Object obj) {
        if (obj instanceof byte[]) {
            return zzalh.zza((byte[]) obj);
        }
        if (!(obj instanceof zzalk)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        int i = 0;
        for (Map.Entry entry : entrySet()) {
            i += zza(entry.getValue()) ^ zza(entry.getKey());
        }
        return i;
    }

    public static <K, V> zzamg<K, V> zza() {
        return zza;
    }

    public final zzamg<K, V> zzb() {
        return isEmpty() ? new zzamg<>() : new zzamg<>(this);
    }

    public final V put(K k, V v) {
        zze();
        zzalh.zza(k);
        zzalh.zza(v);
        return super.put(k, v);
    }

    public final V remove(Object obj) {
        zze();
        return super.remove(obj);
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    static {
        zzamg<?, ?> zzamg = new zzamg<>();
        zza = zzamg;
        zzamg.zzb = false;
    }

    private zzamg() {
    }

    private zzamg(Map<K, V> map) {
        super(map);
    }

    public final void clear() {
        zze();
        super.clear();
    }

    private final void zze() {
        if (!this.zzb) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzc() {
        this.zzb = false;
    }

    public final void zza(zzamg<K, V> zzamg) {
        zze();
        if (!zzamg.isEmpty()) {
            putAll(zzamg);
        }
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zze();
        for (Object next : map.keySet()) {
            zzalh.zza(next);
            zzalh.zza(map.get(next));
        }
        super.putAll(map);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                z = value.equals(obj2);
                continue;
            } else {
                z = Arrays.equals((byte[]) value, (byte[]) obj2);
                continue;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final boolean zzd() {
        return this.zzb;
    }
}
