package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzrv extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzrv zzb;
    private static volatile zzoq zzd;
    private int zze;
    private zzrt zzf;
    private zzrt zzg;

    static {
        zzrv zzrv = new zzrv();
        zzb = zzrv;
        zznd.zzI(zzrv.class, zzrv);
    }

    private zzrv() {
    }

    public static zzrv zzj(byte[] bArr) throws zznn {
        return (zzrv) zznd.zzx(zzb, bArr);
    }

    public final zzrt zzf() {
        zzrt zzrt = this.zzf;
        return zzrt == null ? zzrt.zzg() : zzrt;
    }

    public final zzrt zzg() {
        zzrt zzrt = this.zzg;
        return zzrt == null ? zzrt.zzg() : zzrt;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzrv();
        } else {
            if (i2 == 4) {
                return new zzru((zzrw) null);
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
            synchronized (zzrv.class) {
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
