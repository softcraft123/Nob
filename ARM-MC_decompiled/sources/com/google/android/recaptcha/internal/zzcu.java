package com.google.android.recaptcha.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzcu extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzcv zzb;
    int zzc;
    zzen zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcu(zzcv zzcv, Continuation continuation) {
        super(continuation);
        this.zzb = zzcv;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        return this.zzb.zzj((String) null, 0, (Function2) null, this);
    }
}
