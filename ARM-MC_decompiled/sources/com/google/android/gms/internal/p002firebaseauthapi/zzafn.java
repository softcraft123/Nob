package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzafn implements Runnable {
    private final /* synthetic */ zzafm zza;
    private final /* synthetic */ zzafh zzb;

    zzafn(zzafh zzafh, zzafm zzafm) {
        this.zza = zzafm;
        Objects.requireNonNull(zzafh);
        this.zzb = zzafh;
    }

    public final void run() {
        synchronized (this.zzb.zza.zzh) {
            if (!this.zzb.zza.zzh.isEmpty()) {
                this.zza.zza(this.zzb.zza.zzh.get(0), new Object[0]);
            }
        }
    }
}
