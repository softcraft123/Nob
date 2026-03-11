package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzafk implements zzafm {
    private final /* synthetic */ Status zza;

    zzafk(zzafh zzafh, Status status) {
        this.zza = status;
        Objects.requireNonNull(zzafh);
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationFailed(zzaen.zza(this.zza));
    }
}
