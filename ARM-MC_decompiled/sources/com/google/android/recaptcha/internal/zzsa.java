package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzsa extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzsa zzb;
    private static volatile zzoq zzd;
    private zzle zze = zzle.zzb;

    static {
        zzsa zzsa = new zzsa();
        zzb = zzsa;
        zznd.zzI(zzsa.class, zzsa);
    }

    private zzsa() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n", new Object[]{"zze"});
        } else if (i2 == 3) {
            return new zzsa();
        } else {
            if (i2 == 4) {
                return new zzrz((zzsn) null);
            }
            if (i2 == 5) {
                return zzb;
            }
            if (i2 != 6) {
                return null;
            }
            zzoq zzoq2 = zzd;
            if (zzoq2 != null) {
                return zzoq2;
            }
            synchronized (zzsa.class) {
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
