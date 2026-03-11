package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzmp implements zzbg {
    public static zzbg zza(zzof zzof) throws GeneralSecurityException {
        byte[] bArr;
        zzqb zza = zzof.zza(zzbf.zza());
        zzbg zzbg = (zzbg) zznq.zza().zza(zza.zzf(), zzbg.class).zzb(zza.zzd());
        zzxz zzb = zza.zzb();
        int i = zzmo.zza[zzb.ordinal()];
        if (i == 1) {
            bArr = zzpe.zza.zzb();
        } else if (i == 2 || i == 3) {
            bArr = zzpe.zza(zzof.zzb().intValue()).zzb();
        } else if (i == 4) {
            bArr = zzpe.zzb(zzof.zzb().intValue()).zzb();
        } else {
            throw new GeneralSecurityException("unknown output prefix type " + String.valueOf(zzb));
        }
        return new zzmp(zzbg, bArr);
    }

    private zzmp(zzbg zzbg, byte[] bArr) {
    }
}
