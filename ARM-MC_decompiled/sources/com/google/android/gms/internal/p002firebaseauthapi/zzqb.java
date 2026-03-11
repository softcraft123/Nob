package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzqb implements zzqf {
    private final String zza;
    private final zzaaj zzb;
    private final zzajv zzc;
    private final zzwx.zzb zzd;
    private final zzxz zze;
    @Nullable
    private final Integer zzf;

    public static zzqb zza(String str, zzajv zzajv, zzwx.zzb zzb2, zzxz zzxz, @Nullable Integer num) throws GeneralSecurityException {
        if (zzxz == zzxz.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzqb(str, zzqn.zza(str), zzajv, zzb2, zzxz, num);
    }

    public final zzwx.zzb zza() {
        return this.zzd;
    }

    public final zzxz zzb() {
        return this.zze;
    }

    public final zzaaj zzc() {
        return this.zzb;
    }

    public final zzajv zzd() {
        return this.zzc;
    }

    @Nullable
    public final Integer zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zza;
    }

    private zzqb(String str, zzaaj zzaaj, zzajv zzajv, zzwx.zzb zzb2, zzxz zzxz, @Nullable Integer num) {
        this.zza = str;
        this.zzb = zzaaj;
        this.zzc = zzajv;
        this.zzd = zzb2;
        this.zze = zzxz;
        this.zzf = num;
    }
}
