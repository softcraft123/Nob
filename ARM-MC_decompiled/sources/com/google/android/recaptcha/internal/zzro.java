package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzro extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzro zzb;
    private static volatile zzoq zzd;
    private int zze;
    private String zzf = "";
    private zzqt zzg;
    private zzqk zzh;
    private zzqw zzi;
    private String zzj = "";
    private String zzk = "";

    static {
        zzro zzro = new zzro();
        zzb = zzro;
        zznd.zzI(zzro.class, zzro);
    }

    private zzro() {
    }

    public static zzrm zzf() {
        return (zzrm) zzb.zzq();
    }

    static /* synthetic */ void zzi(zzro zzro, zzqk zzqk) {
        zzqk.getClass();
        zzro.zzh = zzqk;
        zzro.zze |= 2;
    }

    static /* synthetic */ void zzj(zzro zzro, String str) {
        str.getClass();
        zzro.zzk = str;
    }

    static /* synthetic */ void zzk(zzro zzro, String str) {
        str.getClass();
        zzro.zzj = str;
    }

    static /* synthetic */ void zzl(zzro zzro, String str) {
        str.getClass();
        zzro.zzf = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005Ȉ\u0006Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzro();
        } else {
            if (i2 == 4) {
                return new zzrm((zzrn) null);
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
            synchronized (zzro.class) {
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
