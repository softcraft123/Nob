package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzox  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzox {
    private static final zzox zza = new zzox();
    private final Map<String, zzcb> zzb = new HashMap();

    public static zzox zza() {
        return zza;
    }

    zzox() {
    }

    private final synchronized void zza(String str, zzcb zzcb) throws GeneralSecurityException {
        if (!this.zzb.containsKey(str)) {
            this.zzb.put(str, zzcb);
        } else if (!this.zzb.get(str).equals(zzcb)) {
            String valueOf = String.valueOf(this.zzb.get(str));
            throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + valueOf + "), cannot insert " + String.valueOf(zzcb));
        }
    }

    public final synchronized void zza(Map<String, zzcb> map) throws GeneralSecurityException {
        for (Map.Entry next : map.entrySet()) {
            zza((String) next.getKey(), (zzcb) next.getValue());
        }
    }
}
