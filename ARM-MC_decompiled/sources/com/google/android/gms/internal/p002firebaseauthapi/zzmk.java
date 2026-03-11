package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzkg;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzmk {
    public static final byte[] zza = zza(1, 0);
    public static final byte[] zzb = zza(2, 32);
    public static final byte[] zzc = zza(2, 16);
    public static final byte[] zzd = zza(2, 17);
    public static final byte[] zze = zza(2, 18);
    public static final byte[] zzf = zza(2, 1);
    public static final byte[] zzg = zza(2, 2);
    public static final byte[] zzh = zza(2, 3);
    public static final byte[] zzi = zza(2, 1);
    public static final byte[] zzj = zza(2, 2);
    public static final byte[] zzk = zza(2, 3);
    public static final byte[] zzl = new byte[0];
    private static final byte[] zzm = "KEM".getBytes(zzqn.zza);
    private static final byte[] zzn = "HPKE".getBytes(zzqn.zza);
    private static final byte[] zzo = "HPKE-v1".getBytes(zzqn.zza);

    public static int zza(zzkg.zzf zzf2) throws GeneralSecurityException {
        if (zzf2 == zzkg.zzf.zzd || zzf2 == zzkg.zzf.zza) {
            return 32;
        }
        if (zzf2 == zzkg.zzf.zzb) {
            return 48;
        }
        if (zzf2 == zzkg.zzf.zzc) {
            return 66;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    public static int zzb(zzkg.zzf zzf2) throws GeneralSecurityException {
        if (zzf2 == zzkg.zzf.zzd) {
            return 32;
        }
        if (zzf2 == zzkg.zzf.zza) {
            return 65;
        }
        if (zzf2 == zzkg.zzf.zzb) {
            return 97;
        }
        if (zzf2 == zzkg.zzf.zzc) {
            return 133;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    static zzzi zzc(zzkg.zzf zzf2) throws GeneralSecurityException {
        if (zzf2 == zzkg.zzf.zza) {
            return zzzi.NIST_P256;
        }
        if (zzf2 == zzkg.zzf.zzb) {
            return zzzi.NIST_P384;
        }
        if (zzf2 == zzkg.zzf.zzc) {
            return zzzi.NIST_P521;
        }
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }

    static {
        zza(1, 2);
    }

    static byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return zzyz.zza(zzn, bArr, bArr2, bArr3);
    }

    private static byte[] zza(int i, int i2) {
        if (i > 4 || i < 0) {
            throw new IllegalArgumentException("capacity must be between 0 and 4");
        } else if (i2 < 0 || (i < 4 && i2 >= (1 << (i << 3)))) {
            throw new IllegalArgumentException("value too large");
        } else {
            byte[] bArr = new byte[i];
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) (i2 >> (((i - i3) - 1) * 8));
            }
            return bArr;
        }
    }

    static byte[] zza(byte[] bArr) throws GeneralSecurityException {
        return zzyz.zza(zzm, bArr);
    }

    static byte[] zza(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzyz.zza(zzo, bArr2, str.getBytes(zzqn.zza), bArr);
    }

    static byte[] zza(String str, byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        return zzyz.zza(zza(2, i), zzo, bArr2, str.getBytes(zzqn.zza), bArr);
    }
}
