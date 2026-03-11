package com.google.android.gms.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
final class zzv {
    private String zza = null;
    private Boolean zzb = null;
    private Boolean zzc = null;

    private zzv() {
    }

    /* synthetic */ zzv(byte[] bArr) {
    }

    /* access modifiers changed from: package-private */
    public final zzv zza(String str) {
        this.zza = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzv zzb(boolean z) {
        this.zzb = Boolean.valueOf(z);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzv zzc(boolean z) {
        this.zzc = Boolean.valueOf(z);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzw zzd() {
        Boolean bool = this.zzb;
        if (bool == null) {
            throw new IllegalStateException("allowTestKeys must be set");
        } else if (this.zzc != null) {
            return new zzw(this.zza, bool.booleanValue(), false, false, this.zzc.booleanValue(), false, (byte[]) null);
        } else {
            throw new IllegalStateException("isGoogleOrPlatformOnly must be set");
        }
    }
}
