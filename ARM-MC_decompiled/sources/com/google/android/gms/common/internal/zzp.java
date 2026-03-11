package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
final class zzp implements Handler.Callback {
    final /* synthetic */ zzq zza;

    /* synthetic */ zzp(zzq zzq, byte[] bArr) {
        Objects.requireNonNull(zzq);
        this.zza = zzq;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            zzq zzq = this.zza;
            synchronized (zzq.zzf()) {
                zzn zzn = (zzn) message.obj;
                zzo zzo = (zzo) zzq.zzf().get(zzn);
                if (zzo != null && zzo.zzg()) {
                    if (zzo.zzd()) {
                        zzo.zza("GmsClientSupervisor");
                    }
                    zzq.zzf().remove(zzn);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            zzq zzq2 = this.zza;
            synchronized (zzq2.zzf()) {
                zzn zzn2 = (zzn) message.obj;
                zzo zzo2 = (zzo) zzq2.zzf().get(zzn2);
                if (zzo2 != null && zzo2.zze() == 3) {
                    String valueOf = String.valueOf(zzn2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName zzi = zzo2.zzi();
                    if (zzi == null) {
                        zzi = zzn2.zzc();
                    }
                    if (zzi == null) {
                        String zzb = zzn2.zzb();
                        Preconditions.checkNotNull(zzb);
                        String str = zzb;
                        zzi = new ComponentName(zzb, EnvironmentCompat.MEDIA_UNKNOWN);
                    }
                    zzo2.onServiceDisconnected(zzi);
                }
            }
            return true;
        }
    }
}
