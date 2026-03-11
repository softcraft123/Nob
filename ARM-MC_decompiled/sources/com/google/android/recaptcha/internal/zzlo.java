package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzlo implements zzpy {
    private final zzln zza;

    private zzlo(zzln zzln) {
        byte[] bArr = zznl.zzb;
        zzln zzln2 = zzln;
        this.zza = zzln;
        zzln.zza = this;
    }

    public static zzlo zza(zzln zzln) {
        zzlo zzlo = zzln.zza;
        return zzlo != null ? zzlo : new zzlo(zzln);
    }

    public final void zzB(int i, int i2) throws IOException {
        this.zza.zzs(i, (i2 >> 31) ^ (i2 + i2));
    }

    public final void zzD(int i, long j) throws IOException {
        this.zza.zzu(i, (j >> 63) ^ (j + j));
    }

    @Deprecated
    public final void zzF(int i) throws IOException {
        this.zza.zzr(i, 3);
    }

    public final void zzG(int i, String str) throws IOException {
        this.zza.zzp(i, str);
    }

    public final void zzI(int i, int i2) throws IOException {
        this.zza.zzs(i, i2);
    }

    public final void zzK(int i, long j) throws IOException {
        this.zza.zzu(i, j);
    }

    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzd(i, z);
    }

    public final void zzd(int i, zzle zzle) throws IOException {
        this.zza.zze(i, zzle);
    }

    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zze(i, (zzle) list.get(i2));
        }
    }

    public final void zzf(int i, double d) throws IOException {
        this.zza.zzh(i, Double.doubleToRawLongBits(d));
    }

    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzr(i, 4);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    public final void zzm(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzo(int i, float f) throws IOException {
        this.zza.zzf(i, Float.floatToRawIntBits(f));
    }

    public final void zzq(int i, Object obj, zzow zzow) throws IOException {
        zzln zzln = this.zza;
        zzln.zzr(i, 3);
        zzow.zzj((zzoi) obj, zzln.zza);
        zzln.zzr(i, 4);
    }

    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    public final void zzt(int i, long j) throws IOException {
        this.zza.zzu(i, j);
    }

    public final void zzv(int i, Object obj, zzow zzow) throws IOException {
        this.zza.zzm(i, (zzoi) obj, zzow);
    }

    public final void zzw(int i, Object obj) throws IOException {
        if (obj instanceof zzle) {
            this.zza.zzo(i, (zzle) obj);
        } else {
            this.zza.zzn(i, (zzoi) obj);
        }
    }

    public final void zzx(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    public final void zzz(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzH(int i, List list) throws IOException {
        int i2 = 0;
        if (list instanceof zznu) {
            zznu zznu = (zznu) list;
            while (i2 < list.size()) {
                Object zzc = zznu.zzc();
                if (zzc instanceof String) {
                    this.zza.zzp(i, (String) zzc);
                } else {
                    this.zza.zze(i, (zzle) zzc);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzp(i, (String) list.get(i2));
            i2++;
        }
    }

    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzne) {
            zzne zzne = (zzne) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzne.size(); i4++) {
                    i3 += zzln.zzA(zzne.zze(i4));
                }
                this.zza.zzt(i3);
                while (i2 < zzne.size()) {
                    this.zza.zzt(zzne.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzne.size()) {
                this.zza.zzs(i, zzne.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzln.zzA(((Integer) list.get(i6)).intValue());
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzt(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzs(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zznx) {
            zznx zznx = (zznx) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zznx.size(); i4++) {
                    i3 += zzln.zzB(zznx.zze(i4));
                }
                this.zza.zzt(i3);
                while (i2 < zznx.size()) {
                    this.zza.zzv(zznx.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zznx.size()) {
                this.zza.zzu(i, zznx.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzln.zzB(((Long) list.get(i6)).longValue());
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzv(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzu(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzne) {
            zzne zzne = (zzne) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzne.size(); i4++) {
                    zzne.zze(i4);
                    i3 += 4;
                }
                this.zza.zzt(i3);
                while (i2 < zzne.size()) {
                    this.zza.zzg(zzne.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzne.size()) {
                this.zza.zzf(i, zzne.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).intValue();
                i5 += 4;
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzg(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zznx) {
            zznx zznx = (zznx) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zznx.size(); i4++) {
                    zznx.zze(i4);
                    i3 += 8;
                }
                this.zza.zzt(i3);
                while (i2 < zznx.size()) {
                    this.zza.zzi(zznx.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zznx.size()) {
                this.zza.zzh(i, zznx.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).longValue();
                i5 += 8;
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzi(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzkv) {
            zzkv zzkv = (zzkv) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzkv.size(); i4++) {
                    zzkv.zzf(i4);
                    i3++;
                }
                this.zza.zzt(i3);
                while (i2 < zzkv.size()) {
                    this.zza.zzb(zzkv.zzf(i2) ? (byte) 1 : 0);
                    i2++;
                }
                return;
            }
            while (i2 < zzkv.size()) {
                this.zza.zzd(i, zzkv.zzf(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Boolean) list.get(i6)).booleanValue();
                i5++;
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : 0);
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzd(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
        }
    }

    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzne) {
            zzne zzne = (zzne) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzne.size(); i4++) {
                    i3 += zzln.zzB((long) zzne.zze(i4));
                }
                this.zza.zzt(i3);
                while (i2 < zzne.size()) {
                    this.zza.zzk(zzne.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzne.size()) {
                this.zza.zzj(i, zzne.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzln.zzB((long) ((Integer) list.get(i6)).intValue());
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zznx) {
            zznx zznx = (zznx) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zznx.size(); i4++) {
                    zznx.zze(i4);
                    i3 += 8;
                }
                this.zza.zzt(i3);
                while (i2 < zznx.size()) {
                    this.zza.zzi(zznx.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zznx.size()) {
                this.zza.zzh(i, zznx.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).longValue();
                i5 += 8;
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzi(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmi) {
            zzmi zzmi = (zzmi) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmi.size(); i4++) {
                    zzmi.zze(i4);
                    i3 += 8;
                }
                this.zza.zzt(i3);
                while (i2 < zzmi.size()) {
                    this.zza.zzi(Double.doubleToRawLongBits(zzmi.zze(i2)));
                    i2++;
                }
                return;
            }
            while (i2 < zzmi.size()) {
                this.zza.zzh(i, Double.doubleToRawLongBits(zzmi.zze(i2)));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Double) list.get(i6)).doubleValue();
                i5 += 8;
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
        }
    }

    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzmv) {
            zzmv zzmv = (zzmv) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzmv.size(); i4++) {
                    zzmv.zze(i4);
                    i3 += 4;
                }
                this.zza.zzt(i3);
                while (i2 < zzmv.size()) {
                    this.zza.zzg(Float.floatToRawIntBits(zzmv.zze(i2)));
                    i2++;
                }
                return;
            }
            while (i2 < zzmv.size()) {
                this.zza.zzf(i, Float.floatToRawIntBits(zzmv.zze(i2)));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Float) list.get(i6)).floatValue();
                i5 += 4;
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzf(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
        }
    }

    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzne) {
            zzne zzne = (zzne) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzne.size(); i4++) {
                    zzne.zze(i4);
                    i3 += 4;
                }
                this.zza.zzt(i3);
                while (i2 < zzne.size()) {
                    this.zza.zzg(zzne.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzne.size()) {
                this.zza.zzf(i, zzne.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).intValue();
                i5 += 4;
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzg(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzne) {
            zzne zzne = (zzne) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzne.size(); i4++) {
                    int zze = zzne.zze(i4);
                    i3 += zzln.zzA((zze >> 31) ^ (zze + zze));
                }
                this.zza.zzt(i3);
                while (i2 < zzne.size()) {
                    zzln zzln = this.zza;
                    int zze2 = zzne.zze(i2);
                    zzln.zzt((zze2 >> 31) ^ (zze2 + zze2));
                    i2++;
                }
                return;
            }
            while (i2 < zzne.size()) {
                zzln zzln2 = this.zza;
                int zze3 = zzne.zze(i2);
                zzln2.zzs(i, (zze3 >> 31) ^ (zze3 + zze3));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                int intValue = ((Integer) list.get(i6)).intValue();
                i5 += zzln.zzA((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                zzln zzln3 = this.zza;
                int intValue2 = ((Integer) list.get(i2)).intValue();
                zzln3.zzt((intValue2 >> 31) ^ (intValue2 + intValue2));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                zzln zzln4 = this.zza;
                int intValue3 = ((Integer) list.get(i2)).intValue();
                zzln4.zzs(i, (intValue3 >> 31) ^ (intValue3 + intValue3));
                i2++;
            }
        }
    }

    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zznx) {
            zznx zznx = (zznx) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zznx.size(); i4++) {
                    long zze = zznx.zze(i4);
                    i3 += zzln.zzB((zze >> 63) ^ (zze + zze));
                }
                this.zza.zzt(i3);
                while (i2 < zznx.size()) {
                    zzln zzln = this.zza;
                    long zze2 = zznx.zze(i2);
                    zzln.zzv((zze2 >> 63) ^ (zze2 + zze2));
                    i2++;
                }
                return;
            }
            while (i2 < zznx.size()) {
                zzln zzln2 = this.zza;
                long zze3 = zznx.zze(i2);
                zzln2.zzu(i, (zze3 >> 63) ^ (zze3 + zze3));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                long longValue = ((Long) list.get(i6)).longValue();
                i5 += zzln.zzB((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                zzln zzln3 = this.zza;
                long longValue2 = ((Long) list.get(i2)).longValue();
                zzln3.zzv((longValue2 >> 63) ^ (longValue2 + longValue2));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                zzln zzln4 = this.zza;
                long longValue3 = ((Long) list.get(i2)).longValue();
                zzln4.zzu(i, (longValue3 >> 63) ^ (longValue3 + longValue3));
                i2++;
            }
        }
    }

    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzne) {
            zzne zzne = (zzne) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzne.size(); i4++) {
                    i3 += zzln.zzB((long) zzne.zze(i4));
                }
                this.zza.zzt(i3);
                while (i2 < zzne.size()) {
                    this.zza.zzk(zzne.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzne.size()) {
                this.zza.zzj(i, zzne.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzln.zzB((long) ((Integer) list.get(i6)).intValue());
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zznx) {
            zznx zznx = (zznx) list;
            if (z) {
                this.zza.zzr(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zznx.size(); i4++) {
                    i3 += zzln.zzB(zznx.zze(i4));
                }
                this.zza.zzt(i3);
                while (i2 < zznx.size()) {
                    this.zza.zzv(zznx.zze(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zznx.size()) {
                this.zza.zzu(i, zznx.zze(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzr(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzln.zzB(((Long) list.get(i6)).longValue());
            }
            this.zza.zzt(i5);
            while (i2 < list.size()) {
                this.zza.zzv(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzu(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }
}
