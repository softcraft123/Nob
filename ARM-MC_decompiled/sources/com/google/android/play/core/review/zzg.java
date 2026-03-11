package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.review.internal.zzi;
import com.google.android.play.core.review.internal.zzt;

/* compiled from: com.google.android.play:review@@2.0.2 */
class zzg extends com.google.android.play.core.review.internal.zzg {
    final zzi zza;
    final TaskCompletionSource zzb;
    final /* synthetic */ zzi zzc;

    zzg(zzi zzi, zzi zzi2, TaskCompletionSource taskCompletionSource) {
        this.zzc = zzi;
        this.zza = zzi2;
        this.zzb = taskCompletionSource;
    }

    public void zzb(Bundle bundle) throws RemoteException {
        zzt zzt = this.zzc.zza;
        if (zzt != null) {
            zzt.zzu(this.zzb);
        }
        this.zza.zzc("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
