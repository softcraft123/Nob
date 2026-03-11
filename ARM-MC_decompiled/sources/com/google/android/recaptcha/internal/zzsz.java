package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzsz extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzsz zzb;
    private static volatile zzoq zzd;
    private int zze;
    private String zzf = "";
    private zznk zzg = zzB();

    static {
        zzsz zzsz = new zzsz();
        zzb = zzsz;
        zznd.zzI(zzsz.class, zzsz);
    }

    private zzsz() {
    }

    public static zzsy zzf() {
        return (zzsy) zzb.zzq();
    }

    static /* synthetic */ void zzi(zzsz zzsz, Iterable iterable) {
        zzsz.zzl();
        zzko.zzc(iterable, zzsz.zzg);
    }

    static /* synthetic */ void zzj(zzsz zzsz, zzsx zzsx) {
        zzsx.getClass();
        zzsz.zzl();
        zzsz.zzg.add(zzsx);
    }

    static /* synthetic */ void zzk(zzsz zzsz, String str) {
        str.getClass();
        zzsz.zze |= 1;
        zzsz.zzf = str;
    }

    private final void zzl() {
        zznk zznk = this.zzg;
        if (!zznk.zzc()) {
            this.zzg = zznd.zzC(zznk);
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
            return zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000", new Object[]{"zze", "zzg", zzsx.class, "zzf"});
        } else if (i2 == 3) {
            return new zzsz();
        } else {
            if (i2 == 4) {
                return new zzsy((zzta) null);
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
            synchronized (zzsz.class) {
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
