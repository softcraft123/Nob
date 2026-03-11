package com.google.android.play.core.splitinstall.internal;

import android.util.Log;
import com.google.android.play.core.splitinstall.zzf;
import java.util.List;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzaj implements Runnable {
    final /* synthetic */ List zza;
    final /* synthetic */ zzf zzb;
    final /* synthetic */ zzak zzc;

    zzaj(zzak zzak, List list, zzf zzf) {
        this.zzc = zzak;
        this.zza = list;
        this.zzb = zzf;
    }

    public final void run() {
        try {
            if (this.zzc.zzc.zzb(this.zza)) {
                zzak.zzc(this.zzc, this.zzb);
            } else {
                zzak.zzb(this.zzc, this.zza, this.zzb);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Error checking verified files.", e);
            this.zzb.zzb(-11);
        }
    }
}
