package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
public final class zzpz {
    static {
        zzmj zzi = zzml.zzi();
        zzi.zzf(-315576000000L);
        zzi.zze(-999999999);
        zzml zzml = (zzml) zzi.zzk();
        zzmj zzi2 = zzml.zzi();
        zzi2.zzf(315576000000L);
        zzi2.zze(999999999);
        zzml zzml2 = (zzml) zzi2.zzk();
        zzmj zzi3 = zzml.zzi();
        zzi3.zzf(0);
        zzi3.zze(0);
        zzml zzml3 = (zzml) zzi3.zzk();
    }

    public static zzml zza(long j) {
        int i;
        int i2 = (int) (j % 1000000000);
        long j2 = j / 1000000000;
        if (i2 <= -1000000000 || i2 >= 1000000000) {
            j2 = zzkk.zza(j2, (long) (i2 / 1000000000));
            i2 %= 1000000000;
        }
        if (j2 > 0 && i2 < 0) {
            i2 += 1000000000;
            j2--;
        }
        if (j2 < 0 && i2 > 0) {
            i2 -= 1000000000;
            j2++;
        }
        zzmj zzi = zzml.zzi();
        zzi.zzf(j2);
        zzi.zze(i2);
        zzml zzml = (zzml) zzi.zzk();
        long zzg = zzml.zzg();
        int zzf = zzml.zzf();
        if (zzg >= -315576000000L && zzg <= 315576000000L && ((long) zzf) >= -999999999 && zzf < 1000000000 && ((zzg >= 0 && zzf >= 0) || (i <= 0 && zzf <= 0))) {
            return zzml;
        }
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", new Object[]{Long.valueOf(zzg), Integer.valueOf(zzf)}));
    }
}
