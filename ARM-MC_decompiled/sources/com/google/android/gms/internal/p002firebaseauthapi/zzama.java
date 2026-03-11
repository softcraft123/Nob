package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzama  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzama implements zzane {
    private static final zzamj zza = new zzalz();
    private final zzamj zzb;

    public final <T> zzanb<T> zza(Class<T> cls) {
        zzand.zza((Class<?>) cls);
        zzamk zza2 = this.zzb.zza(cls);
        if (zza2.zzc()) {
            return zzams.zza(zzand.zza(), zzaky.zza(), zza2.zza());
        }
        return zzamq.zza(cls, zza2, zzamw.zza(), zzaly.zza(), zzand.zza(), zzamc.zza[zza2.zzb().ordinal()] != 1 ? zzaky.zza() : null, zzamh.zza());
    }

    public zzama() {
        this(new zzamb(zzalg.zza(), zza));
    }

    private zzama(zzamj zzamj) {
        this.zzb = (zzamj) zzalh.zza(zzamj, "messageInfoFactory");
    }
}
