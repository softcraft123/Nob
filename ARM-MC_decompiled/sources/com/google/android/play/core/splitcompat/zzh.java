package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzh implements zzk {
    final /* synthetic */ zzt zza;
    final /* synthetic */ Set zzb;
    final /* synthetic */ AtomicBoolean zzc;
    final /* synthetic */ zzn zzd;

    zzh(zzn zzn, zzt zzt, Set set, AtomicBoolean atomicBoolean) {
        this.zzd = zzn;
        this.zza = zzt;
        this.zzb = set;
        this.zzc = atomicBoolean;
    }

    public final void zza(ZipFile zipFile, Set set) throws IOException {
        this.zzd.zzf(this.zza, set, new zzg(this));
    }
}
