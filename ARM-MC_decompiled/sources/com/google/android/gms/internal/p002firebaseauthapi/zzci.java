package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzci  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzci {
    @Deprecated
    static zzwx zza(String str, zzajv zzajv) throws GeneralSecurityException {
        zzbh<?> zza = zznq.zza().zza(str);
        if (zza instanceof zzcd) {
            return ((zzcd) zza).zzc(zzajv);
        }
        throw new GeneralSecurityException("manager for key type " + str + " is not a PrivateKeyManager");
    }

    static {
        Logger.getLogger(zzci.class.getName());
        new ConcurrentHashMap();
        HashSet hashSet = new HashSet();
        hashSet.add(zzba.class);
        hashSet.add(zzbe.class);
        hashSet.add(zzck.class);
        hashSet.add(zzbg.class);
        hashSet.add(zzbd.class);
        hashSet.add(zzcc.class);
        hashSet.add(zzsq.class);
        hashSet.add(zzcg.class);
        hashSet.add(zzcf.class);
        Collections.unmodifiableSet(hashSet);
    }

    private zzci() {
    }
}
