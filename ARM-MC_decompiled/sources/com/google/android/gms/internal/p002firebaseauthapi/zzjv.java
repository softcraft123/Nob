package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzjv implements zzbe {
    private final zzbe zza;
    private final zzxz zzb;
    private final byte[] zzc;

    public static zzbe zza(zzof zzof) throws GeneralSecurityException {
        byte[] bArr;
        zzqb zza2 = zzof.zza(zzbf.zza());
        zzbe zzbe = (zzbe) zznq.zza().zza(zza2.zzf(), zzbe.class).zzb(zza2.zzd());
        zzxz zzb2 = zza2.zzb();
        int i = zzjy.zza[zzb2.ordinal()];
        if (i == 1) {
            bArr = zzpe.zza.zzb();
        } else if (i == 2 || i == 3) {
            bArr = zzpe.zza(zzof.zzb().intValue()).zzb();
        } else if (i == 4) {
            bArr = zzpe.zzb(zzof.zzb().intValue()).zzb();
        } else {
            throw new GeneralSecurityException("unknown output prefix type " + zzb2.zza());
        }
        return new zzjv(zzbe, zzb2, bArr);
    }

    private zzjv(zzbe zzbe, zzxz zzxz, byte[] bArr) {
        this.zza = zzbe;
        this.zzb = zzxz;
        this.zzc = bArr;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (this.zzb == zzxz.RAW) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzqn.zza(this.zzc, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("wrong prefix");
    }
}
