package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzfv {
    private static final zzor<zzfz> zza = new zzfy();
    private static final zzps<zzfw, zzba> zzb = zzps.zza(new zzfx(), zzfw.class, zzba.class);

    public static void zza(boolean z) throws GeneralSecurityException {
        zzie.zza();
        zzox zza2 = zzox.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("XAES_256_GCM_192_BIT_NONCE", zzfm.zzg);
        hashMap.put("XAES_256_GCM_192_BIT_NONCE_NO_PREFIX", zzfm.zzh);
        hashMap.put("XAES_256_GCM_160_BIT_NONCE_NO_PREFIX", zzfm.zzi);
        hashMap.put("X_AES_GCM_8_BYTE_SALT_NO_PREFIX", zzfm.zzj);
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zzpa.zza().zza(zzb);
        zzop.zza().zza(zza, zzfz.class);
    }
}
