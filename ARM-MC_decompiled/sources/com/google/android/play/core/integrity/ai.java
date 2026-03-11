package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.o;
import com.google.android.play.integrity.internal.s;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
final class ai extends o {
    final /* synthetic */ aj a;
    private final s b = new s("OnRequestIntegrityTokenCallback");
    private final TaskCompletionSource c;

    ai(aj ajVar, TaskCompletionSource taskCompletionSource) {
        this.a = ajVar;
        this.c = taskCompletionSource;
    }

    public final void b(Bundle bundle) {
        this.a.a.v(this.c);
        this.b.d("onRequestIntegrityToken", new Object[0]);
        ApiException a2 = this.a.e.a(bundle);
        if (a2 != null) {
            this.c.trySetException(a2);
            return;
        }
        String string = bundle.getString("token");
        if (string == null) {
            this.c.trySetException(new IntegrityServiceException(-100, (Throwable) null));
            return;
        }
        ah ahVar = new ah(this, this.a.c, bundle.getLong("request.token.sid"));
        TaskCompletionSource taskCompletionSource = this.c;
        a aVar = new a();
        aVar.b(string);
        aVar.a(ahVar);
        taskCompletionSource.trySetResult(aVar.c());
    }
}
