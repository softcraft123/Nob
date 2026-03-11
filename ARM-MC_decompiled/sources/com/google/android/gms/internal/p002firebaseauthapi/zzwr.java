package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzwr extends zzalf<zzwr, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzwr zzc;
    private static volatile zzamv<zzwr> zzd;
    private int zze;
    /* access modifiers changed from: private */
    public int zzf;
    private zzwu zzg;
    private zzajv zzh = zzajv.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwr$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzwr, zza> implements zzamo {
        public final zza zza(zzajv zzajv) {
            zzg();
            zzwr.zza((zzwr) this.zza, zzajv);
            return this;
        }

        public final zza zza(zzwu zzwu) {
            zzg();
            zzwr.zza((zzwr) this.zza, zzwu);
            return this;
        }

        public final zza zza(int i) {
            zzg();
            ((zzwr) this.zza).zzf = 0;
            return this;
        }

        private zza() {
            super(zzwr.zzc);
        }
    }

    public static zzwr zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzwr) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zzwu zzd() {
        zzwu zzwu = this.zzg;
        return zzwu == null ? zzwu.zze() : zzwu;
    }

    public final zzajv zze() {
        return this.zzh;
    }

    public static zzamv<zzwr> zzf() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzwt.zza[i - 1]) {
            case 1:
                return new zzwr();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzwr> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzwr.class) {
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

    static /* synthetic */ void zza(zzwr zzwr, zzajv zzajv) {
        zzajv.getClass();
        zzwr.zzh = zzajv;
    }

    static /* synthetic */ void zza(zzwr zzwr, zzwu zzwu) {
        zzwu.getClass();
        zzwr.zzg = zzwu;
        zzwr.zze |= 1;
    }

    static {
        zzwr zzwr = new zzwr();
        zzc = zzwr;
        zzalf.zza(zzwr.class, zzwr);
    }

    private zzwr() {
    }
}
