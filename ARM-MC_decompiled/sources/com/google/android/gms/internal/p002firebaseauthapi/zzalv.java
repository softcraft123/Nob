package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzalv implements zzalw {
    private static <E> zzalm<E> zzc(Object obj, long j) {
        return (zzalm) zzanz.zze(obj, j);
    }

    public final <L> List<L> zza(Object obj, long j) {
        zzalm zzc = zzc(obj, j);
        if (zzc.zzc()) {
            return zzc;
        }
        int size = zzc.size();
        zzalm zza = zzc.zza(size == 0 ? 10 : size << 1);
        zzanz.zza(obj, j, (Object) zza);
        return zza;
    }

    zzalv() {
    }

    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    public final <E> void zza(Object obj, Object obj2, long j) {
        zzalm zzc = zzc(obj, j);
        zzalm zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzc()) {
                zzc = zzc.zza(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzanz.zza(obj, j, (Object) zzc2);
    }
}
