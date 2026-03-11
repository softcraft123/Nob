package com.google.android.gms.internal.fido;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzct extends zzcc {
    static final zzcc zza = new zzct(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzct(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public final Object get(int i) {
        zzbm.zza(i, this.zzc, "index");
        return Objects.requireNonNull(this.zzb[i]);
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzb;
    }
}
