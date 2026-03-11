package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.OnFailureListener;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzage  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzage implements OnFailureListener {
    zzage(zzagc zzagc) {
        Objects.requireNonNull(zzagc);
    }

    public final void onFailure(Exception exc) {
        zzagc.zza.e("SmsRetrieverClient failed to start: " + exc.getMessage(), new Object[0]);
    }
}
