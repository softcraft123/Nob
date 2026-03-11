package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzanm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
class zzanm extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzang zza;

    public int size() {
        return this.zza.size();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzanj(this.zza);
    }

    private zzanm(zzang zzang) {
        Objects.requireNonNull(zzang);
        this.zza = zzang;
    }

    public void clear() {
        this.zza.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zza.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zza.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zza.remove(entry.getKey());
        return true;
    }
}
