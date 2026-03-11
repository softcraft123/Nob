package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzhl implements zzgx {
    public static final zzhl zza = new zzhl();

    private zzhl() {
    }

    public final void zza(int i, zzgd zzgd, zzue... zzueArr) throws zzce {
        if (zzueArr.length == 1) {
            zzgd.zzc().zze(i, zzgd.zzc().zza(zzueArr[0]));
            return;
        }
        throw new zzce(4, 3, (Throwable) null);
    }
}
