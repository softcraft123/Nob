package com.google.android.gms.common.util;

import android.os.Process;
import com.google.android.gms.internal.common.zzi;
import com.google.android.gms.internal.common.zzj;
import com.google.android.gms.internal.common.zzx;
import com.google.android.gms.internal.common.zzy;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public class ProcessUtils {
    @Nullable
    private static String zza;
    private static int zzb;
    @Nullable
    private static Boolean zzc;

    private ProcessUtils() {
    }

    public static boolean zza() {
        Boolean bool = zzc;
        if (bool == null) {
            if (PlatformVersion.isAtLeastP()) {
                bool = Boolean.valueOf(Process.isIsolated());
            } else {
                try {
                    Object zza2 = zzj.zza(Process.class, "isIsolated", new zzi[0]);
                    Object[] objArr = new Object[0];
                    if (zza2 != null) {
                        bool = (Boolean) zza2;
                    } else {
                        throw new zzy(zzx.zza("expected a non-null reference", objArr));
                    }
                } catch (ReflectiveOperationException unused) {
                    bool = false;
                }
            }
            zzc = bool;
        }
        return bool.booleanValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMyProcessName() {
        /*
            java.lang.String r0 = zza
            if (r0 != 0) goto L_0x0072
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L_0x0011
            java.lang.String r0 = android.app.Application.getProcessName()
            zza = r0
            goto L_0x0072
        L_0x0011:
            int r0 = zzb
            if (r0 != 0) goto L_0x001b
            int r0 = android.os.Process.myPid()
            zzb = r0
        L_0x001b:
            java.lang.String r1 = "/cmdline"
            java.lang.String r2 = "/proc/"
            r3 = 0
            if (r0 > 0) goto L_0x0023
            goto L_0x0070
        L_0x0023:
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x006c, all -> 0x0067 }
            int r4 = r4.length()     // Catch:{ IOException -> 0x006c, all -> 0x0067 }
            int r4 = r4 + 14
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x006c, all -> 0x0067 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x006c, all -> 0x0067 }
            r5.append(r2)     // Catch:{ IOException -> 0x006c, all -> 0x0067 }
            r5.append(r0)     // Catch:{ IOException -> 0x006c, all -> 0x0067 }
            r5.append(r1)     // Catch:{ IOException -> 0x006c, all -> 0x0067 }
            java.lang.String r0 = r5.toString()     // Catch:{ IOException -> 0x006c, all -> 0x0067 }
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()     // Catch:{ IOException -> 0x006c, all -> 0x0067 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0062 }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ all -> 0x0062 }
            r4.<init>(r0)     // Catch:{ all -> 0x0062 }
            r2.<init>(r4)     // Catch:{ all -> 0x0062 }
            android.os.StrictMode.setThreadPolicy(r1)     // Catch:{ IOException -> 0x006c, all -> 0x0067 }
            java.lang.String r0 = r2.readLine()     // Catch:{ IOException -> 0x006d, all -> 0x005f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ IOException -> 0x006d, all -> 0x005f }
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ IOException -> 0x006d, all -> 0x005f }
            java.lang.String r3 = r0.trim()     // Catch:{ IOException -> 0x006d, all -> 0x005f }
            goto L_0x006d
        L_0x005f:
            r0 = move-exception
            r3 = r2
            goto L_0x0068
        L_0x0062:
            r0 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)     // Catch:{ IOException -> 0x006c, all -> 0x0067 }
            throw r0     // Catch:{ IOException -> 0x006c, all -> 0x0067 }
        L_0x0067:
            r0 = move-exception
        L_0x0068:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r3)
            throw r0
        L_0x006c:
            r2 = r3
        L_0x006d:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)
        L_0x0070:
            zza = r3
        L_0x0072:
            java.lang.String r0 = zza
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.ProcessUtils.getMyProcessName():java.lang.String");
    }
}
