package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzrf extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzrf zzb;
    private static volatile zzoq zzd;
    private int zze;
    private zznk zzf = zzB();
    private zznk zzg = zzB();
    private zzqn zzh;

    static {
        zzrf zzrf = new zzrf();
        zzb = zzrf;
        zznd.zzI(zzrf.class, zzrf);
    }

    private zzrf() {
    }

    static /* synthetic */ void zzM(zzrf zzrf, zzrc zzrc) {
        zzrc.getClass();
        zznk zznk = zzrf.zzf;
        if (!zznk.zzc()) {
            zzrf.zzf = zznd.zzC(zznk);
        }
        zzrf.zzf.add(zzrc);
    }

    static /* synthetic */ void zzN(zzrf zzrf, zzrr zzrr) {
        zzrr.getClass();
        zznk zznk = zzrf.zzg;
        if (!zznk.zzc()) {
            zzrf.zzg = zznd.zzC(zznk);
        }
        zzrf.zzg.add(zzrr);
    }

    public static zzrd zzi() {
        return (zzrd) zzb.zzq();
    }

    public static zzrf zzk(byte[] bArr) throws zznn {
        return (zzrf) zznd.zzx(zzb, bArr);
    }

    public final int zzf() {
        return this.zzf.size();
    }

    public final int zzg() {
        return this.zzg.size();
    }

    public final List zzl() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u001b\u0003ဉ\u0000", new Object[]{"zze", "zzf", zzrc.class, "zzg", zzrr.class, "zzh"});
        } else if (i2 == 3) {
            return new zzrf();
        } else {
            if (i2 == 4) {
                return new zzrd((zzre) null);
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
            synchronized (zzrf.class) {
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
