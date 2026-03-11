package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzod  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public class zzod<P> implements zzbh<P> {
    final String zza;
    final zzwx.zzb zzb;
    private final Class<P> zzc;

    public static <P> zzbh<P> zza(String str, Class<P> cls, zzwx.zzb zzb2, zzamv<? extends zzamm> zzamv) {
        return new zzod(str, cls, zzb2, zzamv);
    }

    public static <P> zzcd<P> zza(String str, Class<P> cls, zzamv<? extends zzamm> zzamv) {
        return new zzoc(str, cls, zzamv);
    }

    public final zzwx zza(zzajv zzajv) throws GeneralSecurityException {
        zzqb zzqb = (zzqb) zzoz.zza().zza(zzop.zza().zza(zzoz.zza().zza(zzqe.zza((zzxb) ((zzalf) zzxb.zza().zza(this.zza).zza(zzajv).zza(zzxz.RAW).zze()))), (Integer) null), zzqb.class, zzbf.zza());
        return (zzwx) ((zzalf) zzwx.zza().zza(zzqb.zzf()).zza(zzqb.zzd()).zza(zzqb.zza()).zze());
    }

    public final Class<P> zza() {
        return this.zzc;
    }

    public final P zzb(zzajv zzajv) throws GeneralSecurityException {
        return zzpa.zza().zza(zzoz.zza().zza(zzqb.zza(this.zza, zzajv, this.zzb, zzxz.RAW, (Integer) null), zzbf.zza()), this.zzc);
    }

    public final String zzb() {
        return this.zza;
    }

    zzod(String str, Class<P> cls, zzwx.zzb zzb2, zzamv<? extends zzamm> zzamv) {
        this.zza = str;
        this.zzc = cls;
        this.zzb = zzb2;
    }
}
