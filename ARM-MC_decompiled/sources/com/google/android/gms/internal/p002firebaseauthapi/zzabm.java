package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.zze;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzabm implements zzafv<zzajj> {
    private final /* synthetic */ zzael zza;
    private final /* synthetic */ zzafv zzb;
    private final /* synthetic */ zzabj zzc;

    zzabm(zzabj zzabj, zzael zzael, zzafv zzafv) {
        this.zza = zzael;
        this.zzb = zzafv;
        Objects.requireNonNull(zzabj);
        this.zzc = zzabj;
    }

    public final void zza(String str) {
        this.zzb.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        zzajj zzajj = (zzajj) obj;
        if (!TextUtils.isEmpty(zzajj.zze())) {
            this.zza.zza(new Status(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE), PhoneAuthCredential.zzb(zzajj.zzc(), zzajj.zze()));
            return;
        }
        this.zzc.zza.zza(new zzahv(zzajj.zzd(), zzajj.zzb(), Long.valueOf(zzajj.zza()), "Bearer"), (String) null, "phone", Boolean.valueOf(zzajj.zzf()), (zze) null, this.zza, this.zzb);
    }
}
