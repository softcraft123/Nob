package com.google.android.recaptcha.internal;

import java.lang.reflect.Proxy;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzgt implements zzgx {
    public static final zzgt zza = new zzgt();

    private zzgt() {
    }

    public final void zza(int i, zzgd zzgd, zzue... zzueArr) throws zzce {
        int length = zzueArr.length;
        Object obj = null;
        if (length == 4 || length == 5) {
            Object zza2 = zzgd.zzc().zza(zzueArr[0]);
            if (true != (zza2 instanceof Integer)) {
                zza2 = null;
            }
            Integer num = (Integer) zza2;
            if (num != null) {
                int intValue = num.intValue();
                Object zza3 = zzgd.zzc().zza(zzueArr[1]);
                if (true != (zza3 instanceof Integer)) {
                    zza3 = null;
                }
                Integer num2 = (Integer) zza3;
                if (num2 != null) {
                    int intValue2 = num2.intValue();
                    Object zza4 = zzgd.zzc().zza(zzueArr[2]);
                    if (true != (zza4 instanceof String)) {
                        zza4 = null;
                    }
                    String str = (String) zza4;
                    if (str != null) {
                        String zza5 = zzgd.zzh().zza(str);
                        Object zza6 = zzgd.zzc().zza(zzueArr[3]);
                        if (true != (zza6 instanceof String)) {
                            zza6 = null;
                        }
                        String str2 = (String) zza6;
                        if (str2 != null) {
                            String zza7 = zzgd.zzh().zza(str2);
                            if (length == 5) {
                                obj = zzgd.zzc().zza(zzueArr[4]);
                            }
                            zzfz zzfz = new zzfz(intValue2);
                            try {
                                Class zza8 = zzgc.zza(zza5);
                                zzgd.zzc().zze(intValue, Proxy.newProxyInstance(zza8.getClassLoader(), new Class[]{zza8}, new zzga(zzfz, zza7, obj)));
                                zzgd.zzc().zze(i, zzfz);
                            } catch (Exception e) {
                                throw new zzce(6, 20, e);
                            }
                        } else {
                            throw new zzce(4, 5, (Throwable) null);
                        }
                    } else {
                        throw new zzce(4, 5, (Throwable) null);
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
