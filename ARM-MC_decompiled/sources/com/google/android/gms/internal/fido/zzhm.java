package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzhm extends zzhp {
    private final int zza;
    private final zzcj zzb;

    zzhm(zzcj zzcj) throws zzhf {
        zzcj.getClass();
        this.zzb = zzcj;
        zzdc zzd = zzcj.entrySet().iterator();
        int i = 0;
        while (zzd.hasNext()) {
            Map.Entry entry = (Map.Entry) zzd.next();
            int zzb2 = ((zzhp) entry.getKey()).zzb();
            i = i < zzb2 ? zzb2 : i;
            int zzb3 = ((zzhp) entry.getValue()).zzb();
            if (i < zzb3) {
                i = zzb3;
            }
        }
        int i2 = i + 1;
        this.zza = i2;
        if (i2 > 8) {
            throw new zzhf("Exceeded cutoff limit for max depth of cbor value");
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        int compareTo;
        int size;
        int size2;
        zzhp zzhp = (zzhp) obj;
        if (zzd((byte) -96) != zzhp.zza()) {
            size2 = zzhp.zza();
            size = zzd((byte) -96);
        } else {
            zzhm zzhm = (zzhm) zzhp;
            if (this.zzb.size() != zzhm.zzb.size()) {
                size = this.zzb.size();
                size2 = zzhm.zzb.size();
            } else {
                zzdc zzd = this.zzb.entrySet().iterator();
                zzdc zzd2 = zzhm.zzb.entrySet().iterator();
                do {
                    if (!zzd.hasNext() && !zzd2.hasNext()) {
                        return 0;
                    }
                    Map.Entry entry = (Map.Entry) zzd.next();
                    Map.Entry entry2 = (Map.Entry) zzd2.next();
                    int compareTo2 = ((zzhp) entry.getKey()).compareTo((zzhp) entry2.getKey());
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    compareTo = ((zzhp) entry.getValue()).compareTo((zzhp) entry2.getValue());
                } while (compareTo == 0);
                return compareTo;
            }
        }
        return size - size2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.zzb.equals(((zzhm) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzd((byte) -96)), this.zzb});
    }

    public final String toString() {
        if (this.zzb.isEmpty()) {
            return "{}";
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        zzdc zzd = this.zzb.entrySet().iterator();
        while (zzd.hasNext()) {
            Map.Entry entry = (Map.Entry) zzd.next();
            linkedHashMap.put(((zzhp) entry.getKey()).toString().replace("\n", "\n  "), ((zzhp) entry.getValue()).toString().replace("\n", "\n  "));
        }
        zzbd zza2 = zzbd.zza(",\n  ");
        StringBuilder sb = new StringBuilder("{\n  ");
        try {
            zzbc.zza(sb, linkedHashMap.entrySet().iterator(), zza2, " : ");
            sb.append("\n}");
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        return zzd((byte) -96);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        return this.zza;
    }

    public final zzcj zzc() {
        return this.zzb;
    }
}
