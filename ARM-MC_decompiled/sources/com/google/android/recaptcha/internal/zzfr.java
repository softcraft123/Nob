package com.google.android.recaptcha.internal;

import java.util.Arrays;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzfr extends SuspendLambda implements Function2 {
    final /* synthetic */ Exception zza;
    final /* synthetic */ zzgd zzb;
    final /* synthetic */ zzft zzc;
    private /* synthetic */ Object zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfr(Exception exc, zzgd zzgd, zzft zzft, Continuation continuation) {
        super(2, continuation);
        this.zza = exc;
        this.zzb = zzgd;
        this.zzc = zzft;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        zzfr zzfr = new zzfr(this.zza, this.zzb, this.zzc, continuation);
        zzfr.zzd = obj;
        return zzfr;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfr) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        zztd zztd;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.zzd;
        Exception exc = this.zza;
        if (exc instanceof zzce) {
            zztd = ((zzce) exc).zza();
            zztd.zze(this.zzb.zza());
        } else {
            zzgd zzgd = this.zzb;
            zztd zzf = zzte.zzf();
            zzf.zze(zzgd.zza());
            zzf.zzr(2);
            zzf.zzq(2);
            zztd = zzf;
        }
        zzte zzte = (zzte) zztd.zzk();
        zzte.zzl();
        zzte.zzk();
        Reflection.getOrCreateKotlinClass(this.zza.getClass()).getSimpleName();
        this.zza.getMessage();
        zzgd zzgd2 = this.zzb;
        zzbn zzb2 = zzgd2.zzb();
        zzbn zzbn = zzgd2.zza;
        if (zzbn == null) {
            zzbn = null;
        }
        zzrl zza2 = zzev.zza(zzb2, zzbn);
        CharSequence zzd2 = this.zzb.zzd();
        if (zzd2.length() == 0) {
            zzd2 = "recaptcha.m.Main.rge";
        }
        String str = (String) zzd2;
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            zzft zzft = this.zzc;
            zzkh zzh = zzkh.zzh();
            byte[] zzd3 = zzte.zzd();
            zzkh zzh2 = zzkh.zzh();
            byte[] zzd4 = zza2.zzd();
            zzft.zzb.zzd().zzb(str, (String[]) Arrays.copyOf(new String[]{zzh.zzi(zzd3, 0, zzd3.length), zzh2.zzi(zzd4, 0, zzd4.length)}, 2));
        }
        return Unit.INSTANCE;
    }
}
