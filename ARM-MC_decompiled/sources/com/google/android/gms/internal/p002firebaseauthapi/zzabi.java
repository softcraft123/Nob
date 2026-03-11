package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zze;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzabi implements zzafv<zzajj> {
    private final /* synthetic */ zzael zza;
    private final /* synthetic */ zzaar zzb;

    zzabi(zzaar zzaar, zzael zzael) {
        this.zza = zzael;
        Objects.requireNonNull(zzaar);
        this.zzb = zzaar;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzajj zzajj = (zzajj) obj;
        this.zzb.zza(new zzahv(zzajj.zzd(), zzajj.zzb(), Long.valueOf(zzajj.zza()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzajj.zzf()), (zze) null, this.zza, this);
    }
}
