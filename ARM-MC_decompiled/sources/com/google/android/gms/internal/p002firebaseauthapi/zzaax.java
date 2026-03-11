package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaax  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzaax implements zzafv<zzahl> {
    private final /* synthetic */ zzafs zza;
    private final /* synthetic */ zzael zzb;
    private final /* synthetic */ zzahv zzc;
    private final /* synthetic */ zzail zzd;
    private final /* synthetic */ zzaar zze;

    zzaax(zzaar zzaar, zzafs zzafs, zzael zzael, zzahv zzahv, zzail zzail) {
        this.zza = zzafs;
        this.zzb = zzael;
        this.zzc = zzahv;
        this.zzd = zzail;
        Objects.requireNonNull(zzaar);
        this.zze = zzaar;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzahk> zza2 = ((zzahl) obj).zza();
        if (zza2 == null || zza2.isEmpty()) {
            this.zza.zza("No users");
        } else {
            zzaar.zza(this.zze, this.zzb, this.zzc, zza2.get(0), this.zzd, this.zza);
        }
    }
}
