package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    /* access modifiers changed from: private */
    public static final GoogleApiAvailabilityLight zza = GoogleApiAvailabilityLight.getInstance();
    private static final Object zzb = new Object();
    private static Method zzc = null;
    private static boolean zzd = false;

    /* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void installIfNeeded(android.content.Context r14) throws com.google.android.gms.common.GooglePlayServicesRepairableException, com.google.android.gms.common.GooglePlayServicesNotAvailableException {
        /*
            java.lang.String r0 = "Context must not be null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14, r0)
            com.google.android.gms.common.GoogleApiAvailabilityLight r0 = zza
            r1 = 11925000(0xb5f608, float:1.6710484E-38)
            r0.verifyGooglePlayServicesIsAvailable(r14, r1)
            long r0 = android.os.SystemClock.uptimeMillis()
            java.lang.Object r2 = zzb
            monitor-enter(r2)
            boolean r3 = zzd     // Catch:{ all -> 0x00a7 }
            r4 = 0
            if (r3 != 0) goto L_0x0047
            java.lang.String r3 = "Failed to load providerinstaller module: "
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy r5 = com.google.android.gms.dynamite.DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING     // Catch:{ LoadingException -> 0x0028 }
            java.lang.String r6 = "com.google.android.gms.providerinstaller.dynamite"
            com.google.android.gms.dynamite.DynamiteModule r5 = com.google.android.gms.dynamite.DynamiteModule.load(r14, r5, r6)     // Catch:{ LoadingException -> 0x0028 }
            android.content.Context r3 = r5.getModuleContext()     // Catch:{ LoadingException -> 0x0028 }
            goto L_0x003e
        L_0x0028:
            r5 = move-exception
            java.lang.String r6 = "ProviderInstaller"
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x00a7 }
            java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00a7 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = r3.concat(r5)     // Catch:{ all -> 0x00a7 }
            android.util.Log.w(r6, r3)     // Catch:{ all -> 0x00a7 }
            r3 = r4
        L_0x003e:
            if (r3 == 0) goto L_0x0047
            java.lang.String r0 = "com.google.android.gms.providerinstaller.ProviderInstallerImpl"
            zzb(r3, r14, r0)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r2)     // Catch:{ all -> 0x00a7 }
            goto L_0x0097
        L_0x0047:
            boolean r3 = zzd     // Catch:{ all -> 0x00a7 }
            java.lang.String r5 = "Failed to report request stats: "
            android.content.Context r6 = com.google.android.gms.common.GooglePlayServicesUtilLight.getRemoteContext(r14)     // Catch:{ all -> 0x00a7 }
            if (r6 != 0) goto L_0x0052
            goto L_0x008f
        L_0x0052:
            r4 = 1
            zzd = r4     // Catch:{ all -> 0x00a7 }
            if (r3 != 0) goto L_0x008e
            long r7 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x0080 }
            java.lang.String r3 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            java.lang.String r9 = "reportRequestStats2"
            java.lang.ClassLoader r10 = r6.getClassLoader()     // Catch:{ Exception -> 0x0080 }
            r11 = 3
            com.google.android.gms.internal.common.zzi[] r11 = new com.google.android.gms.internal.common.zzi[r11]     // Catch:{ Exception -> 0x0080 }
            java.lang.Class<android.content.Context> r12 = android.content.Context.class
            com.google.android.gms.internal.common.zzi r12 = com.google.android.gms.internal.common.zzi.zzb(r12, r14)     // Catch:{ Exception -> 0x0080 }
            r13 = 0
            r11[r13] = r12     // Catch:{ Exception -> 0x0080 }
            com.google.android.gms.internal.common.zzh r0 = com.google.android.gms.internal.common.zzh.zza(r0)     // Catch:{ Exception -> 0x0080 }
            r11[r4] = r0     // Catch:{ Exception -> 0x0080 }
            com.google.android.gms.internal.common.zzh r0 = com.google.android.gms.internal.common.zzh.zza(r7)     // Catch:{ Exception -> 0x0080 }
            r1 = 2
            r11[r1] = r0     // Catch:{ Exception -> 0x0080 }
            com.google.android.gms.internal.common.zzj.zzb(r3, r9, r10, r11)     // Catch:{ Exception -> 0x0080 }
            goto L_0x008e
        L_0x0080:
            r0 = move-exception
            java.lang.String r1 = "ProviderInstaller"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = r5.concat(r0)     // Catch:{ all -> 0x00a7 }
            android.util.Log.w(r1, r0)     // Catch:{ all -> 0x00a7 }
        L_0x008e:
            r4 = r6
        L_0x008f:
            if (r4 == 0) goto L_0x0098
            java.lang.String r0 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            zzb(r4, r14, r0)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r2)     // Catch:{ all -> 0x00a7 }
        L_0x0097:
            return
        L_0x0098:
            java.lang.String r14 = "ProviderInstaller"
            java.lang.String r0 = "Failed to get remote context"
            android.util.Log.e(r14, r0)     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.common.GooglePlayServicesNotAvailableException r14 = new com.google.android.gms.common.GooglePlayServicesNotAvailableException     // Catch:{ all -> 0x00a7 }
            r0 = 8
            r14.<init>(r0)     // Catch:{ all -> 0x00a7 }
            throw r14     // Catch:{ all -> 0x00a7 }
        L_0x00a7:
            r14 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00a7 }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.security.ProviderInstaller.installIfNeeded(android.content.Context):void");
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute(new Void[0]);
    }

    private static void zzb(Context context, Context context2, String str) throws GooglePlayServicesNotAvailableException {
        try {
            if (zzc == null) {
                zzc = context.getClassLoader().loadClass(str).getMethod("insertProvider", new Class[]{Context.class});
            }
            zzc.invoke((Object) null, new Object[]{context});
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                String exc = cause == null ? e.toString() : cause.toString();
                String.valueOf(exc);
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(exc)));
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }
}
