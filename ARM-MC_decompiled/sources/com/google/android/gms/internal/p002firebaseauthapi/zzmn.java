package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzmn implements zzbd {
    private final zzbd zza;
    private final byte[] zzb;

    public static zzbd zza(zzof zzof) throws GeneralSecurityException {
        byte[] bArr;
        zzqb zza2 = zzof.zza(zzbf.zza());
        zzbd zzbd = (zzbd) zznq.zza().zza(zza2.zzf(), zzbd.class).zzb(zza2.zzd());
        zzxz zzb2 = zza2.zzb();
        int i = zzmm.zza[zzb2.ordinal()];
        if (i == 1) {
            bArr = zzpe.zza.zzb();
        } else if (i == 2 || i == 3) {
            bArr = zzpe.zza(zzof.zzb().intValue()).zzb();
        } else if (i == 4) {
            bArr = zzpe.zzb(zzof.zzb().intValue()).zzb();
        } else {
            throw new GeneralSecurityException("unknown output prefix type " + String.valueOf(zzb2));
        }
        return new zzmn(zzbd, bArr);
    }

    private zzmn(zzbd zzbd, byte[] bArr) {
        this.zza = zzbd;
        this.zzb = bArr;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzqn.zza(bArr3, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, this.zzb.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
    }
}
