package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzld  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzld implements zzpz<zzbg, zzbg> {
    private static final zzld zza = new zzld();
    private static final zzps<zzof, zzbg> zzb = zzps.zza(new zzlc(), zzof.class, zzbg.class);

    public final Class<zzbg> zza() {
        return zzbg.class;
    }

    public final Class<zzbg> zzb() {
        return zzbg.class;
    }

    public final /* synthetic */ Object zza(zzob zzob, zzok zzok, zzqc zzqc) throws GeneralSecurityException {
        zzoo zzoo;
        if (!zzok.zza()) {
            zzoo = zzow.zzb().zza().zza(zzob, zzok, "hybrid_encrypt", "encrypt");
        } else {
            zzoo = zzon.zza;
        }
        zzoa zzc = zzob.zzc();
        return new zzle(new zzlf((zzbg) zzqc.zza(zzc), zzc.zza()), zzoo);
    }

    zzld() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzpa.zza().zza(zza);
        zzpa.zza().zza(zzb);
    }

    public static void zza(zzpy zzpy) throws GeneralSecurityException {
        zzpy.zza(zza);
    }
}
