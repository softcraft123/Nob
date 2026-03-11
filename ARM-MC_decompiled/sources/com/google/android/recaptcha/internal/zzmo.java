package com.google.android.recaptcha.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzmo {
    static final zzmo zza = new zzmo(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    zzmo() {
        this.zzd = new HashMap();
    }

    public final zznc zza(zzoi zzoi, int i) {
        return (zznc) this.zzd.get(new zzmn(zzoi, i));
    }

    zzmo(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
