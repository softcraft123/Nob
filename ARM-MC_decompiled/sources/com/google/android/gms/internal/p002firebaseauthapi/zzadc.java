package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzadc extends zzaff<AuthResult, zzl> {
    private final EmailAuthCredential zzv;
    private final String zzw;

    public final String zza() {
        return "linkEmailAuthCredential";
    }

    public zzadc(EmailAuthCredential emailAuthCredential, String str) {
        super(2);
        this.zzv = (EmailAuthCredential) Preconditions.checkNotNull(emailAuthCredential, "credential cannot be null");
        Preconditions.checkNotEmpty(emailAuthCredential.zzc(), "email cannot be null");
        Preconditions.checkNotEmpty(emailAuthCredential.zzd(), "password cannot be null");
        this.zzw = str;
    }

    public final void zzb() {
        zzaf zza = zzacq.zza(this.zzc, this.zzk);
        ((zzl) this.zze).zza(this.zzj, zza);
        zzb(new zzz(zza));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zza(this.zzv.zzc(), Preconditions.checkNotEmpty(this.zzv.zzd()), this.zzd.zze(), this.zzd.getTenantId(), this.zzw, this.zzb);
    }
}
