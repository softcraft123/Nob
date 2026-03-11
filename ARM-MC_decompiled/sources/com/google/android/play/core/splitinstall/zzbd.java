package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.splitinstall.internal.zzcb;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final class zzbd implements zzcb {
    private final zzcb zza;

    public zzbd(zzcb zzcb) {
        this.zza = zzcb;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        Context zzb = ((zzad) this.zza).zzb();
        return new zzbc(zzb, zzb.getPackageName());
    }
}
