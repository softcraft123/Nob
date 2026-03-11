package com.google.android.gms.internal.fido;

import java.util.Comparator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzgl {
    static final String zza;
    static final Comparator zzb;

    static {
        Comparator comparator;
        String concat = String.valueOf(zzgl.class.getName()).concat("$UnsafeComparator");
        zza = concat;
        try {
            comparator = (Comparator) ((Object[]) Objects.requireNonNull(Class.forName(concat).getEnumConstants()))[0];
        } catch (Throwable unused) {
            comparator = zzgk.INSTANCE;
        }
        zzb = comparator;
    }

    zzgl() {
    }
}
