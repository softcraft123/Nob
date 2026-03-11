package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzti extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzti zzb;
    private static volatile zzoq zzd;
    private zznk zze = zzB();
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzti zzti = new zzti();
        zzb = zzti;
        zznd.zzI(zzti.class, zzti);
    }

    private zzti() {
    }

    public static zztf zzf() {
        return (zztf) zzb.zzq();
    }

    static /* synthetic */ void zzi(zzti zzti, Iterable iterable) {
        zzti.zzl();
        zzko.zzc(iterable, zzti.zze);
    }

    static /* synthetic */ void zzj(zzti zzti, zzth zzth) {
        zzth.getClass();
        zzti.zzl();
        zzti.zze.add(zzth);
    }

    private final void zzl() {
        zznk zznk = this.zze;
        if (!zznk.zzc()) {
            this.zze = zznd.zzC(zznk);
        }
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u000b", new Object[]{"zze", zzth.class, "zzf"});
        } else if (i2 == 3) {
            return new zzti();
        } else {
            if (i2 == 4) {
                return new zztf((zztj) null);
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
            synchronized (zzti.class) {
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
