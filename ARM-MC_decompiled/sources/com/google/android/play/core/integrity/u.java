package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.am;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
final class u implements av {
    private Context a;

    private u() {
    }

    /* synthetic */ u(t tVar) {
    }

    public final u a(Context context) {
        context.getClass();
        this.a = context;
        return this;
    }

    public final aw b() {
        am.a(this.a, Context.class);
        return new w(this.a, (v) null);
    }
}
