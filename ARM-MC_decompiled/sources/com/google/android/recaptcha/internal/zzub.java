package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzub extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzub zzb;
    private static volatile zzoq zzd;
    private int zze;
    private String zzf = "";
    private zzni zzg = zzy();
    private zznj zzh = zzA();
    private zztl zzi;

    static {
        zzub zzub = new zzub();
        zzb = zzub;
        zznd.zzI(zzub.class, zzub);
    }

    private zzub() {
    }

    public static zzub zzi(byte[] bArr) throws zznn {
        return (zzub) zznd.zzx(zzb, bArr);
    }

    public final zztl zzf() {
        zztl zztl = this.zzi;
        return zztl == null ? zztl.zzg() : zztl;
    }

    public final String zzj() {
        return this.zzf;
    }

    public final List zzk() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001Ȉ\u0002'\u0003%\u0004ဉ\u0000", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzub();
        } else {
            if (i2 == 4) {
                return new zzua((zzug) null);
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
            synchronized (zzub.class) {
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
