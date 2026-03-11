package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqu;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzrz {
    private static final zzaaj zza;
    private static final zzph<zzqu, zzqe> zzb = zzph.zza(new zzry(), zzqu.class, zzqe.class);
    private static final zzpd<zzqe> zzc;
    private static final zznx<zzqp, zzqb> zzd = zznx.zza(new zzsa(), zzqp.class, zzqb.class);
    private static final zznt<zzqb> zze;

    /* access modifiers changed from: private */
    public static zzqp zzb(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        if (zzqb.zzf().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzsw zza2 = zzsw.zza(zzqb.zzd(), zzaku.zza());
                if (zza2.zza() == 0) {
                    return zzqp.zzc().zza(zzqu.zzd().zza(zza2.zze().zzb()).zzb(zza2.zzd().zza()).zza(zza(zzqb.zzb())).zza()).zza(zzaal.zza(zza2.zze().zzd(), zzch.zza(zzch))).zza(zzqb.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzall | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing AesCmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
    }

    private static zzqu.zza zza(zzxz zzxz) throws GeneralSecurityException {
        int i = zzsc.zza[zzxz.ordinal()];
        if (i == 1) {
            return zzqu.zza.zza;
        }
        if (i == 2) {
            return zzqu.zza.zzb;
        }
        if (i == 3) {
            return zzqu.zza.zzc;
        }
        if (i == 4) {
            return zzqu.zza.zzd;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxz.zza());
    }

    /* access modifiers changed from: private */
    public static zzqu zzb(zzqe zzqe) throws GeneralSecurityException {
        if (zzqe.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzsz zza2 = zzsz.zza(zzqe.zza().zze(), zzaku.zza());
                return zzqu.zzd().zza(zza2.zza()).zzb(zza2.zzd().zza()).zza(zza(zzqe.zza().zzd())).zza();
            } catch (zzall e) {
                throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: " + zzqe.zza().zzf());
        }
    }

    private static zztc zzb(zzqu zzqu) {
        return (zztc) ((zzalf) zztc.zzb().zza(zzqu.zzb()).zze());
    }

    private static zzxz zza(zzqu.zza zza2) throws GeneralSecurityException {
        if (zzqu.zza.zza.equals(zza2)) {
            return zzxz.TINK;
        }
        if (zzqu.zza.zzb.equals(zza2)) {
            return zzxz.CRUNCHY;
        }
        if (zzqu.zza.zzd.equals(zza2)) {
            return zzxz.RAW;
        }
        if (zzqu.zza.zzc.equals(zza2)) {
            return zzxz.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zza2));
    }

    static {
        zzaaj zzb2 = zzqn.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zza = zzb2;
        zzc = zzpd.zza(new zzsb(), zzb2, zzqe.class);
        zze = zznt.zza(new zzsd(), zzb2, zzqb.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzoz zza2 = zzoz.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
