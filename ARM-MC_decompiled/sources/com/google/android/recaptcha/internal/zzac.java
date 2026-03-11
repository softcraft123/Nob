package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzac extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzae zzc;
    final /* synthetic */ String zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzac(zzae zzae, String str, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzae;
        this.zzd = str;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzac(this.zzc, this.zzd, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzac) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        if (r7 != r0) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x010e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.zzb
            r2 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r2) goto L_0x0014
            java.lang.Object r0 = r6.zza
            com.google.android.recaptcha.internal.zzy r0 = (com.google.android.recaptcha.internal.zzy) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x00ed
        L_0x0014:
            java.lang.Object r1 = r6.zza
            com.google.android.recaptcha.internal.zzen r1 = (com.google.android.recaptcha.internal.zzen) r1
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x001c }
            goto L_0x0042
        L_0x001c:
            r7 = move-exception
            goto L_0x006a
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r7)
            com.google.android.recaptcha.internal.zzae r7 = r6.zzc
            java.lang.String r1 = r6.zzd
            com.google.android.recaptcha.internal.zzy r7 = (com.google.android.recaptcha.internal.zzy) r7
            com.google.android.recaptcha.internal.zzen r1 = com.google.android.recaptcha.internal.zzz.zzb(r7, r1)
            com.google.android.recaptcha.internal.zzae r7 = r6.zzc     // Catch:{ Exception -> 0x001c }
            com.google.android.recaptcha.internal.zzan r3 = r7.zzc     // Catch:{ Exception -> 0x001c }
            java.lang.String r7 = r7.zze     // Catch:{ Exception -> 0x001c }
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch:{ Exception -> 0x001c }
            r6.zza = r1     // Catch:{ Exception -> 0x001c }
            r6.zzb = r2     // Catch:{ Exception -> 0x001c }
            java.lang.Object r7 = r3.zzc(r7, r4)     // Catch:{ Exception -> 0x001c }
            if (r7 == r0) goto L_0x010e
        L_0x0042:
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x001c }
            r1.zza()     // Catch:{ Exception -> 0x001c }
            com.google.android.recaptcha.internal.zzae r2 = r6.zzc     // Catch:{ Exception -> 0x001c }
            com.google.android.recaptcha.internal.zzy r2 = (com.google.android.recaptcha.internal.zzy) r2     // Catch:{ Exception -> 0x001c }
            com.google.android.recaptcha.internal.zztf r3 = com.google.android.recaptcha.internal.zzti.zzf()     // Catch:{ Exception -> 0x001c }
            com.google.android.recaptcha.internal.zztg r4 = com.google.android.recaptcha.internal.zzth.zzf()     // Catch:{ Exception -> 0x001c }
            r4.zzw(r7)     // Catch:{ Exception -> 0x001c }
            com.google.android.recaptcha.internal.zznd r7 = r4.zzk()     // Catch:{ Exception -> 0x001c }
            com.google.android.recaptcha.internal.zzth r7 = (com.google.android.recaptcha.internal.zzth) r7     // Catch:{ Exception -> 0x001c }
            r3.zzf(r7)     // Catch:{ Exception -> 0x001c }
            com.google.android.recaptcha.internal.zznd r7 = r3.zzk()     // Catch:{ Exception -> 0x001c }
            com.google.android.recaptcha.internal.zzti r7 = (com.google.android.recaptcha.internal.zzti) r7     // Catch:{ Exception -> 0x001c }
            com.google.android.recaptcha.internal.zzaa r7 = com.google.android.recaptcha.internal.zzz.zza(r2, r7)     // Catch:{ Exception -> 0x001c }
            return r7
        L_0x006a:
            com.google.android.recaptcha.internal.zzbd r2 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r3 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r4 = com.google.android.recaptcha.internal.zzba.zzaa
            java.lang.String r5 = r7.getMessage()
            r2.<init>(r3, r4, r5)
            r1.zzb(r2)
            com.google.android.recaptcha.internal.zzae r1 = r6.zzc
            com.google.android.recaptcha.internal.zzy r1 = (com.google.android.recaptcha.internal.zzy) r1
            r2 = r6
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r6.zza = r1
            r2 = 2
            r6.zzb = r2
            boolean r3 = r7 instanceof com.google.android.play.core.integrity.StandardIntegrityException
            if (r3 == 0) goto L_0x00d8
            com.google.android.play.core.integrity.StandardIntegrityException r7 = (com.google.android.play.core.integrity.StandardIntegrityException) r7
            int r7 = r7.getErrorCode()
            r3 = -100
            if (r7 == r3) goto L_0x00d5
            r3 = -12
            if (r7 == r3) goto L_0x00d2
            r3 = -3
            if (r7 == r3) goto L_0x00cf
            r3 = -2
            if (r7 == r3) goto L_0x00cc
            r3 = -1
            if (r7 == r3) goto L_0x00c9
            switch(r7) {
                case -19: goto L_0x00c6;
                case -18: goto L_0x00c3;
                case -17: goto L_0x00c0;
                case -16: goto L_0x00bd;
                case -15: goto L_0x00ba;
                case -14: goto L_0x00b7;
                default: goto L_0x00a4;
            }
        L_0x00a4:
            switch(r7) {
                case -9: goto L_0x00b4;
                case -8: goto L_0x00b1;
                case -7: goto L_0x00ae;
                case -6: goto L_0x00ab;
                case -5: goto L_0x00a8;
                default: goto L_0x00a7;
            }
        L_0x00a7:
            goto L_0x00da
        L_0x00a8:
            r2 = 32
            goto L_0x00da
        L_0x00ab:
            r2 = 33
            goto L_0x00da
        L_0x00ae:
            r2 = 34
            goto L_0x00da
        L_0x00b1:
            r2 = 35
            goto L_0x00da
        L_0x00b4:
            r2 = 36
            goto L_0x00da
        L_0x00b7:
            r2 = 41
            goto L_0x00da
        L_0x00ba:
            r2 = 42
            goto L_0x00da
        L_0x00bd:
            r2 = 43
            goto L_0x00da
        L_0x00c0:
            r2 = 52
            goto L_0x00da
        L_0x00c3:
            r2 = 53
            goto L_0x00da
        L_0x00c6:
            r2 = 54
            goto L_0x00da
        L_0x00c9:
            r2 = 28
            goto L_0x00da
        L_0x00cc:
            r2 = 29
            goto L_0x00da
        L_0x00cf:
            r2 = 30
            goto L_0x00da
        L_0x00d2:
            r2 = 39
            goto L_0x00da
        L_0x00d5:
            r2 = 44
            goto L_0x00da
        L_0x00d8:
            r2 = 45
        L_0x00da:
            com.google.android.recaptcha.internal.zztd r7 = com.google.android.recaptcha.internal.zzte.zzf()
            r7.zzq(r2)
            r2 = 15
            r7.zzr(r2)
            com.google.android.recaptcha.internal.zznd r7 = r7.zzk()
            if (r7 == r0) goto L_0x010e
            r0 = r1
        L_0x00ed:
            com.google.android.recaptcha.internal.zzte r7 = (com.google.android.recaptcha.internal.zzte) r7
            com.google.android.recaptcha.internal.zzw r1 = new com.google.android.recaptcha.internal.zzw
            int r2 = r0.zza()
            com.google.android.recaptcha.internal.zzmx r7 = r7.zzr()
            com.google.android.recaptcha.internal.zztd r7 = (com.google.android.recaptcha.internal.zztd) r7
            int r0 = r0.zza()
            r7.zzf(r0)
            com.google.android.recaptcha.internal.zznd r7 = r7.zzk()
            com.google.android.recaptcha.internal.zzte r7 = (com.google.android.recaptcha.internal.zzte) r7
            r1.<init>(r2, r7)
            com.google.android.recaptcha.internal.zzaa r1 = (com.google.android.recaptcha.internal.zzaa) r1
            return r1
        L_0x010e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzac.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
