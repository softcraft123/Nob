package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzu;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaek  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzaek extends zzaff<String, zzl> {
    private final String zzv;
    private final String zzw;

    public final String zza() {
        return "verifyPasswordResetCode";
    }

    public zzaek(String str, String str2) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zzv = str;
        this.zzw = str2;
    }

    public final void zzb() {
        if (new zzu(this.zzm).getOperation() != 0) {
            zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR));
        } else {
            zzb(this.zzm.zzb());
        }
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zzd(this.zzv, this.zzw, this.zzb);
    }
}
