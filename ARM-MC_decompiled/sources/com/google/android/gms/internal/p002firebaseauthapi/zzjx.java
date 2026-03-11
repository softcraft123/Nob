package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdi;
import com.google.android.gms.internal.p002firebaseauthapi.zzdx;
import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import com.google.android.gms.internal.p002firebaseauthapi.zzkb;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzjx {
    private static final zzps<zzke, zzbd> zza = zzps.zza(new zzka(), zzke.class, zzbd.class);
    private static final zzps<zzkh, zzbg> zzb = zzps.zza(new zzjz(), zzkh.class, zzbg.class);
    private static final zzcd<zzbd> zzc = zzod.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", zzbd.class, zzvn.zzf());
    private static final zzbh<zzbg> zzd = zzod.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", zzbg.class, zzwx.zzb.ASYMMETRIC_PUBLIC, zzvq.zzh());
    private static final zzor<zzkb> zze = new zzkc();

    public static /* synthetic */ zzke zza(zzkb zzkb, Integer num) {
        ECParameterSpec eCParameterSpec;
        zzkb.zzc zzd2 = zzkb.zzd();
        if (zzd2 == zzkb.zzc.zza) {
            eCParameterSpec = zznj.zza;
        } else if (zzd2 == zzkb.zzc.zzb) {
            eCParameterSpec = zznj.zzb;
        } else if (zzd2 == zzkb.zzc.zzc) {
            eCParameterSpec = zznj.zzc;
        } else {
            throw new GeneralSecurityException("Unsupported curve type: " + String.valueOf(zzd2));
        }
        KeyPair zza2 = zzzf.zza(eCParameterSpec);
        return zzke.zza(zzkh.zza(zzkb, ((ECPublicKey) zza2.getPublic()).getW(), num), zzaam.zza(((ECPrivateKey) zza2.getPrivate()).getS(), zzbf.zza()));
    }

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zziv.zza.ALGORITHM_NOT_FIPS.zza()) {
            zzlq.zza();
            zzox zza2 = zzox.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zzkb.zzc().zza(zzkb.zzc.zza).zza(zzkb.zzb.zzc).zza(zzkb.zze.zzb).zza(zzkb.zzd.zza).zza((zzcb) zzdx.zze().zza(12).zzb(16).zzc(16).zza(zzdx.zza.zzc).zza()).zza());
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzkb.zzc().zza(zzkb.zzc.zza).zza(zzkb.zzb.zzc).zza(zzkb.zze.zzb).zza(zzkb.zzd.zzc).zza((zzcb) zzdx.zze().zza(12).zzb(16).zzc(16).zza(zzdx.zza.zzc).zza()).zza());
            hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zzkb.zzc().zza(zzkb.zzc.zza).zza(zzkb.zzb.zzc).zza(zzkb.zze.zza).zza(zzkb.zzd.zza).zza((zzcb) zzdx.zze().zza(12).zzb(16).zzc(16).zza(zzdx.zza.zzc).zza()).zza());
            hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzkb.zzc().zza(zzkb.zzc.zza).zza(zzkb.zzb.zzc).zza(zzkb.zze.zza).zza(zzkb.zzd.zzc).zza((zzcb) zzdx.zze().zza(12).zzb(16).zzc(16).zza(zzdx.zza.zzc).zza()).zza());
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzkb.zzc().zza(zzkb.zzc.zza).zza(zzkb.zzb.zzc).zza(zzkb.zze.zza).zza(zzkb.zzd.zzc).zza((zzcb) zzdx.zze().zza(12).zzb(16).zzc(16).zza(zzdx.zza.zzc).zza()).zza());
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzkb.zzc().zza(zzkb.zzc.zza).zza(zzkb.zzb.zzc).zza(zzkb.zze.zzb).zza(zzkb.zzd.zza).zza((zzcb) zzdi.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdi.zza.zzc).zza(zzdi.zzc.zzc).zza()).zza());
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzkb.zzc().zza(zzkb.zzc.zza).zza(zzkb.zzb.zzc).zza(zzkb.zze.zzb).zza(zzkb.zzd.zzc).zza((zzcb) zzdi.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdi.zza.zzc).zza(zzdi.zzc.zzc).zza()).zza());
            hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzkb.zzc().zza(zzkb.zzc.zza).zza(zzkb.zzb.zzc).zza(zzkb.zze.zza).zza(zzkb.zzd.zza).zza((zzcb) zzdi.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdi.zza.zzc).zza(zzdi.zzc.zzc).zza()).zza());
            hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzkb.zzc().zza(zzkb.zzc.zza).zza(zzkb.zzb.zzc).zza(zzkb.zze.zza).zza(zzkb.zzd.zzc).zza((zzcb) zzdi.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdi.zza.zzc).zza(zzdi.zzc.zzc).zza()).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zzpa.zza().zza(zza);
            zzpa.zza().zza(zzb);
            zzop.zza().zza(zze, zzkb.class);
            zznq.zza().zza(zzc, true);
            zznq.zza().zza(zzd, false);
            return;
        }
        throw new GeneralSecurityException("Registering ECIES Hybrid Encryption is not supported in FIPS mode");
    }
}
