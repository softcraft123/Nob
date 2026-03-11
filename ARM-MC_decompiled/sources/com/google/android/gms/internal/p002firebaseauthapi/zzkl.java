package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzkg;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzkl {
    private static final zzaaj zza;
    private static final zzaaj zzb;
    private static final zzph<zzkg, zzqe> zzc = zzph.zza(new zzkk(), zzkg.class, zzqe.class);
    private static final zzpd<zzqe> zzd;
    private static final zznx<zzkq, zzqb> zze = zznx.zza(new zzkm(), zzkq.class, zzqb.class);
    private static final zznt<zzqb> zzf;
    private static final zznx<zzki, zzqb> zzg = zznx.zza(new zzko(), zzki.class, zzqb.class);
    private static final zznt<zzqb> zzh;
    private static final zznl<zzxz, zzkg.zze> zzi = zznl.zza().zza(zzxz.RAW, zzkg.zze.zzc).zza(zzxz.TINK, zzkg.zze.zza).zza(zzxz.LEGACY, zzkg.zze.zzb).zza(zzxz.CRUNCHY, zzkg.zze.zzb).zza();
    private static final zznl<zzwm, zzkg.zzf> zzj = zznl.zza().zza(zzwm.DHKEM_P256_HKDF_SHA256, zzkg.zzf.zza).zza(zzwm.DHKEM_P384_HKDF_SHA384, zzkg.zzf.zzb).zza(zzwm.DHKEM_P521_HKDF_SHA512, zzkg.zzf.zzc).zza(zzwm.DHKEM_X25519_HKDF_SHA256, zzkg.zzf.zzd).zza();
    private static final zznl<zzwj, zzkg.zzc> zzk = zznl.zza().zza(zzwj.HKDF_SHA256, zzkg.zzc.zza).zza(zzwj.HKDF_SHA384, zzkg.zzc.zzb).zza(zzwj.HKDF_SHA512, zzkg.zzc.zzc).zza();
    private static final zznl<zzwk, zzkg.zzb> zzl = zznl.zza().zza(zzwk.AES_128_GCM, zzkg.zzb.zza).zza(zzwk.AES_256_GCM, zzkg.zzb.zzb).zza(zzwk.CHACHA20_POLY1305, zzkg.zzb.zzc).zza();

    private static zzkg zza(zzxz zzxz, zzwo zzwo) throws GeneralSecurityException {
        return zzkg.zzc().zza(zzi.zza(zzxz)).zza(zzj.zza(zzwo.zzc())).zza(zzk.zza(zzwo.zzb())).zza(zzl.zza(zzwo.zza())).zza();
    }

    /* access modifiers changed from: private */
    public static zzkg zzb(zzqe zzqe) throws GeneralSecurityException {
        if (zzqe.zza().zzf().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            try {
                return zza(zzqe.zza().zzd(), zzwl.zza(zzqe.zza().zze(), zzaku.zza()).zzc());
            } catch (zzall e) {
                throw new GeneralSecurityException("Parsing HpkeParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parseParameters: " + zzqe.zza().zzf());
        }
    }

    /* access modifiers changed from: private */
    public static zzki zzc(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        if (zzqb.zzf().equals("type.googleapis.com/google.crypto.tink.HpkePrivateKey")) {
            try {
                zzwr zza2 = zzwr.zza(zzqb.zzd(), zzaku.zza());
                if (zza2.zza() == 0) {
                    zzwu zzd2 = zza2.zzd();
                    if (zzd2.zza() == 0) {
                        zzkg zza3 = zza(zzqb.zzb(), zzd2.zzb());
                        return zzki.zza(zzkq.zza(zza3, zza(zza3.zze(), zzd2.zzf().zzd()), zzqb.zze()), zzaal.zza(zzne.zza(zzne.zza(zza2.zze().zzd()), zzmk.zza(zza3.zze())), zzch.zza(zzch)));
                    }
                    throw new GeneralSecurityException("Only version 0 keys are accepted");
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzall unused) {
                throw new GeneralSecurityException("Parsing HpkePrivateKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePrivateKey: " + zzqb.zzf());
        }
    }

    /* access modifiers changed from: private */
    public static zzkq zzd(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        if (zzqb.zzf().equals("type.googleapis.com/google.crypto.tink.HpkePublicKey")) {
            try {
                zzwu zza2 = zzwu.zza(zzqb.zzd(), zzaku.zza());
                if (zza2.zza() == 0) {
                    zzkg zza3 = zza(zzqb.zzb(), zza2.zzb());
                    return zzkq.zza(zza3, zza(zza3.zze(), zza2.zzf().zzd()), zzqb.zze());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzall unused) {
                throw new GeneralSecurityException("Parsing HpkePublicKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePublicKey: " + zzqb.zzf());
        }
    }

    private static zzwo zzb(zzkg zzkg) throws GeneralSecurityException {
        return (zzwo) ((zzalf) zzwo.zzd().zza(zzj.zza(zzkg.zze())).zza(zzk.zza(zzkg.zzd())).zza(zzl.zza(zzkg.zzb())).zze());
    }

    private static zzwu zza(zzkq zzkq) throws GeneralSecurityException {
        return (zzwu) ((zzalf) zzwu.zzc().zza(0).zza(zzb((zzkg) ((zzlg) zzkq.zza()))).zza(zzajv.zza(zzkq.zze().zzb())).zze());
    }

    private static zzaaj zza(zzkg.zzf zzf2, byte[] bArr) throws GeneralSecurityException {
        return zzaaj.zza(zzne.zza(zzne.zza(bArr), zzmk.zzb(zzf2)));
    }

    static {
        zzaaj zzb2 = zzqn.zzb("type.googleapis.com/google.crypto.tink.HpkePrivateKey");
        zza = zzb2;
        zzaaj zzb3 = zzqn.zzb("type.googleapis.com/google.crypto.tink.HpkePublicKey");
        zzb = zzb3;
        zzd = zzpd.zza(new zzkn(), zzb2, zzqe.class);
        zzf = zznt.zza(new zzkp(), zzb3, zzqb.class);
        zzh = zznt.zza(new zzkr(), zzb2, zzqb.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzoz zza2 = zzoz.zza();
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
        zza2.zza(zzf);
        zza2.zza(zzg);
        zza2.zza(zzh);
    }
}
