package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzc extends ContinuationImpl {
    Object zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ zze zzc;
    int zzd;
    zzen zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzc(zze zze2, Continuation continuation) {
        super(continuation);
        this.zzc = zze2;
    }

    public final Object invokeSuspend(Object obj) {
        this.zzb = obj;
        this.zzd |= Integer.MIN_VALUE;
        Object zze2 = this.zzc.zze(0, (zzsc) null, this);
        return zze2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? zze2 : Result.m515boximpl(zze2);
    }
}
