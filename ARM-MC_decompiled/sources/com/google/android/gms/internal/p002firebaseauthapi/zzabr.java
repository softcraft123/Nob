package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zze;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzabr implements zzafv<zzajl> {
    private final /* synthetic */ zzael zza;
    private final /* synthetic */ zzabs zzb;

    zzabr(zzabs zzabs, zzael zzael) {
        this.zza = zzael;
        Objects.requireNonNull(zzabs);
        this.zzb = zzabs;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzajl zzajl = (zzajl) obj;
        if (TextUtils.isEmpty(zzajl.zza()) || TextUtils.isEmpty(zzajl.zzb())) {
            this.zza.zza(zzao.zza("INTERNAL_SUCCESS_SIGN_OUT"));
            return;
        }
        this.zzb.zza.zza(new zzahv(zzajl.zzb(), zzajl.zza(), Long.valueOf(zzahx.zza(zzajl.zza())), "Bearer"), (String) null, (String) null, false, (zze) null, this.zza, this);
    }
}
