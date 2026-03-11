package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzdg extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzdt zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ zzsp zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdg(zzdt zzdt, String str, long j, zzsp zzsp, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzdt;
        this.zzd = str;
        this.zze = j;
        this.zzf = zzsp;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzdg(this.zzc, this.zzd, this.zze, this.zzf, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzdg) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        TimeoutCancellationException e;
        zzen zzen;
        zzbd e2;
        Exception e3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.zzb != 0) {
            zzen = (zzen) this.zza;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (TimeoutCancellationException e4) {
                e = e4;
            } catch (zzbd e5) {
                e2 = e5;
                zzbd zzb2 = this.zzc.zzs(e2, e2);
                zzen.zzb(zzb2);
                throw zzb2;
            } catch (Exception e6) {
                e3 = e6;
                zzbd zzb3 = this.zzc.zzs(e3, new zzbd(zzbb.zzc, zzba.zzZ, e3.getMessage()));
                zzen.zzb(zzb3);
                throw zzb3;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            zzen zzf2 = this.zzc.zzu(this.zzd).zzf(28);
            try {
                this.zza = zzf2;
                this.zzb = 1;
                Object withTimeout = TimeoutKt.withTimeout(this.zze, new zzdf(this.zzc, this.zzf, zzf2, (Continuation) null), this);
                if (withTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
                zzen = zzf2;
                obj = withTimeout;
            } catch (TimeoutCancellationException e7) {
                TimeoutCancellationException timeoutCancellationException = e7;
                zzen = zzf2;
                e = timeoutCancellationException;
                zzbd zzb4 = this.zzc.zzs(e, new zzbd(zzbb.zzc, zzba.zzb, e.getMessage()));
                zzen.zzb(zzb4);
                throw zzb4;
            } catch (zzbd e8) {
                zzbd zzbd = e8;
                zzen = zzf2;
                e2 = zzbd;
                zzbd zzb22 = this.zzc.zzs(e2, e2);
                zzen.zzb(zzb22);
                throw zzb22;
            } catch (Exception e9) {
                Exception exc = e9;
                zzen = zzf2;
                e3 = exc;
                zzbd zzb32 = this.zzc.zzs(e3, new zzbd(zzbb.zzc, zzba.zzZ, e3.getMessage()));
                zzen.zzb(zzb32);
                throw zzb32;
            }
        }
        return (zzsr) obj;
    }
}
