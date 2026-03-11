package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzax extends zzbb {
    zzax(zzbc zzbc, TaskCompletionSource taskCompletionSource) {
        super(zzbc, taskCompletionSource);
    }

    public final void zzf(Bundle bundle) throws RemoteException {
        super.zzf(bundle);
        this.zza.trySetResult(null);
    }
}
