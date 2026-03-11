package com.google.android.play.core.splitcompat;

import java.io.File;
import java.io.IOException;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzg implements zzl {
    final /* synthetic */ zzh zza;

    zzg(zzh zzh) {
        this.zza = zzh;
    }

    public final void zza(zzm zzm, File file, boolean z) throws IOException {
        this.zza.zzb.add(file);
        if (!z) {
            this.zza.zzc.set(false);
        }
    }
}
