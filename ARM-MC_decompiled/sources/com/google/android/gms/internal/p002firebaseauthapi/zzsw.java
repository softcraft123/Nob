package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzsw extends zzalf<zzsw, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzsw zzc;
    private static volatile zzamv<zzsw> zzd;
    private int zze;
    private int zzf;
    private zzajv zzg = zzajv.zza;
    private zztc zzh;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsw$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzsw, zza> implements zzamo {
        public final zza zza(zzajv zzajv) {
            zzg();
            zzsw.zza((zzsw) this.zza, zzajv);
            return this;
        }

        public final zza zza(zztc zztc) {
            zzg();
            zzsw.zza((zzsw) this.zza, zztc);
            return this;
        }

        private zza() {
            super(zzsw.zzc);
        }
    }

    public static zzsw zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzsw) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zztc zzd() {
        zztc zztc = this.zzh;
        return zztc == null ? zztc.zzd() : zztc;
    }

    public final zzajv zze() {
        return this.zzg;
    }

    public static zzamv<zzsw> zzf() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzsy.zza[i - 1]) {
            case 1:
                return new zzsw();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzsw> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzsw.class) {
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

    static /* synthetic */ void zza(zzsw zzsw, zzajv zzajv) {
        zzajv.getClass();
        zzsw.zzg = zzajv;
    }

    static /* synthetic */ void zza(zzsw zzsw, zztc zztc) {
        zztc.getClass();
        zzsw.zzh = zztc;
        zzsw.zze |= 1;
    }

    static {
        zzsw zzsw = new zzsw();
        zzc = zzsw;
        zzalf.zza(zzsw.class, zzsw);
    }

    private zzsw() {
    }
}
