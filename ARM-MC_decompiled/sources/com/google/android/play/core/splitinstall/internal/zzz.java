package com.google.android.play.core.splitinstall.internal;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzz extends zzv {
    final /* synthetic */ zzaf zza;

    zzz(zzaf zzaf) {
        this.zza = zzaf;
    }

    public final void zzc() {
        synchronized (this.zza.zzg) {
            if (this.zza.zzl.get() > 0) {
                if (this.zza.zzl.decrementAndGet() > 0) {
                    this.zza.zzc.zzd("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
            }
            zzaf zzaf = this.zza;
            if (zzaf.zzn != null) {
                zzaf.zzc.zzd("Unbind from service.", new Object[0]);
                zzaf zzaf2 = this.zza;
                zzaf2.zzb.unbindService(zzaf2.zzm);
                this.zza.zzh = false;
                this.zza.zzn = null;
                this.zza.zzm = null;
            }
            this.zza.zzw();
        }
    }
}
