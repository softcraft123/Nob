package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.signatureverification.SignatureVerificationConfigurationProvider;
import com.google.android.gms.common.signatureverification.zza;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public class PackageSignatureVerifier {
    static volatile zzac zza;
    private static zzad zzb;

    private static synchronized zzad zza(Context context) {
        zzad zzad;
        synchronized (PackageSignatureVerifier.class) {
            if (zzb == null) {
                zzb = new zzad(context);
            }
            zzad = zzb;
        }
        return zzad;
    }

    public PackageVerificationResult queryPackageSignatureVerified(Context context, String str) {
        String str2;
        boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(context);
        zza(context);
        int i = zzo.zzh;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            zzo.zzb();
            if (zzo.zzg.zzi()) {
                SignatureVerificationConfigurationProvider.zza().zza();
                String.valueOf(str);
                String valueOf = String.valueOf(str);
                if (true != honorsDebugCertificates) {
                    str2 = "-0";
                } else {
                    str2 = "-1";
                }
                String concat = valueOf.concat(str2);
                if (zza != null && zza.zza().equals(concat)) {
                    return zza.zzb();
                }
                str.isEmpty();
                zza(context);
                zzv zzv = new zzv((byte[]) null);
                zzv.zza(str);
                zzv.zzb(honorsDebugCertificates);
                zzv.zzc(false);
                zzy zzc = zzo.zzc(zzv.zzd());
                if (zzc.zza) {
                    PackageVerificationResult zzd = PackageVerificationResult.zzd(str, zzc.zzd, (zza) null);
                    zza = new zzac(concat, zzd);
                    return zzd;
                }
                String str3 = zzc.zzb;
                Preconditions.checkNotNull(str3);
                return PackageVerificationResult.zza(str, str3, zzc.zzc, (zza) null);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
        throw new zzae();
    }

    public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(Context context, String str) {
        try {
            PackageVerificationResult queryPackageSignatureVerified = queryPackageSignatureVerified(context, str);
            queryPackageSignatureVerified.zzc();
            return queryPackageSignatureVerified;
        } catch (SecurityException e) {
            PackageVerificationResult queryPackageSignatureVerified2 = queryPackageSignatureVerified(context, str);
            if (queryPackageSignatureVerified2.zzb()) {
                Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", e);
            }
            return queryPackageSignatureVerified2;
        }
    }
}
