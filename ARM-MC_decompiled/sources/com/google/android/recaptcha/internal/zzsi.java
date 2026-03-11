package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzsi extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzsi zzb;
    private static volatile zzoq zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private zzsm zzk;
    private zzsg zzl;
    private zzsk zzm;
    private zzry zzn;

    static {
        zzsi zzsi = new zzsi();
        zzb = zzsi;
        zznd.zzI(zzsi.class, zzsi);
    }

    private zzsi() {
    }

    static /* synthetic */ void zzN(zzsi zzsi, String str) {
        str.getClass();
        zzsi.zze |= 1;
        zzsi.zzf = str;
    }

    static /* synthetic */ void zzO(zzsi zzsi, zzsg zzsg) {
        zzsg.getClass();
        zzsi.zzl = zzsg;
        zzsi.zze |= 64;
    }

    static /* synthetic */ void zzP(zzsi zzsi, zzsm zzsm) {
        zzsm.getClass();
        zzsi.zzk = zzsm;
        zzsi.zze |= 32;
    }

    static /* synthetic */ void zzQ(zzsi zzsi, zzsk zzsk) {
        zzsk.getClass();
        zzsi.zzm = zzsk;
        zzsi.zze |= 128;
    }

    public static zzsh zzf() {
        return (zzsh) zzb.zzq();
    }

    public static zzsi zzi(byte[] bArr) throws zznn {
        return (zzsi) zznd.zzx(zzb, bArr);
    }

    @Deprecated
    public final String zzM() {
        return this.zzh;
    }

    @Deprecated
    public final String zzj() {
        return this.zzi;
    }

    public final String zzk() {
        return this.zzf;
    }

    @Deprecated
    public final String zzl() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001\u0003ለ\u0002\u0004ለ\u0003\u0005ለ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဉ\u0007\tဉ\b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
        } else if (i2 == 3) {
            return new zzsi();
        } else {
            if (i2 == 4) {
                return new zzsh((zzsn) null);
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
            synchronized (zzsi.class) {
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
