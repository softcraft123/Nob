package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzvh extends zzalf<zzvh, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzvh zzc;
    private static volatile zzamv<zzvh> zzd;
    private int zze;
    private zzvk zzf;

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzvh zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzvh) zzalf.zza(zzc, zzajv, zzaku);
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvh$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzvh, zza> implements zzamo {
        public final zza zza(zzvk zzvk) {
            zzg();
            zzvh.zza((zzvh) this.zza, zzvk);
            return this;
        }

        private zza() {
            super(zzvh.zzc);
        }
    }

    public final zzvk zzc() {
        zzvk zzvk = this.zzf;
        return zzvk == null ? zzvk.zze() : zzvk;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzvg.zza[i - 1]) {
            case 1:
                return new zzvh();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzvh> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzvh.class) {
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

    static /* synthetic */ void zza(zzvh zzvh, zzvk zzvk) {
        zzvk.getClass();
        zzvh.zzf = zzvk;
        zzvh.zze |= 1;
    }

    static {
        zzvh zzvh = new zzvh();
        zzc = zzvh;
        zzalf.zza(zzvh.class, zzvh);
    }

    private zzvh() {
    }
}
