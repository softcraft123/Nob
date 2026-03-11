package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzyo extends zzalf<zzyo, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzyo zzc;
    private static volatile zzamv<zzyo> zzd;
    private int zze;
    private zzajv zzf = zzajv.zza;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyo$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzyo, zza> implements zzamo {
        public final zza zza(zzajv zzajv) {
            zzg();
            zzyo.zza((zzyo) this.zza, zzajv);
            return this;
        }

        private zza() {
            super(zzyo.zzc);
        }
    }

    public static zzyo zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzyo) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zzajv zzd() {
        return this.zzf;
    }

    public static zzamv<zzyo> zze() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzyn.zza[i - 1]) {
            case 1:
                return new zzyo();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzyo> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzyo.class) {
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

    static /* synthetic */ void zza(zzyo zzyo, zzajv zzajv) {
        zzajv.getClass();
        zzyo.zzf = zzajv;
    }

    static {
        zzyo zzyo = new zzyo();
        zzc = zzyo;
        zzalf.zza(zzyo.class, zzyo);
    }

    private zzyo() {
    }
}
