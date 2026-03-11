package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzacy extends zzaff<AuthResult, zzl> {
    private final MultiFactorAssertion zzv;
    private final String zzw;
    private final String zzx;

    public final String zza() {
        return "finalizeMfaSignIn";
    }

    public zzacy(MultiFactorAssertion multiFactorAssertion, String str, String str2) {
        super(2);
        this.zzv = (MultiFactorAssertion) Preconditions.checkNotNull(multiFactorAssertion);
        this.zzw = Preconditions.checkNotEmpty(str);
        this.zzx = str2;
    }

    public final void zzb() {
        zzaf zza = zzacq.zza(this.zzc, this.zzk);
        if (this.zzd == null || this.zzd.getUid().equalsIgnoreCase(zza.getUid())) {
            ((zzl) this.zze).zza(this.zzj, zza);
            zzb(new zzz(zza));
            return;
        }
        zza(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zza(this.zzw, this.zzv, this.zzx, (zzaem) this.zzb);
    }
}
