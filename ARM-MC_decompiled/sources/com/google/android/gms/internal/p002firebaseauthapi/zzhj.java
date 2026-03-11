package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzem;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzhj {
    private static final zzaaj zza;
    private static final zzph<zzem, zzqe> zzb = zzph.zza(new zzhm(), zzem.class, zzqe.class);
    private static final zzpd<zzqe> zzc;
    private static final zznx<zzej, zzqb> zzd = zznx.zza(new zzho(), zzej.class, zzqb.class);
    private static final zznt<zzqb> zze;

    /* access modifiers changed from: private */
    public static zzej zzb(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        if (zzqb.zzf().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzuv zza2 = zzuv.zza(zzqb.zzd(), zzaku.zza());
                if (zza2.zza() == 0) {
                    return zzej.zza(zza(zzqb.zzb()), zzaal.zza(zza2.zzd().zzd(), zzch.zza(zzch)), zzqb.zze());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzall unused) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
        }
    }

    private static zzem.zza zza(zzxz zzxz) throws GeneralSecurityException {
        int i = zzhq.zza[zzxz.ordinal()];
        if (i == 1) {
            return zzem.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzem.zza.zzb;
        }
        if (i == 4) {
            return zzem.zza.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxz.zza());
    }

    /* access modifiers changed from: private */
    public static zzem zzb(zzqe zzqe) throws GeneralSecurityException {
        if (zzqe.zza().zzf().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzuy.zza(zzqe.zza().zze(), zzaku.zza());
                return zzem.zza(zza(zzqe.zza().zzd()));
            } catch (zzall e) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: " + zzqe.zza().zzf());
        }
    }

    private static zzxz zza(zzem.zza zza2) throws GeneralSecurityException {
        if (zzem.zza.zza.equals(zza2)) {
            return zzxz.TINK;
        }
        if (zzem.zza.zzb.equals(zza2)) {
            return zzxz.CRUNCHY;
        }
        if (zzem.zza.zzc.equals(zza2)) {
            return zzxz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zza2));
    }

    static {
        zzaaj zzb2 = zzqn.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zza = zzb2;
        zzc = zzpd.zza(new zzhl(), zzb2, zzqe.class);
        zze = zznt.zza(new zzhn(), zzb2, zzqb.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzoz zza2 = zzoz.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
