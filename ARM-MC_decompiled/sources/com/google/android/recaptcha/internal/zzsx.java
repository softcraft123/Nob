package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzsx extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzsx zzb;
    private static volatile zzoq zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private zzni zzh = zzy();
    private int zzi;
    private int zzj;

    static {
        zzsx zzsx = new zzsx();
        zzb = zzsx;
        zznd.zzI(zzsx.class, zzsx);
    }

    private zzsx() {
    }

    public static zzsv zzf() {
        return (zzsv) zzb.zzq();
    }

    static /* synthetic */ void zzi(zzsx zzsx, String str) {
        str.getClass();
        zzsx.zze |= 2;
        zzsx.zzg = str;
    }

    static /* synthetic */ void zzj(zzsx zzsx, String str) {
        str.getClass();
        zzsx.zze |= 1;
        zzsx.zzf = str;
    }

    static /* synthetic */ void zzk(zzsx zzsx, int i) {
        zzsx.zzi = 2;
        zzsx.zze |= 4;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003'\u0004᠌\u0002\u0005င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzsw.zza, "zzj"});
        } else if (i2 == 3) {
            return new zzsx();
        } else {
            if (i2 == 4) {
                return new zzsv((zzta) null);
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
            synchronized (zzsx.class) {
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
