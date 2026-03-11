package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdq;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzgl {
    private static final zzaaj zza;
    private static final zzph<zzdq, zzqe> zzb = zzph.zza(new zzgo(), zzdq.class, zzqe.class);
    private static final zzpd<zzqe> zzc;
    private static final zznx<zzdl, zzqb> zzd = zznx.zza(new zzgq(), zzdl.class, zzqb.class);
    private static final zznt<zzqb> zze;

    /* access modifiers changed from: private */
    public static zzdl zzb(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        if (zzqb.zzf().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zztu zza2 = zztu.zza(zzqb.zzd(), zzaku.zza());
                if (zza2.zza() == 0) {
                    return zzdl.zze().zza(zzdq.zze().zzb(zza2.zze().zzb()).zza(zza2.zzd().zza()).zzc(16).zza(zza(zzqb.zzb())).zza()).zza(zzaal.zza(zza2.zze().zzd(), zzch.zza(zzch))).zza(zzqb.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzall unused) {
                throw new GeneralSecurityException("Parsing AesEaxcKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
    }

    private static zzdq.zzb zza(zzxz zzxz) throws GeneralSecurityException {
        int i = zzgs.zza[zzxz.ordinal()];
        if (i == 1) {
            return zzdq.zzb.zza;
        }
        if (i == 2 || i == 3) {
            return zzdq.zzb.zzb;
        }
        if (i == 4) {
            return zzdq.zzb.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxz.zza());
    }

    /* access modifiers changed from: private */
    public static zzdq zzb(zzqe zzqe) throws GeneralSecurityException {
        if (zzqe.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zztx zza2 = zztx.zza(zzqe.zza().zze(), zzaku.zza());
                return zzdq.zze().zzb(zza2.zza()).zza(zza2.zzd().zza()).zzc(16).zza(zza(zzqe.zza().zzd())).zza();
            } catch (zzall e) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: " + zzqe.zza().zzf());
        }
    }

    private static zzua zzb(zzdq zzdq) throws GeneralSecurityException {
        if (zzdq.zzd() == 16) {
            return (zzua) ((zzalf) zzua.zzb().zza(zzdq.zzb()).zze());
        }
        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports aes eax keys with tag size equal to 16 bytes.", new Object[]{Integer.valueOf(zzdq.zzd())}));
    }

    private static zzxz zza(zzdq.zzb zzb2) throws GeneralSecurityException {
        if (zzdq.zzb.zza.equals(zzb2)) {
            return zzxz.TINK;
        }
        if (zzdq.zzb.zzb.equals(zzb2)) {
            return zzxz.CRUNCHY;
        }
        if (zzdq.zzb.zzc.equals(zzb2)) {
            return zzxz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzb2));
    }

    static {
        zzaaj zzb2 = zzqn.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zza = zzb2;
        zzc = zzpd.zza(new zzgn(), zzb2, zzqe.class);
        zze = zznt.zza(new zzgp(), zzb2, zzqb.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzoz zza2 = zzoz.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
