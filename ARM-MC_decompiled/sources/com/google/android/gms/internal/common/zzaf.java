package com.google.android.gms.internal.common;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
final class zzaf extends zzah {
    private final transient zzah zza;

    zzaf(zzah zzah) {
        this.zza = zzah;
    }

    private final int zzs(int i) {
        return (this.zza.size() - 1) - i;
    }

    public final boolean contains(Object obj) {
        return this.zza.contains(obj);
    }

    public final Object get(int i) {
        zzah zzah = this.zza;
        zzr.zzb(i, zzah.size(), "index");
        return zzah.get(zzs(i));
    }

    public final int indexOf(Object obj) {
        int lastIndexOf = this.zza.lastIndexOf(obj);
        if (lastIndexOf >= 0) {
            return zzs(lastIndexOf);
        }
        return -1;
    }

    public final int lastIndexOf(Object obj) {
        int indexOf = this.zza.indexOf(obj);
        if (indexOf >= 0) {
            return zzs(indexOf);
        }
        return -1;
    }

    public final int size() {
        return this.zza.size();
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return this.zza.zzf();
    }

    public final zzah zzh() {
        return this.zza;
    }

    public final zzah zzi(int i, int i2) {
        zzah zzah = this.zza;
        zzr.zzd(i, i2, zzah.size());
        return zzah.subList(zzah.size() - i2, zzah.size() - i).zzh();
    }
}
