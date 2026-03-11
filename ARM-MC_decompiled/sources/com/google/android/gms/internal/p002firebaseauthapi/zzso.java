package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzso  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzso extends zzst {
    private final zzsr zza;
    private final zzaal zzb;

    public final /* synthetic */ zzcb zza() {
        return (zzsr) zza();
    }

    @Nullable
    public final Integer zzb() {
        return null;
    }

    public static zzso zza(zzsr zzsr, zzaal zzaal) throws GeneralSecurityException {
        if (zzsr.zzb() == zzaal.zza()) {
            return new zzso(zzsr, zzaal);
        }
        throw new GeneralSecurityException("Key size mismatch");
    }

    public final /* synthetic */ zzss zzc() {
        return this.zza;
    }

    public final zzaal zzd() {
        return this.zzb;
    }

    private zzso(zzsr zzsr, zzaal zzaal) {
        this.zza = zzsr;
        this.zzb = zzaal;
    }
}
