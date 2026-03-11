package com.google.common.math;

import java.lang.Comparable;
import java.lang.Number;
import java.math.RoundingMode;

@ElementTypesAreNonnullByDefault
abstract class ToDoubleRounder<X extends Number & Comparable<X>> {
    /* access modifiers changed from: package-private */
    public abstract X minus(X x, X x2);

    /* access modifiers changed from: package-private */
    public abstract double roundToDoubleArbitrarily(X x);

    /* access modifiers changed from: package-private */
    public abstract int sign(X x);

    /* access modifiers changed from: package-private */
    public abstract X toX(double d, RoundingMode roundingMode);

    ToDoubleRounder() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final double roundToDouble(X r13, java.math.RoundingMode r14) {
        /*
            r12 = this;
            java.lang.String r0 = "x"
            com.google.common.base.Preconditions.checkNotNull(r13, r0)
            java.lang.String r0 = "mode"
            com.google.common.base.Preconditions.checkNotNull(r14, r0)
            double r0 = r12.roundToDoubleArbitrarily(r13)
            boolean r2 = java.lang.Double.isInfinite(r0)
            r3 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            r5 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            if (r2 == 0) goto L_0x005a
            int[] r2 = com.google.common.math.ToDoubleRounder.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r7 = r14.ordinal()
            r2 = r2[r7]
            r7 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            switch(r2) {
                case 1: goto L_0x0053;
                case 2: goto L_0x0053;
                case 3: goto L_0x0053;
                case 4: goto L_0x0053;
                case 5: goto L_0x004d;
                case 6: goto L_0x0042;
                case 7: goto L_0x012d;
                case 8: goto L_0x0029;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x005a
        L_0x0029:
            java.lang.ArithmeticException r14 = new java.lang.ArithmeticException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r13 = r0.append(r13)
            java.lang.String r0 = " cannot be represented precisely as a double"
            java.lang.StringBuilder r13 = r13.append(r0)
            java.lang.String r13 = r13.toString()
            r14.<init>(r13)
            throw r14
        L_0x0042:
            int r13 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r13 != 0) goto L_0x0047
            return r5
        L_0x0047:
            r13 = -4503599627370497(0xffefffffffffffff, double:-1.7976931348623157E308)
            return r13
        L_0x004d:
            int r13 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r13 != 0) goto L_0x0052
            return r7
        L_0x0052:
            return r3
        L_0x0053:
            int r13 = r12.sign(r13)
            double r13 = (double) r13
            double r13 = r13 * r7
            return r13
        L_0x005a:
            java.math.RoundingMode r2 = java.math.RoundingMode.UNNECESSARY
            java.lang.Number r2 = r12.toX(r0, r2)
            r7 = r13
            java.lang.Comparable r7 = (java.lang.Comparable) r7
            int r7 = r7.compareTo(r2)
            int[] r8 = com.google.common.math.ToDoubleRounder.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r9 = r14.ordinal()
            r8 = r8[r9]
            java.lang.String r9 = "impossible"
            switch(r8) {
                case 1: goto L_0x011d;
                case 2: goto L_0x00ad;
                case 3: goto L_0x00ad;
                case 4: goto L_0x00ad;
                case 5: goto L_0x00a4;
                case 6: goto L_0x009b;
                case 7: goto L_0x0083;
                case 8: goto L_0x007a;
                default: goto L_0x0074;
            }
        L_0x0074:
            java.lang.AssertionError r13 = new java.lang.AssertionError
            r13.<init>(r9)
            throw r13
        L_0x007a:
            if (r7 != 0) goto L_0x007e
            r13 = 1
            goto L_0x007f
        L_0x007e:
            r13 = 0
        L_0x007f:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r13)
            return r0
        L_0x0083:
            int r13 = r12.sign(r13)
            if (r13 < 0) goto L_0x0092
            if (r7 > 0) goto L_0x008d
            goto L_0x012d
        L_0x008d:
            double r13 = java.lang.Math.nextUp(r0)
            return r13
        L_0x0092:
            if (r7 < 0) goto L_0x0096
            goto L_0x012d
        L_0x0096:
            double r13 = com.google.common.math.DoubleUtils.nextDown(r0)
            return r13
        L_0x009b:
            if (r7 > 0) goto L_0x009f
            goto L_0x012d
        L_0x009f:
            double r13 = java.lang.Math.nextUp(r0)
            return r13
        L_0x00a4:
            if (r7 < 0) goto L_0x00a8
            goto L_0x012d
        L_0x00a8:
            double r13 = com.google.common.math.DoubleUtils.nextDown(r0)
            return r13
        L_0x00ad:
            if (r7 < 0) goto L_0x00c0
            double r3 = java.lang.Math.nextUp(r0)
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x00b9
            goto L_0x012d
        L_0x00b9:
            java.math.RoundingMode r5 = java.math.RoundingMode.CEILING
            java.lang.Number r5 = r12.toX(r3, r5)
            goto L_0x00d5
        L_0x00c0:
            double r5 = com.google.common.math.DoubleUtils.nextDown(r0)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x00ca
            goto L_0x012d
        L_0x00ca:
            java.math.RoundingMode r3 = java.math.RoundingMode.FLOOR
            java.lang.Number r3 = r12.toX(r5, r3)
            r10 = r5
            r5 = r2
            r2 = r3
            r3 = r0
            r0 = r10
        L_0x00d5:
            java.lang.Number r2 = r12.minus(r13, r2)
            java.lang.Number r5 = r12.minus(r5, r13)
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r2 = r2.compareTo(r5)
            if (r2 >= 0) goto L_0x00e6
            goto L_0x011b
        L_0x00e6:
            if (r2 <= 0) goto L_0x00e9
            goto L_0x011c
        L_0x00e9:
            int[] r2 = com.google.common.math.ToDoubleRounder.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r14 = r14.ordinal()
            r14 = r2[r14]
            r2 = 2
            if (r14 == r2) goto L_0x010e
            r2 = 3
            if (r14 == r2) goto L_0x0107
            r2 = 4
            if (r14 != r2) goto L_0x0101
            int r13 = r12.sign(r13)
            if (r13 < 0) goto L_0x011b
            goto L_0x011c
        L_0x0101:
            java.lang.AssertionError r13 = new java.lang.AssertionError
            r13.<init>(r9)
            throw r13
        L_0x0107:
            int r13 = r12.sign(r13)
            if (r13 < 0) goto L_0x011c
            goto L_0x011b
        L_0x010e:
            long r13 = java.lang.Double.doubleToRawLongBits(r0)
            r5 = 1
            long r13 = r13 & r5
            r5 = 0
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 != 0) goto L_0x011c
        L_0x011b:
            return r0
        L_0x011c:
            return r3
        L_0x011d:
            int r13 = r12.sign(r13)
            if (r13 < 0) goto L_0x012b
            if (r7 < 0) goto L_0x0126
            goto L_0x012d
        L_0x0126:
            double r13 = com.google.common.math.DoubleUtils.nextDown(r0)
            return r13
        L_0x012b:
            if (r7 > 0) goto L_0x012e
        L_0x012d:
            return r0
        L_0x012e:
            double r13 = java.lang.Math.nextUp(r0)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.ToDoubleRounder.roundToDouble(java.lang.Number, java.math.RoundingMode):double");
    }

    /* renamed from: com.google.common.math.ToDoubleRounder$1  reason: invalid class name */
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
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.ToDoubleRounder.AnonymousClass1.<clinit>():void");
        }
    }
}
