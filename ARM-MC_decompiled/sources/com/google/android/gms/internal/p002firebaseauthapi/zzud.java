package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzud  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzud extends zzalf<zzud, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzud zzc;
    private static volatile zzamv<zzud> zzd;
    private int zze;
    private zzajv zzf = zzajv.zza;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzud$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzud, zza> implements zzamo {
        public final zza zza(zzajv zzajv) {
            zzg();
            zzud.zza((zzud) this.zza, zzajv);
            return this;
        }

        private zza() {
            super(zzud.zzc);
        }
    }

    public static zzud zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzud) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zzajv zzd() {
        return this.zzf;
    }

    public static zzamv<zzud> zze() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzuf.zza[i - 1]) {
            case 1:
                return new zzud();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzud> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzud.class) {
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

    static /* synthetic */ void zza(zzud zzud, zzajv zzajv) {
        zzajv.getClass();
        zzud.zzf = zzajv;
    }

    static {
        zzud zzud = new zzud();
        zzc = zzud;
        zzalf.zza(zzud.class, zzud);
    }

    private zzud() {
    }
}
