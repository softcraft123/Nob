package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
final /* synthetic */ class zzl implements Callable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzj zzc;

    /* synthetic */ zzl(boolean z, String str, zzj zzj) {
        this.zza = z;
        this.zzb = str;
        this.zzc = zzj;
    }

    public final /* synthetic */ Object call() {
        return zzo.zze(this.zza, this.zzb, this.zzc);
    }
}
