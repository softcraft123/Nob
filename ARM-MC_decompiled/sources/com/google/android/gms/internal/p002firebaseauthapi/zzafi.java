package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzafi implements zzafm {
    private final /* synthetic */ PhoneAuthCredential zza;

    zzafi(zzafh zzafh, PhoneAuthCredential phoneAuthCredential) {
        this.zza = phoneAuthCredential;
        Objects.requireNonNull(zzafh);
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationCompleted(this.zza);
    }
}
