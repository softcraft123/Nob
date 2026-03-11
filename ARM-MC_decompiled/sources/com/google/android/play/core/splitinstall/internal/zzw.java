package com.google.android.play.core.splitinstall.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final /* synthetic */ class zzw implements OnCompleteListener {
    public final /* synthetic */ zzaf zza;
    public final /* synthetic */ TaskCompletionSource zzb;

    public /* synthetic */ zzw(zzaf zzaf, TaskCompletionSource taskCompletionSource) {
        this.zza = zzaf;
        this.zzb = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.zza.zzt(this.zzb, task);
    }
}
