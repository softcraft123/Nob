package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzto  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzto extends zzalf<zzto, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzto zzc;
    private static volatile zzamv<zzto> zzd;
    private int zze;
    private zztr zzf;
    /* access modifiers changed from: private */
    public int zzg;

    public final int zza() {
        return this.zzg;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzto$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzto, zza> implements zzamo {
        public final zza zza(int i) {
            zzg();
            ((zzto) this.zza).zzg = i;
            return this;
        }

        public final zza zza(zztr zztr) {
            zzg();
            zzto.zza((zzto) this.zza, zztr);
            return this;
        }

        private zza() {
            super(zzto.zzc);
        }
    }

    public static zzto zzd() {
        return zzc;
    }

    public final zztr zze() {
        zztr zztr = this.zzf;
        return zztr == null ? zztr.zzd() : zztr;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zztq.zza[i - 1]) {
            case 1:
                return new zzto();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzto> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzto.class) {
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

    static /* synthetic */ void zza(zzto zzto, zztr zztr) {
        zztr.getClass();
        zzto.zzf = zztr;
        zzto.zze |= 1;
    }

    static {
        zzto zzto = new zzto();
        zzc = zzto;
        zzalf.zza(zzto.class, zzto);
    }

    private zzto() {
    }
}
