package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzrr implements zzcc {
    private final zzro zza;
    private final zzpl<zzro> zzb;
    private final zzoo zzc;
    private final zzoo zzd;

    private zzrr(zzro zzro, zzpl<zzro> zzpl, zzoo zzoo, zzoo zzoo2) {
        this.zza = zzro;
        this.zzb = zzpl;
        this.zzc = zzoo;
        this.zzd = zzoo2;
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        for (zzro next : this.zzb.zza(bArr)) {
            try {
                next.zza.zza(bArr, bArr2);
                this.zzd.zza(next.zzb, (long) bArr2.length);
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        this.zzd.zza();
        throw new GeneralSecurityException("invalid MAC");
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        try {
            byte[] zza2 = this.zza.zza.zza(bArr);
            this.zzc.zza(this.zza.zzb, (long) bArr.length);
            return zza2;
        } catch (GeneralSecurityException e) {
            this.zzc.zza();
            throw e;
        }
    }
}
