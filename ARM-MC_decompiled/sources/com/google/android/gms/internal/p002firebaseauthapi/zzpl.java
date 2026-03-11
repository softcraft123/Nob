package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzpl<P> {
    private static final zzaaj zza = zzaaj.zza(new byte[0]);
    private final Map<zzaaj, List<P>> zzb;

    public final Iterable<P> zza(byte[] bArr) {
        List list = this.zzb.get(zza);
        List list2 = bArr.length >= 5 ? this.zzb.get(zzaaj.zza(bArr, 0, 5)) : null;
        if (list == null && list2 == null) {
            return new ArrayList();
        }
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        return new zzpo(this, list2, list);
    }

    private zzpl(Map<zzaaj, List<P>> map) {
        this.zzb = map;
    }
}
