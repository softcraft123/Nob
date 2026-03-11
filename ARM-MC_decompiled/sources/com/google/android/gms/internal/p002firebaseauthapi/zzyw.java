package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzyw implements zzba {
    private static final zziv.zza zza = zziv.zza.ALGORITHM_NOT_FIPS;
    private static final ThreadLocal<Cipher> zzb = new zzyv();
    private final byte[] zzc;
    private final zzsq zzd;
    private final SecretKeySpec zze;
    private final int zzf;

    public static zzba zza(zzdl zzdl) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        } else if (((zzdq) ((zzcy) zzdl.zza())).zzd() == 16) {
            return new zzyw(zzdl.zzf().zza(zzbf.zza()), ((zzdq) ((zzcy) zzdl.zza())).zzb(), zzdl.zzd().zzb());
        } else {
            throw new GeneralSecurityException("AesEaxJce only supports 16 byte tag size, not " + ((zzdq) ((zzcy) zzdl.zza())).zzd());
        }
    }

    private zzyw(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        } else if (i == 12 || i == 16) {
            this.zzf = i;
            zzaai.zza(bArr.length);
            this.zze = new SecretKeySpec(bArr, "AES");
            this.zzd = zzzz.zza(zzso.zza(zzsr.zza(bArr.length), zzaal.zza(bArr, zzbf.zza())));
            this.zzc = bArr2;
        } else {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.zzc;
        int length2 = ((length - bArr3.length) - this.zzf) - 16;
        if (length2 < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        } else if (zzqn.zza(bArr3, bArr)) {
            byte[] zza2 = zza(0, bArr, this.zzc.length, this.zzf);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] zza3 = zza(1, bArr2, 0, bArr2.length);
            byte[] zza4 = zza(2, bArr, this.zzc.length + this.zzf, length2);
            int length3 = bArr.length - 16;
            byte b = 0;
            for (int i = 0; i < 16; i++) {
                b = (byte) (b | (((bArr[length3 + i] ^ zza3[i]) ^ zza2[i]) ^ zza4[i]));
            }
            if (b == 0) {
                Cipher cipher = zzb.get();
                cipher.init(1, this.zze, new IvParameterSpec(zza2));
                return cipher.doFinal(bArr, this.zzc.length + this.zzf, length2);
            }
            throw new AEADBadTagException("tag mismatch");
        } else {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.zzc;
        int length2 = Integer.MAX_VALUE - bArr3.length;
        int i = this.zzf;
        if (length <= (length2 - i) - 16) {
            byte[] copyOf = Arrays.copyOf(bArr3, bArr3.length + i + bArr.length + 16);
            byte[] zza2 = zzqd.zza(this.zzf);
            System.arraycopy(zza2, 0, copyOf, this.zzc.length, this.zzf);
            byte[] zza3 = zza(0, zza2, 0, zza2.length);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] zza4 = zza(1, bArr2, 0, bArr2.length);
            Cipher cipher = zzb.get();
            cipher.init(1, this.zze, new IvParameterSpec(zza3));
            byte[] bArr4 = bArr;
            cipher.doFinal(bArr4, 0, bArr.length, copyOf, this.zzc.length + this.zzf);
            byte[] zza5 = zza(2, copyOf, this.zzc.length + this.zzf, bArr4.length);
            int length3 = this.zzc.length + bArr4.length + this.zzf;
            for (int i2 = 0; i2 < 16; i2++) {
                copyOf[length3 + i2] = (byte) ((zza4[i2] ^ zza3[i2]) ^ zza5[i2]);
            }
            return copyOf;
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    private final byte[] zza(int i, byte[] bArr, int i2, int i3) throws GeneralSecurityException {
        byte[] bArr2 = new byte[(i3 + 16)];
        bArr2[15] = (byte) i;
        System.arraycopy(bArr, i2, bArr2, 16, i3);
        return this.zzd.zza(bArr2, 16);
    }
}
