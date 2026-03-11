package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfz;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzie  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzie {
    private static final zzaaj zza;
    private static final zzph<zzfz, zzqe> zzb = zzph.zza(new zzid(), zzfz.class, zzqe.class);
    private static final zzpd<zzqe> zzc;
    private static final zznx<zzfw, zzqb> zzd = zznx.zza(new zzif(), zzfw.class, zzqb.class);
    private static final zznt<zzqb> zze;

    /* access modifiers changed from: private */
    public static zzfw zzb(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        if (zzqb.zzf().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            try {
                zzyf zza2 = zzyf.zza(zzqb.zzd(), zzaku.zza());
                if (zza2.zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys are accepted");
                } else if (zza2.zze().zzb() == 32) {
                    return zzfw.zza(zzfz.zza(zza(zzqb.zzb()), zza2.zzd().zza()), zzaal.zza(zza2.zze().zzd(), zzch.zza(zzch)), zzqb.zze());
                } else {
                    throw new GeneralSecurityException("Only 32 byte key size is accepted");
                }
            } catch (zzall unused) {
                throw new GeneralSecurityException("Parsing XAesGcmKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseKey");
        }
    }

    private static zzfz.zza zza(zzxz zzxz) throws GeneralSecurityException {
        int i = zzih.zza[zzxz.ordinal()];
        if (i == 1) {
            return zzfz.zza.zza;
        }
        if (i == 2) {
            return zzfz.zza.zzb;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxz.zza());
    }

    /* access modifiers changed from: private */
    public static zzfz zzb(zzqe zzqe) throws GeneralSecurityException {
        if (zzqe.zza().zzf().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            try {
                zzyi zza2 = zzyi.zza(zzqe.zza().zze(), zzaku.zza());
                if (zza2.zza() == 0) {
                    return zzfz.zza(zza(zzqe.zza().zzd()), zza2.zzd().zza());
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzall e) {
                throw new GeneralSecurityException("Parsing XAesGcmParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseParameters: " + zzqe.zza().zzf());
        }
    }

    private static zzxz zza(zzfz.zza zza2) throws GeneralSecurityException {
        if (Objects.equals(zza2, zzfz.zza.zza)) {
            return zzxz.TINK;
        }
        if (Objects.equals(zza2, zzfz.zza.zzb)) {
            return zzxz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zza2));
    }

    static {
        zzaaj zzb2 = zzqn.zzb("type.googleapis.com/google.crypto.tink.XAesGcmKey");
        zza = zzb2;
        zzc = zzpd.zza(new zzig(), zzb2, zzqe.class);
        zze = zznt.zza(new zzii(), zzb2, zzqb.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzoz zza2 = zzoz.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
