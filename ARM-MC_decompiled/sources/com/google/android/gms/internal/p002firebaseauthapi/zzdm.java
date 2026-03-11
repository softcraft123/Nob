package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdq;
import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzdm {
    private static final zzps<zzdl, zzba> zza = zzps.zza(new zzdp(), zzdl.class, zzba.class);
    private static final zzbh<zzba> zzb = zzod.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", zzba.class, zzwx.zzb.SYMMETRIC, zztu.zzf());
    private static final zzor<zzdq> zzc = new zzdo();

    public static /* synthetic */ zzdl zza(zzdq zzdq, Integer num) {
        if (zzdq.zzc() != 24) {
            return zzdl.zze().zza(zzdq).zza(num).zza(zzaal.zza(zzdq.zzc())).zza();
        }
        throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
    }

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zziv.zza.ALGORITHM_NOT_FIPS.zza()) {
            zzgl.zza();
            zzpa.zza().zza(zza);
            zzox zza2 = zzox.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_EAX", zzfm.zzc);
            hashMap.put("AES128_EAX_RAW", zzdq.zze().zza(16).zzb(16).zzc(16).zza(zzdq.zzb.zzc).zza());
            hashMap.put("AES256_EAX", zzfm.zzd);
            hashMap.put("AES256_EAX_RAW", zzdq.zze().zza(16).zzb(32).zzc(16).zza(zzdq.zzb.zzc).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zzop.zza().zza(zzc, zzdq.class);
            zznq.zza().zza(zzb, true);
            return;
        }
        throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
    }
}
