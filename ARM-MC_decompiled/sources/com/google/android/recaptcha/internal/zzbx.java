package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzbx {
    public static final Deferred zza(Task task) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        task.addOnCompleteListener((Executor) zzbv.zza, new zzbu(CompletableDeferred$default));
        return new zzbw(CompletableDeferred$default);
    }
}
