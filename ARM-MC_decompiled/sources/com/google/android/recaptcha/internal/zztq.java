package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zztq extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zztq zzb;
    private static volatile zzoq zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zztq zztq = new zztq();
        zzb = zztq;
        zznd.zzI(zztq.class, zztq);
    }

    private zztq() {
    }

    public static zztp zzf() {
        return (zztp) zzb.zzq();
    }

    static /* synthetic */ void zzi(zztq zztq, String str) {
        str.getClass();
        zztq.zze = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zztq();
        } else {
            if (i2 == 4) {
                return new zztp((zzug) null);
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
            synchronized (zztq.class) {
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
