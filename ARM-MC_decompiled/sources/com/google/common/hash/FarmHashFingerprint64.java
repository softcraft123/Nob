package com.google.common.hash;

import com.google.common.base.Preconditions;

@ElementTypesAreNonnullByDefault
final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
    static final HashFunction FARMHASH_FINGERPRINT_64 = new FarmHashFingerprint64();
    private static final long K0 = -4348849565147123417L;
    private static final long K1 = -5435081209227447693L;
    private static final long K2 = -7286425919675154353L;

    private static long hashLength16(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    private static long shiftMix(long j) {
        return j ^ (j >>> 47);
    }

    public int bits() {
        return 64;
    }

    FarmHashFingerprint64() {
    }

    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        return HashCode.fromLong(fingerprint(bArr, i, i2));
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }

    static long fingerprint(byte[] bArr, int i, int i2) {
        if (i2 <= 32) {
            if (i2 <= 16) {
                return hashLength0to16(bArr, i, i2);
            }
            return hashLength17to32(bArr, i, i2);
        } else if (i2 <= 64) {
            return hashLength33To64(bArr, i, i2);
        } else {
            return hashLength65Plus(bArr, i, i2);
        }
    }

    private static void weakHashLength32WithSeeds(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long load64 = LittleEndianByteArray.load64(bArr, i);
        long load642 = LittleEndianByteArray.load64(bArr, i + 8);
        long load643 = LittleEndianByteArray.load64(bArr, i + 16);
        long load644 = LittleEndianByteArray.load64(bArr, i + 24);
        long j3 = j + load64;
        long j4 = load642 + j3 + load643;
        jArr[0] = j4 + load644;
        jArr[1] = Long.rotateRight(j2 + j3 + load644, 21) + Long.rotateRight(j4, 44) + j3;
    }

    private static long hashLength0to16(byte[] bArr, int i, int i2) {
        if (i2 >= 8) {
            long j = (((long) i2) * 2) + K2;
            long load64 = LittleEndianByteArray.load64(bArr, i) + K2;
            long load642 = LittleEndianByteArray.load64(bArr, (i + i2) - 8);
            return hashLength16((Long.rotateRight(load642, 37) * j) + load64, (Long.rotateRight(load64, 25) + load642) * j, j);
        } else if (i2 >= 4) {
            return hashLength16(((long) i2) + ((((long) LittleEndianByteArray.load32(bArr, i)) & 4294967295L) << 3), ((long) LittleEndianByteArray.load32(bArr, (i + i2) - 4)) & 4294967295L, ((long) (i2 * 2)) + K2);
        } else if (i2 <= 0) {
            return K2;
        } else {
            return shiftMix((((long) ((bArr[i] & 255) + ((bArr[(i2 >> 1) + i] & 255) << 8))) * K2) ^ (((long) (i2 + ((bArr[i + (i2 - 1)] & 255) << 2))) * K0)) * K2;
        }
    }

    private static long hashLength17to32(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        int i3 = i2;
        long j = (((long) i3) * 2) + K2;
        long load64 = LittleEndianByteArray.load64(bArr, i) * K1;
        long load642 = LittleEndianByteArray.load64(bArr2, i + 8);
        int i4 = i + i3;
        long load643 = LittleEndianByteArray.load64(bArr2, i4 - 8) * j;
        return hashLength16(Long.rotateRight(load64 + load642, 43) + Long.rotateRight(load643, 30) + (LittleEndianByteArray.load64(bArr2, i4 - 16) * K2), load643 + load64 + Long.rotateRight(load642 + K2, 18), j);
    }

    private static long hashLength33To64(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        int i3 = i2;
        long j = (((long) i3) * 2) + K2;
        long load64 = LittleEndianByteArray.load64(bArr, i) * K2;
        long load642 = LittleEndianByteArray.load64(bArr2, i + 8);
        int i4 = i + i3;
        long load643 = LittleEndianByteArray.load64(bArr2, i4 - 8) * j;
        long load644 = LittleEndianByteArray.load64(bArr2, i4 - 16) * K2;
        long rotateRight = load643 + Long.rotateRight(load642 + K2, 18) + load64;
        long rotateRight2 = Long.rotateRight(load64 + load642, 43) + Long.rotateRight(load643, 30) + load644;
        long hashLength16 = hashLength16(rotateRight2, rotateRight, j);
        long load645 = LittleEndianByteArray.load64(bArr2, i + 16) * j;
        long load646 = LittleEndianByteArray.load64(bArr2, i + 24);
        long load647 = (rotateRight2 + LittleEndianByteArray.load64(bArr2, i4 - 32)) * j;
        return hashLength16(Long.rotateRight(load645 + load646, 43) + Long.rotateRight(load647, 30) + ((hashLength16 + LittleEndianByteArray.load64(bArr2, i4 - 24)) * j), load645 + Long.rotateRight(load64 + load646, 18) + load647, j);
    }

    private static long hashLength65Plus(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        long j = (long) 81;
        long j2 = K1;
        long j3 = (j * K1) + 113;
        long shiftMix = shiftMix((j3 * K2) + 113) * K2;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        char c = 1;
        int i3 = i2 - 1;
        int i4 = i + ((i3 / 64) * 64);
        int i5 = i3 & 63;
        int i6 = i4 + i5;
        int i7 = i6 - 63;
        long j4 = j3;
        long load64 = (j * K2) + LittleEndianByteArray.load64(bArr, i);
        int i8 = i;
        while (true) {
            long j5 = j2;
            long rotateRight = (Long.rotateRight(((load64 + j4) + jArr[0]) + LittleEndianByteArray.load64(bArr2, i8 + 8), 37) * j5) ^ jArr2[c];
            char c2 = c;
            long rotateRight2 = (Long.rotateRight(j4 + jArr[c] + LittleEndianByteArray.load64(bArr2, i8 + 48), 42) * j5) + jArr[0] + LittleEndianByteArray.load64(bArr2, i8 + 40);
            long rotateRight3 = Long.rotateRight(shiftMix + jArr2[0], 33) * j5;
            weakHashLength32WithSeeds(bArr2, i8, jArr[c2] * j5, rotateRight + jArr2[0], jArr);
            int i9 = i8;
            long[] jArr3 = jArr;
            weakHashLength32WithSeeds(bArr2, i9 + 32, jArr2[c2] + rotateRight3, rotateRight2 + LittleEndianByteArray.load64(bArr2, i9 + 16), jArr2);
            i8 = i9 + 64;
            if (i8 == i4) {
                long j6 = ((rotateRight & 255) << c2) + j5;
                long j7 = jArr2[0] + ((long) i5);
                jArr2[0] = j7;
                long j8 = jArr3[0] + j7;
                jArr3[0] = j8;
                jArr2[0] = jArr2[0] + j8;
                long rotateRight4 = (Long.rotateRight(((rotateRight3 + rotateRight2) + jArr3[0]) + LittleEndianByteArray.load64(bArr2, i6 - 55), 37) * j6) ^ (jArr2[c2] * 9);
                long rotateRight5 = (Long.rotateRight(rotateRight2 + jArr3[c2] + LittleEndianByteArray.load64(bArr2, i6 - 15), 42) * j6) + (jArr3[0] * 9) + LittleEndianByteArray.load64(bArr2, i6 - 23);
                long rotateRight6 = Long.rotateRight(rotateRight + jArr2[0], 33) * j6;
                weakHashLength32WithSeeds(bArr2, i7, jArr3[c2] * j6, jArr2[0] + rotateRight4, jArr3);
                long[] jArr4 = jArr2;
                weakHashLength32WithSeeds(bArr2, i6 - 31, jArr2[c2] + rotateRight6, LittleEndianByteArray.load64(bArr2, i6 - 47) + rotateRight5, jArr4);
                return hashLength16(hashLength16(jArr3[0], jArr4[0], j6) + (shiftMix(rotateRight5) * K0) + rotateRight4, hashLength16(jArr3[c2], jArr4[c2], j6) + rotateRight6, j6);
            }
            bArr2 = bArr;
            load64 = rotateRight3;
            j2 = j5;
            shiftMix = rotateRight;
            c = c2;
            j4 = rotateRight2;
            jArr = jArr3;
        }
    }
}
