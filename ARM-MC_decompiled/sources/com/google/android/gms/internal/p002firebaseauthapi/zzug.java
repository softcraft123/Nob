package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzug  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzug extends zzalf<zzug, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzug zzc;
    private static volatile zzamv<zzug> zzd;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzug$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzug, zza> implements zzamo {
        public final zza zza(int i) {
            zzg();
            ((zzug) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzug.zzc);
        }
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzug zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzug) zzalf.zza(zzc, zzajv, zzaku);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzui.zza[i - 1]) {
            case 1:
                return new zzug();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzug> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzug.class) {
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
        zzug zzug = new zzug();
        zzc = zzug;
        zzalf.zza(zzug.class, zzug);
    }

    private zzug() {
    }
}
