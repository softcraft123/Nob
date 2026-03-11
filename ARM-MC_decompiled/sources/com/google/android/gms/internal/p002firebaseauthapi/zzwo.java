package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzwo extends zzalf<zzwo, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzwo zzc;
    private static volatile zzamv<zzwo> zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public int zzg;

    public final zzwk zza() {
        zzwk zza2 = zzwk.zza(this.zzg);
        return zza2 == null ? zzwk.UNRECOGNIZED : zza2;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwo$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzwo, zza> implements zzamo {
        public final zza zza(zzwk zzwk) {
            zzg();
            ((zzwo) this.zza).zzg = zzwk.zza();
            return this;
        }

        public final zza zza(zzwj zzwj) {
            zzg();
            ((zzwo) this.zza).zzf = zzwj.zza();
            return this;
        }

        public final zza zza(zzwm zzwm) {
            zzg();
            ((zzwo) this.zza).zze = zzwm.zza();
            return this;
        }

        private zza() {
            super(zzwo.zzc);
        }
    }

    public final zzwj zzb() {
        zzwj zza2 = zzwj.zza(this.zzf);
        return zza2 == null ? zzwj.UNRECOGNIZED : zza2;
    }

    public final zzwm zzc() {
        zzwm zza2 = zzwm.zza(this.zze);
        return zza2 == null ? zzwm.UNRECOGNIZED : zza2;
    }

    public static zza zzd() {
        return (zza) zzc.zzm();
    }

    public static zzwo zzf() {
        return zzc;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzwq.zza[i - 1]) {
            case 1:
                return new zzwo();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzwo> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzwo.class) {
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

    static {
        zzwo zzwo = new zzwo();
        zzc = zzwo;
        zzalf.zza(zzwo.class, zzwo);
    }

    private zzwo() {
    }
}
