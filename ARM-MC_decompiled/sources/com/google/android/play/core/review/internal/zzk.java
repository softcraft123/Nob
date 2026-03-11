package com.google.android.play.core.review.internal;

import android.os.IBinder;

/* compiled from: com.google.android.play:review@@2.0.2 */
public final /* synthetic */ class zzk implements IBinder.DeathRecipient {
    public final /* synthetic */ zzt zza;

    public /* synthetic */ zzk(zzt zzt) {
        this.zza = zzt;
    }

    public final void binderDied() {
        zzt.zzj(this.zza);
    }
}
