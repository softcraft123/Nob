package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public class PhoneMultiFactorAssertion extends MultiFactorAssertion {
    private final PhoneAuthCredential zza;

    public final PhoneAuthCredential zza() {
        return this.zza;
    }

    public String getFactorId() {
        return "phone";
    }

    public PhoneMultiFactorAssertion(PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkNotNull(phoneAuthCredential);
        this.zza = phoneAuthCredential;
    }
}
