package com.google.common.math;

import com.google.android.gms.location.LocationRequest;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedLongs;
import java.math.RoundingMode;

@ElementTypesAreNonnullByDefault
public final class LongMath {
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
    static final long MAX_SIGNED_POWER_OF_TWO = 4611686018427387904L;
    private static final int SIEVE_30 = -545925251;
    static final int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
    static final int[] biggestSimpleBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, 139, 119, LocationRequest.PRIORITY_NO_POWER, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    static final long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    static final long[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    static final byte[] maxLog10ForLeadingZeros = {19, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, 17, 17, 17, Ascii.DLE, Ascii.DLE, Ascii.DLE, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SO, Ascii.SO, Ascii.SO, Ascii.CR, Ascii.CR, Ascii.CR, Ascii.FF, Ascii.FF, Ascii.FF, Ascii.FF, Ascii.VT, Ascii.VT, Ascii.VT, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
    private static final long[][] millerRabinBaseSets = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};
    static final long[] powersOf10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    static boolean fitsInInt(long j) {
        return ((long) ((int) j)) == j;
    }

    public static boolean isPowerOfTwo(long j) {
        boolean z = true;
        boolean z2 = j > 0;
        if ((j & (j - 1)) != 0) {
            z = false;
        }
        return z2 & z;
    }

    static int lessThanBranchFree(long j, long j2) {
        return (int) ((~(~(j - j2))) >>> 63);
    }

    public static long mean(long j, long j2) {
        return (j & j2) + ((j ^ j2) >> 1);
    }

    public static long saturatedAdd(long j, long j2) {
        long j3 = j + j2;
        boolean z = true;
        boolean z2 = (j2 ^ j) < 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        return z2 | z ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    public static long saturatedSubtract(long j, long j2) {
        long j3 = j - j2;
        boolean z = true;
        boolean z2 = (j2 ^ j) >= 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        return z2 | z ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    public static long ceilingPowerOfTwo(long j) {
        MathPreconditions.checkPositive("x", j);
        if (j <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + j + ") is not representable as a long");
    }

    public static long floorPowerOfTwo(long j) {
        MathPreconditions.checkPositive("x", j);
        return 1 << (63 - Long.numberOfLeadingZeros(j));
    }

    /* renamed from: com.google.common.math.LongMath$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                java.math.RoundingMode[] r0 = java.math.RoundingMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$math$RoundingMode = r0
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.AnonymousClass1.<clinit>():void");
        }
    }

    public static int log2(long j, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", j);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(j));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Long.numberOfLeadingZeros(j);
                return (63 - numberOfLeadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> numberOfLeadingZeros, j);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j);
    }

    public static int log10(long j, RoundingMode roundingMode) {
        int lessThanBranchFree;
        MathPreconditions.checkPositive("x", j);
        int log10Floor = log10Floor(j);
        long j2 = powersOf10[log10Floor];
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(j == j2);
                return log10Floor;
            case 2:
            case 3:
                return log10Floor;
            case 4:
            case 5:
                lessThanBranchFree = lessThanBranchFree(j2, j);
                break;
            case 6:
            case 7:
            case 8:
                lessThanBranchFree = lessThanBranchFree(halfPowersOf10[log10Floor], j);
                break;
            default:
                throw new AssertionError();
        }
        return log10Floor + lessThanBranchFree;
    }

    static int log10Floor(long j) {
        byte b = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(j)];
        return b - lessThanBranchFree(j, powersOf10[b]);
    }

    public static long pow(long j, int i) {
        MathPreconditions.checkNonNegative("exponent", i);
        if (-2 > j || j > 2) {
            long j2 = 1;
            while (i != 0) {
                if (i == 1) {
                    return j2 * j;
                }
                j2 *= (i & 1) == 0 ? 1 : j;
                j *= j;
                i >>= 1;
            }
            return j2;
        }
        int i2 = (int) j;
        if (i2 != -2) {
            if (i2 == -1) {
                return (i & 1) == 0 ? 1 : -1;
            }
            if (i2 == 0) {
                return i == 0 ? 1 : 0;
            }
            if (i2 == 1) {
                return 1;
            }
            if (i2 != 2) {
                throw new AssertionError();
            } else if (i < 64) {
                return 1 << i;
            } else {
                return 0;
            }
        } else if (i < 64) {
            return (i & 1) == 0 ? 1 << i : -(1 << i);
        } else {
            return 0;
        }
    }

    public static long sqrt(long j, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", j);
        if (fitsInInt(j)) {
            return (long) IntMath.sqrt((int) j, roundingMode);
        }
        long sqrt = (long) Math.sqrt((double) j);
        long j2 = sqrt * sqrt;
        boolean z = true;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                if (j2 != j) {
                    z = false;
                }
                MathPreconditions.checkRoundingUnnecessary(z);
                return sqrt;
            case 2:
            case 3:
                return j < j2 ? sqrt - 1 : sqrt;
            case 4:
            case 5:
                return j > j2 ? sqrt + 1 : sqrt;
            case 6:
            case 7:
            case 8:
                if (j >= j2) {
                    z = false;
                }
                long j3 = sqrt - (z ? 1 : 0);
                return j3 + ((long) lessThanBranchFree((j3 * j3) + j3, j));
            default:
                throw new AssertionError();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005b, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return r0 + ((long) r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long divide(long r9, long r11, java.math.RoundingMode r13) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r13)
            long r0 = r9 / r11
            long r2 = r11 * r0
            long r2 = r9 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0010
            return r0
        L_0x0010:
            long r9 = r9 ^ r11
            r7 = 63
            long r9 = r9 >> r7
            int r9 = (int) r9
            r10 = 1
            r9 = r9 | r10
            int[] r7 = com.google.common.math.LongMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r8 = r13.ordinal()
            r7 = r7[r8]
            switch(r7) {
                case 1: goto L_0x0054;
                case 2: goto L_0x005b;
                case 3: goto L_0x004f;
                case 4: goto L_0x0051;
                case 5: goto L_0x004b;
                case 6: goto L_0x0028;
                case 7: goto L_0x0028;
                case 8: goto L_0x0028;
                default: goto L_0x0022;
            }
        L_0x0022:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L_0x0028:
            long r2 = java.lang.Math.abs(r2)
            long r10 = java.lang.Math.abs(r11)
            long r10 = r10 - r2
            long r2 = r2 - r10
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x0047
            java.math.RoundingMode r10 = java.math.RoundingMode.HALF_UP
            if (r13 == r10) goto L_0x0051
            java.math.RoundingMode r10 = java.math.RoundingMode.HALF_EVEN
            if (r13 != r10) goto L_0x0046
            r10 = 1
            long r10 = r10 & r0
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0046
            goto L_0x0051
        L_0x0046:
            return r0
        L_0x0047:
            if (r10 <= 0) goto L_0x004a
            goto L_0x0051
        L_0x004a:
            return r0
        L_0x004b:
            if (r9 <= 0) goto L_0x004e
            goto L_0x0051
        L_0x004e:
            return r0
        L_0x004f:
            if (r9 >= 0) goto L_0x0053
        L_0x0051:
            long r9 = (long) r9
            long r0 = r0 + r9
        L_0x0053:
            return r0
        L_0x0054:
            if (r6 != 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r10 = 0
        L_0x0058:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r10)
        L_0x005b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.divide(long, long, java.math.RoundingMode):long");
    }

    public static int mod(long j, int i) {
        return (int) mod(j, (long) i);
    }

    public static long mod(long j, long j2) {
        if (j2 > 0) {
            long j3 = j % j2;
            return j3 >= 0 ? j3 : j3 + j2;
        }
        throw new ArithmeticException("Modulus must be positive");
    }

    public static long gcd(long j, long j2) {
        MathPreconditions.checkNonNegative("a", j);
        MathPreconditions.checkNonNegative("b", j2);
        if (j == 0) {
            return j2;
        }
        if (j2 == 0) {
            return j;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        long j3 = j >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j2);
        long j4 = j2 >> numberOfTrailingZeros2;
        while (j3 != j4) {
            long j5 = j3 - j4;
            long j6 = (j5 >> 63) & j5;
            long j7 = (j5 - j6) - j6;
            j4 += j6;
            j3 = j7 >> Long.numberOfTrailingZeros(j7);
        }
        return j3 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static long checkedAdd(long j, long j2) {
        long j3 = j + j2;
        boolean z = true;
        boolean z2 = (j ^ j2) < 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        MathPreconditions.checkNoOverflow(z2 | z, "checkedAdd", j, j2);
        return j3;
    }

    public static long checkedSubtract(long j, long j2) {
        long j3 = j - j2;
        boolean z = true;
        boolean z2 = (j ^ j2) >= 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        MathPreconditions.checkNoOverflow(z2 | z, "checkedSubtract", j, j2);
        return j3;
    }

    public static long checkedMultiply(long j, long j2) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j2);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        long j3 = j;
        long j4 = j2;
        MathPreconditions.checkNoOverflow(numberOfLeadingZeros >= 64, "checkedMultiply", j3, j4);
        long j5 = j4;
        long j6 = j3;
        int i = (j6 > 0 ? 1 : (j6 == 0 ? 0 : -1));
        MathPreconditions.checkNoOverflow((i >= 0) | (j5 != Long.MIN_VALUE), "checkedMultiply", j6, j5);
        long j7 = j6 * j5;
        MathPreconditions.checkNoOverflow(i == 0 || j7 / j6 == j5, "checkedMultiply", j6, j5);
        return j7;
    }

    public static long checkedPow(long j, int i) {
        long j2 = j;
        int i2 = i;
        MathPreconditions.checkNonNegative("exponent", i2);
        long j3 = 1;
        if ((j2 >= -2) && (j2 <= 2)) {
            int i3 = (int) j2;
            if (i3 == -2) {
                MathPreconditions.checkNoOverflow(i2 < 64, "checkedPow", j, (long) i2);
                return (i2 & 1) == 0 ? 1 << i2 : -1 << i2;
            } else if (i3 == -1) {
                return (i2 & 1) == 0 ? 1 : -1;
            } else {
                if (i3 != 0) {
                    if (i3 == 1) {
                        return 1;
                    }
                    if (i3 == 2) {
                        MathPreconditions.checkNoOverflow(i2 < 63, "checkedPow", j2, (long) i2);
                        return 1 << i2;
                    }
                    throw new AssertionError();
                } else if (i2 == 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        } else {
            long j4 = j;
            while (i2 != 0) {
                if (i2 == 1) {
                    return checkedMultiply(j3, j4);
                }
                if ((i2 & 1) != 0) {
                    j3 = checkedMultiply(j3, j4);
                }
                i2 >>= 1;
                if (i2 > 0) {
                    MathPreconditions.checkNoOverflow(-3037000499L <= j4 && j4 <= FLOOR_SQRT_MAX_LONG, "checkedPow", j4, (long) i2);
                    j4 *= j4;
                }
            }
            return j3;
        }
    }

    public static long saturatedMultiply(long j, long j2) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j2);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        long j3 = ((j ^ j2) >>> 63) + Long.MAX_VALUE;
        boolean z = true;
        boolean z2 = numberOfLeadingZeros < 64;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        boolean z3 = i < 0;
        if (j2 != Long.MIN_VALUE) {
            z = false;
        }
        if (!z2 && !(z & z3)) {
            long j4 = j * j2;
            if (i == 0 || j4 / j == j2) {
                return j4;
            }
        }
        return j3;
    }

    public static long saturatedPow(long j, int i) {
        MathPreconditions.checkNonNegative("exponent", i);
        long j2 = 1;
        if ((j >= -2) && (j <= 2)) {
            int i2 = (int) j;
            if (i2 != -2) {
                if (i2 == -1) {
                    return (i & 1) == 0 ? 1 : -1;
                }
                if (i2 != 0) {
                    if (i2 == 1) {
                        return 1;
                    }
                    if (i2 != 2) {
                        throw new AssertionError();
                    } else if (i >= 63) {
                        return Long.MAX_VALUE;
                    } else {
                        return 1 << i;
                    }
                } else if (i == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if (i >= 64) {
                return ((long) (i & 1)) + Long.MAX_VALUE;
            } else {
                return (i & 1) == 0 ? 1 << i : -1 << i;
            }
        } else {
            long j3 = ((j >>> 63) & ((long) (i & 1))) + Long.MAX_VALUE;
            while (i != 0) {
                if (i == 1) {
                    return saturatedMultiply(j2, j);
                }
                if ((i & 1) != 0) {
                    j2 = saturatedMultiply(j2, j);
                }
                i >>= 1;
                if (i > 0) {
                    if ((-3037000499L > j) || (j > FLOOR_SQRT_MAX_LONG)) {
                        return j3;
                    }
                    j *= j;
                }
            }
            return j2;
        }
    }

    public static long factorial(int i) {
        MathPreconditions.checkNonNegative("n", i);
        long[] jArr = factorials;
        if (i < jArr.length) {
            return jArr[i];
        }
        return Long.MAX_VALUE;
    }

    public static long binomial(int i, int i2) {
        MathPreconditions.checkNonNegative("n", i);
        MathPreconditions.checkNonNegative("k", i2);
        Preconditions.checkArgument(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        long j = 1;
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return (long) i;
        }
        long[] jArr = factorials;
        if (i < jArr.length) {
            return jArr[i] / (jArr[i2] * jArr[i - i2]);
        }
        int[] iArr = biggestBinomials;
        if (i2 >= iArr.length || i > iArr[i2]) {
            return Long.MAX_VALUE;
        }
        int[] iArr2 = biggestSimpleBinomials;
        if (i2 >= iArr2.length || i > iArr2[i2]) {
            long j2 = (long) i;
            int log2 = log2(j2, RoundingMode.CEILING);
            int i3 = i - 1;
            int i4 = log2;
            int i5 = 2;
            long j3 = j2;
            long j4 = 1;
            while (i5 <= i2) {
                i4 += log2;
                if (i4 < 63) {
                    j3 *= (long) i3;
                    j4 *= (long) i5;
                } else {
                    j = multiplyFraction(j, j3, j4);
                    j3 = (long) i3;
                    j4 = (long) i5;
                    i4 = log2;
                }
                i5++;
                i3--;
            }
            return multiplyFraction(j, j3, j4);
        }
        int i6 = i - 1;
        long j5 = (long) i;
        for (int i7 = 2; i7 <= i2; i7++) {
            j5 = (j5 * ((long) i6)) / ((long) i7);
            i6--;
        }
        return j5;
    }

    static long multiplyFraction(long j, long j2, long j3) {
        if (j == 1) {
            return j2 / j3;
        }
        long gcd = gcd(j, j3);
        return (j / gcd) * (j2 / (j3 / gcd));
    }

    public static boolean isPrime(long j) {
        if (j < 2) {
            MathPreconditions.checkNonNegative("n", j);
            return false;
        } else if (j < 66) {
            if (((722865708377213483 >> (((int) j) - 2)) & 1) != 0) {
                return true;
            }
            return false;
        } else if (((1 << ((int) (j % 30))) & SIEVE_30) != 0 || j % 7 == 0 || j % 11 == 0 || j % 13 == 0) {
            return false;
        } else {
            if (j < 289) {
                return true;
            }
            for (long[] jArr : millerRabinBaseSets) {
                if (j <= jArr[0]) {
                    for (int i = 1; i < jArr.length; i++) {
                        if (!MillerRabinTester.test(jArr[i], j)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            throw new AssertionError();
        }
    }

    private enum MillerRabinTester {
        SMALL {
            /* access modifiers changed from: package-private */
            public long mulMod(long j, long j2, long j3) {
                return (j * j2) % j3;
            }

            /* access modifiers changed from: package-private */
            public long squareMod(long j, long j2) {
                return (j * j) % j2;
            }
        },
        LARGE {
            private long plusMod(long j, long j2, long j3) {
                int i = (j > (j3 - j2) ? 1 : (j == (j3 - j2) ? 0 : -1));
                long j4 = j + j2;
                return i >= 0 ? j4 - j3 : j4;
            }

            private long times2ToThe32Mod(long j, long j2) {
                int i = 32;
                do {
                    int min = Math.min(i, Long.numberOfLeadingZeros(j));
                    j = UnsignedLongs.remainder(j << min, j2);
                    i -= min;
                } while (i > 0);
                return j;
            }

            /* access modifiers changed from: package-private */
            public long mulMod(long j, long j2, long j3) {
                long j4 = j3;
                long j5 = j >>> 32;
                long j6 = j2 >>> 32;
                long j7 = j & 4294967295L;
                long j8 = j2 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j5 * j6, j4) + (j5 * j8);
                if (times2ToThe32Mod < 0) {
                    times2ToThe32Mod = UnsignedLongs.remainder(times2ToThe32Mod, j4);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + (j6 * j7), j4), UnsignedLongs.remainder(j7 * j8, j4), j4);
            }

            /* access modifiers changed from: package-private */
            public long squareMod(long j, long j2) {
                long j3 = j >>> 32;
                long j4 = j & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j3 * j3, j2);
                long j5 = j3 * j4 * 2;
                if (j5 < 0) {
                    j5 = UnsignedLongs.remainder(j5, j2);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + j5, j2), UnsignedLongs.remainder(j4 * j4, j2), j2);
            }
        };

        /* access modifiers changed from: package-private */
        public abstract long mulMod(long j, long j2, long j3);

        /* access modifiers changed from: package-private */
        public abstract long squareMod(long j, long j2);

        static boolean test(long j, long j2) {
            return (j2 <= LongMath.FLOOR_SQRT_MAX_LONG ? SMALL : LARGE).testWitness(j, j2);
        }

        private long powMod(long j, long j2, long j3) {
            long j4 = j;
            long j5 = 1;
            while (j2 != 0) {
                long j6 = j3;
                if ((j2 & 1) != 0) {
                    j5 = mulMod(j5, j4, j6);
                }
                j4 = squareMod(j4, j6);
                j2 >>= 1;
                j3 = j6;
            }
            return j5;
        }

        private boolean testWitness(long j, long j2) {
            long j3 = j2 - 1;
            int numberOfTrailingZeros = Long.numberOfTrailingZeros(j3);
            long j4 = j3 >> numberOfTrailingZeros;
            long j5 = j % j2;
            if (j5 == 0) {
                return true;
            }
            long j6 = j2;
            long powMod = powMod(j5, j4, j6);
            if (powMod == 1) {
                return true;
            }
            int i = 0;
            while (powMod != j3) {
                i++;
                if (i == numberOfTrailingZeros) {
                    return false;
                }
                powMod = squareMod(powMod, j6);
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0088 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static double roundToDouble(long r19, java.math.RoundingMode r21) {
        /*
            r0 = r19
            double r2 = (double) r0
            long r4 = (long) r2
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x000f
            r8 = -1
            goto L_0x0013
        L_0x000f:
            int r8 = com.google.common.primitives.Longs.compare(r0, r4)
        L_0x0013:
            int[] r9 = com.google.common.math.LongMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r10 = r21.ordinal()
            r9 = r9[r10]
            java.lang.String r10 = "impossible"
            r11 = 0
            switch(r9) {
                case 1: goto L_0x00c2;
                case 2: goto L_0x00ae;
                case 3: goto L_0x00a6;
                case 4: goto L_0x0092;
                case 5: goto L_0x008a;
                case 6: goto L_0x0028;
                case 7: goto L_0x0028;
                case 8: goto L_0x0028;
                default: goto L_0x0022;
            }
        L_0x0022:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>(r10)
            throw r0
        L_0x0028:
            if (r8 < 0) goto L_0x0034
            double r8 = java.lang.Math.nextUp(r2)
            double r13 = java.lang.Math.ceil(r8)
            long r13 = (long) r13
            goto L_0x0047
        L_0x0034:
            double r8 = com.google.common.math.DoubleUtils.nextDown(r2)
            double r13 = java.lang.Math.floor(r8)
            long r13 = (long) r13
            r17 = r8
            r8 = r2
            r2 = r17
            r17 = r13
            r13 = r4
            r4 = r17
        L_0x0047:
            long r4 = r0 - r4
            long r15 = r13 - r0
            int r6 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            r13 = 1
            if (r6 != 0) goto L_0x0052
            long r15 = r15 + r13
        L_0x0052:
            r6 = r15
            int r4 = com.google.common.primitives.Longs.compare(r4, r6)
            if (r4 >= 0) goto L_0x005a
            goto L_0x0088
        L_0x005a:
            if (r4 <= 0) goto L_0x005d
            goto L_0x0089
        L_0x005d:
            int[] r4 = com.google.common.math.LongMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r5 = r21.ordinal()
            r4 = r4[r5]
            r5 = 6
            if (r4 == r5) goto L_0x0084
            r5 = 7
            if (r4 == r5) goto L_0x007f
            r0 = 8
            if (r4 != r0) goto L_0x0079
            long r0 = com.google.common.math.DoubleUtils.getSignificand(r2)
            long r0 = r0 & r13
            int r0 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x0089
            goto L_0x0088
        L_0x0079:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>(r10)
            throw r0
        L_0x007f:
            int r0 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r0 < 0) goto L_0x0088
            goto L_0x0089
        L_0x0084:
            int r0 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r0 < 0) goto L_0x0089
        L_0x0088:
            return r2
        L_0x0089:
            return r8
        L_0x008a:
            if (r8 > 0) goto L_0x008d
            goto L_0x00bc
        L_0x008d:
            double r0 = java.lang.Math.nextUp(r2)
            return r0
        L_0x0092:
            int r0 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r0 < 0) goto L_0x009e
            if (r8 > 0) goto L_0x0099
            goto L_0x00bc
        L_0x0099:
            double r0 = java.lang.Math.nextUp(r2)
            return r0
        L_0x009e:
            if (r8 < 0) goto L_0x00a1
            goto L_0x00bc
        L_0x00a1:
            double r0 = com.google.common.math.DoubleUtils.nextDown(r2)
            return r0
        L_0x00a6:
            if (r8 < 0) goto L_0x00a9
            goto L_0x00bc
        L_0x00a9:
            double r0 = com.google.common.math.DoubleUtils.nextDown(r2)
            return r0
        L_0x00ae:
            int r0 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r0 < 0) goto L_0x00ba
            if (r8 < 0) goto L_0x00b5
            goto L_0x00bc
        L_0x00b5:
            double r0 = com.google.common.math.DoubleUtils.nextDown(r2)
            return r0
        L_0x00ba:
            if (r8 > 0) goto L_0x00bd
        L_0x00bc:
            return r2
        L_0x00bd:
            double r0 = java.lang.Math.nextUp(r2)
            return r0
        L_0x00c2:
            if (r8 != 0) goto L_0x00c6
            r0 = 1
            goto L_0x00c7
        L_0x00c6:
            r0 = 0
        L_0x00c7:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.roundToDouble(long, java.math.RoundingMode):double");
    }

    private LongMath() {
    }
}
