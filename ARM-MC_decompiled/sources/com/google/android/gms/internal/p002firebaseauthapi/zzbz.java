package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzbz {
    public static zzbm zza(zzbv zzbv, zzch zzch) throws GeneralSecurityException, IOException {
        if (zzch != null) {
            return zzbm.zza(zzbv.zzb());
        }
        throw new NullPointerException("SecretKeyAccess cannot be null");
    }

    public static void zza(zzbm zzbm, zzby zzby, zzch zzch) throws IOException {
        if (zzch != null) {
            zzby.zza(zzbm.zzd());
            return;
        }
        throw new NullPointerException("SecretKeyAccess cannot be null");
    }
}
