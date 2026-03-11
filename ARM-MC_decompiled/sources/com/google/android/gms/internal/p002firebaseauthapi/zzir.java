package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import javax.crypto.Cipher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzir  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzir extends ThreadLocal<Cipher> {
    /* access modifiers changed from: protected */
    @Nullable
    public final /* synthetic */ Object initialValue() {
        return zza();
    }

    @Nullable
    private static Cipher zza() {
        try {
            Cipher zza = zzzj.zza.zza("AES/GCM-SIV/NoPadding");
            if (!zzgz.zza(zza)) {
                return null;
            }
            return zza;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    zzir() {
    }
}
