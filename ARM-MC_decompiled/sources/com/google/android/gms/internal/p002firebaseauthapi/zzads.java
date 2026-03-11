package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzl;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzads  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzads extends zzaff<Void, zzl> {
    private final zzain zzv;

    public final String zza() {
        return "setFirebaseUIVersion";
    }

    public zzads(String str) {
        super(9);
        this.zzv = new zzain(str);
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zza(this.zzv, (zzaem) this.zzb);
    }
}
