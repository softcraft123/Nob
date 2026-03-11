package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzve  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzve extends zzalf<zzve, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzve zzc;
    private static volatile zzamv<zzve> zzd;
    private int zze;
    private zzxb zzf;

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzve zzc() {
        return zzc;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzve$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzve, zza> implements zzamo {
        public final zza zza(zzxb zzxb) {
            zzg();
            zzve.zza((zzve) this.zza, zzxb);
            return this;
        }

        private zza() {
            super(zzve.zzc);
        }
    }

    public final zzxb zzd() {
        zzxb zzxb = this.zzf;
        return zzxb == null ? zzxb.zzc() : zzxb;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzvd.zza[i - 1]) {
            case 1:
                return new zzve();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzve> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzve.class) {
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

    static /* synthetic */ void zza(zzve zzve, zzxb zzxb) {
        zzxb.getClass();
        zzve.zzf = zzxb;
        zzve.zze |= 1;
    }

    static {
        zzve zzve = new zzve();
        zzc = zzve;
        zzalf.zza(zzve.class, zzve);
    }

    private zzve() {
    }
}
