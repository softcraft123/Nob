package com.google.android.play.core.integrity;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.n;
import com.google.android.play.integrity.internal.t;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
final class ag extends t {
    final /* synthetic */ Bundle a;
    final /* synthetic */ Activity b;
    final /* synthetic */ TaskCompletionSource c;
    final /* synthetic */ int d;
    final /* synthetic */ aj e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ag(aj ajVar, TaskCompletionSource taskCompletionSource, Bundle bundle, Activity activity, TaskCompletionSource taskCompletionSource2, int i) {
        super(taskCompletionSource);
        this.e = ajVar;
        this.a = bundle;
        this.b = activity;
        this.c = taskCompletionSource2;
        this.d = i;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        try {
            Bundle bundle = this.a;
            aj ajVar = this.e;
            ((n) this.e.a.e()).c(bundle, ajVar.d.a(this.b, this.c, ajVar.a));
        } catch (RemoteException e2) {
            this.e.b.c(e2, "requestAndShowDialog(%s)", Integer.valueOf(this.d));
            this.c.trySetException(new IntegrityServiceException(-100, e2));
        }
    }
}
