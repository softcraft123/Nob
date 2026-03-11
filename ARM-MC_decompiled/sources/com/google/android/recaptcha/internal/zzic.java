package com.google.android.recaptcha.internal;

import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzic implements zzih {
    private static final boolean zzb(int i) {
        try {
            new Socket("localhost", i).close();
            return true;
        } catch (ConnectException unused) {
            return false;
        }
    }

    public final /* synthetic */ Object cs(Object[] objArr) {
        return zzie.zza(this, objArr);
    }

    public final Object zza(Object... objArr) {
        int length = objArr.length;
        Collection arrayList = new ArrayList(length);
        int i = 0;
        while (i < length) {
            Integer num = objArr[i];
            if (true != (num instanceof Integer)) {
                num = null;
            }
            Integer num2 = num;
            if (num2 != null) {
                arrayList.add(Integer.valueOf(num2.intValue()));
                i++;
            } else {
                throw new zzce(4, 5, (Throwable) null);
            }
        }
        List arrayList2 = new ArrayList();
        for (Number intValue : (List) arrayList) {
            int intValue2 = intValue.intValue();
            if (zzb(intValue2)) {
                arrayList2.add(Integer.valueOf(intValue2));
            }
        }
        return arrayList2;
    }
}
