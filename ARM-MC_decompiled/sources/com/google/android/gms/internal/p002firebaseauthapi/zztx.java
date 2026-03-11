package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zztx extends zzalf<zztx, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zztx zzc;
    private static volatile zzamv<zztx> zzd;
    private int zze;
    private zzua zzf;
    /* access modifiers changed from: private */
    public int zzg;

    public final int zza() {
        return this.zzg;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztx$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zztx, zza> implements zzamo {
        public final zza zza(int i) {
            zzg();
            ((zztx) this.zza).zzg = i;
            return this;
        }

        public final zza zza(zzua zzua) {
            zzg();
            zztx.zza((zztx) this.zza, zzua);
            return this;
        }

        private zza() {
            super(zztx.zzc);
        }
    }

    public static zztx zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zztx) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zzua zzd() {
        zzua zzua = this.zzf;
        return zzua == null ? zzua.zzd() : zzua;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zztz.zza[i - 1]) {
            case 1:
                return new zztx();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zztx> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zztx.class) {
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

    static /* synthetic */ void zza(zztx zztx, zzua zzua) {
        zzua.getClass();
        zztx.zzf = zzua;
        zztx.zze |= 1;
    }

    static {
        zztx zztx = new zztx();
        zzc = zztx;
        zzalf.zza(zztx.class, zztx);
    }

    private zztx() {
    }
}
