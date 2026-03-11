package com.google.android.play.core.review.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:review@@2.0.2 */
final class zzm extends zzj {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzj zzb;
    final /* synthetic */ zzt zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzm(zzt zzt, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzj zzj) {
        super(taskCompletionSource);
        this.zza = taskCompletionSource2;
        this.zzb = zzj;
        this.zzc = zzt;
    }

    public final void zza() {
        synchronized (this.zzc.zzg) {
            zzt.zzn(this.zzc, this.zza);
            if (this.zzc.zzl.getAndIncrement() > 0) {
                this.zzc.zzc.zzc("Already connected to the service.", new Object[0]);
            }
            zzt.zzp(this.zzc, this.zzb);
        }
    }
}
