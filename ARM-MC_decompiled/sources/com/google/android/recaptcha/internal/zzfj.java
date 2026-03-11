package com.google.android.recaptcha.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzfj {
    private final Lazy zza = LazyKt.lazy(zzfi.zza);

    public zzfj() {
        int i = zzav.zza;
    }

    public static final /* synthetic */ zzex zza(zzfj zzfj) {
        return (zzex) zzfj.zza.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object zzc(com.google.android.recaptcha.internal.zzfj r4, com.google.android.recaptcha.internal.zzbr r5, com.google.android.recaptcha.internal.zzsp r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzfg
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.google.android.recaptcha.internal.zzfg r0 = (com.google.android.recaptcha.internal.zzfg) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzfg r0 = new com.google.android.recaptcha.internal.zzfg
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)
            return r7
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            com.google.android.recaptcha.internal.zzfh r7 = new com.google.android.recaptcha.internal.zzfh
            r2 = 0
            r7.<init>(r4, r5, r6, r2)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r0.zzc = r3
            java.lang.Object r4 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r7, r0)
            if (r4 != r1) goto L_0x0045
            return r1
        L_0x0045:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzfj.zzc(com.google.android.recaptcha.internal.zzfj, com.google.android.recaptcha.internal.zzbr, com.google.android.recaptcha.internal.zzsp, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object zzb(zzbr zzbr, zzsp zzsp, Continuation continuation) {
        return zzc(this, zzbr, zzsp, continuation);
    }
}
