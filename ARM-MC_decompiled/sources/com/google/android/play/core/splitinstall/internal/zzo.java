package com.google.android.play.core.splitinstall.internal;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzo extends zzp {
    private final int zza;
    private final long zzb;

    zzo(int i, long j) {
        this.zza = i;
        this.zzb = j;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzp) {
            zzp zzp = (zzp) obj;
            return this.zza == zzp.zza() && this.zzb == zzp.zzb();
        }
    }

    public final int hashCode() {
        long j = this.zzb;
        return ((this.zza ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        int i = this.zza;
        long j = this.zzb;
        return "EventRecord{eventType=" + i + ", eventTimestamp=" + j + "}";
    }

    public final int zza() {
        return this.zza;
    }

    public final long zzb() {
        return this.zzb;
    }
}
