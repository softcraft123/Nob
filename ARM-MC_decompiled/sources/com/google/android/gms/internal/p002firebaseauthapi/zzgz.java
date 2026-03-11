package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzgz implements zzba {
    private static final byte[] zza = zzzx.zza("7a806c");
    private static final byte[] zzb = zzzx.zza("46bb91c3c5");
    private static final byte[] zzc = zzzx.zza("36864200e0eaf5284d884a0e77d31646");
    private static final byte[] zzd = zzzx.zza("bae8e37fc83441b16034566b");
    private static final byte[] zze = zzzx.zza("af60eb711bd85bc1e4d3e0a462e074eea428a8");
    private final zzhc<Cipher> zzf;
    private final SecretKey zzg;
    private final byte[] zzh;

    public static zzba zza(zzdz zzdz, zzhc<Cipher> zzhc) throws GeneralSecurityException {
        if (zza(zzhc.zza())) {
            return new zzgz(zzdz.zzf().zza(zzbf.zza()), zzdz.zzd().zzb(), zzhc);
        }
        throw new IllegalStateException("Cipher does not implement AES GCM SIV.");
    }

    private static AlgorithmParameterSpec zza(byte[] bArr, int i, int i2) {
        return new GCMParameterSpec(128, bArr, i, i2);
    }

    private zzgz(byte[] bArr, byte[] bArr2, zzhc<Cipher> zzhc) throws GeneralSecurityException {
        this.zzh = bArr2;
        zzaai.zza(bArr.length);
        this.zzg = new SecretKeySpec(bArr, "AES");
        this.zzf = zzhc;
    }

    public static boolean zza(Cipher cipher) {
        try {
            byte[] bArr = zzd;
            cipher.init(2, new SecretKeySpec(zzc, "AES"), zza(bArr, 0, bArr.length));
            cipher.updateAAD(zzb);
            byte[] bArr2 = zze;
            return MessageDigest.isEqual(cipher.doFinal(bArr2, 0, bArr2.length), zza);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.zzh;
        if (length < bArr3.length + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        } else if (zzqn.zza(bArr3, bArr)) {
            Cipher zza2 = this.zzf.zza();
            zza2.init(2, this.zzg, zza(bArr, this.zzh.length, 12));
            if (!(bArr2 == null || bArr2.length == 0)) {
                zza2.updateAAD(bArr2);
            }
            byte[] bArr4 = this.zzh;
            return zza2.doFinal(bArr, bArr4.length + 12, (bArr.length - bArr4.length) - 12);
        } else {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher zza2 = this.zzf.zza();
        int length = bArr.length;
        byte[] bArr3 = this.zzh;
        if (length <= 2147483619 - bArr3.length) {
            byte[] copyOf = Arrays.copyOf(bArr3, bArr3.length + 12 + bArr.length + 16);
            byte[] zza3 = zzqd.zza(12);
            System.arraycopy(zza3, 0, copyOf, this.zzh.length, 12);
            zza2.init(1, this.zzg, zza(zza3, 0, zza3.length));
            if (!(bArr2 == null || bArr2.length == 0)) {
                zza2.updateAAD(bArr2);
            }
            byte[] bArr4 = bArr;
            int doFinal = zza2.doFinal(bArr4, 0, bArr.length, copyOf, this.zzh.length + 12);
            if (doFinal == bArr4.length + 16) {
                return copyOf;
            }
            throw new GeneralSecurityException(String.format("encryption failed; AES-GCM-SIV tag must be %s bytes, but got only %s bytes", new Object[]{16, Integer.valueOf(doFinal - bArr4.length)}));
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
