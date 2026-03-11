package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzmg extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzmg zzb;
    private static volatile zzoq zzd;
    private int zze;
    private zznk zzf = zzot.zze();
    private String zzg = "";
    private long zzh;
    private long zzi;
    private double zzj;
    private zzle zzk = zzle.zzb;
    private String zzl = "";
    private byte zzm = 2;

    static {
        zzmg zzmg = new zzmg();
        zzb = zzmg;
        zznd.zzI(zzmg.class, zzmg);
    }

    private zzmg() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return new zzou(zzb, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0001\u0001\u0002Л\u0003ဈ\u0000\u0004ဃ\u0001\u0005ဂ\u0002\u0006က\u0003\u0007ည\u0004\bဈ\u0005", new Object[]{"zze", "zzf", zzmf.class, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        } else if (i2 == 3) {
            return new zzmg();
        } else {
            if (i2 == 4) {
                return new zzmd((zzmh) null);
            }
            if (i2 == 5) {
                return zzb;
            }
            if (i2 != 6) {
                this.zzm = obj == null ? (byte) 0 : 1;
                return null;
            }
            zzoq zzoq2 = zzd;
            if (zzoq2 != null) {
                return zzoq2;
            }
            synchronized (zzmg.class) {
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
