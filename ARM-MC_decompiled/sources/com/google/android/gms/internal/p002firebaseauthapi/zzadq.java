package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.internal.zzl;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzadq extends zzaff<Void, zzl> {
    private final zzahm zzv;

    public final String zza() {
        return "sendEmailVerification";
    }

    public zzadq(String str, ActionCodeSettings actionCodeSettings) {
        super(6);
        Preconditions.checkNotEmpty(str, "token cannot be null or empty");
        zzahm zzahm = new zzahm(4);
        this.zzv = zzahm;
        zzahm.zzd(str);
        if (actionCodeSettings != null) {
            zzahm.zza(actionCodeSettings);
        }
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zza(this.zzv, (zzaem) this.zzb);
    }
}
