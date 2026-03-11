package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzadr extends zzaff<AuthResult, zzl> {
    private final String zzv;

    public final String zza() {
        return "signInAnonymously";
    }

    public zzadr(String str) {
        super(2);
        this.zzv = str;
    }

    public final void zzb() {
        zzaf zza = zzacq.zza(this.zzc, this.zzk);
        ((zzl) this.zze).zza(this.zzj, zza);
        zzb(new zzz(zza));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zzd(this.zzv, this.zzb);
    }
}
