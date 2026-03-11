package com.google.android.gms.internal.fido;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzcm extends zzdc {
    private static final Object zza = new Object();
    private Object zzb;

    zzcm(Object obj) {
        this.zzb = obj;
    }

    public final boolean hasNext() {
        return this.zzb != zza;
    }

    public final Object next() {
        Object obj = this.zzb;
        Object obj2 = zza;
        if (obj != obj2) {
            this.zzb = obj2;
            return obj;
        }
        throw new NoSuchElementException();
    }
}
