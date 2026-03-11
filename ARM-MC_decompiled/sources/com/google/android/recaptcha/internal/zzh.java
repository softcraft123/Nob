package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Arrays;
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
import kotlinx.coroutines.Deferred;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzh extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzl zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    private /* synthetic */ Object zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzh(zzl zzl, String str, long j, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzl;
        this.zzc = str;
        this.zzd = j;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        zzh zzh = new zzh(this.zzb, this.zzc, this.zzd, continuation);
        zzh.zze = obj;
        return zzh;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzh) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        zzen zzen;
        zzen zzen2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.zza != 0) {
            zzen = (zzen) this.zze;
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.zze;
            zzek zza2 = this.zzb.zzb;
            if (zza2 != null) {
                zza2.zzc(this.zzc);
                zzen2 = zza2.zzf(31);
            } else {
                zzen2 = null;
            }
            List arrayList = new ArrayList();
            for (zze zze2 : this.zzb.zzd()) {
                if (zze2.zzl()) {
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new zzg(zze2, this.zzc, this.zzd, (Continuation) null), 3, (Object) null));
                }
            }
            Deferred[] deferredArr = (Deferred[]) arrayList.toArray(new Deferred[0]);
            this.zze = zzen2;
            this.zza = 1;
            obj2 = AwaitKt.awaitAll((Deferred<? extends T>[]) (Deferred[]) Arrays.copyOf(deferredArr, deferredArr.length), this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            zzen = zzen2;
        }
        String str = this.zzc;
        zzsh zzf = zzsi.zzf();
        zzf.zze(str);
        for (Result r3 : (List) obj2) {
            Object r32 = r3.m525unboximpl();
            if (Result.m523isSuccessimpl(r32)) {
                zzf.zzh((zzsi) r32);
            }
        }
        zzsi zzsi = (zzsi) zzf.zzk();
        if (zzen != null) {
            zzen.zza();
        }
        return zzsi;
    }
}
