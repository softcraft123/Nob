package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import com.google.android.gms.internal.p002firebaseauthapi.zzrh;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzre  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzre {
    private static final zzps<zzra, zzqw> zza = zzps.zza(new zzrd(), zzra.class, zzqw.class);
    private static final zzps<zzra, zzcc> zzb = zzps.zza(new zzrg(), zzra.class, zzcc.class);
    private static final zzbh<zzcc> zzc = zzod.zza("type.googleapis.com/google.crypto.tink.HmacKey", zzcc.class, zzwx.zzb.SYMMETRIC, zzwb.zzg());
    private static final zzot<zzrh> zzd = new zzrf();
    private static final zzor<zzrh> zze = new zzri();
    private static final zziv.zza zzf = zziv.zza.ALGORITHM_REQUIRES_BORINGCRYPTO;

    static zzra zza(zzrh zzrh, @Nullable Integer num) throws GeneralSecurityException {
        return zzra.zzc().zza(zzrh).zza(zzaal.zza(zzrh.zzc())).zza(num).zza();
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zziv.zza zza2 = zzf;
        if (zza2.zza()) {
            zzsj.zza();
            zzpa.zza().zza(zza);
            zzpa.zza().zza(zzb);
            zzox zza3 = zzox.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("HMAC_SHA256_128BITTAG", zzrt.zza);
            hashMap.put("HMAC_SHA256_128BITTAG_RAW", zzrh.zzd().zza(32).zzb(16).zza(zzrh.zzc.zzd).zza(zzrh.zza.zzc).zza());
            hashMap.put("HMAC_SHA256_256BITTAG", zzrh.zzd().zza(32).zzb(32).zza(zzrh.zzc.zza).zza(zzrh.zza.zzc).zza());
            hashMap.put("HMAC_SHA256_256BITTAG_RAW", zzrh.zzd().zza(32).zzb(32).zza(zzrh.zzc.zzd).zza(zzrh.zza.zzc).zza());
            hashMap.put("HMAC_SHA512_128BITTAG", zzrh.zzd().zza(64).zzb(16).zza(zzrh.zzc.zza).zza(zzrh.zza.zze).zza());
            hashMap.put("HMAC_SHA512_128BITTAG_RAW", zzrh.zzd().zza(64).zzb(16).zza(zzrh.zzc.zzd).zza(zzrh.zza.zze).zza());
            hashMap.put("HMAC_SHA512_256BITTAG", zzrh.zzd().zza(64).zzb(32).zza(zzrh.zzc.zza).zza(zzrh.zza.zze).zza());
            hashMap.put("HMAC_SHA512_256BITTAG_RAW", zzrh.zzd().zza(64).zzb(32).zza(zzrh.zzc.zzd).zza(zzrh.zza.zze).zza());
            hashMap.put("HMAC_SHA512_512BITTAG", zzrt.zzb);
            hashMap.put("HMAC_SHA512_512BITTAG_RAW", zzrh.zzd().zza(64).zzb(64).zza(zzrh.zzc.zzd).zza(zzrh.zza.zze).zza());
            zza3.zza(Collections.unmodifiableMap(hashMap));
            zzop.zza().zza(zze, zzrh.class);
            zzou.zza().zza(zzd, zzrh.class);
            zznq.zza().zza(zzc, zza2, true);
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
