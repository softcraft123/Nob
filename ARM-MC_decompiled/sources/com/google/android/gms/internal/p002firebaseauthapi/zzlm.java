package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzlm implements zzlr {
    private final zzdi zza;
    private final int zzb;

    public final int zza() {
        return this.zzb;
    }

    public zzlm(zzdi zzdi) {
        this.zza = zzdi;
        this.zzb = zzdi.zzb() + zzdi.zzc();
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        if (bArr2.length >= i) {
            return zzzk.zza(zzdd.zze().zza(this.zza).zza(zzaal.zza(Arrays.copyOf(bArr, this.zza.zzb()), zzbf.zza())).zzb(zzaal.zza(Arrays.copyOfRange(bArr, this.zza.zzb(), this.zza.zzb() + this.zza.zzc()), zzbf.zza())).zza()).zza(Arrays.copyOfRange(bArr2, i, bArr2.length), zzln.zza);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
