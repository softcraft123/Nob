package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzia  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzia implements zzba {
    private final zzba zza;
    private final byte[] zzb;

    public static zzba zza(zzof zzof) throws GeneralSecurityException {
        byte[] bArr;
        zzqb zza2 = zzof.zza(zzbf.zza());
        zzba zzba = (zzba) zznq.zza().zza(zza2.zzf(), zzba.class).zzb(zza2.zzd());
        zzxz zzb2 = zza2.zzb();
        int i = zzhz.zza[zzb2.ordinal()];
        if (i == 1) {
            bArr = zzpe.zza.zzb();
        } else if (i == 2 || i == 3) {
            bArr = zzpe.zza(zzof.zzb().intValue()).zzb();
        } else if (i == 4) {
            bArr = zzpe.zzb(zzof.zzb().intValue()).zzb();
        } else {
            throw new GeneralSecurityException("unknown output prefix type " + String.valueOf(zzb2));
        }
        return new zzia(zzba, bArr);
    }

    public static zzba zza(zzba zzba, zzaaj zzaaj) {
        return new zzia(zzba, zzaaj.zzb());
    }

    private zzia(zzba zzba, byte[] bArr) {
        this.zza = zzba;
        if (bArr.length == 0 || bArr.length == 5) {
            this.zzb = bArr;
            return;
        }
        throw new IllegalArgumentException("identifier has an invalid length");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzqn.zza(bArr3, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("wrong prefix");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zzb(bArr, bArr2);
        }
        return zzyz.zza(bArr3, this.zza.zzb(bArr, bArr2));
    }
}
