package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
final class zzo {
    static final zzm zza = new zzd(zzj.zzf("0\u0005È0\u0003° \u0003\u0002\u0001\u0002\u0002\u0014¢fú§pxb±"));
    static final zzm zzb = new zze(zzj.zzf("0\u0006\u00040\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014QÕÛ\u0004÷XçB<"));
    static final zzm zzc = new zzf(zzj.zzf("0\u0005È0\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010e\bsù/Qí"));
    static final zzm zzd = new zzg(zzj.zzf("0\u0006\u00040\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²­×árÊkì"));
    static final zzm zze = new zzh(zzj.zzf("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00"));
    static final zzm zzf = new zzi(zzj.zzf("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0"));
    static volatile zzad zzg;
    public static final /* synthetic */ int zzh = 0;
    private static final Object zzi = new Object();
    private static Context zzj;

    static synchronized void zza(Context context) {
        synchronized (zzo.class) {
            if (zzj != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                zzj = context.getApplicationContext();
            }
        }
    }

    static void zzb() throws DynamiteModule.LoadingException {
        if (zzg == null) {
            Preconditions.checkNotNull(zzj);
            synchronized (zzi) {
                if (zzg == null) {
                    zzg = zzac.zzb(DynamiteModule.load(zzj, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            }
        }
    }

    static zzy zzc(zzw zzw) {
        zzy zzy;
        zzr zzr;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.checkNotNull(zzj);
            try {
                zzb();
                Preconditions.checkNotNull(zzj);
                zzp zzb2 = zzw.zzb(zzj);
                if (zzw.zza()) {
                    zzr = zzg.zzf(zzb2);
                } else {
                    zzr = zzg.zzh(zzb2);
                }
                if (zzr.zza()) {
                    zzy = zzy.zzf(zzr.zze(), zzr.zzc());
                } else {
                    String zzb3 = zzr.zzb();
                    PackageManager.NameNotFoundException nameNotFoundException = zzr.zzd() == 4 ? new PackageManager.NameNotFoundException() : null;
                    if (zzb3 == null) {
                        zzb3 = "error checking package certificate";
                    }
                    zzy = zzy.zzg(zzr.zze(), zzr.zzd(), zzb3, nameNotFoundException);
                }
            } catch (DynamiteModule.LoadingException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                String message = e.getMessage();
                String.valueOf(message);
                zzy = zzy.zzd("module init: ".concat(String.valueOf(message)), e);
            }
        } catch (RemoteException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            zzy = zzy.zzd("module call", e2);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return zzy;
    }

    @Deprecated
    static zzy zzd(String str, zzj zzj2, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return zzf(str, zzj2, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    static /* synthetic */ String zze(boolean z, String str, zzj zzj2) {
        String str2;
        if (z || !zzf(str, zzj2, true, false).zza) {
            str2 = "not allowed";
        } else {
            str2 = "debug cert rejected";
        }
        MessageDigest zza2 = AndroidUtilsLight.zza("SHA-256");
        Preconditions.checkNotNull(zza2);
        MessageDigest messageDigest = zza2;
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", new Object[]{str2, str, Hex.bytesToStringLowercase(zza2.digest(zzj2.zzc())), Boolean.valueOf(z), "12451000.false"});
    }

    @Deprecated
    private static zzy zzf(String str, zzj zzj2, boolean z, boolean z2) {
        try {
            zzb();
            Preconditions.checkNotNull(zzj);
            try {
                return zzg.zze(new zzt(str, zzj2, z, z2), ObjectWrapper.wrap(zzj.getPackageManager())) ? zzy.zzb() : new zzx(new zzl(z, str, zzj2), (byte[]) null);
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return zzy.zzd("module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            String message = e2.getMessage();
            String.valueOf(message);
            return zzy.zzd("module init: ".concat(String.valueOf(message)), e2);
        }
    }
}
