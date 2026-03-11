package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzma extends zzna implements zzoj {
    /* access modifiers changed from: private */
    public static final zzma zzd;
    private static volatile zzoq zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private byte zzm = 2;

    static {
        zzma zzma = new zzma();
        zzd = zzma;
        zznd.zzI(zzma.class, zzma);
    }

    private zzma() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return new zzou(zzd, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005", new Object[]{"zzf", "zzg", zzlv.zza, "zzh", zzlu.zza, "zzi", zzly.zza, "zzj", zzlz.zza, "zzk", zzlx.zza, "zzl", zzlw.zza});
        } else if (i2 == 3) {
            return new zzma();
        } else {
            if (i2 == 4) {
                return new zzlt((zzmh) null);
            }
            if (i2 == 5) {
                return zzd;
            }
            if (i2 != 6) {
                this.zzm = obj == null ? (byte) 0 : 1;
                return null;
            }
            zzoq zzoq2 = zze;
            if (zzoq2 != null) {
                return zzoq2;
            }
            synchronized (zzma.class) {
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
