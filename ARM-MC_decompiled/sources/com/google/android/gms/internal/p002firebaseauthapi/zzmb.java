package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzmb {
    private static final byte[] zza = new byte[0];
    private final zzly zzb;
    private final BigInteger zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private BigInteger zzf = BigInteger.ZERO;

    public static zzmb zza(byte[] bArr, zzme zzme, zzmf zzmf, zzmc zzmc, zzly zzly, byte[] bArr2) throws GeneralSecurityException {
        byte[] zza2 = zzmf.zza(bArr, zzme);
        byte[] bArr3 = zzmk.zza;
        byte[] zza3 = zzmk.zza(zzmf.zza(), zzmc.zzb(), zzly.zzc());
        byte[] bArr4 = zzmk.zzl;
        byte[] bArr5 = zza;
        byte[] zza4 = zzyz.zza(bArr3, zzmc.zza(bArr4, bArr5, "psk_id_hash", zza3), zzmc.zza(zzmk.zzl, bArr2, "info_hash", zza3));
        byte[] zza5 = zzmc.zza(zza2, bArr5, "secret", zza3);
        zzmc zzmc2 = zzmc;
        byte[] zza6 = zzmc2.zza(zza5, zza4, "key", zza3, zzly.zza());
        byte[] zza7 = zzmc2.zza(zza5, zza4, "base_nonce", zza3, zzly.zzb());
        zzly.zzb();
        zzly zzly2 = zzly;
        return new zzmb(bArr, zza6, zza7, BigInteger.ONE.shiftLeft(96).subtract(BigInteger.ONE), zzly2);
    }

    private zzmb(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, zzly zzly) {
        this.zzd = bArr2;
        this.zze = bArr3;
        this.zzc = bigInteger;
        this.zzb = zzly;
    }

    private final synchronized byte[] zza() throws GeneralSecurityException {
        byte[] zza2;
        zza2 = zzyz.zza(this.zze, zzne.zza(this.zzf, this.zzb.zzb()));
        if (this.zzf.compareTo(this.zzc) < 0) {
            this.zzf = this.zzf.add(BigInteger.ONE);
        } else {
            throw new GeneralSecurityException("message limit reached");
        }
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final byte[] zza(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        return this.zzb.zza(this.zzd, zza(), bArr, i, bArr2);
    }
}
