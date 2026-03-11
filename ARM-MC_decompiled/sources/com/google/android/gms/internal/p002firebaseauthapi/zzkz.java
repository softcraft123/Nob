package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzkz implements zzpz<zzbd, zzbd> {
    private static final zzkz zza = new zzkz();
    private static final zzps<zzof, zzbd> zzb = zzps.zza(new zzky(), zzof.class, zzbd.class);

    public final Class<zzbd> zza() {
        return zzbd.class;
    }

    public final Class<zzbd> zzb() {
        return zzbd.class;
    }

    public final /* synthetic */ Object zza(zzob zzob, zzok zzok, zzqc zzqc) throws GeneralSecurityException {
        zzoo zzoo;
        zzaaj zzaaj;
        zzpn zzpn = new zzpn();
        for (int i = 0; i < zzob.zza(); i++) {
            zzoa zza2 = zzob.zza(i);
            if (zza2.zzc().equals(zzbk.zza)) {
                zzbd zzbd = (zzbd) zzqc.zza(zza2);
                zzbi zzb2 = zza2.zzb();
                if (zzb2 instanceof zzlj) {
                    zzaaj = ((zzlj) zzb2).zzh();
                } else if (zzb2 instanceof zzof) {
                    zzaaj = ((zzof) zzb2).zzc();
                } else {
                    String name = zzb2.getClass().getName();
                    throw new GeneralSecurityException("Cannot get output prefix for key of class " + name + " with parameters " + String.valueOf(zzb2.zza()));
                }
                zzpn.zza(zzaaj, new zzlb(zzbd, zza2.zza()));
            }
        }
        if (!zzok.zza()) {
            zzoo = zzow.zzb().zza().zza(zzob, zzok, "hybrid_decrypt", "decrypt");
        } else {
            zzoo = zzon.zza;
        }
        return new zzla(zzpn.zza(), zzoo);
    }

    zzkz() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzpa.zza().zza(zza);
        zzpa.zza().zza(zzb);
    }

    public static void zza(zzpy zzpy) throws GeneralSecurityException {
        zzpy.zza(zza);
    }
}
