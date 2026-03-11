package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.splitinstall.internal.zzbr;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final class zzu {
    private static zzp zza;

    public static synchronized zzp zza(Context context) {
        zzp zzp;
        synchronized (zzu.class) {
            if (zza == null) {
                zzc zzc = new zzc((zzb) null);
                zzc.zza(new zzac(zzbr.zza(context)));
                zza = zzc.zzb();
            }
            zzp = zza;
        }
        return zzp;
    }
}
