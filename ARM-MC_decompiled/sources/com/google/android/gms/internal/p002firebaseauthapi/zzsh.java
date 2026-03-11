package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import java.security.GeneralSecurityException;
import java.security.Provider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzsh implements zzqw {
    private static final zziv.zza zza = zziv.zza.ALGORITHM_NOT_FIPS;

    public static zzqw zza(zzqp zzqp) throws GeneralSecurityException {
        if (zza.zza()) {
            Provider zza2 = zznh.zza();
            if (zza2 != null) {
                try {
                    return zzse.zza(zzqp, zza2);
                } catch (GeneralSecurityException unused) {
                }
            }
            return new zzsh(zzqp);
        }
        throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
    }

    private zzsh(zzqp zzqp) {
    }
}
