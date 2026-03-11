package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzes  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzes {
    private static final zzbh<zzba> zza = zzod.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", zzba.class, zzwx.zzb.SYMMETRIC, zzxt.zze());
    private static final zzor<zzfc> zzb = new zzer();
    private static final zzps<zzfd, zzba> zzc = zzps.zza(new zzeu(), zzfd.class, zzba.class);

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zziv.zza.ALGORITHM_NOT_FIPS.zza()) {
            zzfg.zza();
            zzop.zza().zza(zzb, zzfc.class);
            zzpa.zza().zza(zzc);
            zznq.zza().zza(zza, true);
            return;
        }
        throw new GeneralSecurityException("Registering KMS Envelope AEAD is not supported in FIPS mode");
    }
}
