package com.google.android.gms.internal.p002firebaseauthapi;

import com.bumptech.glide.load.Key;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzahx {
    public static long zza(String str) {
        zzahw zzb = zzb(str);
        return zzb.zza().longValue() - zzb.zzb().longValue();
    }

    private static zzahw zzb(String str) {
        Preconditions.checkNotEmpty(str);
        List<String> zza = zzt.zza('.').zza((CharSequence) str);
        if (zza.size() >= 2) {
            try {
                return zzahw.zza(new String(Base64Utils.decodeUrlSafeNoPadding(zza.get(1)), Key.STRING_CHARSET_NAME));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("Unable to decode token", e);
            }
        } else {
            throw new RuntimeException("Invalid idToken " + str);
        }
    }
}
