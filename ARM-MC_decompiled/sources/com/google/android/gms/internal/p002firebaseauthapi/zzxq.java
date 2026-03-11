package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzxq extends zzalf<zzxq, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzxq zzc;
    private static volatile zzamv<zzxq> zzd;
    private String zze = "";

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzxq zzc() {
        return zzc;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxq$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzxq, zza> implements zzamo {
        public final zza zza(String str) {
            zzg();
            zzxq.zza((zzxq) this.zza, str);
            return this;
        }

        private zza() {
            super(zzxq.zzc);
        }
    }

    public static zzxq zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzxq) zzalf.zza(zzc, zzajv, zzaku);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzxs.zza[i - 1]) {
            case 1:
                return new zzxq();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzxq> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzxq.class) {
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

    public final String zzd() {
        return this.zze;
    }

    static /* synthetic */ void zza(zzxq zzxq, String str) {
        str.getClass();
        zzxq.zze = str;
    }

    static {
        zzxq zzxq = new zzxq();
        zzc = zzxq;
        zzalf.zza(zzxq.class, zzxq);
    }

    private zzxq() {
    }
}
