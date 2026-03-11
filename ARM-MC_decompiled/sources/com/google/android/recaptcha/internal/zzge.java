package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzge {
    private final Map zza = new LinkedHashMap();
    private final Set zzb = new LinkedHashSet();

    private final List zzh(List list) {
        Iterable<zzue> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (zzue zza2 : iterable) {
            arrayList.add(zza(zza2));
        }
        return (List) arrayList;
    }

    public final Object zza(zzue zzue) throws zzce {
        int zzS = zzue.zzS();
        int i = zzS - 1;
        if (zzS != 0) {
            switch (i) {
                case 0:
                    return this.zza.get(Integer.valueOf(zzue.zzi()));
                case 1:
                    return Boolean.valueOf(zzue.zzQ());
                case 2:
                    byte[] zzl = zzue.zzM().zzl();
                    if (zzl.length == 1) {
                        return Byte.valueOf(zzl[0]);
                    }
                    throw new zzce(4, 6, (Throwable) null);
                case 3:
                    String zzO = zzue.zzO();
                    if (zzO.length() == 1) {
                        return Character.valueOf(zzO.charAt(0));
                    }
                    throw new zzce(4, 6, (Throwable) null);
                case 4:
                    int zzj = zzue.zzj();
                    if (zzj >= -32768 && zzj <= 32767) {
                        return Short.valueOf((short) zzj);
                    }
                    throw new zzce(4, 6, (Throwable) null);
                case 5:
                    return Integer.valueOf(zzue.zzk());
                case 6:
                case 8:
                    throw new zzce(4, 6, (Throwable) null);
                case 7:
                    return Long.valueOf(zzue.zzl());
                case 9:
                    return Float.valueOf(zzue.zzg());
                case 10:
                    return Double.valueOf(zzue.zzf());
                case 11:
                    return zzue.zzP();
                case 12:
                    return null;
                default:
                    throw new zzce(4, 5, (Throwable) null);
            }
        } else {
            throw null;
        }
    }

    public final Object zzb(int i) {
        return this.zza.remove(Integer.valueOf(i));
    }

    public final void zzc() {
        this.zza.clear();
    }

    public final void zzd(int i, Object obj) {
        zze(173, obj);
        this.zzb.add(173);
    }

    public final void zze(int i, Object obj) {
        this.zza.put(Integer.valueOf(i), obj);
    }

    public final Class[] zzf(List list) {
        Iterable<Object> zzh = zzh(list);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(zzh, 10));
        for (Object zza2 : zzh) {
            arrayList.add(zzgc.zza(zza2));
        }
        return (Class[]) ((List) arrayList).toArray(new Class[0]);
    }

    public final Object[] zzg(List list) {
        return zzh(list).toArray(new Object[0]);
    }
}
