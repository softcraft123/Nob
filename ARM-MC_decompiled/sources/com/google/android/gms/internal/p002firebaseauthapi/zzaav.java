package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzao;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaav  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzaav implements zzafv<zzahv> {
    private final /* synthetic */ EmailAuthCredential zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzael zzc;
    private final /* synthetic */ zzaar zzd;

    zzaav(zzaar zzaar, EmailAuthCredential emailAuthCredential, String str, zzael zzael) {
        this.zza = emailAuthCredential;
        this.zzb = str;
        this.zzc = zzael;
        Objects.requireNonNull(zzaar);
        this.zzd = zzaar;
    }

    public final void zza(String str) {
        this.zzc.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzd.zza(new zzagx(this.zza, ((zzahv) obj).zzc(), this.zzb), this.zzc);
    }
}
