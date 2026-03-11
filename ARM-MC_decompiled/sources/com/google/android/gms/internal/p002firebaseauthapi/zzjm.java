package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzjm implements zzpz<zzbe, zzbe> {
    private static final zzjm zza = new zzjm();
    private static final zzps<zzof, zzbe> zzb = zzps.zza(new zzjl(), zzof.class, zzbe.class);

    public final Class<zzbe> zza() {
        return zzbe.class;
    }

    public final Class<zzbe> zzb() {
        return zzbe.class;
    }

    public final /* synthetic */ Object zza(zzob zzob, zzok zzok, zzqc zzqc) throws GeneralSecurityException {
        zzoo zzoo;
        zzoo zzoo2;
        zzaaj zzaaj;
        zzpn zzpn = new zzpn();
        for (int i = 0; i < zzob.zza(); i++) {
            zzoa zza2 = zzob.zza(i);
            if (zza2.zzc().equals(zzbk.zza)) {
                zzbe zzbe = (zzbe) zzqc.zza(zza2);
                zzbi zzb2 = zza2.zzb();
                if (zzb2 instanceof zzjk) {
                    zzaaj = ((zzjk) zzb2).zze();
                } else if (zzb2 instanceof zzof) {
                    zzaaj = ((zzof) zzb2).zzc();
                } else {
                    String name = zzb2.getClass().getName();
                    throw new GeneralSecurityException("Cannot get output prefix for key of class " + name + " with parameters " + String.valueOf(zzb2.zza()));
                }
                zzpn.zza(zzaaj, new zzjo(zzbe, zza2.zza()));
            }
        }
        if (!zzok.zza()) {
            zzol zza3 = zzow.zzb().zza();
            zzoo2 = zza3.zza(zzob, zzok, "daead", "encrypt");
            zzoo = zza3.zza(zzob, zzok, "daead", "decrypt");
        } else {
            zzoo2 = zzon.zza;
            zzoo = zzon.zza;
        }
        return new zzjn(new zzjo((zzbe) zzqc.zza(zzob.zzc()), zzob.zzc().zza()), zzpn.zza(), zzoo2, zzoo);
    }

    zzjm() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzpa.zza().zza(zza);
        zzpa.zza().zza(zzb);
    }
}
