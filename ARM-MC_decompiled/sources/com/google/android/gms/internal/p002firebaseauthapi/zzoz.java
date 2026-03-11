package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzoz {
    private static final zzoz zza = ((zzoz) zzql.zza(new zzpc()));
    private final AtomicReference<zzqi> zzb = new AtomicReference<>(new zzqh().zza());

    public final <SerializationT extends zzqf> zzbi zza(SerializationT serializationt, @Nullable zzch zzch) throws GeneralSecurityException {
        return this.zzb.get().zza(serializationt, zzch);
    }

    public final <SerializationT extends zzqf> zzcb zza(SerializationT serializationt) throws GeneralSecurityException {
        return this.zzb.get().zza(serializationt);
    }

    public static zzoz zza() {
        return zza;
    }

    public final <KeyT extends zzbi, SerializationT extends zzqf> SerializationT zza(KeyT keyt, Class<SerializationT> cls, @Nullable zzch zzch) throws GeneralSecurityException {
        return this.zzb.get().zza(keyt, cls, zzch);
    }

    public final <ParametersT extends zzcb, SerializationT extends zzqf> SerializationT zza(ParametersT parameterst, Class<SerializationT> cls) throws GeneralSecurityException {
        return this.zzb.get().zza(parameterst, cls);
    }

    public final synchronized <SerializationT extends zzqf> void zza(zznt<SerializationT> zznt) throws GeneralSecurityException {
        this.zzb.set(new zzqh(this.zzb.get()).zza(zznt).zza());
    }

    public final synchronized <KeyT extends zzbi, SerializationT extends zzqf> void zza(zznx<KeyT, SerializationT> zznx) throws GeneralSecurityException {
        this.zzb.set(new zzqh(this.zzb.get()).zza(zznx).zza());
    }

    public final synchronized <SerializationT extends zzqf> void zza(zzpd<SerializationT> zzpd) throws GeneralSecurityException {
        this.zzb.set(new zzqh(this.zzb.get()).zza(zzpd).zza());
    }

    public final synchronized <ParametersT extends zzcb, SerializationT extends zzqf> void zza(zzph<ParametersT, SerializationT> zzph) throws GeneralSecurityException {
        this.zzb.set(new zzqh(this.zzb.get()).zza(zzph).zza());
    }

    public final <SerializationT extends zzqf> boolean zzb(SerializationT serializationt) {
        return this.zzb.get().zzb(serializationt);
    }

    public final <SerializationT extends zzqf> boolean zzc(SerializationT serializationt) {
        return this.zzb.get().zzc(serializationt);
    }
}
