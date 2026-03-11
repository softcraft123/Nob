package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzacz extends zzaff<zzahs, Void> {
    private final zzaht zzv;

    public final String zza() {
        return "getRecaptchaConfig";
    }

    public zzacz(String str, String str2) {
        super(10);
        Preconditions.checkNotEmpty(str2);
        this.zzv = zzaht.zza(str, str2);
    }

    public final void zzb() {
        zzb(this.zzr);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zza(this.zzv, (zzaem) this.zzb);
    }
}
