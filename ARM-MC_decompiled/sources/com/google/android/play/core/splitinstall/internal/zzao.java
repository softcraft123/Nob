package com.google.android.play.core.splitinstall.internal;

import android.os.Build;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final class zzao {
    public static zzan zza() {
        int i = Build.VERSION.SDK_INT;
        if (i != 26) {
            return (i == 27 && Build.VERSION.PREVIEW_SDK_INT == 0) ? new zzbe() : new zzbg();
        }
        return new zzbd();
    }
}
