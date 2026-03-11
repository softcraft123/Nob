package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zztx extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zztx zzb;
    private static volatile zzoq zzd;
    private int zze = 0;
    private Object zzf;

    static {
        zztx zztx = new zztx();
        zzb = zztx;
        zznd.zzI(zztx.class, zztx);
    }

    private zztx() {
    }

    static /* synthetic */ void zzM(zztx zztx, zzrr zzrr) {
        zzrr.getClass();
        zztx.zzf = zzrr;
        zztx.zze = 2;
    }

    public static zztw zzi() {
        return (zztw) zzb.zzq();
    }

    public static zztx zzk(byte[] bArr) throws zznn {
        return (zztx) zznd.zzx(zzb, bArr);
    }

    static /* synthetic */ void zzl(zztx zztx, zzrc zzrc) {
        zzrc.getClass();
        zztx.zzf = zzrc;
        zztx.zze = 1;
    }

    public final int zzN() {
        int i = this.zze;
        if (i == 0) {
            return 3;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    public final zzrc zzf() {
        if (this.zze == 1) {
            return (zzrc) this.zzf;
        }
        return zzrc.zzk();
    }

    public final zzrr zzg() {
        if (this.zze == 2) {
            return (zzrr) this.zzf;
        }
        return zzrr.zzg();
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"zzf", "zze", zzrc.class, zzrr.class});
        } else if (i2 == 3) {
            return new zztx();
        } else {
            if (i2 == 4) {
                return new zztw((zzug) null);
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
            synchronized (zztx.class) {
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
