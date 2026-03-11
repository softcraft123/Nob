package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzs extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzv zzb;
    final /* synthetic */ String zzc;
    private /* synthetic */ Object zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzs(zzv zzv, String str, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzv;
        this.zzc = str;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        zzs zzs = new zzs(this.zzb, this.zzc, continuation);
        zzs.zzd = obj;
        return zzs;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzs) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i == 0) {
            CoroutineScope coroutineScope = (CoroutineScope) this.zzd;
            List arrayList = new ArrayList();
            zzv zzv = this.zzb;
            zzv.zzo().put(this.zzc, arrayList);
            List arrayList2 = new ArrayList();
            Collection arrayList3 = new ArrayList();
            for (Object next : this.zzb.zzb) {
                if (((zzy) next).zzf()) {
                    arrayList3.add(next);
                }
            }
            for (zzy zzr : (List) arrayList3) {
                arrayList2.add(BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new zzr(zzr, this.zzc, arrayList, (Continuation) null), 3, (Object) null));
            }
            Job[] jobArr = (Job[]) arrayList2.toArray(new Job[0]);
            this.zza = 1;
            if (AwaitKt.joinAll((Job[]) Arrays.copyOf(jobArr, jobArr.length), (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Result.Companion companion = Result.Companion;
        return Result.m515boximpl(Result.m516constructorimpl(this.zzb.zzq(this.zzc)));
    }
}
