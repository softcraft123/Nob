package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzxt extends zzalf<zzxt, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzxt zzc;
    private static volatile zzamv<zzxt> zzd;
    private int zze;
    private int zzf;
    private zzxw zzg;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxt$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzxt, zza> implements zzamo {
        public final zza zza(zzxw zzxw) {
            zzg();
            zzxt.zza((zzxt) this.zza, zzxw);
            return this;
        }

        private zza() {
            super(zzxt.zzc);
        }
    }

    public static zzxt zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzxt) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zzxw zzd() {
        zzxw zzxw = this.zzg;
        return zzxw == null ? zzxw.zzd() : zzxw;
    }

    public static zzamv<zzxt> zze() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzxv.zza[i - 1]) {
            case 1:
                return new zzxt();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzxt> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzxt.class) {
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

    static /* synthetic */ void zza(zzxt zzxt, zzxw zzxw) {
        zzxw.getClass();
        zzxt.zzg = zzxw;
        zzxt.zze |= 1;
    }

    static {
        zzxt zzxt = new zzxt();
        zzc = zzxt;
        zzalf.zza(zzxt.class, zzxt);
    }

    private zzxt() {
    }
}
