package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzrl extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzrl zzb;
    private static volatile zzoq zzd;
    private int zze;
    private zzml zzf;
    private zzpj zzg;
    private zzml zzh;
    private zzpj zzi;

    static {
        zzrl zzrl = new zzrl();
        zzb = zzrl;
        zznd.zzI(zzrl.class, zzrl);
    }

    private zzrl() {
    }

    public static zzrj zzf() {
        return (zzrj) zzb.zzq();
    }

    static /* synthetic */ void zzi(zzrl zzrl, zzpj zzpj) {
        zzpj.getClass();
        zzrl.zzi = zzpj;
        zzrl.zze |= 8;
    }

    static /* synthetic */ void zzj(zzrl zzrl, zzml zzml) {
        zzml.getClass();
        zzrl.zzh = zzml;
        zzrl.zze |= 4;
    }

    static /* synthetic */ void zzk(zzrl zzrl, zzpj zzpj) {
        zzpj.getClass();
        zzrl.zzg = zzpj;
        zzrl.zze |= 2;
    }

    static /* synthetic */ void zzl(zzrl zzrl, zzml zzml) {
        zzml.getClass();
        zzrl.zzf = zzml;
        zzrl.zze |= 1;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzrl();
        } else {
            if (i2 == 4) {
                return new zzrj((zzrk) null);
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
            synchronized (zzrl.class) {
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
