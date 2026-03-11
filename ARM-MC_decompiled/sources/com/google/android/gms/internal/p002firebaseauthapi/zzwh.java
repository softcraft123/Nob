package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzwh extends zzalf<zzwh, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzwh zzc;
    private static volatile zzamv<zzwh> zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;

    public final int zza() {
        return this.zzf;
    }

    public final zzvy zzb() {
        zzvy zza2 = zzvy.zza(this.zze);
        return zza2 == null ? zzvy.UNRECOGNIZED : zza2;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwh$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzwh, zza> implements zzamo {
        public final zza zza(zzvy zzvy) {
            zzg();
            ((zzwh) this.zza).zze = zzvy.zza();
            return this;
        }

        public final zza zza(int i) {
            zzg();
            ((zzwh) this.zza).zzf = i;
            return this;
        }

        private zza() {
            super(zzwh.zzc);
        }
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzwh zze() {
        return zzc;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzwg.zza[i - 1]) {
            case 1:
                return new zzwh();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzwh> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzwh.class) {
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
        zzwh zzwh = new zzwh();
        zzc = zzwh;
        zzalf.zza(zzwh.class, zzwh);
    }

    private zzwh() {
    }
}
