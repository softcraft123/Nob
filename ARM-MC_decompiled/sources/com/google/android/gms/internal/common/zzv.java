package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
abstract class zzv extends zzk {
    final CharSequence zzb;
    final zzp zzc;
    final boolean zzd;
    int zze = 0;
    int zzf;

    zzv(zzw zzw, CharSequence charSequence) {
        this.zzc = zzw.zzf();
        this.zzd = zzw.zzg();
        this.zzf = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        int zzc2;
        int i;
        int i2 = this.zze;
        while (true) {
            int i3 = this.zze;
            if (i3 != -1) {
                zzc2 = zzc(i3);
                if (zzc2 == -1) {
                    zzc2 = this.zzb.length();
                    this.zze = -1;
                    i = -1;
                } else {
                    i = zzd(zzc2);
                    this.zze = i;
                }
                if (i == i2) {
                    int i4 = i + 1;
                    this.zze = i4;
                    if (i4 > this.zzb.length()) {
                        this.zze = -1;
                    }
                } else {
                    if (i2 < zzc2) {
                        this.zzb.charAt(i2);
                    }
                    if (i2 < zzc2) {
                        this.zzb.charAt(zzc2 - 1);
                    }
                    if (!this.zzd || i2 != zzc2) {
                        int i5 = this.zzf;
                    } else {
                        i2 = this.zze;
                    }
                }
            } else {
                zzb();
                String str = null;
                return null;
            }
        }
        int i52 = this.zzf;
        if (i52 == 1) {
            CharSequence charSequence = this.zzb;
            int length = charSequence.length();
            this.zze = -1;
            if (length > i2) {
                charSequence.charAt(length - 1);
            }
            zzc2 = length;
        } else {
            this.zzf = i52 - 1;
        }
        return this.zzb.subSequence(i2, zzc2).toString();
    }

    /* access modifiers changed from: package-private */
    public abstract int zzc(int i);

    /* access modifiers changed from: package-private */
    public abstract int zzd(int i);
}
