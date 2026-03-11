package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzbi;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzps  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public abstract class zzps<KeyT extends zzbi, PrimitiveT> {
    private final Class<KeyT> zza;
    private final Class<PrimitiveT> zzb;

    public static <KeyT extends zzbi, PrimitiveT> zzps<KeyT, PrimitiveT> zza(zzpu<KeyT, PrimitiveT> zzpu, Class<KeyT> cls, Class<PrimitiveT> cls2) {
        return new zzpr(cls, cls2, zzpu);
    }

    public abstract PrimitiveT zza(KeyT keyt) throws GeneralSecurityException;

    public final Class<KeyT> zza() {
        return this.zza;
    }

    public final Class<PrimitiveT> zzb() {
        return this.zzb;
    }

    private zzps(Class<KeyT> cls, Class<PrimitiveT> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }
}
