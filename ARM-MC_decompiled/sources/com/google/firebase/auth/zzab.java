package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzbo;
import com.google.firebase.auth.internal.zzcf;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzab extends zzbo<Void> {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ FirebaseUser zzb;
    private final /* synthetic */ EmailAuthCredential zzc;
    private final /* synthetic */ FirebaseAuth zzd;

    /* JADX WARNING: type inference failed for: r7v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zzb] */
    /* JADX WARNING: type inference failed for: r6v2, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.FirebaseAuth$zzb] */
    public final Task<Void> zza(String str) {
        if (this.zza) {
            if (TextUtils.isEmpty(str)) {
                Log.i("FirebaseAuth", " Email link reauth with empty reCAPTCHA token");
            } else {
                Log.i("FirebaseAuth", "Got reCAPTCHA token for reauth with email link");
            }
            return this.zzd.zzd.zza(this.zzd.zzf, this.zzb, this.zzc, str, (zzcf) new FirebaseAuth.zzb(this.zzd));
        }
        String str2 = str;
        String zzc2 = this.zzc.zzc();
        String zzd2 = this.zzc.zzd();
        if (TextUtils.isEmpty(str2)) {
            Log.i("FirebaseAuth", "Reauthenticating " + zzc2 + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for reauth with " + zzc2);
        }
        return this.zzd.zzd.zza(this.zzd.zzf, this.zzb, zzc2, Preconditions.checkNotEmpty(zzd2), this.zzb.getTenantId(), str2, new FirebaseAuth.zzb(this.zzd));
    }

    zzab(FirebaseAuth firebaseAuth, boolean z, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential) {
        this.zza = z;
        this.zzb = firebaseUser;
        this.zzc = emailAuthCredential;
        Objects.requireNonNull(firebaseAuth);
        this.zzd = firebaseAuth;
    }
}
