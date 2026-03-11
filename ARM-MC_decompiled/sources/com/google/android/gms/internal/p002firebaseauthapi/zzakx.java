package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzakx<T extends zzakz<T>> {
    private static final zzakx<?> zzb = new zzakx<>(true);
    final zzang<T, Object> zza;
    private boolean zzc;
    private boolean zzd;

    static int zza(zzaog zzaog, int i, Object obj) {
        int zzh = zzakn.zzh(i);
        if (zzaog == zzaog.GROUP) {
            zzalh.zza((zzamm) obj);
            zzh <<= 1;
        }
        return zzh + zza(zzaog, obj);
    }

    private static int zza(zzaog zzaog, Object obj) {
        switch (zzala.zzb[zzaog.ordinal()]) {
            case 1:
                return zzakn.zza(((Double) obj).doubleValue());
            case 2:
                return zzakn.zza(((Float) obj).floatValue());
            case 3:
                return zzakn.zzb(((Long) obj).longValue());
            case 4:
                return zzakn.zze(((Long) obj).longValue());
            case 5:
                return zzakn.zzc(((Integer) obj).intValue());
            case 6:
                return zzakn.zza(((Long) obj).longValue());
            case 7:
                return zzakn.zzb(((Integer) obj).intValue());
            case 8:
                return zzakn.zza(((Boolean) obj).booleanValue());
            case 9:
                return ((zzamm) obj).zzl();
            case 10:
                if (obj instanceof zzalq) {
                    return zzakn.zza((zzalu) (zzalq) obj);
                }
                return zzakn.zza((zzamm) obj);
            case 11:
                if (obj instanceof zzajv) {
                    return zzakn.zza((zzajv) obj);
                }
                return zzakn.zza((String) obj);
            case 12:
                if (obj instanceof zzajv) {
                    return zzakn.zza((zzajv) obj);
                }
                return zzakn.zza((byte[]) obj);
            case 13:
                return zzakn.zzi(((Integer) obj).intValue());
            case 14:
                return zzakn.zzf(((Integer) obj).intValue());
            case 15:
                return zzakn.zzc(((Long) obj).longValue());
            case 16:
                return zzakn.zzg(((Integer) obj).intValue());
            case 17:
                return zzakn.zzd(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzalk) {
                    return zzakn.zza(((zzalk) obj).zza());
                }
                return zzakn.zza(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzakz<?> zzakz, Object obj) {
        zzaog zzb2 = zzakz.zzb();
        int zza2 = zzakz.zza();
        if (!zzakz.zze()) {
            return zza(zzb2, zza2, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzakz.zzd()) {
            int i2 = 0;
            while (i < size) {
                i2 += zza(zzb2, zza2, list.get(i));
                i++;
            }
            return i2;
        } else if (list.isEmpty()) {
            return 0;
        } else {
            int i3 = 0;
            while (i < size) {
                i3 += zza(zzb2, list.get(i));
                i++;
            }
            return zzakn.zzh(zza2) + i3 + zzakn.zzi(i3);
        }
    }

    public final int zza() {
        int zzb2 = this.zza.zzb();
        int i = 0;
        for (int i2 = 0; i2 < zzb2; i2++) {
            i += zza(this.zza.zza(i2));
        }
        for (Map.Entry<T, Object> zza2 : this.zza.zzc()) {
            i += zza(zza2);
        }
        return i;
    }

    private static int zza(Map.Entry<T, Object> entry) {
        zzakz zzakz = (zzakz) entry.getKey();
        Object value = entry.getValue();
        if (zzakz.zzc() != zzaoj.MESSAGE || zzakz.zze() || zzakz.zzd()) {
            return zza((zzakz<?>) zzakz, value);
        }
        if (value instanceof zzalq) {
            return zzakn.zza(((zzakz) entry.getKey()).zza(), (zzalu) (zzalq) value);
        }
        return zzakn.zza(((zzakz) entry.getKey()).zza(), (zzamm) value);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public static <T extends zzakz<T>> zzakx<T> zzb() {
        return zzb;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzakx zzakx = new zzakx();
        int zzb2 = this.zza.zzb();
        for (int i = 0; i < zzb2; i++) {
            Map.Entry<T, Object> zza2 = this.zza.zza(i);
            zzakx.zzb((zzakz) zza2.getKey(), zza2.getValue());
        }
        for (Map.Entry next : this.zza.zzc()) {
            zzakx.zzb((zzakz) next.getKey(), next.getValue());
        }
        zzakx.zzd = this.zzd;
        return zzakx;
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzamr) {
            return ((zzamr) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzalq)) {
            return obj;
        }
        zzalq zzalq = (zzalq) obj;
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zzc() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzals(this.zza.zzd().iterator());
        }
        return this.zza.zzd().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzals(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    private zzakx() {
        this.zza = new zzanf();
    }

    private zzakx(zzang<T, Object> zzang) {
        this.zza = zzang;
        zze();
    }

    private zzakx(boolean z) {
        this(new zzanf());
        zze();
    }

    public final void zze() {
        if (!this.zzc) {
            int zzb2 = this.zza.zzb();
            for (int i = 0; i < zzb2; i++) {
                Object value = this.zza.zza(i).getValue();
                if (value instanceof zzalf) {
                    ((zzalf) value).zzt();
                }
            }
            for (Map.Entry<T, Object> value2 : this.zza.zzc()) {
                Object value3 = value2.getValue();
                if (value3 instanceof zzalf) {
                    ((zzalf) value3).zzt();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zza(zzakx<T> zzakx) {
        int zzb2 = zzakx.zza.zzb();
        for (int i = 0; i < zzb2; i++) {
            zzb(zzakx.zza.zza(i));
        }
        for (Map.Entry<T, Object> zzb3 : zzakx.zza.zzc()) {
            zzb(zzb3);
        }
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        Object obj;
        zzakz zzakz = (zzakz) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzalq;
        if (zzakz.zze()) {
            if (!z) {
                Object zza2 = zza(zzakz);
                List list = (List) value;
                int size = list.size();
                if (zza2 == null) {
                    zza2 = new ArrayList(size);
                }
                List list2 = (List) zza2;
                for (int i = 0; i < size; i++) {
                    list2.add(zza(list.get(i)));
                }
                this.zza.put(zzakz, zza2);
                return;
            }
            throw new IllegalStateException("Lazy fields can not be repeated");
        } else if (zzakz.zzc() == zzaoj.MESSAGE) {
            Object zza3 = zza(zzakz);
            if (zza3 == null) {
                this.zza.put(zzakz, zza(value));
                if (z) {
                    this.zzd = true;
                }
            } else if (!z) {
                if (zza3 instanceof zzamr) {
                    obj = zzakz.zza((zzamr) zza3, (zzamr) value);
                } else {
                    obj = zzakz.zza(((zzamm) zza3).zzr(), (zzamm) value).zze();
                }
                this.zza.put(zzakz, obj);
            } else {
                zzalq zzalq = (zzalq) value;
                throw new NoSuchMethodError();
            }
        } else if (!z) {
            this.zza.put(zzakz, zza(value));
        } else {
            throw new IllegalStateException("Lazy fields must be message-valued");
        }
    }

    private final void zzb(T t, Object obj) {
        if (!t.zze()) {
            zzc(t, obj);
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzc(t, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzalq) {
            this.zzd = true;
        }
        this.zza.put(t, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        if ((r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzalk) == false) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        if ((r4 instanceof byte[]) == false) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        if ((r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzalq) == false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzc(T r3, java.lang.Object r4) {
        /*
            com.google.android.gms.internal.firebase-auth-api.zzaog r0 = r3.zzb()
            com.google.android.gms.internal.p002firebaseauthapi.zzalh.zza(r4)
            int[] r1 = com.google.android.gms.internal.p002firebaseauthapi.zzala.zza
            com.google.android.gms.internal.firebase-auth-api.zzaoj r0 = r0.zzb()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L_0x0044;
                case 2: goto L_0x0041;
                case 3: goto L_0x003e;
                case 4: goto L_0x003b;
                case 5: goto L_0x0038;
                case 6: goto L_0x0035;
                case 7: goto L_0x002c;
                case 8: goto L_0x0023;
                case 9: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            r1 = r2
            goto L_0x0046
        L_0x001a:
            boolean r0 = r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzamm
            if (r0 != 0) goto L_0x0046
            boolean r0 = r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzalq
            if (r0 == 0) goto L_0x0018
            goto L_0x0046
        L_0x0023:
            boolean r0 = r4 instanceof java.lang.Integer
            if (r0 != 0) goto L_0x0046
            boolean r0 = r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzalk
            if (r0 == 0) goto L_0x0018
            goto L_0x0046
        L_0x002c:
            boolean r0 = r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzajv
            if (r0 != 0) goto L_0x0046
            boolean r0 = r4 instanceof byte[]
            if (r0 == 0) goto L_0x0018
            goto L_0x0046
        L_0x0035:
            boolean r1 = r4 instanceof java.lang.String
            goto L_0x0046
        L_0x0038:
            boolean r1 = r4 instanceof java.lang.Boolean
            goto L_0x0046
        L_0x003b:
            boolean r1 = r4 instanceof java.lang.Double
            goto L_0x0046
        L_0x003e:
            boolean r1 = r4 instanceof java.lang.Float
            goto L_0x0046
        L_0x0041:
            boolean r1 = r4 instanceof java.lang.Long
            goto L_0x0046
        L_0x0044:
            boolean r1 = r4 instanceof java.lang.Integer
        L_0x0046:
            if (r1 == 0) goto L_0x0049
            return
        L_0x0049:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r3.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.firebase-auth-api.zzaog r3 = r3.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzaoj r3 = r3.zzb()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            java.lang.Object[] r3 = new java.lang.Object[]{r1, r3, r4}
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzakx.zzc(com.google.android.gms.internal.firebase-auth-api.zzakz, java.lang.Object):void");
    }

    static void zza(zzakn zzakn, zzaog zzaog, int i, Object obj) throws IOException {
        if (zzaog == zzaog.GROUP) {
            zzamm zzamm = (zzamm) obj;
            zzalh.zza(zzamm);
            zzakn.zzj(i, 3);
            zzamm.zza(zzakn);
            zzakn.zzj(i, 4);
            return;
        }
        zzakn.zzj(i, zzaog.zza());
        switch (zzala.zzb[zzaog.ordinal()]) {
            case 1:
                zzakn.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzakn.zzb(((Float) obj).floatValue());
                return;
            case 3:
                zzakn.zzh(((Long) obj).longValue());
                return;
            case 4:
                zzakn.zzh(((Long) obj).longValue());
                return;
            case 5:
                zzakn.zzk(((Integer) obj).intValue());
                return;
            case 6:
                zzakn.zzf(((Long) obj).longValue());
                return;
            case 7:
                zzakn.zzj(((Integer) obj).intValue());
                return;
            case 8:
                zzakn.zzb(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzamm) obj).zza(zzakn);
                return;
            case 10:
                zzakn.zzb((zzamm) obj);
                return;
            case 11:
                if (obj instanceof zzajv) {
                    zzakn.zzb((zzajv) obj);
                    return;
                } else {
                    zzakn.zzb((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzajv) {
                    zzakn.zzb((zzajv) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzakn.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzakn.zzm(((Integer) obj).intValue());
                return;
            case 14:
                zzakn.zzj(((Integer) obj).intValue());
                return;
            case 15:
                zzakn.zzf(((Long) obj).longValue());
                return;
            case 16:
                zzakn.zzl(((Integer) obj).intValue());
                return;
            case 17:
                zzakn.zzg(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzalk) {
                    zzakn.zzk(((zzalk) obj).zza());
                    return;
                } else {
                    zzakn.zzk(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzakx)) {
            return false;
        }
        return this.zza.equals(((zzakx) obj).zza);
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        int zzb2 = this.zza.zzb();
        for (int i = 0; i < zzb2; i++) {
            if (!zzc(this.zza.zza(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zzc2 : this.zza.zzc()) {
            if (!zzc(zzc2)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzakz<T>> boolean zzc(Map.Entry<T, Object> entry) {
        zzakz zzakz = (zzakz) entry.getKey();
        if (zzakz.zzc() != zzaoj.MESSAGE) {
            return true;
        }
        if (!zzakz.zze()) {
            return zzb(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzb(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzb(Object obj) {
        if (obj instanceof zzamo) {
            return ((zzamo) obj).zzv();
        }
        if (obj instanceof zzalq) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }
}
