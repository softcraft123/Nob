package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzbj {
    @Nullable
    private final zzcb zza;

    public static zzbj zza(zzcb zzcb) throws GeneralSecurityException {
        return new zzbj(zzcb);
    }

    public final zzcb zza() throws GeneralSecurityException {
        zzcb zzcb = this.zza;
        if (zzcb != null) {
            return zzcb;
        }
        return zzcj.zza(zzb().zzk());
    }

    private final zzxb zzb() {
        try {
            zzcb zzcb = this.zza;
            if (zzcb instanceof zzoi) {
                return ((zzoi) zzcb).zzb().zza();
            }
            return ((zzqe) zzoz.zza().zza(this.zza, zzqe.class)).zza();
        } catch (GeneralSecurityException e) {
            throw new zzql("Parsing parameters failed in getProto(). You probably want to call some Tink register function for " + String.valueOf(this.zza), e);
        }
    }

    private zzbj(zzcb zzcb) {
        this.zza = zzcb;
    }
}
