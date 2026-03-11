package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzabs implements zzafv<zzahv> {
    final /* synthetic */ zzaar zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzael zzd;

    zzabs(zzaar zzaar, String str, String str2, zzael zzael) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzael;
        Objects.requireNonNull(zzaar);
        this.zza = zzaar;
    }

    public final void zza(String str) {
        this.zzd.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zza.zza.zza(new zzaji(((zzahv) obj).zzc(), this.zzb, this.zzc), (zzafv<zzajl>) new zzabr(this, this.zzd));
    }
}
