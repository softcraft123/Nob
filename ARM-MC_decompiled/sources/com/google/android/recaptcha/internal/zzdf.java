package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzdf extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzdt zzb;
    final /* synthetic */ zzsp zzc;
    final /* synthetic */ zzen zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdf(zzdt zzdt, zzsp zzsp, zzen zzen, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzdt;
        this.zzc = zzsp;
        this.zzd = zzen;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzdf(this.zzb, this.zzc, this.zzd, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzdf) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i == 0) {
            zzdt zzdt = this.zzb;
            zzsp zzsp = this.zzc;
            this.zza = 1;
            obj = zzdt.zzh(zzdt).zzb(zzdt.zzd(zzdt), zzsp, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        zzsr zzsr = (zzsr) obj;
        this.zzd.zza();
        return zzsr;
    }
}
