package com.google.android.gms.internal.fido;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzga extends zzfq implements Serializable {
    private final MessageDigest zza;
    private final int zzb;
    private final boolean zzc;
    private final String zzd = "Hashing.sha256()";

    zzga(String str, String str2) {
        MessageDigest zzb2 = zzb("SHA-256");
        this.zza = zzb2;
        this.zzb = zzb2.getDigestLength();
        this.zzc = zzc(zzb2);
    }

    private static MessageDigest zzb(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    private static boolean zzc(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    public final String toString() {
        return this.zzd;
    }

    public final zzfv zza() {
        if (this.zzc) {
            try {
                return new zzfz((MessageDigest) this.zza.clone(), this.zzb, (zzfy) null);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new zzfz(zzb(this.zza.getAlgorithm()), this.zzb, (zzfy) null);
    }
}
