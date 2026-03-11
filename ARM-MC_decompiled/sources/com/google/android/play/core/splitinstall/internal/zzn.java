package com.google.android.play.core.splitinstall.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
public final class zzn {
    private final List zza = new ArrayList();

    public final List zza() {
        ArrayList arrayList = new ArrayList();
        for (zzp zzp : this.zza) {
            Bundle bundle = new Bundle();
            bundle.putInt("event_type", zzp.zza());
            bundle.putLong("event_timestamp", zzp.zzb());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public final void zzb(int i) {
        this.zza.add(zzp.zzc(i, System.currentTimeMillis()));
    }
}
