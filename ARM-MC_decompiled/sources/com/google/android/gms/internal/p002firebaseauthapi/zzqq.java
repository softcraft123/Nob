package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import com.google.android.gms.internal.p002firebaseauthapi.zzqu;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzqq {
    private static final zzor<zzqu> zza = new zzqt();
    private static final zzps<zzqp, zzqw> zzb = zzps.zza(new zzqs(), zzqp.class, zzqw.class);
    private static final zzps<zzqp, zzcc> zzc = zzps.zza(new zzqv(), zzqp.class, zzcc.class);
    private static final zzbh<zzcc> zzd = zzod.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", zzcc.class, zzwx.zzb.SYMMETRIC, zzsw.zzf());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zziv.zza.ALGORITHM_NOT_FIPS.zza()) {
            zzrz.zza();
            zzop.zza().zza(zza, zzqu.class);
            zzpa.zza().zza(zzb);
            zzpa.zza().zza(zzc);
            zzox zza2 = zzox.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("AES_CMAC", zzrt.zzc);
            hashMap.put("AES256_CMAC", zzrt.zzc);
            hashMap.put("AES256_CMAC_RAW", zzqu.zzd().zza(32).zzb(16).zza(zzqu.zza.zzd).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zznq.zza().zza(zzd, true);
            return;
        }
        throw new GeneralSecurityException("Registering AES CMAC is not supported in FIPS mode");
    }

    /* access modifiers changed from: private */
    public static void zza(zzqu zzqu) throws GeneralSecurityException {
        if (zzqu.zzc() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }
}
