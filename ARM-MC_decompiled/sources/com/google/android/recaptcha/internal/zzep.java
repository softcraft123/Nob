package com.google.android.recaptcha.internal;

import java.util.TimerTask;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzep extends TimerTask {
    final /* synthetic */ zzes zza;

    public zzep(zzes zzes) {
        this.zza = zzes;
    }

    public final void run() {
        TimerTask timerTask = this;
        zzes zzes = this.zza;
        Job unused = BuildersKt__Builders_commonKt.launch$default(zzes.zzd, (CoroutineContext) null, (CoroutineStart) null, new zzeq(zzes, (Continuation) null), 3, (Object) null);
    }
}
