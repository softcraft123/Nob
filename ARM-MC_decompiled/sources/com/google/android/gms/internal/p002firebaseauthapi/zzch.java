package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzch  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzch {
    private static final zzch zza = new zzch();

    static zzch zza() {
        return zza;
    }

    public static zzch zza(@Nullable zzch zzch) throws GeneralSecurityException {
        if (zzch != null) {
            return zzch;
        }
        throw new GeneralSecurityException("SecretKeyAccess is required");
    }

    private zzch() {
    }
}
