package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxe  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzxe extends zzalf<zzxe, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzxe zzc;
    private static volatile zzamv<zzxe> zzd;
    private String zze = "";
    private String zzf = "";
    private int zzg;
    private boolean zzh;
    private String zzi = "";

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxe$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzxe, zza> implements zzamo {
        private zza() {
            super(zzxe.zzc);
        }
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzxg.zza[i - 1]) {
            case 1:
                return new zzxe();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzxe> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzxe.class) {
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
        zzxe zzxe = new zzxe();
        zzc = zzxe;
        zzalf.zza(zzxe.class, zzxe);
    }

    private zzxe() {
    }
}
