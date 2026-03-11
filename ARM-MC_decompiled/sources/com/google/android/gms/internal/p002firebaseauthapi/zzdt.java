package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdx;
import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzdt {
    private static final zzps<zzds, zzba> zza = zzps.zza(new zzdw(), zzds.class, zzba.class);
    private static final zzbh<zzba> zzb = zzod.zza("type.googleapis.com/google.crypto.tink.AesGcmKey", zzba.class, zzwx.zzb.SYMMETRIC, zzud.zze());
    private static final zzot<zzdx> zzc = new zzdv();
    private static final zzor<zzdx> zzd = new zzdy();
    private static final zziv.zza zze = zziv.zza.ALGORITHM_REQUIRES_BORINGCRYPTO;

    public static /* synthetic */ zzds zza(zzdx zzdx, Integer num) {
        if (zzdx.zzc() != 24) {
            return zzds.zze().zza(zzdx).zza(num).zza(zzaal.zza(zzdx.zzc())).zza();
        }
        throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
    }

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zziv.zza zza2 = zze;
        if (zza2.zza()) {
            zzgt.zza();
            zzpa.zza().zza(zza);
            zzox zza3 = zzox.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_GCM", zzfm.zza);
            hashMap.put("AES128_GCM_RAW", zzdx.zze().zza(12).zzb(16).zzc(16).zza(zzdx.zza.zzc).zza());
            hashMap.put("AES256_GCM", zzfm.zzb);
            hashMap.put("AES256_GCM_RAW", zzdx.zze().zza(12).zzb(32).zzc(16).zza(zzdx.zza.zzc).zza());
            zza3.zza(Collections.unmodifiableMap(hashMap));
            zzou.zza().zza(zzc, zzdx.class);
            zzop.zza().zza(zzd, zzdx.class);
            zznq.zza().zza(zzb, zza2, true);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }
}
