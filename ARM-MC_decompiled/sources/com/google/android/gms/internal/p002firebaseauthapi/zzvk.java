package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzvk extends zzalf<zzvk, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzvk zzc;
    private static volatile zzamv<zzvk> zzd;
    private int zze;
    private zzvt zzf;
    private zzve zzg;
    /* access modifiers changed from: private */
    public int zzh;

    public final zzvb zza() {
        zzvb zza2 = zzvb.zza(this.zzh);
        return zza2 == null ? zzvb.UNRECOGNIZED : zza2;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvk$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzvk, zza> implements zzamo {
        public final zza zza(zzve zzve) {
            zzg();
            zzvk.zza((zzvk) this.zza, zzve);
            return this;
        }

        public final zza zza(zzvb zzvb) {
            zzg();
            ((zzvk) this.zza).zzh = zzvb.zza();
            return this;
        }

        public final zza zza(zzvt zzvt) {
            zzg();
            zzvk.zza((zzvk) this.zza, zzvt);
            return this;
        }

        private zza() {
            super(zzvk.zzc);
        }
    }

    public final zzve zzb() {
        zzve zzve = this.zzg;
        return zzve == null ? zzve.zzc() : zzve;
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzvk zze() {
        return zzc;
    }

    public final zzvt zzf() {
        zzvt zzvt = this.zzf;
        return zzvt == null ? zzvt.zzc() : zzvt;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzvj.zza[i - 1]) {
            case 1:
                return new zzvk();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzvk> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzvk.class) {
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

    static /* synthetic */ void zza(zzvk zzvk, zzve zzve) {
        zzve.getClass();
        zzvk.zzg = zzve;
        zzvk.zze |= 2;
    }

    static /* synthetic */ void zza(zzvk zzvk, zzvt zzvt) {
        zzvt.getClass();
        zzvk.zzf = zzvt;
        zzvk.zze |= 1;
    }

    static {
        zzvk zzvk = new zzvk();
        zzc = zzvk;
        zzalf.zza(zzvk.class, zzvk);
    }

    private zzvk() {
    }
}
