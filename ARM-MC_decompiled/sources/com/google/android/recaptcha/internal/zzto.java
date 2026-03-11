package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzto extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzto zzb;
    private static volatile zzoq zzd;
    private String zze = "";
    private String zzf = "";
    /* access modifiers changed from: private */
    public String zzg = "";
    /* access modifiers changed from: private */
    public int zzh;
    private String zzi = "";
    private String zzj = "";
    /* access modifiers changed from: private */
    public String zzk = "";

    static {
        zzto zzto = new zzto();
        zzb = zzto;
        zznd.zzI(zzto.class, zzto);
    }

    private zzto() {
    }

    static /* synthetic */ void zzM(zzto zzto, String str) {
        str.getClass();
        zzto.zzi = str;
    }

    static /* synthetic */ void zzN(zzto zzto, String str) {
        str.getClass();
        zzto.zze = str;
    }

    public static zztn zzf() {
        return (zztn) zzb.zzq();
    }

    static /* synthetic */ void zzj(zzto zzto, String str) {
        str.getClass();
        zzto.zzj = str;
    }

    static /* synthetic */ void zzk(zzto zzto, String str) {
        str.getClass();
        zzto.zzf = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0007\u0000\u0000\u0001\b\u0007\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\f\u0006Ȉ\u0007Ȉ\bȈ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzto();
        } else {
            if (i2 == 4) {
                return new zztn((zzug) null);
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
            synchronized (zzto.class) {
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
