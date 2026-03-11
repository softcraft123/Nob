package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdi;
import com.google.android.gms.internal.p002firebaseauthapi.zzwh;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzgg {
    private static final zzaaj zza;
    private static final zzph<zzdi, zzqe> zzb = zzph.zza(new zzgi(), zzdi.class, zzqe.class);
    private static final zzpd<zzqe> zzc;
    private static final zznx<zzdd, zzqb> zzd = zznx.zza(new zzgk(), zzdd.class, zzqb.class);
    private static final zznt<zzqb> zze;

    /* access modifiers changed from: private */
    public static zzdd zzb(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        if (zzqb.zzf().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zztf zza2 = zztf.zza(zzqb.zzd(), zzaku.zza());
                if (zza2.zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys are accepted");
                } else if (zza2.zzd().zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
                } else if (zza2.zze().zza() == 0) {
                    return zzdd.zze().zza(zzdi.zzf().zza(zza2.zzd().zzf().zzb()).zzb(zza2.zze().zzf().zzb()).zzc(zza2.zzd().zze().zza()).zzd(zza2.zze().zze().zza()).zza(zza(zza2.zze().zze().zzb())).zza(zza(zzqb.zzb())).zza()).zza(zzaal.zza(zza2.zzd().zzf().zzd(), zzch.zza(zzch))).zzb(zzaal.zza(zza2.zze().zzf().zzd(), zzch.zza(zzch))).zza(zzqb.zze()).zza();
                } else {
                    throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
                }
            } catch (zzall unused) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
    }

    private static zzdi.zza zza(zzvy zzvy) throws GeneralSecurityException {
        int i = zzgm.zzb[zzvy.ordinal()];
        if (i == 1) {
            return zzdi.zza.zza;
        }
        if (i == 2) {
            return zzdi.zza.zzb;
        }
        if (i == 3) {
            return zzdi.zza.zzc;
        }
        if (i == 4) {
            return zzdi.zza.zzd;
        }
        if (i == 5) {
            return zzdi.zza.zze;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + zzvy.zza());
    }

    private static zzdi.zzc zza(zzxz zzxz) throws GeneralSecurityException {
        int i = zzgm.zza[zzxz.ordinal()];
        if (i == 1) {
            return zzdi.zzc.zza;
        }
        if (i == 2 || i == 3) {
            return zzdi.zzc.zzb;
        }
        if (i == 4) {
            return zzdi.zzc.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxz.zza());
    }

    /* access modifiers changed from: private */
    public static zzdi zzb(zzqe zzqe) throws GeneralSecurityException {
        if (zzqe.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzti zza2 = zzti.zza(zzqe.zza().zze(), zzaku.zza());
                if (zza2.zzd().zzb() == 0) {
                    return zzdi.zzf().zza(zza2.zzc().zza()).zzb(zza2.zzd().zza()).zzc(zza2.zzc().zze().zza()).zzd(zza2.zzd().zzf().zza()).zza(zza(zza2.zzd().zzf().zzb())).zza(zza(zzqe.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzall e) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: " + zzqe.zza().zzf());
        }
    }

    private static zzwh zzb(zzdi zzdi) throws GeneralSecurityException {
        zzvy zzvy;
        zzwh.zza zza2 = zzwh.zzc().zza(zzdi.zze());
        zzdi.zza zzg = zzdi.zzg();
        if (zzdi.zza.zza.equals(zzg)) {
            zzvy = zzvy.SHA1;
        } else if (zzdi.zza.zzb.equals(zzg)) {
            zzvy = zzvy.SHA224;
        } else if (zzdi.zza.zzc.equals(zzg)) {
            zzvy = zzvy.SHA256;
        } else if (zzdi.zza.zzd.equals(zzg)) {
            zzvy = zzvy.SHA384;
        } else if (zzdi.zza.zze.equals(zzg)) {
            zzvy = zzvy.SHA512;
        } else {
            throw new GeneralSecurityException("Unable to serialize HashType " + String.valueOf(zzg));
        }
        return (zzwh) ((zzalf) zza2.zza(zzvy).zze());
    }

    private static zzxz zza(zzdi.zzc zzc2) throws GeneralSecurityException {
        if (zzdi.zzc.zza.equals(zzc2)) {
            return zzxz.TINK;
        }
        if (zzdi.zzc.zzb.equals(zzc2)) {
            return zzxz.CRUNCHY;
        }
        if (zzdi.zzc.zzc.equals(zzc2)) {
            return zzxz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzc2));
    }

    static {
        zzaaj zzb2 = zzqn.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zza = zzb2;
        zzc = zzpd.zza(new zzgh(), zzb2, zzqe.class);
        zze = zznt.zza(new zzgj(), zzb2, zzqb.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzoz zza2 = zzoz.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
