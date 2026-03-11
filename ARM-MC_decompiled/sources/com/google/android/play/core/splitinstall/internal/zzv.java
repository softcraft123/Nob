package com.google.android.play.core.splitinstall.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public abstract class zzv implements Runnable {
    private final TaskCompletionSource zza;

    zzv() {
        this.zza = null;
    }

    public zzv(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void run() {
        try {
            zzc();
        } catch (Exception e) {
            zzb(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final TaskCompletionSource zza() {
        return this.zza;
    }

    public final void zzb(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.zza;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzc();
}
