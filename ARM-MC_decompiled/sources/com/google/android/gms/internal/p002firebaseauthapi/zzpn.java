package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzpn<P> {
    private final Map<zzaaj, List<P>> zza = new HashMap();

    public final zzpn<P> zza(zzaaj zzaaj, P p) throws GeneralSecurityException {
        List list;
        if (zzaaj.zza() == 0 || zzaaj.zza() == 5) {
            if (this.zza.containsKey(zzaaj)) {
                list = this.zza.get(zzaaj);
            } else {
                ArrayList arrayList = new ArrayList();
                this.zza.put(zzaaj, arrayList);
                list = arrayList;
            }
            list.add(p);
            return this;
        }
        throw new GeneralSecurityException("PrefixMap only supports 0 and 5 byte prefixes");
    }

    public final zzpl<P> zza() {
        return new zzpl<>(this.zza);
    }
}
