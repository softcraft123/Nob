package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import com.google.android.gms.internal.p002firebaseauthapi.zzkg;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzmg {
    private static final zzps<zzki, zzbd> zza = zzps.zza(new zzmj(), zzki.class, zzbd.class);
    private static final zzps<zzkq, zzbg> zzb = zzps.zza(new zzmi(), zzkq.class, zzbg.class);
    private static final zzcd<zzbd> zzc = zzod.zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey", zzbd.class, zzwr.zzf());
    private static final zzbh<zzbg> zzd = zzod.zza("type.googleapis.com/google.crypto.tink.HpkePublicKey", zzbg.class, zzwx.zzb.ASYMMETRIC_PUBLIC, zzwu.zzg());
    private static final zzor<zzkg> zze = new zzml();

    public static /* synthetic */ zzki zza(zzkg zzkg, Integer num) {
        zzaal zzaal;
        zzaaj zzaaj;
        byte[] bArr;
        if (zzkg.zze().equals(zzkg.zzf.zzd)) {
            byte[] zza2 = zzaah.zza();
            zzaal = zzaal.zza(zza2, zzbf.zza());
            zzaaj = zzaaj.zza(zzaah.zza(zza2));
        } else if (zzkg.zze().equals(zzkg.zzf.zza) || zzkg.zze().equals(zzkg.zzf.zzb) || zzkg.zze().equals(zzkg.zzf.zzc)) {
            zzzi zzc2 = zzmk.zzc(zzkg.zze());
            KeyPair zza3 = zzzf.zza(zzzf.zza(zzc2));
            zzzh zzzh = zzzh.UNCOMPRESSED;
            ECPoint w = ((ECPublicKey) zza3.getPublic()).getW();
            EllipticCurve curve = zzzf.zza(zzc2).getCurve();
            zznj.zza(w, curve);
            int zza4 = zzzf.zza(curve);
            int ordinal = zzzh.ordinal();
            if (ordinal != 0) {
                int i = 2;
                if (ordinal == 1) {
                    int i2 = zza4 + 1;
                    bArr = new byte[i2];
                    byte[] zza5 = zzne.zza(w.getAffineX());
                    System.arraycopy(zza5, 0, bArr, i2 - zza5.length, zza5.length);
                    if (w.getAffineY().testBit(0)) {
                        i = 3;
                    }
                    bArr[0] = (byte) i;
                } else if (ordinal == 2) {
                    int i3 = zza4 * 2;
                    bArr = new byte[i3];
                    byte[] zza6 = zzne.zza(w.getAffineX());
                    if (zza6.length > zza4) {
                        zza6 = Arrays.copyOfRange(zza6, zza6.length - zza4, zza6.length);
                    }
                    byte[] zza7 = zzne.zza(w.getAffineY());
                    if (zza7.length > zza4) {
                        zza7 = Arrays.copyOfRange(zza7, zza7.length - zza4, zza7.length);
                    }
                    System.arraycopy(zza7, 0, bArr, i3 - zza7.length, zza7.length);
                    System.arraycopy(zza6, 0, bArr, zza4 - zza6.length, zza6.length);
                } else {
                    throw new GeneralSecurityException("invalid format:" + String.valueOf(zzzh));
                }
            } else {
                int i4 = (zza4 * 2) + 1;
                bArr = new byte[i4];
                byte[] zza8 = zzne.zza(w.getAffineX());
                byte[] zza9 = zzne.zza(w.getAffineY());
                System.arraycopy(zza9, 0, bArr, i4 - zza9.length, zza9.length);
                System.arraycopy(zza8, 0, bArr, (zza4 + 1) - zza8.length, zza8.length);
                bArr[0] = 4;
            }
            zzaaj = zzaaj.zza(bArr);
            zzaal = zzaal.zza(zzne.zza(((ECPrivateKey) zza3.getPrivate()).getS(), zzmk.zza(zzkg.zze())), zzbf.zza());
        } else {
            throw new GeneralSecurityException("Unknown KEM ID");
        }
        return zzki.zza(zzkq.zza(zzkg, zzaaj, num), zzaal);
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zziv.zza.ALGORITHM_NOT_FIPS.zza()) {
            zzkl.zza();
            zzox zza2 = zzox.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzkg.zzc().zza(zzkg.zze.zza).zza(zzkg.zzf.zzd).zza(zzkg.zzc.zza).zza(zzkg.zzb.zza).zza());
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzkg.zzc().zza(zzkg.zze.zzc).zza(zzkg.zzf.zzd).zza(zzkg.zzc.zza).zza(zzkg.zzb.zza).zza());
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzkg.zzc().zza(zzkg.zze.zza).zza(zzkg.zzf.zzd).zza(zzkg.zzc.zza).zza(zzkg.zzb.zzb).zza());
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzkg.zzc().zza(zzkg.zze.zzc).zza(zzkg.zzf.zzd).zza(zzkg.zzc.zza).zza(zzkg.zzb.zzb).zza());
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", zzkg.zzc().zza(zzkg.zze.zza).zza(zzkg.zzf.zzd).zza(zzkg.zzc.zza).zza(zzkg.zzb.zzc).zza());
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", zzkg.zzc().zza(zzkg.zze.zzc).zza(zzkg.zzf.zzd).zza(zzkg.zzc.zza).zza(zzkg.zzb.zzc).zza());
            hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzkg.zzc().zza(zzkg.zze.zza).zza(zzkg.zzf.zza).zza(zzkg.zzc.zza).zza(zzkg.zzb.zza).zza());
            hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzkg.zzc().zza(zzkg.zze.zzc).zza(zzkg.zzf.zza).zza(zzkg.zzc.zza).zza(zzkg.zzb.zza).zza());
            hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzkg.zzc().zza(zzkg.zze.zza).zza(zzkg.zzf.zza).zza(zzkg.zzc.zza).zza(zzkg.zzb.zzb).zza());
            hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzkg.zzc().zza(zzkg.zze.zzc).zza(zzkg.zzf.zza).zza(zzkg.zzc.zza).zza(zzkg.zzb.zzb).zza());
            hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", zzkg.zzc().zza(zzkg.zze.zza).zza(zzkg.zzf.zzb).zza(zzkg.zzc.zzb).zza(zzkg.zzb.zza).zza());
            hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", zzkg.zzc().zza(zzkg.zze.zzc).zza(zzkg.zzf.zzb).zza(zzkg.zzc.zzb).zza(zzkg.zzb.zza).zza());
            hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", zzkg.zzc().zza(zzkg.zze.zza).zza(zzkg.zzf.zzb).zza(zzkg.zzc.zzb).zza(zzkg.zzb.zzb).zza());
            hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", zzkg.zzc().zza(zzkg.zze.zzc).zza(zzkg.zzf.zzb).zza(zzkg.zzc.zzb).zza(zzkg.zzb.zzb).zza());
            hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", zzkg.zzc().zza(zzkg.zze.zza).zza(zzkg.zzf.zzc).zza(zzkg.zzc.zzc).zza(zzkg.zzb.zza).zza());
            hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", zzkg.zzc().zza(zzkg.zze.zzc).zza(zzkg.zzf.zzc).zza(zzkg.zzc.zzc).zza(zzkg.zzb.zza).zza());
            hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", zzkg.zzc().zza(zzkg.zze.zza).zza(zzkg.zzf.zzc).zza(zzkg.zzc.zzc).zza(zzkg.zzb.zzb).zza());
            hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", zzkg.zzc().zza(zzkg.zze.zzc).zza(zzkg.zzf.zzc).zza(zzkg.zzc.zzc).zza(zzkg.zzb.zzb).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zzpa.zza().zza(zza);
            zzpa.zza().zza(zzb);
            zzop.zza().zza(zze, zzkg.class);
            zznq.zza().zza(zzc, true);
            zznq.zza().zza(zzd, false);
            return;
        }
        throw new GeneralSecurityException("Registering HPKE Hybrid Encryption is not supported in FIPS mode");
    }
}
