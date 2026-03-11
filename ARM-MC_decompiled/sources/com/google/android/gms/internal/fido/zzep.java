package com.google.android.gms.internal.fido;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzep extends zzev {
    private static final zzep zza = new zzep(zzev.zze());
    private final AtomicReference zzb;

    zzep(zzev zzev) {
        this.zzb = new AtomicReference(zzev);
    }

    public static final zzep zzb() {
        return zza;
    }

    public final zzdr zza() {
        return ((zzev) this.zzb.get()).zza();
    }

    public final zzfi zzc() {
        return ((zzev) this.zzb.get()).zzc();
    }

    public final boolean zzd(String str, Level level, boolean z) {
        ((zzev) this.zzb.get()).zzd(str, level, z);
        return false;
    }
}
