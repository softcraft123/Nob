package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzti  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzti extends zzalf<zzti, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzti zzc;
    private static volatile zzamv<zzti> zzd;
    private int zze;
    private zzto zzf;
    private zzwe zzg;

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzti zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzti) zzalf.zza(zzc, zzajv, zzaku);
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzti$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzti, zza> implements zzamo {
        public final zza zza(zzto zzto) {
            zzg();
            zzti.zza((zzti) this.zza, zzto);
            return this;
        }

        public final zza zza(zzwe zzwe) {
            zzg();
            zzti.zza((zzti) this.zza, zzwe);
            return this;
        }

        private zza() {
            super(zzti.zzc);
        }
    }

    public final zzto zzc() {
        zzto zzto = this.zzf;
        return zzto == null ? zzto.zzd() : zzto;
    }

    public final zzwe zzd() {
        zzwe zzwe = this.zzg;
        return zzwe == null ? zzwe.zze() : zzwe;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zztk.zza[i - 1]) {
            case 1:
                return new zzti();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzti> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzti.class) {
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

    static /* synthetic */ void zza(zzti zzti, zzto zzto) {
        zzto.getClass();
        zzti.zzf = zzto;
        zzti.zze |= 1;
    }

    static /* synthetic */ void zza(zzti zzti, zzwe zzwe) {
        zzwe.getClass();
        zzti.zzg = zzwe;
        zzti.zze |= 2;
    }

    static {
        zzti zzti = new zzti();
        zzc = zzti;
        zzalf.zza(zzti.class, zzti);
    }

    private zzti() {
    }
}
