package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.List;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzabp implements zzafv<zzahl> {
    private final /* synthetic */ zzafv zza;
    private final /* synthetic */ zzahv zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzael zzd;
    private final /* synthetic */ zzabq zze;

    zzabp(zzabq zzabq, zzafv zzafv, zzahv zzahv, String str, zzael zzael) {
        this.zza = zzafv;
        this.zzb = zzahv;
        this.zzc = str;
        this.zzd = zzael;
        Objects.requireNonNull(zzabq);
        this.zze = zzabq;
    }

    public final void zza(String str) {
        this.zzd.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzahk> zza2 = ((zzahl) obj).zza();
        if (zza2 == null || zza2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzail zzail = new zzail();
        zzail.zzd(this.zzb.zzc()).zza(this.zzc);
        zzaar.zza(this.zze.zza, this.zzd, this.zzb, zza2.get(0), zzail, (zzafs) this.zza);
    }
}
