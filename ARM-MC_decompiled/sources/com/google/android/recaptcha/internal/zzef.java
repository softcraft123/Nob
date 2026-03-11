package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzef implements zzcn {
    private final zzdt zza;
    private zzcm zzb = zzcm.zza;
    private zzsc zzc;

    public zzef(zzdt zzdt) {
        this.zza = zzdt;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009e A[Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b6 A[Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(java.lang.String r17, com.google.android.recaptcha.RecaptchaAction r18, long r19, kotlin.coroutines.Continuation r21) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r21
            boolean r3 = r2 instanceof com.google.android.recaptcha.internal.zzed
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.google.android.recaptcha.internal.zzed r3 = (com.google.android.recaptcha.internal.zzed) r3
            int r4 = r3.zzd
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.zzd = r4
            goto L_0x001e
        L_0x0019:
            com.google.android.recaptcha.internal.zzed r3 = new com.google.android.recaptcha.internal.zzed
            r3.<init>(r1, r2)
        L_0x001e:
            r9 = r3
            java.lang.Object r2 = r9.zzb
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r9.zzd
            r5 = 2
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x005f
            if (r4 == r6) goto L_0x0047
            if (r4 != r5) goto L_0x003f
            java.lang.String r0 = r9.zzf
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.recaptcha.internal.zzef r3 = r9.zze
            r4 = r3
            com.google.android.recaptcha.internal.zzef r4 = (com.google.android.recaptcha.internal.zzef) r4
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            goto L_0x00b8
        L_0x003f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0047:
            double r10 = r9.zza
            com.google.android.recaptcha.RecaptchaAction r0 = r9.zzg
            r4 = r0
            com.google.android.recaptcha.RecaptchaAction r4 = (com.google.android.recaptcha.RecaptchaAction) r4
            java.lang.String r4 = r9.zzf
            r6 = r4
            java.lang.String r6 = (java.lang.String) r6
            com.google.android.recaptcha.internal.zzef r6 = r9.zze
            r8 = r6
            com.google.android.recaptcha.internal.zzef r8 = (com.google.android.recaptcha.internal.zzef) r8
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            r11 = r10
            r10 = r6
            r6 = r4
            goto L_0x0096
        L_0x005f:
            kotlin.ResultKt.throwOnFailure(r2)
            com.google.android.recaptcha.internal.zzcm r2 = r1.zzb     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            com.google.android.recaptcha.internal.zzcj r4 = com.google.android.recaptcha.internal.zzcm.zzb     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            if (r2 == 0) goto L_0x00c5
            r10 = r19
            double r10 = (double) r10     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            com.google.android.recaptcha.internal.zzdt r2 = r1.zza     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            r12 = 4601778099247172813(0x3fdccccccccccccd, double:0.45)
            double r12 = r12 * r10
            r9.zze = r1     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            r9.zzf = r0     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            r4 = r18
            r9.zzg = r4     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            r14 = 4603129179135383962(0x3fe199999999999a, double:0.55)
            double r10 = r10 * r14
            r9.zza = r10     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            r9.zzd = r6     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            long r12 = (long) r12     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            java.lang.Object r2 = r2.zzl(r0, r12, r9)     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            if (r2 == r3) goto L_0x00c4
            r6 = r0
            r0 = r4
            r11 = r10
            r10 = r1
        L_0x0096:
            com.google.android.recaptcha.internal.zzsi r2 = (com.google.android.recaptcha.internal.zzsi) r2     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            com.google.android.recaptcha.internal.zzdt r4 = r10.zza     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            com.google.android.recaptcha.internal.zzsc r8 = r10.zzc     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            if (r8 != 0) goto L_0x009f
            r8 = r7
        L_0x009f:
            com.google.android.recaptcha.internal.zzsp r0 = r4.zzi(r0, r2, r8)     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            com.google.android.recaptcha.internal.zzdt r4 = r10.zza     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            long r11 = (long) r11     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            r9.zze = r10     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            r9.zzf = r6     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            r9.zzg = r7     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            r9.zzd = r5     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            r5 = r0
            r7 = r11
            java.lang.Object r2 = r4.zzm(r5, r6, r7, r9)     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            if (r2 == r3) goto L_0x00c4
            r0 = r6
            r3 = r10
        L_0x00b8:
            com.google.android.recaptcha.internal.zzsr r2 = (com.google.android.recaptcha.internal.zzsr) r2     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            com.google.android.recaptcha.internal.zzdt r3 = r3.zza     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            r3.zzq(r0, r2)     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            java.lang.String r0 = r2.zzj()     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            return r0
        L_0x00c4:
            return r3
        L_0x00c5:
            com.google.android.recaptcha.internal.zzbd r0 = new com.google.android.recaptcha.internal.zzbd     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            com.google.android.recaptcha.internal.zzbb r2 = com.google.android.recaptcha.internal.zzbb.zzb     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            com.google.android.recaptcha.internal.zzba r3 = com.google.android.recaptcha.internal.zzba.zzar     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            r0.<init>(r2, r3, r7)     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
            throw r0     // Catch:{ zzbd -> 0x00de, Exception -> 0x00cf }
        L_0x00cf:
            r0 = move-exception
            com.google.android.recaptcha.internal.zzbd r2 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r3 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r4 = com.google.android.recaptcha.internal.zzba.zzaz
            java.lang.String r0 = r0.getMessage()
            r2.<init>(r3, r4, r0)
            throw r2
        L_0x00de:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzef.zza(java.lang.String, com.google.android.recaptcha.RecaptchaAction, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a1, code lost:
        if (r11.zza.zzn(r2, (long) r12, r0) == r1) goto L_0x00ae;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzb(long r11, kotlin.coroutines.Continuation r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.google.android.recaptcha.internal.zzee
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.google.android.recaptcha.internal.zzee r0 = (com.google.android.recaptcha.internal.zzee) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzd = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzee r0 = new com.google.android.recaptcha.internal.zzee
            r0.<init>(r10, r13)
        L_0x0018:
            java.lang.Object r13 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzd
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004f
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            com.google.android.recaptcha.internal.zzef r11 = r0.zze
            r12 = r11
            com.google.android.recaptcha.internal.zzef r12 = (com.google.android.recaptcha.internal.zzef) r12
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ zzbd -> 0x0032 }
            goto L_0x00a3
        L_0x0032:
            r12 = move-exception
            goto L_0x00b2
        L_0x0035:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003d:
            double r11 = r0.zza
            com.google.android.recaptcha.internal.zzef r2 = r0.zze
            r4 = r2
            com.google.android.recaptcha.internal.zzef r4 = (com.google.android.recaptcha.internal.zzef) r4
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ zzbd -> 0x004c }
            r9 = r2
            r2 = r13
            r12 = r11
            r11 = r9
            goto L_0x0092
        L_0x004c:
            r12 = move-exception
            r11 = r2
            goto L_0x00b2
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r13)
            com.google.android.recaptcha.internal.zzcm r13 = r10.zzb
            com.google.android.recaptcha.internal.zzcj r2 = com.google.android.recaptcha.internal.zzcm.zzb
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r2)
            if (r13 != 0) goto L_0x00bb
            com.google.android.recaptcha.internal.zzcm r13 = r10.zzb
            com.google.android.recaptcha.internal.zzci r2 = com.google.android.recaptcha.internal.zzcm.zzd
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r2)
            if (r13 == 0) goto L_0x006b
            goto L_0x00bb
        L_0x006b:
            com.google.android.recaptcha.internal.zzck r13 = com.google.android.recaptcha.internal.zzcm.zzc
            com.google.android.recaptcha.internal.zzcm r13 = (com.google.android.recaptcha.internal.zzcm) r13
            r10.zzb = r13
            double r11 = (double) r11
            com.google.android.recaptcha.internal.zzdt r13 = r10.zza     // Catch:{ zzbd -> 0x00af }
            r5 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            double r5 = r5 * r11
            r0.zze = r10     // Catch:{ zzbd -> 0x00af }
            r7 = 4600877379321698714(0x3fd999999999999a, double:0.4)
            double r11 = r11 * r7
            r0.zza = r11     // Catch:{ zzbd -> 0x00af }
            r0.zzd = r4     // Catch:{ zzbd -> 0x00af }
            long r4 = (long) r5     // Catch:{ zzbd -> 0x00af }
            java.lang.Object r13 = r13.zzo(r4, r0)     // Catch:{ zzbd -> 0x00af }
            if (r13 == r1) goto L_0x00ae
            r2 = r13
            r12 = r11
            r11 = r10
        L_0x0092:
            com.google.android.recaptcha.internal.zzsc r2 = (com.google.android.recaptcha.internal.zzsc) r2     // Catch:{ zzbd -> 0x0032 }
            r11.zzc = r2     // Catch:{ zzbd -> 0x0032 }
            com.google.android.recaptcha.internal.zzdt r4 = r11.zza     // Catch:{ zzbd -> 0x0032 }
            long r12 = (long) r12     // Catch:{ zzbd -> 0x0032 }
            r0.zze = r11     // Catch:{ zzbd -> 0x0032 }
            r0.zzd = r3     // Catch:{ zzbd -> 0x0032 }
            java.lang.Object r12 = r4.zzn(r2, r12, r0)     // Catch:{ zzbd -> 0x0032 }
            if (r12 == r1) goto L_0x00ae
        L_0x00a3:
            com.google.android.recaptcha.internal.zzcj r12 = com.google.android.recaptcha.internal.zzcm.zzb     // Catch:{ zzbd -> 0x0032 }
            com.google.android.recaptcha.internal.zzcm r12 = (com.google.android.recaptcha.internal.zzcm) r12     // Catch:{ zzbd -> 0x0032 }
            r11.zzb = r12     // Catch:{ zzbd -> 0x0032 }
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00ae:
            return r1
        L_0x00af:
            r11 = move-exception
            r12 = r11
            r11 = r10
        L_0x00b2:
            com.google.android.recaptcha.internal.zzci r13 = com.google.android.recaptcha.internal.zzcm.zzd
            com.google.android.recaptcha.internal.zzcm r13 = (com.google.android.recaptcha.internal.zzcm) r13
            r11.zzb = r13
            throw r12
        L_0x00bb:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzef.zzb(long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
