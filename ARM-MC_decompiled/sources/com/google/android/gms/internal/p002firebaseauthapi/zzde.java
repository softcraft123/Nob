package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdi;
import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzde  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzde {
    private static final zzps<zzdd, zzba> zza = zzps.zza(new zzdh(), zzdd.class, zzba.class);
    private static final zzbh<zzba> zzb = zzod.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", zzba.class, zzwx.zzb.SYMMETRIC, zztf.zzf());
    private static final zzot<zzdi> zzc = new zzdg();
    private static final zzor<zzdi> zzd = new zzdj();
    private static final zziv.zza zze = zziv.zza.ALGORITHM_REQUIRES_BORINGCRYPTO;

    static zzdd zza(zzdi zzdi, @Nullable Integer num) throws GeneralSecurityException {
        if (zzdi.zzb() == 16 || zzdi.zzb() == 32) {
            return zzdd.zze().zza(zzdi).zza(num).zza(zzaal.zza(zzdi.zzb())).zzb(zzaal.zza(zzdi.zzc())).zza();
        }
        throw new GeneralSecurityException("AES key size must be 16 or 32 bytes");
    }

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zziv.zza zza2 = zze;
        if (zza2.zza()) {
            zzgg.zza();
            zzpa.zza().zza(zza);
            zzox zza3 = zzox.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_CTR_HMAC_SHA256", zzfm.zze);
            hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zzdi.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdi.zza.zzc).zza(zzdi.zzc.zzc).zza());
            hashMap.put("AES256_CTR_HMAC_SHA256", zzfm.zzf);
            hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzdi.zzf().zza(32).zzb(32).zzd(32).zzc(16).zza(zzdi.zza.zzc).zza(zzdi.zzc.zzc).zza());
            zza3.zza(Collections.unmodifiableMap(hashMap));
            zzou.zza().zza(zzc, zzdi.class);
            zzop.zza().zza(zzd, zzdi.class);
            zznq.zza().zza(zzb, zza2, true);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CTR-HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
