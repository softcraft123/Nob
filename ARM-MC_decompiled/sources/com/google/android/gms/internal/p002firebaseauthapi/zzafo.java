package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public class zzafo {
    zzaeo zza;
    Executor zzb;

    public final <ResultT> Task<ResultT> zza(zzafq<ResultT> zzafq) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzb.execute(new zzafr(this, zzafq, taskCompletionSource));
        return taskCompletionSource.getTask();
    }
}
