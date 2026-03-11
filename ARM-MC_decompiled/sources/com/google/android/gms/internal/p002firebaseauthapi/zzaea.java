package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzam;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaea  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzaea extends zzaff<zzair, Void> {
    private final zzaiu zzv;

    public final String zza() {
        return "startMfaEnrollment";
    }

    public zzaea(zzam zzam, String str) {
        super(12);
        Preconditions.checkNotNull(zzam);
        this.zzv = zzaiu.zza(Preconditions.checkNotEmpty(zzam.zzb()), str);
    }

    public final void zzb() {
        zzb(this.zzt);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zza(this.zzv, (zzaem) this.zzb);
    }
}
