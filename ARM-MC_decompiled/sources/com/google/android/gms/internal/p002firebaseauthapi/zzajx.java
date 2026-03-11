package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzajx implements Comparator<zzajv> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzajv zzajv = (zzajv) obj;
        zzajv zzajv2 = (zzajv) obj2;
        zzakb zzakb = (zzakb) zzajv.iterator();
        zzakb zzakb2 = (zzakb) zzajv2.iterator();
        while (zzakb.hasNext() && zzakb2.hasNext()) {
            int compare = Integer.compare(zzajv.zza(zzakb.zza()), zzajv.zza(zzakb2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzajv.zzb(), zzajv2.zzb());
    }

    zzajx() {
    }
}
