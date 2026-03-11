package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzpw {
    /* access modifiers changed from: private */
    public final Map<zzpx, zzps<?, ?>> zza;
    /* access modifiers changed from: private */
    public final Map<Class<?>, zzpz<?, ?>> zzb;

    public static zzpy zza() {
        return new zzpy();
    }

    public static zzpy zza(zzpw zzpw) {
        return new zzpy(zzpw);
    }

    public final <KeyT extends zzbi, PrimitiveT> PrimitiveT zza(KeyT keyt, Class<PrimitiveT> cls) throws GeneralSecurityException {
        zzpx zzpx = new zzpx(keyt.getClass(), cls);
        if (this.zza.containsKey(zzpx)) {
            return this.zza.get(zzpx).zza(keyt);
        }
        throw new GeneralSecurityException("No PrimitiveConstructor for " + String.valueOf(zzpx) + " available, see https://developers.google.com/tink/faq/registration_errors");
    }

    public final <WrappedPrimitiveT> WrappedPrimitiveT zza(zzob zzob, zzok zzok, Class<WrappedPrimitiveT> cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            zzpz zzpz = this.zzb.get(cls);
            return zzpz.zza(zzob, zzok, new zzpv(this, zzpz));
        }
        throw new GeneralSecurityException("No wrapper found for " + String.valueOf(cls));
    }

    private zzpw(zzpy zzpy) {
        this.zza = new HashMap(zzpy.zza);
        this.zzb = new HashMap(zzpy.zzb);
    }
}
