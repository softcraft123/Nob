package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzxk extends zzalf<zzxk, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzxk zzc;
    private static volatile zzamv<zzxk> zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzalm<zzb> zzf = zzp();

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxk$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zzb extends zzalf<zzb, zza> implements zzamo {
        /* access modifiers changed from: private */
        public static final zzb zzc;
        private static volatile zzamv<zzb> zzd;
        private String zze = "";
        /* access modifiers changed from: private */
        public int zzf;
        /* access modifiers changed from: private */
        public int zzg;
        /* access modifiers changed from: private */
        public int zzh;

        public static zza zza() {
            return (zza) zzc.zzm();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzamv zzamv;
            switch (zzxm.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza();
                case 3:
                    return zza((zzamm) zzc, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzc;
                case 5:
                    zzamv<zzb> zzamv2 = zzd;
                    if (zzamv2 != null) {
                        return zzamv2;
                    }
                    synchronized (zzb.class) {
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

        /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxk$zzb$zza */
        /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
        public static final class zza extends zzalf.zzb<zzb, zza> implements zzamo {
            public final zza zza(int i) {
                zzg();
                ((zzb) this.zza).zzg = i;
                return this;
            }

            public final zza zza(zzxz zzxz) {
                zzg();
                ((zzb) this.zza).zzh = zzxz.zza();
                return this;
            }

            public final zza zza(zzxc zzxc) {
                zzg();
                ((zzb) this.zza).zzf = zzxc.zza();
                return this;
            }

            public final zza zza(String str) {
                zzg();
                zzb.zza((zzb) this.zza, str);
                return this;
            }

            private zza() {
                super(zzb.zzc);
            }
        }

        static /* synthetic */ void zza(zzb zzb, String str) {
            str.getClass();
            zzb.zze = str;
        }

        static {
            zzb zzb = new zzb();
            zzc = zzb;
            zzalf.zza(zzb.class, zzb);
        }

        private zzb() {
        }
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzxm.zza[i - 1]) {
            case 1:
                return new zzxk();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zzb.class});
            case 4:
                return zzc;
            case 5:
                zzamv<zzxk> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzxk.class) {
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

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxk$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzxk, zza> implements zzamo {
        public final zza zza(zzb zzb) {
            zzg();
            zzxk.zza((zzxk) this.zza, zzb);
            return this;
        }

        public final zza zza(int i) {
            zzg();
            ((zzxk) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzxk.zzc);
        }
    }

    static /* synthetic */ void zza(zzxk zzxk, zzb zzb2) {
        zzb2.getClass();
        zzalm<zzb> zzalm = zzxk.zzf;
        if (!zzalm.zzc()) {
            zzxk.zzf = zzalf.zza(zzalm);
        }
        zzxk.zzf.add(zzb2);
    }

    static {
        zzxk zzxk = new zzxk();
        zzc = zzxk;
        zzalf.zza(zzxk.class, zzxk);
    }

    private zzxk() {
    }
}
