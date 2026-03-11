package com.google.android.recaptcha.internal;

import android.content.ContentValues;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzer extends SuspendLambda implements Function2 {
    final /* synthetic */ zzes zza;
    final /* synthetic */ zztx zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzer(zzes zzes, zztx zztx, Continuation continuation) {
        super(2, continuation);
        this.zza = zzes;
        this.zzb = zztx;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzer(this.zza, this.zzb, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzer) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zztx zztx = this.zzb;
        zzes zzes = this.zza;
        synchronized (zzeo.class) {
            if (zzes.zze != null) {
                byte[] zzd = zztx.zzd();
                zzej zzej = new zzej(zzkh.zzg().zzi(zzd, 0, zzd.length), System.currentTimeMillis(), 0);
                zzei zzb2 = zzes.zze;
                ContentValues contentValues = new ContentValues();
                contentValues.put("ss", zzej.zzc());
                contentValues.put("ts", Long.valueOf(zzej.zzb()));
                zzb2.getWritableDatabase().insert("ce", (String) null, contentValues);
                int zzb3 = zzes.zze.zzb() - 500;
                if (zzb3 > 0) {
                    zzes.zze.zza(CollectionsKt.take(zzes.zze.zzd(), zzb3));
                }
                if (zzes.zze.zzb() >= 20) {
                    zzes.zzg();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
