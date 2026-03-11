package com.google.android.recaptcha.internal;

import java.util.Iterator;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzqk extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzqk zzb;
    private static volatile zzoq zzd;
    /* access modifiers changed from: private */
    public int zze;
    private String zzf = "";
    /* access modifiers changed from: private */
    public String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private zzni zzk = zzy();

    static {
        zzqk zzqk = new zzqk();
        zzb = zzqk;
        zznd.zzI(zzqk.class, zzqk);
    }

    private zzqk() {
    }

    static /* synthetic */ void zzM(zzqk zzqk, String str) {
        str.getClass();
        zzqk.zzf = str;
    }

    static /* synthetic */ void zzN(zzqk zzqk, String str) {
        str.getClass();
        zzqk.zzi = str;
    }

    public static zzqh zzf() {
        return (zzqh) zzb.zzq();
    }

    static /* synthetic */ void zzi(zzqk zzqk, Iterable iterable) {
        zzni zzni = zzqk.zzk;
        if (!zzni.zzc()) {
            zzqk.zzk = zznd.zzz(zzni);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzqk.zzk.zzh(((zzqi) it.next()).zza());
        }
    }

    static /* synthetic */ void zzk(zzqk zzqk, String str) {
        str.getClass();
        zzqk.zzj = str;
    }

    static /* synthetic */ void zzl(zzqk zzqk, String str) {
        str.getClass();
        zzqk.zzh = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007,", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzqk();
        } else {
            if (i2 == 4) {
                return new zzqh((zzqj) null);
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
            synchronized (zzqk.class) {
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
