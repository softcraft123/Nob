package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzam  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzam extends zzah<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzah zzc;

    /* access modifiers changed from: package-private */
    public final int zza() {
        return this.zzc.zzb() + this.zza + this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc.zzb() + this.zza;
    }

    public final int size() {
        return this.zzb;
    }

    public final zzah<E> zza(int i, int i2) {
        zzu.zza(i, i2, this.zzb);
        zzah zzah = this.zzc;
        int i3 = this.zza;
        return (zzah) zzah.subList(i + i3, i2 + i3);
    }

    public final E get(int i) {
        zzu.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    zzam(zzah zzah, int i, int i2) {
        Objects.requireNonNull(zzah);
        this.zzc = zzah;
        this.zza = i;
        this.zzb = i2;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzc.zze();
    }
}
