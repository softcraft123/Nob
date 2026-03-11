package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzoy {
    public static final /* synthetic */ int zza = 0;
    private static final zzpl zzb = new zzpn();

    static {
        int i = zzos.zza;
    }

    public static void zzA(int i, List list, zzpy zzpy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzpy.zzA(i, list, z);
        }
    }

    public static void zzB(int i, List list, zzpy zzpy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzpy.zzC(i, list, z);
        }
    }

    public static void zzC(int i, List list, zzpy zzpy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzpy.zzE(i, list, z);
        }
    }

    public static void zzD(int i, List list, zzpy zzpy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzpy.zzJ(i, list, z);
        }
    }

    public static void zzE(int i, List list, zzpy zzpy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzpy.zzL(i, list, z);
        }
    }

    static boolean zzF(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzne) {
            zzne zzne = (zzne) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzln.zzB((long) zzne.zze(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzln.zzB((long) ((Integer) list.get(i)).intValue());
            i++;
        }
        return i3;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzln.zzA(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzln.zzA(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzne) {
            zzne zzne = (zzne) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzln.zzB((long) zzne.zze(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzln.zzB((long) ((Integer) list.get(i)).intValue());
            i++;
        }
        return i3;
    }

    static int zzg(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zznx) {
            zznx zznx = (zznx) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzln.zzB(zznx.zze(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzln.zzB(((Long) list.get(i)).longValue());
            i++;
        }
        return i3;
    }

    static int zzh(int i, Object obj, zzow zzow) {
        int i2 = i << 3;
        if (!(obj instanceof zznt)) {
            return zzln.zzA(i2) + zzln.zzy((zzoi) obj, zzow);
        }
        int zzA = zzln.zzA(i2);
        int zza2 = ((zznt) obj).zza();
        return zzA + zzln.zzA(zza2) + zza2;
    }

    static int zzi(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzne) {
            zzne zzne = (zzne) list;
            int i2 = 0;
            while (i < size) {
                int zze = zzne.zze(i);
                i2 += zzln.zzA((zze >> 31) ^ (zze + zze));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            int intValue = ((Integer) list.get(i)).intValue();
            i3 += zzln.zzA((intValue >> 31) ^ (intValue + intValue));
            i++;
        }
        return i3;
    }

    static int zzj(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zznx) {
            zznx zznx = (zznx) list;
            int i2 = 0;
            while (i < size) {
                long zze = zznx.zze(i);
                i2 += zzln.zzB((zze >> 63) ^ (zze + zze));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            long longValue = ((Long) list.get(i)).longValue();
            i3 += zzln.zzB((longValue >> 63) ^ (longValue + longValue));
            i++;
        }
        return i3;
    }

    static int zzk(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzne) {
            zzne zzne = (zzne) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzln.zzA(zzne.zze(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzln.zzA(((Integer) list.get(i)).intValue());
            i++;
        }
        return i3;
    }

    static int zzl(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zznx) {
            zznx zznx = (zznx) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzln.zzB(zznx.zze(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzln.zzB(((Long) list.get(i)).longValue());
            i++;
        }
        return i3;
    }

    public static zzpl zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i, List list, zznh zznh, Object obj2, zzpl zzpl) {
        if (zznh == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zznh.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj2 = zzo(obj, i, intValue, obj2, zzpl);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
            return obj2;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int intValue2 = ((Integer) it.next()).intValue();
            if (!zznh.zza(intValue2)) {
                obj2 = zzo(obj, i, intValue2, obj2, zzpl);
                it.remove();
            }
        }
        return obj2;
    }

    static Object zzo(Object obj, int i, int i2, Object obj2, zzpl zzpl) {
        if (obj2 == null) {
            obj2 = zzpl.zza(obj);
        }
        zzpl.zzh(obj2, i, (long) i2);
        return obj2;
    }

    static void zzp(zzmp zzmp, Object obj, Object obj2) {
        zzmt zzmt = ((zzna) obj2).zzb;
        if (!zzmt.zza.isEmpty()) {
            ((zzna) obj).zzi().zzh(zzmt);
        }
    }

    static void zzq(zzpl zzpl, Object obj, Object obj2) {
        zznd zznd = (zznd) obj;
        zzpm zzpm = zznd.zzc;
        zzpm zzpm2 = ((zznd) obj2).zzc;
        zzpm zzpm3 = zzpm;
        zzpm zzpm4 = zzpm2;
        if (!zzpm.zzc().equals(zzpm2)) {
            if (zzpm.zzc().equals(zzpm)) {
                zzpm = zzpm.zze(zzpm, zzpm2);
            } else {
                zzpm.zzd(zzpm2);
            }
        }
        zzpm zzpm5 = zzpm;
        zznd.zzc = zzpm;
    }

    public static void zzr(int i, List list, zzpy zzpy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzpy.zzc(i, list, z);
        }
    }

    public static void zzs(int i, List list, zzpy zzpy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzpy.zzg(i, list, z);
        }
    }

    public static void zzt(int i, List list, zzpy zzpy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzpy.zzj(i, list, z);
        }
    }

    public static void zzu(int i, List list, zzpy zzpy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzpy.zzl(i, list, z);
        }
    }

    public static void zzv(int i, List list, zzpy zzpy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzpy.zzn(i, list, z);
        }
    }

    public static void zzw(int i, List list, zzpy zzpy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzpy.zzp(i, list, z);
        }
    }

    public static void zzx(int i, List list, zzpy zzpy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzpy.zzs(i, list, z);
        }
    }

    public static void zzy(int i, List list, zzpy zzpy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzpy.zzu(i, list, z);
        }
    }

    public static void zzz(int i, List list, zzpy zzpy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzpy.zzy(i, list, z);
        }
    }
}
