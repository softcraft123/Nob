package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzow  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzow {
    private static final zzow zza = new zzow();
    private static final zzov zzb = new zzov();
    private final AtomicReference<zzol> zzc = new AtomicReference<>();

    public final zzol zza() {
        zzol zzol = this.zzc.get();
        return zzol == null ? zzb : zzol;
    }

    public static zzow zzb() {
        return zza;
    }
}
