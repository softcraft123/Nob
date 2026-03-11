package com.google.android.recaptcha.internal;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzjh {
    private boolean zza;
    private long zzb;
    private long zzc;

    zzjh() {
    }

    public static zzjh zzb() {
        zzjh zzjh = new zzjh();
        zzjh.zze();
        return zzjh;
    }

    public static zzjh zzc() {
        return new zzjh();
    }

    private final long zzg() {
        return this.zza ? (System.nanoTime() - this.zzc) + this.zzb : this.zzb;
    }

    public final String toString() {
        TimeUnit timeUnit;
        String str;
        long zzg = zzg();
        if (TimeUnit.DAYS.convert(zzg, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.DAYS;
        } else if (TimeUnit.HOURS.convert(zzg, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.HOURS;
        } else if (TimeUnit.MINUTES.convert(zzg, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MINUTES;
        } else if (TimeUnit.SECONDS.convert(zzg, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.SECONDS;
        } else if (TimeUnit.MILLISECONDS.convert(zzg, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        } else if (TimeUnit.MICROSECONDS.convert(zzg, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MICROSECONDS;
        } else {
            timeUnit = TimeUnit.NANOSECONDS;
        }
        String format = String.format(Locale.ROOT, "%.4g", new Object[]{Double.valueOf(((double) zzg) / ((double) TimeUnit.NANOSECONDS.convert(1, timeUnit)))});
        switch (zzjg.zza[timeUnit.ordinal()]) {
            case 1:
                str = "ns";
                break;
            case 2:
                str = "μs";
                break;
            case 3:
                str = "ms";
                break;
            case 4:
                str = "s";
                break;
            case 5:
                str = "min";
                break;
            case 6:
                str = "h";
                break;
            case 7:
                str = "d";
                break;
            default:
                throw new AssertionError();
        }
        return format + " " + str;
    }

    public final long zza(TimeUnit timeUnit) {
        return timeUnit.convert(zzg(), TimeUnit.NANOSECONDS);
    }

    public final zzjh zzd() {
        this.zzb = 0;
        this.zza = false;
        return this;
    }

    public final zzjh zze() {
        zzjf.zze(!this.zza, "This stopwatch is already running.");
        this.zza = true;
        this.zzc = System.nanoTime();
        return this;
    }

    public final zzjh zzf() {
        long nanoTime = System.nanoTime();
        zzjf.zze(this.zza, "This stopwatch is already stopped.");
        this.zza = false;
        this.zzb += nanoTime - this.zzc;
        return this;
    }
}
