package com.google.android.gms.internal.fido;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public final class zzdv {
    private static final zzdz zza = new zzds();
    private static final zzdy zzb = new zzdt();
    /* access modifiers changed from: private */
    public final Map zzc = new HashMap();
    /* access modifiers changed from: private */
    public final Map zzd = new HashMap();
    /* access modifiers changed from: private */
    public final zzdz zze;
    /* access modifiers changed from: private */
    public zzdy zzf = null;

    /* synthetic */ zzdv(zzdz zzdz, zzdu zzdu) {
        this.zze = zzdz;
    }

    public final zzdv zza(zzdy zzdy) {
        this.zzf = zzdy;
        return this;
    }

    public final zzea zzd() {
        return new zzdx(this, (zzdw) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzg(zzdk zzdk) {
        zzfk.zza(zzdk, "key");
        if (zzdk.zzb()) {
            zzdy zzdy = zzb;
            zzfk.zza(zzdk, "key");
            if (zzdk.zzb()) {
                this.zzc.remove(zzdk);
                this.zzd.put(zzdk, zzdy);
                return;
            }
            throw new IllegalArgumentException("key must be repeating");
        }
        zzdz zzdz = zza;
        zzfk.zza(zzdk, "key");
        this.zzd.remove(zzdk);
        this.zzc.put(zzdk, zzdz);
    }
}
