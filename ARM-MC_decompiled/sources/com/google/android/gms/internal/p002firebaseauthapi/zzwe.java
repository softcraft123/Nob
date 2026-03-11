package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwe  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzwe extends zzalf<zzwe, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzwe zzc;
    private static volatile zzamv<zzwe> zzd;
    private int zze;
    private zzwh zzf;
    /* access modifiers changed from: private */
    public int zzg;
    private int zzh;

    public final int zza() {
        return this.zzg;
    }

    public final int zzb() {
        return this.zzh;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwe$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzwe, zza> implements zzamo {
        public final zza zza(int i) {
            zzg();
            ((zzwe) this.zza).zzg = i;
            return this;
        }

        public final zza zza(zzwh zzwh) {
            zzg();
            zzwe.zza((zzwe) this.zza, zzwh);
            return this;
        }

        private zza() {
            super(zzwe.zzc);
        }
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzwe zze() {
        return zzc;
    }

    public static zzwe zza(zzajv zzajv, zzaku zzaku) throws zzall {
        return (zzwe) zzalf.zza(zzc, zzajv, zzaku);
    }

    public final zzwh zzf() {
        zzwh zzwh = this.zzf;
        return zzwh == null ? zzwh.zze() : zzwh;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzwd.zza[i - 1]) {
            case 1:
                return new zzwe();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzwe> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzwe.class) {
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

    static /* synthetic */ void zza(zzwe zzwe, zzwh zzwh) {
        zzwh.getClass();
        zzwe.zzf = zzwh;
        zzwe.zze |= 1;
    }

    static {
        zzwe zzwe = new zzwe();
        zzc = zzwe;
        zzalf.zza(zzwe.class, zzwe);
    }

    private zzwe() {
    }
}
