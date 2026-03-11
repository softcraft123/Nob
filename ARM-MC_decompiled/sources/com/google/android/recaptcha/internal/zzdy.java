package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzdy extends SuspendLambda implements Function1 {
    int zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzec zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdy(long j, zzec zzec, Continuation continuation) {
        super(1, continuation);
        this.zzb = j;
        this.zzc = zzec;
    }

    public final Continuation create(Continuation continuation) {
        return new zzdy(this.zzb, this.zzc, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return ((zzdy) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i == 0) {
            this.zza = 1;
            if (TimeoutKt.withTimeout(this.zzb, new zzdx(this.zzc, (Continuation) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
