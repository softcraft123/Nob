package com.google.android.recaptcha.internal;

import java.util.Timer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzeq extends SuspendLambda implements Function2 {
    final /* synthetic */ zzes zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeq(zzes zzes, Continuation continuation) {
        super(2, continuation);
        this.zza = zzes;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzeq(this.zza, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzeq) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzes zzes = this.zza;
        synchronized (zzeo.class) {
            zzei zzb = zzes.zze;
            if (zzb != null && zzb.zzb() == 0) {
                Timer zzc = zzes.zza;
                if (zzc != null) {
                    zzc.cancel();
                }
                zzes.zza = null;
            }
            zzes.zzg();
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
