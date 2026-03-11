package com.google.android.recaptcha.internal;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzkc extends zzjs implements Serializable {
    private final MessageDigest zza;
    private final int zzb;
    private final boolean zzc;
    private final String zzd = "Hashing.sha256()";

    zzkc(String str, String str2) {
        MessageDigest zzc2 = zzc("SHA-256");
        this.zza = zzc2;
        this.zzb = zzc2.getDigestLength();
        String str3 = "Hashing.sha256()";
        this.zzc = zzd(zzc2);
    }

    private static MessageDigest zzc(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    private static boolean zzd(MessageDigest messageDigest) {
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

    public final zzjx zzb() {
        if (this.zzc) {
            try {
                return new zzka((MessageDigest) this.zza.clone(), this.zzb, (zzkb) null);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new zzka(zzc(this.zza.getAlgorithm()), this.zzb, (zzkb) null);
    }
}
