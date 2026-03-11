package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zztl extends zzalf<zztl, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zztl zzc;
    private static volatile zzamv<zztl> zzd;
    private int zze;
    private int zzf;
    private zztr zzg;
    private zzajv zzh = zzajv.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztl$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zztl, zza> implements zzamo {
        public final zza zza(zzajv zzajv) {
            zzg();
            zztl.zza((zztl) this.zza, zzajv);
            return this;
        }

        public final zza zza(zztr zztr) {
            zzg();
            zztl.zza((zztl) this.zza, zztr);
            return this;
        }

        private zza() {
            super(zztl.zzc);
        }
    }

    public static zztl zzd() {
        return zzc;
    }

    public final zztr zze() {
        zztr zztr = this.zzg;
        return zztr == null ? zztr.zzd() : zztr;
    }

    public final zzajv zzf() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zztn.zza[i - 1]) {
            case 1:
                return new zztl();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamv<zztl> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zztl.class) {
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

    static /* synthetic */ void zza(zztl zztl, zzajv zzajv) {
        zzajv.getClass();
        zztl.zzh = zzajv;
    }

    static /* synthetic */ void zza(zztl zztl, zztr zztr) {
        zztr.getClass();
        zztl.zzg = zztr;
        zztl.zze |= 1;
    }

    static {
        zztl zztl = new zztl();
        zzc = zztl;
        zzalf.zza(zztl.class, zztl);
    }

    private zztl() {
    }
}
