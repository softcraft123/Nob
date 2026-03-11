package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzoj {
    private HashMap<String, String> zza = new HashMap<>();

    public final zzok zza() {
        if (this.zza != null) {
            zzok zzok = new zzok(Collections.unmodifiableMap(this.zza));
            this.zza = null;
            return zzok;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
