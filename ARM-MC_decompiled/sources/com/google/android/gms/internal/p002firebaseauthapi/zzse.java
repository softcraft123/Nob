package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzse  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzse implements zzqw {
    private static final zziv.zza zza = zziv.zza.ALGORITHM_NOT_FIPS;

    public static zzqw zza(zzqp zzqp, Provider provider) throws GeneralSecurityException {
        return new zzse(zzqp, provider);
    }

    private zzse(zzqp zzqp, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            throw new IllegalArgumentException("conscrypt is null");
        } else if (zza.zza()) {
            try {
                Mac.getInstance("AESCMAC", provider);
                zzqp.zze().zzb();
                new SecretKeySpec(zzqp.zzf().zza(zzbf.zza()), "AES");
            } catch (NoSuchAlgorithmException e) {
                throw new GeneralSecurityException("AES-CMAC not available.", e);
            }
        } else {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
    }
}
