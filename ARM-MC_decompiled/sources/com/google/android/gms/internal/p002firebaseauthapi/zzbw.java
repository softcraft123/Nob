package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;
import com.google.android.gms.internal.p002firebaseauthapi.zzxh;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzbw {
    private final zzxh.zza zza;

    public final synchronized zzbm zza() throws GeneralSecurityException {
        return zzbm.zza((zzxh) ((zzalf) this.zza.zze()));
    }

    public static zzbw zza(zzbm zzbm) {
        zzalf.zzb zzn = zzbm.zzd().zzn();
        zzalf.zzb zzb = zzn;
        return new zzbw((zzxh.zza) zzn);
    }

    private zzbw(zzxh.zza zza2) {
        this.zza = zza2;
    }
}
