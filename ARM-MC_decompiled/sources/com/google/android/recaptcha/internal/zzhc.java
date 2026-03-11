package com.google.android.recaptcha.internal;

import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzhc implements zzgx {
    public static final zzhc zza = new zzhc();

    private zzhc() {
    }

    public final void zza(int i, zzgd zzgd, zzue... zzueArr) throws zzce {
        int length = zzueArr.length;
        if (length >= 2) {
            Object zza2 = zzgd.zzc().zza(zzueArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                Class<?> cls = zza2 instanceof Class ? (Class) zza2 : zza2.getClass();
                Object zza3 = zzgd.zzc().zza(zzueArr[1]);
                if (true != (zza3 instanceof String)) {
                    zza3 = null;
                }
                String str = (String) zza3;
                if (str != null) {
                    String zza4 = zzgd.zzh().zza(str);
                    if (!Intrinsics.areEqual((Object) zza4, (Object) "forName")) {
                        Class[] zzf = zzgd.zzc().zzf(ArraysKt.toList((T[]) zzueArr).subList(2, length));
                        try {
                            zzgd.zzc().zze(i, cls.getMethod(zza4, (Class[]) Arrays.copyOf(zzf, zzf.length)));
                        } catch (Exception e) {
                            throw new zzce(6, 13, e);
                        }
                    } else {
                        throw new zzce(6, 48, (Throwable) null);
                    }
                } else {
                    throw new zzce(4, 5, (Throwable) null);
                }
            } else {
                throw new zzce(4, 5, (Throwable) null);
            }
        } else {
            throw new zzce(4, 3, (Throwable) null);
        }
    }
}
