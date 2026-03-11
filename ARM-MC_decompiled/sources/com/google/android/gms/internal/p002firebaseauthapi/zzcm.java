package com.google.android.gms.internal.p002firebaseauthapi;

import com.bumptech.glide.load.Key;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import com.google.android.gms.internal.p002firebaseauthapi.zzxh;
import com.google.android.gms.internal.p002firebaseauthapi.zzxk;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzcm {
    public static zzxk zza(zzxh zzxh) {
        zzxk.zza zza = zzxk.zza().zza(zzxh.zzb());
        for (zzxh.zzb next : zzxh.zze()) {
            zza.zza((zzxk.zzb) ((zzalf) zzxk.zzb.zza().zza(next.zzb().zzf()).zza(next.zzc()).zza(next.zzf()).zza(next.zza()).zze()));
        }
        return (zzxk) ((zzalf) zza.zze());
    }

    static {
        Charset.forName(Key.STRING_CHARSET_NAME);
    }

    public static void zzb(zzxh zzxh) throws GeneralSecurityException {
        int zzb = zzxh.zzb();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzxh.zzb next : zzxh.zze()) {
            if (next.zzc() == zzxc.ENABLED) {
                if (!next.zzg()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(next.zza())}));
                } else if (next.zzf() == zzxz.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(next.zza())}));
                } else if (next.zzc() != zzxc.UNKNOWN_STATUS) {
                    if (next.zza() == zzb) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    if (next.zzb().zzb() != zzwx.zzb.ASYMMETRIC_PUBLIC) {
                        z2 = false;
                    }
                    i++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(next.zza())}));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
