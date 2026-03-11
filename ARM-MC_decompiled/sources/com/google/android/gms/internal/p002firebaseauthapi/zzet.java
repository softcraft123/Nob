package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzev;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzet  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzet extends zzcw {
    private final zzev zza;
    private final zzaaj zzb;
    @Nullable
    private final Integer zzc;

    public final /* synthetic */ zzcb zza() {
        return (zzev) zza();
    }

    public final /* synthetic */ zzcy zzc() {
        return this.zza;
    }

    public static zzet zza(zzev zzev, @Nullable Integer num) throws GeneralSecurityException {
        zzaaj zzaaj;
        if (zzev.zzb() == zzev.zza.zza) {
            if (num != null) {
                zzaaj = zzaaj.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            } else {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
        } else if (zzev.zzb() != zzev.zza.zzb) {
            throw new GeneralSecurityException("Unknown Variant: " + String.valueOf(zzev.zzb()));
        } else if (num == null) {
            zzaaj = zzaaj.zza(new byte[0]);
        } else {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        return new zzet(zzev, zzaaj, num);
    }

    public final zzaaj zzd() {
        return this.zzb;
    }

    public final Integer zzb() {
        return this.zzc;
    }

    private zzet(zzev zzev, zzaaj zzaaj, @Nullable Integer num) {
        this.zza = zzev;
        this.zzb = zzaaj;
        this.zzc = num;
    }
}
