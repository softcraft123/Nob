package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzyr extends zzalf<zzyr, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzyr zzc;
    private static volatile zzamv<zzyr> zzd;
    private int zze;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyr$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzyr, zza> implements zzamo {
        private zza() {
            super(zzyr.zzc);
        }
    }

    public final int zza() {
        return this.zze;
    }

    public static zzyr zzc() {
        return zzc;
    }

    public static zzyr zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzyr) zzalf.zza(zzc, zzajv, zzaku);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzyq.zza[i - 1]) {
            case 1:
                return new zzyr();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzyr> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzyr.class) {
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
        zzyr zzyr = new zzyr();
        zzc = zzyr;
        zzalf.zza(zzyr.class, zzyr);
    }

    private zzyr() {
    }
}
