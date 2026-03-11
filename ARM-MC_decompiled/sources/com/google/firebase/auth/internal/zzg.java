package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzg implements OnSuccessListener<String> {
    private final /* synthetic */ TaskCompletionSource zza;

    zzg(zzb zzb, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
        Objects.requireNonNull(zzb);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zza.setResult(new zzm().zzc((String) obj).zza());
    }
}
