package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzkb;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzkh extends zzli {
    private final zzkb zza;
    @Nullable
    private final ECPoint zzb;
    @Nullable
    private final zzaaj zzc;
    private final zzaaj zzd;
    @Nullable
    private final Integer zze;

    public final /* synthetic */ zzcb zza() {
        return (zzkb) zza();
    }

    public static zzkh zza(zzkb zzkb, zzaaj zzaaj, @Nullable Integer num) throws GeneralSecurityException {
        if (zzkb.zzd().equals(zzkb.zzc.zzd)) {
            zzb(zzkb.zzg(), num);
            if (zzaaj.zza() == 32) {
                return new zzkh(zzkb, (ECPoint) null, zzaaj, zza(zzkb.zzg(), num), num);
            }
            throw new GeneralSecurityException("Encoded public point byte length for X25519 curve must be 32");
        }
        throw new GeneralSecurityException("createForCurveX25519 may only be called with parameters for curve X25519");
    }

    public static zzkh zza(zzkb zzkb, ECPoint eCPoint, @Nullable Integer num) throws GeneralSecurityException {
        EllipticCurve ellipticCurve;
        if (!zzkb.zzd().equals(zzkb.zzc.zzd)) {
            zzb(zzkb.zzg(), num);
            zzkb.zzc zzd2 = zzkb.zzd();
            if (zzd2 == zzkb.zzc.zza) {
                ellipticCurve = zznj.zza.getCurve();
            } else if (zzd2 == zzkb.zzc.zzb) {
                ellipticCurve = zznj.zzb.getCurve();
            } else if (zzd2 == zzkb.zzc.zzc) {
                ellipticCurve = zznj.zzc.getCurve();
            } else {
                throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zzd2));
            }
            zznj.zza(eCPoint, ellipticCurve);
            return new zzkh(zzkb, eCPoint, (zzaaj) null, zza(zzkb.zzg(), num), num);
        }
        throw new GeneralSecurityException("createForNistCurve may only be called with parameters for NIST curve");
    }

    public final /* synthetic */ zzlg zzc() {
        return this.zza;
    }

    private static zzaaj zza(zzkb.zzd zzd2, @Nullable Integer num) {
        if (zzd2 == zzkb.zzd.zzc) {
            return zzpe.zza;
        }
        if (num == null) {
            throw new IllegalStateException("idRequirement must be non-null for EciesParameters.Variant: " + String.valueOf(zzd2));
        } else if (zzd2 == zzkb.zzd.zzb) {
            return zzpe.zza(num.intValue());
        } else {
            if (zzd2 == zzkb.zzd.zza) {
                return zzpe.zzb(num.intValue());
            }
            throw new IllegalStateException("Unknown EciesParameters.Variant: " + String.valueOf(zzd2));
        }
    }

    public final zzaaj zzd() {
        return this.zzd;
    }

    @Nullable
    public final zzaaj zze() {
        return this.zzc;
    }

    @Nullable
    public final Integer zzb() {
        return this.zze;
    }

    @Nullable
    public final ECPoint zzf() {
        return this.zzb;
    }

    private zzkh(zzkb zzkb, @Nullable ECPoint eCPoint, @Nullable zzaaj zzaaj, zzaaj zzaaj2, @Nullable Integer num) {
        this.zza = zzkb;
        this.zzb = eCPoint;
        this.zzc = zzaaj;
        this.zzd = zzaaj2;
        this.zze = num;
    }

    private static void zzb(zzkb.zzd zzd2, @Nullable Integer num) throws GeneralSecurityException {
        if (!zzd2.equals(zzkb.zzd.zzc) && num == null) {
            throw new GeneralSecurityException("'idRequirement' must be non-null for " + String.valueOf(zzd2) + " variant.");
        } else if (zzd2.equals(zzkb.zzd.zzc) && num != null) {
            throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
        }
    }
}
