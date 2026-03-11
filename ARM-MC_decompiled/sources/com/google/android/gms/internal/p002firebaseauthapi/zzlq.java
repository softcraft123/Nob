package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzkb;
import com.google.android.gms.internal.p002firebaseauthapi.zzvn;
import com.google.android.gms.internal.p002firebaseauthapi.zzvt;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzlq {
    private static final zzaaj zza;
    private static final zzaaj zzb;
    private static final zzph<zzkb, zzqe> zzc = zzph.zza(new zzlt(), zzkb.class, zzqe.class);
    private static final zzpd<zzqe> zzd;
    private static final zznx<zzkh, zzqb> zze = zznx.zza(new zzlv(), zzkh.class, zzqb.class);
    private static final zznt<zzqb> zzf;
    private static final zznx<zzke, zzqb> zzg = zznx.zza(new zzlx(), zzke.class, zzqb.class);
    private static final zznt<zzqb> zzh;
    private static final zznl<zzxz, zzkb.zzd> zzi = zznl.zza().zza(zzxz.RAW, zzkb.zzd.zzc).zza(zzxz.TINK, zzkb.zzd.zza).zza(zzxz.LEGACY, zzkb.zzd.zzb).zza(zzxz.CRUNCHY, zzkb.zzd.zzb).zza();
    private static final zznl<zzvy, zzkb.zzb> zzj = zznl.zza().zza(zzvy.SHA1, zzkb.zzb.zza).zza(zzvy.SHA224, zzkb.zzb.zzb).zza(zzvy.SHA256, zzkb.zzb.zzc).zza(zzvy.SHA384, zzkb.zzb.zzd).zza(zzvy.SHA512, zzkb.zzb.zze).zza();
    private static final zznl<zzvw, zzkb.zzc> zzk = zznl.zza().zza(zzvw.NIST_P256, zzkb.zzc.zza).zza(zzvw.NIST_P384, zzkb.zzc.zzb).zza(zzvw.NIST_P521, zzkb.zzc.zzc).zza(zzvw.CURVE25519, zzkb.zzc.zzd).zza();
    private static final zznl<zzvb, zzkb.zze> zzl = zznl.zza().zza(zzvb.UNCOMPRESSED, zzkb.zze.zzb).zza(zzvb.COMPRESSED, zzkb.zze.zza).zza(zzvb.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, zzkb.zze.zzc).zza();

    private static int zza(zzkb.zzc zzc2) throws GeneralSecurityException {
        if (zzkb.zzc.zza.equals(zzc2)) {
            return 33;
        }
        if (zzkb.zzc.zzb.equals(zzc2)) {
            return 49;
        }
        if (zzkb.zzc.zzc.equals(zzc2)) {
            return 67;
        }
        throw new GeneralSecurityException("Unable to serialize CurveType " + String.valueOf(zzc2));
    }

    private static zzkb zza(zzxz zzxz, zzvk zzvk) throws GeneralSecurityException {
        zzkb.zza zza2 = zzkb.zzc().zza(zzi.zza(zzxz)).zza(zzk.zza(zzvk.zzf().zzd())).zza(zzj.zza(zzvk.zzf().zze())).zza(zzcj.zza(((zzxb) ((zzalf) zzxb.zza().zza(zzvk.zzb().zzd().zzf()).zza(zzxz.RAW).zza(zzvk.zzb().zzd().zze()).zze())).zzk())).zza(zzaaj.zza(zzvk.zzf().zzf().zzd()));
        if (!zzvk.zzf().zzd().equals(zzvw.CURVE25519)) {
            zza2.zza(zzl.zza(zzvk.zza()));
        } else if (!zzvk.zza().equals(zzvb.COMPRESSED)) {
            throw new GeneralSecurityException("For CURVE25519 EcPointFormat must be compressed");
        }
        return zza2.zza();
    }

    /* access modifiers changed from: private */
    public static zzkb zzb(zzqe zzqe) throws GeneralSecurityException {
        if (zzqe.zza().zzf().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            try {
                return zza(zzqe.zza().zzd(), zzvh.zza(zzqe.zza().zze(), zzaku.zza()).zzc());
            } catch (zzall e) {
                throw new GeneralSecurityException("Parsing EciesParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parseParameters: " + zzqe.zza().zzf());
        }
    }

    /* access modifiers changed from: private */
    public static zzke zzc(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        if (zzqb.zzf().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
            try {
                zzvn zza2 = zzvn.zza(zzqb.zzd(), zzaku.zza());
                if (zza2.zza() == 0) {
                    zzvq zzd2 = zza2.zzd();
                    if (zzd2.zza() == 0) {
                        zzkb zza3 = zza(zzqb.zzb(), zzd2.zzb());
                        if (zza3.zzd().equals(zzkb.zzc.zzd)) {
                            return zzke.zza(zzkh.zza(zza3, zzaaj.zza(zzd2.zzf().zzd()), zzqb.zze()), zzaal.zza(zza2.zze().zzd(), zzch.zza(zzch)));
                        }
                        return zzke.zza(zzkh.zza(zza3, new ECPoint(zzne.zza(zzd2.zzf().zzd()), zzne.zza(zzd2.zzg().zzd())), zzqb.zze()), zzaam.zza(zzne.zza(zza2.zze().zzd()), zzch.zza(zzch)));
                    }
                    throw new GeneralSecurityException("Only version 0 keys are accepted");
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzall | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing EcdsaPrivateKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePrivateKey: " + zzqb.zzf());
        }
    }

    /* access modifiers changed from: private */
    public static zzkh zzd(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        if (zzqb.zzf().equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
            try {
                zzvq zza2 = zzvq.zza(zzqb.zzd(), zzaku.zza());
                if (zza2.zza() == 0) {
                    zzkb zza3 = zza(zzqb.zzb(), zza2.zzb());
                    if (!zza3.zzd().equals(zzkb.zzc.zzd)) {
                        return zzkh.zza(zza3, new ECPoint(zzne.zza(zza2.zzf().zzd()), zzne.zza(zza2.zzg().zzd())), zzqb.zze());
                    }
                    if (zza2.zzg().zzb() == 0) {
                        return zzkh.zza(zza3, zzaaj.zza(zza2.zzf().zzd()), zzqb.zze());
                    }
                    throw new GeneralSecurityException("Y must be empty for X25519 points");
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzall | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePublicKey: " + zzqb.zzf());
        }
    }

    public static /* synthetic */ zzqb zza(zzke zzke, zzch zzch) {
        zzvn.zza zza2 = zzvn.zzb().zza(0).zza(zza((zzkh) ((zzli) zzke.zzc())));
        if (((zzkb) ((zzlg) zzke.zza())).zzd().equals(zzkb.zzc.zzd)) {
            zza2.zza(zzajv.zza(zzke.zzg().zza(zzch.zza(zzch))));
        } else {
            zza2.zza(zzajv.zza(zzne.zza(zzke.zzf().zza(zzch.zza(zzch)), zza(((zzkb) ((zzlg) zzke.zza())).zzd()))));
        }
        return zzqb.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", ((zzvn) ((zzalf) zza2.zze())).zzj(), zzwx.zzb.ASYMMETRIC_PRIVATE, zzi.zza(((zzkb) ((zzlg) zzke.zza())).zzg()), zzke.zzb());
    }

    private static zzvk zzb(zzkb zzkb) throws GeneralSecurityException {
        zzvt.zza zza2 = zzvt.zza().zza(zzk.zza(zzkb.zzd())).zza(zzj.zza(zzkb.zze()));
        if (zzkb.zzh() != null && zzkb.zzh().zza() > 0) {
            zza2.zza(zzajv.zza(zzkb.zzh().zzb()));
        }
        zzvt zzvt = (zzvt) ((zzalf) zza2.zze());
        try {
            zzxb zza3 = zzxb.zza(zzcj.zza(zzkb.zzb()), zzaku.zza());
            zzve zzve = (zzve) ((zzalf) zzve.zza().zza((zzxb) ((zzalf) zzxb.zza().zza(zza3.zzf()).zza(zzxz.TINK).zza(zza3.zze()).zze())).zze());
            zzkb.zze zzf2 = zzkb.zzf();
            if (zzf2 == null) {
                zzf2 = zzkb.zze.zza;
            }
            return (zzvk) ((zzalf) zzvk.zzc().zza(zzvt).zza(zzve).zza(zzl.zza(zzf2)).zze());
        } catch (zzall e) {
            throw new GeneralSecurityException("Parsing EciesParameters failed: ", e);
        }
    }

    private static zzvq zza(zzkh zzkh) throws GeneralSecurityException {
        if (((zzkb) ((zzlg) zzkh.zza())).zzd().equals(zzkb.zzc.zzd)) {
            return (zzvq) ((zzalf) zzvq.zzc().zza(0).zza(zzb((zzkb) ((zzlg) zzkh.zza()))).zza(zzajv.zza(zzkh.zze().zzb())).zzb(zzajv.zza).zze());
        }
        int zza2 = zza(((zzkb) ((zzlg) zzkh.zza())).zzd());
        ECPoint zzf2 = zzkh.zzf();
        if (zzf2 != null) {
            return (zzvq) ((zzalf) zzvq.zzc().zza(0).zza(zzb((zzkb) ((zzlg) zzkh.zza()))).zza(zzajv.zza(zzne.zza(zzf2.getAffineX(), zza2))).zzb(zzajv.zza(zzne.zza(zzf2.getAffineY(), zza2))).zze());
        }
        throw new GeneralSecurityException("NistCurvePoint was null for NIST curve");
    }

    static {
        zzaaj zzb2 = zzqn.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        zza = zzb2;
        zzaaj zzb3 = zzqn.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
        zzb = zzb3;
        zzd = zzpd.zza(new zzls(), zzb2, zzqe.class);
        zzf = zznt.zza(new zzlu(), zzb3, zzqb.class);
        zzh = zznt.zza(new zzlw(), zzb2, zzqb.class);
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
