package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzfh extends SuspendLambda implements Function2 {
    final /* synthetic */ zzfj zza;
    final /* synthetic */ zzbr zzb;
    final /* synthetic */ zzsp zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfh(zzfj zzfj, zzbr zzbr, zzsp zzsp, Continuation continuation) {
        super(2, continuation);
        this.zza = zzfj;
        this.zzb = zzbr;
        this.zzc = zzsp;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzfh(this.zza, this.zzb, this.zzc, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfh) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzew zzew = null;
        try {
            zzew = zzfj.zza(this.zza).zza(this.zzb.zzd());
            zzew.zzc();
            zzew.zze(this.zzc.zzd());
            zzsr zzsr = (zzsr) zzew.zza(zzsr.zzi());
            zzew.zzd();
            return zzsr;
        } catch (zzbd e) {
            throw e;
        } catch (Exception e2) {
            throw new zzbd(zzbb.zzc, zzba.zzF, e2.getMessage());
        } catch (Throwable th) {
            if (zzew != null) {
                zzew.zzd();
            }
            throw th;
        }
    }
}
