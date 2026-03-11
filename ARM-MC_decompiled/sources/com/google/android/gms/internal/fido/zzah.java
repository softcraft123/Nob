package com.google.android.gms.internal.fido;

/* compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
final class zzah {
    private static final Object zza = new Object();
    private static volatile boolean zzb = false;
    private static volatile zzag zzc = null;
    private static volatile boolean zzd = false;
    private static volatile zzag zze;

    static void zza() {
        zzd = true;
    }

    static void zzb() {
        if (zze == null) {
            zze = new zzag((zzaf) null);
        }
    }

    static void zzc() {
        if (zzc == null) {
            zzc = new zzag((zzaf) null);
        }
    }

    static boolean zzd() {
        synchronized (zza) {
        }
        return false;
    }
}
