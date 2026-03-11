package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzkb;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzze  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzze implements zzbg {
    static final zznl<zzzi, zzkb.zzc> zza = zznl.zza().zza(zzzi.NIST_P256, zzkb.zzc.zza).zza(zzzi.NIST_P384, zzkb.zzc.zzb).zza(zzzi.NIST_P521, zzkb.zzc.zzc).zza();
    static final zznl<zzzh, zzkb.zze> zzb = zznl.zza().zza(zzzh.UNCOMPRESSED, zzkb.zze.zzb).zza(zzzh.COMPRESSED, zzkb.zze.zza).zza(zzzh.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, zzkb.zze.zzc).zza();

    public static zzbg zza(zzkh zzkh) throws GeneralSecurityException {
        byte[] byteArray = zzkh.zzf().getAffineX().toByteArray();
        byte[] byteArray2 = zzkh.zzf().getAffineY().toByteArray();
        ECParameterSpec zza2 = zzzf.zza(zza.zza(((zzkb) ((zzlg) zzkh.zza())).zzd()));
        ECPoint eCPoint = new ECPoint(new BigInteger(1, byteArray), new BigInteger(1, byteArray2));
        zznj.zza(eCPoint, zza2.getCurve());
        ECPublicKey eCPublicKey = (ECPublicKey) zzzj.zze.zza("EC").generatePublic(new ECPublicKeySpec(eCPoint, zza2));
        byte[] bArr = new byte[0];
        if (((zzkb) ((zzlg) zzkh.zza())).zzh() != null) {
            bArr = ((zzkb) ((zzlg) zzkh.zza())).zzh().zzb();
        }
        return new zzze(eCPublicKey, bArr, zza(((zzkb) ((zzlg) zzkh.zza())).zze()), zzb.zza(((zzkb) ((zzlg) zzkh.zza())).zzf()), zzln.zza((zzkb) ((zzlg) zzkh.zza())), zzkh.zzd().zzb());
    }

    static final String zza(zzkb.zzb zzb2) throws GeneralSecurityException {
        if (zzb2.equals(zzkb.zzb.zza)) {
            return "HmacSha1";
        }
        if (zzb2.equals(zzkb.zzb.zzb)) {
            return "HmacSha224";
        }
        if (zzb2.equals(zzkb.zzb.zzc)) {
            return "HmacSha256";
        }
        if (zzb2.equals(zzkb.zzb.zzd)) {
            return "HmacSha384";
        }
        if (zzb2.equals(zzkb.zzb.zze)) {
            return "HmacSha512";
        }
        throw new GeneralSecurityException("hash unsupported for EciesAeadHkdf: " + String.valueOf(zzb2));
    }

    private zzze(ECPublicKey eCPublicKey, byte[] bArr, String str, zzzh zzzh, zzlr zzlr, byte[] bArr2) throws GeneralSecurityException {
        zznj.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        new zzzg(eCPublicKey);
    }
}
