package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Build;
import com.bumptech.glide.load.Key;
import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzqn {
    public static final Charset zza = Charset.forName(Key.STRING_CHARSET_NAME);

    public static int zza() {
        byte b = 0;
        while (b == 0) {
            byte[] zza2 = zzqd.zza(4);
            b = (zza2[3] & 255) | ((zza2[0] & 255) << Ascii.CAN) | ((zza2[1] & 255) << Ascii.DLE) | ((zza2[2] & 255) << 8);
        }
        return b;
    }

    public static final zzaaj zza(String str) throws GeneralSecurityException {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < '!' || charAt > '~') {
                throw new GeneralSecurityException("Not a printable ASCII character: " + charAt);
            }
            bArr[i] = (byte) charAt;
        }
        return zzaaj.zza(bArr);
    }

    public static final zzaaj zzb(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < '!' || charAt > '~') {
                throw new zzql("Not a printable ASCII character: " + charAt);
            }
            bArr[i] = (byte) charAt;
        }
        return zzaaj.zza(bArr);
    }

    @Nullable
    public static Integer zzb() {
        if (!Objects.equals(System.getProperty("java.vendor"), "The Android Project")) {
            return null;
        }
        return Integer.valueOf(Build.VERSION.SDK_INT);
    }

    public static boolean zza(byte[] bArr, byte[] bArr2) {
        if (bArr2.length < bArr.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr2[i] != bArr[i]) {
                return false;
            }
        }
        return true;
    }
}
