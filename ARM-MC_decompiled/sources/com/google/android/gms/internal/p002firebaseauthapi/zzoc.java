package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzoc<P> extends zzod<P> implements zzcd<P> {
    public final zzwx zzc(zzajv zzajv) throws GeneralSecurityException {
        zzbi zza = zzoz.zza().zza(zzqb.zza(this.zza, zzajv, this.zzb, zzxz.RAW, (Integer) null), zzbf.zza());
        if (zza instanceof zzce) {
            zzqb zzqb = (zzqb) zzoz.zza().zza(((zzce) zza).zzc(), zzqb.class, zzbf.zza());
            return (zzwx) ((zzalf) zzwx.zza().zza(zzqb.zzf()).zza(zzqb.zzd()).zza(zzqb.zza()).zze());
        }
        throw new GeneralSecurityException("Key not private key");
    }

    protected zzoc(String str, Class<P> cls, zzamv<? extends zzamm> zzamv) {
        super(str, cls, zzwx.zzb.ASYMMETRIC_PRIVATE, zzamv);
    }
}
