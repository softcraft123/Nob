package com.google.android.play.core.splitinstall.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzr extends BroadcastReceiver {
    final /* synthetic */ zzs zza;

    /* synthetic */ zzr(zzs zzs, zzq zzq) {
        this.zza = zzs;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.zza(context, intent);
    }
}
