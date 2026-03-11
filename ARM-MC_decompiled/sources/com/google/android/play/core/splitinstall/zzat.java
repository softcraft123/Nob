package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzat extends zzbb {
    zzat(zzbc zzbc, TaskCompletionSource taskCompletionSource) {
        super(zzbc, taskCompletionSource);
    }

    public final void zzb(int i, Bundle bundle) throws RemoteException {
        super.zzb(i, bundle);
        this.zza.trySetResult(null);
    }
}
