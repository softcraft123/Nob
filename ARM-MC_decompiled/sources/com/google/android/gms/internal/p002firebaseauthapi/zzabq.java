package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzabq implements zzafv<zzahv> {
    final /* synthetic */ zzaar zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzael zzc;

    zzabq(zzaar zzaar, String str, zzael zzael) {
        this.zzb = str;
        this.zzc = zzael;
        Objects.requireNonNull(zzaar);
        this.zza = zzaar;
    }

    public final void zza(String str) {
        this.zzc.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzahv zzahv = (zzahv) obj;
        this.zza.zza.zza(new zzahi(zzahv.zzc()), (zzafv<zzahl>) new zzabp(this, this, zzahv, this.zzb, this.zzc));
    }
}
