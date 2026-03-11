package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzvq extends zzalf<zzvq, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzvq zzc;
    private static volatile zzamv<zzvq> zzd;
    private int zze;
    /* access modifiers changed from: private */
    public int zzf;
    private zzvk zzg;
    private zzajv zzh = zzajv.zza;
    private zzajv zzi = zzajv.zza;

    public final int zza() {
        return this.zzf;
    }

    public final zzvk zzb() {
        zzvk zzvk = this.zzg;
        return zzvk == null ? zzvk.zze() : zzvk;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvq$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzvq, zza> implements zzamo {
        public final zza zza(zzvk zzvk) {
            zzg();
            zzvq.zza((zzvq) this.zza, zzvk);
            return this;
        }

        public final zza zza(int i) {
            zzg();
            ((zzvq) this.zza).zzf = 0;
            return this;
        }

        public final zza zza(zzajv zzajv) {
            zzg();
            zzvq.zza((zzvq) this.zza, zzajv);
            return this;
        }

        public final zza zzb(zzajv zzajv) {
            zzg();
            zzvq.zzb((zzvq) this.zza, zzajv);
            return this;
        }

        private zza() {
            super(zzvq.zzc);
        }
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzvq zze() {
        return zzc;
    }

    public static zzvq zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzvq) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zzajv zzf() {
        return this.zzh;
    }

    public final zzajv zzg() {
        return this.zzi;
    }

    public static zzamv<zzvq> zzh() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzvp.zza[i - 1]) {
            case 1:
                return new zzvq();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzvq> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzvq.class) {
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

    static /* synthetic */ void zza(zzvq zzvq, zzvk zzvk) {
        zzvk.getClass();
        zzvq.zzg = zzvk;
        zzvq.zze |= 1;
    }

    static /* synthetic */ void zza(zzvq zzvq, zzajv zzajv) {
        zzajv.getClass();
        zzvq.zzh = zzajv;
    }

    static /* synthetic */ void zzb(zzvq zzvq, zzajv zzajv) {
        zzajv.getClass();
        zzvq.zzi = zzajv;
    }

    static {
        zzvq zzvq = new zzvq();
        zzc = zzvq;
        zzalf.zza(zzvq.class, zzvq);
    }

    private zzvq() {
    }
}
