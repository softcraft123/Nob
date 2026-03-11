package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzkg;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzki  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzki extends zzlj {
    private final zzkq zza;
    private final zzaal zzb;

    public final /* synthetic */ zzbi zzc() {
        return (zzkq) zzc();
    }

    public final /* synthetic */ zzcb zza() {
        return (zzkg) zza();
    }

    public static zzki zza(zzkq zzkq, zzaal zzaal) throws GeneralSecurityException {
        ECParameterSpec eCParameterSpec;
        if (zzkq == null) {
            throw new GeneralSecurityException("HPKE private key cannot be constructed without an HPKE public key");
        } else if (zzaal != null) {
            zzkg.zzf zze = ((zzkg) ((zzlg) zzkq.zza())).zze();
            int zza2 = zzaal.zza();
            String str = "Encoded private key byte length for " + String.valueOf(zze) + " must be %d, not " + zza2;
            if (zze == zzkg.zzf.zza) {
                if (zza2 != 32) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{32}));
                }
            } else if (zze == zzkg.zzf.zzb) {
                if (zza2 != 48) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{48}));
                }
            } else if (zze == zzkg.zzf.zzc) {
                if (zza2 != 66) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{66}));
                }
            } else if (zze != zzkg.zzf.zzd) {
                throw new GeneralSecurityException("Unable to validate private key length for " + String.valueOf(zze));
            } else if (zza2 != 32) {
                throw new GeneralSecurityException(String.format(str, new Object[]{32}));
            }
            zzkg.zzf zze2 = ((zzkg) ((zzlg) zzkq.zza())).zze();
            byte[] zzb2 = zzkq.zze().zzb();
            byte[] zza3 = zzaal.zza(zzbf.zza());
            if (zze2 == zzkg.zzf.zza || zze2 == zzkg.zzf.zzb || zze2 == zzkg.zzf.zzc) {
                if (zze2 == zzkg.zzf.zza) {
                    eCParameterSpec = zznj.zza;
                } else if (zze2 == zzkg.zzf.zzb) {
                    eCParameterSpec = zznj.zzb;
                } else if (zze2 == zzkg.zzf.zzc) {
                    eCParameterSpec = zznj.zzc;
                } else {
                    throw new IllegalArgumentException("Unable to determine NIST curve params for " + String.valueOf(zze2));
                }
                BigInteger order = eCParameterSpec.getOrder();
                BigInteger zza4 = zzne.zza(zza3);
                if (zza4.signum() <= 0 || zza4.compareTo(order) >= 0) {
                    throw new GeneralSecurityException("Invalid private key.");
                } else if (!zznj.zza(zza4, eCParameterSpec).equals(zzzf.zza(eCParameterSpec.getCurve(), zzzh.UNCOMPRESSED, zzb2))) {
                    throw new GeneralSecurityException("Invalid private key for public key.");
                }
            } else if (zze2 != zzkg.zzf.zzd) {
                throw new IllegalArgumentException("Unable to validate key pair for " + String.valueOf(zze2));
            } else if (!Arrays.equals(zzaah.zza(zza3), zzb2)) {
                throw new GeneralSecurityException("Invalid private key for public key.");
            }
            return new zzki(zzkq, zzaal);
        } else {
            throw new GeneralSecurityException("HPKE private key cannot be constructed without secret");
        }
    }

    public final /* synthetic */ zzlg zzd() {
        return (zzkg) ((zzlg) this.zza.zza());
    }

    public final /* synthetic */ zzli zze() {
        return this.zza;
    }

    public final zzaal zzf() {
        return this.zzb;
    }

    private zzki(zzkq zzkq, zzaal zzaal) {
        this.zza = zzkq;
        this.zzb = zzaal;
    }
}
