package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzl;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaec  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzaec extends zzaff<Void, zzl> {
    private final String zzv;
    private final String zzw;
    private final String zzx;

    public final String zza() {
        return "unenrollMfa";
    }

    public zzaec(String str, String str2, String str3) {
        super(2);
        this.zzv = Preconditions.checkNotEmpty(str);
        this.zzw = Preconditions.checkNotEmpty(str2);
        this.zzx = str3;
    }

    public final void zzb() {
        ((zzl) this.zze).zza(this.zzj, zzacq.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zza(this.zzv, this.zzw, this.zzx, (zzaem) this.zzb);
    }
}
