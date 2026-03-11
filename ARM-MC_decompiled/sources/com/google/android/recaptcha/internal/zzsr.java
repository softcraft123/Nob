package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzsr extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzsr zzb;
    private static volatile zzoq zzd;
    private int zze;
    private String zzf = "";
    private long zzg;
    private int zzh;
    private zznk zzi = zzB();
    private zzle zzj = zzle.zzb;
    private String zzk = "";
    private String zzl = "";

    static {
        zzsr zzsr = new zzsr();
        zzb = zzsr;
        zznd.zzI(zzsr.class, zzsr);
    }

    private zzsr() {
    }

    public static zzsr zzi() {
        return zzb;
    }

    public final zzle zzf() {
        return this.zzj;
    }

    public final String zzj() {
        return this.zzf;
    }

    public final List zzk() {
        return this.zzi;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0007\u0000\u0001\u0001\b\u0007\u0000\u0001\u0000\u0001ለ\u0000\u0002ဂ\u0001\u0004ဌ\u0002\u0005\u001b\u0006ည\u0003\u0007ለ\u0004\bለ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzst.class, "zzj", "zzk", "zzl"});
        } else if (i2 == 3) {
            return new zzsr();
        } else {
            if (i2 == 4) {
                return new zzsq((zzsu) null);
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
            synchronized (zzsr.class) {
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
