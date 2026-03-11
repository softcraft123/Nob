package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzth extends zznd implements zzoj {
    /* access modifiers changed from: private */
    public static final zzth zzb;
    private static volatile zzoq zzd;
    private int zze = 0;
    private Object zzf;

    static {
        zzth zzth = new zzth();
        zzb = zzth;
        zznd.zzI(zzth.class, zzth);
    }

    private zzth() {
    }

    static /* synthetic */ void zzM(zzth zzth, float f) {
        zzth.zze = 9;
        zzth.zzf = Float.valueOf(f);
    }

    static /* synthetic */ void zzN(zzth zzth, int i) {
        zzth.zze = 4;
        zzth.zzf = Integer.valueOf(i);
    }

    static /* synthetic */ void zzO(zzth zzth, int i) {
        zzth.zze = 5;
        zzth.zzf = Integer.valueOf(i);
    }

    static /* synthetic */ void zzP(zzth zzth, long j) {
        zzth.zze = 7;
        zzth.zzf = Long.valueOf(j);
    }

    static /* synthetic */ void zzQ(zzth zzth, String str) {
        str.getClass();
        zzth.zze = 11;
        zzth.zzf = str;
    }

    public static zztg zzf() {
        return (zztg) zzb.zzq();
    }

    static /* synthetic */ void zzi(zzth zzth, boolean z) {
        zzth.zze = 1;
        zzth.zzf = Boolean.valueOf(z);
    }

    static /* synthetic */ void zzj(zzth zzth, zzle zzle) {
        zzth.zze = 2;
        zzth.zzf = zzle;
    }

    static /* synthetic */ void zzk(zzth zzth, String str) {
        str.getClass();
        zzth.zze = 3;
        zzth.zzf = str;
    }

    static /* synthetic */ void zzl(zzth zzth, double d) {
        zzth.zze = 10;
        zzth.zzf = Double.valueOf(d);
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzoq;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u000b\u0001\u0000\u0001\u000b\u000b\u0000\u0000\u0000\u0001:\u0000\u0002=\u0000\u0003Ȼ\u0000\u0004B\u0000\u0005B\u0000\u0006>\u0000\u0007C\u0000\b6\u0000\t4\u0000\n3\u0000\u000bȻ\u0000", new Object[]{"zzf", "zze"});
        } else if (i2 == 3) {
            return new zzth();
        } else {
            if (i2 == 4) {
                return new zztg((zztj) null);
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
            synchronized (zzth.class) {
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
