package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzair;
import com.google.android.gms.internal.p002firebaseauthapi.zzaix;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.internal.zzcc;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzt implements Continuation<zzair, Task<TotpSecret>> {
    private final /* synthetic */ FirebaseAuth zza;

    public final /* synthetic */ Object then(Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException((Exception) Preconditions.checkNotNull(task.getException()));
        }
        zzair zzair = (zzair) task.getResult();
        if (zzair instanceof zzaix) {
            zzaix zzaix = (zzaix) zzair;
            return Tasks.forResult(new zzcc(Preconditions.checkNotEmpty(zzaix.zzf()), Preconditions.checkNotEmpty(zzaix.zze()), zzaix.zzc(), zzaix.zzb(), zzaix.zzd(), Preconditions.checkNotEmpty(zzaix.zza()), this.zza));
        }
        throw new IllegalArgumentException("Response should be an instance of StartTotpMfaEnrollmentResponse but was " + zzair.getClass().getName() + ".");
    }

    zzt(FirebaseAuth firebaseAuth) {
        Objects.requireNonNull(firebaseAuth);
        this.zza = firebaseAuth;
    }
}
