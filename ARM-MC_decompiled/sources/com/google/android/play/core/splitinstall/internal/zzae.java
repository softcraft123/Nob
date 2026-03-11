package com.google.android.play.core.splitinstall.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzae implements ServiceConnection {
    final /* synthetic */ zzaf zza;

    /* synthetic */ zzae(zzaf zzaf, zzad zzad) {
        this.zza = zzaf;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zza.zzc.zzd("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        zzaf zzaf = this.zza;
        zzaf.zzc().post(new zzab(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zzc.zzd("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        zzaf zzaf = this.zza;
        zzaf.zzc().post(new zzac(this));
    }
}
