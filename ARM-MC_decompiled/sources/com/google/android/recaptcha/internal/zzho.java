package com.google.android.recaptcha.internal;

import java.lang.reflect.Field;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzho implements zzgx {
    public static final zzho zza = new zzho();

    private zzho() {
    }

    public final void zza(int i, zzgd zzgd, zzue... zzueArr) throws zzce {
        if (zzueArr.length == 2) {
            Object zza2 = zzgd.zzc().zza(zzueArr[0]);
            if (true != (zza2 instanceof Field)) {
                zza2 = null;
            }
            Field field = (Field) zza2;
            if (field != null) {
                try {
                    field.set((Object) null, zzgd.zzc().zza(zzueArr[1]));
                } catch (Exception e) {
                    throw new zzce(6, 11, e);
                }
            } else {
                throw new zzce(4, 5, (Throwable) null);
            }
        } else {
            throw new zzce(4, 3, (Throwable) null);
        }
    }
}
