package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
final class zzb implements Runnable {
    final /* synthetic */ LifecycleCallback zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzc zzc;

    zzb(zzc zzc2, LifecycleCallback lifecycleCallback, String str) {
        this.zza = lifecycleCallback;
        this.zzb = str;
        Objects.requireNonNull(zzc2);
        this.zzc = zzc2;
    }

    public final void run() {
        Bundle bundle;
        zzc zzc2 = this.zzc;
        if (zzc2.zzm() > 0) {
            LifecycleCallback lifecycleCallback = this.zza;
            if (zzc2.zzn() != null) {
                bundle = zzc2.zzn().getBundle(this.zzb);
            } else {
                bundle = null;
            }
            lifecycleCallback.onCreate(bundle);
        }
        if (zzc2.zzm() >= 2) {
            this.zza.onStart();
        }
        if (zzc2.zzm() >= 3) {
            this.zza.onResume();
        }
        if (zzc2.zzm() >= 4) {
            this.zza.onStop();
        }
        if (zzc2.zzm() >= 5) {
            this.zza.onDestroy();
        }
    }
}
