package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzco  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzco {
    private static final zznp zza = zzb();

    public static /* synthetic */ zzba zza(zzgb zzgb) {
        if (zzik.zza()) {
            return zzik.zza(zzgb);
        }
        return zzaak.zza(zzgb);
    }

    public static /* synthetic */ zzba zza(zzej zzej) {
        if (zzhh.zzb()) {
            return zzhh.zza(zzej);
        }
        return zzzc.zza(zzej);
    }

    public static zzbb zza() throws GeneralSecurityException {
        if (!zziv.zzb()) {
            return zza;
        }
        throw new GeneralSecurityException("Cannot use non-FIPS-compliant AeadConfigurationV1 in FIPS mode");
    }

    private static zznp zzb() {
        try {
            zzpy zza2 = zzpw.zza();
            zzcx.zza(zza2);
            zza2.zza(zzps.zza(new zzcn(), zzdd.class, zzba.class));
            zza2.zza(zzps.zza(new zzcq(), zzds.class, zzba.class));
            zza2.zza(zzps.zza(new zzcp(), zzdz.class, zzba.class));
            zza2.zza(zzps.zza(new zzcs(), zzdl.class, zzba.class));
            zza2.zza(zzps.zza(new zzcr(), zzej.class, zzba.class));
            zza2.zza(zzps.zza(new zzcu(), zzgb.class, zzba.class));
            zza2.zza(zzps.zza(new zzct(), zzfw.class, zzba.class));
            return zznp.zza(zza2.zza());
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
