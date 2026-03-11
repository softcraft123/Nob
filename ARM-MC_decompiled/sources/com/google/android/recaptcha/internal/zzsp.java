package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzsp extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzsp zzb;
    private static volatile zzoq zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private zzsi zzm;

    static {
        zzsp zzsp = new zzsp();
        zzb = zzsp;
        zznd.zzI(zzsp.class, zzsp);
    }

    private zzsp() {
    }

    static /* synthetic */ void zzM(zzsp zzsp, String str) {
        str.getClass();
        zzsp.zze |= 4;
        zzsp.zzh = str;
    }

    public static zzso zzf() {
        return (zzso) zzb.zzq();
    }

    static /* synthetic */ void zzi(zzsp zzsp, String str) {
        str.getClass();
        zzsp.zze |= 8;
        zzsp.zzi = str;
    }

    static /* synthetic */ void zzj(zzsp zzsp, String str) {
        str.getClass();
        zzsp.zze |= 2;
        zzsp.zzg = str;
    }

    static /* synthetic */ void zzk(zzsp zzsp, String str) {
        str.getClass();
        zzsp.zze |= 1;
        zzsp.zzf = str;
    }

    static /* synthetic */ void zzl(zzsp zzsp, zzsi zzsi) {
        zzsi.getClass();
        zzsp.zzm = zzsi;
        zzsp.zze |= 128;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001\u0003ለ\u0002\u0004ለ\u0003\u0005ለ\u0004\u0006ለ\u0005\u0007ለ\u0006\bဉ\u0007", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        } else if (i2 == 3) {
            return new zzsp();
        } else {
            if (i2 == 4) {
                return new zzso((zzsu) null);
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
            synchronized (zzsp.class) {
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
