package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqf;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public abstract class zznt<SerializationT extends zzqf> {
    private final zzaaj zza;
    private final Class<SerializationT> zzb;

    public static <SerializationT extends zzqf> zznt<SerializationT> zza(zznv<SerializationT> zznv, zzaaj zzaaj, Class<SerializationT> cls) {
        return new zzns(zzaaj, cls, zznv);
    }

    public abstract zzbi zza(SerializationT serializationt, @Nullable zzch zzch) throws GeneralSecurityException;

    public final zzaaj zza() {
        return this.zza;
    }

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zznt(zzaaj zzaaj, Class<SerializationT> cls) {
        this.zza = zzaaj;
        this.zzb = cls;
    }
}
