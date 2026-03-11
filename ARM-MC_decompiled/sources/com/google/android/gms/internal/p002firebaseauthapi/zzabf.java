package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzabf implements zzafv<zzaii> {
    private final /* synthetic */ zzael zza;

    zzabf(zzaar zzaar, zzael zzael) {
        this.zza = zzael;
        Objects.requireNonNull(zzaar);
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zza.zzb(((zzaii) obj).zza());
    }
}
