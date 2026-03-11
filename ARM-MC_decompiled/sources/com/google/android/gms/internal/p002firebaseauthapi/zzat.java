package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzat  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzat<K> extends zzaq<K> {
    private final transient zzal<K, ?> zza;
    private final transient zzah<K> zzb;

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzah<K> zzc() {
        return this.zzb;
    }

    public final zzay<K> zzd() {
        return (zzay) zzc().iterator();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    zzat(zzal<K, ?> zzal, zzah<K> zzah) {
        this.zza = zzal;
        this.zzb = zzah;
    }

    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }
}
