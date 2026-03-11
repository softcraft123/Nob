package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfc;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzfd extends zzcw {
    private final zzfc zza;
    private final zzaaj zzb;
    @Nullable
    private final Integer zzc;

    public final /* synthetic */ zzcb zza() {
        return (zzfc) zza();
    }

    public final /* synthetic */ zzcy zzc() {
        return this.zza;
    }

    public static zzfd zza(zzfc zzfc, @Nullable Integer num) throws GeneralSecurityException {
        zzaaj zzaaj;
        if (zzfc.zzc() == zzfc.zzc.zzb) {
            if (num == null) {
                zzaaj = zzpe.zza;
            } else {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
        } else if (zzfc.zzc() != zzfc.zzc.zza) {
            throw new GeneralSecurityException("Unknown Variant: " + String.valueOf(zzfc.zzc()));
        } else if (num != null) {
            zzaaj = zzpe.zzb(num.intValue());
        } else {
            throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
        }
        return new zzfd(zzfc, zzaaj, num);
    }

    public final zzaaj zzd() {
        return this.zzb;
    }

    public final Integer zzb() {
        return this.zzc;
    }

    private zzfd(zzfc zzfc, zzaaj zzaaj, @Nullable Integer num) {
        this.zza = zzfc;
        this.zzb = zzaaj;
        this.zzc = num;
    }
}
