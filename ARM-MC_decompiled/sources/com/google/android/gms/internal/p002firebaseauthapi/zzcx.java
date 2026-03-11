package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzcx implements zzpz<zzba, zzba> {
    private static final zzcx zza = new zzcx();
    private static final zzps<zzof, zzba> zzb = zzps.zza(new zzda(), zzof.class, zzba.class);

    public final Class<zzba> zza() {
        return zzba.class;
    }

    public final Class<zzba> zzb() {
        return zzba.class;
    }

    public final /* synthetic */ Object zza(zzob zzob, zzok zzok, zzqc zzqc) throws GeneralSecurityException {
        zzoo zzoo;
        zzoo zzoo2;
        zzaaj zzaaj;
        zzpn zzpn = new zzpn();
        for (int i = 0; i < zzob.zza(); i++) {
            zzoa zza2 = zzob.zza(i);
            if (zza2.zzc().equals(zzbk.zza)) {
                zzbi zzb2 = zza2.zzb();
                if (zzb2 instanceof zzcw) {
                    zzaaj = ((zzcw) zzb2).zzd();
                } else if (zzb2 instanceof zzof) {
                    zzaaj = ((zzof) zzb2).zzc();
                } else {
                    String name = zzb2.getClass().getName();
                    throw new GeneralSecurityException("Cannot get output prefix for key of class " + name + " with parameters " + String.valueOf(zzb2.zza()));
                }
                zzpn.zza(zzaaj, new zzcz((zzba) zzqc.zza(zza2), zza2.zza()));
            }
        }
        if (!zzok.zza()) {
            zzol zza3 = zzow.zzb().zza();
            zzoo2 = zza3.zza(zzob, zzok, "aead", "encrypt");
            zzoo = zza3.zza(zzob, zzok, "aead", "decrypt");
        } else {
            zzoo2 = zzon.zza;
            zzoo = zzon.zza;
        }
        zzoo zzoo3 = zzoo;
        return new zzdc(new zzcz((zzba) zzqc.zza(zzob.zzc()), zzob.zzc().zza()), zzpn.zza(), zzoo2, zzoo3);
    }

    zzcx() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzpa.zza().zza(zza);
        zzpa.zza().zza(zzb);
    }

    public static void zza(zzpy zzpy) throws GeneralSecurityException {
        zzpy.zza(zza);
    }
}
