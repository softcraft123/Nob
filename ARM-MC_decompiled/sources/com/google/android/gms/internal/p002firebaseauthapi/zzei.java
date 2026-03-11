package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzem;
import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzei  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzei {
    private static final zzps<zzej, zzba> zza = zzps.zza(new zzel(), zzej.class, zzba.class);
    private static final zzor<zzem> zzb = new zzek();
    private static final zzbh<zzba> zzc = zzod.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", zzba.class, zzwx.zzb.SYMMETRIC, zzuv.zze());

    public static /* synthetic */ zzba zza(zzej zzej) {
        if (zzhh.zzb()) {
            return zzhh.zza(zzej);
        }
        return zzzc.zza(zzej);
    }

    static zzej zza(zzem zzem, @Nullable Integer num) throws GeneralSecurityException {
        return zzej.zza(zzem.zzb(), zzaal.zza(32), num);
    }

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zziv.zza.ALGORITHM_NOT_FIPS.zza()) {
            zzhj.zza();
            zzpa.zza().zza(zza);
            zzop.zza().zza(zzb, zzem.class);
            zzox zza2 = zzox.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("CHACHA20_POLY1305", zzem.zza(zzem.zza.zza));
            hashMap.put("CHACHA20_POLY1305_RAW", zzem.zza(zzem.zza.zzc));
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zznq.zza().zza(zzc, true);
            return;
        }
        throw new GeneralSecurityException("Registering ChaCha20Poly1305 is not supported in FIPS mode");
    }
}
