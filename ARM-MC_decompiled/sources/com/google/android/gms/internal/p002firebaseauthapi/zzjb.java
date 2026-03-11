package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import com.google.android.gms.internal.p002firebaseauthapi.zzjf;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzjb {
    private static final zzps<zzja, zzbe> zza = zzps.zza(new zzje(), zzja.class, zzbe.class);
    private static final zzbh<zzbe> zzb = zzod.zza("type.googleapis.com/google.crypto.tink.AesSivKey", zzbe.class, zzwx.zzb.SYMMETRIC, zzup.zze());
    private static final zzot<zzjf> zzc = new zzjd();
    private static final zzor<zzjf> zzd = new zzjg();

    static zzja zza(zzjf zzjf, @Nullable Integer num) throws GeneralSecurityException {
        zza(zzjf);
        return zzja.zzc().zza(zzjf).zza(num).zza(zzaal.zza(zzjf.zzb())).zza();
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zziv.zza.ALGORITHM_NOT_FIPS.zza()) {
            zzjs.zza();
            zzpa.zza().zza(zza);
            zzox zza2 = zzox.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("AES256_SIV", zzjq.zza);
            hashMap.put("AES256_SIV_RAW", zzjf.zzc().zza(64).zza(zzjf.zza.zzc).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zzou.zza().zza(zzc, zzjf.class);
            zzop.zza().zza(zzd, zzjf.class);
            zznq.zza().zza(zzb, true);
            return;
        }
        throw new GeneralSecurityException("Registering AES SIV is not supported in FIPS mode");
    }

    /* access modifiers changed from: private */
    public static void zza(zzjf zzjf) throws GeneralSecurityException {
        if (zzjf.zzb() != 64) {
            throw new InvalidAlgorithmParameterException("invalid key size: " + zzjf.zzb() + ". Valid keys must have 64 bytes.");
        }
    }
}
