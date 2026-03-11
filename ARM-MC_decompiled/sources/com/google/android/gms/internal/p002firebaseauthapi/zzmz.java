package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzmz {
    public static zzba zza(String str) throws GeneralSecurityException {
        return new zznc(str, zza());
    }

    private static KeyStore zza() throws GeneralSecurityException {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            return instance;
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }

    public static boolean zzb(String str) throws GeneralSecurityException {
        return zza().containsAlias(str);
    }
}
