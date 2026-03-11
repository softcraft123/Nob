package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaam  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzaam {
    private final BigInteger zza;

    public static zzaam zza(BigInteger bigInteger, zzch zzch) {
        if (zzch != null) {
            return new zzaam(bigInteger);
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public final BigInteger zza(zzch zzch) {
        if (zzch != null) {
            return this.zza;
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    private zzaam(BigInteger bigInteger) {
        this.zza = bigInteger;
    }
}
