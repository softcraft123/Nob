package com.google.android.recaptcha.internal;

import android.app.Application;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.TimeoutCancellationException;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzcq {
    private static zzcv zza;

    public static final zzcv zza(Application application) {
        zzcv zzcv = zza;
        if (zzcv == null) {
            zzcv = new zzcv(application);
        }
        if (zza == null) {
            zza = zzcv;
        }
        return zzcv;
    }

    public static final Object zzb(Application application, String str, long j, Continuation continuation) throws TimeoutCancellationException, ApiException, RecaptchaException {
        return zzcv.zzh(zza(application), str, j, (zzcn) null, (zzbi) null, (zzch) null, continuation, 28, (Object) null);
    }

    public static final Task zzc(Application application, String str, long j) throws TimeoutCancellationException, ApiException, RecaptchaException {
        return zzas.zza(BuildersKt__Builders_commonKt.async$default(zza(application).zzd().zza(), (CoroutineContext) null, (CoroutineStart) null, new zzco(application, str, j, (Continuation) null), 3, (Object) null));
    }

    public static final Object zzd(Application application, String str, Continuation continuation) throws ApiException, RecaptchaException {
        return zzcv.zzh(zza(application), str, 0, (zzcn) null, zza(application).zzf, zzch.zzb, continuation, 2, (Object) null);
    }

    public static final Task zze(Application application, String str) throws ApiException, RecaptchaException {
        return zzas.zza(BuildersKt__Builders_commonKt.async$default(zza(application).zzd().zza(), (CoroutineContext) null, (CoroutineStart) null, new zzcp(application, str, (Continuation) null), 3, (Object) null));
    }
}
