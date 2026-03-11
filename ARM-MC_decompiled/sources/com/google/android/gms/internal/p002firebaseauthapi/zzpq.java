package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzpq<P> implements Iterator<P> {
    private final Iterator<P> zza;
    private final Iterator<P> zzb;

    public final P next() {
        if (this.zza.hasNext()) {
            return this.zza.next();
        }
        return this.zzb.next();
    }

    private zzpq(Iterator<P> it, Iterator<P> it2) {
        this.zza = it;
        this.zzb = it2;
    }

    public final boolean hasNext() {
        return this.zza.hasNext() || this.zzb.hasNext();
    }
}
