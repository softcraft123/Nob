package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdx;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzlp implements zzlr {
    private final int zza;

    public final int zza() {
        return this.zza;
    }

    public zzlp(zzdx zzdx) throws GeneralSecurityException {
        if (zzdx.zzb() != 12) {
            throw new GeneralSecurityException("invalid IV size");
        } else if (zzdx.zzd() != 16) {
            throw new GeneralSecurityException("invalid tag size");
        } else if (zzdx.zzf() == zzdx.zza.zzc) {
            this.zza = zzdx.zzc();
        } else {
            throw new GeneralSecurityException("invalid variant");
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        if (bArr2.length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        } else if (bArr.length == this.zza) {
            SecretKey zzb = zzgr.zzb(bArr);
            int i2 = i + 12;
            if (bArr2.length >= i + 28) {
                AlgorithmParameterSpec zza2 = zzgr.zza(bArr2, i, 12);
                Cipher zza3 = zzgr.zza();
                zza3.init(2, zzb, zza2);
                return zza3.doFinal(bArr2, i2, (bArr2.length - i) - 12);
            }
            throw new GeneralSecurityException("ciphertext too short");
        } else {
            throw new GeneralSecurityException("invalid key size");
        }
    }
}
