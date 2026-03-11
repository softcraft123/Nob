package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzlh {
    public static final zzxb zza;
    private static final byte[] zzb;

    @Deprecated
    private static zzxb zza(zzvw zzvw, zzvy zzvy, zzvb zzvb, zzxb zzxb, zzxz zzxz, byte[] bArr) {
        return (zzxb) ((zzalf) zzxb.zza().zza(zzjx.zza()).zza(zzxz).zza(((zzvh) ((zzalf) zzvh.zza().zza((zzvk) ((zzalf) zzvk.zzc().zza((zzvt) ((zzalf) zzvt.zza().zza(zzvw).zza(zzvy).zza(zzajv.zza(bArr)).zze())).zza((zzve) ((zzalf) zzve.zza().zza(zzxb).zze())).zza(zzvb).zze())).zze())).zzj()).zze());
    }

    static {
        byte[] bArr = new byte[0];
        zzb = bArr;
        zza = zza(zzvw.NIST_P256, zzvy.SHA256, zzvb.UNCOMPRESSED, zzcv.zza, zzxz.TINK, bArr);
        zza(zzvw.NIST_P256, zzvy.SHA256, zzvb.COMPRESSED, zzcv.zza, zzxz.RAW, bArr);
        zza(zzvw.NIST_P256, zzvy.SHA256, zzvb.UNCOMPRESSED, zzcv.zzc, zzxz.TINK, bArr);
    }
}
