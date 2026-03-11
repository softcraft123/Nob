package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqu;
import com.google.android.gms.internal.p002firebaseauthapi.zzrh;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaag  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzaag implements zzcc {
    private static final byte[] zza = {0};
    private final zzsq zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    public static zzcc zza(zzqp zzqp) throws GeneralSecurityException {
        return new zzaag(zzqp);
    }

    public static zzcc zza(zzra zzra) throws GeneralSecurityException {
        return new zzaag(zzra);
    }

    private zzaag(zzqp zzqp) throws GeneralSecurityException {
        this.zzb = zzzz.zza(zzso.zza(zzsr.zza(((zzqu) ((zzrn) zzqp.zza())).zzc()), zzqp.zzf()));
        this.zzc = ((zzqu) ((zzrn) zzqp.zza())).zzb();
        this.zzd = zzqp.zze().zzb();
        if (((zzqu) ((zzrn) zzqp.zza())).zze().equals(zzqu.zza.zzc)) {
            byte[] bArr = zza;
            this.zze = Arrays.copyOf(bArr, bArr.length);
            return;
        }
        this.zze = new byte[0];
    }

    private zzaag(zzra zzra) throws GeneralSecurityException {
        this.zzb = new zzaae("HMAC" + String.valueOf(((zzrh) ((zzrn) zzra.zza())).zze()), new SecretKeySpec(zzra.zzf().zza(zzbf.zza()), "HMAC"));
        this.zzc = ((zzrh) ((zzrn) zzra.zza())).zzb();
        this.zzd = zzra.zze().zzb();
        if (((zzrh) ((zzrn) zzra.zza())).zzf().equals(zzrh.zzc.zzc)) {
            byte[] bArr = zza;
            this.zze = Arrays.copyOf(bArr, bArr.length);
            return;
        }
        this.zze = new byte[0];
    }

    public zzaag(zzsq zzsq, int i) throws GeneralSecurityException {
        this.zzb = zzsq;
        this.zzc = i;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        if (i >= 10) {
            zzsq.zza(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!MessageDigest.isEqual(zza(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = this.zze;
        if (bArr2.length > 0) {
            return zzyz.zza(this.zzd, this.zzb.zza(zzyz.zza(bArr, bArr2), this.zzc));
        }
        return zzyz.zza(this.zzd, this.zzb.zza(bArr, this.zzc));
    }
}
