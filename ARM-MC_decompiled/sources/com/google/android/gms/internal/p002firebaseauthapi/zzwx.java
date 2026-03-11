package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;
import kotlin.text.Typography;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzwx extends zzalf<zzwx, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzwx zzc;
    private static volatile zzamv<zzwx> zzd;
    private String zze = "";
    private zzajv zzf = zzajv.zza;
    /* access modifiers changed from: private */
    public int zzg;

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public final zzb zzb() {
        zzb zza2 = zzb.zza(this.zzg);
        return zza2 == null ? zzb.UNRECOGNIZED : zza2;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwx$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzwx, zza> implements zzamo {
        public final zza zza(zzb zzb) {
            zzg();
            ((zzwx) this.zza).zzg = zzb.zza();
            return this;
        }

        public final zza zza(String str) {
            zzg();
            zzwx.zza((zzwx) this.zza, str);
            return this;
        }

        public final zza zza(zzajv zzajv) {
            zzg();
            zzwx.zza((zzwx) this.zza, zzajv);
            return this;
        }

        private zza() {
            super(zzwx.zzc);
        }
    }

    public static zzwx zzd() {
        return zzc;
    }

    public final zzajv zze() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzwz.zza[i - 1]) {
            case 1:
                return new zzwx();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzwx> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzwx.class) {
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

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwx$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public enum zzb implements zzalk {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private final int zzh;

        public final int zza() {
            if (this != UNRECOGNIZED) {
                return this.zzh;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static zzb zza(int i) {
            if (i == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i == 1) {
                return SYMMETRIC;
            }
            if (i == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i != 4) {
                return null;
            }
            return REMOTE;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=").append(zza());
            }
            return sb.append(" name=").append(name()).append(Typography.greater).toString();
        }

        private zzb(int i) {
            this.zzh = i;
        }
    }

    public final String zzf() {
        return this.zze;
    }

    static /* synthetic */ void zza(zzwx zzwx, String str) {
        str.getClass();
        zzwx.zze = str;
    }

    static /* synthetic */ void zza(zzwx zzwx, zzajv zzajv) {
        zzajv.getClass();
        zzwx.zzf = zzajv;
    }

    static {
        zzwx zzwx = new zzwx();
        zzc = zzwx;
        zzalf.zza(zzwx.class, zzwx);
    }

    private zzwx() {
    }
}
