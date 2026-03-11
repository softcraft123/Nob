package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzal extends SuspendLambda implements Function2 {
    long zza;
    boolean zzb;
    int zzc;
    final /* synthetic */ zzan zzd;
    final /* synthetic */ zzen zze;
    final /* synthetic */ Ref.ObjectRef zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzal(zzan zzan, zzen zzen, Ref.ObjectRef objectRef, Continuation continuation) {
        super(2, continuation);
        this.zzd = zzan;
        this.zze = zzen;
        this.zzf = objectRef;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzal(this.zzd, this.zze, this.zzf, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzal) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r8 != r0) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        r1 = ((com.google.android.play.core.integrity.StandardIntegrityException) r8).getErrorCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0083, code lost:
        if (kotlinx.coroutines.DelayKt.delay(r4, r7) != r0) goto L_0x0013;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0088, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026 A[SYNTHETIC, Splitter:B:11:0x0026] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.zzc
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x0016
            boolean r1 = r7.zzb
            long r4 = r7.zza
            kotlin.ResultKt.throwOnFailure(r8)
        L_0x0013:
            r8 = r1
            goto L_0x0086
        L_0x0016:
            long r4 = r7.zza
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ Exception -> 0x001c }
            goto L_0x0035
        L_0x001c:
            r8 = move-exception
            goto L_0x004e
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r8)
            r4 = 1000(0x3e8, double:4.94E-321)
            r8 = r3
        L_0x0024:
            if (r8 == 0) goto L_0x008a
            com.google.android.recaptcha.internal.zzan r8 = r7.zzd     // Catch:{ Exception -> 0x001c }
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch:{ Exception -> 0x001c }
            r7.zza = r4     // Catch:{ Exception -> 0x001c }
            r7.zzc = r3     // Catch:{ Exception -> 0x001c }
            java.lang.Object r8 = r8.zzi(r1)     // Catch:{ Exception -> 0x001c }
            if (r8 == r0) goto L_0x0088
        L_0x0035:
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenProvider r8 = (com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenProvider) r8     // Catch:{ Exception -> 0x001c }
            com.google.android.recaptcha.internal.zzan r1 = r7.zzd     // Catch:{ Exception -> 0x001c }
            kotlinx.coroutines.CompletableDeferred r1 = r1.zzf()     // Catch:{ Exception -> 0x001c }
            r1.complete(r8)     // Catch:{ Exception -> 0x001c }
            com.google.android.recaptcha.internal.zzan r8 = r7.zzd     // Catch:{ Exception -> 0x001c }
            com.google.android.recaptcha.internal.zzao r1 = com.google.android.recaptcha.internal.zzao.zzc     // Catch:{ Exception -> 0x001c }
            r8.zze = r1     // Catch:{ Exception -> 0x001c }
            com.google.android.recaptcha.internal.zzen r8 = r7.zze     // Catch:{ Exception -> 0x001c }
            r8.zza()     // Catch:{ Exception -> 0x001c }
            r8 = r2
            goto L_0x0024
        L_0x004e:
            kotlin.jvm.internal.Ref$ObjectRef r1 = r7.zzf
            r1.element = r8
            boolean r1 = r8 instanceof com.google.android.play.core.integrity.StandardIntegrityException
            if (r1 == 0) goto L_0x0072
            r1 = r8
            com.google.android.play.core.integrity.StandardIntegrityException r1 = (com.google.android.play.core.integrity.StandardIntegrityException) r1
            int r1 = r1.getErrorCode()
            r6 = -100
            if (r1 == r6) goto L_0x0070
            r6 = -18
            if (r1 == r6) goto L_0x0070
            r6 = -12
            if (r1 == r6) goto L_0x0070
            r6 = -8
            if (r1 == r6) goto L_0x0070
            r6 = -3
            if (r1 == r6) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r1 = r3
            goto L_0x0073
        L_0x0072:
            r1 = r2
        L_0x0073:
            if (r1 == 0) goto L_0x0089
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.zza = r4
            r7.zzb = r3
            r6 = 2
            r7.zzc = r6
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r4, r8)
            if (r8 == r0) goto L_0x0088
            goto L_0x0013
        L_0x0086:
            long r4 = r4 + r4
            goto L_0x0024
        L_0x0088:
            return r0
        L_0x0089:
            throw r8
        L_0x008a:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzal.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
