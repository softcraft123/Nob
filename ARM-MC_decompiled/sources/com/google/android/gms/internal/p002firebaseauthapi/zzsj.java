package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzrh;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzsj {
    private static final zzaaj zza;
    private static final zznl<zzxz, zzrh.zzc> zzb = zznl.zza().zza(zzxz.RAW, zzrh.zzc.zzd).zza(zzxz.TINK, zzrh.zzc.zza).zza(zzxz.LEGACY, zzrh.zzc.zzc).zza(zzxz.CRUNCHY, zzrh.zzc.zzb).zza();
    private static final zznl<zzvy, zzrh.zza> zzc = zznl.zza().zza(zzvy.SHA1, zzrh.zza.zza).zza(zzvy.SHA224, zzrh.zza.zzb).zza(zzvy.SHA256, zzrh.zza.zzc).zza(zzvy.SHA384, zzrh.zza.zzd).zza(zzvy.SHA512, zzrh.zza.zze).zza();
    private static final zzph<zzrh, zzqe> zzd = zzph.zza(new zzsi(), zzrh.class, zzqe.class);
    private static final zzpd<zzqe> zze;
    private static final zznx<zzra, zzqb> zzf = zznx.zza(new zzsk(), zzra.class, zzqb.class);
    private static final zznt<zzqb> zzg;

    /* access modifiers changed from: private */
    public static zzra zzb(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        if (zzqb.zzf().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzwb zza2 = zzwb.zza(zzqb.zzd(), zzaku.zza());
                if (zza2.zza() == 0) {
                    return zzra.zzc().zza(zzrh.zzd().zza(zza2.zzf().zzb()).zzb(zza2.zze().zza()).zza(zzc.zza(zza2.zze().zzb())).zza(zzb.zza(zzqb.zzb())).zza()).zza(zzaal.zza(zza2.zzf().zzd(), zzch.zza(zzch))).zza(zzqb.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzall | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing HmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
    }

    /* access modifiers changed from: private */
    public static zzrh zzb(zzqe zzqe) throws GeneralSecurityException {
        if (zzqe.zza().zzf().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzwe zza2 = zzwe.zza(zzqe.zza().zze(), zzaku.zza());
                if (zza2.zzb() == 0) {
                    return zzrh.zzd().zza(zza2.zza()).zzb(zza2.zzf().zza()).zza(zzc.zza(zza2.zzf().zzb())).zza(zzb.zza(zzqe.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zza2.zzb());
            } catch (zzall e) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: " + zzqe.zza().zzf());
        }
    }

    private static zzwh zzb(zzrh zzrh) throws GeneralSecurityException {
        return (zzwh) ((zzalf) zzwh.zzc().zza(zzrh.zzb()).zza(zzc.zza(zzrh.zze())).zze());
    }

    static {
        zzaaj zzb2 = zzqn.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zza = zzb2;
        zze = zzpd.zza(new zzsl(), zzb2, zzqe.class);
        zzg = zznt.zza(new zzsn(), zzb2, zzqb.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzoz zza2 = zzoz.zza();
        zza2.zza(zzd);
        zza2.zza(zze);
        zza2.zza(zzf);
        zza2.zza(zzg);
    }
}
