package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfc;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzfg {
    private static final zzaaj zza;
    private static final zzph<zzfc, zzqe> zzb = zzph.zza(new zzff(), zzfc.class, zzqe.class);
    private static final zzpd<zzqe> zzc;
    private static final zznx<zzfd, zzqb> zzd = zznx.zza(new zzfh(), zzfd.class, zzqb.class);
    private static final zznt<zzqb> zze;

    /* access modifiers changed from: private */
    public static zzfd zzb(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        if (zzqb.zzf().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                zzxt zza2 = zzxt.zza(zzqb.zzd(), zzaku.zza());
                if (zza2.zza() == 0) {
                    return zzfd.zza(zza(zza2.zzd(), zzqb.zzb()), zzqb.zze());
                }
                throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got " + String.valueOf(zza2));
            } catch (zzall e) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
    }

    /* access modifiers changed from: private */
    public static zzfc zzb(zzqe zzqe) throws GeneralSecurityException {
        if (zzqe.zza().zzf().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                return zza(zzxw.zza(zzqe.zza().zze(), zzaku.zza()), zzqe.zza().zzd());
            } catch (zzall e) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: " + zzqe.zza().zzf());
        }
    }

    private static zzfc zza(zzxw zzxw, zzxz zzxz) throws GeneralSecurityException {
        zzfc.zza zza2;
        zzfc.zzc zzc2;
        zzcb zza3 = zzcj.zza(((zzxb) ((zzalf) zzxb.zza().zza(zzxw.zza().zzf()).zza(zzxw.zza().zze()).zza(zzxz.RAW).zze())).zzk());
        if (zza3 instanceof zzdx) {
            zza2 = zzfc.zza.zza;
        } else if (zza3 instanceof zzem) {
            zza2 = zzfc.zza.zzc;
        } else if (zza3 instanceof zzge) {
            zza2 = zzfc.zza.zzb;
        } else if (zza3 instanceof zzdi) {
            zza2 = zzfc.zza.zzd;
        } else if (zza3 instanceof zzdq) {
            zza2 = zzfc.zza.zze;
        } else if (zza3 instanceof zzeg) {
            zza2 = zzfc.zza.zzf;
        } else {
            throw new GeneralSecurityException("Unsupported DEK parameters when parsing " + String.valueOf(zza3));
        }
        zzfc.zzb zzb2 = new zzfc.zzb();
        int i = zzfj.zza[zzxz.ordinal()];
        if (i == 1) {
            zzc2 = zzfc.zzc.zza;
        } else if (i == 2) {
            zzc2 = zzfc.zzc.zzb;
        } else {
            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxz.zza());
        }
        return zzb2.zza(zzc2).zza(zzxw.zze()).zza((zzcy) zza3).zza(zza2).zza();
    }

    private static zzxw zzb(zzfc zzfc) throws GeneralSecurityException {
        try {
            return (zzxw) ((zzalf) zzxw.zzb().zza(zzfc.zzd()).zza(zzxb.zza(zzcj.zza((zzcb) zzfc.zzb()), zzaku.zza())).zze());
        } catch (zzall e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    private static zzxz zza(zzfc.zzc zzc2) throws GeneralSecurityException {
        if (zzfc.zzc.zza.equals(zzc2)) {
            return zzxz.TINK;
        }
        if (zzfc.zzc.zzb.equals(zzc2)) {
            return zzxz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzc2));
    }

    static {
        zzaaj zzb2 = zzqn.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zza = zzb2;
        zzc = zzpd.zza(new zzfi(), zzb2, zzqe.class);
        zze = zznt.zza(new zzfk(), zzb2, zzqb.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzoz zza2 = zzoz.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
