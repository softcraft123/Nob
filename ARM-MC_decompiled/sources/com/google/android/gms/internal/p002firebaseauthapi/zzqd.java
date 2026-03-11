package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzqd {
    private static final ThreadLocal<SecureRandom> zza = new zzqg();

    static /* synthetic */ SecureRandom zza() {
        SecureRandom zzb = zzb();
        zzb.nextLong();
        return zzb;
    }

    private static SecureRandom zzb() {
        Provider zza2 = zznh.zza();
        if (zza2 != null) {
            try {
                return SecureRandom.getInstance("SHA1PRNG", zza2);
            } catch (GeneralSecurityException unused) {
            }
        }
        Provider zzb = zznh.zzb();
        if (zzb != null) {
            try {
                return SecureRandom.getInstance("SHA1PRNG", zzb);
            } catch (GeneralSecurityException unused2) {
            }
        }
        return new SecureRandom();
    }

    public static byte[] zza(int i) {
        byte[] bArr = new byte[i];
        zza.get().nextBytes(bArr);
        return bArr;
    }
}
