package com.google.android.play.core.review.internal;

import android.os.IBinder;

/* compiled from: com.google.android.play:review@@2.0.2 */
final class zzp extends zzj {
    final /* synthetic */ IBinder zza;
    final /* synthetic */ zzr zzb;

    zzp(zzr zzr, IBinder iBinder) {
        this.zza = iBinder;
        this.zzb = zzr;
    }

    public final void zza() {
        this.zzb.zza.zzn = zze.zzb(this.zza);
        zzt.zzq(this.zzb.zza);
        this.zzb.zza.zzh = false;
        for (Runnable run : this.zzb.zza.zze) {
            run.run();
        }
        this.zzb.zza.zze.clear();
    }
}
