package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.review.internal.zzj;
import java.util.Map;

/* compiled from: com.google.android.play:review@@2.0.2 */
final class zzf extends zzj {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzi zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzf(zzi zzi, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zza = taskCompletionSource2;
        this.zzb = zzi;
    }

    /* access modifiers changed from: protected */
    public final void zza() {
        try {
            com.google.android.play.core.review.internal.zzf zzf = (com.google.android.play.core.review.internal.zzf) this.zzb.zza.zze();
            String zzc = this.zzb.zzc;
            Bundle bundle = new Bundle();
            Map zza2 = zzj.zza();
            bundle.putInt("playcore_version_code", ((Integer) zza2.get("java")).intValue());
            if (zza2.containsKey("native")) {
                bundle.putInt("playcore_native_version", ((Integer) zza2.get("native")).intValue());
            }
            if (zza2.containsKey("unity")) {
                bundle.putInt("playcore_unity_version", ((Integer) zza2.get("unity")).intValue());
            }
            zzi zzi = this.zzb;
            zzf.zzc(zzc, bundle, new zzh(zzi, this.zza, zzi.zzc));
        } catch (RemoteException e) {
            zzi.zzb.zzb(e, "error requesting in-app review for %s", this.zzb.zzc);
            this.zza.trySetException(new RuntimeException(e));
        }
    }
}
