package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public abstract class zzakn extends zzajw {
    private static final Logger zzb = Logger.getLogger(zzakn.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzanz.zzc();
    zzakp zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakn$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    private static class zza extends zzakn {
        private final byte[] zzb;
        private final int zzc;
        private int zzd;

        public final int zza() {
            return this.zzc - this.zzd;
        }

        public final void zzc() {
        }

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            } else if (((bArr.length - i2) | i2) >= 0) {
                this.zzb = bArr;
                this.zzd = 0;
                this.zzc = i2;
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)}));
            }
        }

        public final void zza(byte b) throws IOException {
            int i = this.zzd;
            try {
                int i2 = i + 1;
                try {
                    this.zzb[i] = b;
                    this.zzd = i2;
                } catch (IndexOutOfBoundsException e) {
                    e = e;
                    i = i2;
                    throw new zzd(i, this.zzc, 1, (Throwable) e);
                }
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
                throw new zzd(i, this.zzc, 1, (Throwable) e);
            }
        }

        private final void zzc(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.zzb, this.zzd, i2);
                this.zzd += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(this.zzd, this.zzc, i2, (Throwable) e);
            }
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzj(i, 0);
            zza(z ? (byte) 1 : 0);
        }

        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzm(i2);
            zzc(bArr, 0, i2);
        }

        public final void zzc(int i, zzajv zzajv) throws IOException {
            zzj(i, 2);
            zzb(zzajv);
        }

        public final void zzb(zzajv zzajv) throws IOException {
            zzm(zzajv.zzb());
            zzajv.zza((zzajw) this);
        }

        public final void zzg(int i, int i2) throws IOException {
            zzj(i, 5);
            zzj(i2);
        }

        public final void zzj(int i) throws IOException {
            int i2 = this.zzd;
            try {
                byte[] bArr = this.zzb;
                bArr[i2] = (byte) i;
                bArr[i2 + 1] = (byte) (i >> 8);
                bArr[i2 + 2] = (byte) (i >> 16);
                bArr[i2 + 3] = i >> Ascii.CAN;
                this.zzd = i2 + 4;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(i2, this.zzc, 4, (Throwable) e);
            }
        }

        public final void zzf(int i, long j) throws IOException {
            zzj(i, 1);
            zzf(j);
        }

        public final void zzf(long j) throws IOException {
            int i = this.zzd;
            try {
                byte[] bArr = this.zzb;
                bArr[i] = (byte) ((int) j);
                bArr[i + 1] = (byte) ((int) (j >> 8));
                bArr[i + 2] = (byte) ((int) (j >> 16));
                bArr[i + 3] = (byte) ((int) (j >> 24));
                bArr[i + 4] = (byte) ((int) (j >> 32));
                bArr[i + 5] = (byte) ((int) (j >> 40));
                bArr[i + 6] = (byte) ((int) (j >> 48));
                bArr[i + 7] = (byte) ((int) (j >> 56));
                this.zzd = i + 8;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(i, this.zzc, 8, (Throwable) e);
            }
        }

        public final void zzh(int i, int i2) throws IOException {
            zzj(i, 0);
            zzk(i2);
        }

        public final void zzk(int i) throws IOException {
            if (i >= 0) {
                zzm(i);
            } else {
                zzh((long) i);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            zzc(bArr, i, i2);
        }

        public final void zzb(zzamm zzamm) throws IOException {
            zzm(zzamm.zzl());
            zzamm.zza(this);
        }

        public final void zzb(int i, zzamm zzamm) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzj(3, 2);
            zzb(zzamm);
            zzj(1, 4);
        }

        public final void zzd(int i, zzajv zzajv) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzc(3, zzajv);
            zzj(1, 4);
        }

        public final void zzb(int i, String str) throws IOException {
            zzj(i, 2);
            zzb(str);
        }

        public final void zzb(String str) throws IOException {
            int i = this.zzd;
            try {
                int zzi = zzi(str.length() * 3);
                int zzi2 = zzi(str.length());
                if (zzi2 == zzi) {
                    int i2 = i + zzi2;
                    this.zzd = i2;
                    int zza = zzaoa.zza(str, this.zzb, i2, zza());
                    this.zzd = i;
                    zzm((zza - i) - zzi2);
                    this.zzd = zza;
                    return;
                }
                zzm(zzaoa.zza(str));
                this.zzd = zzaoa.zza(str, this.zzb, this.zzd, zza());
            } catch (zzaod e) {
                this.zzd = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzd(e2);
            }
        }

        public final void zzj(int i, int i2) throws IOException {
            zzm((i << 3) | i2);
        }

        public final void zzk(int i, int i2) throws IOException {
            zzj(i, 0);
            zzm(i2);
        }

        public final void zzm(int i) throws IOException {
            int i2;
            int i3 = this.zzd;
            while ((i & -128) != 0) {
                i2 = i3 + 1;
                this.zzb[i3] = (byte) (i | 128);
                i >>>= 7;
                i3 = i2;
            }
            try {
                i2 = i3 + 1;
                try {
                    this.zzb[i3] = (byte) i;
                    this.zzd = i2;
                } catch (IndexOutOfBoundsException e) {
                    e = e;
                    i3 = i2;
                    throw new zzd(i3, this.zzc, 1, (Throwable) e);
                }
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
                throw new zzd(i3, this.zzc, 1, (Throwable) e);
            }
        }

        public final void zzh(int i, long j) throws IOException {
            zzj(i, 0);
            zzh(j);
        }

        public final void zzh(long j) throws IOException {
            int i;
            int i2 = this.zzd;
            if (!zzakn.zzc || zza() < 10) {
                while ((j & -128) != 0) {
                    int i3 = i2 + 1;
                    try {
                        this.zzb[i2] = (byte) (((int) j) | 128);
                        j >>>= 7;
                        i2 = i3;
                    } catch (IndexOutOfBoundsException e) {
                        e = e;
                        i2 = i3;
                        throw new zzd(i2, this.zzc, 1, (Throwable) e);
                    }
                }
                try {
                    i = i2 + 1;
                } catch (IndexOutOfBoundsException e2) {
                    e = e2;
                    throw new zzd(i2, this.zzc, 1, (Throwable) e);
                }
                try {
                    this.zzb[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e3) {
                    e = e3;
                    i2 = i;
                    throw new zzd(i2, this.zzc, 1, (Throwable) e);
                }
            } else {
                while ((j & -128) != 0) {
                    zzanz.zza(this.zzb, (long) i2, (byte) (((int) j) | 128));
                    j >>>= 7;
                    i2++;
                }
                i = i2 + 1;
                zzanz.zza(this.zzb, (long) i2, (byte) ((int) j));
            }
            this.zzd = i;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakn$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    private static abstract class zzb extends zzakn {
        final byte[] zzb;
        final int zzc;
        int zzd;
        int zze;

        public final int zza() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        zzb(int i) {
            super();
            if (i >= 0) {
                byte[] bArr = new byte[Math.max(i, 20)];
                this.zzb = bArr;
                this.zzc = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        /* access modifiers changed from: package-private */
        public final void zzb(byte b) {
            int i = this.zzd;
            this.zzb[i] = b;
            this.zzd = i + 1;
            this.zze++;
        }

        /* access modifiers changed from: package-private */
        public final void zzn(int i) {
            int i2 = this.zzd;
            byte[] bArr = this.zzb;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = i >> Ascii.CAN;
            this.zzd = i2 + 4;
            this.zze += 4;
        }

        /* access modifiers changed from: package-private */
        public final void zzi(long j) {
            int i = this.zzd;
            byte[] bArr = this.zzb;
            bArr[i] = (byte) ((int) j);
            bArr[i + 1] = (byte) ((int) (j >> 8));
            bArr[i + 2] = (byte) ((int) (j >> 16));
            bArr[i + 3] = (byte) ((int) (j >> 24));
            bArr[i + 4] = (byte) ((int) (j >> 32));
            bArr[i + 5] = (byte) ((int) (j >> 40));
            bArr[i + 6] = (byte) ((int) (j >> 48));
            bArr[i + 7] = (byte) ((int) (j >> 56));
            this.zzd = i + 8;
            this.zze += 8;
        }

        /* access modifiers changed from: package-private */
        public final void zzl(int i, int i2) {
            zzo((i << 3) | i2);
        }

        /* access modifiers changed from: package-private */
        public final void zzo(int i) {
            if (zzakn.zzc) {
                long j = (long) this.zzd;
                while ((i & -128) != 0) {
                    byte[] bArr = this.zzb;
                    int i2 = this.zzd;
                    this.zzd = i2 + 1;
                    zzanz.zza(bArr, (long) i2, (byte) (i | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i3 = this.zzd;
                this.zzd = i3 + 1;
                zzanz.zza(bArr2, (long) i3, (byte) i);
                this.zze += (int) (((long) this.zzd) - j);
                return;
            }
            while ((i & -128) != 0) {
                byte[] bArr3 = this.zzb;
                int i4 = this.zzd;
                this.zzd = i4 + 1;
                bArr3[i4] = (byte) (i | 128);
                this.zze++;
                i >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i5 = this.zzd;
            this.zzd = i5 + 1;
            bArr4[i5] = (byte) i;
            this.zze++;
        }

        /* access modifiers changed from: package-private */
        public final void zzj(long j) {
            if (zzakn.zzc) {
                long j2 = (long) this.zzd;
                while ((j & -128) != 0) {
                    byte[] bArr = this.zzb;
                    int i = this.zzd;
                    this.zzd = i + 1;
                    zzanz.zza(bArr, (long) i, (byte) (((int) j) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i2 = this.zzd;
                this.zzd = i2 + 1;
                zzanz.zza(bArr2, (long) i2, (byte) ((int) j));
                this.zze += (int) (((long) this.zzd) - j2);
                return;
            }
            while ((j & -128) != 0) {
                byte[] bArr3 = this.zzb;
                int i3 = this.zzd;
                this.zzd = i3 + 1;
                bArr3[i3] = (byte) (((int) j) | 128);
                this.zze++;
                j >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i4 = this.zzd;
            this.zzd = i4 + 1;
            bArr4[i4] = (byte) ((int) j);
            this.zze++;
        }
    }

    public static int zza(double d) {
        return 8;
    }

    public static int zza(float f) {
        return 4;
    }

    public static int zza(long j) {
        return 8;
    }

    public static int zza(boolean z) {
        return 1;
    }

    public static int zzb(int i) {
        return 4;
    }

    public static int zzc(long j) {
        return 8;
    }

    static int zze(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int zzf(int i) {
        return 4;
    }

    private static long zzi(long j) {
        return (j >> 63) ^ (j << 1);
    }

    private static int zzn(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b) throws IOException;

    public abstract void zzb(int i, zzamm zzamm) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zzajv zzajv) throws IOException;

    public abstract void zzb(zzamm zzamm) throws IOException;

    public abstract void zzb(String str) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzb(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzc() throws IOException;

    public abstract void zzc(int i, zzajv zzajv) throws IOException;

    public abstract void zzd(int i, zzajv zzajv) throws IOException;

    public abstract void zzf(int i, long j) throws IOException;

    public abstract void zzf(long j) throws IOException;

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzh(long j) throws IOException;

    public abstract void zzj(int i) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public abstract void zzk(int i) throws IOException;

    public abstract void zzk(int i, int i2) throws IOException;

    public abstract void zzm(int i) throws IOException;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakn$zzd */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    public static class zzd extends IOException {
        zzd() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzd(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        private zzd(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        zzd(int i, int i2, int i3, Throwable th) {
            this((long) i, (long) i2, i3, th);
        }

        private zzd(long j, long j2, int i, Throwable th) {
            this(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}), th);
        }
    }

    public static int zza(int i, boolean z) {
        return zzi(i << 3) + 1;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakn$zzc */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    private static final class zzc extends zzb {
        private final OutputStream zzf;

        zzc(OutputStream outputStream, int i) {
            super(i);
            if (outputStream != null) {
                this.zzf = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private final void zze() throws IOException {
            this.zzf.write(this.zzb, 0, this.zzd);
            this.zzd = 0;
        }

        public final void zzc() throws IOException {
            if (this.zzd > 0) {
                zze();
            }
        }

        private final void zzp(int i) throws IOException {
            if (this.zzc - this.zzd < i) {
                zze();
            }
        }

        public final void zza(byte b) throws IOException {
            if (this.zzd == this.zzc) {
                zze();
            }
            zzb(b);
        }

        private final void zzc(byte[] bArr, int i, int i2) throws IOException {
            if (this.zzc - this.zzd >= i2) {
                System.arraycopy(bArr, i, this.zzb, this.zzd, i2);
                this.zzd += i2;
            } else {
                int i3 = this.zzc - this.zzd;
                System.arraycopy(bArr, i, this.zzb, this.zzd, i3);
                int i4 = i + i3;
                i2 -= i3;
                this.zzd = this.zzc;
                this.zze += i3;
                zze();
                if (i2 <= this.zzc) {
                    System.arraycopy(bArr, i4, this.zzb, 0, i2);
                    this.zzd = i2;
                } else {
                    this.zzf.write(bArr, i4, i2);
                }
            }
            this.zze += i2;
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzp(11);
            zzl(i, 0);
            zzb(z ? (byte) 1 : 0);
        }

        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzm(i2);
            zzc(bArr, 0, i2);
        }

        public final void zzc(int i, zzajv zzajv) throws IOException {
            zzj(i, 2);
            zzb(zzajv);
        }

        public final void zzb(zzajv zzajv) throws IOException {
            zzm(zzajv.zzb());
            zzajv.zza((zzajw) this);
        }

        public final void zzg(int i, int i2) throws IOException {
            zzp(14);
            zzl(i, 5);
            zzn(i2);
        }

        public final void zzj(int i) throws IOException {
            zzp(4);
            zzn(i);
        }

        public final void zzf(int i, long j) throws IOException {
            zzp(18);
            zzl(i, 1);
            zzi(j);
        }

        public final void zzf(long j) throws IOException {
            zzp(8);
            zzi(j);
        }

        public final void zzh(int i, int i2) throws IOException {
            zzp(20);
            zzl(i, 0);
            if (i2 >= 0) {
                zzo(i2);
            } else {
                zzj((long) i2);
            }
        }

        public final void zzk(int i) throws IOException {
            if (i >= 0) {
                zzm(i);
            } else {
                zzh((long) i);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            zzc(bArr, i, i2);
        }

        public final void zzb(zzamm zzamm) throws IOException {
            zzm(zzamm.zzl());
            zzamm.zza(this);
        }

        public final void zzb(int i, zzamm zzamm) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzj(3, 2);
            zzb(zzamm);
            zzj(1, 4);
        }

        public final void zzd(int i, zzajv zzajv) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzc(3, zzajv);
            zzj(1, 4);
        }

        public final void zzb(int i, String str) throws IOException {
            zzj(i, 2);
            zzb(str);
        }

        public final void zzb(String str) throws IOException {
            int i;
            int i2;
            try {
                int length = str.length() * 3;
                int zzi = zzi(length);
                int i3 = zzi + length;
                if (i3 > this.zzc) {
                    byte[] bArr = new byte[length];
                    int zza = zzaoa.zza(str, bArr, 0, length);
                    zzm(zza);
                    zza(bArr, 0, zza);
                    return;
                }
                if (i3 > this.zzc - this.zzd) {
                    zze();
                }
                int zzi2 = zzi(str.length());
                i = this.zzd;
                if (zzi2 == zzi) {
                    this.zzd = i + zzi2;
                    int zza2 = zzaoa.zza(str, this.zzb, this.zzd, this.zzc - this.zzd);
                    this.zzd = i;
                    i2 = (zza2 - i) - zzi2;
                    zzo(i2);
                    this.zzd = zza2;
                } else {
                    i2 = zzaoa.zza(str);
                    zzo(i2);
                    this.zzd = zzaoa.zza(str, this.zzb, this.zzd, i2);
                }
                this.zze += i2;
            } catch (zzaod e) {
                this.zze -= this.zzd - i;
                this.zzd = i;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new zzd(e2);
            } catch (zzaod e3) {
                zza(str, e3);
            }
        }

        public final void zzj(int i, int i2) throws IOException {
            zzm((i << 3) | i2);
        }

        public final void zzk(int i, int i2) throws IOException {
            zzp(20);
            zzl(i, 0);
            zzo(i2);
        }

        public final void zzm(int i) throws IOException {
            zzp(5);
            zzo(i);
        }

        public final void zzh(int i, long j) throws IOException {
            zzp(20);
            zzl(i, 0);
            zzj(j);
        }

        public final void zzh(long j) throws IOException {
            zzp(10);
            zzj(j);
        }
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzi(length) + length;
    }

    public static int zza(int i, zzajv zzajv) {
        int zzi = zzi(i << 3);
        int zzb2 = zzajv.zzb();
        return zzi + zzi(zzb2) + zzb2;
    }

    public static int zza(zzajv zzajv) {
        int zzb2 = zzajv.zzb();
        return zzi(zzb2) + zzb2;
    }

    public static int zza(int i, double d) {
        return zzi(i << 3) + 8;
    }

    public static int zza(int i, int i2) {
        return zzi(i << 3) + zze((long) i2);
    }

    public static int zza(int i) {
        return zze((long) i);
    }

    public static int zzb(int i, int i2) {
        return zzi(i << 3) + 4;
    }

    public static int zza(int i, long j) {
        return zzi(i << 3) + 8;
    }

    public static int zza(int i, float f) {
        return zzi(i << 3) + 4;
    }

    public static int zzc(int i, int i2) {
        return zzi(i << 3) + zze((long) i2);
    }

    public static int zzc(int i) {
        return zze((long) i);
    }

    public static int zzb(int i, long j) {
        return zzi(i << 3) + zze(j);
    }

    public static int zzb(long j) {
        return zze(j);
    }

    public static int zza(int i, zzalu zzalu) {
        return (zzi(8) << 1) + zzf(2, i) + zzb(3, zzalu);
    }

    public static int zzb(int i, zzalu zzalu) {
        int zzi = zzi(i << 3);
        int zza2 = zzalu.zza();
        return zzi + zzi(zza2) + zza2;
    }

    public static int zza(zzalu zzalu) {
        int zza2 = zzalu.zza();
        return zzi(zza2) + zza2;
    }

    static int zzd(int i) {
        return zzi(i) + i;
    }

    public static int zza(int i, zzamm zzamm) {
        return (zzi(8) << 1) + zzf(2, i) + zzi(24) + zza(zzamm);
    }

    public static int zza(zzamm zzamm) {
        int zzl = zzamm.zzl();
        return zzi(zzl) + zzl;
    }

    public static int zzb(int i, zzajv zzajv) {
        return (zzi(8) << 1) + zzf(2, i) + zza(3, zzajv);
    }

    public static int zzd(int i, int i2) {
        return zzi(i << 3) + 4;
    }

    public static int zzc(int i, long j) {
        return zzi(i << 3) + 8;
    }

    public static int zze(int i, int i2) {
        return zzi(i << 3) + zzi(zzn(i2));
    }

    public static int zzg(int i) {
        return zzi(zzn(i));
    }

    public static int zzd(int i, long j) {
        return zzi(i << 3) + zze(zzi(j));
    }

    public static int zzd(long j) {
        return zze(zzi(j));
    }

    public static int zza(int i, String str) {
        return zzi(i << 3) + zza(str);
    }

    public static int zza(String str) {
        int i;
        try {
            i = zzaoa.zza(str);
        } catch (zzaod unused) {
            i = str.getBytes(zzalh.zza).length;
        }
        return zzi(i) + i;
    }

    public static int zzh(int i) {
        return zzi(i << 3);
    }

    public static int zzf(int i, int i2) {
        return zzi(i << 3) + zzi(i2);
    }

    public static int zzi(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zze(int i, long j) {
        return zzi(i << 3) + zze(j);
    }

    public static int zze(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static zzakn zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static zzakn zza(OutputStream outputStream, int i) {
        return new zzc(outputStream, i);
    }

    private zzakn() {
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzaod zzaod) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzaod);
        byte[] bytes = str.getBytes(zzalh.zza);
        try {
            zzm(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzd(e);
        }
    }

    public final void zzb(boolean z) throws IOException {
        zza(z ? (byte) 1 : 0);
    }

    public final void zzb(int i, double d) throws IOException {
        zzf(i, Double.doubleToRawLongBits(d));
    }

    public final void zzb(double d) throws IOException {
        zzf(Double.doubleToRawLongBits(d));
    }

    public final void zzb(int i, float f) throws IOException {
        zzg(i, Float.floatToRawIntBits(f));
    }

    public final void zzb(float f) throws IOException {
        zzj(Float.floatToRawIntBits(f));
    }

    public final void zzi(int i, int i2) throws IOException {
        zzk(i, zzn(i2));
    }

    public final void zzl(int i) throws IOException {
        zzm(zzn(i));
    }

    public final void zzg(int i, long j) throws IOException {
        zzh(i, zzi(j));
    }

    public final void zzg(long j) throws IOException {
        zzh(zzi(j));
    }
}
