package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzmu implements zzmf {
    private final zzlz zza;
    private final zzmt zzb;

    zzmu(zzlz zzlz) {
        zzmt zzmt;
        this.zza = zzlz;
        try {
            zzmt = zzmv.zzb();
        } catch (GeneralSecurityException unused) {
            zzmt = new zzmx();
        }
        this.zzb = zzmt;
    }

    public final byte[] zza(byte[] bArr, zzme zzme) throws GeneralSecurityException {
        byte[] zza2 = this.zzb.zza(zzme.zza().zzb(), bArr);
        byte[] zza3 = zzyz.zza(bArr, zzme.zzb().zzb());
        byte[] zza4 = zzmk.zza(zzmk.zzb);
        zzlz zzlz = this.zza;
        return zzlz.zza((byte[]) null, zza2, "eae_prk", zza3, "shared_secret", zza4, zzlz.zza());
    }

    public final byte[] zza() throws GeneralSecurityException {
        if (Arrays.equals(this.zza.zzb(), zzmk.zzf)) {
            return zzmk.zzb;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
