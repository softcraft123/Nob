package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzt extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzv zzb;
    int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzt(zzv zzv, Continuation continuation) {
        super(continuation);
        this.zzb = zzv;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object zzh = this.zzb.zzh((zzsc) null, this);
        return zzh == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? zzh : Result.m515boximpl(zzh);
    }
}
