package com.google.android.gms.internal.fido;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
public abstract class zzeg {
    private static String zza = "com.google.android.gms.internal.fido.zzel";
    private static String zzb = "com.google.common.flogger.backend.google.GooglePlatform";
    private static String zzc = "com.google.common.flogger.backend.system.DefaultPlatform";
    /* access modifiers changed from: private */
    public static final String[] zzd = {"com.google.android.gms.internal.fido.zzel", "com.google.common.flogger.backend.google.GooglePlatform", "com.google.common.flogger.backend.system.DefaultPlatform"};

    public static int zza() {
        return zzfm.zza();
    }

    public static long zzb() {
        return zzee.zza.zzc();
    }

    public static zzdp zzd(String str) {
        return zzee.zza.zze(str);
    }

    public static zzdr zzf() {
        return zzi().zza();
    }

    public static zzef zzg() {
        return zzee.zza.zzh();
    }

    public static zzev zzi() {
        return zzee.zza.zzj();
    }

    public static zzfi zzk() {
        return zzi().zzc();
    }

    public static String zzl() {
        return zzee.zza.zzm();
    }

    public static boolean zzn(String str, Level level, boolean z) {
        zzi().zzd(str, level, z);
        return false;
    }

    /* access modifiers changed from: protected */
    public long zzc() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    /* access modifiers changed from: protected */
    public abstract zzdp zze(String str);

    /* access modifiers changed from: protected */
    public abstract zzef zzh();

    /* access modifiers changed from: protected */
    public zzev zzj() {
        return zzev.zze();
    }

    /* access modifiers changed from: protected */
    public abstract String zzm();
}
