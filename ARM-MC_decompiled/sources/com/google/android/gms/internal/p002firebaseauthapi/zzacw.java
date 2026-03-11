package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.internal.zzar;
import com.google.firebase.auth.internal.zzl;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzacw extends zzaff<SignInMethodQueryResult, zzl> {
    private final String zzv;
    private final String zzw;

    public final String zza() {
        return "fetchSignInMethodsForEmail";
    }

    public zzacw(String str, String str2) {
        super(3);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zzv = str;
        this.zzw = str2;
    }

    public final void zzb() {
        List list;
        if (this.zzl.zza() == null) {
            list = zzah.zzg();
        } else {
            list = (List) Preconditions.checkNotNull(this.zzl.zza());
        }
        zzb(new zzar(list));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzaeo zzaeo) {
        this.zzg = new zzafp(this, taskCompletionSource);
        zzaeo.zze(this.zzv, this.zzw, this.zzb);
    }
}
