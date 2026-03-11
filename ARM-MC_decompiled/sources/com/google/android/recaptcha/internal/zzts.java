package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzts extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzts zzb;
    private static volatile zzoq zzd;
    private int zze;

    static {
        zzts zzts = new zzts();
        zzb = zzts;
        zznd.zzI(zzts.class, zzts);
    }

    private zzts() {
    }

    public static zzts zzg(byte[] bArr) throws zznn {
        return (zzts) zznd.zzx(zzb, bArr);
    }

    public final zztv zzi() {
        zztv zzb2 = zztv.zzb(this.zze);
        return zzb2 == null ? zztv.UNRECOGNIZED : zzb2;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"zze"});
        } else if (i2 == 3) {
            return new zzts();
        } else {
            if (i2 == 4) {
                return new zztr((zzug) null);
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
            synchronized (zzts.class) {
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
