package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:integrity@@1.3.0 */
public final /* synthetic */ class v implements OnCompleteListener {
    public final /* synthetic */ ae a;
    public final /* synthetic */ TaskCompletionSource b;

    public /* synthetic */ v(ae aeVar, TaskCompletionSource taskCompletionSource) {
        this.a = aeVar;
        this.b = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.a.u(this.b, task);
    }
}
