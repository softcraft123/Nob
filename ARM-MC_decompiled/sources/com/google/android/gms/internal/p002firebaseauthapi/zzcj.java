package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzcj {
    public static zzcb zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzxb zza = zzxb.zza(bArr, zzaku.zza());
            zzoz zza2 = zzoz.zza();
            zzqe zza3 = zzqe.zza(zza);
            if (!zza2.zzc(zza3)) {
                return new zzoi(zza3);
            }
            return zza2.zza(zza3);
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }

    public static byte[] zza(zzcb zzcb) throws GeneralSecurityException {
        if (zzcb instanceof zzoi) {
            return ((zzoi) zzcb).zzb().zza().zzk();
        }
        return ((zzqe) zzoz.zza().zza(zzcb, zzqe.class)).zza().zzk();
    }
}
