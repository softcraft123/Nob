package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzcz extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzdc zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ RecaptchaAction zzd;
    final /* synthetic */ String zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcz(zzdc zzdc, long j, RecaptchaAction recaptchaAction, String str, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzdc;
        this.zzc = j;
        this.zzd = recaptchaAction;
        this.zze = str;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzcz(this.zzb, this.zzc, this.zzd, this.zze, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzcz) create((zzek) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i == 0) {
            zzdc.zze(this.zzb, this.zzc, this.zzd);
            zzdc zzdc = this.zzb;
            String str = this.zze;
            RecaptchaAction recaptchaAction = this.zzd;
            long j = this.zzc;
            this.zza = 1;
            obj = zzdc.zzb.zza(str, recaptchaAction, j, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Result.m515boximpl(Result.m516constructorimpl((String) obj));
    }
}
