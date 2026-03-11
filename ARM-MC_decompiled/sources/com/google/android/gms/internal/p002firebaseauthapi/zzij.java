package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzge;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzij  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzij {
    private static final zzaaj zza;
    private static final zzph<zzge, zzqe> zzb = zzph.zza(new zzim(), zzge.class, zzqe.class);
    private static final zzpd<zzqe> zzc;
    private static final zznx<zzgb, zzqb> zzd = zznx.zza(new zzio(), zzgb.class, zzqb.class);
    private static final zznt<zzqb> zze;

    /* access modifiers changed from: private */
    public static zzgb zzb(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        if (zzqb.zzf().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                zzyo zza2 = zzyo.zza(zzqb.zzd(), zzaku.zza());
                if (zza2.zza() == 0) {
                    return zzgb.zza(zza(zzqb.zzb()), zzaal.zza(zza2.zzd().zzd(), zzch.zza(zzch)), zzqb.zze());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzall unused) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
    }

    private static zzge.zza zza(zzxz zzxz) throws GeneralSecurityException {
        int i = zziq.zza[zzxz.ordinal()];
        if (i == 1) {
            return zzge.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzge.zza.zzb;
        }
        if (i == 4) {
            return zzge.zza.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxz.zza());
    }

    /* access modifiers changed from: private */
    public static zzge zzb(zzqe zzqe) throws GeneralSecurityException {
        if (zzqe.zza().zzf().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                if (zzyr.zza(zzqe.zza().zze(), zzaku.zza()).zza() == 0) {
                    return zzge.zza(zza(zzqe.zza().zzd()));
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzall e) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: " + zzqe.zza().zzf());
        }
    }

    private static zzxz zza(zzge.zza zza2) throws GeneralSecurityException {
        if (zzge.zza.zza.equals(zza2)) {
            return zzxz.TINK;
        }
        if (zzge.zza.zzb.equals(zza2)) {
            return zzxz.CRUNCHY;
        }
        if (zzge.zza.zzc.equals(zza2)) {
            return zzxz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zza2));
    }

    static {
        zzaaj zzb2 = zzqn.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza = zzb2;
        zzc = zzpd.zza(new zzil(), zzb2, zzqe.class);
        zze = zznt.zza(new zzin(), zzb2, zzqb.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzoz zza2 = zzoz.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
