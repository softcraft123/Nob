package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzxh extends zzalf<zzxh, zza> implements zzamo {
    /* access modifiers changed from: private */
    public static final zzxh zzc;
    private static volatile zzamv<zzxh> zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzalm<zzb> zzf = zzp();

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxh$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zzb extends zzalf<zzb, zza> implements zzamo {
        /* access modifiers changed from: private */
        public static final zzb zzc;
        private static volatile zzamv<zzb> zzd;
        private int zze;
        private zzwx zzf;
        /* access modifiers changed from: private */
        public int zzg;
        /* access modifiers changed from: private */
        public int zzh;
        /* access modifiers changed from: private */
        public int zzi;

        public final int zza() {
            return this.zzh;
        }

        public final zzwx zzb() {
            zzwx zzwx = this.zzf;
            return zzwx == null ? zzwx.zzd() : zzwx;
        }

        /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxh$zzb$zza */
        /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
        public static final class zza extends zzalf.zzb<zzb, zza> implements zzamo {
            public final zza zza(zzwx.zza zza) {
                zzg();
                zzb.zza((zzb) this.zza, (zzwx) ((zzalf) zza.zze()));
                return this;
            }

            public final zza zza(zzwx zzwx) {
                zzg();
                zzb.zza((zzb) this.zza, zzwx);
                return this;
            }

            public final zza zza(int i) {
                zzg();
                ((zzb) this.zza).zzh = i;
                return this;
            }

            public final zza zza(zzxz zzxz) {
                zzg();
                ((zzb) this.zza).zzi = zzxz.zza();
                return this;
            }

            public final zza zza(zzxc zzxc) {
                zzg();
                ((zzb) this.zza).zzg = zzxc.zza();
                return this;
            }

            private zza() {
                super(zzb.zzc);
            }
        }

        public final zzxc zzc() {
            zzxc zza2 = zzxc.zza(this.zzg);
            return zza2 == null ? zzxc.UNRECOGNIZED : zza2;
        }

        public static zza zzd() {
            return (zza) zzc.zzm();
        }

        public final zzxz zzf() {
            zzxz zza2 = zzxz.zza(this.zzi);
            return zza2 == null ? zzxz.UNRECOGNIZED : zza2;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzamv zzamv;
            switch (zzxj.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza();
                case 3:
                    return zza((zzamm) zzc, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
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

        static /* synthetic */ void zza(zzb zzb, zzwx zzwx) {
            zzwx.getClass();
            zzb.zzf = zzwx;
            zzb.zze |= 1;
        }

        static {
            zzb zzb = new zzb();
            zzc = zzb;
            zzalf.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        public final boolean zzg() {
            return (this.zze & 1) != 0;
        }
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxh$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static final class zza extends zzalf.zzb<zzxh, zza> implements zzamo {
        public final zza zza(zzb zzb) {
            zzg();
            zzxh.zza((zzxh) this.zza, zzb);
            return this;
        }

        public final zza zza(int i) {
            zzg();
            ((zzxh) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzxh.zzc);
        }
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public final zzb zza(int i) {
        return (zzb) this.zzf.get(i);
    }

    public static zzxh zza(InputStream inputStream, zzaku zzaku) throws IOException {
        return (zzxh) zzalf.zza(zzc, inputStream, zzaku);
    }

    public static zzxh zza(byte[] bArr, zzaku zzaku) throws zzall {
        return (zzxh) zzalf.zza(zzc, bArr, zzaku);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzamv zzamv;
        switch (zzxj.zza[i - 1]) {
            case 1:
                return new zzxh();
            case 2:
                return new zza();
            case 3:
                return zza((zzamm) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zzb.class});
            case 4:
                return zzc;
            case 5:
                zzamv<zzxh> zzamv2 = zzd;
                if (zzamv2 != null) {
                    return zzamv2;
                }
                synchronized (zzxh.class) {
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

    public final List<zzb> zze() {
        return this.zzf;
    }

    static /* synthetic */ void zza(zzxh zzxh, zzb zzb2) {
        zzb2.getClass();
        zzalm<zzb> zzalm = zzxh.zzf;
        if (!zzalm.zzc()) {
            zzxh.zzf = zzalf.zza(zzalm);
        }
        zzxh.zzf.add(zzb2);
    }

    static {
        zzxh zzxh = new zzxh();
        zzc = zzxh;
        zzalf.zza(zzxh.class, zzxh);
    }

    private zzxh() {
    }
}
