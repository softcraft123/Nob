package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzpo implements Iterable<P> {
    private final /* synthetic */ List zza;
    private final /* synthetic */ List zzb;

    public final Iterator<P> iterator() {
        return new zzpq(this.zza.iterator(), this.zzb.iterator());
    }

    zzpo(zzpl zzpl, List list, List list2) {
        this.zza = list;
        this.zzb = list2;
        Objects.requireNonNull(zzpl);
    }
}
