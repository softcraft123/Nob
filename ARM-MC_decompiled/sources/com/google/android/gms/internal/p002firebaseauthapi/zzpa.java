package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpa  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzpa {
    private static zzpa zza = new zzpa();
    private final AtomicReference<zzpw> zzb = new AtomicReference<>(zzpw.zza().zza());

    public static zzpa zza() {
        return zza;
    }

    public final <KeyT extends zzbi, PrimitiveT> PrimitiveT zza(KeyT keyt, Class<PrimitiveT> cls) throws GeneralSecurityException {
        return this.zzb.get().zza(keyt, cls);
    }

    zzpa() {
    }

    public final synchronized <KeyT extends zzbi, PrimitiveT> void zza(zzps<KeyT, PrimitiveT> zzps) throws GeneralSecurityException {
        this.zzb.set(zzpw.zza(this.zzb.get()).zza(zzps).zza());
    }

    public final synchronized <InputPrimitiveT, WrapperPrimitiveT> void zza(zzpz<InputPrimitiveT, WrapperPrimitiveT> zzpz) throws GeneralSecurityException {
        this.zzb.set(zzpw.zza(this.zzb.get()).zza(zzpz).zza());
    }
}
