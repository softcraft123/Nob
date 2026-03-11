package com.google.android.gms.internal.fido;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzgp implements Comparator {
    zzgp() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzgx zzgx = (zzgx) obj;
        zzgx zzgx2 = (zzgx) obj2;
        zzgo zzgo = new zzgo(zzgx);
        zzgo zzgo2 = new zzgo(zzgx2);
        while (zzgo.hasNext() && zzgo2.hasNext()) {
            int compareTo = Integer.valueOf(zzgo.zza() & 255).compareTo(Integer.valueOf(zzgo2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzgx.zzd()).compareTo(Integer.valueOf(zzgx2.zzd()));
    }
}
