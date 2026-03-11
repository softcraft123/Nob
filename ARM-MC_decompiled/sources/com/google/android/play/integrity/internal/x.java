package com.google.android.play.integrity.internal;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
final class x extends t {
    final /* synthetic */ ae a;

    x(ae aeVar) {
        this.a = aeVar;
    }

    public final void b() {
        synchronized (this.a.g) {
            if (this.a.m.get() <= 0 || this.a.m.decrementAndGet() <= 0) {
                ae aeVar = this.a;
                if (aeVar.o != null) {
                    aeVar.c.d("Unbind from service.", new Object[0]);
                    ae aeVar2 = this.a;
                    aeVar2.b.unbindService(aeVar2.n);
                    this.a.h = false;
                    this.a.o = null;
                    this.a.n = null;
                }
                this.a.x();
                return;
            }
            this.a.c.d("Leaving the connection open for other ongoing calls.", new Object[0]);
        }
    }
}
