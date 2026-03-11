package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzwl extends zzalf<zzwl, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzwl zzc;
    private static volatile zzamv<zzwl> zzd;
    private int zze;
    private zzwo zzf;

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzwl zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzwl) zzalf.zza(zzc, zzajv, zzaku);
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwl$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzwl, zza> implements zzamo {
        public final zza zza(zzwo zzwo) {
            zzg();
            zzwl.zza((zzwl) this.zza, zzwo);
            return this;
        }

        private zza() {
            super(zzwl.zzc);
        }
    }

    public final zzwo zzc() {
        zzwo zzwo = this.zzf;
        return zzwo == null ? zzwo.zzf() : zzwo;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzwn.zza[i - 1]) {
            case 1:
                return new zzwl();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzwl> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzwl.class) {
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

    static /* synthetic */ void zza(zzwl zzwl, zzwo zzwo) {
        zzwo.getClass();
        zzwl.zzf = zzwo;
        zzwl.zze |= 1;
    }

    static {
        zzwl zzwl = new zzwl();
        zzc = zzwl;
        zzalf.zza(zzwl.class, zzwl);
    }

    private zzwl() {
    }
}
