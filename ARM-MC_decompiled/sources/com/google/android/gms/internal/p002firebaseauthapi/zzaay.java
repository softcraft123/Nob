package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zze;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaay  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzaay implements zzafv<zzagw> {
    private final /* synthetic */ zzael zza;
    private final /* synthetic */ zzaar zzb;

    zzaay(zzaar zzaar, zzael zzael) {
        this.zza = zzael;
        Objects.requireNonNull(zzaar);
        this.zzb = zzaar;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzagw zzagw = (zzagw) obj;
        if (zzagw.zzf()) {
            this.zza.zza(new zzaas(zzagw.zzc(), zzagw.zze(), (zze) null));
            return;
        }
        this.zzb.zza(new zzahv(zzagw.zzd(), zzagw.zzb(), Long.valueOf(zzagw.zza()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzagw.zzg()), (zze) null, this.zza, this);
    }
}
