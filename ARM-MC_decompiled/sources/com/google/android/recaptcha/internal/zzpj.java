package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzpj extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzpj zzb;
    private static volatile zzoq zzd;
    /* access modifiers changed from: private */
    public long zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzpj zzpj = new zzpj();
        zzb = zzpj;
        zznd.zzI(zzpj.class, zzpj);
    }

    private zzpj() {
    }

    public static zzph zzi() {
        return (zzph) zzb.zzq();
    }

    public final int zzf() {
        return this.zzf;
    }

    public final long zzg() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzou(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzpj();
        } else {
            if (i2 == 4) {
                return new zzph((zzpi) null);
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
            synchronized (zzpj.class) {
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
