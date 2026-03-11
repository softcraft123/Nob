package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzand  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzand {
    private static final zzanu<?, ?> zza = new zzanw();

    @Deprecated
    static int zza(int i, zzamm zzamm, zzanb zzanb) {
        return (zzakn.zzh(i) << 1) + ((zzajm) zzamm).zza(zzanb);
    }

    private static int zza(zzajm zzajm, zzanb zzanb) {
        return zzakn.zzd(zzajm.zza(zzanb));
    }

    static int zza(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzakn.zza(i, true);
    }

    static int zza(List<?> list) {
        return list.size();
    }

    static int zza(int i, List<zzajv> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzh = size * zzakn.zzh(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzh += zzakn.zza(list.get(i2));
        }
        return zzh;
    }

    static int zzb(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzakn.zzh(i));
    }

    static int zzb(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzali) {
            zzali zzali = (zzali) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzakn.zza(zzali.zzb(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzakn.zza(list.get(i).intValue());
            i++;
        }
        return i3;
    }

    static int zzc(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzakn.zzb(i, 0);
    }

    static int zzc(List<?> list) {
        return list.size() << 2;
    }

    static int zzd(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzakn.zza(i, 0);
    }

    static int zzd(List<?> list) {
        return list.size() << 3;
    }

    static int zza(int i, List<zzamm> list, zzanb<?> zzanb) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zza(i, list.get(i3), (zzanb) zzanb);
        }
        return i2;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzakn.zzh(i));
    }

    static int zze(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzali) {
            zzali zzali = (zzali) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzakn.zzc(zzali.zzb(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzakn.zzc(list.get(i).intValue());
            i++;
        }
        return i3;
    }

    static int zzf(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzf(list) + (list.size() * zzakn.zzh(i));
    }

    static int zzf(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzalx) {
            zzalx zzalx = (zzalx) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzakn.zzb(zzalx.zzb(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzakn.zzb(list.get(i).longValue());
            i++;
        }
        return i3;
    }

    static int zza(int i, Object obj, zzanb<?> zzanb) {
        if (obj instanceof zzalu) {
            return zzakn.zzb(i, (zzalu) obj);
        }
        return zzakn.zzh(i) + zza((zzajm) obj, (zzanb) zzanb);
    }

    static int zzb(int i, List<?> list, zzanb<?> zzanb) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzh = zzakn.zzh(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzalu) {
                i2 = zzakn.zza((zzalu) obj);
            } else {
                i2 = zza((zzajm) obj, (zzanb) zzanb);
            }
            zzh += i2;
        }
        return zzh;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzakn.zzh(i));
    }

    static int zzg(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzali) {
            zzali zzali = (zzali) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzakn.zzg(zzali.zzb(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzakn.zzg(list.get(i).intValue());
            i++;
        }
        return i3;
    }

    static int zzh(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzakn.zzh(i));
    }

    static int zzh(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzalx) {
            zzalx zzalx = (zzalx) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzakn.zzd(zzalx.zzb(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzakn.zzd(list.get(i).longValue());
            i++;
        }
        return i3;
    }

    static int zzb(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzh = zzakn.zzh(i) * size;
        if (list instanceof zzalt) {
            zzalt zzalt = (zzalt) list;
            while (i4 < size) {
                Object zza2 = zzalt.zza(i4);
                if (zza2 instanceof zzajv) {
                    i3 = zzakn.zza((zzajv) zza2);
                } else {
                    i3 = zzakn.zza((String) zza2);
                }
                zzh += i3;
                i4++;
            }
            return zzh;
        }
        while (i4 < size) {
            Object obj = list.get(i4);
            if (obj instanceof zzajv) {
                i2 = zzakn.zza((zzajv) obj);
            } else {
                i2 = zzakn.zza((String) obj);
            }
            zzh += i2;
            i4++;
        }
        return zzh;
    }

    static int zzi(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzakn.zzh(i));
    }

    static int zzi(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzali) {
            zzali zzali = (zzali) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzakn.zzi(zzali.zzb(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzakn.zzi(list.get(i).intValue());
            i++;
        }
        return i3;
    }

    static int zzj(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzakn.zzh(i));
    }

    static int zzj(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzalx) {
            zzalx zzalx = (zzalx) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzakn.zze(zzalx.zzb(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzakn.zze(list.get(i).longValue());
            i++;
        }
        return i3;
    }

    public static zzanu<?, ?> zza() {
        return zza;
    }

    static <UT, UB> UB zza(Object obj, int i, List<Integer> list, zzalj zzalj, UB ub, zzanu<UT, UB> zzanu) {
        if (zzalj == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzalj.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zza(obj, i, intValue, ub, zzanu);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue2 = it.next().intValue();
            if (!zzalj.zza(intValue2)) {
                ub = zza(obj, i, intValue2, ub, zzanu);
                it.remove();
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(Object obj, int i, int i2, UB ub, zzanu<UT, UB> zzanu) {
        if (ub == null) {
            ub = zzanu.zzc(obj);
        }
        zzanu.zzb(ub, i, (long) i2);
        return ub;
    }

    static <T, FT extends zzakz<FT>> void zza(zzakw<FT> zzakw, T t, T t2) {
        zzakx<FT> zza2 = zzakw.zza((Object) t2);
        if (!zza2.zza.isEmpty()) {
            zzakw.zzb(t).zza(zza2);
        }
    }

    static <T> void zza(zzamf zzamf, T t, T t2, long j) {
        zzanz.zza((Object) t, j, zzamf.zza(zzanz.zze(t, j), zzanz.zze(t2, j)));
    }

    static <T, UT, UB> void zza(zzanu<UT, UB> zzanu, T t, T t2) {
        zzanu.zzc(t, zzanu.zza(zzanu.zzd(t), zzanu.zzd(t2)));
    }

    public static void zza(Class<?> cls) {
        zzalf.class.isAssignableFrom(cls);
    }

    public static void zza(int i, List<Boolean> list, zzaol zzaol, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zza(i, list, z);
        }
    }

    public static void zza(int i, List<zzajv> list, zzaol zzaol) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zza(i, list);
        }
    }

    public static void zzb(int i, List<Double> list, zzaol zzaol, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zzb(i, list, z);
        }
    }

    public static void zzc(int i, List<Integer> list, zzaol zzaol, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Integer> list, zzaol zzaol, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzaol zzaol, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zze(i, list, z);
        }
    }

    public static void zzf(int i, List<Float> list, zzaol zzaol, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zzf(i, list, z);
        }
    }

    public static void zza(int i, List<?> list, zzaol zzaol, zzanb<?> zzanb) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zza(i, list, (zzanb) zzanb);
        }
    }

    public static void zzg(int i, List<Integer> list, zzaol zzaol, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zzg(i, list, z);
        }
    }

    public static void zzh(int i, List<Long> list, zzaol zzaol, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zzh(i, list, z);
        }
    }

    public static void zzb(int i, List<?> list, zzaol zzaol, zzanb<?> zzanb) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zzb(i, list, (zzanb) zzanb);
        }
    }

    public static void zzi(int i, List<Integer> list, zzaol zzaol, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zzi(i, list, z);
        }
    }

    public static void zzj(int i, List<Long> list, zzaol zzaol, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zzj(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzaol zzaol, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zzk(i, list, z);
        }
    }

    public static void zzl(int i, List<Long> list, zzaol zzaol, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zzl(i, list, z);
        }
    }

    public static void zzb(int i, List<String> list, zzaol zzaol) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zzb(i, list);
        }
    }

    public static void zzm(int i, List<Integer> list, zzaol zzaol, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zzm(i, list, z);
        }
    }

    public static void zzn(int i, List<Long> list, zzaol zzaol, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaol.zzn(i, list, z);
        }
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
