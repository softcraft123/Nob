package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
final class zznb implements zzms {
    final int zza;
    final zzpw zzb;

    zznb(zzng zzng, int i, zzpw zzpw, boolean z, boolean z2) {
        this.zza = i;
        this.zzb = zzpw;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return this.zza - ((zznb) obj).zza;
    }

    public final int zza() {
        return this.zza;
    }

    public final zzoh zzb(zzoh zzoh, zzoi zzoi) {
        zzmx zzmx = (zzmx) zzoh;
        zzmx.zzh((zznd) zzoi);
        return zzmx;
    }

    public final zzon zzc(zzon zzon, zzon zzon2) {
        throw new UnsupportedOperationException();
    }

    public final zzpw zzd() {
        return this.zzb;
    }

    public final zzpx zze() {
        return this.zzb.zza();
    }

    public final boolean zzf() {
        return false;
    }

    public final boolean zzg() {
        return false;
    }
}
