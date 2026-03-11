package com.google.android.recaptcha.internal;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzbk {
    public static final /* synthetic */ int zza = 0;
    private static final ConcurrentHashMap zzb = new ConcurrentHashMap();

    public static final void zza(int i, long j) {
        ConcurrentHashMap concurrentHashMap = zzb;
        Integer valueOf = Integer.valueOf(i);
        Object obj = concurrentHashMap.get(valueOf);
        if (obj == null) {
            obj = new zzbj();
        }
        zzbj zzbj = (zzbj) obj;
        zzbj.zzg(zzbj.zzb() + 1);
        zzbj.zzf(zzbj.zzd() + j);
        zzbj.zze(Math.max(j, zzbj.zzc()));
        concurrentHashMap.put(valueOf, zzbj);
    }
}
