package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zztf extends zzalf<zztf, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zztf zzc;
    private static volatile zzamv<zztf> zzd;
    private int zze;
    private int zzf;
    private zztl zzg;
    private zzwb zzh;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztf$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zztf, zza> implements zzamo {
        public final zza zza(zztl zztl) {
            zzg();
            zztf.zza((zztf) this.zza, zztl);
            return this;
        }

        public final zza zza(zzwb zzwb) {
            zzg();
            zztf.zza((zztf) this.zza, zzwb);
            return this;
        }

        private zza() {
            super(zztf.zzc);
        }
    }

    public static zztf zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zztf) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zztl zzd() {
        zztl zztl = this.zzg;
        return zztl == null ? zztl.zzd() : zztl;
    }

    public final zzwb zze() {
        zzwb zzwb = this.zzh;
        return zzwb == null ? zzwb.zzd() : zzwb;
    }

    public static zzamv<zztf> zzf() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzth.zza[i - 1]) {
            case 1:
                return new zztf();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamv<zztf> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zztf.class) {
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

    static /* synthetic */ void zza(zztf zztf, zztl zztl) {
        zztl.getClass();
        zztf.zzg = zztl;
        zztf.zze |= 1;
    }

    static /* synthetic */ void zza(zztf zztf, zzwb zzwb) {
        zzwb.getClass();
        zztf.zzh = zzwb;
        zztf.zze |= 2;
    }

    static {
        zztf zztf = new zztf();
        zzc = zztf;
        zzalf.zza(zztf.class, zztf);
    }

    private zztf() {
    }
}
