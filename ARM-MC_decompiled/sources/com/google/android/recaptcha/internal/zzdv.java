package com.google.android.recaptcha.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzdv extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzec zzb;
    int zzc;
    zzbn zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdv(zzec zzec, Continuation continuation) {
        super(continuation);
        this.zzb = zzec;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        return this.zzb.zzl((Function1) null, this);
    }
}
