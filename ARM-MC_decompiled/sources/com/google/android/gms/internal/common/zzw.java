package com.google.android.gms.internal.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public final class zzw {
    private final zzp zza;
    private final boolean zzb;
    private final zzu zzc;

    private zzw(zzu zzu, boolean z, zzp zzp, int i) {
        this.zzc = zzu;
        this.zzb = z;
        this.zza = zzp;
    }

    public static zzw zza(zzp zzp) {
        return new zzw(new zzu(zzp), false, zzo.zza, Integer.MAX_VALUE);
    }

    public final zzw zzb() {
        return new zzw(this.zzc, true, this.zza, Integer.MAX_VALUE);
    }

    public final Iterable zzc(CharSequence charSequence) {
        return new zzt(this, charSequence);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Iterator zze(CharSequence charSequence) {
        return this.zzc.zza(this, charSequence);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzp zzf() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzg() {
        return this.zzb;
    }

    public final List zzd(CharSequence charSequence) {
        charSequence.getClass();
        Iterator zza2 = this.zzc.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zza2.hasNext()) {
            arrayList.add((String) zza2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
