package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public abstract class zze {
    private boolean zza;

    /* access modifiers changed from: protected */
    public zzen zza(String str) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public zzen zzb() {
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e4, code lost:
        if (r0 != r5) goto L_0x00e7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009f A[Catch:{ Exception -> 0x00a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzc(java.lang.String r19, long r20, kotlin.coroutines.Continuation r22) throws com.google.android.recaptcha.internal.zzbd {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r3 = r20
            r0 = r22
            boolean r5 = r0 instanceof com.google.android.recaptcha.internal.zza
            if (r5 == 0) goto L_0x001b
            r5 = r0
            com.google.android.recaptcha.internal.zza r5 = (com.google.android.recaptcha.internal.zza) r5
            int r6 = r5.zze
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = r6 & r7
            if (r8 == 0) goto L_0x001b
            int r6 = r6 - r7
            r5.zze = r6
            goto L_0x0020
        L_0x001b:
            com.google.android.recaptcha.internal.zza r5 = new com.google.android.recaptcha.internal.zza
            r5.<init>(r1, r0)
        L_0x0020:
            r11 = r5
            java.lang.Object r0 = r11.zzc
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r11.zze
            r12 = 3
            r7 = 2
            r8 = 1
            r13 = 0
            if (r6 == 0) goto L_0x0073
            if (r6 == r8) goto L_0x0050
            if (r6 == r7) goto L_0x0042
            if (r6 != r12) goto L_0x003a
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00e7
        L_0x003a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0042:
            java.lang.String r2 = r11.zzf
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r3 = r11.zza
            com.google.android.recaptcha.internal.zze r3 = (com.google.android.recaptcha.internal.zze) r3
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00d8
        L_0x0050:
            long r2 = r11.zzb
            com.google.android.recaptcha.internal.zzen r4 = r11.zzg
            r6 = r4
            com.google.android.recaptcha.internal.zzen r6 = (com.google.android.recaptcha.internal.zzen) r6
            java.lang.String r6 = r11.zzf
            r8 = r6
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r11.zza
            com.google.android.recaptcha.internal.zze r8 = (com.google.android.recaptcha.internal.zze) r8
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x006a }
            r16 = r6
            r6 = r4
            r3 = r2
            r2 = r16
            goto L_0x0092
        L_0x006a:
            r0 = move-exception
            r16 = r2
            r2 = r6
        L_0x006e:
            r6 = r8
            r8 = r16
            r10 = r0
            goto L_0x00b1
        L_0x0073:
            kotlin.ResultKt.throwOnFailure(r0)
            com.google.android.recaptcha.internal.zzen r6 = r18.zza(r19)
            com.google.android.recaptcha.internal.zzb r0 = new com.google.android.recaptcha.internal.zzb     // Catch:{ Exception -> 0x00ac }
            r0.<init>(r1, r2, r13)     // Catch:{ Exception -> 0x00ac }
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0     // Catch:{ Exception -> 0x00ac }
            r11.zza = r1     // Catch:{ Exception -> 0x00ac }
            r11.zzf = r2     // Catch:{ Exception -> 0x00ac }
            r11.zzg = r6     // Catch:{ Exception -> 0x00ac }
            r11.zzb = r3     // Catch:{ Exception -> 0x00ac }
            r11.zze = r8     // Catch:{ Exception -> 0x00ac }
            java.lang.Object r0 = kotlinx.coroutines.TimeoutKt.withTimeout(r3, r0, r11)     // Catch:{ Exception -> 0x00ac }
            if (r0 == r5) goto L_0x00ec
            r8 = r1
        L_0x0092:
            kotlin.Result r0 = (kotlin.Result) r0     // Catch:{ Exception -> 0x00a7 }
            java.lang.Object r0 = r0.m525unboximpl()     // Catch:{ Exception -> 0x00a7 }
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x00a7 }
            com.google.android.recaptcha.internal.zzsi r0 = (com.google.android.recaptcha.internal.zzsi) r0     // Catch:{ Exception -> 0x00a7 }
            if (r6 == 0) goto L_0x00a2
            r6.zza()     // Catch:{ Exception -> 0x00a7 }
        L_0x00a2:
            java.lang.Object r0 = kotlin.Result.m516constructorimpl(r0)     // Catch:{ Exception -> 0x00a7 }
            return r0
        L_0x00a7:
            r0 = move-exception
            r16 = r3
            r4 = r6
            goto L_0x006e
        L_0x00ac:
            r0 = move-exception
            r10 = r0
            r8 = r3
            r4 = r6
            r6 = r1
        L_0x00b1:
            com.google.android.recaptcha.internal.zzbd r0 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r3 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r14 = com.google.android.recaptcha.internal.zzba.zzaa
            java.lang.String r15 = r10.getMessage()
            r0.<init>(r3, r14, r15)
            com.google.android.recaptcha.internal.zzbd r0 = com.google.android.recaptcha.internal.zzf.zza(r10, r0)
            if (r4 == 0) goto L_0x00c7
            r4.zzb(r0)
        L_0x00c7:
            r11.zza = r6
            r11.zzf = r2
            r11.zzg = r13
            r11.zze = r7
            r7 = r2
            java.lang.Object r0 = r6.zzi(r7, r8, r10, r11)
            if (r0 == r5) goto L_0x00ec
            r3 = r6
            r2 = r7
        L_0x00d8:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            r11.zza = r13
            r11.zzf = r13
            r11.zze = r12
            java.lang.Object r0 = r3.zzd(r2, r11)
            if (r0 != r5) goto L_0x00e7
            goto L_0x00ec
        L_0x00e7:
            java.lang.Object r0 = kotlin.Result.m516constructorimpl(r0)
            return r0
        L_0x00ec:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zze.zzc(java.lang.String, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public abstract Object zzd(String str, Continuation continuation);

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b0, code lost:
        if (r11 == r1) goto L_0x00d4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0097 A[Catch:{ Exception -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zze(long r8, com.google.android.recaptcha.internal.zzsc r10, kotlin.coroutines.Continuation r11) throws com.google.android.recaptcha.internal.zzbd {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.google.android.recaptcha.internal.zzc
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.google.android.recaptcha.internal.zzc r0 = (com.google.android.recaptcha.internal.zzc) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzd = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzc r0 = new com.google.android.recaptcha.internal.zzc
            r0.<init>(r7, r11)
        L_0x0018:
            java.lang.Object r11 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzd
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x005a
            if (r2 == r6) goto L_0x004b
            if (r2 == r5) goto L_0x003d
            if (r2 != r4) goto L_0x0035
            java.lang.Object r8 = r0.zza
            com.google.android.recaptcha.internal.zzbd r8 = (com.google.android.recaptcha.internal.zzbd) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c7
        L_0x0035:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003d:
            com.google.android.recaptcha.internal.zzen r8 = r0.zze
            r9 = r8
            com.google.android.recaptcha.internal.zzen r9 = (com.google.android.recaptcha.internal.zzen) r9
            java.lang.Object r9 = r0.zza
            com.google.android.recaptcha.internal.zze r9 = (com.google.android.recaptcha.internal.zze) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00b2
        L_0x004b:
            com.google.android.recaptcha.internal.zzen r8 = r0.zze
            r9 = r8
            com.google.android.recaptcha.internal.zzen r9 = (com.google.android.recaptcha.internal.zzen) r9
            java.lang.Object r9 = r0.zza
            com.google.android.recaptcha.internal.zze r9 = (com.google.android.recaptcha.internal.zze) r9
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ Exception -> 0x0058 }
            goto L_0x0088
        L_0x0058:
            r10 = move-exception
            goto L_0x00a3
        L_0x005a:
            kotlin.ResultKt.throwOnFailure(r11)
            com.google.android.recaptcha.internal.zzen r11 = r7.zzb()
            boolean r2 = r7.zza
            if (r2 == 0) goto L_0x0071
            r11.zza()
            kotlin.Result$Companion r8 = kotlin.Result.Companion
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            java.lang.Object r8 = kotlin.Result.m516constructorimpl(r8)
            return r8
        L_0x0071:
            com.google.android.recaptcha.internal.zzd r2 = new com.google.android.recaptcha.internal.zzd     // Catch:{ Exception -> 0x009f }
            r2.<init>(r7, r10, r3)     // Catch:{ Exception -> 0x009f }
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ Exception -> 0x009f }
            r0.zza = r7     // Catch:{ Exception -> 0x009f }
            r0.zze = r11     // Catch:{ Exception -> 0x009f }
            r0.zzd = r6     // Catch:{ Exception -> 0x009f }
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.withTimeout(r8, r2, r0)     // Catch:{ Exception -> 0x009f }
            if (r8 == r1) goto L_0x00d4
            r9 = r11
            r11 = r8
            r8 = r9
            r9 = r7
        L_0x0088:
            kotlin.Result r11 = (kotlin.Result) r11     // Catch:{ Exception -> 0x0058 }
            java.lang.Object r10 = r11.m525unboximpl()     // Catch:{ Exception -> 0x0058 }
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ Exception -> 0x0058 }
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0058 }
            r9.zza = r6     // Catch:{ Exception -> 0x0058 }
            if (r8 == 0) goto L_0x009a
            r8.zza()     // Catch:{ Exception -> 0x0058 }
        L_0x009a:
            java.lang.Object r8 = kotlin.Result.m516constructorimpl(r10)     // Catch:{ Exception -> 0x0058 }
            return r8
        L_0x009f:
            r8 = move-exception
            r10 = r8
            r9 = r7
            r8 = r11
        L_0x00a3:
            r11 = 0
            r9.zza = r11
            r0.zza = r9
            r0.zze = r8
            r0.zzd = r5
            java.lang.Object r11 = r9.zzj(r10, r0)
            if (r11 == r1) goto L_0x00d4
        L_0x00b2:
            r10 = r11
            com.google.android.recaptcha.internal.zzbd r10 = (com.google.android.recaptcha.internal.zzbd) r10
            if (r8 == 0) goto L_0x00ba
            r8.zzb(r10)
        L_0x00ba:
            r0.zza = r10
            r0.zze = r3
            r0.zzd = r4
            java.lang.Object r8 = r9.zzg(r10, r0)
            if (r8 == r1) goto L_0x00d4
            r8 = r10
        L_0x00c7:
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m516constructorimpl(r8)
            return r8
        L_0x00d4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zze.zze(long, com.google.android.recaptcha.internal.zzsc, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public abstract Object zzf(String str, Continuation continuation) throws zzbd;

    /* access modifiers changed from: protected */
    public Object zzg(zzbd zzbd, Continuation continuation) {
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzh(zzsc zzsc, Continuation continuation) throws zzbd;

    /* access modifiers changed from: protected */
    public Object zzi(String str, long j, Exception exc, Continuation continuation) {
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public Object zzj(Exception exc, Continuation continuation) {
        return zzf.zza(exc, new zzbd(zzbb.zzb, zzba.zzap, exc.getMessage()));
    }

    /* access modifiers changed from: protected */
    public void zzk(zzsr zzsr) {
    }

    public final boolean zzl() {
        return this.zza;
    }
}
