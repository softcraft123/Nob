package com.google.android.gms.internal.fido;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzhg extends zzhp {
    private final zzcc zza;
    private final int zzb;

    zzhg(zzcc zzcc) throws zzhf {
        zzcc.getClass();
        this.zza = zzcc;
        int i = 0;
        int i2 = 0;
        while (true) {
            zzcc zzcc2 = this.zza;
            if (i >= zzcc2.size()) {
                break;
            }
            int zzb2 = ((zzhp) zzcc2.get(i)).zzb();
            if (i2 < zzb2) {
                i2 = zzb2;
            }
            i++;
        }
        int i3 = i2 + 1;
        this.zzb = i3;
        if (i3 > 8) {
            throw new zzhf("Exceeded cutoff limit for max depth of cbor value");
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzhp zzhp = (zzhp) obj;
        if (zzd(Byte.MIN_VALUE) != zzhp.zza()) {
            return zzd(Byte.MIN_VALUE) - zzhp.zza();
        }
        zzhg zzhg = (zzhg) zzhp;
        zzcc zzcc = this.zza;
        int size = zzcc.size();
        zzcc zzcc2 = zzhg.zza;
        if (size != zzcc2.size()) {
            return zzcc.size() - zzcc2.size();
        }
        int i = 0;
        while (true) {
            zzcc zzcc3 = this.zza;
            if (i >= zzcc3.size()) {
                return 0;
            }
            int compareTo = ((zzhp) zzcc3.get(i)).compareTo((zzhp) zzhg.zza.get(i));
            if (compareTo != 0) {
                return compareTo;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.zza.equals(((zzhg) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzd(Byte.MIN_VALUE)), this.zza});
    }

    public final String toString() {
        if (this.zza.isEmpty()) {
            return "[]";
        }
        ArrayList arrayList = new ArrayList();
        zzcc zzcc = this.zza;
        int size = zzcc.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((zzhp) zzcc.get(i)).toString().replace("\n", "\n  "));
        }
        zzbd zza2 = zzbd.zza(",\n  ");
        StringBuilder sb = new StringBuilder("[\n  ");
        zza2.zzc(sb, arrayList.iterator());
        sb.append("\n]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        return zzd(Byte.MIN_VALUE);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        return this.zzb;
    }
}
