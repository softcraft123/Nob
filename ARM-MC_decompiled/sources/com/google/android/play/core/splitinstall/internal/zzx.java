package com.google.android.play.core.splitinstall.internal;

import android.os.IBinder;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final /* synthetic */ class zzx implements IBinder.DeathRecipient {
    public final /* synthetic */ zzaf zza;

    public /* synthetic */ zzx(zzaf zzaf) {
        this.zza = zzaf;
    }

    public final void binderDied() {
        zzaf.zzj(this.zza);
    }
}
