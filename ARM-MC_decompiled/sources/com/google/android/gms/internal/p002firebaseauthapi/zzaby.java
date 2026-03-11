package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zze;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaby  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzaby implements zzafv<zzaha> {
    private final /* synthetic */ zzael zza;
    private final /* synthetic */ zzaar zzb;

    zzaby(zzaar zzaar, zzael zzael) {
        this.zza = zzael;
        Objects.requireNonNull(zzaar);
        this.zzb = zzaar;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzaha zzaha = (zzaha) obj;
        this.zzb.zza(new zzahv(zzaha.zzb(), zzaha.zza(), Long.valueOf(zzahx.zza(zzaha.zza())), "Bearer"), (String) null, (String) null, false, (zze) null, this.zza, this);
    }
}
