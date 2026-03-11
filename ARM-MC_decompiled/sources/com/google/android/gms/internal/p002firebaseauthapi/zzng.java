package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzng  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzng {
    private static final byte[][] zza = {new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{-32, -21, 122, 124, 59, 65, -72, -82, Ascii.SYN, 86, -29, -6, -15, -97, -60, 106, -38, 9, -115, -21, -100, 50, -79, -3, -122, 98, 5, Ascii.SYN, 95, 73, -72, 0}, new byte[]{95, -100, -107, -68, -93, 80, -116, 36, -79, -48, -79, 85, -100, -125, -17, 91, 4, 68, 92, -60, 88, Ascii.FS, -114, -122, -40, 34, 78, -35, -48, -97, 17, 87}, new byte[]{-20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}};

    public static void zza(long[] jArr, byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        byte[] bArr3 = bArr2;
        int i = 32;
        if (bArr3.length == 32) {
            byte[] copyOf = Arrays.copyOf(bArr3, bArr3.length);
            copyOf[31] = (byte) (copyOf[31] & Byte.MAX_VALUE);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                byte[][] bArr4 = zza;
                if (i3 >= bArr4.length) {
                    long[] zza2 = zznm.zza(copyOf);
                    long[] jArr2 = new long[19];
                    long[] jArr3 = new long[19];
                    jArr3[0] = 1;
                    long[] jArr4 = new long[19];
                    jArr4[0] = 1;
                    long[] jArr5 = new long[19];
                    long[] jArr6 = new long[19];
                    long[] jArr7 = new long[19];
                    jArr7[0] = 1;
                    long[] jArr8 = new long[19];
                    long[] jArr9 = new long[19];
                    jArr9[0] = 1;
                    int i4 = 10;
                    System.arraycopy(zza2, 0, jArr2, 0, 10);
                    int i5 = 0;
                    while (i5 < i) {
                        byte b = bArr[31 - i5] & 255;
                        while (i2 < 8) {
                            int i6 = (b >> (7 - i2)) & 1;
                            zza(jArr4, jArr2, i6);
                            zza(jArr5, jArr3, i6);
                            long[] copyOf2 = Arrays.copyOf(jArr4, i4);
                            byte b2 = b;
                            int i7 = i2;
                            long[] jArr10 = new long[19];
                            int i8 = i5;
                            long[] jArr11 = new long[19];
                            long[] jArr12 = new long[19];
                            int i9 = i6;
                            long[] jArr13 = new long[19];
                            long[] jArr14 = jArr9;
                            long[] jArr15 = new long[19];
                            long[] jArr16 = new long[19];
                            zznm.zzd(jArr4, jArr5);
                            zznm.zzc(jArr5, copyOf2);
                            long[] copyOf3 = Arrays.copyOf(jArr2, 10);
                            zznm.zzd(jArr2, jArr3);
                            zznm.zzc(jArr3, copyOf3);
                            zznm.zzb(jArr12, jArr2, jArr5);
                            zznm.zzb(jArr13, jArr4, jArr3);
                            zznm.zzb(jArr12);
                            zznm.zza(jArr12);
                            zznm.zzb(jArr13);
                            zznm.zza(jArr13);
                            long[] jArr17 = jArr2;
                            System.arraycopy(jArr12, 0, copyOf3, 0, 10);
                            zznm.zzd(jArr12, jArr13);
                            zznm.zzc(jArr13, copyOf3);
                            zznm.zzb(jArr16, jArr12);
                            zznm.zzb(jArr15, jArr13);
                            zznm.zzb(jArr13, jArr15, zza2);
                            zznm.zzb(jArr13);
                            zznm.zza(jArr13);
                            System.arraycopy(jArr16, 0, jArr6, 0, 10);
                            System.arraycopy(jArr13, 0, jArr7, 0, 10);
                            zznm.zzb(jArr10, jArr4);
                            zznm.zzb(jArr11, jArr5);
                            zznm.zzb(jArr8, jArr10, jArr11);
                            zznm.zzb(jArr8);
                            zznm.zza(jArr8);
                            zznm.zzc(jArr11, jArr10);
                            long[] jArr18 = new long[19];
                            Arrays.fill(jArr18, 10, 18, 0);
                            zznm.zza(jArr18, jArr11, 121665);
                            zznm.zza(jArr18);
                            zznm.zzd(jArr18, jArr10);
                            long[] jArr19 = jArr14;
                            zznm.zzb(jArr19, jArr11, jArr18);
                            zznm.zzb(jArr19);
                            zznm.zza(jArr19);
                            int i10 = i9;
                            zza(jArr8, jArr6, i10);
                            zza(jArr19, jArr7, i10);
                            i2 = i7 + 1;
                            long[] jArr20 = jArr7;
                            jArr7 = jArr3;
                            jArr3 = jArr20;
                            long[] jArr21 = jArr8;
                            jArr8 = jArr4;
                            jArr4 = jArr21;
                            long[] jArr22 = jArr19;
                            jArr9 = jArr5;
                            jArr5 = jArr22;
                            byte[] bArr5 = bArr2;
                            jArr2 = jArr6;
                            b = b2;
                            i5 = i8;
                            jArr6 = jArr17;
                            i4 = 10;
                        }
                        long[] jArr23 = jArr2;
                        i5++;
                        byte[] bArr6 = bArr2;
                        i = 32;
                        i2 = 0;
                        i4 = 10;
                    }
                    int i11 = i4;
                    long[] jArr24 = new long[i11];
                    zznm.zza(jArr24, jArr5);
                    long[] jArr25 = jArr;
                    zznm.zza(jArr25, jArr4, jArr24);
                    long[] jArr26 = new long[i11];
                    long[] jArr27 = new long[i11];
                    long[] jArr28 = new long[11];
                    long[] jArr29 = new long[11];
                    long[] jArr30 = new long[11];
                    zznm.zza(jArr26, zza2, jArr25);
                    zznm.zzd(jArr27, zza2, jArr25);
                    long[] jArr31 = new long[i11];
                    jArr31[0] = 486662;
                    zznm.zzd(jArr29, jArr27, jArr31);
                    zznm.zza(jArr29, jArr29, jArr3);
                    zznm.zzd(jArr29, jArr2);
                    zznm.zza(jArr29, jArr29, jArr26);
                    zznm.zza(jArr29, jArr29, jArr2);
                    zznm.zza(jArr28, jArr29, 4);
                    zznm.zza(jArr28);
                    zznm.zza(jArr29, jArr26, jArr3);
                    zznm.zzc(jArr29, jArr29, jArr3);
                    zznm.zza(jArr30, jArr27, jArr2);
                    zznm.zzd(jArr29, jArr29, jArr30);
                    zznm.zzb(jArr29, jArr29);
                    if (!MessageDigest.isEqual(zznm.zzc(jArr28), zznm.zzc(jArr29))) {
                        throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: " + zzzx.zza(bArr2));
                    }
                    return;
                } else if (!MessageDigest.isEqual(bArr4[i3], copyOf)) {
                    i3++;
                } else {
                    throw new InvalidKeyException("Banned public key: " + zzzx.zza(bArr4[i3]));
                }
            }
        } else {
            throw new InvalidKeyException("Public key length is not 32-byte");
        }
    }

    private static void zza(long[] jArr, long[] jArr2, int i) {
        int i2 = -i;
        for (int i3 = 0; i3 < 10; i3++) {
            long j = jArr[i3];
            int i4 = (((int) j) ^ ((int) jArr2[i3])) & i2;
            jArr[i3] = (long) (((int) j) ^ i4);
            jArr2[i3] = (long) (((int) jArr2[i3]) ^ i4);
        }
    }
}
