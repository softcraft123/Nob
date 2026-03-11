package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzjn implements zzbe {
    private final zzpl<zzjo> zza;
    private final zzoo zzb;

    public zzjn(zzjo zzjo, zzpl<zzjo> zzpl, zzoo zzoo, zzoo zzoo2) {
        this.zza = zzpl;
        this.zzb = zzoo2;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        for (zzjo next : this.zza.zza(bArr)) {
            try {
                byte[] zza2 = next.zza.zza(bArr, bArr2);
                this.zzb.zza(next.zzb, (long) bArr.length);
                return zza2;
            } catch (GeneralSecurityException unused) {
            }
        }
        this.zzb.zza();
        throw new GeneralSecurityException("decryption failed");
    }
}
