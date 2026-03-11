package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzev;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzex  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzex {
    private static final zzaaj zza;
    private static final zzph<zzev, zzqe> zzb = zzph.zza(new zzew(), zzev.class, zzqe.class);
    private static final zzpd<zzqe> zzc;
    private static final zznx<zzet, zzqb> zzd = zznx.zza(new zzey(), zzet.class, zzqb.class);
    private static final zznt<zzqb> zze;

    /* access modifiers changed from: private */
    public static zzet zzb(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        if (zzqb.zzf().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            try {
                zzxn zza2 = zzxn.zza(zzqb.zzd(), zzaku.zza());
                if (zza2.zza() == 0) {
                    return zzet.zza(zzev.zza(zza2.zzd().zzd(), zza(zzqb.zzb())), zzqb.zze());
                }
                throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got " + String.valueOf(zza2));
            } catch (zzall e) {
                throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        }
    }

    private static zzev.zza zza(zzxz zzxz) throws GeneralSecurityException {
        int i = zzfa.zza[zzxz.ordinal()];
        if (i == 1) {
            return zzev.zza.zza;
        }
        if (i == 2) {
            return zzev.zza.zzb;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxz.zza());
    }

    /* access modifiers changed from: private */
    public static zzev zzb(zzqe zzqe) throws GeneralSecurityException {
        if (zzqe.zza().zzf().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            try {
                return zzev.zza(zzxq.zza(zzqe.zza().zze(), zzaku.zza()).zzd(), zza(zzqe.zza().zzd()));
            } catch (zzall e) {
                throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: " + zzqe.zza().zzf());
        }
    }

    private static zzxz zza(zzev.zza zza2) throws GeneralSecurityException {
        if (zzev.zza.zza.equals(zza2)) {
            return zzxz.TINK;
        }
        if (zzev.zza.zzb.equals(zza2)) {
            return zzxz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zza2));
    }

    static {
        zzaaj zzb2 = zzqn.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zza = zzb2;
        zzc = zzpd.zza(new zzez(), zzb2, zzqe.class);
        zze = zznt.zza(new zzfb(), zzb2, zzqb.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzoz zza2 = zzoz.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
