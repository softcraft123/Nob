package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzls extends zzna implements zzoj {
    /* access modifiers changed from: private */
    public static final zzls zzd;
    private static volatile zzoq zze;
    private int zzf;
    private boolean zzg;
    private zzma zzh;
    private boolean zzi;
    private zzmc zzj;
    private zznk zzk = zzot.zze();
    private byte zzl = 2;

    static {
        zzls zzls = new zzls();
        zzd = zzls;
        zznd.zzI(zzls.class, zzls);
    }

    private zzls() {
    }

    public static zzls zzg() {
        return zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return new zzou(zzd, "\u0001\u0005\u0000\u0001\u0001ϧ\u0005\u0000\u0001\u0002\u0001ဇ\u0000\u0002ᐉ\u0001\u0003ဇ\u0002\u0004ဉ\u0003ϧЛ", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzmg.class});
        } else if (i2 == 3) {
            return new zzls();
        } else {
            if (i2 == 4) {
                return new zzlr((zzmh) null);
            }
            if (i2 == 5) {
                return zzd;
            }
            if (i2 != 6) {
                this.zzl = obj == null ? (byte) 0 : 1;
                return null;
            }
            zzoq zzoq2 = zze;
            if (zzoq2 != null) {
                return zzoq2;
            }
            synchronized (zzls.class) {
                try {
                    zzoq = zze;
                    if (zzoq == null) {
                        zzoq = new zzmy(zzd);
                        zze = zzoq;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzoq;
        }
    }
}
