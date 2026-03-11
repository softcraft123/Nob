package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzadt extends zzaff<AuthResult, zzl> {
    private final zzajc zzv;

    public final String zza() {
        return "signInWithCustomToken";
    }

    public zzadt(String str, String str2) {
        super(2);
        Preconditions.checkNotEmpty(str, "token cannot be null or empty");
        this.zzv = new zzajc(str, str2);
    }

    public final void zzb() {
        zzaf zza = zzacq.zza(this.zzc, this.zzk);
        ((zzl) this.zze).zza(this.zzj, zza);
        zzb(new zzz(zza));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zza(this.zzv, (zzaem) this.zzb);
    }
}
