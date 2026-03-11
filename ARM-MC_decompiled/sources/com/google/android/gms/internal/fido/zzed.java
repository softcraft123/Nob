package com.google.android.gms.internal.fido;

import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzed {
    private static final zzdz zza = new zzeb();
    private static final zzdy zzb = new zzec();

    public static zzdv zza(Set set) {
        zzdv zzdv = new zzdv(zza, (zzdu) null);
        zzdv.zza(zzb);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzdv.zzg((zzdk) it.next());
        }
        return zzdv;
    }
}
