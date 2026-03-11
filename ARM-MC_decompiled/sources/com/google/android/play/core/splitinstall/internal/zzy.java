package com.google.android.play.core.splitinstall.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzy extends zzv {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzv zzb;
    final /* synthetic */ zzaf zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzy(zzaf zzaf, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzv zzv) {
        super(taskCompletionSource);
        this.zzc = zzaf;
        this.zza = taskCompletionSource2;
        this.zzb = zzv;
    }

    public final void zzc() {
        synchronized (this.zzc.zzg) {
            zzaf.zzn(this.zzc, this.zza);
            if (this.zzc.zzl.getAndIncrement() > 0) {
                this.zzc.zzc.zzd("Already connected to the service.", new Object[0]);
            }
            zzaf.zzp(this.zzc, this.zzb);
        }
    }
}
