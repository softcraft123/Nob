package com.google.android.gms.common;

import com.google.android.gms.common.signatureverification.zza;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public class PackageVerificationResult {
    private final String zza;
    private final boolean zzb;
    @Nullable
    private final String zzc;
    @Nullable
    private final Throwable zzd;

    private PackageVerificationResult(String str, int i, boolean z, @Nullable String str2, @Nullable Throwable th, @Nullable zza zza2) {
        this.zza = str;
        this.zzb = z;
        this.zzc = str2;
        this.zzd = th;
    }

    public static PackageVerificationResult zza(String str, String str2, @Nullable Throwable th, @Nullable zza zza2) {
        return new PackageVerificationResult(str, 1, false, str2, th, (zza) null);
    }

    public static PackageVerificationResult zzd(String str, int i, @Nullable zza zza2) {
        return new PackageVerificationResult(str, i, true, (String) null, (Throwable) null, (zza) null);
    }

    public final boolean zzb() {
        return this.zzb;
    }

    public final void zzc() {
        if (!this.zzb) {
            String str = this.zzc;
            String.valueOf(str);
            Throwable th = this.zzd;
            String concat = "PackageVerificationRslt: ".concat(String.valueOf(str));
            if (th != null) {
                throw new SecurityException(concat, th);
            }
            throw new SecurityException(concat);
        }
    }
}
