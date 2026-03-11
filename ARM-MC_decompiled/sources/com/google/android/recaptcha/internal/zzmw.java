package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zzmw implements zzog {
    private static final zzmw zza = new zzmw();

    private zzmw() {
    }

    public static zzmw zza() {
        return zza;
    }

    public final zzof zzb(Class cls) {
        if (zznd.class.isAssignableFrom(cls)) {
            try {
                return (zzof) zznd.zzu(cls.asSubclass(zznd.class)).zzh(3, (Object) null, (Object) null);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
    }

    public final boolean zzc(Class cls) {
        return zznd.class.isAssignableFrom(cls);
    }
}
