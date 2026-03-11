package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzxb extends zzalf<zzxb, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzxb zzc;
    private static volatile zzamv<zzxb> zzd;
    private String zze = "";
    private zzajv zzf = zzajv.zza;
    /* access modifiers changed from: private */
    public int zzg;

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zza zza(zzxb zzxb) {
        return (zza) zzc.zzm().zza(zzxb);
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxb$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzxb, zza> implements zzamo {
        public final zza zza(zzxz zzxz) {
            zzg();
            ((zzxb) this.zza).zzg = zzxz.zza();
            return this;
        }

        public final zza zza(String str) {
            zzg();
            zzxb.zza((zzxb) this.zza, str);
            return this;
        }

        public final zza zza(zzajv zzajv) {
            zzg();
            zzxb.zza((zzxb) this.zza, zzajv);
            return this;
        }

        private zza() {
            super(zzxb.zzc);
        }
    }

    public static zzxb zzc() {
        return zzc;
    }

    public static zzxb zza(byte[] bArr, zzaku zzaku) throws zzall {
        return (zzxb) zzalf.zza(zzc, bArr, zzaku);
    }

    public final zzxz zzd() {
        zzxz zza2 = zzxz.zza(this.zzg);
        return zza2 == null ? zzxz.UNRECOGNIZED : zza2;
    }

    public final zzajv zze() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzxd.zza[i - 1]) {
            case 1:
                return new zzxb();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzxb> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzxb.class) {
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

    public final String zzf() {
        return this.zze;
    }

    static /* synthetic */ void zza(zzxb zzxb, String str) {
        str.getClass();
        zzxb.zze = str;
    }

    static /* synthetic */ void zza(zzxb zzxb, zzajv zzajv) {
        zzajv.getClass();
        zzxb.zzf = zzajv;
    }

    static {
        zzxb zzxb = new zzxb();
        zzc = zzxb;
        zzalf.zza(zzxb.class, zzxb);
    }

    private zzxb() {
    }
}
