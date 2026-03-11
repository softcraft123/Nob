package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzwu extends zzalf<zzwu, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzwu zzc;
    private static volatile zzamv<zzwu> zzd;
    private int zze;
    /* access modifiers changed from: private */
    public int zzf;
    private zzwo zzg;
    private zzajv zzh = zzajv.zza;

    public final int zza() {
        return this.zzf;
    }

    public final zzwo zzb() {
        zzwo zzwo = this.zzg;
        return zzwo == null ? zzwo.zzf() : zzwo;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwu$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzwu, zza> implements zzamo {
        public final zza zza(zzwo zzwo) {
            zzg();
            zzwu.zza((zzwu) this.zza, zzwo);
            return this;
        }

        public final zza zza(zzajv zzajv) {
            zzg();
            zzwu.zza((zzwu) this.zza, zzajv);
            return this;
        }

        public final zza zza(int i) {
            zzg();
            ((zzwu) this.zza).zzf = 0;
            return this;
        }

        private zza() {
            super(zzwu.zzc);
        }
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzwu zze() {
        return zzc;
    }

    public static zzwu zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzwu) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zzajv zzf() {
        return this.zzh;
    }

    public static zzamv<zzwu> zzg() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzww.zza[i - 1]) {
            case 1:
                return new zzwu();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzwu> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzwu.class) {
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

    static /* synthetic */ void zza(zzwu zzwu, zzwo zzwo) {
        zzwo.getClass();
        zzwu.zzg = zzwo;
        zzwu.zze |= 1;
    }

    static /* synthetic */ void zza(zzwu zzwu, zzajv zzajv) {
        zzajv.getClass();
        zzwu.zzh = zzajv;
    }

    static {
        zzwu zzwu = new zzwu();
        zzc = zzwu;
        zzalf.zza(zzwu.class, zzwu);
    }

    private zzwu() {
    }
}
