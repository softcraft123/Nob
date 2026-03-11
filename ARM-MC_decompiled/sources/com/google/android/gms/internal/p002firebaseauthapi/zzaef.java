package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzl;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaef  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzaef extends zzaff<Void, zzl> {
    private final PhoneAuthCredential zzv;

    public final String zza() {
        return "updatePhoneNumber";
    }

    public zzaef(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        this.zzv = (PhoneAuthCredential) Preconditions.checkNotNull(phoneAuthCredential);
    }

    public final void zzb() {
        ((zzl) this.zze).zza(this.zzj, zzacq.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zza(new zzahz(this.zzd.zze(), zzafw.zza(this.zzv)), (zzaem) this.zzb);
    }
}
