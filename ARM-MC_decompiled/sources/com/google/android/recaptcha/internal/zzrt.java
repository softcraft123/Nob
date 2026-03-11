package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzrt extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzrt zzb;
    private static volatile zzoq zzd;
    private zznk zze = zznd.zzB();

    static {
        zzrt zzrt = new zzrt();
        zzb = zzrt;
        zznd.zzI(zzrt.class, zzrt);
    }

    private zzrt() {
    }

    public static zzrt zzg() {
        return zzb;
    }

    public final List zzi() {
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
            return zzF(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"zze"});
        } else if (i2 == 3) {
            return new zzrt();
        } else {
            if (i2 == 4) {
                return new zzrs((zzrw) null);
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
            synchronized (zzrt.class) {
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
