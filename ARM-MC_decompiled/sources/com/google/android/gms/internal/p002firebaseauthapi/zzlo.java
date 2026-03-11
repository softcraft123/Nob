package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzlo implements zzlr {
    private final zzjf zza;
    private final int zzb;

    public final int zza() {
        return this.zzb;
    }

    public zzlo(zzjf zzjf) {
        this.zza = zzjf;
        this.zzb = zzjf.zzb();
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        if (bArr2.length >= i) {
            return zzyx.zza(zzja.zzc().zza(this.zza).zza(zzaal.zza(bArr, zzbf.zza())).zza()).zza(Arrays.copyOfRange(bArr2, i, bArr2.length), zzln.zza);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
