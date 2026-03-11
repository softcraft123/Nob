package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzsm implements zzcc {
    private static final byte[] zza = {0};
    private final zzcc zzb;
    private final zzxz zzc;
    private final byte[] zzd;

    public static zzcc zza(zzof zzof) throws GeneralSecurityException {
        byte[] bArr;
        zzqb zza2 = zzof.zza(zzbf.zza());
        zzcc zzcc = (zzcc) zznq.zza().zza(zza2.zzf(), zzcc.class).zzb(zza2.zzd());
        zzxz zzb2 = zza2.zzb();
        int i = zzsp.zza[zzb2.ordinal()];
        if (i == 1) {
            bArr = zzpe.zza.zzb();
        } else if (i == 2 || i == 3) {
            bArr = zzpe.zza(zzof.zzb().intValue()).zzb();
        } else if (i == 4) {
            bArr = zzpe.zzb(zzof.zzb().intValue()).zzb();
        } else {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return new zzsm(zzcc, zzb2, bArr);
    }

    private zzsm(zzcc zzcc, zzxz zzxz, byte[] bArr) {
        this.zzb = zzcc;
        this.zzc = zzxz;
        this.zzd = bArr;
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length >= 10) {
            if (this.zzc.equals(zzxz.LEGACY)) {
                bArr2 = zzyz.zza(bArr2, zza);
            }
            byte[] bArr3 = new byte[0];
            if (!this.zzc.equals(zzxz.RAW)) {
                byte[] copyOf = Arrays.copyOf(bArr, 5);
                bArr = Arrays.copyOfRange(bArr, 5, bArr.length);
                bArr3 = copyOf;
            }
            if (Arrays.equals(this.zzd, bArr3)) {
                this.zzb.zza(bArr, bArr2);
                return;
            }
            throw new GeneralSecurityException("wrong prefix");
        }
        throw new GeneralSecurityException("tag too short");
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        if (this.zzc.equals(zzxz.LEGACY)) {
            bArr = zzyz.zza(bArr, zza);
        }
        return zzyz.zza(this.zzd, this.zzb.zza(bArr));
    }
}
