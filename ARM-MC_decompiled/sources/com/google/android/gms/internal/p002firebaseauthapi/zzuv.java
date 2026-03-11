package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzuv extends zzalf<zzuv, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzuv zzc;
    private static volatile zzamv<zzuv> zzd;
    private int zze;
    private zzajv zzf = zzajv.zza;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuv$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzuv, zza> implements zzamo {
        public final zza zza(zzajv zzajv) {
            zzg();
            zzuv.zza((zzuv) this.zza, zzajv);
            return this;
        }

        private zza() {
            super(zzuv.zzc);
        }
    }

    public static zzuv zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzuv) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zzajv zzd() {
        return this.zzf;
    }

    public static zzamv<zzuv> zze() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzux.zza[i - 1]) {
            case 1:
                return new zzuv();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzuv> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzuv.class) {
                    zzamv = zzd;
                    if (zzamv == null) {
                        zzamv = new zzalf.zza(zzc);
                        zzd = zzamv;
                    }
                }
                return zzamv;
            case 6:
                return (byte) 1;
            default:
                throw null;
        }
    }

    static /* synthetic */ void zza(zzuv zzuv, zzajv zzajv) {
        zzajv.getClass();
        zzuv.zzf = zzajv;
    }

    static {
        zzuv zzuv = new zzuv();
        zzc = zzuv;
        zzalf.zza(zzuv.class, zzuv);
    }

    private zzuv() {
    }
}
