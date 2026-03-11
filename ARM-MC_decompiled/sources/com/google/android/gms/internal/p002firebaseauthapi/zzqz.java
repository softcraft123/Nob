package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzqz implements zzpz<zzqw, zzqw> {
    private static final zzqz zza = new zzqz();

    public final Class<zzqw> zza() {
        return zzqw.class;
    }

    public final Class<zzqw> zzb() {
        return zzqw.class;
    }

    public final /* synthetic */ Object zza(zzob zzob, zzok zzok, zzqc zzqc) throws GeneralSecurityException {
        zzaaj zzaaj;
        zzoa zzc = zzob.zzc();
        if (zzc != null) {
            zzpn zzpn = new zzpn();
            for (int i = 0; i < zzob.zza(); i++) {
                zzoa zza2 = zzob.zza(i);
                if (zza2.zzc().equals(zzbk.zza)) {
                    zzqw zzqw = (zzqw) zzqc.zza(zza2);
                    zzbi zzb = zza2.zzb();
                    if (zzb instanceof zzrk) {
                        zzaaj = ((zzrk) zzb).zze();
                    } else if (zzb instanceof zzof) {
                        zzaaj = ((zzof) zzb).zzc();
                    } else {
                        String name = zzb.getClass().getName();
                        throw new GeneralSecurityException("Cannot get output prefix for key of class " + name + " with parameters " + String.valueOf(zzb.zza()));
                    }
                    zzpn.zza(zzaaj, zzqw);
                }
            }
            return new zzqy(zzpn.zza(), (zzqw) zzqc.zza(zzc));
        }
        throw new GeneralSecurityException("no primary in primitive set");
    }

    private zzqz() {
    }

    static void zzc() throws GeneralSecurityException {
        zzpa.zza().zza(zza);
    }
}
