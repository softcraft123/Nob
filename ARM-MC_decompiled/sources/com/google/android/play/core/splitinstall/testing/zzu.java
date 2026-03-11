package com.google.android.play.core.splitinstall.testing;

import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
abstract class zzu {
    zzu() {
    }

    /* access modifiers changed from: package-private */
    public abstract zzu zza(int i);

    /* access modifiers changed from: package-private */
    public abstract zzu zzb(Map map);

    /* access modifiers changed from: package-private */
    public abstract zzv zzc();

    /* access modifiers changed from: package-private */
    public abstract Map zzd();

    /* access modifiers changed from: package-private */
    public final zzv zze() {
        zzb(Collections.unmodifiableMap(zzd()));
        return zzc();
    }
}
