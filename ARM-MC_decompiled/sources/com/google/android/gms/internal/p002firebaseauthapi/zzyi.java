package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzyi extends zzalf<zzyi, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzyi zzc;
    private static volatile zzamv<zzyi> zzd;
    private int zze;
    private int zzf;
    private zzyl zzg;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyi$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzyi, zza> implements zzamo {
        public final zza zza(zzyl zzyl) {
            zzg();
            zzyi.zza((zzyi) this.zza, zzyl);
            return this;
        }

        private zza() {
            super(zzyi.zzc);
        }
    }

    public static zzyi zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzyi) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zzyl zzd() {
        zzyl zzyl = this.zzg;
        return zzyl == null ? zzyl.zzd() : zzyl;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzyh.zza[i - 1]) {
            case 1:
                return new zzyi();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzyi> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzyi.class) {
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

    static /* synthetic */ void zza(zzyi zzyi, zzyl zzyl) {
        zzyl.getClass();
        zzyi.zzg = zzyl;
        zzyi.zze |= 1;
    }

    static {
        zzyi zzyi = new zzyi();
        zzc = zzyi;
        zzalf.zza(zzyi.class, zzyi);
    }

    private zzyi() {
    }
}
