package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.collections.ArraysKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzhg implements zzgx {
    public static final zzhg zza = new zzhg();

    private zzhg() {
    }

    public final void zza(int i, zzgd zzgd, zzue... zzueArr) throws zzce {
        int length = zzueArr.length;
        if (length != 0) {
            Object zza2 = zzgd.zzc().zza(zzueArr[0]);
            if (true != (zza2 instanceof Method)) {
                zza2 = null;
            }
            Method method = (Method) zza2;
            if (method != null) {
                Object[] zzg = zzgd.zzc().zzg(ArraysKt.toList((T[]) zzueArr).subList(1, length));
                try {
                    zzgd.zzc().zze(i, method.invoke((Object) null, Arrays.copyOf(zzg, zzg.length)));
                } catch (Exception e) {
                    throw new zzce(6, 15, e);
                }
            } else {
                throw new zzce(4, 5, (Throwable) null);
            }
        } else {
            throw new zzce(4, 3, (Throwable) null);
        }
    }
}
