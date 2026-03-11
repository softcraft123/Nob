package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzacb implements zzafv<zzahl> {
    private final /* synthetic */ zzafv zza;
    private final /* synthetic */ zzael zzb;
    private final /* synthetic */ zzahv zzc;

    zzacb(zzacc zzacc, zzafv zzafv, zzael zzael, zzahv zzahv) {
        this.zza = zzafv;
        this.zzb = zzael;
        this.zzc = zzahv;
        Objects.requireNonNull(zzacc);
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzahk> zza2 = ((zzahl) obj).zza();
        if (zza2 == null || zza2.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zzb.zza(this.zzc, zza2.get(0));
        }
    }
}
