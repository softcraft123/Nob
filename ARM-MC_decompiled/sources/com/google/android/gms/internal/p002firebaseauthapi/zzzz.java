package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzzz implements zzsq {
    public static zzsq zza(zzso zzso) throws GeneralSecurityException {
        zzsq zza = zzsv.zza(zzso);
        try {
            return new zzaac(zza, zzsx.zza(zzso));
        } catch (GeneralSecurityException unused) {
            return zza;
        }
    }

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        throw new NoSuchMethodError();
    }
}
