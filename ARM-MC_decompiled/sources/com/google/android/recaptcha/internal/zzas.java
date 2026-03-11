package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import kotlinx.coroutines.Deferred;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzas {
    public static final Task zza(Deferred deferred) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(new CancellationTokenSource().getToken());
        deferred.invokeOnCompletion(new zzar(taskCompletionSource, deferred));
        return taskCompletionSource.getTask();
    }
}
