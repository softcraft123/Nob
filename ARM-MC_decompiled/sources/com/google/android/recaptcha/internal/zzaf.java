package com.google.android.recaptcha.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzaf extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzan zzb;
    int zzc;
    zzan zzd;
    String zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaf(zzan zzan, Continuation continuation) {
        super(continuation);
        this.zzb = zzan;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        return this.zzb.zzc((String) null, this);
    }
}
