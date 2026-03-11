package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzack  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzack implements zzafv<zzahv> {
    private final /* synthetic */ UserProfileChangeRequest zza;
    private final /* synthetic */ zzael zzb;
    private final /* synthetic */ zzaar zzc;

    zzack(zzaar zzaar, UserProfileChangeRequest userProfileChangeRequest, zzael zzael) {
        this.zza = userProfileChangeRequest;
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
        zzail.zzd(zzahv.zzc());
        if (this.zza.zzb() || this.zza.getDisplayName() != null) {
            zzail.zzb(this.zza.getDisplayName());
        }
        if (this.zza.zzc() || this.zza.getPhotoUri() != null) {
            zzail.zzg(this.zza.zza());
        }
        zzaar.zza(this.zzc, this.zzb, zzahv, zzail, (zzafs) this);
    }
}
