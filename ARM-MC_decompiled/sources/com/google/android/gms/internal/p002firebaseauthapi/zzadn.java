package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzadn extends zzaff<Void, Void> {
    private final zzaie zzv;

    public final String zza() {
        return "revokeAccessToken";
    }

    public zzadn(String str, String str2, String str3, String str4) {
        super(15);
        this.zzv = zzaie.zzg().zzd(str).zza(str2).zzc(str4).zzb(str3).zza(zzahg.ACCESS_TOKEN).zza();
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource<Void> taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zza(this.zzv, (zzaem) this.zzb);
    }
}
