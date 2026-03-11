package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.zze;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzabk implements zzafv<zzaip> {
    private final /* synthetic */ zzael zza;
    private final /* synthetic */ zzafs zzb;
    private final /* synthetic */ zzaar zzc;

    zzabk(zzaar zzaar, zzael zzael, zzafs zzafs) {
        this.zza = zzael;
        this.zzb = zzafs;
        Objects.requireNonNull(zzaar);
        this.zzc = zzaar;
    }

    public final void zza(String str) {
        this.zzb.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        zzaip zzaip = (zzaip) obj;
        this.zzc.zza(new zzahv(zzaip.zzc(), zzaip.zzb(), Long.valueOf(zzaip.zza()), "Bearer"), (String) null, "password", false, (zze) null, this.zza, this);
    }
}
