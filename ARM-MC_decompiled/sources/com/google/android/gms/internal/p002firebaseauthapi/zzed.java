package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzeg;
import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzed  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzed {
    private static final zzps<zzdz, zzba> zza = zzps.zza(new zzec(), zzdz.class, zzba.class);
    private static final zzor<zzeg> zzb = new zzef();
    private static final zzot<zzeg> zzc = new zzee();
    private static final zzbh<zzba> zzd = zzod.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", zzba.class, zzwx.zzb.SYMMETRIC, zzuj.zze());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zziv.zza.ALGORITHM_NOT_FIPS.zza()) {
            zzhb.zza();
            zzox zza2 = zzox.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_GCM_SIV", zzeg.zzc().zza(16).zza(zzeg.zzb.zza).zza());
            hashMap.put("AES128_GCM_SIV_RAW", zzeg.zzc().zza(16).zza(zzeg.zzb.zzc).zza());
            hashMap.put("AES256_GCM_SIV", zzeg.zzc().zza(32).zza(zzeg.zzb.zza).zza());
            hashMap.put("AES256_GCM_SIV_RAW", zzeg.zzc().zza(32).zza(zzeg.zzb.zzc).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zzou.zza().zza(zzc, zzeg.class);
            zzop.zza().zza(zzb, zzeg.class);
            zzpa.zza().zza(zza);
            zznq.zza().zza(zzd, true);
            return;
        }
        throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
    }
}
