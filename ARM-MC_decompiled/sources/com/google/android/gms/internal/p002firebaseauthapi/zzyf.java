package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzyf extends zzalf<zzyf, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzyf zzc;
    private static volatile zzamv<zzyf> zzd;
    private int zze;
    private int zzf;
    private zzyl zzg;
    private zzajv zzh = zzajv.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyf$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzyf, zza> implements zzamo {
        public final zza zza(zzajv zzajv) {
            zzg();
            zzyf.zza((zzyf) this.zza, zzajv);
            return this;
        }

        public final zza zza(zzyl zzyl) {
            zzg();
            zzyf.zza((zzyf) this.zza, zzyl);
            return this;
        }

        private zza() {
            super(zzyf.zzc);
        }
    }

    public static zzyf zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzyf) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zzyl zzd() {
        zzyl zzyl = this.zzg;
        return zzyl == null ? zzyl.zzd() : zzyl;
    }

    public final zzajv zze() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzye.zza[i - 1]) {
            case 1:
                return new zzyf();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzyf> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzyf.class) {
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

    static /* synthetic */ void zza(zzyf zzyf, zzajv zzajv) {
        zzajv.getClass();
        zzyf.zzh = zzajv;
    }

    static /* synthetic */ void zza(zzyf zzyf, zzyl zzyl) {
        zzyl.getClass();
        zzyf.zzg = zzyl;
        zzyf.zze |= 1;
    }

    static {
        zzyf zzyf = new zzyf();
        zzc = zzyf;
        zzalf.zza(zzyf.class, zzyf);
    }

    private zzyf() {
    }
}
