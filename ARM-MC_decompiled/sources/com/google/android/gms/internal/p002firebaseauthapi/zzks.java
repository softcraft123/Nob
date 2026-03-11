package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzks  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzks {
    private static final zznp zza = zzb();

    public static zzbb zza() throws GeneralSecurityException {
        if (!zziv.zzb()) {
            return zza;
        }
        throw new GeneralSecurityException("Cannot use non-FIPS-compliant HybridConfigurationV1 in FIPS mode");
    }

    private static zznp zzb() {
        try {
            zzpy zza2 = zzpw.zza();
            zzld.zza(zza2);
            zza2.zza(zzps.zza(new zzkv(), zzkh.class, zzbg.class));
            zza2.zza(zzps.zza(new zzku(), zzkq.class, zzbg.class));
            zzkz.zza(zza2);
            zza2.zza(zzps.zza(new zzkx(), zzke.class, zzbd.class));
            zza2.zza(zzps.zza(new zzkw(), zzki.class, zzbd.class));
            return zznp.zza(zza2.zza());
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
