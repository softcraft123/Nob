package com.google.android.recaptcha.internal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzhi implements zzgx {
    public static final zzhi zza = new zzhi();

    private zzhi() {
    }

    public final void zza(int i, zzgd zzgd, zzue... zzueArr) throws zzce {
        Serializable serializable;
        if (zzueArr.length == 2) {
            Object zza2 = zzgd.zzc().zza(zzueArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                Object zza3 = zzgd.zzc().zza(zzueArr[1]);
                if (true != (zza3 instanceof Integer)) {
                    zza3 = null;
                }
                Integer num = (Integer) zza3;
                if (num != null) {
                    int intValue = num.intValue();
                    if (zza2 instanceof Integer) {
                        serializable = Integer.valueOf(((Number) zza2).intValue() * intValue);
                    } else if (zza2 instanceof int[]) {
                        Collection arrayList = new ArrayList(r2);
                        for (int i2 : (int[]) zza2) {
                            arrayList.add(Integer.valueOf(i2 * intValue));
                        }
                        serializable = (Serializable) ((List) arrayList).toArray(new Integer[0]);
                    } else {
                        throw new zzce(4, 5, (Throwable) null);
                    }
                    zzgd.zzc().zze(i, serializable);
                    return;
                }
                throw new zzce(4, 5, (Throwable) null);
            }
            throw new zzce(4, 5, (Throwable) null);
        }
        throw new zzce(4, 3, (Throwable) null);
    }
}
