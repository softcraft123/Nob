package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
final class zzcd implements BackgroundDetector.BackgroundStateChangeListener {
    private final /* synthetic */ zzca zza;

    zzcd(zzca zzca) {
        Objects.requireNonNull(zzca);
        this.zza = zzca;
    }

    public final void onBackgroundStateChanged(boolean z) {
        if (z) {
            this.zza.zzc = true;
            this.zza.zza();
            return;
        }
        this.zza.zzc = false;
        if (this.zza.zzb()) {
            this.zza.zzb.zzc();
        }
    }
}
