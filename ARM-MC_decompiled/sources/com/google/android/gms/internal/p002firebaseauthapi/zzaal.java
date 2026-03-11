package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaal  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzaal {
    private final zzaaj zza;

    public final int zza() {
        return this.zza.zza();
    }

    public static zzaal zza(byte[] bArr, zzch zzch) {
        if (zzch != null) {
            return new zzaal(zzaaj.zza(bArr));
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public static zzaal zza(int i) {
        return new zzaal(zzaaj.zza(zzqd.zza(i)));
    }

    private zzaal(zzaaj zzaaj) {
        this.zza = zzaaj;
    }

    public final byte[] zza(zzch zzch) {
        if (zzch != null) {
            return this.zza.zzb();
        }
        throw new NullPointerException("SecretKeyAccess required");
    }
}
