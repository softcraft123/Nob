package com.google.android.gms.common;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public class GooglePlayServicesUtilLight {
    static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
    static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
    public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static final String GOOGLE_SERVICES_FRAMEWORK_PACKAGE = "com.google.android.gsf";
    @Deprecated
    static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();
    public static boolean zza = false;
    public static boolean zzb = false;
    private static final AtomicBoolean zzc = new AtomicBoolean();

    GooglePlayServicesUtilLight() {
    }

    @Deprecated
    public static void cancelAvailabilityErrorNotifications(Context context) {
        if (!sCanceledAvailabilityNotification.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(GMS_AVAILABILITY_NOTIFICATION_ID);
                }
            } catch (SecurityException e) {
                Log.d("GooglePlayServicesUtil", "Suppressing Security Exception %s in cancelAvailabilityErrorNotifications.", e);
            }
        }
    }

    public static void enableUsingApkIndependentContext() {
        zzc.set(true);
    }

    @Deprecated
    public static void ensurePlayServicesAvailable(Context context, int i) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, i);
        if (isGooglePlayServicesAvailable != 0) {
            Intent errorResolutionIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(context, isGooglePlayServicesAvailable, "e");
            StringBuilder sb = new StringBuilder(String.valueOf(isGooglePlayServicesAvailable).length() + 46);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(isGooglePlayServicesAvailable);
            Log.e("GooglePlayServicesUtil", sb.toString());
            if (errorResolutionIntent == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", errorResolutionIntent);
        }
    }

    @Deprecated
    public static int getApkVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @Deprecated
    public static int getClientVersion(Context context) {
        Preconditions.checkState(true);
        return ClientLibraryUtils.getClientVersion(context, context.getPackageName());
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.zza(i);
    }

    @Deprecated
    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int i) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent((Context) null, i, (String) null);
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean honorsDebugCertificates(Context context) {
        if (!zzb) {
            try {
                PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.google.android.gms", Build.VERSION.SDK_INT >= 28 ? 134217792 : 64);
                GoogleSignatureVerifier.getInstance(context);
                if (packageInfo == null || GoogleSignatureVerifier.zza(packageInfo, false) || !GoogleSignatureVerifier.zza(packageInfo, true)) {
                    zza = false;
                } else {
                    zza = true;
                }
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
            } finally {
                zzb = true;
            }
        }
        return zza || !DeviceProperties.isUserBuild();
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @Deprecated
    public static boolean isGooglePlayServicesUid(Context context, int i) {
        return UidVerifier.isGooglePlayServicesUid(context, i);
    }

    @Deprecated
    public static boolean isPlayServicesPossiblyUpdating(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return zza(context, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean isPlayStorePossiblyUpdating(Context context, int i) {
        if (i == 9) {
            return zza(context, "com.android.vending");
        }
        return false;
    }

    public static boolean isRestrictedUserProfile(Context context) {
        Object systemService = context.getSystemService("user");
        Preconditions.checkNotNull(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        return applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    @Deprecated
    public static boolean isSidewinderDevice(Context context) {
        return DeviceProperties.isSidewinder(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    @Deprecated
    public static boolean uidHasPackageName(Context context, int i, String str) {
        return UidVerifier.uidHasPackageName(context, i, str);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean zza(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "com.google.android.gms"
            boolean r0 = r6.equals(r0)
            r1 = 0
            android.content.pm.PackageManager r2 = r5.getPackageManager()     // Catch:{ Exception -> 0x0049 }
            android.content.pm.PackageInstaller r2 = r2.getPackageInstaller()     // Catch:{ Exception -> 0x0049 }
            java.util.List r2 = r2.getAllSessions()     // Catch:{ Exception -> 0x0049 }
            java.util.Iterator r2 = r2.iterator()
        L_0x0017:
            boolean r3 = r2.hasNext()
            r4 = 1
            if (r3 == 0) goto L_0x002f
            java.lang.Object r3 = r2.next()
            android.content.pm.PackageInstaller$SessionInfo r3 = (android.content.pm.PackageInstaller.SessionInfo) r3
            java.lang.String r3 = r3.getAppPackageName()
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x0017
            return r4
        L_0x002f:
            android.content.pm.PackageManager r2 = r5.getPackageManager()
            r3 = 8192(0x2000, float:1.14794E-41)
            android.content.pm.ApplicationInfo r6 = r2.getApplicationInfo(r6, r3)     // Catch:{  }
            if (r0 == 0) goto L_0x003e
            boolean r5 = r6.enabled     // Catch:{  }
            return r5
        L_0x003e:
            boolean r6 = r6.enabled     // Catch:{  }
            if (r6 == 0) goto L_0x0049
            boolean r5 = isRestrictedUserProfile(r5)     // Catch:{  }
            if (r5 != 0) goto L_0x0049
            return r4
        L_0x0049:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GooglePlayServicesUtilLight.zza(android.content.Context, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x008d A[Catch:{ NameNotFoundException -> 0x0167 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0091 A[Catch:{ NameNotFoundException -> 0x0167 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b1  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int isGooglePlayServicesAvailable(android.content.Context r11, int r12) {
        /*
            java.lang.String r0 = "GooglePlayServicesUtil"
            android.content.res.Resources r1 = r11.getResources()     // Catch:{ all -> 0x000c }
            int r2 = com.google.android.gms.common.R.string.common_google_play_services_unknown_issue     // Catch:{ all -> 0x000c }
            r1.getString(r2)     // Catch:{ all -> 0x000c }
            goto L_0x0011
        L_0x000c:
            java.lang.String r1 = "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included."
            android.util.Log.e(r0, r1)
        L_0x0011:
            java.lang.String r1 = r11.getPackageName()
            java.lang.String r2 = "com.google.android.gms"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x003d
            java.util.concurrent.atomic.AtomicBoolean r1 = zzc
            boolean r1 = r1.get()
            if (r1 == 0) goto L_0x0026
            goto L_0x003d
        L_0x0026:
            int r1 = com.google.android.gms.common.internal.zzae.zzb(r11)
            if (r1 == 0) goto L_0x0037
            int r3 = GOOGLE_PLAY_SERVICES_VERSION_CODE
            if (r1 != r3) goto L_0x0031
            goto L_0x003d
        L_0x0031:
            com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException r11 = new com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException
            r11.<init>(r1)
            throw r11
        L_0x0037:
            com.google.android.gms.common.GooglePlayServicesMissingManifestValueException r11 = new com.google.android.gms.common.GooglePlayServicesMissingManifestValueException
            r11.<init>()
            throw r11
        L_0x003d:
            boolean r1 = com.google.android.gms.common.util.DeviceProperties.isWearableWithoutPlayStore(r11)
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L_0x004d
            boolean r1 = com.google.android.gms.common.util.DeviceProperties.zzd(r11)
            if (r1 != 0) goto L_0x004d
            r1 = r3
            goto L_0x004e
        L_0x004d:
            r1 = r4
        L_0x004e:
            if (r12 < 0) goto L_0x0052
            r5 = r3
            goto L_0x0053
        L_0x0052:
            r5 = r4
        L_0x0053:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r5)
            java.lang.String r5 = r11.getPackageName()
            android.content.pm.PackageManager r6 = r11.getPackageManager()
            r7 = 28
            r8 = 9
            if (r1 == 0) goto L_0x0088
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ NameNotFoundException -> 0x0075 }
            if (r9 < r7) goto L_0x006c
            r9 = 134225984(0x8002040, float:3.855651E-34)
            goto L_0x006e
        L_0x006c:
            r9 = 8256(0x2040, float:1.1569E-41)
        L_0x006e:
            java.lang.String r10 = "com.android.vending"
            android.content.pm.PackageInfo r9 = r6.getPackageInfo(r10, r9)     // Catch:{ NameNotFoundException -> 0x0075 }
            goto L_0x0089
        L_0x0075:
            java.lang.String.valueOf(r5)
            java.lang.String r11 = java.lang.String.valueOf(r5)
            java.lang.String r12 = " requires the Google Play Store, but it is missing."
            java.lang.String r11 = r11.concat(r12)
            android.util.Log.w(r0, r11)
        L_0x0085:
            r3 = r8
            goto L_0x0177
        L_0x0088:
            r9 = 0
        L_0x0089:
            int r10 = android.os.Build.VERSION.SDK_INT     // Catch:{ NameNotFoundException -> 0x0167 }
            if (r10 < r7) goto L_0x0091
            r7 = 134217792(0x8000040, float:3.8518893E-34)
            goto L_0x0093
        L_0x0091:
            r7 = 64
        L_0x0093:
            android.content.pm.PackageInfo r7 = r6.getPackageInfo(r2, r7)     // Catch:{ NameNotFoundException -> 0x0167 }
            com.google.android.gms.common.GoogleSignatureVerifier.getInstance(r11)
            boolean r11 = com.google.android.gms.common.GoogleSignatureVerifier.zza(r7, r3)
            if (r11 != 0) goto L_0x00b1
            java.lang.String.valueOf(r5)
            java.lang.String r11 = java.lang.String.valueOf(r5)
            java.lang.String r12 = " requires Google Play services, but their signature is invalid."
            java.lang.String r11 = r11.concat(r12)
            android.util.Log.w(r0, r11)
            goto L_0x0085
        L_0x00b1:
            if (r1 == 0) goto L_0x00d0
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            r11 = r9
            android.content.pm.PackageInfo r11 = (android.content.pm.PackageInfo) r11
            boolean r11 = com.google.android.gms.common.GoogleSignatureVerifier.zza(r9, r3)
            if (r11 != 0) goto L_0x00d0
            java.lang.String.valueOf(r5)
            java.lang.String r11 = java.lang.String.valueOf(r5)
            java.lang.String r12 = " requires Google Play Store, but its signature is invalid."
            java.lang.String r11 = r11.concat(r12)
            android.util.Log.w(r0, r11)
            goto L_0x0085
        L_0x00d0:
            if (r1 == 0) goto L_0x00f3
            if (r9 == 0) goto L_0x00f3
            android.content.pm.Signature[] r11 = r9.signatures
            r11 = r11[r4]
            android.content.pm.Signature[] r1 = r7.signatures
            r1 = r1[r4]
            boolean r11 = r11.equals(r1)
            if (r11 != 0) goto L_0x00f3
            java.lang.String.valueOf(r5)
            java.lang.String r11 = java.lang.String.valueOf(r5)
            java.lang.String r12 = " requires Google Play Store, but its signature doesn't match that of Google Play services."
            java.lang.String r11 = r11.concat(r12)
            android.util.Log.w(r0, r11)
            goto L_0x0085
        L_0x00f3:
            int r11 = r7.versionCode
            int r11 = com.google.android.gms.common.util.zzb.zza(r11)
            int r1 = com.google.android.gms.common.util.zzb.zza(r12)
            if (r11 >= r1) goto L_0x0145
            int r11 = r7.versionCode
            java.lang.String r1 = java.lang.String.valueOf(r5)
            int r1 = r1.length()
            java.lang.String r2 = java.lang.String.valueOf(r12)
            int r1 = r1 + 49
            int r2 = r2.length()
            java.lang.String r3 = java.lang.String.valueOf(r11)
            int r1 = r1 + r2
            int r1 = r1 + 11
            int r2 = r3.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r1 = r1 + r2
            r3.<init>(r1)
            java.lang.String r1 = "Google Play services out of date for "
            r3.append(r1)
            r3.append(r5)
            java.lang.String r1 = ".  Requires "
            r3.append(r1)
            r3.append(r12)
            java.lang.String r12 = " but found "
            r3.append(r12)
            r3.append(r11)
            java.lang.String r11 = r3.toString()
            android.util.Log.w(r0, r11)
            r3 = 2
            goto L_0x0177
        L_0x0145:
            android.content.pm.ApplicationInfo r11 = r7.applicationInfo
            if (r11 != 0) goto L_0x0160
            android.content.pm.ApplicationInfo r11 = r6.getApplicationInfo(r2, r4)     // Catch:{ NameNotFoundException -> 0x014e }
            goto L_0x0160
        L_0x014e:
            r11 = move-exception
            java.lang.String.valueOf(r5)
            java.lang.String r12 = java.lang.String.valueOf(r5)
            java.lang.String r1 = " requires Google Play services, but they're missing when getting application info."
            java.lang.String r12 = r12.concat(r1)
            android.util.Log.wtf(r0, r12, r11)
            goto L_0x0177
        L_0x0160:
            boolean r11 = r11.enabled
            if (r11 != 0) goto L_0x0166
            r3 = 3
            goto L_0x0177
        L_0x0166:
            return r4
        L_0x0167:
            java.lang.String.valueOf(r5)
            java.lang.String r11 = java.lang.String.valueOf(r5)
            java.lang.String r12 = " requires Google Play services, but they are missing."
            java.lang.String r11 = r11.concat(r12)
            android.util.Log.w(r0, r11)
        L_0x0177:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(android.content.Context, int):int");
    }
}
