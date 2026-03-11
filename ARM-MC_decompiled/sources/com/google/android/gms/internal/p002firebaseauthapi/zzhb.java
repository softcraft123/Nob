package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzeg;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzhb {
    private static final zzaaj zza;
    private static final zzph<zzeg, zzqe> zzb = zzph.zza(new zzhe(), zzeg.class, zzqe.class);
    private static final zzpd<zzqe> zzc;
    private static final zznx<zzdz, zzqb> zzd = zznx.zza(new zzhg(), zzdz.class, zzqb.class);
    private static final zznt<zzqb> zze;

    /* access modifiers changed from: private */
    public static zzdz zzb(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        if (zzqb.zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzuj zza2 = zzuj.zza(zzqb.zzd(), zzaku.zza());
                if (zza2.zza() == 0) {
                    return zzdz.zze().zza(zzeg.zzc().zza(zza2.zzd().zzb()).zza(zza(zzqb.zzb())).zza()).zza(zzaal.zza(zza2.zzd().zzd(), zzch.zza(zzch))).zza(zzqb.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzall unused) {
                throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
    }

    private static zzeg.zzb zza(zzxz zzxz) throws GeneralSecurityException {
        int i = zzhi.zza[zzxz.ordinal()];
        if (i == 1) {
            return zzeg.zzb.zza;
        }
        if (i == 2 || i == 3) {
            return zzeg.zzb.zzb;
        }
        if (i == 4) {
            return zzeg.zzb.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxz.zza());
    }

    /* access modifiers changed from: private */
    public static zzeg zzb(zzqe zzqe) throws GeneralSecurityException {
        if (zzqe.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzum zza2 = zzum.zza(zzqe.zza().zze(), zzaku.zza());
                if (zza2.zzb() == 0) {
                    return zzeg.zzc().zza(zza2.zza()).zza(zza(zzqe.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzall e) {
                throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: " + zzqe.zza().zzf());
        }
    }

    private static zzxz zza(zzeg.zzb zzb2) throws GeneralSecurityException {
        if (zzeg.zzb.zza.equals(zzb2)) {
            return zzxz.TINK;
        }
        if (zzeg.zzb.zzb.equals(zzb2)) {
            return zzxz.CRUNCHY;
        }
        if (zzeg.zzb.zzc.equals(zzb2)) {
            return zzxz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzb2));
    }

    static {
        zzaaj zzb2 = zzqn.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zza = zzb2;
        zzc = zzpd.zza(new zzhd(), zzb2, zzqe.class);
        zze = zznt.zza(new zzhf(), zzb2, zzqb.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzoz zza2 = zzoz.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
