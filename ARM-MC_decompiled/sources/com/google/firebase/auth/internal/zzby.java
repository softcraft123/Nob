package com.google.firebase.auth.internal;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzba;
import com.google.android.gms.internal.p002firebaseauthapi.zzcl;
import com.google.android.gms.internal.p002firebaseauthapi.zzco;
import com.google.android.gms.internal.p002firebaseauthapi.zzcv;
import com.google.android.gms.internal.p002firebaseauthapi.zzmy;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzby {
    private static zzby zza;
    private final String zzb;
    private final zzmy zzc;

    private static zzmy zzb(Context context, String str) throws GeneralSecurityException, IOException {
        return new zzmy.zza().zza(context, "StorageCryptoKeyset", zzc(str)).zza(zzcv.zzb).zza(String.format("android-keystore://firebear_main_key_id_for_storage_crypto.%s", new Object[]{str})).zza();
    }

    private static zzmy zzc(Context context, String str) {
        try {
            zzcl.zza();
            return zzb(context, str);
        } catch (IOException | GeneralSecurityException e) {
            Log.e("FirebearStorageCryptoHelper", "Exception encountered during crypto setup:\n" + e.getMessage());
            if (e instanceof GeneralSecurityException) {
                context.getSharedPreferences(zzc(str), 0).edit().remove("StorageCryptoKeyset").apply();
                try {
                    return zzb(context, str);
                } catch (IOException | GeneralSecurityException e2) {
                    Log.e("FirebearStorageCryptoHelper", "Exception encountered during second attempt to crypto setup:\n" + e2.getMessage());
                    return null;
                }
            }
            return null;
        }
    }

    public static zzby zza(Context context, String str) {
        zzby zzby = zza;
        if (zzby == null || !Objects.equals(zzby.zzb, str)) {
            zza = new zzby(str, zzc(context, str));
        }
        return zza;
    }

    public final String zza(String str) {
        String str2;
        Preconditions.checkNotNull(str);
        zzmy zzmy = this.zzc;
        if (zzmy == null) {
            Log.e("FirebearStorageCryptoHelper", "KeysetManager failed to initialize - unable to decrypt data");
            return null;
        }
        try {
            synchronized (zzmy) {
                str2 = new String(((zzba) this.zzc.zza().zza(zzco.zza(), zzba.class)).zza(Base64.decode(str, 2), (byte[]) null), StandardCharsets.UTF_8);
            }
            return str2;
        } catch (IllegalArgumentException | GeneralSecurityException e) {
            Log.e("FirebearStorageCryptoHelper", "Exception encountered while decrypting bytes:\n" + e.getMessage());
            return null;
        }
    }

    public final String zzb(String str) {
        String encodeToString;
        Preconditions.checkNotNull(str);
        zzmy zzmy = this.zzc;
        if (zzmy == null) {
            Log.e("FirebearStorageCryptoHelper", "KeysetManager failed to initialize - unable to encrypt data");
            return null;
        }
        try {
            synchronized (zzmy) {
                encodeToString = Base64.encodeToString(((zzba) this.zzc.zza().zza(zzco.zza(), zzba.class)).zzb(str.getBytes(StandardCharsets.UTF_8), (byte[]) null), 2);
            }
            return encodeToString;
        } catch (GeneralSecurityException e) {
            Log.e("FirebearStorageCryptoHelper", "Exception encountered while encrypting bytes:\n" + e.getMessage());
            return null;
        }
    }

    private static String zzc(String str) {
        return String.format("com.google.firebase.auth.api.crypto.%s", new Object[]{str});
    }

    private zzby(String str, zzmy zzmy) {
        this.zzb = str;
        this.zzc = zzmy;
    }
}
