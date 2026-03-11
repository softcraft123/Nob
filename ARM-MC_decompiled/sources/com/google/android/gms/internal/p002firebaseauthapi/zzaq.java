package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public abstract class zzaq<E> extends zzag<E> implements Set<E> {
    private transient zzah<E> zza;

    public int hashCode() {
        return zzav.zza(this);
    }

    public zzah<E> zzc() {
        zzah<E> zzah = this.zza;
        if (zzah != null) {
            return zzah;
        }
        zzah<E> zzf = zzf();
        this.zza = zzf;
        return zzf;
    }

    /* access modifiers changed from: package-private */
    public zzah<E> zzf() {
        return zzah.zza(toArray());
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    zzaq() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return zzav.zza(this, obj);
    }
}
