package com.google.android.gms.internal.fido;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzgo extends zzgq {
    final /* synthetic */ zzgx zza;
    private int zzb = 0;
    private final int zzc;

    zzgo(zzgx zzgx) {
        this.zza = zzgx;
        this.zzc = zzgx.zzd();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
