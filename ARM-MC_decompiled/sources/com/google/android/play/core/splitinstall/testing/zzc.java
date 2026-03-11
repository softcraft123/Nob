package com.google.android.play.core.splitinstall.testing;

import java.util.Map;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzc extends zzv {
    private final Integer zzb;
    private final Map zzc;

    /* synthetic */ zzc(Integer num, Map map, zzb zzb2) {
        this.zzb = num;
        this.zzc = map;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzv) {
            zzv zzv = (zzv) obj;
            Integer num = this.zzb;
            if (num != null ? num.equals(zzv.zza()) : zzv.zza() == null) {
                if (this.zzc.equals(zzv.zzb())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        Integer num = this.zzb;
        String valueOf = String.valueOf(this.zzc);
        return "LocalTestingConfig{defaultSplitInstallErrorCode=" + num + ", splitInstallErrorCodeByModule=" + valueOf + "}";
    }

    public final Integer zza() {
        return this.zzb;
    }

    public final Map zzb() {
        return this.zzc;
    }

    public final int hashCode() {
        int i;
        Integer num = this.zzb;
        if (num == null) {
            i = 0;
        } else {
            i = num.hashCode();
        }
        return ((i ^ 1000003) * 1000003) ^ this.zzc.hashCode();
    }
}
