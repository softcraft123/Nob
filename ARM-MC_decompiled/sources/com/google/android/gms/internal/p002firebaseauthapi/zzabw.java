package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzabw implements zzafv<zzahv> {
    final /* synthetic */ zzaar zza;
    private final /* synthetic */ zzagz zzb;
    private final /* synthetic */ zzael zzc;

    zzabw(zzaar zzaar, zzagz zzagz, zzael zzael) {
        this.zzb = zzagz;
        this.zzc = zzael;
        Objects.requireNonNull(zzaar);
        this.zza = zzaar;
    }

    public final void zza(String str) {
        this.zzc.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzb.zza(((zzahv) obj).zzc());
        this.zza.zza.zza(this.zzb, (zzafv<zzagy>) new zzabv(this, this.zzc));
    }
}
