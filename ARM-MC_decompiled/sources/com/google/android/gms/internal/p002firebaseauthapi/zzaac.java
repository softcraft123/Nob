package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaac  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzaac implements zzsq {
    private final zzsq zza;
    private final zzsq zzb;

    private zzaac(zzsq zzsq, zzsq zzsq2) {
        this.zza = zzsq;
        this.zzb = zzsq2;
    }

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        if (bArr.length <= 64) {
            return this.zza.zza(bArr, i);
        }
        return this.zzb.zza(bArr, i);
    }
}
