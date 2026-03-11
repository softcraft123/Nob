package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzsr extends zzss {
    private final int zza;

    public final boolean zza() {
        return false;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzsr.class, Integer.valueOf(this.zza)});
    }

    public static zzsr zza(int i) throws GeneralSecurityException {
        if (i == 16 || i == 32) {
            return new zzsr(i);
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit are supported", new Object[]{Integer.valueOf(i << 3)}));
    }

    public final String toString() {
        return "AesCmac PRF Parameters (" + this.zza + "-byte key)";
    }

    private zzsr(int i) {
        this.zza = i;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof zzsr) && ((zzsr) obj).zza == this.zza) {
            return true;
        }
        return false;
    }
}
