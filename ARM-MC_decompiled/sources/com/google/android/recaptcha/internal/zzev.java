package com.google.android.recaptcha.internal;

import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzev {
    public static final zzrl zza(zzbn zzbn, zzbn zzbn2) {
        zzrj zzf = zzrl.zzf();
        zzf.zzq(zzqb.zzb(zzbn.zzb()));
        zzf.zzr(zzpz.zza(zzbn.zza(TimeUnit.NANOSECONDS)));
        zzf.zze(zzqb.zzb(zzbn2.zzb()));
        zzf.zzf(zzpz.zza(zzbn2.zza(TimeUnit.NANOSECONDS)));
        return (zzrl) zzf.zzk();
    }
}
