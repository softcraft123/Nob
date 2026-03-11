package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzami  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzami implements zzamf {
    public final int zza(int i, Object obj, Object obj2) {
        zzamg zzamg = (zzamg) obj;
        zzame zzame = (zzame) obj2;
        if (zzamg.isEmpty()) {
            return 0;
        }
        Iterator it = zzamg.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    public final zzamd<?, ?> zza(Object obj) {
        zzame zzame = (zzame) obj;
        throw new NoSuchMethodError();
    }

    public final Object zza(Object obj, Object obj2) {
        zzamg zzamg = (zzamg) obj;
        zzamg zzamg2 = (zzamg) obj2;
        if (!zzamg2.isEmpty()) {
            if (!zzamg.zzd()) {
                zzamg = zzamg.zzb();
            }
            zzamg.zza(zzamg2);
        }
        return zzamg;
    }

    public final Object zzb(Object obj) {
        return zzamg.zza().zzb();
    }

    public final Object zzc(Object obj) {
        ((zzamg) obj).zzc();
        return obj;
    }

    public final Map<?, ?> zzd(Object obj) {
        return (zzamg) obj;
    }

    public final Map<?, ?> zze(Object obj) {
        return (zzamg) obj;
    }

    zzami() {
    }

    public final boolean zzf(Object obj) {
        return !((zzamg) obj).zzd();
    }
}
