package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzpm {
    private static final zzpm zza = new zzpm(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzpm() {
        this(0, new int[8], new Object[8], true);
    }

    private zzpm(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzpm zzc() {
        return zza;
    }

    static zzpm zze(zzpm zzpm, zzpm zzpm2) {
        int i = zzpm.zzb + zzpm2.zzb;
        int[] copyOf = Arrays.copyOf(zzpm.zzc, i);
        System.arraycopy(zzpm2.zzc, 0, copyOf, zzpm.zzb, zzpm2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzpm.zzd, i);
        System.arraycopy(zzpm2.zzd, 0, copyOf2, zzpm.zzb, zzpm2.zzb);
        return new zzpm(i, copyOf, copyOf2, true);
    }

    static zzpm zzf() {
        return new zzpm(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i) {
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

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzpm)) {
            return false;
        }
        zzpm zzpm = (zzpm) obj;
        int i = this.zzb;
        if (i == zzpm.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzpm.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzpm.zzd;
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

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i2 * 31) + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final int zza() {
        int i;
        int i2;
        int i3;
        int i4 = this.zze;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 == 1) {
                    ((Long) this.zzd[i6]).longValue();
                    i = zzln.zzA(i8 << 3) + 8;
                } else if (i9 == 2) {
                    int zzA = zzln.zzA(i8 << 3);
                    int zzd2 = ((zzle) this.zzd[i6]).zzd();
                    i = zzA + zzln.zzA(zzd2) + zzd2;
                } else if (i9 == 3) {
                    int zzA2 = zzln.zzA(i8 << 3);
                    i3 = zzA2 + zzA2;
                    i2 = ((zzpm) this.zzd[i6]).zza();
                } else if (i9 == 5) {
                    ((Integer) this.zzd[i6]).intValue();
                    i = zzln.zzA(i8 << 3) + 4;
                } else {
                    throw new IllegalStateException(new zznm("Protocol message tag had invalid wire type."));
                }
                i5 += i;
            } else {
                int i10 = i8 << 3;
                long longValue = ((Long) this.zzd[i6]).longValue();
                i3 = zzln.zzA(i10);
                i2 = zzln.zzB(longValue);
            }
            i = i3 + i2;
            i5 += i;
        }
        this.zze = i5;
        return i5;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int zzA = zzln.zzA(8);
            int zzA2 = zzln.zzA(16) + zzln.zzA(this.zzc[i3] >>> 3);
            int zzA3 = zzln.zzA(24);
            int zzd2 = ((zzle) this.zzd[i3]).zzd();
            i2 += zzA + zzA + zzA2 + zzA3 + zzln.zzA(zzd2) + zzd2;
        }
        this.zze = i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final zzpm zzd(zzpm zzpm) {
        if (zzpm.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzpm.zzb;
        zzm(i);
        System.arraycopy(zzpm.zzc, 0, this.zzc, this.zzb, zzpm.zzb);
        System.arraycopy(zzpm.zzd, 0, this.zzd, this.zzb, zzpm.zzb);
        this.zzb = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzok.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzj(int i, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    /* access modifiers changed from: package-private */
    public final void zzk(zzpy zzpy) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzpy.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzpy zzpy) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzpy.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzpy.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzpy.zzd(i4, (zzle) obj);
                } else if (i3 == 3) {
                    zzpy.zzF(i4);
                    ((zzpm) obj).zzl(zzpy);
                    zzpy.zzh(i4);
                } else if (i3 == 5) {
                    zzpy.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(new zznm("Protocol message tag had invalid wire type."));
                }
            }
        }
    }
}
