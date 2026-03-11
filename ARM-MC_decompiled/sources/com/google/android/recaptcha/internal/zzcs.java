package com.google.android.recaptcha.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzcs extends ContinuationImpl {
    Object zza;
    Object zzb;
    Object zzc;
    long zzd;
    /* synthetic */ Object zze;
    final /* synthetic */ zzcv zzf;
    int zzg;
    String zzh;
    zzch zzi;
    zzbi zzj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcs(zzcv zzcv, Continuation continuation) {
        super(continuation);
        this.zzf = zzcv;
    }

    public final Object invokeSuspend(Object obj) {
        this.zze = obj;
        this.zzg |= Integer.MIN_VALUE;
        return this.zzf.zzg((String) null, 0, (zzcn) null, (zzbi) null, (zzch) null, this);
    }
}
