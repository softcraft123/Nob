package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zze;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzabv implements zzafv<zzagy> {
    private final /* synthetic */ zzael zza;
    private final /* synthetic */ zzabw zzb;

    zzabv(zzabw zzabw, zzael zzael) {
        this.zza = zzael;
        Objects.requireNonNull(zzabw);
        this.zzb = zzabw;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzagy zzagy = (zzagy) obj;
        this.zzb.zza.zza(new zzahv(zzagy.zzb(), zzagy.zza(), Long.valueOf(zzahx.zza(zzagy.zza())), "Bearer"), (String) null, (String) null, false, (zze) null, this.zza, this);
    }
}
