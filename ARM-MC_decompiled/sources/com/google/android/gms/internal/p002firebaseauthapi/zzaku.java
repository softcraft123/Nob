package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaku  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzaku {
    static final zzaku zza = new zzaku(true);
    private static volatile boolean zzb = false;
    private final Map<zzakt, zzalf.zzf<?, ?>> zzc;

    public static zzaku zza() {
        return zza;
    }

    public final <ContainingType extends zzamm> zzalf.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzc.get(new zzakt(containingtype, i));
    }

    zzaku() {
        this.zzc = new HashMap();
    }

    private zzaku(boolean z) {
        this.zzc = Collections.emptyMap();
    }
}
