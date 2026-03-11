package com.google.android.recaptcha.internal;

import com.google.common.base.Ascii;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public abstract class zzjv {
    private static final char[] zza = "0123456789abcdef".toCharArray();
    public static final /* synthetic */ int zzb = 0;

    zzjv() {
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzjv) {
            zzjv zzjv = (zzjv) obj;
            if (zzb() != zzjv.zzb() || !zzc(zzjv)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (zzb() >= 32) {
            return zza();
        }
        byte[] zze = zze();
        byte b = zze[0] & 255;
        for (int i = 1; i < zze.length; i++) {
            b |= (zze[i] & 255) << (i * 8);
        }
        return b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(r1 + r1);
        for (byte b : zze()) {
            char[] cArr = zza;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & Ascii.SI]);
        }
        return sb.toString();
    }

    public abstract int zza();

    public abstract int zzb();

    /* access modifiers changed from: package-private */
    public abstract boolean zzc(zzjv zzjv);

    public abstract byte[] zzd();

    /* access modifiers changed from: package-private */
    public byte[] zze() {
        throw null;
    }
}
