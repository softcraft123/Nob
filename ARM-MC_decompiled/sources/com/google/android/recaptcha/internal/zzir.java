package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzir extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzja zzb;
    int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzir(zzja zzja, Continuation continuation) {
        super(continuation);
        this.zzb = zzja;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object zzh = this.zzb.zzh((zzsc) null, this);
        return zzh == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? zzh : Result.m515boximpl(zzh);
    }
}
