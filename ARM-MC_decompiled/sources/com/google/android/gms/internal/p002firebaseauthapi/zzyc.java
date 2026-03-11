package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzyc extends zzalf<zzyc, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzyc zzc;
    private static volatile zzamv<zzyc> zzd;
    private String zze = "";
    private zzalm<zzxe> zzf = zzp();

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyc$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzyc, zza> implements zzamo {
        private zza() {
            super(zzyc.zzc);
        }
    }

    public static zzyc zzb() {
        return zzc;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzyb.zza[i - 1]) {
            case 1:
                return new zzyc();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zze", "zzf", zzxe.class});
            case 4:
                return zzc;
            case 5:
                zzamv<zzyc> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzyc.class) {
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
        zzyc zzyc = new zzyc();
        zzc = zzyc;
        zzalf.zza(zzyc.class, zzyc);
    }

    private zzyc() {
    }
}
