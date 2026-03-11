package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzabl implements zzafv<zzahv> {
    final /* synthetic */ zzaar zza;
    private final /* synthetic */ zzajb zzb;
    private final /* synthetic */ zzael zzc;

    zzabl(zzaar zzaar, zzajb zzajb, zzael zzael) {
        this.zzb = zzajb;
        this.zzc = zzael;
        Objects.requireNonNull(zzaar);
        this.zza = zzaar;
    }

    public final void zza(String str) {
        this.zzc.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzb.zzb(true);
        this.zzb.zza(((zzahv) obj).zzc());
        this.zza.zza.zza(this.zzb, (zzafv<zzajd>) new zzabo(this, this.zzc, this));
    }
}
