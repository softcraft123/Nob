package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzod {
    zzod() {
    }

    public static final boolean zza(Object obj) {
        return !((zzoc) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzoc zzoc = (zzoc) obj;
        zzoc zzoc2 = (zzoc) obj2;
        if (!zzoc2.isEmpty()) {
            if (!zzoc.zze()) {
                zzoc = zzoc.zzb();
            }
            zzoc.zzd(zzoc2);
        }
        return zzoc;
    }
}
