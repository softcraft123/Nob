package com.google.android.gms.internal.fido;

import java.util.AbstractMap;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzch extends zzcc {
    final /* synthetic */ zzci zza;

    zzch(zzci zzci) {
        this.zza = zzci;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return new AbstractMap.SimpleImmutableEntry(this.zza.zza.zzd.zzd.get(i), this.zza.zza.zze.get(i));
    }

    public final int size() {
        return this.zza.zza.size();
    }
}
