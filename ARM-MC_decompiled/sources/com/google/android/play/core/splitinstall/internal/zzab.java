package com.google.android.play.core.splitinstall.internal;

import android.os.IBinder;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzab extends zzv {
    final /* synthetic */ IBinder zza;
    final /* synthetic */ zzae zzb;

    zzab(zzae zzae, IBinder iBinder) {
        this.zzb = zzae;
        this.zza = iBinder;
    }

    public final void zzc() {
        this.zzb.zza.zzn = zzbn.zzb(this.zza);
        zzaf.zzq(this.zzb.zza);
        this.zzb.zza.zzh = false;
        for (Runnable run : this.zzb.zza.zze) {
            run.run();
        }
        this.zzb.zza.zze.clear();
    }
}
