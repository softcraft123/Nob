package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzaeh extends zzaff<Void, Void> {
    private final zzahm zzv;

    public final String zza() {
        return "verifyBeforeUpdateEmail";
    }

    public zzaeh(String str, String str2, ActionCodeSettings actionCodeSettings) {
        super(6);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(actionCodeSettings);
        this.zzv = zzahm.zza(actionCodeSettings, str, str2);
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zzc(this.zzv, (zzaem) this.zzb);
    }
}
