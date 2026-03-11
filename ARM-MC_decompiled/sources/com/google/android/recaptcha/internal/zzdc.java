package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaClient;
import com.google.android.recaptcha.RecaptchaTasksClient;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzdc implements RecaptchaClient, RecaptchaTasksClient {
    private static final Regex zza = new Regex("^[a-zA-Z0-9/_]{0,100}$");
    /* access modifiers changed from: private */
    public final zzcn zzb;
    private final String zzc;
    private final zzek zzd;
    private final zzbi zze;

    public zzdc(zzcn zzcn, String str, zzbi zzbi, zzek zzek) {
        this.zzb = zzcn;
        this.zzc = str;
        this.zze = zzbi;
        this.zzd = zzek;
    }

    public static final /* synthetic */ void zze(zzdc zzdc, long j, RecaptchaAction recaptchaAction) {
        zzbd zzbd = !zza.matches(recaptchaAction.getAction()) ? new zzbd(zzbb.zzg, zzba.zzh, (String) null) : null;
        if (j < 5000) {
            zzbd = new zzbd(zzbb.zzb, zzba.zzI, (String) null);
        }
        if (zzbd != null) {
            throw zzbd;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzg(java.lang.String r5, kotlin.jvm.functions.Function2 r6, kotlin.coroutines.Continuation r7) throws com.google.android.recaptcha.internal.zzbd {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzdb
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.google.android.recaptcha.internal.zzdb r0 = (com.google.android.recaptcha.internal.zzdb) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzdb r0 = new com.google.android.recaptcha.internal.zzdb
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            com.google.android.recaptcha.internal.zzen r5 = r0.zzd
            r6 = r5
            com.google.android.recaptcha.internal.zzen r6 = (com.google.android.recaptcha.internal.zzen) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ zzbd -> 0x0030, Exception -> 0x002e }
            goto L_0x0056
        L_0x002e:
            r6 = move-exception
            goto L_0x005b
        L_0x0030:
            r6 = move-exception
            goto L_0x006c
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r7)
            com.google.android.recaptcha.internal.zzek r7 = r4.zzd
            com.google.android.recaptcha.internal.zzek r7 = r7.zza()
            r7.zzc(r5)
            r5 = 9
            com.google.android.recaptcha.internal.zzen r5 = r7.zzf(r5)
            r0.zzd = r5     // Catch:{ zzbd -> 0x0030, Exception -> 0x002e }
            r0.zzc = r3     // Catch:{ zzbd -> 0x0030, Exception -> 0x002e }
            java.lang.Object r7 = r6.invoke(r7, r0)     // Catch:{ zzbd -> 0x0030, Exception -> 0x002e }
            if (r7 == r1) goto L_0x005a
        L_0x0056:
            r5.zza()     // Catch:{ zzbd -> 0x0030, Exception -> 0x002e }
            return r7
        L_0x005a:
            return r1
        L_0x005b:
            com.google.android.recaptcha.internal.zzbd r7 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r0 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r1 = com.google.android.recaptcha.internal.zzba.zzX
            java.lang.String r6 = r6.getMessage()
            r7.<init>(r0, r1, r6)
            r5.zzb(r7)
            throw r7
        L_0x006c:
            r5.zzb(r6)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdc.zzg(java.lang.String, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: execute-0E7RQCE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m333execute0E7RQCE(com.google.android.recaptcha.RecaptchaAction r5, long r6, kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.google.android.recaptcha.internal.zzcw
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.google.android.recaptcha.internal.zzcw r0 = (com.google.android.recaptcha.internal.zzcw) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzcw r0 = new com.google.android.recaptcha.internal.zzcw
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r5 = r8.m525unboximpl()
            return r5
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.zzc = r3
            java.lang.Object r5 = r4.zzf(r5, r6, r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdc.m333execute0E7RQCE(com.google.android.recaptcha.RecaptchaAction, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: execute-gIAlu-s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m334executegIAlus(com.google.android.recaptcha.RecaptchaAction r5, kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.google.android.recaptcha.internal.zzcx
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.android.recaptcha.internal.zzcx r0 = (com.google.android.recaptcha.internal.zzcx) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzcx r0 = new com.google.android.recaptcha.internal.zzcx
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.m525unboximpl()
            return r5
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.zzc = r3
            r2 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r5 = r4.m333execute0E7RQCE(r5, r2, r0)
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdc.m334executegIAlus(com.google.android.recaptcha.RecaptchaAction, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Task<String> executeTask(RecaptchaAction recaptchaAction) {
        return zzas.zza(BuildersKt__Builders_commonKt.async$default(this.zze.zzb(), (CoroutineContext) null, (CoroutineStart) null, new zzda(this, recaptchaAction, 10000, (Continuation) null), 3, (Object) null));
    }

    public final String zzd() {
        return this.zzc;
    }

    public final Task<String> executeTask(RecaptchaAction recaptchaAction, long j) {
        return zzas.zza(BuildersKt__Builders_commonKt.async$default(this.zze.zzb(), (CoroutineContext) null, (CoroutineStart) null, new zzda(this, recaptchaAction, j, (Continuation) null), 3, (Object) null));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzf(com.google.android.recaptcha.RecaptchaAction r12, long r13, kotlin.coroutines.Continuation r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof com.google.android.recaptcha.internal.zzcy
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.google.android.recaptcha.internal.zzcy r0 = (com.google.android.recaptcha.internal.zzcy) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzcy r0 = new com.google.android.recaptcha.internal.zzcy
            r0.<init>(r11, r15)
        L_0x0018:
            java.lang.Object r15 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ zzbd -> 0x002a }
            r5 = r11
            goto L_0x0055
        L_0x002a:
            r0 = move-exception
            r12 = r0
            r5 = r11
            goto L_0x0061
        L_0x002e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r15)
            java.util.UUID r15 = java.util.UUID.randomUUID()     // Catch:{ zzbd -> 0x005e }
            java.lang.String r9 = r15.toString()     // Catch:{ zzbd -> 0x005e }
            com.google.android.recaptcha.internal.zzcz r4 = new com.google.android.recaptcha.internal.zzcz     // Catch:{ zzbd -> 0x005e }
            r10 = 0
            r5 = r11
            r8 = r12
            r6 = r13
            r4.<init>(r5, r6, r8, r9, r10)     // Catch:{ zzbd -> 0x005c }
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch:{ zzbd -> 0x005c }
            r0.zzc = r3     // Catch:{ zzbd -> 0x005c }
            java.lang.Object r15 = r11.zzg(r9, r4, r0)     // Catch:{ zzbd -> 0x005c }
            if (r15 != r1) goto L_0x0055
            return r1
        L_0x0055:
            kotlin.Result r15 = (kotlin.Result) r15     // Catch:{ zzbd -> 0x005c }
            java.lang.Object r12 = r15.m525unboximpl()     // Catch:{ zzbd -> 0x005c }
            return r12
        L_0x005c:
            r0 = move-exception
            goto L_0x0060
        L_0x005e:
            r0 = move-exception
            r5 = r11
        L_0x0060:
            r12 = r0
        L_0x0061:
            kotlin.Result$Companion r13 = kotlin.Result.Companion
            com.google.android.recaptcha.RecaptchaException r12 = r12.zzc()
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m516constructorimpl(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdc.zzf(com.google.android.recaptcha.RecaptchaAction, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
