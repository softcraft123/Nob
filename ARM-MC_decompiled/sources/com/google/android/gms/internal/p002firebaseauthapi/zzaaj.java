package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzaaj {
    private final byte[] zza;

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final int zza() {
        return this.zza.length;
    }

    public static zzaaj zza(byte[] bArr) {
        if (bArr != null) {
            return zza(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public static zzaaj zza(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i2 > bArr.length) {
                i2 = bArr.length;
            }
            return new zzaaj(bArr, 0, i2);
        }
        throw new NullPointerException("data must be non-null");
    }

    public final String toString() {
        return "Bytes(" + zzzx.zza(this.zza) + ")";
    }

    private zzaaj(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.zza = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaaj)) {
            return false;
        }
        return Arrays.equals(((zzaaj) obj).zza, this.zza);
    }

    public final byte[] zzb() {
        byte[] bArr = this.zza;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
