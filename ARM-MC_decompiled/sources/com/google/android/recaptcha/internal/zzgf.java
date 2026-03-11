package com.google.android.recaptcha.internal;

import java.util.HashMap;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzgf {
    private final zzge zza;
    private final HashMap zzb;
    private final zzfw zzc;
    private final zzcg zzd;

    public zzgf(zzfw zzfw, zzcg zzcg, zzbo zzbo) {
        this.zzc = zzfw;
        this.zzd = zzcg;
        zzge zzge = new zzge();
        this.zza = zzge;
        HashMap hashMap = new HashMap();
        this.zzb = hashMap;
        zzge.zzd(173, hashMap);
    }

    public final zzge zza() {
        return this.zza;
    }

    public final void zzb() {
        this.zza.zzc();
        this.zza.zzd(173, this.zzb);
    }

    public final zzcg zzc() {
        return this.zzd;
    }

    public final zzfw zzd() {
        return this.zzc;
    }

    public final void zze(int i, Object obj) {
        this.zzb.put(Integer.valueOf(i - 2), obj);
    }
}
