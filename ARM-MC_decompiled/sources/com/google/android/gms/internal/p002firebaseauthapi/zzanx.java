package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzanx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzanx {
    private static final zzanx zza = new zzanx(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    public final int zza() {
        int i;
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzakn.zze(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 1) {
                i = zzakn.zza(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 2) {
                i = zzakn.zza(i6, (zzajv) this.zzd[i4]);
            } else if (i7 == 3) {
                i = (zzakn.zzh(i6) << 1) + ((zzanx) this.zzd[i4]).zza();
            } else if (i7 == 5) {
                i = zzakn.zzb(i6, ((Integer) this.zzd[i4]).intValue());
            } else {
                throw new IllegalStateException(zzall.zza());
            }
            i3 += i;
        }
        this.zze = i3;
        return i3;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            i2 += zzakn.zzb(this.zzc[i3] >>> 3, (zzajv) this.zzd[i3]);
        }
        this.zze = i2;
        return i2;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public static zzanx zzc() {
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final zzanx zza(zzanx zzanx) {
        if (zzanx.equals(zza)) {
            return this;
        }
        zzf();
        int i = this.zzb + zzanx.zzb;
        zza(i);
        System.arraycopy(zzanx.zzc, 0, this.zzc, this.zzb, zzanx.zzb);
        System.arraycopy(zzanx.zzd, 0, this.zzd, this.zzb, zzanx.zzb);
        this.zzb = i;
        return this;
    }

    static zzanx zza(zzanx zzanx, zzanx zzanx2) {
        int i = zzanx.zzb + zzanx2.zzb;
        int[] copyOf = Arrays.copyOf(zzanx.zzc, i);
        System.arraycopy(zzanx2.zzc, 0, copyOf, zzanx.zzb, zzanx2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzanx.zzd, i);
        System.arraycopy(zzanx2.zzd, 0, copyOf2, zzanx.zzb, zzanx2.zzb);
        return new zzanx(i, copyOf, copyOf2, true);
    }

    static zzanx zzd() {
        return new zzanx();
    }

    private zzanx() {
        this(0, new int[8], new Object[8], true);
    }

    private zzanx(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    private final void zzf() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    private final void zza(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzamn.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzaol zzaol) throws IOException {
        if (zzaol.zza() == 2) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzaol.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzaol.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    private static void zza(int i, Object obj, zzaol zzaol) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzaol.zzb(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzaol.zza(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzaol.zza(i2, (zzajv) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzaol.zzb(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzall.zza());
        } else if (zzaol.zza() == 1) {
            zzaol.zzb(i2);
            ((zzanx) obj).zzb(zzaol);
            zzaol.zza(i2);
        } else {
            zzaol.zza(i2);
            ((zzanx) obj).zzb(zzaol);
            zzaol.zzb(i2);
        }
    }

    public final void zzb(zzaol zzaol) throws IOException {
        if (this.zzb != 0) {
            if (zzaol.zza() == 1) {
                for (int i = 0; i < this.zzb; i++) {
                    zza(this.zzc[i], this.zzd[i], zzaol);
                }
                return;
            }
            for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
                zza(this.zzc[i2], this.zzd[i2], zzaol);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzanx)) {
            return false;
        }
        zzanx zzanx = (zzanx) obj;
        int i = this.zzb;
        if (i == zzanx.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzanx.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzanx.zzd;
                    int i3 = this.zzb;
                    int i4 = 0;
                    while (i4 < i3) {
                        if (objArr[i4].equals(objArr2[i4])) {
                            i4++;
                        }
                    }
                    return true;
                } else if (iArr[i2] != iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }
}
