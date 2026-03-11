package com.google.android.gms.internal.fido;

import com.google.common.base.Ascii;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public abstract class zzft {
    private static final char[] zza = "0123456789abcdef".toCharArray();
    public static final /* synthetic */ int zzb = 0;

    zzft() {
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzft) {
            zzft zzft = (zzft) obj;
            if (zzb() != zzft.zzb() || !zzc(zzft)) {
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
    public abstract boolean zzc(zzft zzft);

    public abstract byte[] zzd();

    /* access modifiers changed from: package-private */
    public byte[] zze() {
        throw null;
    }
}
