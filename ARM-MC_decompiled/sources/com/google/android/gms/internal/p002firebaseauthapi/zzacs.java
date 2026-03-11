package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzu;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzacs extends zzaff<ActionCodeResult, zzl> {
    private final String zzv;
    private final String zzw;

    public final String zza() {
        return "checkActionCode";
    }

    public zzacs(String str, String str2) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zzv = str;
        this.zzw = str2;
    }

    public final void zzb() {
        zzb(new zzu(this.zzm));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zzd(this.zzv, this.zzw, this.zzb);
    }
}
