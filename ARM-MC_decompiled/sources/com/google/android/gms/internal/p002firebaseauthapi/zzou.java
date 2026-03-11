package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzou  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzou {
    private static final zzou zza = new zzou();
    private final Map<Class<? extends zzcb>, zzot<? extends zzcb>> zzb = new HashMap();

    public static zzou zza() {
        return zza;
    }

    public final synchronized <ParametersT extends zzcb> void zza(zzot<ParametersT> zzot, Class<ParametersT> cls) throws GeneralSecurityException {
        zzot zzot2 = this.zzb.get(cls);
        if (zzot2 != null) {
            if (!zzot2.equals(zzot)) {
                throw new GeneralSecurityException("Different key creator for parameters class already inserted");
            }
        }
        this.zzb.put(cls, zzot);
    }
}
