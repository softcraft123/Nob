package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqf;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public abstract class zzpd<SerializationT extends zzqf> {
    private final zzaaj zza;
    private final Class<SerializationT> zzb;

    public static <SerializationT extends zzqf> zzpd<SerializationT> zza(zzpf<SerializationT> zzpf, zzaaj zzaaj, Class<SerializationT> cls) {
        return new zzpg(zzaaj, cls, zzpf);
    }

    public abstract zzcb zza(SerializationT serializationt) throws GeneralSecurityException;

    public final zzaaj zza() {
        return this.zza;
    }

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zzpd(zzaaj zzaaj, Class<SerializationT> cls) {
        this.zza = zzaaj;
        this.zzb = cls;
    }
}
