package com.google.android.gms.internal.auth;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
final class zzga<T> implements zzgi<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhj.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfx zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzfl zzk;
    private final zzgz zzl;
    private final zzem zzm;
    private final zzgc zzn;
    private final zzfs zzo;

    private zzga(int[] iArr, Object[] objArr, int i, int i2, zzfx zzfx, int i3, boolean z, int[] iArr2, int i4, int i5, zzgc zzgc, zzfl zzfl, zzgz zzgz, zzem zzem, zzfs zzfs) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzh = iArr2;
        this.zzi = i4;
        this.zzj = i5;
        this.zzn = zzgc;
        this.zzk = zzfl;
        this.zzl = zzgz;
        this.zzm = zzem;
        this.zzg = zzfx;
        this.zzo = zzfs;
    }

    private final void zzA(Object obj, int i, int i2) {
        zzhj.zzn(obj, (long) (zzl(i2) & 1048575), i);
    }

    private final void zzB(Object obj, int i, Object obj2) {
        zzb.putObject(obj, (long) (zzo(i) & 1048575), obj2);
        zzz(obj, i);
    }

    private final void zzC(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, (long) (zzo(i2) & 1048575), obj2);
        zzA(obj, i, i2);
    }

    private final boolean zzD(Object obj, Object obj2, int i) {
        return zzE(obj, i) == zzE(obj2, i);
    }

    private final boolean zzE(Object obj, int i) {
        int zzl2 = zzl(i);
        long j = (long) (zzl2 & 1048575);
        if (j == 1048575) {
            int zzo2 = zzo(i);
            long j2 = (long) (zzo2 & 1048575);
            switch (zzn(zzo2)) {
                case 0:
                    return Double.doubleToRawLongBits(zzhj.zza(obj, j2)) != 0;
                case 1:
                    return Float.floatToRawIntBits(zzhj.zzb(obj, j2)) != 0;
                case 2:
                    return zzhj.zzd(obj, j2) != 0;
                case 3:
                    return zzhj.zzd(obj, j2) != 0;
                case 4:
                    return zzhj.zzc(obj, j2) != 0;
                case 5:
                    return zzhj.zzd(obj, j2) != 0;
                case 6:
                    return zzhj.zzc(obj, j2) != 0;
                case 7:
                    return zzhj.zzt(obj, j2);
                case 8:
                    Object zzf2 = zzhj.zzf(obj, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzef) {
                        return !zzef.zzb.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzhj.zzf(obj, j2) != null;
                case 10:
                    return !zzef.zzb.equals(zzhj.zzf(obj, j2));
                case 11:
                    return zzhj.zzc(obj, j2) != 0;
                case 12:
                    return zzhj.zzc(obj, j2) != 0;
                case 13:
                    return zzhj.zzc(obj, j2) != 0;
                case 14:
                    return zzhj.zzd(obj, j2) != 0;
                case 15:
                    return zzhj.zzc(obj, j2) != 0;
                case 16:
                    return zzhj.zzd(obj, j2) != 0;
                case 17:
                    return zzhj.zzf(obj, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzhj.zzc(obj, j) & (1 << (zzl2 >>> 20))) != 0;
        }
    }

    private final boolean zzF(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzE(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzG(Object obj, int i, zzgi zzgi) {
        return zzgi.zzi(zzhj.zzf(obj, (long) (i & 1048575)));
    }

    private static boolean zzH(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzev) {
            return ((zzev) obj).zzm();
        }
        return true;
    }

    private final boolean zzI(Object obj, int i, int i2) {
        return zzhj.zzc(obj, (long) (zzl(i2) & 1048575)) == i;
    }

    static zzha zzc(Object obj) {
        zzev zzev = (zzev) obj;
        zzha zzha = zzev.zzc;
        if (zzha != zzha.zza()) {
            return zzha;
        }
        zzha zzd2 = zzha.zzd();
        zzev.zzc = zzd2;
        return zzd2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0271  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.auth.zzga zzj(java.lang.Class r31, com.google.android.gms.internal.auth.zzfu r32, com.google.android.gms.internal.auth.zzgc r33, com.google.android.gms.internal.auth.zzfl r34, com.google.android.gms.internal.auth.zzgz r35, com.google.android.gms.internal.auth.zzem r36, com.google.android.gms.internal.auth.zzfs r37) {
        /*
            r0 = r32
            boolean r1 = r0 instanceof com.google.android.gms.internal.auth.zzgh
            if (r1 == 0) goto L_0x03df
            com.google.android.gms.internal.auth.zzgh r0 = (com.google.android.gms.internal.auth.zzgh) r0
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            r3 = 0
            char r4 = r1.charAt(r3)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0025
            r4 = 1
        L_0x001b:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0026
            r4 = r7
            goto L_0x001b
        L_0x0025:
            r7 = 1
        L_0x0026:
            int r4 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0045
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0032:
            int r10 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0042
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r9
            r7 = r7 | r4
            int r9 = r9 + 13
            r4 = r10
            goto L_0x0032
        L_0x0042:
            int r4 = r4 << r9
            r7 = r7 | r4
            r4 = r10
        L_0x0045:
            if (r7 != 0) goto L_0x0057
            int[] r7 = zza
            r9 = r3
            r11 = r9
            r12 = r11
            r13 = r12
            r16 = r13
            r18 = r16
            r17 = r7
            r7 = r18
            goto L_0x0169
        L_0x0057:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0076
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0063:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0073
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r4 = r4 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x0063
        L_0x0073:
            int r7 = r7 << r9
            r4 = r4 | r7
            r7 = r10
        L_0x0076:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0095
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0082:
            int r11 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x0092
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r11
            goto L_0x0082
        L_0x0092:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r11
        L_0x0095:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x00b4
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a1:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00b1
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r9 = r9 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x00a1
        L_0x00b1:
            int r10 = r10 << r11
            r9 = r9 | r10
            r10 = r12
        L_0x00b4:
            int r11 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00d3
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c0:
            int r13 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00d0
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c0
        L_0x00d0:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00d3:
            int r12 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00f2
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00df:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x00ef
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00df
        L_0x00ef:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f2:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x0111
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fe:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x010e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fe
        L_0x010e:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0111:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x0132
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011d:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x012e
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011d
        L_0x012e:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0132:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x0155
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013e:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r5) goto L_0x0150
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013e
        L_0x0150:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0155:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int r16 = r4 + r4
            int r16 = r16 + r7
            int[] r7 = new int[r13]
            r13 = r12
            r12 = r9
            r9 = r13
            r17 = r7
            r13 = r10
            r18 = r14
            r7 = r4
            r4 = r15
        L_0x0169:
            sun.misc.Unsafe r10 = zzb
            java.lang.Object[] r14 = r0.zze()
            com.google.android.gms.internal.auth.zzfx r15 = r0.zza()
            java.lang.Class r15 = r15.getClass()
            int r19 = r18 + r9
            int r9 = r11 + r11
            int r11 = r11 * 3
            int[] r11 = new int[r11]
            java.lang.Object[] r9 = new java.lang.Object[r9]
            r20 = r3
            r21 = r20
            r22 = r18
            r23 = r19
        L_0x0189:
            if (r4 >= r2) goto L_0x03c0
            int r24 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x01b1
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0199:
            int r25 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r5) goto L_0x01ab
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r25
            goto L_0x0199
        L_0x01ab:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r25
            goto L_0x01b3
        L_0x01b1:
            r3 = r24
        L_0x01b3:
            int r24 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r5) goto L_0x01d9
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r8 = r24
            r24 = 13
        L_0x01c1:
            int r25 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01d3
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r24
            r3 = r3 | r8
            int r24 = r24 + 13
            r8 = r25
            goto L_0x01c1
        L_0x01d3:
            int r8 = r8 << r24
            r3 = r3 | r8
            r8 = r25
            goto L_0x01db
        L_0x01d9:
            r8 = r24
        L_0x01db:
            r6 = r3 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x01e5
            int r6 = r20 + 1
            r17[r20] = r21
            r20 = r6
        L_0x01e5:
            r6 = r3 & 255(0xff, float:3.57E-43)
            r5 = 51
            if (r6 < r5) goto L_0x0285
            int r5 = r8 + 1
            char r8 = r1.charAt(r8)
            r26 = r0
            r0 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r0) goto L_0x0216
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r29 = 13
        L_0x01fc:
            int r30 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r0) goto L_0x0211
            r0 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r0 = r0 << r29
            r8 = r8 | r0
            int r29 = r29 + 13
            r5 = r30
            r0 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01fc
        L_0x0211:
            int r0 = r5 << r29
            r8 = r8 | r0
            r5 = r30
        L_0x0216:
            int r0 = r6 + -51
            r29 = r2
            r2 = 9
            if (r0 == r2) goto L_0x023d
            r2 = 17
            if (r0 != r2) goto L_0x0223
            goto L_0x023d
        L_0x0223:
            r2 = 12
            if (r0 != r2) goto L_0x024c
            int r0 = r26.zzc()
            r2 = 1
            if (r0 == r2) goto L_0x0232
            r0 = r3 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x024c
        L_0x0232:
            int r0 = r21 / 3
            int r0 = r0 + r0
            int r0 = r0 + r2
            int r2 = r16 + 1
            r16 = r14[r16]
            r9[r0] = r16
            goto L_0x024a
        L_0x023d:
            int r0 = r21 / 3
            int r0 = r0 + r0
            r24 = 1
            int r0 = r0 + 1
            int r2 = r16 + 1
            r16 = r14[r16]
            r9[r0] = r16
        L_0x024a:
            r16 = r2
        L_0x024c:
            int r8 = r8 + r8
            r0 = r14[r8]
            boolean r2 = r0 instanceof java.lang.reflect.Field
            if (r2 == 0) goto L_0x0256
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0
            goto L_0x025e
        L_0x0256:
            java.lang.String r0 = (java.lang.String) r0
            java.lang.reflect.Field r0 = zzv(r15, r0)
            r14[r8] = r0
        L_0x025e:
            r2 = r4
            r27 = r5
            long r4 = r10.objectFieldOffset(r0)
            int r0 = (int) r4
            int r8 = r8 + 1
            r4 = r14[r8]
            boolean r5 = r4 instanceof java.lang.reflect.Field
            if (r5 == 0) goto L_0x0271
            java.lang.reflect.Field r4 = (java.lang.reflect.Field) r4
            goto L_0x0279
        L_0x0271:
            java.lang.String r4 = (java.lang.String) r4
            java.lang.reflect.Field r4 = zzv(r15, r4)
            r14[r8] = r4
        L_0x0279:
            long r4 = r10.objectFieldOffset(r4)
            int r4 = (int) r4
            r28 = r1
            r25 = r27
            r8 = 0
            goto L_0x0382
        L_0x0285:
            r26 = r0
            r29 = r2
            r2 = r4
            int r0 = r16 + 1
            r4 = r14[r16]
            java.lang.String r4 = (java.lang.String) r4
            java.lang.reflect.Field r4 = zzv(r15, r4)
            r5 = 9
            if (r6 == r5) goto L_0x0303
            r5 = 17
            if (r6 != r5) goto L_0x029e
            goto L_0x0303
        L_0x029e:
            r5 = 27
            if (r6 == r5) goto L_0x02f3
            r5 = 49
            if (r6 != r5) goto L_0x02a7
            goto L_0x02f3
        L_0x02a7:
            r5 = 12
            if (r6 == r5) goto L_0x02db
            r5 = 30
            if (r6 == r5) goto L_0x02db
            r5 = 44
            if (r6 != r5) goto L_0x02b4
            goto L_0x02db
        L_0x02b4:
            r5 = 50
            if (r6 != r5) goto L_0x02d8
            int r5 = r22 + 1
            r17[r22] = r21
            int r22 = r21 / 3
            int r27 = r16 + 2
            r0 = r14[r0]
            int r22 = r22 + r22
            r9[r22] = r0
            r0 = r3 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x02d4
            int r22 = r22 + 1
            int r0 = r16 + 3
            r16 = r14[r27]
            r9[r22] = r16
            r27 = r0
        L_0x02d4:
            r22 = r5
        L_0x02d6:
            r0 = 1
            goto L_0x0310
        L_0x02d8:
            r27 = r0
            goto L_0x02d6
        L_0x02db:
            int r5 = r26.zzc()
            r27 = r0
            r0 = 1
            if (r5 == r0) goto L_0x02e8
            r5 = r3 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0310
        L_0x02e8:
            int r5 = r21 / 3
            int r5 = r5 + r5
            int r5 = r5 + r0
            int r16 = r16 + 2
            r24 = r14[r27]
            r9[r5] = r24
            goto L_0x0300
        L_0x02f3:
            r27 = r0
            r0 = 1
            int r5 = r21 / 3
            int r5 = r5 + r5
            int r5 = r5 + r0
            int r16 = r16 + 2
            r24 = r14[r27]
            r9[r5] = r24
        L_0x0300:
            r27 = r16
            goto L_0x0310
        L_0x0303:
            r27 = r0
            r0 = 1
            int r5 = r21 / 3
            int r5 = r5 + r5
            int r5 = r5 + r0
            java.lang.Class r16 = r4.getType()
            r9[r5] = r16
        L_0x0310:
            long r4 = r10.objectFieldOffset(r4)
            int r4 = (int) r4
            r5 = r3 & 4096(0x1000, float:5.74E-42)
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r5 == 0) goto L_0x036a
            r5 = 17
            if (r6 > r5) goto L_0x036a
            int r5 = r8 + 1
            char r8 = r1.charAt(r8)
            r0 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r0) goto L_0x0345
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x032f:
            int r25 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r0) goto L_0x0341
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r16
            r8 = r8 | r5
            int r16 = r16 + 13
            r5 = r25
            goto L_0x032f
        L_0x0341:
            int r5 = r5 << r16
            r8 = r8 | r5
            goto L_0x0347
        L_0x0345:
            r25 = r5
        L_0x0347:
            int r5 = r7 + r7
            int r16 = r8 / 32
            int r5 = r5 + r16
            r0 = r14[r5]
            r28 = r1
            boolean r1 = r0 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L_0x0358
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0
            goto L_0x0360
        L_0x0358:
            java.lang.String r0 = (java.lang.String) r0
            java.lang.reflect.Field r0 = zzv(r15, r0)
            r14[r5] = r0
        L_0x0360:
            long r0 = r10.objectFieldOffset(r0)
            int r0 = (int) r0
            int r8 = r8 % 32
            r16 = r0
            goto L_0x036f
        L_0x036a:
            r28 = r1
            r25 = r8
            r8 = 0
        L_0x036f:
            r0 = 18
            if (r6 < r0) goto L_0x037d
            r5 = 49
            if (r6 > r5) goto L_0x037d
            int r0 = r23 + 1
            r17[r23] = r4
            r23 = r0
        L_0x037d:
            r0 = r4
            r4 = r16
            r16 = r27
        L_0x0382:
            int r1 = r21 + 1
            r11[r21] = r2
            int r2 = r21 + 2
            r5 = r3 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x038f
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0390
        L_0x038f:
            r5 = 0
        L_0x0390:
            r27 = r0
            r0 = r3 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0399
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x039a
        L_0x0399:
            r0 = 0
        L_0x039a:
            r3 = r3 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x03a1
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x03a2
        L_0x03a1:
            r3 = 0
        L_0x03a2:
            int r6 = r6 << 20
            r0 = r0 | r5
            r0 = r0 | r3
            r0 = r0 | r6
            r0 = r0 | r27
            r11[r1] = r0
            int r21 = r21 + 3
            int r0 = r8 << 20
            r0 = r0 | r4
            r11[r2] = r0
            r4 = r25
            r0 = r26
            r1 = r28
            r2 = r29
            r3 = 0
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0189
        L_0x03c0:
            r26 = r0
            com.google.android.gms.internal.auth.zzga r0 = new com.google.android.gms.internal.auth.zzga
            com.google.android.gms.internal.auth.zzfx r14 = r26.zza()
            int r15 = r26.zzc()
            r16 = 0
            r20 = r33
            r21 = r34
            r22 = r35
            r23 = r36
            r24 = r37
            r10 = r11
            r11 = r9
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r9
        L_0x03df:
            com.google.android.gms.internal.auth.zzgw r0 = (com.google.android.gms.internal.auth.zzgw) r0
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zzj(java.lang.Class, com.google.android.gms.internal.auth.zzfu, com.google.android.gms.internal.auth.zzgc, com.google.android.gms.internal.auth.zzfl, com.google.android.gms.internal.auth.zzgz, com.google.android.gms.internal.auth.zzem, com.google.android.gms.internal.auth.zzfs):com.google.android.gms.internal.auth.zzga");
    }

    private static int zzk(Object obj, long j) {
        return ((Integer) zzhj.zzf(obj, j)).intValue();
    }

    private final int zzl(int i) {
        return this.zzc[i + 2];
    }

    private final int zzm(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzn(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzo(int i) {
        return this.zzc[i + 1];
    }

    private static long zzp(Object obj, long j) {
        return ((Long) zzhj.zzf(obj, j)).longValue();
    }

    private final zzey zzq(int i) {
        int i2 = i / 3;
        return (zzey) this.zzd[i2 + i2 + 1];
    }

    private final zzgi zzr(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgi zzgi = (zzgi) this.zzd[i3];
        if (zzgi != null) {
            return zzgi;
        }
        zzgi zzb2 = zzgf.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzs(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzt(Object obj, int i) {
        zzgi zzr = zzr(i);
        int zzo2 = zzo(i) & 1048575;
        if (!zzE(obj, i)) {
            return zzr.zzd();
        }
        Object object = zzb.getObject(obj, (long) zzo2);
        if (zzH(object)) {
            return object;
        }
        Object zzd2 = zzr.zzd();
        if (object != null) {
            zzr.zzf(zzd2, object);
        }
        return zzd2;
    }

    private final Object zzu(Object obj, int i, int i2) {
        zzgi zzr = zzr(i2);
        if (!zzI(obj, i, i2)) {
            return zzr.zzd();
        }
        Object object = zzb.getObject(obj, (long) (zzo(i2) & 1048575));
        if (zzH(object)) {
            return object;
        }
        Object zzd2 = zzr.zzd();
        if (object != null) {
            zzr.zzf(zzd2, object);
        }
        return zzd2;
    }

    private static Field zzv(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzw(Object obj) {
        if (!zzH(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzx(Object obj, Object obj2, int i) {
        if (zzE(obj2, i)) {
            Unsafe unsafe = zzb;
            long zzo2 = (long) (zzo(i) & 1048575);
            Object object = unsafe.getObject(obj2, zzo2);
            if (object != null) {
                zzgi zzr = zzr(i);
                if (!zzE(obj, i)) {
                    if (!zzH(object)) {
                        unsafe.putObject(obj, zzo2, object);
                    } else {
                        Object zzd2 = zzr.zzd();
                        zzr.zzf(zzd2, object);
                        unsafe.putObject(obj, zzo2, zzd2);
                    }
                    zzz(obj, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzo2);
                if (!zzH(object2)) {
                    Object zzd3 = zzr.zzd();
                    zzr.zzf(zzd3, object2);
                    unsafe.putObject(obj, zzo2, zzd3);
                    object2 = zzd3;
                }
                zzr.zzf(object2, object);
                return;
            }
            int i2 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i2 + " is present but null: " + obj3);
        }
    }

    private final void zzy(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzI(obj2, i2, i)) {
            Unsafe unsafe = zzb;
            long zzo2 = (long) (zzo(i) & 1048575);
            Object object = unsafe.getObject(obj2, zzo2);
            if (object != null) {
                zzgi zzr = zzr(i);
                if (!zzI(obj, i2, i)) {
                    if (!zzH(object)) {
                        unsafe.putObject(obj, zzo2, object);
                    } else {
                        Object zzd2 = zzr.zzd();
                        zzr.zzf(zzd2, object);
                        unsafe.putObject(obj, zzo2, zzd2);
                    }
                    zzA(obj, i2, i);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzo2);
                if (!zzH(object2)) {
                    Object zzd3 = zzr.zzd();
                    zzr.zzf(zzd3, object2);
                    unsafe.putObject(obj, zzo2, zzd3);
                    object2 = zzd3;
                }
                zzr.zzf(object2, object);
                return;
            }
            int i3 = this.zzc[i];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i3 + " is present but null: " + obj3);
        }
    }

    private final void zzz(Object obj, int i) {
        int zzl2 = zzl(i);
        long j = (long) (1048575 & zzl2);
        if (j != 1048575) {
            zzhj.zzn(obj, j, (1 << (zzl2 >>> 20)) | zzhj.zzc(obj, j));
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c6, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0222, code lost:
        r3 = (int) (r3 ^ (r3 >>> 32));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0226, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0227, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r10) {
        /*
            r9 = this;
            int[] r0 = r9.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022b
            int r3 = r9.zzo(r1)
            int[] r4 = r9.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            int r3 = zzn(r3)
            long r5 = (long) r5
            r7 = 37
            r8 = 32
            switch(r3) {
                case 0: goto L_0x0216;
                case 1: goto L_0x020b;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f9;
                case 4: goto L_0x01f2;
                case 5: goto L_0x01e9;
                case 6: goto L_0x01e2;
                case 7: goto L_0x01d7;
                case 8: goto L_0x01ca;
                case 9: goto L_0x01bc;
                case 10: goto L_0x01b0;
                case 11: goto L_0x01a8;
                case 12: goto L_0x01a0;
                case 13: goto L_0x0198;
                case 14: goto L_0x018e;
                case 15: goto L_0x0186;
                case 16: goto L_0x017c;
                case 17: goto L_0x0171;
                case 18: goto L_0x0165;
                case 19: goto L_0x0165;
                case 20: goto L_0x0165;
                case 21: goto L_0x0165;
                case 22: goto L_0x0165;
                case 23: goto L_0x0165;
                case 24: goto L_0x0165;
                case 25: goto L_0x0165;
                case 26: goto L_0x0165;
                case 27: goto L_0x0165;
                case 28: goto L_0x0165;
                case 29: goto L_0x0165;
                case 30: goto L_0x0165;
                case 31: goto L_0x0165;
                case 32: goto L_0x0165;
                case 33: goto L_0x0165;
                case 34: goto L_0x0165;
                case 35: goto L_0x0165;
                case 36: goto L_0x0165;
                case 37: goto L_0x0165;
                case 38: goto L_0x0165;
                case 39: goto L_0x0165;
                case 40: goto L_0x0165;
                case 41: goto L_0x0165;
                case 42: goto L_0x0165;
                case 43: goto L_0x0165;
                case 44: goto L_0x0165;
                case 45: goto L_0x0165;
                case 46: goto L_0x0165;
                case 47: goto L_0x0165;
                case 48: goto L_0x0165;
                case 49: goto L_0x0165;
                case 50: goto L_0x0159;
                case 51: goto L_0x013f;
                case 52: goto L_0x0127;
                case 53: goto L_0x0117;
                case 54: goto L_0x0107;
                case 55: goto L_0x00f9;
                case 56: goto L_0x00e9;
                case 57: goto L_0x00db;
                case 58: goto L_0x00c3;
                case 59: goto L_0x00af;
                case 60: goto L_0x009d;
                case 61: goto L_0x008b;
                case 62: goto L_0x007d;
                case 63: goto L_0x006f;
                case 64: goto L_0x0061;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0033;
                case 68: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0227
        L_0x0021:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0033:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzp(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0222
        L_0x0043:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzk(r10, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzp(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0222
        L_0x0061:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzk(r10, r5)
            goto L_0x0226
        L_0x006f:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzk(r10, r5)
            goto L_0x0226
        L_0x007d:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzk(r10, r5)
            goto L_0x0226
        L_0x008b:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009d:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00af:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c3:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            int r3 = com.google.android.gms.internal.auth.zzfa.zza(r3)
            goto L_0x0226
        L_0x00db:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzk(r10, r5)
            goto L_0x0226
        L_0x00e9:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzp(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0222
        L_0x00f9:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzk(r10, r5)
            goto L_0x0226
        L_0x0107:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzp(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0222
        L_0x0117:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzp(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0222
        L_0x0127:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013f:
            boolean r3 = r9.zzI(r10, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            java.lang.Double r3 = (java.lang.Double) r3
            double r3 = r3.doubleValue()
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0222
        L_0x0159:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0165:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0171:
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            if (r3 == 0) goto L_0x01c6
            int r7 = r3.hashCode()
            goto L_0x01c6
        L_0x017c:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhj.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0222
        L_0x0186:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhj.zzc(r10, r5)
            goto L_0x0226
        L_0x018e:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhj.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0222
        L_0x0198:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhj.zzc(r10, r5)
            goto L_0x0226
        L_0x01a0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhj.zzc(r10, r5)
            goto L_0x0226
        L_0x01a8:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhj.zzc(r10, r5)
            goto L_0x0226
        L_0x01b0:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01bc:
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            if (r3 == 0) goto L_0x01c6
            int r7 = r3.hashCode()
        L_0x01c6:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0227
        L_0x01ca:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d7:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.auth.zzhj.zzt(r10, r5)
            int r3 = com.google.android.gms.internal.auth.zzfa.zza(r3)
            goto L_0x0226
        L_0x01e2:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhj.zzc(r10, r5)
            goto L_0x0226
        L_0x01e9:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhj.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0222
        L_0x01f2:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhj.zzc(r10, r5)
            goto L_0x0226
        L_0x01f9:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhj.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0222
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhj.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
            goto L_0x0222
        L_0x020b:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.auth.zzhj.zzb(r10, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0216:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.auth.zzhj.zza(r10, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.gms.internal.auth.zzfa.zzd
        L_0x0222:
            long r5 = r3 >>> r8
            long r3 = r3 ^ r5
            int r3 = (int) r3
        L_0x0226:
            int r2 = r2 + r3
        L_0x0227:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022b:
            int r2 = r2 * 53
            com.google.android.gms.internal.auth.zzgz r0 = r9.zzl
            java.lang.Object r10 = r0.zzb(r10)
            int r10 = r10.hashCode()
            int r2 = r2 + r10
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zza(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v50, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v46, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v47, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v48, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v49, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v50, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v51, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v46, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v48, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v67, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v69, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v50, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v72, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v73, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v74, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v58, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v52, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v59, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v53, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v81, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v82, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v83, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v85, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v86, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v87, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v88, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v72, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v89, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v90, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v60, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v92, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v63, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v60, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v64, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v100, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v69, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v61, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v70, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v71, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v62, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v32, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v73, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v67, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v74, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v68, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v75, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v81, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v82, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v83, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v86, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v88, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v73, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v77, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v58, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v56, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v57, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v58, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v65, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v97, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v60, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v67, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v70, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v58, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v75, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v61, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v62, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v78, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v82, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v138, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v83, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v139, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v85, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v142, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v143, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v144, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v145, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v146, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v147, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v148, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v154, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v156, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v91, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v116, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v78, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v84, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v88, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v46, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v89, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v121, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v82, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v91, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v92, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v100, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v87, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v101, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v88, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v102, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v106, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v89, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v109, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v144, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v84, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v111, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v112, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0389, code lost:
        r15 = r19 | r12;
        r4 = r7;
        r7 = r1;
        r1 = r10;
        r10 = r3;
        r3 = r2;
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0392, code lost:
        r3 = r2;
        r14 = r7;
        r15 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x03bd, code lost:
        r14 = r37;
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x03e5, code lost:
        r11 = r8;
        r5 = r9;
        r4 = r13;
        r6 = r20;
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0417, code lost:
        r15 = r1;
        r14 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x045d, code lost:
        r2 = r15;
        r15 = r19 | r12;
        r1 = r2;
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0462, code lost:
        r11 = r8;
        r5 = r9;
        r4 = r13;
        r2 = r14;
        r6 = r20;
        r14 = r37;
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x046e, code lost:
        r3 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x046f, code lost:
        r6 = r36;
        r26 = r37;
        r7 = r39;
        r10 = r14;
        r29 = r15;
        r15 = r19;
        r1 = r20;
        r14 = r40;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x05da, code lost:
        r8 = r3;
        r9 = r30;
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x05e0, code lost:
        r8 = r3;
        r9 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x07c2, code lost:
        r8 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x07c3, code lost:
        r14 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x08c1, code lost:
        r8 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:386:0x08c2, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:0x08c3, code lost:
        r14 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0104, code lost:
        r11 = 0;
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:439:0x09ea, code lost:
        r3 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:440:0x09eb, code lost:
        if (r3 == r14) goto L_0x09fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:441:0x09ed, code lost:
        r7 = r36;
        r5 = r9;
        r2 = r10;
        r4 = r13;
        r14 = r26;
        r15 = r27;
        r1 = r29;
        r11 = 0;
        r10 = r6;
        r6 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:442:0x09fd, code lost:
        r7 = r39;
        r14 = r6;
        r1 = r8;
        r15 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:456:0x0a4b, code lost:
        r20 = r8;
        r19 = r9;
        r9 = r14;
        r14 = r6;
        r6 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:467:0x0abd, code lost:
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:479:0x0b0c, code lost:
        r3 = r5;
        r19 = r9;
        r20 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:480:0x0b11, code lost:
        r9 = r14;
        r14 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:482:0x0b19, code lost:
        r9 = r14;
        r14 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:507:0x0baa, code lost:
        r20 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:520:0x0c1d, code lost:
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:527:0x0c5e, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:528:0x0c60, code lost:
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:529:0x0c61, code lost:
        if (r3 == r9) goto L_0x0c75;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:530:0x0c63, code lost:
        r8 = r38;
        r7 = r6;
        r2 = r10;
        r4 = r13;
        r10 = r14;
        r5 = r19;
        r6 = r20;
        r14 = r26;
        r15 = r27;
        r1 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:531:0x0c75, code lost:
        r7 = r39;
        r9 = r19;
        r1 = r20;
        r15 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01a9, code lost:
        r15 = r8 | r12;
        r5 = r2;
        r2 = r1;
        r1 = r5;
        r14 = r37;
        r8 = r38;
        r6 = r4;
        r5 = r9;
        r4 = r13;
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01b7, code lost:
        r14 = r1;
        r15 = r2;
        r20 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01bb, code lost:
        r19 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01fa, code lost:
        r14 = r37;
        r8 = r38;
        r5 = r9;
        r4 = r13;
        r6 = r20;
        r7 = r7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x06af  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0737  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0785  */
    /* JADX WARNING: Removed duplicated region for block: B:533:0x0c7f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:615:0x08c1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:617:0x08c1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:621:0x08c1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0267  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.auth.zzdt r40) throws java.io.IOException {
        /*
            r34 = this;
            r0 = r34
            r2 = r35
            r7 = r36
            r8 = r38
            r10 = r40
            zzw(r2)
            sun.misc.Unsafe r1 = zzb
            r11 = 0
            r3 = r37
            r5 = r11
            r6 = r5
            r15 = r6
            r4 = -1
            r14 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            r16 = 0
            if (r3 >= r8) goto L_0x0ca4
            int r6 = r3 + 1
            byte r3 = r7[r3]
            if (r3 >= 0) goto L_0x0029
            int r6 = com.google.android.gms.internal.auth.zzdu.zzi(r3, r7, r6, r10)
            int r3 = r10.zza
        L_0x0029:
            r33 = r6
            r6 = r3
            r3 = r33
            r17 = 1048575(0xfffff, float:1.469367E-39)
            int r13 = r6 >>> 3
            r12 = 3
            if (r13 <= r4) goto L_0x0044
            int r5 = r5 / r12
            int r4 = r0.zze
            if (r13 < r4) goto L_0x0051
            int r4 = r0.zzf
            if (r13 > r4) goto L_0x0051
            int r4 = r0.zzm(r13, r5)
            goto L_0x0052
        L_0x0044:
            int r4 = r0.zze
            if (r13 < r4) goto L_0x0051
            int r4 = r0.zzf
            if (r13 > r4) goto L_0x0051
            int r4 = r0.zzm(r13, r11)
            goto L_0x0052
        L_0x0051:
            r4 = -1
        L_0x0052:
            r5 = -1
            if (r4 != r5) goto L_0x0064
            r29 = r1
            r18 = r5
            r1 = r6
            r6 = r7
            r9 = r11
            r26 = r14
            r7 = r39
            r14 = r10
            r10 = r2
            goto L_0x0c7d
        L_0x0064:
            r5 = r6 & 7
            int[] r12 = r0.zzc
            int r19 = r4 + 1
            r11 = r12[r19]
            r19 = r4
            int r4 = zzn(r11)
            r20 = r6
            r6 = r11 & r17
            long r8 = (long) r6
            r21 = 536870912(0x20000000, float:1.0842022E-19)
            r22 = 0
            java.lang.String r6 = ""
            r26 = r8
            r8 = 17
            r28 = 1
            if (r4 > r8) goto L_0x0480
            int r8 = r19 + 2
            r8 = r12[r8]
            int r12 = r8 >>> 20
            int r12 = r28 << r12
            r8 = r8 & r17
            if (r8 == r14) goto L_0x00a7
            r9 = r17
            if (r14 == r9) goto L_0x009c
            long r9 = (long) r14
            r1.putInt(r2, r9, r15)
            r9 = 1048575(0xfffff, float:1.469367E-39)
        L_0x009c:
            if (r8 != r9) goto L_0x00a0
            r15 = 0
            goto L_0x00a6
        L_0x00a0:
            long r9 = (long) r8
            int r9 = r1.getInt(r2, r9)
            r15 = r9
        L_0x00a6:
            r14 = r8
        L_0x00a7:
            switch(r4) {
                case 0: goto L_0x043c;
                case 1: goto L_0x041b;
                case 2: goto L_0x03ec;
                case 3: goto L_0x03ec;
                case 4: goto L_0x03c7;
                case 5: goto L_0x0397;
                case 6: goto L_0x036c;
                case 7: goto L_0x0347;
                case 8: goto L_0x021a;
                case 9: goto L_0x01bf;
                case 10: goto L_0x018b;
                case 11: goto L_0x03c7;
                case 12: goto L_0x0143;
                case 13: goto L_0x036c;
                case 14: goto L_0x0397;
                case 15: goto L_0x0119;
                case 16: goto L_0x00df;
                default: goto L_0x00aa;
            }
        L_0x00aa:
            r10 = r40
            r11 = r3
            r37 = r14
            r9 = r19
            r8 = 0
            r18 = -1
            r14 = r2
            r19 = r15
            r15 = r1
            r1 = 3
            if (r5 != r1) goto L_0x046e
            java.lang.Object r1 = r0.zzt(r14, r9)
            int r2 = r13 << 3
            r6 = r2 | 4
            com.google.android.gms.internal.auth.zzgi r2 = r0.zzr(r9)
            r5 = r38
            r3 = r7
            r7 = r10
            r4 = r11
            int r2 = com.google.android.gms.internal.auth.zzdu.zzl(r1, r2, r3, r4, r5, r6, r7)
            r0.zzB(r14, r9, r1)
            r1 = r19 | r12
            r3 = r15
            r15 = r1
            r1 = r3
            r7 = r36
            r10 = r40
            r3 = r2
            goto L_0x0462
        L_0x00df:
            if (r5 != 0) goto L_0x0107
            r10 = r40
            int r8 = com.google.android.gms.internal.auth.zzdu.zzk(r7, r3, r10)
            long r3 = r10.zzb
            long r5 = com.google.android.gms.internal.auth.zzej.zzc(r3)
            r9 = r19
            r3 = r26
            r18 = -1
            r1.putLong(r2, r3, r5)
            r33 = r2
            r2 = r1
            r1 = r33
            r15 = r15 | r12
            r3 = r2
            r2 = r1
            r1 = r3
            r3 = r8
            r5 = r9
            r4 = r13
            r6 = r20
        L_0x0104:
            r11 = 0
            goto L_0x046a
        L_0x0107:
            r9 = r2
            r2 = r1
            r1 = r9
            r10 = r40
            r9 = r19
            r18 = -1
            r37 = r14
            r19 = r15
            r8 = 0
            r14 = r1
            r15 = r2
            goto L_0x046f
        L_0x0119:
            r37 = r2
            r2 = r1
            r1 = r37
            r10 = r40
            r37 = r14
            r8 = r15
            r9 = r19
            r14 = r26
            r18 = -1
            if (r5 != 0) goto L_0x013f
            int r3 = com.google.android.gms.internal.auth.zzdu.zzh(r7, r3, r10)
            int r4 = r10.zza
            int r4 = com.google.android.gms.internal.auth.zzej.zzb(r4)
            r2.putInt(r1, r14, r4)
            r15 = r8 | r12
            r4 = r2
            r2 = r1
            r1 = r4
            goto L_0x01fa
        L_0x013f:
            r14 = r1
            r15 = r2
            goto L_0x01bb
        L_0x0143:
            r37 = r2
            r2 = r1
            r1 = r37
            r10 = r40
            r37 = r14
            r8 = r15
            r9 = r19
            r4 = r20
            r14 = r26
            r18 = -1
            if (r5 != 0) goto L_0x01b7
            int r3 = com.google.android.gms.internal.auth.zzdu.zzh(r7, r3, r10)
            int r5 = r10.zza
            com.google.android.gms.internal.auth.zzey r6 = r0.zzq(r9)
            r16 = -2147483648(0xffffffff80000000, float:-0.0)
            r11 = r11 & r16
            if (r11 == 0) goto L_0x0187
            if (r6 == 0) goto L_0x0187
            boolean r6 = r6.zza()
            if (r6 == 0) goto L_0x0170
            goto L_0x0187
        L_0x0170:
            com.google.android.gms.internal.auth.zzha r6 = zzc(r1)
            long r11 = (long) r5
            java.lang.Long r5 = java.lang.Long.valueOf(r11)
            r6.zzh(r4, r5)
            r5 = r2
            r2 = r1
            r1 = r5
            r14 = r37
            r6 = r4
            r15 = r8
            r5 = r9
            r4 = r13
            goto L_0x0104
        L_0x0187:
            r2.putInt(r1, r14, r5)
            goto L_0x01a9
        L_0x018b:
            r37 = r2
            r2 = r1
            r1 = r37
            r10 = r40
            r37 = r14
            r8 = r15
            r9 = r19
            r4 = r20
            r14 = r26
            r6 = 2
            r18 = -1
            if (r5 != r6) goto L_0x01b7
            int r3 = com.google.android.gms.internal.auth.zzdu.zza(r7, r3, r10)
            java.lang.Object r5 = r10.zzc
            r2.putObject(r1, r14, r5)
        L_0x01a9:
            r15 = r8 | r12
            r5 = r2
            r2 = r1
            r1 = r5
            r14 = r37
            r8 = r38
            r6 = r4
            r5 = r9
            r4 = r13
            goto L_0x0202
        L_0x01b7:
            r14 = r1
            r15 = r2
            r20 = r4
        L_0x01bb:
            r19 = r8
            goto L_0x0217
        L_0x01bf:
            r37 = r2
            r2 = r1
            r1 = r37
            r10 = r40
            r37 = r14
            r8 = r15
            r9 = r19
            r4 = r20
            r6 = 2
            r18 = -1
            if (r5 != r6) goto L_0x0205
            r5 = r1
            java.lang.Object r1 = r0.zzt(r5, r9)
            r6 = r2
            com.google.android.gms.internal.auth.zzgi r2 = r0.zzr(r9)
            r20 = r10
            r10 = r6
            r6 = r20
            r20 = r4
            r4 = r3
            r3 = r7
            r7 = r5
            r5 = r38
            int r2 = com.google.android.gms.internal.auth.zzdu.zzm(r1, r2, r3, r4, r5, r6)
            r4 = r1
            r1 = r3
            r3 = r6
            r0.zzB(r7, r9, r4)
            r15 = r8 | r12
            r4 = r7
            r7 = r1
            r1 = r10
            r10 = r3
            r3 = r2
            r2 = r4
        L_0x01fa:
            r14 = r37
            r8 = r38
            r5 = r9
            r4 = r13
            r6 = r20
        L_0x0202:
            r11 = 0
            goto L_0x0019
        L_0x0205:
            r20 = r7
            r7 = r1
            r1 = r20
            r20 = r10
            r10 = r2
            r2 = r3
            r3 = r20
            r20 = r4
            r3 = r2
            r14 = r7
            r19 = r8
            r15 = r10
        L_0x0217:
            r8 = 0
            goto L_0x046f
        L_0x021a:
            r10 = r1
            r1 = r7
            r37 = r14
            r8 = r15
            r9 = r19
            r14 = r26
            r4 = 2
            r18 = -1
            r7 = r2
            r2 = r3
            r3 = r40
            if (r5 != r4) goto L_0x0342
            r4 = r11 & r21
            if (r4 == 0) goto L_0x031d
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r1, r2, r3)
            int r4 = r3.zza
            if (r4 < 0) goto L_0x0318
            if (r4 != 0) goto L_0x0241
            r3.zzc = r6
            r19 = r8
            r8 = 0
            goto L_0x0337
        L_0x0241:
            int r5 = com.google.android.gms.internal.auth.zzhn.zza
            int r5 = r1.length
            int r6 = r5 - r2
            r11 = r2 | r4
            int r6 = r6 - r4
            r6 = r6 | r11
            if (r6 < 0) goto L_0x02fc
            int r5 = r2 + r4
            char[] r4 = new char[r4]
            r6 = 0
        L_0x0251:
            if (r2 >= r5) goto L_0x0265
            byte r11 = r1[r2]
            boolean r16 = com.google.android.gms.internal.auth.zzhk.zzd(r11)
            if (r16 == 0) goto L_0x0265
            int r2 = r2 + 1
            int r16 = r6 + 1
            char r11 = (char) r11
            r4[r6] = r11
            r6 = r16
            goto L_0x0251
        L_0x0265:
            if (r2 >= r5) goto L_0x02ef
            int r11 = r2 + 1
            r16 = r2
            byte r2 = r1[r16]
            boolean r19 = com.google.android.gms.internal.auth.zzhk.zzd(r2)
            if (r19 == 0) goto L_0x028d
            int r16 = r6 + 1
            char r2 = (char) r2
            r4[r6] = r2
            r2 = r11
        L_0x0279:
            r6 = r16
            if (r2 >= r5) goto L_0x0265
            byte r11 = r1[r2]
            boolean r16 = com.google.android.gms.internal.auth.zzhk.zzd(r11)
            if (r16 == 0) goto L_0x0265
            int r2 = r2 + 1
            int r16 = r6 + 1
            char r11 = (char) r11
            r4[r6] = r11
            goto L_0x0279
        L_0x028d:
            r19 = r8
            r8 = -32
            if (r2 >= r8) goto L_0x02a9
            if (r11 >= r5) goto L_0x02a4
            int r8 = r16 + 2
            byte r11 = r1[r11]
            int r16 = r6 + 1
            com.google.android.gms.internal.auth.zzhk.zzc(r2, r11, r4, r6)
            r2 = r8
            r6 = r16
        L_0x02a1:
            r8 = r19
            goto L_0x0265
        L_0x02a4:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzb()
            throw r1
        L_0x02a9:
            r8 = -16
            if (r2 >= r8) goto L_0x02ca
            int r8 = r5 + -1
            if (r11 >= r8) goto L_0x02c5
            int r8 = r16 + 2
            byte r11 = r1[r11]
            int r16 = r16 + 3
            byte r8 = r1[r8]
            int r21 = r6 + 1
            com.google.android.gms.internal.auth.zzhk.zzb(r2, r11, r8, r4, r6)
            r2 = r16
            r8 = r19
            r6 = r21
            goto L_0x0265
        L_0x02c5:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzb()
            throw r1
        L_0x02ca:
            int r8 = r5 + -2
            if (r11 >= r8) goto L_0x02ea
            int r8 = r16 + 2
            byte r22 = r1[r11]
            int r11 = r16 + 3
            byte r23 = r1[r8]
            int r8 = r16 + 4
            byte r24 = r1[r11]
            r21 = r2
            r25 = r4
            r26 = r6
            com.google.android.gms.internal.auth.zzhk.zza(r21, r22, r23, r24, r25, r26)
            r2 = r25
            int r6 = r6 + 2
            r4 = r2
            r2 = r8
            goto L_0x02a1
        L_0x02ea:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzb()
            throw r1
        L_0x02ef:
            r2 = r4
            r19 = r8
            java.lang.String r4 = new java.lang.String
            r8 = 0
            r4.<init>(r2, r8, r6)
            r3.zzc = r4
            r2 = r5
            goto L_0x0337
        L_0x02fc:
            java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r2 = new java.lang.Object[]{r3, r2, r4}
            java.lang.String r3 = "buffer length=%d, index=%d, size=%d"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r1.<init>(r2)
            throw r1
        L_0x0318:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzc()
            throw r1
        L_0x031d:
            r19 = r8
            r8 = 0
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r1, r2, r3)
            int r4 = r3.zza
            if (r4 < 0) goto L_0x033d
            if (r4 != 0) goto L_0x032d
            r3.zzc = r6
            goto L_0x0337
        L_0x032d:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.auth.zzfa.zzb
            r5.<init>(r1, r2, r4, r6)
            r3.zzc = r5
            int r2 = r2 + r4
        L_0x0337:
            java.lang.Object r4 = r3.zzc
            r10.putObject(r7, r14, r4)
            goto L_0x0389
        L_0x033d:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzc()
            throw r1
        L_0x0342:
            r19 = r8
            r8 = 0
            goto L_0x0392
        L_0x0347:
            r10 = r1
            r1 = r7
            r37 = r14
            r9 = r19
            r8 = 0
            r18 = -1
            r7 = r2
            r2 = r3
            r19 = r15
            r14 = r26
            r3 = r40
            if (r5 != 0) goto L_0x0392
            int r2 = com.google.android.gms.internal.auth.zzdu.zzk(r1, r2, r3)
            long r4 = r3.zzb
            int r4 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r4 == 0) goto L_0x0367
            r4 = r28
            goto L_0x0368
        L_0x0367:
            r4 = r8
        L_0x0368:
            com.google.android.gms.internal.auth.zzhj.zzk(r7, r14, r4)
            goto L_0x0389
        L_0x036c:
            r10 = r1
            r1 = r7
            r37 = r14
            r9 = r19
            r4 = 5
            r8 = 0
            r18 = -1
            r7 = r2
            r2 = r3
            r19 = r15
            r14 = r26
            r3 = r40
            if (r5 != r4) goto L_0x0392
            int r4 = com.google.android.gms.internal.auth.zzdu.zzb(r1, r2)
            r10.putInt(r7, r14, r4)
            int r2 = r2 + 4
        L_0x0389:
            r15 = r19 | r12
            r4 = r7
            r7 = r1
            r1 = r10
            r10 = r3
            r3 = r2
            r2 = r4
            goto L_0x03bd
        L_0x0392:
            r3 = r2
            r14 = r7
            r15 = r10
            goto L_0x046f
        L_0x0397:
            r10 = r1
            r1 = r7
            r37 = r14
            r9 = r19
            r4 = r28
            r8 = 0
            r18 = -1
            r7 = r2
            r2 = r3
            r19 = r15
            r14 = r26
            r3 = r40
            if (r5 != r4) goto L_0x03c0
            long r5 = com.google.android.gms.internal.auth.zzdu.zzn(r1, r2)
            r11 = r2
            r2 = r7
            r7 = r1
            r1 = r10
            r10 = r3
            r3 = r14
            r1.putLong(r2, r3, r5)
            int r3 = r11 + 8
            r15 = r19 | r12
        L_0x03bd:
            r14 = r37
            goto L_0x03e5
        L_0x03c0:
            r11 = r2
            r2 = r7
            r7 = r1
            r1 = r10
            r10 = r3
            goto L_0x0417
        L_0x03c7:
            r10 = r40
            r11 = r3
            r37 = r14
            r9 = r19
            r3 = r26
            r8 = 0
            r18 = -1
            r19 = r15
            if (r5 != 0) goto L_0x0417
            int r5 = com.google.android.gms.internal.auth.zzdu.zzh(r7, r11, r10)
            int r6 = r10.zza
            r1.putInt(r2, r3, r6)
            r15 = r19 | r12
            r14 = r37
            r3 = r5
        L_0x03e5:
            r11 = r8
            r5 = r9
            r4 = r13
            r6 = r20
            goto L_0x046a
        L_0x03ec:
            r10 = r40
            r11 = r3
            r37 = r14
            r9 = r19
            r3 = r26
            r8 = 0
            r18 = -1
            r19 = r15
            if (r5 != 0) goto L_0x0417
            int r11 = com.google.android.gms.internal.auth.zzdu.zzk(r7, r11, r10)
            long r5 = r10.zzb
            r1.putLong(r2, r3, r5)
            r15 = r1
            r14 = r2
            r1 = r19 | r12
            r2 = r15
            r15 = r1
            r1 = r2
            r5 = r9
            r3 = r11
            r4 = r13
            r2 = r14
            r6 = r20
            r14 = r37
            r11 = r8
            goto L_0x046a
        L_0x0417:
            r15 = r1
            r14 = r2
            goto L_0x046e
        L_0x041b:
            r10 = r40
            r11 = r3
            r37 = r14
            r9 = r19
            r4 = 5
            r8 = 0
            r18 = -1
            r14 = r2
            r19 = r15
            r15 = r1
            r1 = r26
            if (r5 != r4) goto L_0x046e
            int r3 = com.google.android.gms.internal.auth.zzdu.zzb(r7, r11)
            float r3 = java.lang.Float.intBitsToFloat(r3)
            com.google.android.gms.internal.auth.zzhj.zzm(r14, r1, r3)
            int r3 = r11 + 4
            goto L_0x045d
        L_0x043c:
            r10 = r40
            r11 = r3
            r37 = r14
            r9 = r19
            r4 = r28
            r8 = 0
            r18 = -1
            r14 = r2
            r19 = r15
            r15 = r1
            r1 = r26
            if (r5 != r4) goto L_0x046e
            long r3 = com.google.android.gms.internal.auth.zzdu.zzn(r7, r11)
            double r3 = java.lang.Double.longBitsToDouble(r3)
            com.google.android.gms.internal.auth.zzhj.zzl(r14, r1, r3)
            int r3 = r11 + 8
        L_0x045d:
            r1 = r19 | r12
            r2 = r15
            r15 = r1
            r1 = r2
        L_0x0462:
            r11 = r8
            r5 = r9
            r4 = r13
            r2 = r14
            r6 = r20
            r14 = r37
        L_0x046a:
            r8 = r38
            goto L_0x0019
        L_0x046e:
            r3 = r11
        L_0x046f:
            r6 = r36
            r26 = r37
            r7 = r39
            r10 = r14
            r29 = r15
            r15 = r19
            r1 = r20
            r14 = r40
            goto L_0x0c7d
        L_0x0480:
            r7 = r1
            r10 = r2
            r9 = r19
            r1 = r26
            r18 = -1
            r8 = 27
            r19 = 10
            if (r4 != r8) goto L_0x04de
            r8 = 2
            if (r5 != r8) goto L_0x04ce
            java.lang.Object r4 = r7.getObject(r10, r1)
            com.google.android.gms.internal.auth.zzez r4 = (com.google.android.gms.internal.auth.zzez) r4
            boolean r5 = r4.zzc()
            if (r5 != 0) goto L_0x04af
            int r5 = r4.size()
            if (r5 != 0) goto L_0x04a4
            goto L_0x04a6
        L_0x04a4:
            int r19 = r5 + r5
        L_0x04a6:
            r5 = r19
            com.google.android.gms.internal.auth.zzez r4 = r4.zzd(r5)
            r7.putObject(r10, r1, r4)
        L_0x04af:
            r6 = r4
            com.google.android.gms.internal.auth.zzgi r1 = r0.zzr(r9)
            r5 = r38
            r4 = r3
            r8 = r7
            r2 = r20
            r3 = r36
            r7 = r40
            int r1 = com.google.android.gms.internal.auth.zzdu.zze(r1, r2, r3, r4, r5, r6, r7)
            r7 = r3
            r3 = r2
            r6 = r3
            r5 = r9
            r2 = r10
            r4 = r13
            r11 = 0
            r10 = r40
            r3 = r1
            r1 = r8
            goto L_0x046a
        L_0x04ce:
            r8 = r7
            r7 = r36
            r6 = r40
            r29 = r8
            r26 = r14
            r27 = r15
            r8 = r20
            r14 = r3
            goto L_0x0a30
        L_0x04de:
            r29 = r7
            r26 = r14
            r27 = r15
            r7 = r36
            r14 = r3
            r15 = r6
            r3 = r20
            r6 = r40
            r20 = r12
            r12 = r38
            r8 = 49
            if (r4 > r8) goto L_0x0a04
            r30 = r9
            long r8 = (long) r11
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r20 = r11.getObject(r10, r1)
            r31 = r8
            r8 = r20
            com.google.android.gms.internal.auth.zzez r8 = (com.google.android.gms.internal.auth.zzez) r8
            boolean r9 = r8.zzc()
            if (r9 != 0) goto L_0x051b
            int r9 = r8.size()
            if (r9 != 0) goto L_0x0510
            goto L_0x0512
        L_0x0510:
            int r19 = r9 + r9
        L_0x0512:
            r9 = r19
            com.google.android.gms.internal.auth.zzez r8 = r8.zzd(r9)
            r11.putObject(r10, r1, r8)
        L_0x051b:
            switch(r4) {
                case 18: goto L_0x0977;
                case 19: goto L_0x091e;
                case 20: goto L_0x08d3;
                case 21: goto L_0x08d3;
                case 22: goto L_0x08b4;
                case 23: goto L_0x086c;
                case 24: goto L_0x0823;
                case 25: goto L_0x07c6;
                case 26: goto L_0x070a;
                case 27: goto L_0x06e7;
                case 28: goto L_0x0688;
                case 29: goto L_0x08b4;
                case 30: goto L_0x05e5;
                case 31: goto L_0x0823;
                case 32: goto L_0x086c;
                case 33: goto L_0x058d;
                case 34: goto L_0x053f;
                case 35: goto L_0x0977;
                case 36: goto L_0x091e;
                case 37: goto L_0x08d3;
                case 38: goto L_0x08d3;
                case 39: goto L_0x08b4;
                case 40: goto L_0x086c;
                case 41: goto L_0x0823;
                case 42: goto L_0x07c6;
                case 43: goto L_0x08b4;
                case 44: goto L_0x05e5;
                case 45: goto L_0x0823;
                case 46: goto L_0x086c;
                case 47: goto L_0x058d;
                case 48: goto L_0x053f;
                default: goto L_0x051e;
            }
        L_0x051e:
            r1 = r8
            r8 = r3
            r3 = r7
            r7 = r1
            r4 = r12
            r11 = r14
            r9 = r30
            r1 = 3
            if (r5 != r1) goto L_0x07c3
            com.google.android.gms.internal.auth.zzgi r1 = r0.zzr(r9)
            r2 = r8 & -8
            r5 = r2 | 4
            r2 = r3
            r3 = r11
            int r11 = com.google.android.gms.internal.auth.zzdu.zzc(r1, r2, r3, r4, r5, r6)
            r14 = r3
            java.lang.Object r2 = r6.zzc
            r7.add(r2)
            goto L_0x09d0
        L_0x053f:
            r4 = 2
            if (r5 != r4) goto L_0x0564
            com.google.android.gms.internal.auth.zzfm r8 = (com.google.android.gms.internal.auth.zzfm) r8
            int r1 = com.google.android.gms.internal.auth.zzdu.zzh(r7, r14, r6)
            int r2 = r6.zza
            int r2 = r2 + r1
        L_0x054b:
            if (r1 >= r2) goto L_0x055b
            int r1 = com.google.android.gms.internal.auth.zzdu.zzk(r7, r1, r6)
            long r4 = r6.zzb
            long r4 = com.google.android.gms.internal.auth.zzej.zzc(r4)
            r8.zze(r4)
            goto L_0x054b
        L_0x055b:
            if (r1 != r2) goto L_0x055f
            goto L_0x05da
        L_0x055f:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r1
        L_0x0564:
            if (r5 != 0) goto L_0x05e0
            com.google.android.gms.internal.auth.zzfm r8 = (com.google.android.gms.internal.auth.zzfm) r8
            int r1 = com.google.android.gms.internal.auth.zzdu.zzk(r7, r14, r6)
            long r4 = r6.zzb
            long r4 = com.google.android.gms.internal.auth.zzej.zzc(r4)
            r8.zze(r4)
        L_0x0575:
            if (r1 >= r12) goto L_0x05da
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r7, r1, r6)
            int r4 = r6.zza
            if (r3 != r4) goto L_0x05da
            int r1 = com.google.android.gms.internal.auth.zzdu.zzk(r7, r2, r6)
            long r4 = r6.zzb
            long r4 = com.google.android.gms.internal.auth.zzej.zzc(r4)
            r8.zze(r4)
            goto L_0x0575
        L_0x058d:
            r4 = 2
            if (r5 != r4) goto L_0x05b1
            com.google.android.gms.internal.auth.zzew r8 = (com.google.android.gms.internal.auth.zzew) r8
            int r1 = com.google.android.gms.internal.auth.zzdu.zzh(r7, r14, r6)
            int r2 = r6.zza
            int r2 = r2 + r1
        L_0x0599:
            if (r1 >= r2) goto L_0x05a9
            int r1 = com.google.android.gms.internal.auth.zzdu.zzh(r7, r1, r6)
            int r4 = r6.zza
            int r4 = com.google.android.gms.internal.auth.zzej.zzb(r4)
            r8.zze(r4)
            goto L_0x0599
        L_0x05a9:
            if (r1 != r2) goto L_0x05ac
            goto L_0x05da
        L_0x05ac:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r1
        L_0x05b1:
            if (r5 != 0) goto L_0x05e0
            com.google.android.gms.internal.auth.zzew r8 = (com.google.android.gms.internal.auth.zzew) r8
            int r1 = com.google.android.gms.internal.auth.zzdu.zzh(r7, r14, r6)
            int r2 = r6.zza
            int r2 = com.google.android.gms.internal.auth.zzej.zzb(r2)
            r8.zze(r2)
        L_0x05c2:
            if (r1 >= r12) goto L_0x05da
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r7, r1, r6)
            int r4 = r6.zza
            if (r3 != r4) goto L_0x05da
            int r1 = com.google.android.gms.internal.auth.zzdu.zzh(r7, r2, r6)
            int r2 = r6.zza
            int r2 = com.google.android.gms.internal.auth.zzej.zzb(r2)
            r8.zze(r2)
            goto L_0x05c2
        L_0x05da:
            r8 = r3
            r9 = r30
            r3 = r1
            goto L_0x09eb
        L_0x05e0:
            r8 = r3
            r9 = r30
            goto L_0x09ea
        L_0x05e5:
            r4 = 2
            if (r5 != r4) goto L_0x05f5
            int r1 = com.google.android.gms.internal.auth.zzdu.zzf(r7, r14, r8, r6)
            r4 = r7
            r7 = r1
            r1 = r3
            r3 = r4
            r4 = r12
            r11 = r14
        L_0x05f2:
            r9 = r30
            goto L_0x0603
        L_0x05f5:
            if (r5 != 0) goto L_0x0680
            r1 = r3
            r2 = r7
            r5 = r8
            r4 = r12
            r3 = r14
            int r7 = com.google.android.gms.internal.auth.zzdu.zzj(r1, r2, r3, r4, r5, r6)
            r11 = r3
            r3 = r2
            goto L_0x05f2
        L_0x0603:
            com.google.android.gms.internal.auth.zzey r2 = r0.zzq(r9)
            com.google.android.gms.internal.auth.zzgz r5 = r0.zzl
            int r12 = com.google.android.gms.internal.auth.zzgk.zza
            if (r2 == 0) goto L_0x0678
            boolean r12 = r8 instanceof java.util.RandomAccess
            if (r12 == 0) goto L_0x0650
            int r12 = r8.size()
            r37 = r2
            r2 = r16
            r14 = 0
            r15 = 0
        L_0x061b:
            if (r14 >= r12) goto L_0x0644
            java.lang.Object r19 = r8.get(r14)
            java.lang.Integer r19 = (java.lang.Integer) r19
            r20 = r7
            int r7 = r19.intValue()
            boolean r19 = r37.zza()
            if (r19 == 0) goto L_0x063b
            if (r14 == r15) goto L_0x0638
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r8.set(r15, r7)
        L_0x0638:
            int r15 = r15 + 1
            goto L_0x063f
        L_0x063b:
            java.lang.Object r2 = com.google.android.gms.internal.auth.zzgk.zzc(r10, r13, r7, r2, r5)
        L_0x063f:
            int r14 = r14 + 1
            r7 = r20
            goto L_0x061b
        L_0x0644:
            r20 = r7
            if (r15 == r12) goto L_0x067a
            java.util.List r2 = r8.subList(r15, r12)
            r2.clear()
            goto L_0x067a
        L_0x0650:
            r37 = r2
            r20 = r7
            java.util.Iterator r2 = r8.iterator()
            r7 = r16
        L_0x065a:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x067a
            java.lang.Object r8 = r2.next()
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            boolean r12 = r37.zza()
            if (r12 != 0) goto L_0x065a
            java.lang.Object r7 = com.google.android.gms.internal.auth.zzgk.zzc(r10, r13, r8, r7, r5)
            r2.remove()
            goto L_0x065a
        L_0x0678:
            r20 = r7
        L_0x067a:
            r8 = r1
            r14 = r11
            r3 = r20
            goto L_0x09eb
        L_0x0680:
            r1 = r3
            r3 = r7
            r4 = r12
            r9 = r30
            r8 = r1
            goto L_0x09ea
        L_0x0688:
            r1 = r3
            r3 = r7
            r4 = r12
            r11 = r14
            r9 = r30
            r2 = 2
            if (r5 != r2) goto L_0x07c2
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r11, r6)
            int r5 = r6.zza
            if (r5 < 0) goto L_0x06e2
            int r7 = r3.length
            int r7 = r7 - r2
            if (r5 > r7) goto L_0x06dd
            if (r5 != 0) goto L_0x06a5
            com.google.android.gms.internal.auth.zzef r5 = com.google.android.gms.internal.auth.zzef.zzb
            r8.add(r5)
            goto L_0x06ad
        L_0x06a5:
            com.google.android.gms.internal.auth.zzef r7 = com.google.android.gms.internal.auth.zzef.zzk(r3, r2, r5)
            r8.add(r7)
        L_0x06ac:
            int r2 = r2 + r5
        L_0x06ad:
            if (r2 >= r4) goto L_0x08c1
            int r5 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r2, r6)
            int r7 = r6.zza
            if (r1 != r7) goto L_0x08c1
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r5, r6)
            int r5 = r6.zza
            if (r5 < 0) goto L_0x06d8
            int r7 = r3.length
            int r7 = r7 - r2
            if (r5 > r7) goto L_0x06d3
            if (r5 != 0) goto L_0x06cb
            com.google.android.gms.internal.auth.zzef r5 = com.google.android.gms.internal.auth.zzef.zzb
            r8.add(r5)
            goto L_0x06ad
        L_0x06cb:
            com.google.android.gms.internal.auth.zzef r7 = com.google.android.gms.internal.auth.zzef.zzk(r3, r2, r5)
            r8.add(r7)
            goto L_0x06ac
        L_0x06d3:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r1
        L_0x06d8:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzc()
            throw r1
        L_0x06dd:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r1
        L_0x06e2:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzc()
            throw r1
        L_0x06e7:
            r1 = r3
            r3 = r7
            r4 = r12
            r11 = r14
            r9 = r30
            r2 = 2
            if (r5 != r2) goto L_0x07c2
            r20 = r1
            com.google.android.gms.internal.auth.zzgi r1 = r0.zzr(r9)
            r5 = r4
            r7 = r6
            r6 = r8
            r4 = r11
            r2 = r20
            int r1 = com.google.android.gms.internal.auth.zzdu.zze(r1, r2, r3, r4, r5, r6, r7)
            r11 = r2
            r2 = r1
            r1 = r11
            r11 = r4
            r4 = r5
            r8 = r1
            r3 = r2
            r6 = r7
            goto L_0x08c3
        L_0x070a:
            r1 = r3
            r3 = r7
            r4 = r12
            r11 = r14
            r9 = r30
            r2 = 2
            if (r5 != r2) goto L_0x07c2
            r20 = 536870912(0x20000000, double:2.652494739E-315)
            long r20 = r31 & r20
            int r2 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x0762
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r11, r6)
            int r5 = r6.zza
            if (r5 < 0) goto L_0x075d
            if (r5 != 0) goto L_0x072a
            r8.add(r15)
            goto L_0x0735
        L_0x072a:
            java.lang.String r7 = new java.lang.String
            java.nio.charset.Charset r12 = com.google.android.gms.internal.auth.zzfa.zzb
            r7.<init>(r3, r2, r5, r12)
            r8.add(r7)
        L_0x0734:
            int r2 = r2 + r5
        L_0x0735:
            if (r2 >= r4) goto L_0x08c1
            int r5 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r2, r6)
            int r7 = r6.zza
            if (r1 != r7) goto L_0x08c1
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r5, r6)
            int r5 = r6.zza
            if (r5 < 0) goto L_0x0758
            if (r5 != 0) goto L_0x074d
            r8.add(r15)
            goto L_0x0735
        L_0x074d:
            java.lang.String r7 = new java.lang.String
            java.nio.charset.Charset r12 = com.google.android.gms.internal.auth.zzfa.zzb
            r7.<init>(r3, r2, r5, r12)
            r8.add(r7)
            goto L_0x0734
        L_0x0758:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzc()
            throw r1
        L_0x075d:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzc()
            throw r1
        L_0x0762:
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r11, r6)
            int r5 = r6.zza
            if (r5 < 0) goto L_0x07bd
            if (r5 != 0) goto L_0x0770
            r8.add(r15)
            goto L_0x0783
        L_0x0770:
            int r7 = r2 + r5
            boolean r12 = com.google.android.gms.internal.auth.zzhn.zzc(r3, r2, r7)
            if (r12 == 0) goto L_0x07b8
            java.lang.String r12 = new java.lang.String
            java.nio.charset.Charset r14 = com.google.android.gms.internal.auth.zzfa.zzb
            r12.<init>(r3, r2, r5, r14)
            r8.add(r12)
        L_0x0782:
            r2 = r7
        L_0x0783:
            if (r2 >= r4) goto L_0x08c1
            int r5 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r2, r6)
            int r7 = r6.zza
            if (r1 != r7) goto L_0x08c1
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r5, r6)
            int r5 = r6.zza
            if (r5 < 0) goto L_0x07b3
            if (r5 != 0) goto L_0x079b
            r8.add(r15)
            goto L_0x0783
        L_0x079b:
            int r7 = r2 + r5
            boolean r12 = com.google.android.gms.internal.auth.zzhn.zzc(r3, r2, r7)
            if (r12 == 0) goto L_0x07ae
            java.lang.String r12 = new java.lang.String
            java.nio.charset.Charset r14 = com.google.android.gms.internal.auth.zzfa.zzb
            r12.<init>(r3, r2, r5, r14)
            r8.add(r12)
            goto L_0x0782
        L_0x07ae:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzb()
            throw r1
        L_0x07b3:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzc()
            throw r1
        L_0x07b8:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzb()
            throw r1
        L_0x07bd:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzc()
            throw r1
        L_0x07c2:
            r8 = r1
        L_0x07c3:
            r14 = r11
            goto L_0x09ea
        L_0x07c6:
            r1 = r3
            r3 = r7
            r4 = r12
            r11 = r14
            r9 = r30
            r2 = 2
            if (r5 != r2) goto L_0x07f4
            com.google.android.gms.internal.auth.zzdv r8 = (com.google.android.gms.internal.auth.zzdv) r8
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r11, r6)
            int r5 = r6.zza
            int r5 = r5 + r2
        L_0x07d8:
            if (r2 >= r5) goto L_0x07eb
            int r2 = com.google.android.gms.internal.auth.zzdu.zzk(r3, r2, r6)
            long r14 = r6.zzb
            int r7 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r7 == 0) goto L_0x07e6
            r7 = 1
            goto L_0x07e7
        L_0x07e6:
            r7 = 0
        L_0x07e7:
            r8.zze(r7)
            goto L_0x07d8
        L_0x07eb:
            if (r2 != r5) goto L_0x07ef
            goto L_0x088c
        L_0x07ef:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r1
        L_0x07f4:
            if (r5 != 0) goto L_0x07c2
            com.google.android.gms.internal.auth.zzdv r8 = (com.google.android.gms.internal.auth.zzdv) r8
            int r2 = com.google.android.gms.internal.auth.zzdu.zzk(r3, r11, r6)
            long r14 = r6.zzb
            int r5 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r5 == 0) goto L_0x0804
            r5 = 1
            goto L_0x0805
        L_0x0804:
            r5 = 0
        L_0x0805:
            r8.zze(r5)
        L_0x0808:
            if (r2 >= r4) goto L_0x08c1
            int r5 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r2, r6)
            int r7 = r6.zza
            if (r1 != r7) goto L_0x08c1
            int r2 = com.google.android.gms.internal.auth.zzdu.zzk(r3, r5, r6)
            long r14 = r6.zzb
            int r5 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r5 == 0) goto L_0x081e
            r5 = 1
            goto L_0x081f
        L_0x081e:
            r5 = 0
        L_0x081f:
            r8.zze(r5)
            goto L_0x0808
        L_0x0823:
            r1 = r3
            r3 = r7
            r4 = r12
            r11 = r14
            r9 = r30
            r2 = 2
            if (r5 != r2) goto L_0x084a
            com.google.android.gms.internal.auth.zzew r8 = (com.google.android.gms.internal.auth.zzew) r8
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r11, r6)
            int r5 = r6.zza
            int r5 = r5 + r2
        L_0x0835:
            if (r2 >= r5) goto L_0x0841
            int r7 = com.google.android.gms.internal.auth.zzdu.zzb(r3, r2)
            r8.zze(r7)
            int r2 = r2 + 4
            goto L_0x0835
        L_0x0841:
            if (r2 != r5) goto L_0x0845
            goto L_0x08c1
        L_0x0845:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r1
        L_0x084a:
            r2 = 5
            if (r5 != r2) goto L_0x07c2
            com.google.android.gms.internal.auth.zzew r8 = (com.google.android.gms.internal.auth.zzew) r8
            int r2 = com.google.android.gms.internal.auth.zzdu.zzb(r3, r11)
            r8.zze(r2)
            int r2 = r11 + 4
        L_0x0858:
            if (r2 >= r4) goto L_0x08c1
            int r5 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r2, r6)
            int r7 = r6.zza
            if (r1 != r7) goto L_0x08c1
            int r2 = com.google.android.gms.internal.auth.zzdu.zzb(r3, r5)
            r8.zze(r2)
            int r2 = r5 + 4
            goto L_0x0858
        L_0x086c:
            r1 = r3
            r3 = r7
            r4 = r12
            r11 = r14
            r9 = r30
            r2 = 2
            if (r5 != r2) goto L_0x0892
            com.google.android.gms.internal.auth.zzfm r8 = (com.google.android.gms.internal.auth.zzfm) r8
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r11, r6)
            int r5 = r6.zza
            int r5 = r5 + r2
        L_0x087e:
            if (r2 >= r5) goto L_0x088a
            long r14 = com.google.android.gms.internal.auth.zzdu.zzn(r3, r2)
            r8.zze(r14)
            int r2 = r2 + 8
            goto L_0x087e
        L_0x088a:
            if (r2 != r5) goto L_0x088d
        L_0x088c:
            goto L_0x08c1
        L_0x088d:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r1
        L_0x0892:
            r2 = 1
            if (r5 != r2) goto L_0x07c2
            com.google.android.gms.internal.auth.zzfm r8 = (com.google.android.gms.internal.auth.zzfm) r8
            long r14 = com.google.android.gms.internal.auth.zzdu.zzn(r3, r11)
            r8.zze(r14)
            int r2 = r11 + 8
        L_0x08a0:
            if (r2 >= r4) goto L_0x08c1
            int r5 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r2, r6)
            int r7 = r6.zza
            if (r1 != r7) goto L_0x08c1
            long r14 = com.google.android.gms.internal.auth.zzdu.zzn(r3, r5)
            r8.zze(r14)
            int r2 = r5 + 8
            goto L_0x08a0
        L_0x08b4:
            r1 = r3
            r3 = r7
            r4 = r12
            r11 = r14
            r9 = r30
            r2 = 2
            if (r5 != r2) goto L_0x08c6
            int r2 = com.google.android.gms.internal.auth.zzdu.zzf(r3, r11, r8, r6)
        L_0x08c1:
            r8 = r1
        L_0x08c2:
            r3 = r2
        L_0x08c3:
            r14 = r11
            goto L_0x09eb
        L_0x08c6:
            if (r5 != 0) goto L_0x07c2
            r2 = r3
            r5 = r8
            r3 = r11
            int r5 = com.google.android.gms.internal.auth.zzdu.zzj(r1, r2, r3, r4, r5, r6)
            r8 = r1
            r3 = r2
            r3 = r5
            goto L_0x08c3
        L_0x08d3:
            r2 = r8
            r8 = r3
            r3 = r7
            r7 = r2
            r4 = r12
            r11 = r14
            r9 = r30
            r2 = 2
            if (r5 != r2) goto L_0x08fc
            r1 = r7
            com.google.android.gms.internal.auth.zzfm r1 = (com.google.android.gms.internal.auth.zzfm) r1
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r11, r6)
            int r5 = r6.zza
            int r5 = r5 + r2
        L_0x08e8:
            if (r2 >= r5) goto L_0x08f4
            int r2 = com.google.android.gms.internal.auth.zzdu.zzk(r3, r2, r6)
            long r14 = r6.zzb
            r1.zze(r14)
            goto L_0x08e8
        L_0x08f4:
            if (r2 != r5) goto L_0x08f7
            goto L_0x08c2
        L_0x08f7:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r1
        L_0x08fc:
            if (r5 != 0) goto L_0x07c3
            r1 = r7
            com.google.android.gms.internal.auth.zzfm r1 = (com.google.android.gms.internal.auth.zzfm) r1
            int r2 = com.google.android.gms.internal.auth.zzdu.zzk(r3, r11, r6)
            long r14 = r6.zzb
            r1.zze(r14)
        L_0x090a:
            if (r2 >= r4) goto L_0x08c2
            int r5 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r2, r6)
            int r7 = r6.zza
            if (r8 != r7) goto L_0x08c2
            int r2 = com.google.android.gms.internal.auth.zzdu.zzk(r3, r5, r6)
            long r14 = r6.zzb
            r1.zze(r14)
            goto L_0x090a
        L_0x091e:
            r2 = r8
            r8 = r3
            r3 = r7
            r7 = r2
            r4 = r12
            r11 = r14
            r9 = r30
            r2 = 2
            if (r5 != r2) goto L_0x094c
            r1 = r7
            com.google.android.gms.internal.auth.zzer r1 = (com.google.android.gms.internal.auth.zzer) r1
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r11, r6)
            int r5 = r6.zza
            int r5 = r5 + r2
        L_0x0933:
            if (r2 >= r5) goto L_0x0943
            int r7 = com.google.android.gms.internal.auth.zzdu.zzb(r3, r2)
            float r7 = java.lang.Float.intBitsToFloat(r7)
            r1.zze(r7)
            int r2 = r2 + 4
            goto L_0x0933
        L_0x0943:
            if (r2 != r5) goto L_0x0947
            goto L_0x08c2
        L_0x0947:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r1
        L_0x094c:
            r2 = 5
            if (r5 != r2) goto L_0x07c3
            r1 = r7
            com.google.android.gms.internal.auth.zzer r1 = (com.google.android.gms.internal.auth.zzer) r1
            int r2 = com.google.android.gms.internal.auth.zzdu.zzb(r3, r11)
            float r2 = java.lang.Float.intBitsToFloat(r2)
            r1.zze(r2)
            int r2 = r11 + 4
        L_0x095f:
            if (r2 >= r4) goto L_0x08c2
            int r5 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r2, r6)
            int r7 = r6.zza
            if (r8 != r7) goto L_0x08c2
            int r2 = com.google.android.gms.internal.auth.zzdu.zzb(r3, r5)
            float r2 = java.lang.Float.intBitsToFloat(r2)
            r1.zze(r2)
            int r2 = r5 + 4
            goto L_0x095f
        L_0x0977:
            r2 = r8
            r8 = r3
            r3 = r7
            r7 = r2
            r4 = r12
            r11 = r14
            r9 = r30
            r2 = 2
            if (r5 != r2) goto L_0x09a5
            r1 = r7
            com.google.android.gms.internal.auth.zzek r1 = (com.google.android.gms.internal.auth.zzek) r1
            int r2 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r11, r6)
            int r5 = r6.zza
            int r5 = r5 + r2
        L_0x098c:
            if (r2 >= r5) goto L_0x099c
            long r14 = com.google.android.gms.internal.auth.zzdu.zzn(r3, r2)
            double r14 = java.lang.Double.longBitsToDouble(r14)
            r1.zze(r14)
            int r2 = r2 + 8
            goto L_0x098c
        L_0x099c:
            if (r2 != r5) goto L_0x09a0
            goto L_0x08c2
        L_0x09a0:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzf()
            throw r1
        L_0x09a5:
            r2 = 1
            if (r5 != r2) goto L_0x07c3
            r1 = r7
            com.google.android.gms.internal.auth.zzek r1 = (com.google.android.gms.internal.auth.zzek) r1
            long r14 = com.google.android.gms.internal.auth.zzdu.zzn(r3, r11)
            double r14 = java.lang.Double.longBitsToDouble(r14)
            r1.zze(r14)
            int r2 = r11 + 8
        L_0x09b8:
            if (r2 >= r4) goto L_0x08c2
            int r5 = com.google.android.gms.internal.auth.zzdu.zzh(r3, r2, r6)
            int r7 = r6.zza
            if (r8 != r7) goto L_0x08c2
            long r14 = com.google.android.gms.internal.auth.zzdu.zzn(r3, r5)
            double r14 = java.lang.Double.longBitsToDouble(r14)
            r1.zze(r14)
            int r2 = r5 + 8
            goto L_0x09b8
        L_0x09d0:
            if (r11 >= r4) goto L_0x09e8
            r2 = r36
            int r3 = com.google.android.gms.internal.auth.zzdu.zzh(r2, r11, r6)
            int r12 = r6.zza
            if (r8 != r12) goto L_0x09e8
            int r11 = com.google.android.gms.internal.auth.zzdu.zzc(r1, r2, r3, r4, r5, r6)
            java.lang.Object r2 = r6.zzc
            r7.add(r2)
            r4 = r38
            goto L_0x09d0
        L_0x09e8:
            r3 = r11
            goto L_0x09eb
        L_0x09ea:
            r3 = r14
        L_0x09eb:
            if (r3 == r14) goto L_0x09fd
            r7 = r36
            r5 = r9
            r2 = r10
            r4 = r13
            r14 = r26
            r15 = r27
            r1 = r29
            r11 = 0
            r10 = r6
            r6 = r8
            goto L_0x046a
        L_0x09fd:
            r7 = r39
            r14 = r6
            r1 = r8
            r15 = r27
            goto L_0x0a37
        L_0x0a04:
            r8 = r3
            r3 = 50
            if (r4 != r3) goto L_0x0a3b
            r3 = 2
            if (r5 != r3) goto L_0x0a30
            sun.misc.Unsafe r3 = zzb
            java.lang.Object r4 = r0.zzs(r9)
            java.lang.Object r5 = r3.getObject(r10, r1)
            r6 = r5
            com.google.android.gms.internal.auth.zzfr r6 = (com.google.android.gms.internal.auth.zzfr) r6
            boolean r6 = r6.zze()
            if (r6 != 0) goto L_0x0a2d
            com.google.android.gms.internal.auth.zzfr r6 = com.google.android.gms.internal.auth.zzfr.zza()
            com.google.android.gms.internal.auth.zzfr r6 = r6.zzb()
            com.google.android.gms.internal.auth.zzfs.zza(r6, r5)
            r3.putObject(r10, r1, r6)
        L_0x0a2d:
            com.google.android.gms.internal.auth.zzfq r4 = (com.google.android.gms.internal.auth.zzfq) r4
            throw r16
        L_0x0a30:
            r7 = r39
            r1 = r8
            r3 = r14
            r15 = r27
            r14 = r6
        L_0x0a37:
            r6 = r36
            goto L_0x0c7d
        L_0x0a3b:
            int r3 = r9 + 2
            sun.misc.Unsafe r7 = zzb
            r3 = r20[r3]
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r17
            r12 = r4
            long r3 = (long) r3
            switch(r12) {
                case 51: goto L_0x0c3f;
                case 52: goto L_0x0c1f;
                case 53: goto L_0x0c03;
                case 54: goto L_0x0c03;
                case 55: goto L_0x0be8;
                case 56: goto L_0x0bcb;
                case 57: goto L_0x0bae;
                case 58: goto L_0x0b86;
                case 59: goto L_0x0b4b;
                case 60: goto L_0x0b1d;
                case 61: goto L_0x0af9;
                case 62: goto L_0x0be8;
                case 63: goto L_0x0abf;
                case 64: goto L_0x0bae;
                case 65: goto L_0x0bcb;
                case 66: goto L_0x0aa0;
                case 67: goto L_0x0a7c;
                case 68: goto L_0x0a55;
                default: goto L_0x0a4b;
            }
        L_0x0a4b:
            r20 = r8
            r19 = r9
            r9 = r14
            r14 = r6
            r6 = r36
            goto L_0x0c60
        L_0x0a55:
            r12 = 3
            if (r5 != r12) goto L_0x0a4b
            java.lang.Object r1 = r0.zzu(r10, r13, r9)
            r2 = r8 & -8
            r2 = r2 | 4
            r6 = r2
            com.google.android.gms.internal.auth.zzgi r2 = r0.zzr(r9)
            r3 = r36
            r5 = r38
            r7 = r40
            r4 = r14
            int r2 = com.google.android.gms.internal.auth.zzdu.zzl(r1, r2, r3, r4, r5, r6, r7)
            r6 = r3
            r11 = r7
            r0.zzC(r10, r13, r9, r1)
            r3 = r2
            r20 = r8
            r19 = r9
            goto L_0x0b11
        L_0x0a7c:
            r11 = r6
            r6 = r36
            if (r5 != 0) goto L_0x0a9a
            int r5 = com.google.android.gms.internal.auth.zzdu.zzk(r6, r14, r11)
            r20 = r8
            r19 = r9
            long r8 = r11.zzb
            long r8 = com.google.android.gms.internal.auth.zzej.zzc(r8)
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            r7.putObject(r10, r1, r8)
            r7.putInt(r10, r3, r13)
            goto L_0x0abd
        L_0x0a9a:
            r20 = r8
            r19 = r9
            goto L_0x0b19
        L_0x0aa0:
            r11 = r6
            r20 = r8
            r19 = r9
            r6 = r36
            if (r5 != 0) goto L_0x0b19
            int r5 = com.google.android.gms.internal.auth.zzdu.zzh(r6, r14, r11)
            int r8 = r11.zza
            int r8 = com.google.android.gms.internal.auth.zzej.zzb(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7.putObject(r10, r1, r8)
            r7.putInt(r10, r3, r13)
        L_0x0abd:
            r3 = r5
            goto L_0x0b11
        L_0x0abf:
            r11 = r6
            r20 = r8
            r19 = r9
            r6 = r36
            if (r5 != 0) goto L_0x0b19
            int r5 = com.google.android.gms.internal.auth.zzdu.zzh(r6, r14, r11)
            int r8 = r11.zza
            r9 = r19
            com.google.android.gms.internal.auth.zzey r12 = r0.zzq(r9)
            if (r12 == 0) goto L_0x0aec
            boolean r12 = r12.zza()
            if (r12 == 0) goto L_0x0add
            goto L_0x0aec
        L_0x0add:
            com.google.android.gms.internal.auth.zzha r1 = zzc(r10)
            long r2 = (long) r8
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12 = r20
            r1.zzh(r12, r2)
            goto L_0x0b0c
        L_0x0aec:
            r12 = r20
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7.putObject(r10, r1, r8)
            r7.putInt(r10, r3, r13)
            goto L_0x0b0c
        L_0x0af9:
            r11 = r6
            r12 = r8
            r8 = 2
            r6 = r36
            if (r5 != r8) goto L_0x0b15
            int r5 = com.google.android.gms.internal.auth.zzdu.zza(r6, r14, r11)
            java.lang.Object r8 = r11.zzc
            r7.putObject(r10, r1, r8)
            r7.putInt(r10, r3, r13)
        L_0x0b0c:
            r3 = r5
            r19 = r9
            r20 = r12
        L_0x0b11:
            r9 = r14
            r14 = r11
            goto L_0x0c61
        L_0x0b15:
            r19 = r9
            r20 = r12
        L_0x0b19:
            r9 = r14
            r14 = r11
            goto L_0x0c60
        L_0x0b1d:
            r11 = r6
            r12 = r8
            r8 = 2
            r6 = r36
            if (r5 != r8) goto L_0x0b42
            java.lang.Object r1 = r0.zzu(r10, r13, r9)
            com.google.android.gms.internal.auth.zzgi r2 = r0.zzr(r9)
            r5 = r38
            r3 = r6
            r6 = r11
            r4 = r14
            int r2 = com.google.android.gms.internal.auth.zzdu.zzm(r1, r2, r3, r4, r5, r6)
            r14 = r6
            r6 = r3
            r0.zzC(r10, r13, r9, r1)
            r3 = r2
            r19 = r9
            r20 = r12
            r9 = r4
            goto L_0x0c61
        L_0x0b42:
            r4 = r14
            r14 = r11
            r19 = r9
            r20 = r12
            r9 = r4
            goto L_0x0c60
        L_0x0b4b:
            r12 = r8
            r19 = r9
            r9 = r14
            r8 = 2
            r14 = r6
            r6 = r36
            if (r5 != r8) goto L_0x0baa
            int r5 = com.google.android.gms.internal.auth.zzdu.zzh(r6, r9, r14)
            int r8 = r14.zza
            if (r8 != 0) goto L_0x0b61
            r7.putObject(r10, r1, r15)
            goto L_0x0b7e
        L_0x0b61:
            r11 = r11 & r21
            if (r11 == 0) goto L_0x0b73
            int r11 = r5 + r8
            boolean r11 = com.google.android.gms.internal.auth.zzhn.zzc(r6, r5, r11)
            if (r11 == 0) goto L_0x0b6e
            goto L_0x0b73
        L_0x0b6e:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzb()
            throw r1
        L_0x0b73:
            java.lang.String r11 = new java.lang.String
            java.nio.charset.Charset r15 = com.google.android.gms.internal.auth.zzfa.zzb
            r11.<init>(r6, r5, r8, r15)
            r7.putObject(r10, r1, r11)
            int r5 = r5 + r8
        L_0x0b7e:
            r7.putInt(r10, r3, r13)
            r3 = r5
            r20 = r12
            goto L_0x0c61
        L_0x0b86:
            r12 = r8
            r19 = r9
            r9 = r14
            r14 = r6
            r6 = r36
            if (r5 != 0) goto L_0x0baa
            int r5 = com.google.android.gms.internal.auth.zzdu.zzk(r6, r9, r14)
            r20 = r12
            long r11 = r14.zzb
            int r8 = (r11 > r22 ? 1 : (r11 == r22 ? 0 : -1))
            if (r8 == 0) goto L_0x0b9d
            r8 = 1
            goto L_0x0b9e
        L_0x0b9d:
            r8 = 0
        L_0x0b9e:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            r7.putObject(r10, r1, r8)
            r7.putInt(r10, r3, r13)
            goto L_0x0c1d
        L_0x0baa:
            r20 = r12
            goto L_0x0c60
        L_0x0bae:
            r20 = r8
            r19 = r9
            r9 = r14
            r8 = 5
            r14 = r6
            r6 = r36
            if (r5 != r8) goto L_0x0c60
            int r5 = com.google.android.gms.internal.auth.zzdu.zzb(r6, r9)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r7.putObject(r10, r1, r5)
            int r1 = r9 + 4
            r7.putInt(r10, r3, r13)
            goto L_0x0c5e
        L_0x0bcb:
            r20 = r8
            r19 = r9
            r9 = r14
            r8 = 1
            r14 = r6
            r6 = r36
            if (r5 != r8) goto L_0x0c60
            long r11 = com.google.android.gms.internal.auth.zzdu.zzn(r6, r9)
            java.lang.Long r5 = java.lang.Long.valueOf(r11)
            r7.putObject(r10, r1, r5)
            int r1 = r9 + 8
            r7.putInt(r10, r3, r13)
            goto L_0x0c5e
        L_0x0be8:
            r20 = r8
            r19 = r9
            r9 = r14
            r14 = r6
            r6 = r36
            if (r5 != 0) goto L_0x0c60
            int r5 = com.google.android.gms.internal.auth.zzdu.zzh(r6, r9, r14)
            int r8 = r14.zza
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7.putObject(r10, r1, r8)
            r7.putInt(r10, r3, r13)
            goto L_0x0c1d
        L_0x0c03:
            r20 = r8
            r19 = r9
            r9 = r14
            r14 = r6
            r6 = r36
            if (r5 != 0) goto L_0x0c60
            int r5 = com.google.android.gms.internal.auth.zzdu.zzk(r6, r9, r14)
            long r11 = r14.zzb
            java.lang.Long r8 = java.lang.Long.valueOf(r11)
            r7.putObject(r10, r1, r8)
            r7.putInt(r10, r3, r13)
        L_0x0c1d:
            r3 = r5
            goto L_0x0c61
        L_0x0c1f:
            r20 = r8
            r19 = r9
            r9 = r14
            r8 = 5
            r14 = r6
            r6 = r36
            if (r5 != r8) goto L_0x0c60
            int r5 = com.google.android.gms.internal.auth.zzdu.zzb(r6, r9)
            float r5 = java.lang.Float.intBitsToFloat(r5)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r7.putObject(r10, r1, r5)
            int r1 = r9 + 4
            r7.putInt(r10, r3, r13)
            goto L_0x0c5e
        L_0x0c3f:
            r20 = r8
            r19 = r9
            r9 = r14
            r8 = 1
            r14 = r6
            r6 = r36
            if (r5 != r8) goto L_0x0c60
            long r11 = com.google.android.gms.internal.auth.zzdu.zzn(r6, r9)
            double r11 = java.lang.Double.longBitsToDouble(r11)
            java.lang.Double r5 = java.lang.Double.valueOf(r11)
            r7.putObject(r10, r1, r5)
            int r1 = r9 + 8
            r7.putInt(r10, r3, r13)
        L_0x0c5e:
            r3 = r1
            goto L_0x0c61
        L_0x0c60:
            r3 = r9
        L_0x0c61:
            if (r3 == r9) goto L_0x0c75
            r8 = r38
            r7 = r6
            r2 = r10
            r4 = r13
            r10 = r14
            r5 = r19
            r6 = r20
            r14 = r26
            r15 = r27
            r1 = r29
            goto L_0x0202
        L_0x0c75:
            r7 = r39
            r9 = r19
            r1 = r20
            r15 = r27
        L_0x0c7d:
            if (r1 != r7) goto L_0x0c88
            if (r7 != 0) goto L_0x0c82
            goto L_0x0c88
        L_0x0c82:
            r4 = r38
            r6 = r1
            r14 = r26
            goto L_0x0cae
        L_0x0c88:
            com.google.android.gms.internal.auth.zzha r5 = zzc(r10)
            r4 = r38
            r2 = r6
            r6 = r14
            int r3 = com.google.android.gms.internal.auth.zzdu.zzg(r1, r2, r3, r4, r5, r6)
            r7 = r36
            r6 = r1
            r8 = r4
            r5 = r9
            r2 = r10
            r4 = r13
            r14 = r26
            r1 = r29
            r11 = 0
            r10 = r40
            goto L_0x0019
        L_0x0ca4:
            r7 = r39
            r29 = r1
            r10 = r2
            r4 = r8
            r26 = r14
            r27 = r15
        L_0x0cae:
            r9 = 1048575(0xfffff, float:1.469367E-39)
            if (r14 == r9) goto L_0x0cb9
            long r1 = (long) r14
            r8 = r29
            r8.putInt(r10, r1, r15)
        L_0x0cb9:
            int r1 = r0.zzi
        L_0x0cbb:
            int r2 = r0.zzj
            if (r1 >= r2) goto L_0x0cea
            int[] r2 = r0.zzh
            r2 = r2[r1]
            int[] r5 = r0.zzc
            r5 = r5[r2]
            int r5 = r0.zzo(r2)
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r17
            long r8 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.auth.zzhj.zzf(r10, r8)
            if (r5 != 0) goto L_0x0cd8
            goto L_0x0cde
        L_0x0cd8:
            com.google.android.gms.internal.auth.zzey r8 = r0.zzq(r2)
            if (r8 != 0) goto L_0x0ce1
        L_0x0cde:
            int r1 = r1 + 1
            goto L_0x0cbb
        L_0x0ce1:
            com.google.android.gms.internal.auth.zzfr r5 = (com.google.android.gms.internal.auth.zzfr) r5
            java.lang.Object r1 = r0.zzs(r2)
            com.google.android.gms.internal.auth.zzfq r1 = (com.google.android.gms.internal.auth.zzfq) r1
            throw r16
        L_0x0cea:
            if (r7 != 0) goto L_0x0cf4
            if (r3 != r4) goto L_0x0cef
            goto L_0x0cf8
        L_0x0cef:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzd()
            throw r1
        L_0x0cf4:
            if (r3 > r4) goto L_0x0cf9
            if (r6 != r7) goto L_0x0cf9
        L_0x0cf8:
            return r3
        L_0x0cf9:
            com.google.android.gms.internal.auth.zzfb r1 = com.google.android.gms.internal.auth.zzfb.zzd()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zzb(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.auth.zzdt):int");
    }

    public final Object zzd() {
        return ((zzev) this.zzg).zzc();
    }

    public final void zze(Object obj) {
        if (zzH(obj)) {
            if (obj instanceof zzev) {
                zzev zzev = (zzev) obj;
                zzev.zzl(Integer.MAX_VALUE);
                zzev.zza = 0;
                zzev.zzj();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzo2 = zzo(i);
                int i2 = 1048575 & zzo2;
                int zzn2 = zzn(zzo2);
                long j = (long) i2;
                if (zzn2 != 9) {
                    if (zzn2 == 60 || zzn2 == 68) {
                        if (zzI(obj, this.zzc[i], i)) {
                            zzr(i).zze(zzb.getObject(obj, j));
                        }
                    } else {
                        switch (zzn2) {
                            case 17:
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                                this.zzk.zza(obj, j);
                                continue;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzfr) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (zzE(obj, i)) {
                    zzr(i).zze(zzb.getObject(obj, j));
                }
            }
            this.zzl.zze(obj);
        }
    }

    public final void zzf(Object obj, Object obj2) {
        zzw(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzo2 = zzo(i);
            int i2 = this.zzc[i];
            long j = (long) (1048575 & zzo2);
            switch (zzn(zzo2)) {
                case 0:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzl(obj, j, zzhj.zza(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 1:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzm(obj, j, zzhj.zzb(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 2:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 3:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 4:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 5:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 6:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 7:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzk(obj, j, zzhj.zzt(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 8:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 9:
                    zzx(obj, obj2, i);
                    break;
                case 10:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 11:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 12:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 13:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 14:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 15:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 16:
                    if (!zzE(obj2, i)) {
                        break;
                    } else {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                        break;
                    }
                case 17:
                    zzx(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                    this.zzk.zzb(obj, obj2, j);
                    break;
                case 50:
                    int i3 = zzgk.zza;
                    zzhj.zzp(obj, j, zzfs.zza(zzhj.zzf(obj, j), zzhj.zzf(obj2, j)));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF:
                case 53:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzI(obj2, i2, i)) {
                        break;
                    } else {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzA(obj, i2, i);
                        break;
                    }
                case 60:
                    zzy(obj, obj2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT:
                case 64:
                case 65:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT:
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL:
                    if (!zzI(obj2, i2, i)) {
                        break;
                    } else {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzA(obj, i2, i);
                        break;
                    }
                case 68:
                    zzy(obj, obj2, i);
                    break;
            }
        }
        zzgk.zzd(this.zzl, obj, obj2);
    }

    public final void zzg(Object obj, byte[] bArr, int i, int i2, zzdt zzdt) throws IOException {
        zzb(obj, bArr, i, i2, 0, zzdt);
    }

    public final boolean zzh(Object obj, Object obj2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzo2 = zzo(i);
            long j = (long) (zzo2 & 1048575);
            switch (zzn(zzo2)) {
                case 0:
                    if (zzD(obj, obj2, i) && Double.doubleToLongBits(zzhj.zza(obj, j)) == Double.doubleToLongBits(zzhj.zza(obj2, j))) {
                        continue;
                    }
                case 1:
                    if (zzD(obj, obj2, i) && Float.floatToIntBits(zzhj.zzb(obj, j)) == Float.floatToIntBits(zzhj.zzb(obj2, j))) {
                        continue;
                    }
                case 2:
                    if (zzD(obj, obj2, i) && zzhj.zzd(obj, j) == zzhj.zzd(obj2, j)) {
                        continue;
                    }
                case 3:
                    if (zzD(obj, obj2, i) && zzhj.zzd(obj, j) == zzhj.zzd(obj2, j)) {
                        continue;
                    }
                case 4:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                        continue;
                    }
                case 5:
                    if (zzD(obj, obj2, i) && zzhj.zzd(obj, j) == zzhj.zzd(obj2, j)) {
                        continue;
                    }
                case 6:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                        continue;
                    }
                case 7:
                    if (zzD(obj, obj2, i) && zzhj.zzt(obj, j) == zzhj.zzt(obj2, j)) {
                        continue;
                    }
                case 8:
                    if (zzD(obj, obj2, i) && zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        continue;
                    }
                case 9:
                    if (zzD(obj, obj2, i) && zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        continue;
                    }
                case 10:
                    if (zzD(obj, obj2, i) && zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        continue;
                    }
                case 11:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                        continue;
                    }
                case 12:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                        continue;
                    }
                case 13:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                        continue;
                    }
                case 14:
                    if (zzD(obj, obj2, i) && zzhj.zzd(obj, j) == zzhj.zzd(obj2, j)) {
                        continue;
                    }
                case 15:
                    if (zzD(obj, obj2, i) && zzhj.zzc(obj, j) == zzhj.zzc(obj2, j)) {
                        continue;
                    }
                case 16:
                    if (zzD(obj, obj2, i) && zzhj.zzd(obj, j) == zzhj.zzd(obj2, j)) {
                        continue;
                    }
                case 17:
                    if (zzD(obj, obj2, i) && zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
                    z = zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j));
                    break;
                case 50:
                    z = zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF:
                case 53:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT:
                case 64:
                case 65:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT:
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL:
                case 68:
                    long zzl2 = (long) (zzl(i) & 1048575);
                    if (zzhj.zzc(obj, zzl2) == zzhj.zzc(obj2, zzl2) && zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzl.zzb(obj).equals(this.zzl.zzb(obj2))) {
            return false;
        }
        return true;
    }

    public final boolean zzi(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i3 < this.zzi) {
            int i6 = this.zzh[i3];
            int i7 = this.zzc[i6];
            int zzo2 = zzo(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i5) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(obj, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i5;
                i = i4;
            }
            Object obj2 = obj;
            if ((268435456 & zzo2) != 0 && !zzF(obj2, i6, i2, i, i10)) {
                return false;
            }
            int zzn2 = zzn(zzo2);
            if (zzn2 != 9 && zzn2 != 17) {
                if (zzn2 != 27) {
                    if (zzn2 == 60 || zzn2 == 68) {
                        if (zzI(obj2, i7, i6) && !zzG(obj2, zzo2, zzr(i6))) {
                            return false;
                        }
                    } else if (zzn2 != 49) {
                        if (zzn2 == 50 && !((zzfr) zzhj.zzf(obj2, (long) (zzo2 & 1048575))).isEmpty()) {
                            zzfq zzfq = (zzfq) zzs(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzhj.zzf(obj2, (long) (zzo2 & 1048575));
                if (!list.isEmpty()) {
                    zzgi zzr = zzr(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzr.zzi(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzF(obj2, i6, i2, i, i10) && !zzG(obj2, zzo2, zzr(i6))) {
                return false;
            }
            i3++;
            obj = obj2;
            i5 = i2;
            i4 = i;
        }
        return true;
    }
}
