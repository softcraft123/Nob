package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzal  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public abstract class zzal<K, V> implements Serializable, Map<K, V> {
    private transient zzaq<Map.Entry<K, V>> zza;
    private transient zzaq<K> zzb;
    private transient zzag<V> zzc;

    public abstract V get(Object obj);

    public int hashCode() {
        return zzav.zza((zzaq) entrySet());
    }

    /* access modifiers changed from: package-private */
    public abstract zzag<V> zza();

    /* access modifiers changed from: package-private */
    public abstract zzaq<Map.Entry<K, V>> zzb();

    /* access modifiers changed from: package-private */
    public abstract zzaq<K> zzc();

    /* access modifiers changed from: package-private */
    public abstract boolean zzd();

    public static <K, V> zzal<K, V> zza(Map<? extends K, ? extends V> map) {
        if (!(map instanceof zzal) || (map instanceof SortedMap)) {
            Set<Map.Entry<? extends K, ? extends V>> entrySet = map.entrySet();
            zzao zzao = new zzao(entrySet instanceof Collection ? entrySet.size() : 4);
            zzao.zza(entrySet);
            return zzao.zza();
        }
        zzal<K, V> zzal = (zzal) map;
        zzal.zzd();
        return zzal;
    }

    public final V getOrDefault(Object obj, V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        int size = size();
        zzae.zza(size, "size");
        StringBuilder append = new StringBuilder((int) Math.min(((long) size) << 3, 1073741824)).append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                append.append(", ");
            }
            append.append(entry.getKey()).append('=').append(entry.getValue());
            z = false;
        }
        return append.append('}').toString();
    }

    public /* synthetic */ Collection values() {
        zzag<V> zzag = this.zzc;
        if (zzag != null) {
            return zzag;
        }
        zzag<V> zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    public /* synthetic */ Set entrySet() {
        zzaq<Map.Entry<K, V>> zzaq = this.zza;
        if (zzaq != null) {
            return zzaq;
        }
        zzaq<Map.Entry<K, V>> zzb2 = zzb();
        this.zza = zzb2;
        return zzb2;
    }

    public /* synthetic */ Set keySet() {
        zzaq<K> zzaq = this.zzb;
        if (zzaq != null) {
            return zzaq;
        }
        zzaq<K> zzc2 = zzc();
        this.zzb = zzc2;
        return zzc2;
    }

    zzal() {
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        return ((zzag) values()).contains(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
