package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzqz extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzqz zzb;
    private static volatile zzoq zzd;
    private int zze;
    private String zzf = "";
    private int zzg;
    private String zzh = "";
    private int zzi;
    private String zzj = "";
    private int zzk;

    static {
        zzqz zzqz = new zzqz();
        zzb = zzqz;
        zznd.zzI(zzqz.class, zzqz);
    }

    private zzqz() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003\u0004\u0004Ȉ\u0005\u0004\u0006Ȉ\u0007\u0004", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzqz();
        } else {
            if (i2 == 4) {
                return new zzqx((zzqy) null);
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
            synchronized (zzqz.class) {
                try {
                    zzoq = zzd;
                    if (zzoq == null) {
                        zzoq = new zzmy(zzb);
                        zzd = zzoq;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzoq;
        }
    }
}
