package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzib  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzib implements zzba {
    private final byte[] zza;
    private final int zzb;
    private final zzsq zzc;

    public static zzba zza(zzfw zzfw) throws GeneralSecurityException {
        if (((zzfz) ((zzcy) zzfw.zza())).zzb() >= 8 && ((zzfz) ((zzcy) zzfw.zza())).zzb() <= 12) {
            return new zzib(zzfw.zze().zza(zzbf.zza()), zzfw.zzd(), ((zzfz) ((zzcy) zzfw.zza())).zzb());
        }
        throw new GeneralSecurityException("invalid salt size");
    }

    private zzib(byte[] bArr, zzaaj zzaaj, int i) throws GeneralSecurityException {
        this.zzc = zzzz.zza(zzso.zza(zzsr.zza(bArr.length), zzaal.zza(bArr, zzbf.zza())));
        this.zza = zzaaj.zzb();
        this.zzb = i;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr != null) {
            int length = bArr.length;
            byte[] bArr3 = this.zza;
            if (length < bArr3.length + this.zzb + 28) {
                throw new GeneralSecurityException("ciphertext too short");
            } else if (zzqn.zza(bArr3, bArr)) {
                int length2 = this.zza.length + this.zzb;
                int i = length2 + 12;
                return new zzhs(zza(Arrays.copyOfRange(bArr, this.zza.length, length2))).zza(Arrays.copyOfRange(bArr, length2, i), bArr, i, bArr2);
            } else {
                throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
            }
        } else {
            throw new NullPointerException("ciphertext is null");
        }
    }

    private final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = {0, 1, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] bArr3 = {0, 2, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        if (bArr.length > 12 || bArr.length < 8) {
            throw new GeneralSecurityException("invalid salt size");
        }
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        System.arraycopy(bArr, 0, bArr3, 4, bArr.length);
        byte[] bArr4 = new byte[32];
        System.arraycopy(this.zzc.zza(bArr2, 16), 0, bArr4, 0, 16);
        System.arraycopy(this.zzc.zza(bArr3, 16), 0, bArr4, 16, 16);
        return bArr4;
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr != null) {
            byte[] zza2 = zzqd.zza(this.zzb + 12);
            byte[] copyOf = Arrays.copyOf(zza2, this.zzb);
            int i = this.zzb;
            byte[] copyOfRange = Arrays.copyOfRange(zza2, i, i + 12);
            byte[] zzb2 = new zzhs(zza(copyOf)).zzb(copyOfRange, bArr, this.zza.length + this.zzb + copyOfRange.length, bArr2);
            byte[] bArr3 = this.zza;
            System.arraycopy(bArr3, 0, zzb2, 0, bArr3.length);
            System.arraycopy(zza2, 0, zzb2, this.zza.length, zza2.length);
            return zzb2;
        }
        throw new NullPointerException("plaintext is null");
    }
}
