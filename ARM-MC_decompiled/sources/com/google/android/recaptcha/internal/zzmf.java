package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzmf extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzmf zzb;
    private static volatile zzoq zzd;
    private int zze;
    private String zzf = "";
    private boolean zzg;
    private byte zzh = 2;

    static {
        zzmf zzmf = new zzmf();
        zzb = zzmf;
        zznd.zzI(zzmf.class, zzmf);
    }

    private zzmf() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return new zzou(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzmf();
        } else {
            if (i2 == 4) {
                return new zzme((zzmh) null);
            }
            if (i2 == 5) {
                return zzb;
            }
            if (i2 != 6) {
                this.zzh = obj == null ? (byte) 0 : 1;
                return null;
            }
            zzoq zzoq2 = zzd;
            if (zzoq2 != null) {
                return zzoq2;
            }
            synchronized (zzmf.class) {
                zzoq = zzd;
                if (zzoq == null) {
                    zzoq = new zzmy(zzb);
                    zzd = zzoq;
                }
            }
            return zzoq;
        }
    }
}
