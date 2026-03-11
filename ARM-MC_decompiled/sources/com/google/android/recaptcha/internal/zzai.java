package com.google.android.recaptcha.internal;

import java.util.TimerTask;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzai extends TimerTask {
    final /* synthetic */ zzan zza;

    public zzai(zzan zzan) {
        this.zza = zzan;
    }

    public final void run() {
        TimerTask timerTask = this;
        zzan zzan = this.zza;
        Job unused = BuildersKt__Builders_commonKt.launch$default(zzan.zzb, (CoroutineContext) null, (CoroutineStart) null, new zzaj(zzan, (Continuation) null), 3, (Object) null);
    }
}
