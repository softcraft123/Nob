package com.google.android.gms.internal.fido;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzff extends AbstractSet {
    final int zza = -1;
    final /* synthetic */ zzfg zzb;

    zzff(zzfg zzfg, int i) {
        this.zzb = zzfg;
    }

    public final boolean contains(Object obj) {
        Comparator comparator;
        int i = this.zza;
        Object[] zzc = this.zzb.zzb;
        int zzb2 = zzb();
        int zza2 = zza();
        if (i == -1) {
            comparator = zzfg.zza;
        } else {
            comparator = zzfi.zza;
        }
        return Arrays.binarySearch(zzc, zzb2, zza2, obj, comparator) >= 0;
    }

    public final Iterator iterator() {
        return new zzfe(this);
    }

    public final int size() {
        return zza() - zzb();
    }

    /* access modifiers changed from: package-private */
    public final int zza() {
        return this.zzb.zzc[this.zza + 1];
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        if (this.zza == -1) {
            return 0;
        }
        return this.zzb.zzc[0];
    }
}
