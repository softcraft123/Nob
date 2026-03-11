package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzse extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzse zzb;
    private static volatile zzoq zzd;
    private zzle zze = zzle.zzb;
    private String zzf = "";
    private long zzg;
    private zzle zzh = zzle.zzb;
    private String zzi = "";
    private String zzj = "";

    static {
        zzse zzse = new zzse();
        zzb = zzse;
        zznd.zzI(zzse.class, zzse);
    }

    private zzse() {
    }

    public static zzse zzk() {
        return zzb;
    }

    public final long zzf() {
        return this.zzg;
    }

    public final zzle zzg() {
        return this.zzh;
    }

    public final zzle zzi() {
        return this.zze;
    }

    public final String zzl() {
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
            return zzF(zzb, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001\n\u0002Ȉ\u0003\u0002\u0004\n\u0005Ȉ\u0006Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzse();
        } else {
            if (i2 == 4) {
                return new zzsd((zzsn) null);
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
            synchronized (zzse.class) {
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
