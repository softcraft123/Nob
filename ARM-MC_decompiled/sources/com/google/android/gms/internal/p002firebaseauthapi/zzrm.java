package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzrm implements zzpz<zzcc, zzcc> {
    private static final zzrm zza = new zzrm();
    private static final zzps<zzof, zzcc> zzb = zzps.zza(new zzrp(), zzof.class, zzcc.class);

    public final Class<zzcc> zza() {
        return zzcc.class;
    }

    public final Class<zzcc> zzb() {
        return zzcc.class;
    }

    public final /* synthetic */ Object zza(zzob zzob, zzok zzok, zzqc zzqc) throws GeneralSecurityException {
        zzoo zzoo;
        zzoo zzoo2;
        zzaaj zzaaj;
        zzpn zzpn = new zzpn();
        for (int i = 0; i < zzob.zza(); i++) {
            zzoa zza2 = zzob.zza(i);
            if (zza2.zzc().equals(zzbk.zza)) {
                zzcc zzcc = (zzcc) zzqc.zza(zza2);
                zzbi zzb2 = zza2.zzb();
                if (zzb2 instanceof zzrk) {
                    zzaaj = ((zzrk) zzb2).zze();
                } else if (zzb2 instanceof zzof) {
                    zzaaj = ((zzof) zzb2).zzc();
                } else {
                    String name = zzb2.getClass().getName();
                    throw new GeneralSecurityException("Cannot get output prefix for key of class " + name + " with parameters " + String.valueOf(zzb2.zza()));
                }
                zzpn.zza(zzaaj, new zzro(zzcc, zza2.zza()));
            }
        }
        if (!zzok.zza()) {
            zzol zza3 = zzow.zzb().zza();
            zzoo2 = zza3.zza(zzob, zzok, "mac", "compute");
            zzoo = zza3.zza(zzob, zzok, "mac", "verify");
        } else {
            zzoo2 = zzon.zza;
            zzoo = zzon.zza;
        }
        zzoo zzoo3 = zzoo;
        return new zzrr(new zzro((zzcc) zzqc.zza(zzob.zzc()), zzob.zzc().zza()), zzpn.zza(), zzoo2, zzoo3);
    }

    zzrm() {
    }

    static void zzc() throws GeneralSecurityException {
        zzpa.zza().zza(zza);
        zzpa.zza().zza(zzb);
    }
}
