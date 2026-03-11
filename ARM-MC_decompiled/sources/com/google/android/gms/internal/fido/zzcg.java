package com.google.android.gms.internal.fido;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final /* synthetic */ class zzcg implements Comparator {
    public final /* synthetic */ Comparator zza;

    public /* synthetic */ zzcg(Comparator comparator) {
        this.zza = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        Map.Entry entry = (Map.Entry) obj;
        Map.Entry entry2 = (Map.Entry) obj2;
        Objects.requireNonNull(entry);
        Objects.requireNonNull(entry2);
        return this.zza.compare(entry.getKey(), entry2.getKey());
    }
}
