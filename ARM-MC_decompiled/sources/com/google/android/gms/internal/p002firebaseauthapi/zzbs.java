package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzbs implements zzoa {
    /* access modifiers changed from: private */
    public static final zzbu zza = new zzbr();
    /* access modifiers changed from: private */
    public final zzbi zzb;
    /* access modifiers changed from: private */
    public final zzxc zzc;
    private final zzbk zzd;
    /* access modifiers changed from: private */
    public final int zze;
    /* access modifiers changed from: private */
    public final boolean zzf;
    /* access modifiers changed from: private */
    public final boolean zzg;
    private final zzbu zzh;

    static /* synthetic */ void zzd(zzbs zzbs) {
    }

    public final int zza() {
        return this.zze;
    }

    public final zzbi zzb() {
        this.zzh.zza(this);
        return this.zzb;
    }

    public final zzbk zzc() {
        return this.zzd;
    }

    private zzbs(zzbi zzbi, zzxc zzxc, int i, boolean z, boolean z2, zzbu zzbu) {
        zzbk zzbk;
        this.zzb = zzbi;
        this.zzc = zzxc;
        int i2 = zzbo.zza[zzxc.ordinal()];
        if (i2 == 1) {
            zzbk = zzbk.zza;
        } else if (i2 != 2) {
            zzbk = zzbk.zzb;
        } else {
            zzbk = zzbk.zzc;
        }
        this.zzd = zzbk;
        this.zze = i;
        this.zzf = z;
        this.zzg = z2;
        this.zzh = zzbu;
    }

    public final boolean zze() {
        return this.zzf;
    }
}
