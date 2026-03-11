package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzbi;
import com.google.android.gms.internal.p002firebaseauthapi.zzqf;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public abstract class zznx<KeyT extends zzbi, SerializationT extends zzqf> {
    private final Class<KeyT> zza;
    private final Class<SerializationT> zzb;

    public static <KeyT extends zzbi, SerializationT extends zzqf> zznx<KeyT, SerializationT> zza(zznz<KeyT, SerializationT> zznz, Class<KeyT> cls, Class<SerializationT> cls2) {
        return new zznw(cls, cls2, zznz);
    }

    public abstract SerializationT zza(KeyT keyt, @Nullable zzch zzch) throws GeneralSecurityException;

    public final Class<KeyT> zza() {
        return this.zza;
    }

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zznx(Class<KeyT> cls, Class<SerializationT> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }
}
