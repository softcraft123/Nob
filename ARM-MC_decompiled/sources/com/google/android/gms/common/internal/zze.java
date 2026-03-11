package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public final class zze implements ServiceConnection {
    final /* synthetic */ BaseGmsClient zza;
    private final int zzb;

    public zze(BaseGmsClient baseGmsClient, int i) {
        Objects.requireNonNull(baseGmsClient);
        this.zza = baseGmsClient;
        this.zzb = i;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IGmsServiceBroker iGmsServiceBroker;
        BaseGmsClient baseGmsClient = this.zza;
        if (iBinder == null) {
            baseGmsClient.zzf(16);
            return;
        }
        synchronized (baseGmsClient.zzh()) {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) {
                iGmsServiceBroker = new zzaa(iBinder);
            } else {
                iGmsServiceBroker = (IGmsServiceBroker) queryLocalInterface;
            }
            baseGmsClient.zzi(iGmsServiceBroker);
        }
        this.zza.zzb(0, (Bundle) null, this.zzb);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        BaseGmsClient baseGmsClient = this.zza;
        synchronized (baseGmsClient.zzh()) {
            baseGmsClient.zzi((IGmsServiceBroker) null);
        }
        BaseGmsClient baseGmsClient2 = this.zza;
        int i = this.zzb;
        Handler handler = baseGmsClient2.zzb;
        handler.sendMessage(handler.obtainMessage(6, i, 1));
    }
}
