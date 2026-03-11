package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzkb;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzke  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzke extends zzlj {
    private final zzkh zza;
    @Nullable
    private final zzaam zzb;
    @Nullable
    private final zzaal zzc;

    public final /* synthetic */ zzbi zzc() {
        return (zzkh) zzc();
    }

    public final /* synthetic */ zzcb zza() {
        return (zzkb) zza();
    }

    public static zzke zza(zzkh zzkh, zzaal zzaal) throws GeneralSecurityException {
        if (zzkh == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        } else if (zzkh.zze() == null) {
            throw new GeneralSecurityException("ECIES private key for X25519 curve cannot be constructed with NIST-curve public key");
        } else if (zzaal != null) {
            byte[] zza2 = zzaal.zza(zzbf.zza());
            byte[] zzb2 = zzkh.zze().zzb();
            if (zza2.length != 32) {
                throw new GeneralSecurityException("Private key bytes length for X25519 curve must be 32");
            } else if (Arrays.equals(zzaah.zza(zza2), zzb2)) {
                return new zzke(zzkh, (zzaam) null, zzaal);
            } else {
                throw new GeneralSecurityException("Invalid private key for public key.");
            }
        } else {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
    }

    public static zzke zza(zzkh zzkh, zzaam zzaam) throws GeneralSecurityException {
        if (zzkh == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        } else if (zzkh.zzf() == null) {
            throw new GeneralSecurityException("ECIES private key for NIST curve cannot be constructed with X25519-curve public key");
        } else if (zzaam != null) {
            BigInteger zza2 = zzaam.zza(zzbf.zza());
            ECPoint zzf = zzkh.zzf();
            zzkb.zzc zzd = ((zzkb) ((zzlg) zzkh.zza())).zzd();
            BigInteger order = zza(zzd).getOrder();
            if (zza2.signum() <= 0 || zza2.compareTo(order) >= 0) {
                throw new GeneralSecurityException("Invalid private value");
            } else if (zznj.zza(zza2, zza(zzd)).equals(zzf)) {
                return new zzke(zzkh, zzaam, (zzaal) null);
            } else {
                throw new GeneralSecurityException("Invalid private value");
            }
        } else {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
    }

    public final /* synthetic */ zzlg zzd() {
        return (zzkb) ((zzlg) this.zza.zza());
    }

    public final /* synthetic */ zzli zze() {
        return this.zza;
    }

    @Nullable
    public final zzaam zzf() {
        return this.zzb;
    }

    @Nullable
    public final zzaal zzg() {
        return this.zzc;
    }

    private static ECParameterSpec zza(zzkb.zzc zzc2) {
        if (zzc2 == zzkb.zzc.zza) {
            return zznj.zza;
        }
        if (zzc2 == zzkb.zzc.zzb) {
            return zznj.zzb;
        }
        if (zzc2 == zzkb.zzc.zzc) {
            return zznj.zzc;
        }
        throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zzc2));
    }

    private zzke(zzkh zzkh, @Nullable zzaam zzaam, @Nullable zzaal zzaal) {
        this.zza = zzkh;
        this.zzb = zzaam;
        this.zzc = zzaal;
    }
}
