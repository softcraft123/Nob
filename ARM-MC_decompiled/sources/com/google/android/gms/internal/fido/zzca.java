package com.google.android.gms.internal.fido;

import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzca extends zzcc {
    private final transient zzcc zza;

    zzca(zzcc zzcc) {
        this.zza = zzcc;
    }

    private final int zzl(int i) {
        return (this.zza.size() - 1) - i;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.contains(obj);
    }

    public final Object get(int i) {
        zzbm.zza(i, this.zza.size(), "index");
        return this.zza.get(zzl(i));
    }

    public final int indexOf(@CheckForNull Object obj) {
        int lastIndexOf = this.zza.lastIndexOf(obj);
        if (lastIndexOf >= 0) {
            return zzl(lastIndexOf);
        }
        return -1;
    }

    public final int lastIndexOf(@CheckForNull Object obj) {
        int indexOf = this.zza.indexOf(obj);
        if (indexOf >= 0) {
            return zzl(indexOf);
        }
        return -1;
    }

    public final int size() {
        return this.zza.size();
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    public final zzcc zzf() {
        return this.zza;
    }

    public final zzcc zzg(int i, int i2) {
        zzbm.zze(i, i2, this.zza.size());
        zzcc zzcc = this.zza;
        return zzcc.subList(zzcc.size() - i2, this.zza.size() - i).zzf();
    }
}
