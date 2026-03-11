package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.NoSuchElementException;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzajy extends zzaka {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzajv zzc;

    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }

    zzajy(zzajv zzajv) {
        Objects.requireNonNull(zzajv);
        this.zzc = zzajv;
        this.zzb = zzajv.zzb();
    }

    public final boolean hasNext() {
        return this.zza < this.zzb;
    }
}
