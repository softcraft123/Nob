package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdx;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzgt {
    private static final zzaaj zza;
    private static final zzph<zzdx, zzqe> zzb = zzph.zza(new zzgw(), zzdx.class, zzqe.class);
    private static final zzpd<zzqe> zzc;
    private static final zznx<zzds, zzqb> zzd = zznx.zza(new zzgy(), zzds.class, zzqb.class);
    private static final zznt<zzqb> zze;

    /* access modifiers changed from: private */
    public static zzds zzb(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        if (zzqb.zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzud zza2 = zzud.zza(zzqb.zzd(), zzaku.zza());
                if (zza2.zza() == 0) {
                    return zzds.zze().zza(zzdx.zze().zzb(zza2.zzd().zzb()).zza(12).zzc(16).zza(zza(zzqb.zzb())).zza()).zza(zzaal.zza(zza2.zzd().zzd(), zzch.zza(zzch))).zza(zzqb.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzall unused) {
                throw new GeneralSecurityException("Parsing AesGcmKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
    }

    private static zzdx.zza zza(zzxz zzxz) throws GeneralSecurityException {
        int i = zzha.zza[zzxz.ordinal()];
        if (i == 1) {
            return zzdx.zza.zza;
        }
        if (i == 2 || i == 3) {
            return zzdx.zza.zzb;
        }
        if (i == 4) {
            return zzdx.zza.zzc;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzxz.zza());
    }

    /* access modifiers changed from: private */
    public static zzdx zzb(zzqe zzqe) throws GeneralSecurityException {
        if (zzqe.zza().zzf().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzug zza2 = zzug.zza(zzqe.zza().zze(), zzaku.zza());
                if (zza2.zzb() == 0) {
                    return zzdx.zze().zzb(zza2.zza()).zza(12).zzc(16).zza(zza(zzqe.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzall e) {
                throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: " + zzqe.zza().zzf());
        }
    }

    private static zzxz zza(zzdx.zza zza2) throws GeneralSecurityException {
        if (zzdx.zza.zza.equals(zza2)) {
            return zzxz.TINK;
        }
        if (zzdx.zza.zzb.equals(zza2)) {
            return zzxz.CRUNCHY;
        }
        if (zzdx.zza.zzc.equals(zza2)) {
            return zzxz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zza2));
    }

    static {
        zzaaj zzb2 = zzqn.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zza = zzb2;
        zzc = zzpd.zza(new zzgv(), zzb2, zzqe.class);
        zze = zznt.zza(new zzgx(), zzb2, zzqb.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzoz zza2 = zzoz.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }

    /* access modifiers changed from: private */
    public static void zzb(zzdx zzdx) throws GeneralSecurityException {
        if (zzdx.zzd() != 16) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports serialization of AES GCM keys with tag size equal to 16 bytes.", new Object[]{Integer.valueOf(zzdx.zzd())}));
        } else if (zzdx.zzb() != 12) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d. Currently Tink only supports serialization of AES GCM keys with IV size equal to 12 bytes.", new Object[]{Integer.valueOf(zzdx.zzb())}));
        }
    }
}
