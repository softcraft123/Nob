package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zztu extends zzalf<zztu, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zztu zzc;
    private static volatile zzamv<zztu> zzd;
    private int zze;
    private int zzf;
    private zzua zzg;
    private zzajv zzh = zzajv.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztu$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zztu, zza> implements zzamo {
        public final zza zza(zzajv zzajv) {
            zzg();
            zztu.zza((zztu) this.zza, zzajv);
            return this;
        }

        public final zza zza(zzua zzua) {
            zzg();
            zztu.zza((zztu) this.zza, zzua);
            return this;
        }

        private zza() {
            super(zztu.zzc);
        }
    }

    public static zztu zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zztu) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zzua zzd() {
        zzua zzua = this.zzg;
        return zzua == null ? zzua.zzd() : zzua;
    }

    public final zzajv zze() {
        return this.zzh;
    }

    public static zzamv<zztu> zzf() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zztw.zza[i - 1]) {
            case 1:
                return new zztu();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamv<zztu> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zztu.class) {
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

    static /* synthetic */ void zza(zztu zztu, zzajv zzajv) {
        zzajv.getClass();
        zztu.zzh = zzajv;
    }

    static /* synthetic */ void zza(zztu zztu, zzua zzua) {
        zzua.getClass();
        zztu.zzg = zzua;
        zztu.zze |= 1;
    }

    static {
        zztu zztu = new zztu();
        zzc = zztu;
        zzalf.zza(zztu.class, zztu);
    }

    private zztu() {
    }
}
