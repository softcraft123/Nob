package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzada  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzada extends zzaff<zzahr, Void> {
    private final zzaho zzv = zzaho.zzb();

    public final String zza() {
        return "getRecaptchaParam";
    }

    public zzada() {
        super(11);
    }

    public final void zzb() {
        zzb(this.zzs);
    }

    public final void zza(TaskCompletionSource<zzahr> taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zza(this.zzv, (zzaem) this.zzb);
    }
}
