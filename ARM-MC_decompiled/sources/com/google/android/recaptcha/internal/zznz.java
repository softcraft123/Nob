package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zznz implements zzog {
    private final zzog[] zza;

    zznz(zzog... zzogArr) {
        this.zza = zzogArr;
    }

    public final zzof zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzog zzog = this.zza[i];
            if (zzog.zzc(cls)) {
                return zzog.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
