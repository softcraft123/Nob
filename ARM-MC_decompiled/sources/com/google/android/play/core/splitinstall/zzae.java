package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.internal.zzcb;
import com.google.android.play.core.splitinstall.testing.zzaa;
import java.io.File;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final class zzae implements zzcb {
    private final zzcb zza;

    public zzae(zzcb zzcb) {
        this.zza = zzcb;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        File file = (File) this.zza.zza();
        if (file == null) {
            return null;
        }
        return zzaa.zza(file);
    }
}
