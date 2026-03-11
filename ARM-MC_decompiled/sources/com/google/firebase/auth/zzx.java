package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import com.google.firebase.auth.internal.zzau;
import com.google.firebase.auth.internal.zzl;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzx implements zzau, zzl {
    private final /* synthetic */ FirebaseAuth zza;

    zzx(FirebaseAuth firebaseAuth) {
        Objects.requireNonNull(firebaseAuth);
        this.zza = firebaseAuth;
    }

    public final void zza(zzahv zzahv, FirebaseUser firebaseUser) {
        this.zza.zza(firebaseUser, zzahv, true, true);
    }

    public final void zza(Status status) {
        int statusCode = status.getStatusCode();
        if (statusCode == 17011 || statusCode == 17021 || statusCode == 17005) {
            this.zza.signOut();
        }
    }
}
