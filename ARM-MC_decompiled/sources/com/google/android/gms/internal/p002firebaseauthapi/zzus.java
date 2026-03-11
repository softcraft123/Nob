package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzus  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzus extends zzalf<zzus, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzus zzc;
    private static volatile zzamv<zzus> zzd;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzus$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzus, zza> implements zzamo {
        public final zza zza(int i) {
            zzg();
            ((zzus) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzus.zzc);
        }
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzus zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzus) zzalf.zza(zzc, zzajv, zzaku);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzuu.zza[i - 1]) {
            case 1:
                return new zzus();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzus> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzus.class) {
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
        zzus zzus = new zzus();
        zzc = zzus;
        zzalf.zza(zzus.class, zzus);
    }

    private zzus() {
    }
}
