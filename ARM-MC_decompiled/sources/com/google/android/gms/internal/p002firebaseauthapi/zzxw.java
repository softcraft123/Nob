package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzxw extends zzalf<zzxw, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzxw zzc;
    private static volatile zzamv<zzxw> zzd;
    private int zze;
    private String zzf = "";
    private zzxb zzg;

    public final zzxb zza() {
        zzxb zzxb = this.zzg;
        return zzxb == null ? zzxb.zzc() : zzxb;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxw$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzxw, zza> implements zzamo {
        public final zza zza(zzxb zzxb) {
            zzg();
            zzxw.zza((zzxw) this.zza, zzxb);
            return this;
        }

        public final zza zza(String str) {
            zzg();
            zzxw.zza((zzxw) this.zza, str);
            return this;
        }

        private zza() {
            super(zzxw.zzc);
        }
    }

    public static zzxw zzd() {
        return zzc;
    }

    public static zzxw zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzxw) zzalf.zza(zzc, zzajv, zzaku);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzxy.zza[i - 1]) {
            case 1:
                return new zzxw();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzxw> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzxw.class) {
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

    public final String zze() {
        return this.zzf;
    }

    static /* synthetic */ void zza(zzxw zzxw, zzxb zzxb) {
        zzxb.getClass();
        zzxw.zzg = zzxb;
        zzxw.zze |= 1;
    }

    static /* synthetic */ void zza(zzxw zzxw, String str) {
        str.getClass();
        zzxw.zzf = str;
    }

    static {
        zzxw zzxw = new zzxw();
        zzc = zzxw;
        zzalf.zza(zzxw.class, zzxw);
    }

    private zzxw() {
    }
}
