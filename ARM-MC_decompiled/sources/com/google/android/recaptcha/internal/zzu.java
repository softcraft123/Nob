package com.google.android.recaptcha.internal;

import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzu extends SuspendLambda implements Function2 {
    Object zza;
    Object zzb;
    int zzc;
    final /* synthetic */ zzsc zzd;
    final /* synthetic */ zzv zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzu(zzsc zzsc, zzv zzv, Continuation continuation) {
        super(2, continuation);
        this.zzd = zzsc;
        this.zze = zzv;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzu(this.zzd, this.zze, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzu) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        zzse zzse;
        Iterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.zzc != 0) {
            it = (Iterator) this.zzb;
            zzse = (zzse) this.zza;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            if (!this.zzd.zzS()) {
                Result.Companion companion = Result.Companion;
                return Result.m515boximpl(Result.m516constructorimpl(ResultKt.createFailure(new zzbd(zzbb.zzb, zzba.zzab, (String) null))));
            }
            zzse = this.zzd.zzj();
            if (zzse.zzi().zzd() != 0) {
                this.zze.zzc = zzse.zzi();
                it = this.zze.zzb.iterator();
            } else {
                Result.Companion companion2 = Result.Companion;
                return Result.m515boximpl(Result.m516constructorimpl(ResultKt.createFailure(new zzbd(zzbb.zzb, zzba.zzab, (String) null))));
            }
        }
        while (it.hasNext()) {
            this.zza = zzse;
            this.zzb = it;
            this.zzc = 1;
            if (((zzy) it.next()).zzd(zzse, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Result.Companion companion3 = Result.Companion;
        return Result.m515boximpl(Result.m516constructorimpl(Unit.INSTANCE));
    }
}
