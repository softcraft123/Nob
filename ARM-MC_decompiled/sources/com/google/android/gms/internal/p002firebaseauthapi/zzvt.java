package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzvt extends zzalf<zzvt, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzvt zzc;
    private static volatile zzamv<zzvt> zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    private zzajv zzg = zzajv.zza;

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzvt zzc() {
        return zzc;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvt$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzvt, zza> implements zzamo {
        public final zza zza(zzvw zzvw) {
            zzg();
            ((zzvt) this.zza).zze = zzvw.zza();
            return this;
        }

        public final zza zza(zzvy zzvy) {
            zzg();
            ((zzvt) this.zza).zzf = zzvy.zza();
            return this;
        }

        public final zza zza(zzajv zzajv) {
            zzg();
            zzvt.zza((zzvt) this.zza, zzajv);
            return this;
        }

        private zza() {
            super(zzvt.zzc);
        }
    }

    public final zzvw zzd() {
        zzvw zza2 = zzvw.zza(this.zze);
        return zza2 == null ? zzvw.UNRECOGNIZED : zza2;
    }

    public final zzvy zze() {
        zzvy zza2 = zzvy.zza(this.zzf);
        return zza2 == null ? zzvy.UNRECOGNIZED : zza2;
    }

    public final zzajv zzf() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzvs.zza[i - 1]) {
            case 1:
                return new zzvt();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzvt> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzvt.class) {
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

    static /* synthetic */ void zza(zzvt zzvt, zzajv zzajv) {
        zzajv.getClass();
        zzvt.zzg = zzajv;
    }

    static {
        zzvt zzvt = new zzvt();
        zzc = zzvt;
        zzalf.zza(zzvt.class, zzvt);
    }

    private zzvt() {
    }
}
