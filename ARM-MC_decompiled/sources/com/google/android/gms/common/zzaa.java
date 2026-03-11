package com.google.android.gms.common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzah;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
final class zzaa {
    private String zza = null;
    private long zzb = -1;
    private zzah zzc = zzah.zzj();
    private zzah zzd = zzah.zzj();

    zzaa() {
    }

    /* access modifiers changed from: package-private */
    public final zzaa zza(String str) {
        this.zza = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzaa zzb(long j) {
        this.zzb = j;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzaa zzc(List list) {
        Preconditions.checkNotNull(list);
        this.zzc = zzah.zzp(list);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzaa zzd(List list) {
        Preconditions.checkNotNull(list);
        this.zzd = zzah.zzp(list);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzab zze() {
        if (this.zza == null) {
            throw new IllegalStateException("packageName must be defined");
        } else if (this.zzb < 0) {
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        } else if (!this.zzc.isEmpty() || !this.zzd.isEmpty()) {
            return new zzab(this.zza, this.zzb, this.zzc, this.zzd, (byte[]) null);
        } else {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
    }
}
