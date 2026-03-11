package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzge;
import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzga  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzga {
    private static final zzps<zzgb, zzba> zza = zzps.zza(new zzgd(), zzgb.class, zzba.class);
    private static final zzbh<zzba> zzb = zzod.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", zzba.class, zzwx.zzb.SYMMETRIC, zzyo.zze());
    private static final zzot<zzge> zzc = new zzgc();
    private static final zzor<zzge> zzd = new zzgf();

    public static /* synthetic */ zzba zza(zzgb zzgb) {
        if (zzik.zza()) {
            return zzik.zza(zzgb);
        }
        return zzaak.zza(zzgb);
    }

    static zzgb zza(zzge zzge, @Nullable Integer num) throws GeneralSecurityException {
        return zzgb.zza(zzge.zzb(), zzaal.zza(32), num);
    }

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zziv.zza.ALGORITHM_NOT_FIPS.zza()) {
            zzij.zza();
            zzpa.zza().zza(zza);
            zzox zza2 = zzox.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("XCHACHA20_POLY1305", zzge.zza(zzge.zza.zza));
            hashMap.put("XCHACHA20_POLY1305_RAW", zzge.zza(zzge.zza.zzc));
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zzop.zza().zza(zzd, zzge.class);
            zzou.zza().zza(zzc, zzge.class);
            zznq.zza().zza(zzb, true);
            return;
        }
        throw new GeneralSecurityException("Registering XChaCha20Poly1305 is not supported in FIPS mode");
    }
}
