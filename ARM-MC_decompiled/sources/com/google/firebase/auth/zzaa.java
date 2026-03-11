package com.google.firebase.auth;

import com.google.android.gms.internal.p002firebaseauthapi.zzac;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaTasksClient;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzaa implements Continuation<RecaptchaTasksClient, Task<Void>> {
    public final /* synthetic */ Object then(Task task) throws Exception {
        if (task.isSuccessful()) {
            return Tasks.forResult(null);
        }
        Exception exception = task.getException();
        return Tasks.forException(new FirebaseAuthException("INTERNAL_ERROR", zzac.zzb(exception != null ? exception.getMessage() : "")));
    }

    zzaa(FirebaseAuth firebaseAuth) {
        Objects.requireNonNull(firebaseAuth);
    }
}
