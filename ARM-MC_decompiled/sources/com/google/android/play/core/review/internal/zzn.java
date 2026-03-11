package com.google.android.play.core.review.internal;

/* compiled from: com.google.android.play:review@@2.0.2 */
final class zzn extends zzj {
    final /* synthetic */ zzt zza;

    zzn(zzt zzt) {
        this.zza = zzt;
    }

    public final void zza() {
        synchronized (this.zza.zzg) {
            if (this.zza.zzl.get() <= 0 || this.zza.zzl.decrementAndGet() <= 0) {
                zzt zzt = this.zza;
                if (zzt.zzn != null) {
                    zzt.zzc.zzc("Unbind from service.", new Object[0]);
                    zzt zzt2 = this.zza;
                    zzt2.zzb.unbindService(zzt2.zzm);
                    this.zza.zzh = false;
                    this.zza.zzn = null;
                    this.zza.zzm = null;
                }
                this.zza.zzw();
                return;
            }
            this.zza.zzc.zzc("Leaving the connection open for other ongoing calls.", new Object[0]);
        }
    }
}
