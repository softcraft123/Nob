package com.google.android.recaptcha.internal;

import android.content.Context;
import android.webkit.WebView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzjc extends SuspendLambda implements Function2 {
    final /* synthetic */ zzjd zza;
    final /* synthetic */ Context zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjc(zzjd zzjd, Context context, Continuation continuation) {
        super(2, continuation);
        this.zza = zzjd;
        this.zzb = context;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzjc(this.zza, this.zzb, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzjc) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        WebView zza2 = this.zza.zza;
        if (zza2 == null) {
            zza2 = new WebView(this.zzb);
        }
        this.zza.zza = zza2;
        return zza2;
    }
}
