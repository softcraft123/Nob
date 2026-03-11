package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.PhoneAuthProvider;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzafj implements zzafm {
    private final /* synthetic */ String zza;

    zzafj(zzafh zzafh, String str) {
        this.zza = str;
        Objects.requireNonNull(zzafh);
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeSent(this.zza, PhoneAuthProvider.ForceResendingToken.zza());
    }
}
