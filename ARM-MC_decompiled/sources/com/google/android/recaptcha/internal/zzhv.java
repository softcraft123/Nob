package com.google.android.recaptcha.internal;

import java.math.BigInteger;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzhv {
    /* access modifiers changed from: private */
    public static final zzhu zza = new zzhu(11, 20919936621L ^ ((long) Math.pow(2.0d, 32.0d)), (long) Math.pow(2.0d, 48.0d));
    private final zzhu zzb;
    private long zzc;

    public zzhv(long j, long j2, zzhu zzhu) {
        this.zzb = zzhu;
        this.zzc = Math.abs(j);
    }

    public final long zza() {
        zzhu zzhu = this.zzb;
        long longValue = (BigInteger.valueOf(zzhu.zzb()).multiply(BigInteger.valueOf(this.zzc)).mod(BigInteger.valueOf(zzhu.zza())).longValue() + 11) % this.zzb.zza();
        this.zzc = longValue;
        return longValue % 255;
    }
}
