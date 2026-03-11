package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzals  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzals<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zza;

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zza.next();
        return next.getValue() instanceof zzalq ? new zzalp(next) : next;
    }

    public zzals(Iterator<Map.Entry<K, Object>> it) {
        this.zza = it;
    }

    public final void remove() {
        this.zza.remove();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }
}
