package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqe  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzqe implements zzqf {
    private final zzaaj zza;
    private final zzxb zzb;

    public static zzqe zza(zzxb zzxb) throws GeneralSecurityException {
        return new zzqe(zzxb, zzqn.zza(zzxb.zzf()));
    }

    public static zzqe zzb(zzxb zzxb) {
        return new zzqe(zzxb, zzqn.zzb(zzxb.zzf()));
    }

    public final zzxb zza() {
        return this.zzb;
    }

    public final zzaaj zzc() {
        return this.zza;
    }

    private zzqe(zzxb zzxb, zzaaj zzaaj) {
        this.zzb = zzxb;
        this.zza = zzaaj;
    }
}
