package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzic  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzic {
    private static long zza(byte[] bArr, int i, int i2) {
        return (zza(bArr, i) >> i2) & 67108863;
    }

    private static long zza(byte[] bArr, int i) {
        return ((long) (((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << Ascii.DLE))) & 4294967295L;
    }

    private static void zza(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) ((int) (255 & j));
            i2++;
            j >>= 8;
        }
    }

    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (bArr3.length == 32) {
            long zza = zza(bArr3, 0, 0) & 67108863;
            int i = 3;
            int i2 = 2;
            long zza2 = zza(bArr3, 3, 2) & 67108611;
            long zza3 = zza(bArr3, 6, 4) & 67092735;
            long zza4 = zza(bArr3, 9, 6) & 66076671;
            long zza5 = zza(bArr3, 12, 8) & 1048575;
            long j = zza2 * 5;
            long j2 = zza3 * 5;
            long j3 = zza4 * 5;
            long j4 = zza5 * 5;
            int i3 = 17;
            byte[] bArr5 = new byte[17];
            long j5 = 0;
            int i4 = 0;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            while (i4 < bArr4.length) {
                int min = Math.min(16, bArr4.length - i4);
                System.arraycopy(bArr4, i4, bArr5, 0, min);
                bArr5[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr5, min + 1, i3, (byte) 0);
                }
                long zza6 = j9 + zza(bArr5, 0, 0);
                long zza7 = j5 + zza(bArr5, i, i2);
                long zza8 = j6 + zza(bArr5, 6, 4);
                long zza9 = j7 + zza(bArr5, 9, 6);
                long j10 = zza2;
                long zza10 = j8 + (zza(bArr5, 12, 8) | ((long) (bArr5[16] << Ascii.CAN)));
                long j11 = (zza6 * zza) + (zza7 * j4) + (zza8 * j3) + (zza9 * j2) + (zza10 * j);
                long j12 = (zza6 * j10) + (zza7 * zza) + (zza8 * j4) + (zza9 * j3) + (zza10 * j2) + (j11 >> 26);
                long j13 = (zza6 * zza3) + (zza7 * j10) + (zza8 * zza) + (zza9 * j4) + (zza10 * j3) + (j12 >> 26);
                long j14 = (zza6 * zza4) + (zza7 * zza3) + (zza8 * j10) + (zza9 * zza) + (zza10 * j4) + (j13 >> 26);
                long j15 = (zza6 * zza5) + (zza7 * zza4) + (zza8 * zza3) + (zza9 * j10) + (zza10 * zza) + (j14 >> 26);
                long j16 = (j11 & 67108863) + ((j15 >> 26) * 5);
                j5 = (j12 & 67108863) + (j16 >> 26);
                i4 += 16;
                j6 = j13 & 67108863;
                j7 = j14 & 67108863;
                j8 = j15 & 67108863;
                i3 = 17;
                i = 3;
                j9 = j16 & 67108863;
                zza2 = j10;
                i2 = 2;
            }
            long j17 = j6 + (j5 >> 26);
            long j18 = j17 & 67108863;
            long j19 = j7 + (j17 >> 26);
            long j20 = j19 & 67108863;
            long j21 = j8 + (j19 >> 26);
            long j22 = j21 & 67108863;
            long j23 = j9 + ((j21 >> 26) * 5);
            long j24 = j23 & 67108863;
            long j25 = (j5 & 67108863) + (j23 >> 26);
            long j26 = j24 + 5;
            long j27 = j26 & 67108863;
            long j28 = (j26 >> 26) + j25;
            long j29 = j18 + (j28 >> 26);
            long j30 = j20 + (j29 >> 26);
            long j31 = (j22 + (j30 >> 26)) - 67108864;
            long j32 = j31 >> 63;
            long j33 = ~j32;
            long j34 = (j24 & j32) | (j27 & j33);
            long j35 = (j25 & j32) | (j28 & 67108863 & j33);
            long j36 = (j18 & j32) | (j29 & 67108863 & j33);
            long j37 = (j20 & j32) | (j30 & 67108863 & j33);
            long j38 = ((j31 & j33) | (j22 & j32)) << 8;
            long zza11 = (((j35 << 26) | j34) & 4294967295L) + zza(bArr3, 16);
            long j39 = zza11 & 4294967295L;
            long zza12 = (((j35 >> 6) | (j36 << 20)) & 4294967295L) + zza(bArr3, 20) + (zza11 >> 32);
            long zza13 = (((j36 >> 12) | (j37 << 14)) & 4294967295L) + zza(bArr3, 24) + (zza12 >> 32);
            byte[] bArr6 = new byte[16];
            zza(bArr6, j39, 0);
            zza(bArr6, zza12 & 4294967295L, 4);
            zza(bArr6, zza13 & 4294967295L, 8);
            zza(bArr6, (((j38 | (j37 >> 18)) & 4294967295L) + zza(bArr3, 28) + (zza13 >> 32)) & 4294967295L, 12);
            return bArr6;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }
}
