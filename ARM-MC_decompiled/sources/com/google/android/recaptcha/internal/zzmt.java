package com.google.android.recaptcha.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzmt {
    private static final zzmt zzb = new zzmt(true);
    final zzpe zza = new zzoz();
    private boolean zzc;
    private boolean zzd;

    private zzmt() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011f, code lost:
        r1 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0121, code lost:
        return r4 + r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(com.google.android.recaptcha.internal.zzms r4, java.lang.Object r5) {
        /*
            com.google.android.recaptcha.internal.zzpw r0 = r4.zzd()
            int r1 = r4.zza()
            r4.zzg()
            int r4 = r1 << 3
            int r4 = com.google.android.recaptcha.internal.zzln.zzA(r4)
            com.google.android.recaptcha.internal.zzpw r1 = com.google.android.recaptcha.internal.zzpw.GROUP
            if (r0 != r1) goto L_0x0024
            r1 = r5
            com.google.android.recaptcha.internal.zzoi r1 = (com.google.android.recaptcha.internal.zzoi) r1
            byte[] r2 = com.google.android.recaptcha.internal.zznl.zzb
            boolean r2 = r1 instanceof com.google.android.recaptcha.internal.zzkp
            if (r2 != 0) goto L_0x0020
            int r4 = r4 + r4
            goto L_0x0024
        L_0x0020:
            com.google.android.recaptcha.internal.zzkp r1 = (com.google.android.recaptcha.internal.zzkp) r1
            r4 = 0
            throw r4
        L_0x0024:
            com.google.android.recaptcha.internal.zzpx r1 = com.google.android.recaptcha.internal.zzpx.INT
            int r0 = r0.ordinal()
            r1 = 4
            r2 = 8
            switch(r0) {
                case 0: goto L_0x011a;
                case 1: goto L_0x0114;
                case 2: goto L_0x0109;
                case 3: goto L_0x00fe;
                case 4: goto L_0x00f2;
                case 5: goto L_0x00ec;
                case 6: goto L_0x00e6;
                case 7: goto L_0x00df;
                case 8: goto L_0x00c7;
                case 9: goto L_0x00c0;
                case 10: goto L_0x00aa;
                case 11: goto L_0x0093;
                case 12: goto L_0x0087;
                case 13: goto L_0x0069;
                case 14: goto L_0x0062;
                case 15: goto L_0x005b;
                case 16: goto L_0x004a;
                case 17: goto L_0x0038;
                default: goto L_0x0030;
            }
        L_0x0030:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = "There is no way to get here, but the compiler thinks otherwise."
            r4.<init>(r5)
            throw r4
        L_0x0038:
            java.lang.Long r5 = (java.lang.Long) r5
            long r0 = r5.longValue()
            long r2 = r0 + r0
            r5 = 63
            long r0 = r0 >> r5
            long r0 = r0 ^ r2
            int r1 = com.google.android.recaptcha.internal.zzln.zzB(r0)
            goto L_0x0120
        L_0x004a:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            int r0 = r5 + r5
            int r5 = r5 >> 31
            r5 = r5 ^ r0
            int r1 = com.google.android.recaptcha.internal.zzln.zzA(r5)
            goto L_0x0120
        L_0x005b:
            java.lang.Long r5 = (java.lang.Long) r5
            r5.longValue()
            goto L_0x011f
        L_0x0062:
            java.lang.Integer r5 = (java.lang.Integer) r5
            r5.intValue()
            goto L_0x0120
        L_0x0069:
            boolean r0 = r5 instanceof com.google.android.recaptcha.internal.zznf
            if (r0 == 0) goto L_0x007a
            com.google.android.recaptcha.internal.zznf r5 = (com.google.android.recaptcha.internal.zznf) r5
            int r5 = r5.zza()
            long r0 = (long) r5
            int r1 = com.google.android.recaptcha.internal.zzln.zzB(r0)
            goto L_0x0120
        L_0x007a:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            long r0 = (long) r5
            int r1 = com.google.android.recaptcha.internal.zzln.zzB(r0)
            goto L_0x0120
        L_0x0087:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            int r1 = com.google.android.recaptcha.internal.zzln.zzA(r5)
            goto L_0x0120
        L_0x0093:
            boolean r0 = r5 instanceof com.google.android.recaptcha.internal.zzle
            if (r0 == 0) goto L_0x00a2
            com.google.android.recaptcha.internal.zzle r5 = (com.google.android.recaptcha.internal.zzle) r5
            int r5 = r5.zzd()
            int r0 = com.google.android.recaptcha.internal.zzln.zzA(r5)
            goto L_0x00d5
        L_0x00a2:
            byte[] r5 = (byte[]) r5
            int r5 = r5.length
            int r0 = com.google.android.recaptcha.internal.zzln.zzA(r5)
            goto L_0x00d5
        L_0x00aa:
            boolean r0 = r5 instanceof com.google.android.recaptcha.internal.zzns
            if (r0 == 0) goto L_0x00b9
            com.google.android.recaptcha.internal.zzns r5 = (com.google.android.recaptcha.internal.zzns) r5
            int r5 = r5.zza()
            int r0 = com.google.android.recaptcha.internal.zzln.zzA(r5)
            goto L_0x00d5
        L_0x00b9:
            com.google.android.recaptcha.internal.zzoi r5 = (com.google.android.recaptcha.internal.zzoi) r5
            int r1 = com.google.android.recaptcha.internal.zzln.zzx(r5)
            goto L_0x0120
        L_0x00c0:
            com.google.android.recaptcha.internal.zzoi r5 = (com.google.android.recaptcha.internal.zzoi) r5
            int r1 = r5.zzo()
            goto L_0x0120
        L_0x00c7:
            boolean r0 = r5 instanceof com.google.android.recaptcha.internal.zzle
            if (r0 == 0) goto L_0x00d8
            com.google.android.recaptcha.internal.zzle r5 = (com.google.android.recaptcha.internal.zzle) r5
            int r5 = r5.zzd()
            int r0 = com.google.android.recaptcha.internal.zzln.zzA(r5)
        L_0x00d5:
            int r1 = r0 + r5
            goto L_0x0120
        L_0x00d8:
            java.lang.String r5 = (java.lang.String) r5
            int r1 = com.google.android.recaptcha.internal.zzln.zzz(r5)
            goto L_0x0120
        L_0x00df:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            r5.booleanValue()
            r1 = 1
            goto L_0x0120
        L_0x00e6:
            java.lang.Integer r5 = (java.lang.Integer) r5
            r5.intValue()
            goto L_0x0120
        L_0x00ec:
            java.lang.Long r5 = (java.lang.Long) r5
            r5.longValue()
            goto L_0x011f
        L_0x00f2:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            long r0 = (long) r5
            int r1 = com.google.android.recaptcha.internal.zzln.zzB(r0)
            goto L_0x0120
        L_0x00fe:
            java.lang.Long r5 = (java.lang.Long) r5
            long r0 = r5.longValue()
            int r1 = com.google.android.recaptcha.internal.zzln.zzB(r0)
            goto L_0x0120
        L_0x0109:
            java.lang.Long r5 = (java.lang.Long) r5
            long r0 = r5.longValue()
            int r1 = com.google.android.recaptcha.internal.zzln.zzB(r0)
            goto L_0x0120
        L_0x0114:
            java.lang.Float r5 = (java.lang.Float) r5
            r5.floatValue()
            goto L_0x0120
        L_0x011a:
            java.lang.Double r5 = (java.lang.Double) r5
            r5.doubleValue()
        L_0x011f:
            r1 = r2
        L_0x0120:
            int r4 = r4 + r1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzmt.zza(com.google.android.recaptcha.internal.zzms, java.lang.Object):int");
    }

    public static zzmt zzd() {
        return zzb;
    }

    private static Object zzl(Object obj) {
        if (obj instanceof zzon) {
            return ((zzon) obj).zzd();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzm(Map.Entry entry) {
        Object obj;
        zzms zzms = (zzms) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzns;
        zzms.zzg();
        if (zzms.zze() == zzpx.MESSAGE) {
            Object zze = zze(zzms);
            if (zze == null) {
                this.zza.put(zzms, zzl(value));
                if (z) {
                    this.zzd = true;
                }
            } else if (!z) {
                if (zze instanceof zzon) {
                    obj = zzms.zzc((zzon) zze, (zzon) value);
                } else {
                    obj = zzms.zzb(((zzoi) zze).zzae(), (zzoi) value).zzk();
                }
                this.zza.put(zzms, obj);
            } else {
                zzns zzns = (zzns) value;
                throw null;
            }
        } else if (!z) {
            this.zza.put(zzms, zzl(value));
        } else {
            throw new IllegalStateException("Lazy fields must be message-valued");
        }
    }

    private static boolean zzn(Map.Entry entry) {
        zzms zzms = (zzms) entry.getKey();
        if (zzms.zze() != zzpx.MESSAGE) {
            return true;
        }
        zzms.zzg();
        Object value = entry.getValue();
        if (value instanceof zzoj) {
            return ((zzoj) value).zzp();
        }
        if (value instanceof zzns) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzo(Map.Entry entry) {
        int i;
        int zzA;
        int zzA2;
        zzms zzms = (zzms) entry.getKey();
        Object value = entry.getValue();
        if (zzms.zze() != zzpx.MESSAGE) {
            return zza(zzms, value);
        }
        zzms.zzg();
        zzms.zzf();
        if (value instanceof zzns) {
            int zza2 = ((zzms) entry.getKey()).zza();
            int zzA3 = zzln.zzA(8);
            i = zzA3 + zzA3;
            zzA = zzln.zzA(16) + zzln.zzA(zza2);
            int zzA4 = zzln.zzA(24);
            int zza3 = ((zzns) value).zza();
            zzA2 = zzA4 + zzln.zzA(zza3) + zza3;
        } else {
            int zza4 = ((zzms) entry.getKey()).zza();
            int zzA5 = zzln.zzA(8);
            i = zzA5 + zzA5;
            zzA = zzln.zzA(16) + zzln.zzA(zza4);
            zzA2 = zzln.zzA(24) + zzln.zzx((zzoi) value);
        }
        return i + zzA + zzA2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmt)) {
            return false;
        }
        return this.zza.equals(((zzmt) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzb() {
        int zzc2 = this.zza.zzc();
        int i = 0;
        for (int i2 = 0; i2 < zzc2; i2++) {
            i += zzo(this.zza.zzg(i2));
        }
        for (Map.Entry zzo : this.zza.zzd()) {
            i += zzo(zzo);
        }
        return i;
    }

    /* renamed from: zzc */
    public final zzmt clone() {
        zzmt zzmt = new zzmt();
        int zzc2 = this.zza.zzc();
        for (int i = 0; i < zzc2; i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzmt.zzi((zzms) ((zzpa) zzg).zza(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzd()) {
            zzmt.zzi((zzms) entry.getKey(), entry.getValue());
        }
        zzmt.zzd = this.zzd;
        return zzmt;
    }

    public final Object zze(zzms zzms) {
        Object obj = this.zza.get(zzms);
        if (!(obj instanceof zzns)) {
            return obj;
        }
        zzns zzns = (zzns) obj;
        throw null;
    }

    public final Iterator zzf() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zznq(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (!this.zzc) {
            int zzc2 = this.zza.zzc();
            for (int i = 0; i < zzc2; i++) {
                Object value = this.zza.zzg(i).getValue();
                if (value instanceof zznd) {
                    ((zznd) value).zzG();
                }
            }
            for (Map.Entry value2 : this.zza.zzd()) {
                Object value3 = value2.getValue();
                if (value3 instanceof zznd) {
                    ((zznd) value3).zzG();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzh(zzmt zzmt) {
        int zzc2 = zzmt.zza.zzc();
        for (int i = 0; i < zzc2; i++) {
            zzm(zzmt.zza.zzg(i));
        }
        for (Map.Entry zzm : zzmt.zza.zzd()) {
            zzm(zzm);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        if ((r4 instanceof byte[]) == false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r0 != false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
        if ((r4 instanceof com.google.android.recaptcha.internal.zzns) == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
        r2.zzd = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        r2.zza.zzf(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007e, code lost:
        throw new java.lang.IllegalArgumentException(java.lang.String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new java.lang.Object[]{java.lang.Integer.valueOf(r3.zza()), r3.zzd().zza(), r4.getClass().getName()}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        if ((r4 instanceof com.google.android.recaptcha.internal.zzns) == false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
        if ((r4 instanceof com.google.android.recaptcha.internal.zznf) == false) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(com.google.android.recaptcha.internal.zzms r3, java.lang.Object r4) {
        /*
            r2 = this;
            r3.zzg()
            com.google.android.recaptcha.internal.zzpw r0 = r3.zzd()
            byte[] r1 = com.google.android.recaptcha.internal.zznl.zzb
            r4.getClass()
            com.google.android.recaptcha.internal.zzpw r1 = com.google.android.recaptcha.internal.zzpw.DOUBLE
            com.google.android.recaptcha.internal.zzpx r1 = com.google.android.recaptcha.internal.zzpx.INT
            com.google.android.recaptcha.internal.zzpx r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L_0x0046;
                case 1: goto L_0x0043;
                case 2: goto L_0x0040;
                case 3: goto L_0x003d;
                case 4: goto L_0x003a;
                case 5: goto L_0x0037;
                case 6: goto L_0x002e;
                case 7: goto L_0x0025;
                case 8: goto L_0x001c;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x0057
        L_0x001c:
            boolean r0 = r4 instanceof com.google.android.recaptcha.internal.zzoi
            if (r0 != 0) goto L_0x004a
            boolean r0 = r4 instanceof com.google.android.recaptcha.internal.zzns
            if (r0 == 0) goto L_0x0057
            goto L_0x004a
        L_0x0025:
            boolean r0 = r4 instanceof java.lang.Integer
            if (r0 != 0) goto L_0x004a
            boolean r0 = r4 instanceof com.google.android.recaptcha.internal.zznf
            if (r0 == 0) goto L_0x0057
            goto L_0x004a
        L_0x002e:
            boolean r0 = r4 instanceof com.google.android.recaptcha.internal.zzle
            if (r0 != 0) goto L_0x004a
            boolean r0 = r4 instanceof byte[]
            if (r0 == 0) goto L_0x0057
            goto L_0x004a
        L_0x0037:
            boolean r0 = r4 instanceof java.lang.String
            goto L_0x0048
        L_0x003a:
            boolean r0 = r4 instanceof java.lang.Boolean
            goto L_0x0048
        L_0x003d:
            boolean r0 = r4 instanceof java.lang.Double
            goto L_0x0048
        L_0x0040:
            boolean r0 = r4 instanceof java.lang.Float
            goto L_0x0048
        L_0x0043:
            boolean r0 = r4 instanceof java.lang.Long
            goto L_0x0048
        L_0x0046:
            boolean r0 = r4 instanceof java.lang.Integer
        L_0x0048:
            if (r0 == 0) goto L_0x0057
        L_0x004a:
            boolean r0 = r4 instanceof com.google.android.recaptcha.internal.zzns
            if (r0 == 0) goto L_0x0051
            r0 = 1
            r2.zzd = r0
        L_0x0051:
            com.google.android.recaptcha.internal.zzpe r0 = r2.zza
            r0.put(r3, r4)
            return
        L_0x0057:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r3.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.recaptcha.internal.zzpw r3 = r3.zzd()
            com.google.android.recaptcha.internal.zzpx r3 = r3.zza()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            java.lang.Object[] r3 = new java.lang.Object[]{r1, r3, r4}
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzmt.zzi(com.google.android.recaptcha.internal.zzms, java.lang.Object):void");
    }

    public final boolean zzj() {
        return this.zzc;
    }

    public final boolean zzk() {
        int zzc2 = this.zza.zzc();
        for (int i = 0; i < zzc2; i++) {
            if (!zzn(this.zza.zzg(i))) {
                return false;
            }
        }
        for (Map.Entry zzn : this.zza.zzd()) {
            if (!zzn(zzn)) {
                return false;
            }
        }
        return true;
    }

    private zzmt(boolean z) {
        zzg();
        zzg();
    }
}
