package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzqi {
    /* access modifiers changed from: private */
    public final Map<zzqj, zznx<?, ?>> zza;
    /* access modifiers changed from: private */
    public final Map<zzqk, zznt<?>> zzb;
    /* access modifiers changed from: private */
    public final Map<zzqj, zzph<?, ?>> zzc;
    /* access modifiers changed from: private */
    public final Map<zzqk, zzpd<?>> zzd;

    public final <SerializationT extends zzqf> zzbi zza(SerializationT serializationt, @Nullable zzch zzch) throws GeneralSecurityException {
        zzqk zzqk = new zzqk(serializationt.getClass(), serializationt.zzc());
        if (this.zzb.containsKey(zzqk)) {
            return this.zzb.get(zzqk).zza(serializationt, zzch);
        }
        throw new GeneralSecurityException("No Key Parser for requested key type " + String.valueOf(zzqk) + " available");
    }

    public final <SerializationT extends zzqf> zzcb zza(SerializationT serializationt) throws GeneralSecurityException {
        zzqk zzqk = new zzqk(serializationt.getClass(), serializationt.zzc());
        if (this.zzd.containsKey(zzqk)) {
            return this.zzd.get(zzqk).zza(serializationt);
        }
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + String.valueOf(zzqk) + " available");
    }

    public final <KeyT extends zzbi, SerializationT extends zzqf> SerializationT zza(KeyT keyt, Class<SerializationT> cls, @Nullable zzch zzch) throws GeneralSecurityException {
        zzqj zzqj = new zzqj(keyt.getClass(), cls);
        if (this.zza.containsKey(zzqj)) {
            return this.zza.get(zzqj).zza(keyt, zzch);
        }
        throw new GeneralSecurityException("No Key serializer for " + String.valueOf(zzqj) + " available");
    }

    public final <ParametersT extends zzcb, SerializationT extends zzqf> SerializationT zza(ParametersT parameterst, Class<SerializationT> cls) throws GeneralSecurityException {
        zzqj zzqj = new zzqj(parameterst.getClass(), cls);
        if (this.zzc.containsKey(zzqj)) {
            return this.zzc.get(zzqj).zza(parameterst);
        }
        throw new GeneralSecurityException("No Key Format serializer for " + String.valueOf(zzqj) + " available");
    }

    private zzqi(zzqh zzqh) {
        this.zza = new HashMap(zzqh.zza);
        this.zzb = new HashMap(zzqh.zzb);
        this.zzc = new HashMap(zzqh.zzc);
        this.zzd = new HashMap(zzqh.zzd);
    }

    public final <SerializationT extends zzqf> boolean zzb(SerializationT serializationt) {
        return this.zzb.containsKey(new zzqk(serializationt.getClass(), serializationt.zzc()));
    }

    public final <SerializationT extends zzqf> boolean zzc(SerializationT serializationt) {
        return this.zzd.containsKey(new zzqk(serializationt.getClass(), serializationt.zzc()));
    }
}
