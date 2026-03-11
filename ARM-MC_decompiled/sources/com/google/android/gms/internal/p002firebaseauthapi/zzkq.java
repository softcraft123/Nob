package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzkg;
import java.security.GeneralSecurityException;
import java.security.spec.EllipticCurve;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzkq extends zzli {
    private final zzkg zza;
    private final zzaaj zzb;
    private final zzaaj zzc;
    @Nullable
    private final Integer zzd;

    public final /* synthetic */ zzcb zza() {
        return (zzkg) zza();
    }

    public static zzkq zza(zzkg zzkg, zzaaj zzaaj, @Nullable Integer num) throws GeneralSecurityException {
        zzaaj zzaaj2;
        EllipticCurve ellipticCurve;
        zzkg.zze zzf = zzkg.zzf();
        if (!zzf.equals(zzkg.zze.zzc) && num == null) {
            throw new GeneralSecurityException("'idRequirement' must be non-null for " + String.valueOf(zzf) + " variant.");
        } else if (!zzf.equals(zzkg.zze.zzc) || num == null) {
            zzkg.zzf zze = zzkg.zze();
            int zza2 = zzaaj.zza();
            String str = "Encoded public key byte length for " + String.valueOf(zze) + " must be %d, not " + zza2;
            if (zze == zzkg.zzf.zza) {
                if (zza2 != 65) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{65}));
                }
            } else if (zze == zzkg.zzf.zzb) {
                if (zza2 != 97) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{97}));
                }
            } else if (zze == zzkg.zzf.zzc) {
                if (zza2 != 133) {
                    throw new GeneralSecurityException(String.format(str, new Object[]{133}));
                }
            } else if (zze != zzkg.zzf.zzd) {
                throw new GeneralSecurityException("Unable to validate public key length for " + String.valueOf(zze));
            } else if (zza2 != 32) {
                throw new GeneralSecurityException(String.format(str, new Object[]{32}));
            }
            if (zze == zzkg.zzf.zza || zze == zzkg.zzf.zzb || zze == zzkg.zzf.zzc) {
                if (zze == zzkg.zzf.zza) {
                    ellipticCurve = zznj.zza.getCurve();
                } else if (zze == zzkg.zzf.zzb) {
                    ellipticCurve = zznj.zzb.getCurve();
                } else if (zze == zzkg.zzf.zzc) {
                    ellipticCurve = zznj.zzc.getCurve();
                } else {
                    throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zze));
                }
                zznj.zza(zzzf.zza(ellipticCurve, zzzh.UNCOMPRESSED, zzaaj.zzb()), ellipticCurve);
            }
            zzkg.zze zzf2 = zzkg.zzf();
            if (zzf2 == zzkg.zze.zzc) {
                zzaaj2 = zzpe.zza;
            } else if (num == null) {
                throw new IllegalStateException("idRequirement must be non-null for HpkeParameters.Variant " + String.valueOf(zzf2));
            } else if (zzf2 == zzkg.zze.zzb) {
                zzaaj2 = zzpe.zza(num.intValue());
            } else if (zzf2 == zzkg.zze.zza) {
                zzaaj2 = zzpe.zzb(num.intValue());
            } else {
                throw new IllegalStateException("Unknown HpkeParameters.Variant: " + String.valueOf(zzf2));
            }
            return new zzkq(zzkg, zzaaj, zzaaj2, num);
        } else {
            throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
        }
    }

    public final /* synthetic */ zzlg zzc() {
        return this.zza;
    }

    public final zzaaj zzd() {
        return this.zzc;
    }

    public final zzaaj zze() {
        return this.zzb;
    }

    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    private zzkq(zzkg zzkg, zzaaj zzaaj, zzaaj zzaaj2, @Nullable Integer num) {
        this.zza = zzkg;
        this.zzb = zzaaj;
        this.zzc = zzaaj2;
        this.zzd = num;
    }
}
