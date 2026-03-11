package com.google.android.gms.internal.fido;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzhn extends zzhp {
    private final String zza;

    zzhn(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        int length;
        int length2;
        zzhp zzhp = (zzhp) obj;
        if (zzd((byte) 96) != zzhp.zza()) {
            length = zzhp.zza();
            length2 = zzd((byte) 96);
        } else {
            String str = this.zza;
            String str2 = ((zzhn) zzhp).zza;
            if (str.length() == str2.length()) {
                return str.compareTo(str2);
            }
            length = str2.length();
            length2 = str.length();
        }
        return length2 - length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.zza.equals(((zzhn) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzd((byte) 96)), this.zza});
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        return zzd((byte) 96);
    }
}
