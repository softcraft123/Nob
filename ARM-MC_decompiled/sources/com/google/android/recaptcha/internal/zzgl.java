package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzgl implements zzgx {
    public static final zzgl zza = new zzgl();

    private zzgl() {
    }

    public final void zza(int i, zzgd zzgd, zzue... zzueArr) throws zzce {
        if (zzueArr.length == 2) {
            Object zza2 = zzgd.zzc().zza(zzueArr[0]);
            if (true != (zza2 instanceof String)) {
                zza2 = null;
            }
            String str = (String) zza2;
            if (str != null) {
                Object zza3 = zzgd.zzc().zza(zzueArr[1]);
                if (zza3 == null) {
                    throw new zzce(4, 4, (Throwable) null);
                } else if ((zza3 instanceof Integer) || (zza3 instanceof Short) || (zza3 instanceof Byte) || (zza3 instanceof Long) || (zza3 instanceof Double) || (zza3 instanceof Float) || (zza3 instanceof Boolean) || (zza3 instanceof Character) || (zza3 instanceof String)) {
                    zzgd.zzi().zzb(str, zza3.toString());
                } else {
                    throw new zzce(4, 7, (Throwable) null);
                }
            } else {
                throw new zzce(4, 5, (Throwable) null);
            }
        } else {
            throw new zzce(4, 3, (Throwable) null);
        }
    }
}
