package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzof  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzof extends zzbi {
    private final zzqb zza;

    public final zzcb zza() {
        return new zza(this.zza.zzf(), this.zza.zzb());
    }

    public final zzqb zza(@Nullable zzch zzch) throws GeneralSecurityException {
        zza(this.zza, zzch);
        return this.zza;
    }

    public final zzaaj zzc() throws GeneralSecurityException {
        zzqb zzqb = this.zza;
        if (zzqb.zzb().equals(zzxz.RAW)) {
            return zzaaj.zza(new byte[0]);
        }
        if (zzqb.zzb().equals(zzxz.TINK)) {
            return zzpe.zzb(zzqb.zze().intValue());
        }
        if (zzqb.zzb().equals(zzxz.LEGACY) || zzqb.zzb().equals(zzxz.CRUNCHY)) {
            return zzpe.zza(zzqb.zze().intValue());
        }
        throw new GeneralSecurityException("Unknown output prefix type");
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzof$zza */
    /* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
    private static class zza extends zzcb {
        private final String zza;
        private final zzxz zzb;

        public final String toString() {
            String str;
            String str2 = this.zza;
            int i = zzoe.zza[this.zzb.ordinal()];
            if (i == 1) {
                str = "TINK";
            } else if (i == 2) {
                str = "LEGACY";
            } else if (i == 3) {
                str = "RAW";
            } else if (i != 4) {
                str = "UNKNOWN";
            } else {
                str = "CRUNCHY";
            }
            return String.format("(typeUrl=%s, outputPrefixType=%s)", new Object[]{str2, str});
        }

        private zza(String str, zzxz zzxz) {
            this.zza = str;
            this.zzb = zzxz;
        }

        public final boolean zza() {
            return this.zzb != zzxz.RAW;
        }
    }

    @Nullable
    public final Integer zzb() {
        return this.zza.zze();
    }

    public zzof(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        zza(zzqb, zzch);
        this.zza = zzqb;
    }

    private static void zza(zzqb zzqb, @Nullable zzch zzch) throws GeneralSecurityException {
        int i = zzoe.zzb[zzqb.zza().ordinal()];
        if (i == 1 || i == 2) {
            zzch.zza(zzch);
        }
    }
}
