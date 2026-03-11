package com.google.android.play.core.splitcompat;

import java.io.File;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
final class zzb extends zzt {
    private final File zza;
    private final String zzb;

    zzb(File file, String str) {
        if (file != null) {
            this.zza = file;
            if (str != null) {
                this.zzb = str;
                return;
            }
            throw new NullPointerException("Null splitId");
        }
        throw new NullPointerException("Null splitFile");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzt) {
            zzt zzt = (zzt) obj;
            return this.zza.equals(zzt.zza()) && this.zzb.equals(zzt.zzb());
        }
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    public final String toString() {
        String obj = this.zza.toString();
        String str = this.zzb;
        return "SplitFileInfo{splitFile=" + obj + ", splitId=" + str + "}";
    }

    /* access modifiers changed from: package-private */
    public final File zza() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzb;
    }
}
