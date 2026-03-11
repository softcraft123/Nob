package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzln  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzln {
    /* access modifiers changed from: private */
    public static final byte[] zza = new byte[0];

    public static zzlr zza(zzkb zzkb) throws GeneralSecurityException {
        zzcb zzb = zzkb.zzb();
        if (zzb instanceof zzdx) {
            return new zzlp((zzdx) zzb);
        }
        if (zzb instanceof zzdi) {
            return new zzlm((zzdi) zzb);
        }
        if (zzb instanceof zzjf) {
            return new zzlo((zzjf) zzb);
        }
        throw new GeneralSecurityException("Unsupported DEM parameters: " + String.valueOf(zzb));
    }
}
