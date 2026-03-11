package com.google.android.play.core.review.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:review@@2.0.2 */
public final /* synthetic */ class zzl implements OnCompleteListener {
    public final /* synthetic */ zzt zza;
    public final /* synthetic */ TaskCompletionSource zzb;

    public /* synthetic */ zzl(zzt zzt, TaskCompletionSource taskCompletionSource) {
        this.zza = zzt;
        this.zzb = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.zza.zzt(this.zzb, task);
    }
}
