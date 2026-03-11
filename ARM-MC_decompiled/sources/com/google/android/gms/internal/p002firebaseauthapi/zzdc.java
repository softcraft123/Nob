package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzdc implements zzba {
    private final zzcz zza;
    private final zzpl<zzcz> zzb;
    private final zzoo zzc;
    private final zzoo zzd;

    private zzdc(zzcz zzcz, zzpl<zzcz> zzpl, zzoo zzoo, zzoo zzoo2) {
        this.zza = zzcz;
        this.zzb = zzpl;
        this.zzc = zzoo;
        this.zzd = zzoo2;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        for (zzcz next : this.zzb.zza(bArr)) {
            try {
                byte[] zza2 = next.zza.zza(bArr, bArr2);
                this.zzd.zza(next.zzb, (long) bArr.length);
                return zza2;
            } catch (GeneralSecurityException unused) {
            }
        }
        this.zzd.zza();
        throw new GeneralSecurityException("decryption failed");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            byte[] zzb2 = this.zza.zza.zzb(bArr, bArr2);
            this.zzc.zza(this.zza.zzb, (long) bArr.length);
            return zzb2;
        } catch (GeneralSecurityException e) {
            this.zzc.zza();
            throw e;
        }
    }
}
