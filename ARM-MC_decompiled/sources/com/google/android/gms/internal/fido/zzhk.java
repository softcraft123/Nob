package com.google.android.gms.internal.fido;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzhk extends zzhp {
    private final long zza;

    zzhk(long j) {
        this.zza = j;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzhp zzhp = (zzhp) obj;
        if (zza() != zzhp.zza()) {
            return zza() - zzhp.zza();
        }
        int i = (Math.abs(this.zza) > Math.abs(((zzhk) zzhp).zza) ? 1 : (Math.abs(this.zza) == Math.abs(((zzhk) zzhp).zza) ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.zza == ((zzhk) obj).zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zza()), Long.valueOf(this.zza)});
    }

    public final String toString() {
        return Long.toString(this.zza);
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        return zzd(this.zza >= 0 ? (byte) 0 : 32);
    }

    public final long zzc() {
        return this.zza;
    }
}
