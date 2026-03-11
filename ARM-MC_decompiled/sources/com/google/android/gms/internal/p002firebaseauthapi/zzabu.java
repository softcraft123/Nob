package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzabu implements zzafv<zzajd> {
    private final /* synthetic */ zzael zza;
    private final /* synthetic */ zzaar zzb;

    zzabu(zzaar zzaar, zzael zzael) {
        this.zza = zzael;
        Objects.requireNonNull(zzaar);
        this.zzb = zzaar;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzajd zzajd = (zzajd) obj;
        if (!zzajd.zzl()) {
            zzaar.zza(this.zzb, zzajd, this.zza, (zzafs) this);
        } else {
            this.zza.zza(new zzaas(zzajd.zzf(), zzajd.zzk(), zzajd.zzb()));
        }
    }
}
