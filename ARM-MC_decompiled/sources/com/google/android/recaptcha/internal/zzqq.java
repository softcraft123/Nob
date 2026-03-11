package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzqq extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzqq zzb;
    private static volatile zzoq zzd;
    private String zze = "";
    private String zzf = "";
    /* access modifiers changed from: private */
    public int zzg;
    private String zzh = "";
    /* access modifiers changed from: private */
    public String zzi = "";
    private int zzj;
    /* access modifiers changed from: private */
    public int zzk;

    static {
        zzqq zzqq = new zzqq();
        zzb = zzqq;
        zznd.zzI(zzqq.class, zzqq);
    }

    private zzqq() {
    }

    static /* synthetic */ void zzO(zzqq zzqq, String str) {
        str.getClass();
        zzqq.zze = str;
    }

    public static zzqo zzg() {
        return (zzqo) zzb.zzq();
    }

    public static zzqq zzj() {
        return zzb;
    }

    public final int zzf() {
        return this.zzg;
    }

    public final String zzk() {
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
            return zzF(zzb, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003Ȉ\u0004\u0004\u0005Ȉ\u0006Ȉ\u0007\u0004", new Object[]{"zze", "zzg", "zzi", "zzj", "zzf", "zzh", "zzk"});
        } else if (i2 == 3) {
            return new zzqq();
        } else {
            if (i2 == 4) {
                return new zzqo((zzqp) null);
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
            synchronized (zzqq.class) {
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
