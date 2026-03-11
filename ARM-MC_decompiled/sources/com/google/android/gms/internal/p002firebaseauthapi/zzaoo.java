package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaoo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@24.0.1 */
public final class zzaoo {
    private static final ThreadLocal<SimpleDateFormat> zza = new zzaon();

    private static boolean zza(long j) {
        return j >= -62135596800L && j <= 253402300799L;
    }

    private static long zzb(String str) throws ParseException {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            try {
                return ((Long.parseLong(str.substring(0, indexOf)) * 60) + Long.parseLong(str.substring(indexOf + 1))) * 60;
            } catch (NumberFormatException e) {
                ParseException parseException = new ParseException("Invalid offset value: " + str, 0);
                parseException.initCause(e);
                throw parseException;
            }
        } else {
            throw new ParseException("Invalid offset value: " + str, 0);
        }
    }

    public static long zza(zzans zzans) {
        return zzb(zzans).zzb();
    }

    private static zzans zzb(zzans zzans) {
        long zzb = zzans.zzb();
        int zza2 = zzans.zza();
        if (zza(zzb) && zza2 >= 0 && zza2 < 1000000000) {
            return zzans;
        }
        throw new IllegalArgumentException(zzac.zza("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", Long.valueOf(zzb), Integer.valueOf(zza2)));
    }

    public static zzans zza(String str) throws ParseException {
        String str2;
        int i;
        int indexOf = str.indexOf(84);
        if (indexOf != -1) {
            int indexOf2 = str.indexOf(90, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = str.indexOf(43, indexOf);
            }
            if (indexOf2 == -1) {
                indexOf2 = str.indexOf(45, indexOf);
            }
            if (indexOf2 != -1) {
                String substring = str.substring(0, indexOf2);
                int indexOf3 = substring.indexOf(46);
                boolean z = true;
                if (indexOf3 != -1) {
                    String substring2 = substring.substring(0, indexOf3);
                    str2 = substring.substring(indexOf3 + 1);
                    substring = substring2;
                } else {
                    str2 = "";
                }
                long time = zza.get().parse(substring).getTime() / 1000;
                if (str2.isEmpty()) {
                    i = 0;
                } else {
                    i = 0;
                    for (int i2 = 0; i2 < 9; i2++) {
                        i *= 10;
                        if (i2 < str2.length()) {
                            if (str2.charAt(i2) < '0' || str2.charAt(i2) > '9') {
                                throw new ParseException("Invalid nanoseconds.", 0);
                            }
                            i += str2.charAt(i2) - '0';
                        }
                    }
                }
                if (str.charAt(indexOf2) != 'Z') {
                    long zzb = zzb(str.substring(indexOf2 + 1));
                    time = str.charAt(indexOf2) == '+' ? time - zzb : time + zzb;
                } else if (str.length() != indexOf2 + 1) {
                    throw new ParseException("Failed to parse timestamp: invalid trailing data \"" + str.substring(indexOf2) + "\"", 0);
                }
                try {
                    if (zza(time)) {
                        if (i <= -1000000000 || i >= 1000000000) {
                            long j = (long) (i / 1000000000);
                            long j2 = time + j;
                            if (((j ^ time) < 0) || ((time ^ j2) >= 0)) {
                                i %= 1000000000;
                                time = j2;
                            } else {
                                throw new ArithmeticException();
                            }
                        }
                        if (i < 0) {
                            i += 1000000000;
                            long j3 = time - 1;
                            boolean z2 = (1 ^ time) >= 0;
                            if ((time ^ j3) < 0) {
                                z = false;
                            }
                            if (z2 || z) {
                                time = j3;
                            } else {
                                throw new ArithmeticException();
                            }
                        }
                        return zzb((zzans) ((zzalf) zzans.zzc().zza(time).zza(i).zze()));
                    }
                    throw new IllegalArgumentException(zzac.zza("Timestamp is not valid. Input seconds is too large. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. ", Long.valueOf(time)));
                } catch (IllegalArgumentException e) {
                    ParseException parseException = new ParseException("Failed to parse timestamp " + str + " Timestamp is out of range.", 0);
                    parseException.initCause(e);
                    throw parseException;
                }
            } else {
                throw new ParseException("Failed to parse timestamp: missing valid timezone offset.", 0);
            }
        } else {
            throw new ParseException("Failed to parse timestamp: invalid timestamp \"" + str + "\"", 0);
        }
    }

    @Nullable
    private static Method zzc(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static /* synthetic */ SimpleDateFormat zza() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        simpleDateFormat.setCalendar(gregorianCalendar);
        return simpleDateFormat;
    }

    static {
        zzans zzans = (zzans) ((zzalf) zzans.zzc().zza(-62135596800L).zza(0).zze());
        zzans zzans2 = (zzans) ((zzalf) zzans.zzc().zza(253402300799L).zza(999999999).zze());
        zzans zzans3 = (zzans) ((zzalf) zzans.zzc().zza(0).zza(0).zze());
        zzc("now");
        zzc("getEpochSecond");
        zzc("getNano");
    }
}
