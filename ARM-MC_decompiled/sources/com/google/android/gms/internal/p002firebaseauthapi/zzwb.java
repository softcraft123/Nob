package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzwb extends zzalf<zzwb, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzwb zzc;
    private static volatile zzamv<zzwb> zzd;
    private int zze;
    private int zzf;
    private zzwh zzg;
    private zzajv zzh = zzajv.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwb$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzwb, zza> implements zzamo {
        public final zza zza(zzajv zzajv) {
            zzg();
            zzwb.zza((zzwb) this.zza, zzajv);
            return this;
        }

        public final zza zza(zzwh zzwh) {
            zzg();
            zzwb.zza((zzwb) this.zza, zzwh);
            return this;
        }

        private zza() {
            super(zzwb.zzc);
        }
    }

    public static zzwb zzd() {
        return zzc;
    }

    public static zzwb zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzwb) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zzwh zze() {
        zzwh zzwh = this.zzg;
        return zzwh == null ? zzwh.zze() : zzwh;
    }

    public final zzajv zzf() {
        return this.zzh;
    }

    public static zzamv<zzwb> zzg() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzwa.zza[i - 1]) {
            case 1:
                return new zzwb();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzwb> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzwb.class) {
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

    static /* synthetic */ void zza(zzwb zzwb, zzajv zzajv) {
        zzajv.getClass();
        zzwb.zzh = zzajv;
    }

    static /* synthetic */ void zza(zzwb zzwb, zzwh zzwh) {
        zzwh.getClass();
        zzwb.zzg = zzwh;
        zzwb.zze |= 1;
    }

    static {
        zzwb zzwb = new zzwb();
        zzc = zzwb;
        zzalf.zza(zzwb.class, zzwb);
    }

    private zzwb() {
    }
}
