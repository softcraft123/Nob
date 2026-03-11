package com.google.android.gms.internal.fido;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzfe implements Iterator {
    final /* synthetic */ zzff zza;
    private int zzb = 0;

    zzfe(zzff zzff) {
        this.zza = zzff;
    }

    public final boolean hasNext() {
        int i = this.zzb;
        zzff zzff = this.zza;
        return i < zzff.zza() - zzff.zzb();
    }

    public final Object next() {
        int i = this.zzb;
        zzff zzff = this.zza;
        if (i < zzff.zza() - zzff.zzb()) {
            zzff zzff2 = this.zza;
            Object obj = zzff2.zzb.zzb[zzff2.zzb() + i];
            this.zzb = i + 1;
            return obj;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
