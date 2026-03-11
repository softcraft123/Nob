package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzbq {
    public static final zzbq zza = new zzbq();

    private zzbq() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ae, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r7, r1) != r3) goto L_0x003f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0083 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(kotlin.jvm.functions.Function1 r18, long r19, long r21, double r23, kotlin.jvm.functions.Function1 r25, kotlin.coroutines.Continuation r26) {
        /*
            r17 = this;
            r0 = r26
            boolean r1 = r0 instanceof com.google.android.recaptcha.internal.zzbp
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.google.android.recaptcha.internal.zzbp r1 = (com.google.android.recaptcha.internal.zzbp) r1
            int r2 = r1.zzh
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.zzh = r2
            r2 = r17
            goto L_0x001e
        L_0x0017:
            com.google.android.recaptcha.internal.zzbp r1 = new com.google.android.recaptcha.internal.zzbp
            r2 = r17
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.zzf
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.zzh
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x0062
            if (r4 == r6) goto L_0x004e
            if (r4 != r5) goto L_0x0046
            long r7 = r1.zzd
            double r9 = r1.zze
            long r11 = r1.zzc
            java.lang.Object r4 = r1.zzb
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r13 = r1.zza
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            kotlin.ResultKt.throwOnFailure(r0)
        L_0x003f:
            r15 = r13
            r13 = r1
            r1 = r15
            r15 = r11
            r11 = r9
            r9 = r15
            goto L_0x0070
        L_0x0046:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004e:
            long r7 = r1.zzd
            double r9 = r1.zze
            long r11 = r1.zzc
            java.lang.Object r4 = r1.zzb
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r13 = r1.zza
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x0060 }
            return r0
        L_0x0060:
            r0 = move-exception
            goto L_0x008b
        L_0x0062:
            kotlin.ResultKt.throwOnFailure(r0)
            r7 = r19
            r9 = r21
            r11 = r23
            r4 = r25
            r13 = r1
            r1 = r18
        L_0x0070:
            r13.zza = r1     // Catch:{ Exception -> 0x0084 }
            r13.zzb = r4     // Catch:{ Exception -> 0x0084 }
            r13.zzc = r9     // Catch:{ Exception -> 0x0084 }
            r13.zze = r11     // Catch:{ Exception -> 0x0084 }
            r13.zzd = r7     // Catch:{ Exception -> 0x0084 }
            r13.zzh = r6     // Catch:{ Exception -> 0x0084 }
            java.lang.Object r0 = r4.invoke(r13)     // Catch:{ Exception -> 0x0084 }
            if (r0 != r3) goto L_0x0083
            goto L_0x00b1
        L_0x0083:
            return r0
        L_0x0084:
            r0 = move-exception
            r15 = r13
            r13 = r1
            r1 = r15
            r15 = r11
            r11 = r9
            r9 = r15
        L_0x008b:
            java.lang.Object r14 = r13.invoke(r0)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x00b2
            double r7 = (double) r7
            double r7 = r7 * r9
            long r7 = (long) r7
            long r7 = kotlin.ranges.RangesKt.coerceAtMost((long) r7, (long) r11)
            r1.zza = r13
            r1.zzb = r4
            r1.zzc = r11
            r1.zze = r9
            r1.zzd = r7
            r1.zzh = r5
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.delay(r7, r1)
            if (r0 == r3) goto L_0x00b1
            goto L_0x003f
        L_0x00b1:
            return r3
        L_0x00b2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbq.zza(kotlin.jvm.functions.Function1, long, long, double, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
