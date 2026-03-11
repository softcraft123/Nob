package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zztr extends zzalf<zztr, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zztr zzc;
    private static volatile zzamv<zztr> zzd;
    /* access modifiers changed from: private */
    public int zze;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztr$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zztr, zza> implements zzamo {
        public final zza zza(int i) {
            zzg();
            ((zztr) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zztr.zzc);
        }
    }

    public static zztr zzd() {
        return zzc;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zztt.zza[i - 1]) {
            case 1:
                return new zztr();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamv<zztr> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zztr.class) {
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
        zztr zztr = new zztr();
        zzc = zztr;
        zzalf.zza(zztr.class, zztr);
    }

    private zztr() {
    }
}
