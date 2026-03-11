package com.google.android.recaptcha.internal;

import android.os.Build;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzdh extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzdt zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdh(zzdt zzdt, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzdt;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new zzdh(this.zzb, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzdh) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i != 0) {
            return obj;
        }
        int zza2 = new zzbs(GoogleApiAvailabilityLight.getInstance()).zza(this.zzb.zzr());
        zzdt zzdt = this.zzb;
        String zzp = zzdt.zza;
        String packageName = zzdt.zzr().getPackageName();
        String zzd = this.zzb.zzb.zzd();
        zzbf zzc = this.zzb.zzt();
        int i2 = Build.VERSION.SDK_INT;
        String zza3 = zzc.zza();
        zztn zzf = zzto.zzf();
        zzf.zzt(zzp);
        zzf.zzq(packageName);
        zzf.zzu(zza2);
        zzf.zzr("18.6.1");
        zzf.zzs(zzd);
        zzf.zzf(String.valueOf(i2));
        zzf.zze(zza3);
        zzdt zzdt2 = this.zzb;
        zzff zzg = zzdt.zzg(zzdt2);
        String zzb2 = zzdt.zzd(zzdt2).zzb();
        this.zza = 1;
        Object zzc2 = zzg.zzc(zzb2, (zzto) zzf.zzk(), this);
        return zzc2 == coroutine_suspended ? coroutine_suspended : zzc2;
    }
}
