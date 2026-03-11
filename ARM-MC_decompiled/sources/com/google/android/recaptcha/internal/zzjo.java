package com.google.android.recaptcha.internal;

import java.util.Iterator;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzjo implements Iterator {
    boolean zza = true;
    final /* synthetic */ Iterator zzb;

    zzjo(zzjp zzjp, Iterator it) {
        this.zzb = it;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        Object next = this.zzb.next();
        this.zza = false;
        return next;
    }

    public final void remove() {
        zzjf.zze(!this.zza, "no calls to next() since the last call to remove()");
        this.zzb.remove();
    }
}
