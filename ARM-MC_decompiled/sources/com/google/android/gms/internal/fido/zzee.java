package com.google.android.gms.internal.fido;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzee {
    /* access modifiers changed from: private */
    public static final zzeg zza = zzb(zzeg.zzd);

    private static zzeg zzb(String[] strArr) {
        zzeg zzeg;
        try {
            zzeg = zzeh.zza();
        } catch (NoClassDefFoundError unused) {
            zzeg = null;
        }
        if (zzeg != null) {
            return zzeg;
        }
        StringBuilder sb = new StringBuilder();
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            try {
                return (zzeg) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable th) {
                th = th;
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb.append(10);
                sb.append(str);
                sb.append(": ");
                sb.append(th);
                i++;
            }
        }
        throw new IllegalStateException(sb.insert(0, "No logging platforms found:").toString());
    }
}
