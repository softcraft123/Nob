package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzav;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzact  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzact extends zzaff<Void, zzav> {
    public final String zza() {
        return "delete";
    }

    public zzact() {
        super(5);
    }

    public final void zzb() {
        ((zzav) this.zze).zza();
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zza(this.zzd.zze(), (zzaem) this.zzb);
    }
}
