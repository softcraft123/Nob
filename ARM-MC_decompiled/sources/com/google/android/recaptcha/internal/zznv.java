package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zznv {
    zznv() {
    }

    public static final List zza(Object obj, long j) {
        zznk zznk = (zznk) zzps.zzf(obj, j);
        if (zznk.zzc()) {
            return zznk;
        }
        int size = zznk.size();
        zznk zzd = zznk.zzd(size == 0 ? 10 : size + size);
        zzps.zzs(obj, j, zzd);
        return zzd;
    }
}
