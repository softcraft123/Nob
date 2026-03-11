package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.am;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
final class q implements x {
    private Context a;

    private q() {
    }

    /* synthetic */ q(p pVar) {
    }

    public final q a(Context context) {
        context.getClass();
        this.a = context;
        return this;
    }

    public final s b() {
        am.a(this.a, Context.class);
        return new s(this.a, (r) null);
    }
}
