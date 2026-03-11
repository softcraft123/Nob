package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.internal.zzl;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzadp extends zzaff<Void, zzl> {
    private final zzahm zzv;
    private final String zzw;

    public final String zza() {
        return this.zzw;
    }

    public zzadp(String str, ActionCodeSettings actionCodeSettings, String str2, String str3, String str4) {
        super(4);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        zzahm zzahm = new zzahm(actionCodeSettings.zza());
        this.zzv = zzahm;
        zzahm.zzb(str);
        zzahm.zza(actionCodeSettings);
        zzahm.zzc(str2);
        zzahm.zza(str3);
        this.zzw = str4;
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zzb(this.zzv, (zzaem) this.zzb);
    }
}
