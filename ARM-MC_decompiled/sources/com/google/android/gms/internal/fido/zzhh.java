package com.google.android.gms.internal.fido;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzhh extends zzhp {
    private final boolean zza;

    zzhh(boolean z) {
        this.zza = z;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzhp zzhp = (zzhp) obj;
        if (zzd((byte) -32) != zzhp.zza()) {
            return zzd((byte) -32) - zzhp.zza();
        }
        zzhh zzhh = (zzhh) zzhp;
        int i = 20;
        int i2 = true != this.zza ? 20 : 21;
        if (true == zzhh.zza) {
            i = 21;
        }
        return i2 - i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.zza == ((zzhh) obj).zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzd((byte) -32)), Boolean.valueOf(this.zza)});
    }

    public final String toString() {
        return Boolean.toString(this.zza);
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        return zzd((byte) -32);
    }
}
