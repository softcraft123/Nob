package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.ag;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
final class ax {
    private static aw a;

    static synchronized aw a(Context context) {
        aw awVar;
        synchronized (ax.class) {
            if (a == null) {
                u uVar = new u((t) null);
                uVar.a(ag.a(context));
                a = uVar.b();
            }
            awVar = a;
        }
        return awVar;
    }
}
