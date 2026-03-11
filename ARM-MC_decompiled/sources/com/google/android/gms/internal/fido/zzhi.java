package com.google.android.gms.internal.fido;

import com.google.common.primitives.SignedBytes;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzhi extends zzhp {
    private final zzgx zza;

    zzhi(zzgx zzgx) {
        this.zza = zzgx;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzhp zzhp = (zzhp) obj;
        if (zzd(SignedBytes.MAX_POWER_OF_TWO) != zzhp.zza()) {
            return zzd(SignedBytes.MAX_POWER_OF_TWO) - zzhp.zza();
        }
        zzhi zzhi = (zzhi) zzhp;
        zzgx zzgx = this.zza;
        int zzd = zzgx.zzd();
        zzgx zzgx2 = zzhi.zza;
        if (zzd != zzgx2.zzd()) {
            return zzgx.zzd() - zzgx2.zzd();
        }
        return zzgm.zza().compare(zzgx.zzm(), zzhi.zza.zzm());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.zza.equals(((zzhi) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzd(SignedBytes.MAX_POWER_OF_TWO)), this.zza});
    }

    public final String toString() {
        zzgf zzd = zzgf.zzf().zzd();
        byte[] zzm = this.zza.zzm();
        String zzg = zzd.zzg(zzm, 0, zzm.length);
        return "h'" + zzg + "'";
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        return zzd(SignedBytes.MAX_POWER_OF_TWO);
    }

    public final zzgx zzc() {
        return this.zza;
    }
}
