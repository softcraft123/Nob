package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzmr implements zzmf {
    private final zzzi zza;
    private final zzlz zzb;

    static zzmr zza(zzzi zzzi) throws GeneralSecurityException {
        int i = zzmq.zza[zzzi.ordinal()];
        if (i == 1) {
            return new zzmr(new zzlz("HmacSha256"), zzzi.NIST_P256);
        }
        if (i == 2) {
            return new zzmr(new zzlz("HmacSha384"), zzzi.NIST_P384);
        }
        if (i == 3) {
            return new zzmr(new zzlz("HmacSha512"), zzzi.NIST_P521);
        }
        throw new GeneralSecurityException("invalid curve type: " + String.valueOf(zzzi));
    }

    private zzmr(zzlz zzlz, zzzi zzzi) {
        this.zzb = zzlz;
        this.zza = zzzi;
    }

    public final byte[] zza(byte[] bArr, zzme zzme) throws GeneralSecurityException {
        ECPrivateKey zza2 = zzzf.zza(this.zza, zzme.zza().zzb());
        zzzi zzzi = this.zza;
        byte[] zza3 = zzzf.zza(zza2, zzzf.zza(zzzf.zza(zzzi), zzzh.UNCOMPRESSED, bArr));
        byte[] zza4 = zzyz.zza(bArr, zzme.zzb().zzb());
        byte[] zza5 = zzmk.zza(zza());
        zzlz zzlz = this.zzb;
        return zzlz.zza((byte[]) null, zza3, "eae_prk", zza4, "shared_secret", zza5, zzlz.zza());
    }

    public final byte[] zza() throws GeneralSecurityException {
        int i = zzmq.zza[this.zza.ordinal()];
        if (i == 1) {
            return zzmk.zzc;
        }
        if (i == 2) {
            return zzmk.zzd;
        }
        if (i == 3) {
            return zzmk.zze;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
