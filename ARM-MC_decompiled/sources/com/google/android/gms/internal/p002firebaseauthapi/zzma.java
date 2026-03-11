package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzkg;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzma  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzma implements zzbd {
    private static final byte[] zza = new byte[0];
    private final zzme zzb;
    private final zzmf zzc;
    private final zzmc zzd;
    private final zzly zze;
    private final int zzf;
    private final byte[] zzg;

    public static zzbd zza(zzki zzki) throws GeneralSecurityException {
        int i;
        zzkg zzkg = (zzkg) ((zzlg) zzki.zza());
        zzmf zza2 = zzmh.zza(zzkg.zze());
        zzmc zza3 = zzmh.zza(zzkg.zzd());
        zzly zza4 = zzmh.zza(zzkg.zzb());
        zzkg.zzf zze2 = zzkg.zze();
        if (zze2.equals(zzkg.zzf.zzd)) {
            i = 32;
        } else if (zze2.equals(zzkg.zzf.zza)) {
            i = 65;
        } else if (zze2.equals(zzkg.zzf.zzb)) {
            i = 97;
        } else if (zze2.equals(zzkg.zzf.zzc)) {
            i = 133;
        } else {
            throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
        }
        int i2 = i;
        zzkg.zzf zze3 = ((zzkg) ((zzlg) zzki.zza())).zze();
        if (zze3.equals(zzkg.zzf.zzd) || zze3.equals(zzkg.zzf.zza) || zze3.equals(zzkg.zzf.zzb) || zze3.equals(zzkg.zzf.zzc)) {
            return new zzma(new zzme(zzaaj.zza(zzki.zzf().zza(zzbf.zza())), ((zzkq) ((zzli) zzki.zzc())).zze()), zza2, zza3, zza4, i2, zzki.zzh());
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    private zzma(zzme zzme, zzmf zzmf, zzmc zzmc, zzly zzly, int i, zzaaj zzaaj) {
        this.zzb = zzme;
        this.zzc = zzmf;
        this.zzd = zzmc;
        this.zze = zzly;
        this.zzf = i;
        this.zzg = zzaaj.zzb();
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzg;
        int length = bArr3.length + this.zzf;
        if (bArr.length < length) {
            throw new GeneralSecurityException("Ciphertext is too short.");
        } else if (zzqn.zza(bArr3, bArr)) {
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            return zzmb.zza(Arrays.copyOfRange(bArr, this.zzg.length, length), this.zzb, this.zzc, this.zzd, this.zze, bArr2).zza(bArr, length, zza);
        } else {
            throw new GeneralSecurityException("Invalid ciphertext (output prefix mismatch)");
        }
    }
}
