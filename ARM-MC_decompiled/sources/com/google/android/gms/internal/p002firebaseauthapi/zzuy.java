package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzuy extends zzalf<zzuy, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzuy zzc;
    private static volatile zzamv<zzuy> zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuy$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzuy, zza> implements zzamo {
        private zza() {
            super(zzuy.zzc);
        }
    }

    public static zzuy zzb() {
        return zzc;
    }

    public static zzuy zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzuy) zzalf.zza(zzc, zzajv, zzaku);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzva.zza[i - 1]) {
            case 1:
                return new zzuy();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzc;
            case 5:
                zzamv<zzuy> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzuy.class) {
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
        zzuy zzuy = new zzuy();
        zzc = zzuy;
        zzalf.zza(zzuy.class, zzuy);
    }

    private zzuy() {
    }
}
