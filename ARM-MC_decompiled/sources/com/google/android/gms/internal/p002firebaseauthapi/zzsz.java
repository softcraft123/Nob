package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzsz extends zzalf<zzsz, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzsz zzc;
    private static volatile zzamv<zzsz> zzd;
    private int zze;
    /* access modifiers changed from: private */
    public int zzf;
    private zztc zzg;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsz$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzsz, zza> implements zzamo {
        public final zza zza(int i) {
            zzg();
            ((zzsz) this.zza).zzf = i;
            return this;
        }

        public final zza zza(zztc zztc) {
            zzg();
            zzsz.zza((zzsz) this.zza, zztc);
            return this;
        }

        private zza() {
            super(zzsz.zzc);
        }
    }

    public static zzsz zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzsz) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zztc zzd() {
        zztc zztc = this.zzg;
        return zztc == null ? zztc.zzd() : zztc;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zztb.zza[i - 1]) {
            case 1:
                return new zzsz();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzsz> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzsz.class) {
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

    static /* synthetic */ void zza(zzsz zzsz, zztc zztc) {
        zztc.getClass();
        zzsz.zzg = zztc;
        zzsz.zze |= 1;
    }

    static {
        zzsz zzsz = new zzsz();
        zzc = zzsz;
        zzalf.zza(zzsz.class, zzsz);
    }

    private zzsz() {
    }
}
