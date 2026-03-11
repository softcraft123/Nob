package com.google.android.recaptcha.internal;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzfq extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzgd zzb;
    final /* synthetic */ List zzc;
    final /* synthetic */ zzft zzd;
    private /* synthetic */ Object zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfq(zzgd zzgd, List list, zzft zzft, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzgd;
        this.zzc = list;
        this.zzd = zzft;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        zzfq zzfq = new zzfq(this.zzb, this.zzc, this.zzd, continuation);
        zzfq.zze = obj;
        return zzfq;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfq) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i == 0) {
            CoroutineScope coroutineScope = (CoroutineScope) this.zze;
            while (true) {
                zzgd zzgd = this.zzb;
                if (zzgd.zza() < 0) {
                    break;
                }
                if (zzgd.zza() >= this.zzc.size() || !CoroutineScopeKt.isActive(coroutineScope)) {
                    break;
                }
                zzuf zzuf = (zzuf) this.zzc.get(this.zzb.zza());
                try {
                    zzft.zzf(this.zzd, zzuf, this.zzb);
                } catch (Exception e) {
                    Exception exc = e;
                    zzuf.zzk();
                    Boxing.boxInt(zzuf.zzg());
                    CollectionsKt.joinToString$default(zzuf.zzj(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new zzfp(this.zzd), 31, (Object) null);
                    this.zza = 1;
                    if (this.zzd.zzh(exc, this.zzb, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
