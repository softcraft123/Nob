package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zze;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzaaw implements zzafv<zzajh> {
    private final /* synthetic */ zzael zza;
    private final /* synthetic */ zzaar zzb;

    zzaaw(zzaar zzaar, zzael zzael) {
        this.zza = zzael;
        Objects.requireNonNull(zzaar);
        this.zzb = zzaar;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzajh zzajh = (zzajh) obj;
        if (zzajh.zzf()) {
            this.zza.zza(new zzaas(zzajh.zzc(), zzajh.zze(), (zze) null));
            return;
        }
        this.zzb.zza(new zzahv(zzajh.zzd(), zzajh.zzb(), Long.valueOf(zzajh.zza()), "Bearer"), (String) null, (String) null, false, (zze) null, this.zza, this);
    }
}
