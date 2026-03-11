package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzuj extends zzalf<zzuj, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzuj zzc;
    private static volatile zzamv<zzuj> zzd;
    private int zze;
    private zzajv zzf = zzajv.zza;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuj$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzuj, zza> implements zzamo {
        public final zza zza(zzajv zzajv) {
            zzg();
            zzuj.zza((zzuj) this.zza, zzajv);
            return this;
        }

        private zza() {
            super(zzuj.zzc);
        }
    }

    public static zzuj zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzuj) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zzajv zzd() {
        return this.zzf;
    }

    public static zzamv<zzuj> zze() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzul.zza[i - 1]) {
            case 1:
                return new zzuj();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzuj> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzuj.class) {
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

    static /* synthetic */ void zza(zzuj zzuj, zzajv zzajv) {
        zzajv.getClass();
        zzuj.zzf = zzajv;
    }

    static {
        zzuj zzuj = new zzuj();
        zzc = zzuj;
        zzalf.zza(zzuj.class, zzuj);
    }

    private zzuj() {
    }
}
