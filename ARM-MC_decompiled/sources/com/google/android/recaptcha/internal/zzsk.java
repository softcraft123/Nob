package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzsk extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzsk zzb;
    private static volatile zzoq zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zzsk zzsk = new zzsk();
        zzb = zzsk;
        zznd.zzI(zzsk.class, zzsk);
    }

    private zzsk() {
    }

    public static zzsj zzf() {
        return (zzsj) zzb.zzq();
    }

    static /* synthetic */ void zzi(zzsk zzsk, String str) {
        str.getClass();
        zzsk.zze |= 2;
        zzsk.zzg = str;
    }

    static /* synthetic */ void zzj(zzsk zzsk, String str) {
        str.getClass();
        zzsk.zze |= 1;
        zzsk.zzf = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzsk();
        } else {
            if (i2 == 4) {
                return new zzsj((zzsn) null);
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
            synchronized (zzsk.class) {
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
