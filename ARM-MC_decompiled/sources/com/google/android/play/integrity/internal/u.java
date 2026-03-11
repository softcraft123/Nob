package com.google.android.play.integrity.internal;

import android.os.IBinder;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
public final /* synthetic */ class u implements IBinder.DeathRecipient {
    public final /* synthetic */ ae a;

    public /* synthetic */ u(ae aeVar) {
        this.a = aeVar;
    }

    public final void binderDied() {
        ae.k(this.a);
    }
}
