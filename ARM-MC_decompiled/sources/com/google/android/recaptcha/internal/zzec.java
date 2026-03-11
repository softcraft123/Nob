package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzec implements zzcn {
    /* access modifiers changed from: private */
    public final zzdt zza;
    /* access modifiers changed from: private */
    public final zzek zzb;
    /* access modifiers changed from: private */
    public CompletableDeferred zzc = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    /* access modifiers changed from: private */
    public zzbd zzd;
    /* access modifiers changed from: private */
    public zzsc zze;
    /* access modifiers changed from: private */
    public zzcm zzf = zzcm.zza;
    private final zzbi zzg;

    public zzec(zzdt zzdt, zzbi zzbi, zzek zzek, zzbo zzbo) {
        this.zza = zzdt;
        this.zzg = zzbi;
        this.zzb = zzek;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzl(kotlin.jvm.functions.Function1 r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.google.android.recaptcha.internal.zzdv
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.android.recaptcha.internal.zzdv r0 = (com.google.android.recaptcha.internal.zzdv) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzdv r0 = new com.google.android.recaptcha.internal.zzdv
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            com.google.android.recaptcha.internal.zzbn r5 = r0.zzd
            r0 = r5
            com.google.android.recaptcha.internal.zzbn r0 = (com.google.android.recaptcha.internal.zzbn) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0049
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.recaptcha.internal.zzbn r6 = new com.google.android.recaptcha.internal.zzbn
            r6.<init>()
            r0.zzd = r6
            r0.zzc = r3
            java.lang.Object r5 = r5.invoke(r0)
            if (r5 == r1) goto L_0x0057
            r5 = r6
        L_0x0049:
            r5.zzc()
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r5 = r5.zza(r6)
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
            return r5
        L_0x0057:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzec.zzl(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007f A[SYNTHETIC, Splitter:B:30:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzm(long r7, kotlin.coroutines.Continuation r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.google.android.recaptcha.internal.zzdw
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.google.android.recaptcha.internal.zzdw r0 = (com.google.android.recaptcha.internal.zzdw) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzd = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzdw r0 = new com.google.android.recaptcha.internal.zzdw
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzd
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0049
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            long r7 = r0.zza
            com.google.android.recaptcha.internal.zzec r0 = r0.zze
            r1 = r0
            com.google.android.recaptcha.internal.zzec r1 = (com.google.android.recaptcha.internal.zzec) r1
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x0034 }
            goto L_0x006d
        L_0x0034:
            r7 = move-exception
            goto L_0x008b
        L_0x0036:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003e:
            long r7 = r0.zza
            com.google.android.recaptcha.internal.zzec r2 = r0.zze
            r4 = r2
            com.google.android.recaptcha.internal.zzec r4 = (com.google.android.recaptcha.internal.zzec) r4
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0059
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.zze = r6
            r0.zza = r7
            r0.zzd = r4
            java.lang.Object r9 = r6.zzn(r7, r0)
            if (r9 == r1) goto L_0x00c6
            r2 = r6
        L_0x0059:
            com.google.android.recaptcha.internal.zzdy r9 = new com.google.android.recaptcha.internal.zzdy     // Catch:{ Exception -> 0x0089 }
            r9.<init>(r7, r2, r5)     // Catch:{ Exception -> 0x0089 }
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9     // Catch:{ Exception -> 0x0089 }
            r0.zze = r2     // Catch:{ Exception -> 0x0089 }
            r0.zza = r7     // Catch:{ Exception -> 0x0089 }
            r0.zzd = r3     // Catch:{ Exception -> 0x0089 }
            java.lang.Object r9 = r2.zzl(r9, r0)     // Catch:{ Exception -> 0x0089 }
            if (r9 == r1) goto L_0x00c6
            r0 = r2
        L_0x006d:
            java.lang.Number r9 = (java.lang.Number) r9     // Catch:{ Exception -> 0x0034 }
            long r1 = r9.longValue()     // Catch:{ Exception -> 0x0034 }
            long r7 = r7 - r1
            r1 = 500(0x1f4, double:2.47E-321)
            int r9 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r9 < 0) goto L_0x007f
            java.lang.Long r7 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)
            return r7
        L_0x007f:
            com.google.android.recaptcha.internal.zzbd r7 = new com.google.android.recaptcha.internal.zzbd     // Catch:{ Exception -> 0x0034 }
            com.google.android.recaptcha.internal.zzbb r8 = com.google.android.recaptcha.internal.zzbb.zzc     // Catch:{ Exception -> 0x0034 }
            com.google.android.recaptcha.internal.zzba r9 = com.google.android.recaptcha.internal.zzba.zzar     // Catch:{ Exception -> 0x0034 }
            r7.<init>(r8, r9, r5)     // Catch:{ Exception -> 0x0034 }
            throw r7     // Catch:{ Exception -> 0x0034 }
        L_0x0089:
            r7 = move-exception
            r0 = r2
        L_0x008b:
            boolean r8 = r7 instanceof com.google.android.recaptcha.internal.zzbd
            if (r8 == 0) goto L_0x0092
            r5 = r7
            com.google.android.recaptcha.internal.zzbd r5 = (com.google.android.recaptcha.internal.zzbd) r5
        L_0x0092:
            if (r5 != 0) goto L_0x00a1
            com.google.android.recaptcha.internal.zzbd r5 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r8 = com.google.android.recaptcha.internal.zzbb.zzc
            com.google.android.recaptcha.internal.zzba r9 = com.google.android.recaptcha.internal.zzba.zzar
            java.lang.String r7 = r7.getMessage()
            r5.<init>(r8, r9, r7)
        L_0x00a1:
            com.google.android.recaptcha.internal.zzcm r7 = r0.zzf
            com.google.android.recaptcha.internal.zzci r8 = com.google.android.recaptcha.internal.zzcm.zzd
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 != 0) goto L_0x00bb
            com.google.android.recaptcha.internal.zzcm r7 = r0.zzf
            com.google.android.recaptcha.internal.zzck r8 = com.google.android.recaptcha.internal.zzcm.zzc
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x00ba
            goto L_0x00bb
        L_0x00ba:
            throw r5
        L_0x00bb:
            com.google.android.recaptcha.internal.zzbd r7 = r0.zzd
            if (r7 == 0) goto L_0x00c2
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            goto L_0x00c5
        L_0x00c2:
            r7 = r5
            java.lang.Throwable r7 = (java.lang.Throwable) r7
        L_0x00c5:
            throw r7
        L_0x00c6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzec.zzm(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object zzn(long j, Continuation continuation) {
        if (Intrinsics.areEqual((Object) this.zzf, (Object) zzcm.zzb) || Intrinsics.areEqual((Object) this.zzf, (Object) zzcm.zzc)) {
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) this.zzf, (Object) zzcm.zzd) && !zzo(this.zzd)) {
            return Unit.INSTANCE;
        }
        this.zzf = zzcm.zzc;
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        this.zzc = CompletableDeferred$default;
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.zzg.zza(), (CoroutineContext) null, (CoroutineStart) null, new zzeb(this, CompletableDeferred$default, j, (Continuation) null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final boolean zzo(Exception exc) {
        if (!(exc instanceof zzbd)) {
            return true;
        }
        zzbd zzbd = (zzbd) exc;
        if (Intrinsics.areEqual((Object) zzbd.zzb(), (Object) zzbb.zzd) || Intrinsics.areEqual((Object) zzbd.zzb(), (Object) zzbb.zze) || Intrinsics.areEqual((Object) zzbd.zzb(), (Object) zzbb.zzf)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b1 A[Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bf A[Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d9 A[Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(java.lang.String r18, com.google.android.recaptcha.RecaptchaAction r19, long r20, kotlin.coroutines.Continuation r22) {
        /*
            r17 = this;
            r1 = r17
            r0 = r22
            boolean r2 = r0 instanceof com.google.android.recaptcha.internal.zzdu
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.google.android.recaptcha.internal.zzdu r2 = (com.google.android.recaptcha.internal.zzdu) r2
            int r3 = r2.zzd
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.zzd = r3
            goto L_0x001c
        L_0x0017:
            com.google.android.recaptcha.internal.zzdu r2 = new com.google.android.recaptcha.internal.zzdu
            r2.<init>(r1, r0)
        L_0x001c:
            r8 = r2
            java.lang.Object r0 = r8.zzb
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r8.zzd
            r4 = 3
            r5 = 2
            r6 = 1
            if (r3 == 0) goto L_0x0072
            if (r3 == r6) goto L_0x005c
            if (r3 == r5) goto L_0x0047
            if (r3 != r4) goto L_0x003f
            java.lang.String r2 = r8.zzf
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.recaptcha.internal.zzec r3 = r8.zze
            r4 = r3
            com.google.android.recaptcha.internal.zzec r4 = (com.google.android.recaptcha.internal.zzec) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            goto L_0x00db
        L_0x003f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0047:
            double r5 = r8.zza
            com.google.android.recaptcha.RecaptchaAction r3 = r8.zzg
            r7 = r3
            com.google.android.recaptcha.RecaptchaAction r7 = (com.google.android.recaptcha.RecaptchaAction) r7
            java.lang.String r7 = r8.zzf
            r9 = r7
            java.lang.String r9 = (java.lang.String) r9
            com.google.android.recaptcha.internal.zzec r9 = r8.zze
            r10 = r9
            com.google.android.recaptcha.internal.zzec r10 = (com.google.android.recaptcha.internal.zzec) r10
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            goto L_0x00b6
        L_0x005c:
            com.google.android.recaptcha.RecaptchaAction r3 = r8.zzg
            r6 = r3
            com.google.android.recaptcha.RecaptchaAction r6 = (com.google.android.recaptcha.RecaptchaAction) r6
            java.lang.String r6 = r8.zzf
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            com.google.android.recaptcha.internal.zzec r7 = r8.zze
            r9 = r7
            com.google.android.recaptcha.internal.zzec r9 = (com.google.android.recaptcha.internal.zzec) r9
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r15 = r6
            r6 = r0
            r0 = r15
            goto L_0x008b
        L_0x0072:
            kotlin.ResultKt.throwOnFailure(r0)
            r8.zze = r1     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r0 = r18
            r8.zzf = r0     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r3 = r19
            r8.zzg = r3     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r8.zzd = r6     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r6 = r20
            java.lang.Object r6 = r1.zzm(r6, r8)     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            if (r6 != r2) goto L_0x008a
            goto L_0x00e7
        L_0x008a:
            r7 = r1
        L_0x008b:
            java.lang.Number r6 = (java.lang.Number) r6     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            long r9 = r6.longValue()     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            double r9 = (double) r9     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            com.google.android.recaptcha.internal.zzdt r6 = r7.zza     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r11 = 4601778099247172813(0x3fdccccccccccccd, double:0.45)
            double r11 = r11 * r9
            r8.zze = r7     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r8.zzf = r0     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r8.zzg = r3     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r13 = 4603129179135383962(0x3fe199999999999a, double:0.55)
            double r9 = r9 * r13
            r8.zza = r9     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r8.zzd = r5     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            long r11 = (long) r11     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            java.lang.Object r5 = r6.zzl(r0, r11, r8)     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            if (r5 == r2) goto L_0x00e7
            r15 = r7
            r7 = r0
            r0 = r5
            r5 = r9
            r9 = r15
        L_0x00b6:
            com.google.android.recaptcha.internal.zzsi r0 = (com.google.android.recaptcha.internal.zzsi) r0     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            com.google.android.recaptcha.internal.zzdt r10 = r9.zza     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            com.google.android.recaptcha.internal.zzsc r11 = r9.zze     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r12 = 0
            if (r11 != 0) goto L_0x00c0
            r11 = r12
        L_0x00c0:
            com.google.android.recaptcha.internal.zzsp r0 = r10.zzi(r3, r0, r11)     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            com.google.android.recaptcha.internal.zzdt r3 = r9.zza     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            long r5 = (long) r5     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r8.zze = r9     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r8.zzf = r7     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r8.zzg = r12     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r8.zzd = r4     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r15 = r5
            r5 = r7
            r6 = r15
            r4 = r0
            java.lang.Object r0 = r3.zzm(r4, r5, r6, r8)     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            if (r0 == r2) goto L_0x00e7
            r2 = r5
            r3 = r9
        L_0x00db:
            com.google.android.recaptcha.internal.zzsr r0 = (com.google.android.recaptcha.internal.zzsr) r0     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            com.google.android.recaptcha.internal.zzdt r3 = r3.zza     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            r3.zzq(r2, r0)     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            java.lang.String r0 = r0.zzj()     // Catch:{ zzbd -> 0x00f7, Exception -> 0x00e8 }
            return r0
        L_0x00e7:
            return r2
        L_0x00e8:
            r0 = move-exception
            com.google.android.recaptcha.internal.zzbd r2 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r3 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r4 = com.google.android.recaptcha.internal.zzba.zzay
            java.lang.String r0 = r0.getMessage()
            r2.<init>(r3, r4, r0)
            throw r2
        L_0x00f7:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzec.zza(java.lang.String, com.google.android.recaptcha.RecaptchaAction, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object zzb(long j, Continuation continuation) {
        Object zzn = zzn(j, continuation);
        return zzn == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? zzn : Unit.INSTANCE;
    }
}
