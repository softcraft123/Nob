package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Job;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final /* synthetic */ class zzbu implements OnCompleteListener {
    public final /* synthetic */ CompletableDeferred zza;

    public /* synthetic */ zzbu(CompletableDeferred completableDeferred) {
        this.zza = completableDeferred;
    }

    public final void onComplete(Task task) {
        CompletableDeferred completableDeferred = this.zza;
        Exception exception = task.getException();
        if (exception != null) {
            completableDeferred.completeExceptionally(exception);
        } else if (task.isCanceled()) {
            Job.DefaultImpls.cancel$default((Job) completableDeferred, (CancellationException) null, 1, (Object) null);
        } else {
            completableDeferred.complete(task.getResult());
        }
    }
}
