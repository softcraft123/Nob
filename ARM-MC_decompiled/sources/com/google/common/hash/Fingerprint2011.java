package com.google.common.hash;

import com.google.common.base.Preconditions;

@ElementTypesAreNonnullByDefault
final class Fingerprint2011 extends AbstractNonStreamingHashFunction {
    static final HashFunction FINGERPRINT_2011 = new Fingerprint2011();
    private static final long K0 = -6505348102511208375L;
    private static final long K1 = -8261664234251669945L;
    private static final long K2 = -4288712594273399085L;
    private static final long K3 = -4132994306676758123L;

    static long hash128to64(long j, long j2) {
        long j3 = (j2 ^ j) * K3;
        long j4 = (j ^ (j3 ^ (j3 >>> 47))) * K3;
        return (j4 ^ (j4 >>> 47)) * K3;
    }

    private static long shiftMix(long j) {
        return j ^ (j >>> 47);
    }

    public int bits() {
        return 64;
    }

    Fingerprint2011() {
    }

    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        return HashCode.fromLong(fingerprint(bArr, i, i2));
    }

    public String toString() {
        return "Hashing.fingerprint2011()";
    }

    static long fingerprint(byte[] bArr, int i, int i2) {
        long j;
        if (i2 <= 32) {
            j = murmurHash64WithSeed(bArr, i, i2, -1397348546323613475L);
        } else if (i2 <= 64) {
            j = hashLength33To64(bArr, i, i2);
        } else {
            j = fullFingerprint(bArr, i, i2);
        }
        long j2 = K0;
        long load64 = i2 >= 8 ? LittleEndianByteArray.load64(bArr, i) : -6505348102511208375L;
        if (i2 >= 9) {
            j2 = LittleEndianByteArray.load64(bArr, (i + i2) - 8);
        }
        long hash128to64 = hash128to64(j + j2, load64);
        return (hash128to64 == 0 || hash128to64 == 1) ? hash128to64 - 2 : hash128to64;
    }

    private static void weakHashLength32WithSeeds(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long load64 = LittleEndianByteArray.load64(bArr, i);
        long load642 = LittleEndianByteArray.load64(bArr, i + 8);
        long load643 = LittleEndianByteArray.load64(bArr, i + 16);
        long load644 = LittleEndianByteArray.load64(bArr, i + 24);
        long j3 = j + load64;
        long j4 = load642 + j3 + load643;
        jArr[0] = j4 + load644;
        jArr[1] = Long.rotateRight(j2 + j3 + load644, 51) + Long.rotateRight(j4, 23) + j3;
    }

    private static long fullFingerprint(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        int i3 = i2;
        long load64 = LittleEndianByteArray.load64(bArr, i);
        int i4 = i + i3;
        long load642 = LittleEndianByteArray.load64(bArr2, i4 - 16) ^ K1;
        long load643 = K0 ^ LittleEndianByteArray.load64(bArr2, i4 - 56);
        long[] jArr = new long[2];
        long j = (long) i3;
        weakHashLength32WithSeeds(bArr2, i4 - 64, j, load642, jArr);
        long[] jArr2 = jArr;
        long[] jArr3 = new long[2];
        weakHashLength32WithSeeds(bArr2, i4 - 32, j * K1, K0, jArr3);
        long[] jArr4 = jArr3;
        long shiftMix = load643 + (shiftMix(jArr2[1]) * K1);
        long rotateRight = Long.rotateRight(load64 + shiftMix, 39) * K1;
        int i5 = (i3 - 1) & -64;
        long rotateRight2 = Long.rotateRight(load642, 33) * K1;
        long j2 = rotateRight;
        int i6 = i;
        while (true) {
            long rotateRight3 = Long.rotateRight(j2 + rotateRight2 + jArr2[0] + LittleEndianByteArray.load64(bArr2, i6 + 16), 37) * K1;
            long rotateRight4 = Long.rotateRight(rotateRight2 + jArr2[1] + LittleEndianByteArray.load64(bArr2, i6 + 48), 42) * K1;
            long j3 = jArr4[1] ^ rotateRight3;
            long j4 = rotateRight4 ^ jArr2[0];
            long rotateRight5 = Long.rotateRight(jArr4[0] ^ shiftMix, 33);
            weakHashLength32WithSeeds(bArr2, i6, jArr2[1] * K1, jArr4[0] + j3, jArr2);
            int i7 = i6;
            long[] jArr5 = jArr4;
            rotateRight2 = j4;
            weakHashLength32WithSeeds(bArr, i7 + 32, jArr4[1] + rotateRight5, rotateRight2, jArr5);
            i6 = i7 + 64;
            i5 -= 64;
            if (i5 == 0) {
                return hash128to64(hash128to64(jArr2[0], jArr5[0]) + (shiftMix(rotateRight2) * K1) + j3, hash128to64(jArr2[1], jArr5[1]) + rotateRight5);
            }
            bArr2 = bArr;
            jArr4 = jArr5;
            j2 = rotateRight5;
            shiftMix = j3;
        }
    }

    private static long hashLength33To64(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        int i3 = i2;
        long load64 = LittleEndianByteArray.load64(bArr2, i + 24);
        long j = (long) i3;
        int i4 = i + i3;
        int i5 = i4 - 16;
        long load642 = LittleEndianByteArray.load64(bArr, i) + ((j + LittleEndianByteArray.load64(bArr2, i5)) * K0);
        long rotateRight = Long.rotateRight(load642 + load64, 52);
        long rotateRight2 = Long.rotateRight(load642, 37);
        long load643 = load642 + LittleEndianByteArray.load64(bArr2, i + 8);
        int i6 = i + 16;
        long load644 = load643 + LittleEndianByteArray.load64(bArr2, i6);
        long j2 = load64 + load644;
        long rotateRight3 = rotateRight + Long.rotateRight(load644, 31) + rotateRight2 + Long.rotateRight(load643, 7);
        long load645 = LittleEndianByteArray.load64(bArr2, i6) + LittleEndianByteArray.load64(bArr2, i4 - 32);
        long load646 = LittleEndianByteArray.load64(bArr2, i4 - 8);
        int i7 = i4;
        long rotateRight4 = Long.rotateRight(load645 + load646, 52);
        long rotateRight5 = Long.rotateRight(load645, 37);
        long load647 = load645 + LittleEndianByteArray.load64(bArr2, i7 - 24);
        long load648 = load647 + LittleEndianByteArray.load64(bArr2, i5);
        return shiftMix((shiftMix(((j2 + rotateRight4 + Long.rotateRight(load648, 31) + rotateRight5 + Long.rotateRight(load647, 7)) * K2) + ((load646 + load648 + rotateRight3) * K0)) * K0) + rotateRight3) * K2;
    }

    static long murmurHash64WithSeed(byte[] bArr, int i, int i2, long j) {
        int i3 = i2 & -8;
        int i4 = i2 & 7;
        long j2 = j ^ (((long) i2) * K3);
        for (int i5 = 0; i5 < i3; i5 += 8) {
            j2 = (j2 ^ (shiftMix(LittleEndianByteArray.load64(bArr, i + i5) * K3) * K3)) * K3;
        }
        if (i4 != 0) {
            j2 = (LittleEndianByteArray.load64Safely(bArr, i + i3, i4) ^ j2) * K3;
        }
        return shiftMix(shiftMix(j2) * K3);
    }
}
