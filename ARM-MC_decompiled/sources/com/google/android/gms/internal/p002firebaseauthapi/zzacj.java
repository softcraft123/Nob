package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzacj implements zzafv<zzahv> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzael zzb;
    private final /* synthetic */ zzaar zzc;

    zzacj(zzaar zzaar, String str, zzael zzael) {
        this.zza = str;
        this.zzb = zzael;
        Objects.requireNonNull(zzaar);
        this.zzc = zzaar;
    }

    public final void zza(String str) {
        this.zzb.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzahv zzahv = (zzahv) obj;
        zzail zzail = new zzail();
        zzail.zzd(zzahv.zzc()).zzc(this.zza);
        zzaar.zza(this.zzc, this.zzb, zzahv, zzail, (zzafs) this);
    }
}
