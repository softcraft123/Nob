package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzkg;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzmh {
    public static zzly zza(zzkg.zzb zzb) throws GeneralSecurityException {
        if (zzb == zzkg.zzb.zza) {
            return new zzll(16);
        }
        if (zzb == zzkg.zzb.zzb) {
            return new zzll(32);
        }
        if (zzb == zzkg.zzb.zzc) {
            return new zzlk();
        }
        throw new IllegalArgumentException("Unrecognized HPKE AEAD identifier");
    }

    public static zzmc zza(zzkg.zzc zzc) {
        if (zzc == zzkg.zzc.zza) {
            return new zzlz("HmacSha256");
        }
        if (zzc == zzkg.zzc.zzb) {
            return new zzlz("HmacSha384");
        }
        if (zzc == zzkg.zzc.zzc) {
            return new zzlz("HmacSha512");
        }
        throw new IllegalArgumentException("Unrecognized HPKE KDF identifier");
    }

    public static zzmf zza(zzkg.zzf zzf) throws GeneralSecurityException {
        if (zzf == zzkg.zzf.zzd) {
            return new zzmu(new zzlz("HmacSha256"));
        }
        if (zzf == zzkg.zzf.zza) {
            return zzmr.zza(zzzi.NIST_P256);
        }
        if (zzf == zzkg.zzf.zzb) {
            return zzmr.zza(zzzi.NIST_P384);
        }
        if (zzf == zzkg.zzf.zzc) {
            return zzmr.zza(zzzi.NIST_P521);
        }
        throw new IllegalArgumentException("Unrecognized HPKE KEM identifier");
    }
}
