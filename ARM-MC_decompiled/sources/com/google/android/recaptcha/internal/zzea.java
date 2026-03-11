package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzea extends SuspendLambda implements Function1 {
    Object zza;
    int zzb;
    final /* synthetic */ zzec zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ CompletableDeferred zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzea(zzec zzec, long j, CompletableDeferred completableDeferred, Continuation continuation) {
        super(1, continuation);
        this.zzc = zzec;
        this.zzd = j;
        this.zze = completableDeferred;
    }

    public final Continuation create(Continuation continuation) {
        return new zzea(this.zzc, this.zzd, this.zze, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return ((zzea) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        zzbd e;
        zzen zzen;
        zzen zzen2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zzb;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            zzen zzf = this.zzc.zzb.zzf(41);
            try {
                this.zza = zzf;
                this.zzb = 1;
                Object zzo = this.zzc.zza.zzo(this.zzd, this);
                if (zzo != coroutine_suspended) {
                    Object obj2 = zzo;
                    zzen2 = zzf;
                    obj = obj2;
                }
                return coroutine_suspended;
            } catch (zzbd e2) {
                zzbd zzbd = e2;
                zzen = zzf;
                e = zzbd;
                this.zzc.zzd = e;
                zzen.zzb(e);
                throw e;
            }
        } else if (i != 1) {
            zzen = (zzen) this.zza;
            try {
                ResultKt.throwOnFailure(obj);
                zzen.zza();
                this.zzc.zzf = zzcm.zzb;
                return Boxing.boxBoolean(this.zze.complete(Unit.INSTANCE));
            } catch (zzbd e3) {
                e = e3;
            }
        } else {
            zzen2 = (zzen) this.zza;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (zzbd e4) {
                e = e4;
                zzen = zzen2;
            }
        }
        zzsc zzsc = (zzsc) obj;
        this.zzc.zze = zzsc;
        this.zza = zzen2;
        this.zzb = 2;
        if (this.zzc.zza.zzn(zzsc, this.zzd, this) != coroutine_suspended) {
            zzen = zzen2;
            zzen.zza();
            this.zzc.zzf = zzcm.zzb;
            return Boxing.boxBoolean(this.zze.complete(Unit.INSTANCE));
        }
        return coroutine_suspended;
    }
}
