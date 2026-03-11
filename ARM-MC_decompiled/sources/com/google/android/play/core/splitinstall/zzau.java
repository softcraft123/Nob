package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzau extends zzbb {
    zzau(zzbc zzbc, TaskCompletionSource taskCompletionSource) {
        super(zzbc, taskCompletionSource);
    }

    public final void zzc(Bundle bundle) throws RemoteException {
        super.zzc(bundle);
        this.zza.trySetResult(null);
    }
}
