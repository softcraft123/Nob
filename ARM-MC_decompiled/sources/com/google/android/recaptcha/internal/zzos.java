package com.google.android.recaptcha.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzos {
    public static final /* synthetic */ int zza = 0;
    private static final zzos zzb = new zzos();
    private final zzox zzc = new zzoa();
    private final ConcurrentMap zzd = new ConcurrentHashMap();

    private zzos() {
    }

    public static zzos zza() {
        return zzb;
    }

    public final zzow zzb(Class cls) {
        zznl.zzc(cls, "messageType");
        zzow zzow = (zzow) this.zzd.get(cls);
        if (zzow != null) {
            return zzow;
        }
        zzow zza2 = this.zzc.zza(cls);
        zznl.zzc(cls, "messageType");
        zzow zzow2 = (zzow) this.zzd.putIfAbsent(cls, zza2);
        return zzow2 == null ? zza2 : zzow2;
    }
}
