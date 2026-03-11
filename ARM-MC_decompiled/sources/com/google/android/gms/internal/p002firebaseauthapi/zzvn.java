package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzvn extends zzalf<zzvn, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzvn zzc;
    private static volatile zzamv<zzvn> zzd;
    private int zze;
    /* access modifiers changed from: private */
    public int zzf;
    private zzvq zzg;
    private zzajv zzh = zzajv.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvn$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzvn, zza> implements zzamo {
        public final zza zza(zzajv zzajv) {
            zzg();
            zzvn.zza((zzvn) this.zza, zzajv);
            return this;
        }

        public final zza zza(zzvq zzvq) {
            zzg();
            zzvn.zza((zzvn) this.zza, zzvq);
            return this;
        }

        public final zza zza(int i) {
            zzg();
            ((zzvn) this.zza).zzf = 0;
            return this;
        }

        private zza() {
            super(zzvn.zzc);
        }
    }

    public static zzvn zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzvn) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zzvq zzd() {
        zzvq zzvq = this.zzg;
        return zzvq == null ? zzvq.zze() : zzvq;
    }

    public final zzajv zze() {
        return this.zzh;
    }

    public static zzamv<zzvn> zzf() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzvm.zza[i - 1]) {
            case 1:
                return new zzvn();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzvn> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzvn.class) {
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

    static /* synthetic */ void zza(zzvn zzvn, zzajv zzajv) {
        zzajv.getClass();
        zzvn.zzh = zzajv;
    }

    static /* synthetic */ void zza(zzvn zzvn, zzvq zzvq) {
        zzvq.getClass();
        zzvn.zzg = zzvq;
        zzvn.zze |= 1;
    }

    static {
        zzvn zzvn = new zzvn();
        zzc = zzvn;
        zzalf.zza(zzvn.class, zzvn);
    }

    private zzvn() {
    }
}
