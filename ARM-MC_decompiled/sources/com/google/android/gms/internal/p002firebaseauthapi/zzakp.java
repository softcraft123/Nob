package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzakp implements zzaol {
    private final zzakn zza;

    public static zzakp zza(zzakn zzakn) {
        if (zzakn.zza != null) {
            return zzakn.zza;
        }
        return new zzakp(zzakn);
    }

    public final int zza() {
        return 1;
    }

    private zzakp(zzakn zzakn) {
        zzakn zzakn2 = (zzakn) zzalh.zza(zzakn, "output");
        this.zza = zzakn2;
        zzakn2.zza = this;
    }

    public final void zza(int i, boolean z) throws IOException {
        this.zza.zzb(i, z);
    }

    public final void zza(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzajt) {
            zzajt zzajt = (zzajt) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzajt.size(); i4++) {
                    i3 += zzakn.zza(zzajt.zzb(i4));
                }
                this.zza.zzm(i3);
                while (i2 < zzajt.size()) {
                    this.zza.zzb(zzajt.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzajt.size()) {
                this.zza.zzb(i, zzajt.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzakn.zza(list.get(i6).booleanValue());
            }
            this.zza.zzm(i5);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).booleanValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).booleanValue());
                i2++;
            }
        }
    }

    public final void zza(int i, zzajv zzajv) throws IOException {
        this.zza.zzc(i, zzajv);
    }

    public final void zza(int i, List<zzajv> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzc(i, list.get(i2));
        }
    }

    public final void zza(int i, double d) throws IOException {
        this.zza.zzb(i, d);
    }

    public final void zzb(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzaks) {
            zzaks zzaks = (zzaks) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzaks.size(); i4++) {
                    i3 += zzakn.zza(zzaks.zzb(i4));
                }
                this.zza.zzm(i3);
                while (i2 < zzaks.size()) {
                    this.zza.zzb(zzaks.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzaks.size()) {
                this.zza.zzb(i, zzaks.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzakn.zza(list.get(i6).doubleValue());
            }
            this.zza.zzm(i5);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).doubleValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).doubleValue());
                i2++;
            }
        }
    }

    @Deprecated
    public final void zza(int i) throws IOException {
        this.zza.zzj(i, 4);
    }

    public final void zza(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    public final void zzc(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzali) {
            zzali zzali = (zzali) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzali.size(); i4++) {
                    i3 += zzakn.zza(zzali.zzb(i4));
                }
                this.zza.zzm(i3);
                while (i2 < zzali.size()) {
                    this.zza.zzk(zzali.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzali.size()) {
                this.zza.zzh(i, zzali.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzakn.zza(list.get(i6).intValue());
            }
            this.zza.zzm(i5);
            while (i2 < list.size()) {
                this.zza.zzk(list.get(i2).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzg(i, i2);
    }

    public final void zzd(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzali) {
            zzali zzali = (zzali) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzali.size(); i4++) {
                    i3 += zzakn.zzb(zzali.zzb(i4));
                }
                this.zza.zzm(i3);
                while (i2 < zzali.size()) {
                    this.zza.zzj(zzali.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzali.size()) {
                this.zza.zzg(i, zzali.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzakn.zzb(list.get(i6).intValue());
            }
            this.zza.zzm(i5);
            while (i2 < list.size()) {
                this.zza.zzj(list.get(i2).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzg(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public final void zza(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzalx) {
            zzalx zzalx = (zzalx) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzalx.size(); i4++) {
                    i3 += zzakn.zza(zzalx.zzb(i4));
                }
                this.zza.zzm(i3);
                while (i2 < zzalx.size()) {
                    this.zza.zzf(zzalx.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzalx.size()) {
                this.zza.zzf(i, zzalx.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzakn.zza(list.get(i6).longValue());
            }
            this.zza.zzm(i5);
            while (i2 < list.size()) {
                this.zza.zzf(list.get(i2).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzf(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public final void zza(int i, float f) throws IOException {
        this.zza.zzb(i, f);
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzald) {
            zzald zzald = (zzald) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzald.size(); i4++) {
                    i3 += zzakn.zza(zzald.zzb(i4));
                }
                this.zza.zzm(i3);
                while (i2 < zzald.size()) {
                    this.zza.zzb(zzald.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzald.size()) {
                this.zza.zzb(i, zzald.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzakn.zza(list.get(i6).floatValue());
            }
            this.zza.zzm(i5);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).floatValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).floatValue());
                i2++;
            }
        }
    }

    public final void zza(int i, Object obj, zzanb zzanb) throws IOException {
        this.zza.zzj(i, 3);
        zzanb.zza((zzajm) obj, (zzaol) this);
        this.zza.zzj(i, 4);
    }

    public final void zza(int i, List<?> list, zzanb zzanb) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzanb);
        }
    }

    public final void zzc(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    public final void zzg(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzali) {
            zzali zzali = (zzali) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzali.size(); i4++) {
                    i3 += zzakn.zzc(zzali.zzb(i4));
                }
                this.zza.zzm(i3);
                while (i2 < zzali.size()) {
                    this.zza.zzk(zzali.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzali.size()) {
                this.zza.zzh(i, zzali.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzakn.zzc(list.get(i6).intValue());
            }
            this.zza.zzm(i5);
            while (i2 < list.size()) {
                this.zza.zzk(list.get(i2).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public final void zzb(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzh(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzalx) {
            zzalx zzalx = (zzalx) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzalx.size(); i4++) {
                    i3 += zzakn.zzb(zzalx.zzb(i4));
                }
                this.zza.zzm(i3);
                while (i2 < zzalx.size()) {
                    this.zza.zzh(zzalx.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzalx.size()) {
                this.zza.zzh(i, zzalx.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzakn.zzb(list.get(i6).longValue());
            }
            this.zza.zzm(i5);
            while (i2 < list.size()) {
                this.zza.zzh(list.get(i2).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public final <K, V> void zza(int i, zzamd<K, V> zzamd, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zza.zzj(i, 2);
            this.zza.zzm(zzame.zza(zzamd, next.getKey(), next.getValue()));
            zzame.zza(this.zza, zzamd, next.getKey(), next.getValue());
        }
    }

    public final void zzb(int i, Object obj, zzanb zzanb) throws IOException {
        zzajm zzajm = (zzajm) obj;
        this.zza.zzj(i, 2);
        this.zza.zzm(zzajm.zza(zzanb));
        zzanb.zza(zzajm, (zzaol) this);
    }

    public final void zzb(int i, List<?> list, zzanb zzanb) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzanb);
        }
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzajv) {
            this.zza.zzd(i, (zzajv) obj);
        } else {
            this.zza.zzb(i, (zzamm) obj);
        }
    }

    public final void zzd(int i, int i2) throws IOException {
        this.zza.zzg(i, i2);
    }

    public final void zzi(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzali) {
            zzali zzali = (zzali) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzali.size(); i4++) {
                    i3 += zzakn.zzf(zzali.zzb(i4));
                }
                this.zza.zzm(i3);
                while (i2 < zzali.size()) {
                    this.zza.zzj(zzali.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzali.size()) {
                this.zza.zzg(i, zzali.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzakn.zzf(list.get(i6).intValue());
            }
            this.zza.zzm(i5);
            while (i2 < list.size()) {
                this.zza.zzj(list.get(i2).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzg(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public final void zzc(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    public final void zzj(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzalx) {
            zzalx zzalx = (zzalx) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzalx.size(); i4++) {
                    i3 += zzakn.zzc(zzalx.zzb(i4));
                }
                this.zza.zzm(i3);
                while (i2 < zzalx.size()) {
                    this.zza.zzf(zzalx.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzalx.size()) {
                this.zza.zzf(i, zzalx.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzakn.zzc(list.get(i6).longValue());
            }
            this.zza.zzm(i5);
            while (i2 < list.size()) {
                this.zza.zzf(list.get(i2).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzf(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public final void zze(int i, int i2) throws IOException {
        this.zza.zzi(i, i2);
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzali) {
            zzali zzali = (zzali) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzali.size(); i4++) {
                    i3 += zzakn.zzg(zzali.zzb(i4));
                }
                this.zza.zzm(i3);
                while (i2 < zzali.size()) {
                    this.zza.zzl(zzali.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzali.size()) {
                this.zza.zzi(i, zzali.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzakn.zzg(list.get(i6).intValue());
            }
            this.zza.zzm(i5);
            while (i2 < list.size()) {
                this.zza.zzl(list.get(i2).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzi(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public final void zzd(int i, long j) throws IOException {
        this.zza.zzg(i, j);
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzalx) {
            zzalx zzalx = (zzalx) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzalx.size(); i4++) {
                    i3 += zzakn.zzd(zzalx.zzb(i4));
                }
                this.zza.zzm(i3);
                while (i2 < zzalx.size()) {
                    this.zza.zzg(zzalx.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzalx.size()) {
                this.zza.zzg(i, zzalx.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzakn.zzd(list.get(i6).longValue());
            }
            this.zza.zzm(i5);
            while (i2 < list.size()) {
                this.zza.zzg(list.get(i2).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzg(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    @Deprecated
    public final void zzb(int i) throws IOException {
        this.zza.zzj(i, 3);
    }

    public final void zza(int i, String str) throws IOException {
        this.zza.zzb(i, str);
    }

    public final void zzb(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzalt) {
            zzalt zzalt = (zzalt) list;
            while (i2 < list.size()) {
                Object zza2 = zzalt.zza(i2);
                if (zza2 instanceof String) {
                    this.zza.zzb(i, (String) zza2);
                } else {
                    this.zza.zzc(i, (zzajv) zza2);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2));
            i2++;
        }
    }

    public final void zzf(int i, int i2) throws IOException {
        this.zza.zzk(i, i2);
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzali) {
            zzali zzali = (zzali) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzali.size(); i4++) {
                    i3 += zzakn.zzi(zzali.zzb(i4));
                }
                this.zza.zzm(i3);
                while (i2 < zzali.size()) {
                    this.zza.zzm(zzali.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzali.size()) {
                this.zza.zzk(i, zzali.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzakn.zzi(list.get(i6).intValue());
            }
            this.zza.zzm(i5);
            while (i2 < list.size()) {
                this.zza.zzm(list.get(i2).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzk(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public final void zze(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzalx) {
            zzalx zzalx = (zzalx) list;
            if (z) {
                this.zza.zzj(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzalx.size(); i4++) {
                    i3 += zzakn.zze(zzalx.zzb(i4));
                }
                this.zza.zzm(i3);
                while (i2 < zzalx.size()) {
                    this.zza.zzh(zzalx.zzb(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzalx.size()) {
                this.zza.zzh(i, zzalx.zzb(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzj(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzakn.zze(list.get(i6).longValue());
            }
            this.zza.zzm(i5);
            while (i2 < list.size()) {
                this.zza.zzh(list.get(i2).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).longValue());
                i2++;
            }
        }
    }
}
