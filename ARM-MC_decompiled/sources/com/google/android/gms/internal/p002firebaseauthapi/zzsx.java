package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.Provider;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzsx implements zzsq {
    private static final zziv.zza zza = zziv.zza.ALGORITHM_NOT_FIPS;
    private final Key zzb;
    private final Provider zzc;

    public static zzsq zza(zzso zzso) throws GeneralSecurityException {
        Provider zza2 = zznh.zza();
        if (zza2 != null) {
            Mac.getInstance("AESCMAC", zza2);
            return new zzsx(zzso.zzd().zza(zzbf.zza()), zza2);
        }
        throw new GeneralSecurityException("Conscrypt not available");
    }

    private zzsx(byte[] bArr, Provider provider) throws GeneralSecurityException {
        if (zza.zza()) {
            this.zzb = new SecretKeySpec(bArr, "AES");
            this.zzc = provider;
            return;
        }
        throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode, as BoringCrypto module is not available");
    }

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        if (i <= 16) {
            Mac instance = Mac.getInstance("AESCMAC", this.zzc);
            instance.init(this.zzb);
            byte[] doFinal = instance.doFinal(bArr);
            if (i == doFinal.length) {
                return doFinal;
            }
            return Arrays.copyOf(doFinal, i);
        }
        throw new InvalidAlgorithmParameterException("outputLength must not be larger than 16");
    }
}
