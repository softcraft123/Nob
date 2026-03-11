package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
final class aa extends t {
    final /* synthetic */ IBinder a;
    final /* synthetic */ ad b;

    aa(ad adVar, IBinder iBinder) {
        this.b = adVar;
        this.a = iBinder;
    }

    public final void b() {
        this.b.a.o = (IInterface) this.b.a.j.a(this.a);
        ae.r(this.b.a);
        this.b.a.h = false;
        for (Runnable run : this.b.a.e) {
            run.run();
        }
        this.b.a.e.clear();
    }
}
