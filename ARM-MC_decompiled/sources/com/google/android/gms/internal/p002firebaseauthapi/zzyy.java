package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzyy implements zzba {
    private static final zziv.zza zza = zziv.zza.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final SecretKey zzb;
    private final byte[] zzc;

    public static zzba zza(zzds zzds) throws GeneralSecurityException {
        if (((zzdx) ((zzcy) zzds.zza())).zzb() != 12) {
            throw new GeneralSecurityException("Expected IV Size 12, got " + ((zzdx) ((zzcy) zzds.zza())).zzb());
        } else if (((zzdx) ((zzcy) zzds.zza())).zzd() == 16) {
            return new zzyy(zzds.zzf().zza(zzbf.zza()), zzds.zzd());
        } else {
            throw new GeneralSecurityException("Expected tag Size 16, got " + ((zzdx) ((zzcy) zzds.zza())).zzd());
        }
    }

    private zzyy(byte[] bArr, zzaaj zzaaj) throws GeneralSecurityException {
        if (zza.zza()) {
            this.zzb = zzgr.zzb(bArr);
            this.zzc = zzaaj.zzb();
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr != null) {
            int length = bArr.length;
            byte[] bArr3 = this.zzc;
            if (length < bArr3.length + 28) {
                throw new GeneralSecurityException("ciphertext too short");
            } else if (zzqn.zza(bArr3, bArr)) {
                AlgorithmParameterSpec zza2 = zzgr.zza(bArr, this.zzc.length, 12);
                Cipher zza3 = zzgr.zza();
                zza3.init(2, this.zzb, zza2);
                if (!(bArr2 == null || bArr2.length == 0)) {
                    zza3.updateAAD(bArr2);
                }
                byte[] bArr4 = this.zzc;
                return zza3.doFinal(bArr, bArr4.length + 12, (bArr.length - bArr4.length) - 12);
            } else {
                throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
            }
        } else {
            throw new NullPointerException("ciphertext is null");
        }
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr != null) {
            byte[] zza2 = zzqd.zza(12);
            AlgorithmParameterSpec zza3 = zzgr.zza(zza2);
            Cipher zza4 = zzgr.zza();
            zza4.init(1, this.zzb, zza3);
            if (!(bArr2 == null || bArr2.length == 0)) {
                zza4.updateAAD(bArr2);
            }
            int outputSize = zza4.getOutputSize(bArr.length);
            byte[] bArr3 = this.zzc;
            if (outputSize <= 2147483635 - bArr3.length) {
                byte[] copyOf = Arrays.copyOf(bArr3, bArr3.length + 12 + outputSize);
                System.arraycopy(zza2, 0, copyOf, this.zzc.length, 12);
                if (zza4.doFinal(bArr, 0, bArr.length, copyOf, this.zzc.length + 12) == outputSize) {
                    return copyOf;
                }
                throw new GeneralSecurityException("not enough data written");
            }
            throw new GeneralSecurityException("plaintext too long");
        }
        throw new NullPointerException("plaintext is null");
    }
}
