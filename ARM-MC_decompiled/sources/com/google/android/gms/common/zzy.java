package com.google.android.gms.common;

import android.util.Log;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public class zzy {
    private static final zzy zze = new zzy(true, 3, 1, (String) null, (Throwable) null, -1);
    final boolean zza;
    @Nullable
    final String zzb;
    @Nullable
    final Throwable zzc;
    final int zzd;

    private zzy(boolean z, int i, int i2, @Nullable String str, @Nullable Throwable th, long j) {
        this.zza = z;
        this.zzd = i;
        this.zzb = str;
        this.zzc = th;
    }

    /* synthetic */ zzy(boolean z, int i, int i2, String str, Throwable th, long j, byte[] bArr) {
        this(false, 1, 5, (String) null, (Throwable) null, -1);
    }

    @Deprecated
    static zzy zzb() {
        return zze;
    }

    static zzy zzc(String str) {
        return new zzy(false, 1, 5, str, (Throwable) null, -1);
    }

    static zzy zzd(String str, Throwable th) {
        return new zzy(false, 1, 5, str, th, -1);
    }

    public static zzy zzf(int i, long j) {
        return new zzy(true, i, 1, (String) null, (Throwable) null, j);
    }

    static zzy zzg(int i, int i2, String str, @Nullable Throwable th) {
        return new zzy(false, i, i2, str, th, -1);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String zza() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final void zze() {
        if (!this.zza && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            Throwable th = this.zzc;
            if (th != null) {
                Log.d("GoogleCertificatesRslt", zza(), th);
            } else {
                Log.d("GoogleCertificatesRslt", zza());
            }
        }
    }
}
