package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public class GoogleSignatureVerifier {
    @Nullable
    private static GoogleSignatureVerifier zza;
    @Nullable
    private static volatile Set zzd;
    @Nullable
    private static volatile Set zze;
    private final Context zzb;
    private volatile String zzc;

    public GoogleSignatureVerifier(Context context) {
        this.zzb = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzo.zza(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c4, code lost:
        r5 = r9;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final boolean zza(android.content.pm.PackageInfo r10, boolean r11) {
        /*
            r0 = 0
            if (r10 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 1
            if (r11 == 0) goto L_0x0028
            java.lang.String r2 = r10.packageName
            java.lang.String r3 = "com.android.vending"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x001b
            java.lang.String r2 = r10.packageName
            java.lang.String r3 = "com.google.android.gms"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0028
        L_0x001b:
            android.content.pm.ApplicationInfo r11 = r10.applicationInfo
            if (r11 != 0) goto L_0x0021
        L_0x001f:
            r11 = r0
            goto L_0x0028
        L_0x0021:
            int r11 = r11.flags
            r11 = r11 & 129(0x81, float:1.81E-43)
            if (r11 == 0) goto L_0x001f
            r11 = r1
        L_0x0028:
            if (r11 == 0) goto L_0x002d
            com.google.android.gms.internal.common.zzah r2 = com.google.android.gms.common.zzn.zzc     // Catch:{ IllegalArgumentException -> 0x00cf }
            goto L_0x002f
        L_0x002d:
            com.google.android.gms.internal.common.zzah r2 = com.google.android.gms.common.zzn.zzb     // Catch:{ IllegalArgumentException -> 0x00cf }
        L_0x002f:
            int r3 = com.google.android.gms.common.util.AndroidUtilsLight.zza     // Catch:{ IllegalArgumentException -> 0x00cf }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ IllegalArgumentException -> 0x00cf }
            r4 = 28
            if (r3 >= r4) goto L_0x0055
            android.content.pm.Signature[] r3 = r10.signatures     // Catch:{ IllegalArgumentException -> 0x00cf }
            r4 = 0
            if (r3 == 0) goto L_0x0049
            android.content.pm.Signature[] r3 = r10.signatures     // Catch:{ IllegalArgumentException -> 0x00cf }
            int r3 = r3.length     // Catch:{ IllegalArgumentException -> 0x00cf }
            if (r3 != r1) goto L_0x0049
            android.content.pm.Signature[] r3 = r10.signatures     // Catch:{ IllegalArgumentException -> 0x00cf }
            r3 = r3[r0]     // Catch:{ IllegalArgumentException -> 0x00cf }
            byte[] r4 = r3.toByteArray()     // Catch:{ IllegalArgumentException -> 0x00cf }
        L_0x0049:
            if (r4 == 0) goto L_0x0050
            com.google.android.gms.internal.common.zzah r3 = com.google.android.gms.internal.common.zzah.zzk(r4)     // Catch:{ IllegalArgumentException -> 0x00cf }
            goto L_0x0094
        L_0x0050:
            com.google.android.gms.internal.common.zzah r3 = com.google.android.gms.internal.common.zzah.zzj()     // Catch:{ IllegalArgumentException -> 0x00cf }
            goto L_0x0094
        L_0x0055:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ IllegalArgumentException -> 0x00cf }
            if (r3 < r4) goto L_0x005b
            r3 = r1
            goto L_0x005c
        L_0x005b:
            r3 = r0
        L_0x005c:
            com.google.android.gms.internal.common.zzr.zza(r3)     // Catch:{ IllegalArgumentException -> 0x00cf }
            android.content.pm.SigningInfo r3 = r10.signingInfo     // Catch:{ IllegalArgumentException -> 0x00cf }
            if (r3 == 0) goto L_0x0090
            boolean r4 = r3.hasMultipleSigners()     // Catch:{ IllegalArgumentException -> 0x00cf }
            if (r4 != 0) goto L_0x0090
            android.content.pm.Signature[] r4 = r3.getSigningCertificateHistory()     // Catch:{ IllegalArgumentException -> 0x00cf }
            if (r4 != 0) goto L_0x0070
            goto L_0x0090
        L_0x0070:
            int r4 = com.google.android.gms.internal.common.zzah.zzd     // Catch:{ IllegalArgumentException -> 0x00cf }
            com.google.android.gms.internal.common.zzad r4 = new com.google.android.gms.internal.common.zzad     // Catch:{ IllegalArgumentException -> 0x00cf }
            r4.<init>()     // Catch:{ IllegalArgumentException -> 0x00cf }
            android.content.pm.Signature[] r3 = r3.getSigningCertificateHistory()     // Catch:{ IllegalArgumentException -> 0x00cf }
            int r5 = r3.length     // Catch:{ IllegalArgumentException -> 0x00cf }
            r6 = r0
        L_0x007d:
            if (r6 >= r5) goto L_0x008b
            r7 = r3[r6]     // Catch:{ IllegalArgumentException -> 0x00cf }
            byte[] r7 = r7.toByteArray()     // Catch:{ IllegalArgumentException -> 0x00cf }
            r4.zzb(r7)     // Catch:{ IllegalArgumentException -> 0x00cf }
            int r6 = r6 + 1
            goto L_0x007d
        L_0x008b:
            com.google.android.gms.internal.common.zzah r3 = r4.zzd()     // Catch:{ IllegalArgumentException -> 0x00cf }
            goto L_0x0094
        L_0x0090:
            com.google.android.gms.internal.common.zzah r3 = com.google.android.gms.internal.common.zzah.zzj()     // Catch:{ IllegalArgumentException -> 0x00cf }
        L_0x0094:
            boolean r4 = r3.isEmpty()     // Catch:{ IllegalArgumentException -> 0x00cf }
            if (r4 != 0) goto L_0x00c7
            com.google.android.gms.internal.common.zzah r3 = r3.zzh()     // Catch:{ IllegalArgumentException -> 0x00cf }
            int r4 = r3.size()     // Catch:{ IllegalArgumentException -> 0x00cf }
            r5 = r0
        L_0x00a3:
            if (r5 >= r4) goto L_0x00c6
            java.lang.Object r6 = r3.get(r5)     // Catch:{ IllegalArgumentException -> 0x00cf }
            byte[] r6 = (byte[]) r6     // Catch:{ IllegalArgumentException -> 0x00cf }
            com.google.android.gms.internal.common.zzal r7 = r2.listIterator(r0)     // Catch:{ IllegalArgumentException -> 0x00cf }
        L_0x00af:
            boolean r8 = r7.hasNext()     // Catch:{ IllegalArgumentException -> 0x00cf }
            int r9 = r5 + 1
            if (r8 == 0) goto L_0x00c4
            java.lang.Object r8 = r7.next()     // Catch:{ IllegalArgumentException -> 0x00cf }
            byte[] r8 = (byte[]) r8     // Catch:{ IllegalArgumentException -> 0x00cf }
            boolean r8 = java.util.Arrays.equals(r6, r8)     // Catch:{ IllegalArgumentException -> 0x00cf }
            if (r8 == 0) goto L_0x00af
            return r1
        L_0x00c4:
            r5 = r9
            goto L_0x00a3
        L_0x00c6:
            return r0
        L_0x00c7:
            java.lang.String r2 = "Unable to obtain package certificate history."
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x00cf }
            r3.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x00cf }
            throw r3     // Catch:{ IllegalArgumentException -> 0x00cf }
        L_0x00cf:
            java.lang.String r2 = "GoogleSignatureVerifier"
            java.lang.String r3 = "package info is not set correctly"
            android.util.Log.i(r2, r3)
            if (r11 == 0) goto L_0x00df
            com.google.android.gms.common.zzj[] r11 = com.google.android.gms.common.zzn.zza
            com.google.android.gms.common.zzj r10 = zzc(r10, r11)
            goto L_0x00eb
        L_0x00df:
            com.google.android.gms.common.zzj[] r11 = new com.google.android.gms.common.zzj[r1]
            com.google.android.gms.common.zzj[] r2 = com.google.android.gms.common.zzn.zza
            r2 = r2[r0]
            r11[r0] = r2
            com.google.android.gms.common.zzj r10 = zzc(r10, r11)
        L_0x00eb:
            if (r10 == 0) goto L_0x00ee
            return r1
        L_0x00ee:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.zza(android.content.pm.PackageInfo, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.common.zzy zzb(@javax.annotation.Nullable java.lang.String r6, boolean r7, boolean r8) {
        /*
            r5 = this;
            java.lang.String r7 = "null pkg"
            if (r6 != 0) goto L_0x0009
            com.google.android.gms.common.zzy r6 = com.google.android.gms.common.zzy.zzc(r7)
            return r6
        L_0x0009:
            java.lang.String r8 = r5.zzc
            boolean r8 = r6.equals(r8)
            if (r8 != 0) goto L_0x00d4
            int r8 = com.google.android.gms.common.zzo.zzh
            android.os.StrictMode$ThreadPolicy r8 = android.os.StrictMode.allowThreadDiskReads()
            r0 = 1
            com.google.android.gms.common.zzo.zzb()     // Catch:{ LoadingException -> 0x004a, RemoteException -> 0x0048 }
            com.google.android.gms.common.internal.zzad r1 = com.google.android.gms.common.zzo.zzg     // Catch:{ LoadingException -> 0x004a, RemoteException -> 0x0048 }
            boolean r1 = r1.zzg()     // Catch:{ LoadingException -> 0x004a, RemoteException -> 0x0048 }
            android.os.StrictMode.setThreadPolicy(r8)
            if (r1 == 0) goto L_0x0055
            com.google.android.gms.common.zzv r7 = new com.google.android.gms.common.zzv
            r8 = 0
            r7.<init>(r8)
            r7.zza(r6)
            android.content.Context r8 = r5.zzb
            boolean r8 = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(r8)
            r7.zzb(r8)
            r7.zzc(r0)
            com.google.android.gms.common.zzw r7 = r7.zzd()
            com.google.android.gms.common.zzy r7 = com.google.android.gms.common.zzo.zzc(r7)
            goto L_0x00bd
        L_0x0045:
            r6 = move-exception
            goto L_0x00d0
        L_0x0048:
            r1 = move-exception
            goto L_0x004b
        L_0x004a:
            r1 = move-exception
        L_0x004b:
            java.lang.String r2 = "GoogleCertificates"
            java.lang.String r3 = "Failed to get Google certificates from remote"
            android.util.Log.e(r2, r3, r1)     // Catch:{ all -> 0x0045 }
            android.os.StrictMode.setThreadPolicy(r8)
        L_0x0055:
            int r8 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r8 < r1) goto L_0x005f
            r8 = 134217792(0x8000040, float:3.8518893E-34)
            goto L_0x0061
        L_0x005f:
            r8 = 64
        L_0x0061:
            android.content.Context r1 = r5.zzb     // Catch:{ NameNotFoundException -> 0x00c4 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00c4 }
            android.content.pm.PackageInfo r8 = r1.getPackageInfo(r6, r8)     // Catch:{ NameNotFoundException -> 0x00c4 }
            android.content.Context r1 = r5.zzb
            boolean r1 = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(r1)
            if (r8 != 0) goto L_0x0078
            com.google.android.gms.common.zzy r7 = com.google.android.gms.common.zzy.zzc(r7)
            goto L_0x00bd
        L_0x0078:
            android.content.pm.Signature[] r7 = r8.signatures
            if (r7 == 0) goto L_0x00b7
            android.content.pm.Signature[] r7 = r8.signatures
            int r7 = r7.length
            if (r7 == r0) goto L_0x0082
            goto L_0x00b7
        L_0x0082:
            com.google.android.gms.common.zzk r7 = new com.google.android.gms.common.zzk
            android.content.pm.Signature[] r2 = r8.signatures
            r3 = 0
            r2 = r2[r3]
            byte[] r2 = r2.toByteArray()
            r7.<init>(r2)
            java.lang.String r2 = r8.packageName
            com.google.android.gms.common.zzy r1 = com.google.android.gms.common.zzo.zzd(r2, r7, r1, r3)
            boolean r4 = r1.zza
            if (r4 == 0) goto L_0x00b5
            android.content.pm.ApplicationInfo r4 = r8.applicationInfo
            if (r4 == 0) goto L_0x00b5
            android.content.pm.ApplicationInfo r8 = r8.applicationInfo
            int r8 = r8.flags
            r8 = r8 & 2
            if (r8 == 0) goto L_0x00b5
            com.google.android.gms.common.zzy r7 = com.google.android.gms.common.zzo.zzd(r2, r7, r3, r0)
            boolean r7 = r7.zza
            if (r7 == 0) goto L_0x00b5
            java.lang.String r7 = "debuggable release cert app rejected"
            com.google.android.gms.common.zzy r7 = com.google.android.gms.common.zzy.zzc(r7)
            goto L_0x00bd
        L_0x00b5:
            r7 = r1
            goto L_0x00bd
        L_0x00b7:
            java.lang.String r7 = "single cert required"
            com.google.android.gms.common.zzy r7 = com.google.android.gms.common.zzy.zzc(r7)
        L_0x00bd:
            boolean r8 = r7.zza
            if (r8 == 0) goto L_0x00c3
            r5.zzc = r6
        L_0x00c3:
            return r7
        L_0x00c4:
            r7 = move-exception
            java.lang.String r8 = "no pkg "
            java.lang.String r6 = r8.concat(r6)
            com.google.android.gms.common.zzy r6 = com.google.android.gms.common.zzy.zzd(r6, r7)
            return r6
        L_0x00d0:
            android.os.StrictMode.setThreadPolicy(r8)
            throw r6
        L_0x00d4:
            com.google.android.gms.common.zzy r6 = com.google.android.gms.common.zzy.zzb()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.zzb(java.lang.String, boolean, boolean):com.google.android.gms.common.zzy");
    }

    @Nullable
    private static zzj zzc(PackageInfo packageInfo, zzj... zzjArr) {
        if (packageInfo.signatures != null) {
            if (packageInfo.signatures.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzk zzk = new zzk(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < zzjArr.length; i++) {
                if (zzjArr[i].equals(zzk)) {
                    return zzjArr[i];
                }
            }
        }
        return null;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (zza(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean isPackageGoogleSigned(@Nullable String str) {
        zzy zzb2 = zzb(str, false, false);
        zzb2.zze();
        return zzb2.zza;
    }

    public boolean isUidGoogleSigned(int i) {
        zzy zzy;
        int length;
        String[] packagesForUid = this.zzb.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzy = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    Preconditions.checkNotNull(zzy);
                    zzy zzy2 = zzy;
                    break;
                }
                zzy = zzb(packagesForUid[i2], false, false);
                if (zzy.zza) {
                    break;
                }
                i2++;
            }
        } else {
            zzy = zzy.zzc("no pkgs");
        }
        zzy.zze();
        return zzy.zza;
    }
}
