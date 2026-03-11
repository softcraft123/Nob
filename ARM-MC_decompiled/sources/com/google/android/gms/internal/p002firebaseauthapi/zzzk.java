package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzzk implements zzba {
    private final zzaaa zza;
    private final zzcc zzb;
    private final int zzc;
    private final byte[] zzd;

    public static zzba zza(zzdd zzdd) throws GeneralSecurityException {
        return new zzzk(new zzyu(zzdd.zzf().zza(zzbf.zza()), ((zzdi) ((zzcy) zzdd.zza())).zzd()), new zzaag(new zzaae("HMAC" + String.valueOf(((zzdi) ((zzcy) zzdd.zza())).zzg()), new SecretKeySpec(zzdd.zzg().zza(zzbf.zza()), "HMAC")), ((zzdi) ((zzcy) zzdd.zza())).zze()), ((zzdi) ((zzcy) zzdd.zza())).zze(), zzdd.zzd().zzb());
    }

    private zzzk(zzaaa zzaaa, zzcc zzcc, int i, byte[] bArr) {
        this.zza = zzaaa;
        this.zzb = zzcc;
        this.zzc = i;
        this.zzd = bArr;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzc;
        byte[] bArr3 = this.zzd;
        if (length < i + bArr3.length) {
            throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
        } else if (zzqn.zza(bArr3, bArr)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, this.zzd.length, bArr.length - this.zzc);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.zzc, bArr.length);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            this.zzb.zza(copyOfRange2, zzyz.zza(bArr2, copyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8)));
            return this.zza.zza(copyOfRange);
        } else {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzb2 = this.zza.zzb(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return zzyz.zza(this.zzd, zzb2, this.zzb.zza(zzyz.zza(bArr2, zzb2, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8))));
    }
}
