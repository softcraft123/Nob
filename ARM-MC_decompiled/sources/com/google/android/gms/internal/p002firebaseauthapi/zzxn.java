package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzxn extends zzalf<zzxn, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzxn zzc;
    private static volatile zzamv<zzxn> zzd;
    private int zze;
    private int zzf;
    private zzxq zzg;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxn$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzxn, zza> implements zzamo {
        public final zza zza(zzxq zzxq) {
            zzg();
            zzxn.zza((zzxn) this.zza, zzxq);
            return this;
        }

        private zza() {
            super(zzxn.zzc);
        }
    }

    public static zzxn zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzxn) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zzxq zzd() {
        zzxq zzxq = this.zzg;
        return zzxq == null ? zzxq.zzc() : zzxq;
    }

    public static zzamv<zzxn> zze() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzxp.zza[i - 1]) {
            case 1:
                return new zzxn();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzxn> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzxn.class) {
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

    static /* synthetic */ void zza(zzxn zzxn, zzxq zzxq) {
        zzxq.getClass();
        zzxn.zzg = zzxq;
        zzxn.zze |= 1;
    }

    static {
        zzxn zzxn = new zzxn();
        zzc = zzxn;
        zzalf.zza(zzxn.class, zzxn);
    }

    private zzxn() {
    }
}
