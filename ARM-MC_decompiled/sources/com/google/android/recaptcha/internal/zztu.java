package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zztu extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zztu zzb;
    private static volatile zzoq zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zztu zztu = new zztu();
        zzb = zztu;
        zznd.zzI(zztu.class, zztu);
    }

    private zztu() {
    }

    public static zztu zzg(InputStream inputStream) throws IOException {
        return (zztu) zznd.zzw(zzb, inputStream);
    }

    public final zztv zzi() {
        zztv zzb2 = zztv.zzb(this.zzg);
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
            return zzF(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zztu();
        } else {
            if (i2 == 4) {
                return new zztt((zzug) null);
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
            synchronized (zztu.class) {
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
