package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.ag;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
final class z {
    private static s a;

    static synchronized s a(Context context) {
        s sVar;
        synchronized (z.class) {
            if (a == null) {
                q qVar = new q((p) null);
                qVar.a(ag.a(context));
                a = qVar.b();
            }
            sVar = a;
        }
        return sVar;
    }
}
