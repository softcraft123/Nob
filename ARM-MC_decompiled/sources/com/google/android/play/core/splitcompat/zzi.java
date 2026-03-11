package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipFile;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzi implements zzk {
    final /* synthetic */ Set zza;
    final /* synthetic */ zzt zzb;
    final /* synthetic */ zzn zzc;

    zzi(zzn zzn, Set set, zzt zzt) {
        this.zzc = zzn;
        this.zza = set;
        this.zzb = zzt;
    }

    public final void zza(ZipFile zipFile, Set set) throws IOException {
        this.zza.addAll(zzn.zza(this.zzc, set, this.zzb, zipFile));
    }
}
