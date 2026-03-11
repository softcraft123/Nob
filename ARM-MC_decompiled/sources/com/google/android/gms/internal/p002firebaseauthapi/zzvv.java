package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzvv extends zzalf<zzvv, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzvv zzc;
    private static volatile zzamv<zzvv> zzd;
    private int zze;
    private zzajv zzf = zzajv.zza;
    private zzxk zzg;

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzvv zza(InputStream inputStream, zzaku zzaku) throws IOException {
        return (zzvv) zzalf.zza(zzc, inputStream, zzaku);
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvv$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzvv, zza> implements zzamo {
        public final zza zza() {
            zzg();
            zzvv.zza((zzvv) this.zza);
            return this;
        }

        public final zza zza(zzajv zzajv) {
            zzg();
            zzvv.zza((zzvv) this.zza, zzajv);
            return this;
        }

        public final zza zza(zzxk zzxk) {
            zzg();
            zzvv.zza((zzvv) this.zza, zzxk);
            return this;
        }

        private zza() {
            super(zzvv.zzc);
        }
    }

    public final zzajv zzc() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzvx.zza[i - 1]) {
            case 1:
                return new zzvv();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzvv> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzvv.class) {
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

    static /* synthetic */ void zza(zzvv zzvv) {
        zzvv.zzg = null;
        zzvv.zze &= -2;
    }

    static /* synthetic */ void zza(zzvv zzvv, zzajv zzajv) {
        zzajv.getClass();
        zzvv.zzf = zzajv;
    }

    static /* synthetic */ void zza(zzvv zzvv, zzxk zzxk) {
        zzxk.getClass();
        zzvv.zzg = zzxk;
        zzvv.zze |= 1;
    }

    static {
        zzvv zzvv = new zzvv();
        zzc = zzvv;
        zzalf.zza(zzvv.class, zzvv);
    }

    private zzvv() {
    }
}
