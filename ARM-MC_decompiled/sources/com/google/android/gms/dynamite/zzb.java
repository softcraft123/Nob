package com.google.android.gms.dynamite;

/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
public final class zzb {
    private static ClassLoader zza;
    private static Thread zzb;

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ad, code lost:
        if (r2 == null) goto L_0x00e1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.ClassLoader zza() {
        /*
            java.lang.Class<com.google.android.gms.dynamite.zzb> r0 = com.google.android.gms.dynamite.zzb.class
            monitor-enter(r0)
            java.lang.ClassLoader r1 = zza     // Catch:{ all -> 0x00ea }
            if (r1 != 0) goto L_0x00e6
            java.lang.String r1 = "Failed to get thread context classloader "
            java.lang.Thread r2 = zzb     // Catch:{ all -> 0x00ea }
            r3 = 0
            if (r2 != 0) goto L_0x00b2
            android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x00ea }
            java.lang.Thread r2 = r2.getThread()     // Catch:{ all -> 0x00ea }
            java.lang.ThreadGroup r2 = r2.getThreadGroup()     // Catch:{ all -> 0x00ea }
            java.lang.String r4 = "Failed to enumerate thread/threadgroup "
            if (r2 != 0) goto L_0x0021
            r2 = r3
            goto L_0x00ab
        L_0x0021:
            java.lang.Class<java.lang.Void> r5 = java.lang.Void.class
            monitor-enter(r5)     // Catch:{ all -> 0x00ea }
            int r6 = r2.activeGroupCount()     // Catch:{ SecurityException -> 0x0084 }
            java.lang.ThreadGroup[] r7 = new java.lang.ThreadGroup[r6]     // Catch:{ SecurityException -> 0x0084 }
            r2.enumerate(r7)     // Catch:{ SecurityException -> 0x0084 }
            r8 = 0
            r9 = r8
        L_0x002f:
            if (r9 >= r6) goto L_0x0043
            r10 = r7[r9]     // Catch:{ SecurityException -> 0x0084 }
            java.lang.String r11 = "dynamiteLoader"
            java.lang.String r12 = r10.getName()     // Catch:{ SecurityException -> 0x0084 }
            boolean r11 = r11.equals(r12)     // Catch:{ SecurityException -> 0x0084 }
            if (r11 == 0) goto L_0x0040
            goto L_0x0044
        L_0x0040:
            int r9 = r9 + 1
            goto L_0x002f
        L_0x0043:
            r10 = r3
        L_0x0044:
            if (r10 != 0) goto L_0x004d
            java.lang.ThreadGroup r10 = new java.lang.ThreadGroup     // Catch:{ SecurityException -> 0x0084 }
            java.lang.String r6 = "dynamiteLoader"
            r10.<init>(r2, r6)     // Catch:{ SecurityException -> 0x0084 }
        L_0x004d:
            int r2 = r10.activeCount()     // Catch:{ SecurityException -> 0x0084 }
            java.lang.Thread[] r6 = new java.lang.Thread[r2]     // Catch:{ SecurityException -> 0x0084 }
            r10.enumerate(r6)     // Catch:{ SecurityException -> 0x0084 }
        L_0x0056:
            if (r8 >= r2) goto L_0x006a
            r7 = r6[r8]     // Catch:{ SecurityException -> 0x0084 }
            java.lang.String r9 = "GmsDynamite"
            java.lang.String r11 = r7.getName()     // Catch:{ SecurityException -> 0x0084 }
            boolean r9 = r9.equals(r11)     // Catch:{ SecurityException -> 0x0084 }
            if (r9 == 0) goto L_0x0067
            goto L_0x006b
        L_0x0067:
            int r8 = r8 + 1
            goto L_0x0056
        L_0x006a:
            r7 = r3
        L_0x006b:
            if (r7 != 0) goto L_0x00a9
            com.google.android.gms.dynamite.zza r2 = new com.google.android.gms.dynamite.zza     // Catch:{ SecurityException -> 0x007f }
            java.lang.String r6 = "GmsDynamite"
            r2.<init>(r10, r6)     // Catch:{ SecurityException -> 0x007f }
            r2.setContextClassLoader(r3)     // Catch:{ SecurityException -> 0x007c }
            r2.start()     // Catch:{ SecurityException -> 0x007c }
            r7 = r2
            goto L_0x00a9
        L_0x007c:
            r6 = move-exception
            r7 = r2
            goto L_0x0087
        L_0x007f:
            r2 = move-exception
            r6 = r2
            goto L_0x0087
        L_0x0082:
            r1 = move-exception
            goto L_0x00b0
        L_0x0084:
            r2 = move-exception
            r6 = r2
            r7 = r3
        L_0x0087:
            java.lang.String r2 = "DynamiteLoaderV2CL"
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0082 }
            java.lang.String r8 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0082 }
            int r8 = r8.length()     // Catch:{ all -> 0x0082 }
            int r8 = r8 + 39
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            r9.<init>(r8)     // Catch:{ all -> 0x0082 }
            r9.append(r4)     // Catch:{ all -> 0x0082 }
            r9.append(r6)     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = r9.toString()     // Catch:{ all -> 0x0082 }
            android.util.Log.w(r2, r4)     // Catch:{ all -> 0x0082 }
        L_0x00a9:
            monitor-exit(r5)     // Catch:{ all -> 0x0082 }
            r2 = r7
        L_0x00ab:
            zzb = r2     // Catch:{ all -> 0x00ea }
            if (r2 != 0) goto L_0x00b2
            goto L_0x00e1
        L_0x00b0:
            monitor-exit(r5)     // Catch:{ all -> 0x0082 }
            throw r1     // Catch:{ all -> 0x00ea }
        L_0x00b2:
            monitor-enter(r2)     // Catch:{ all -> 0x00ea }
            java.lang.Thread r4 = zzb     // Catch:{ SecurityException -> 0x00bd }
            java.lang.ClassLoader r1 = r4.getContextClassLoader()     // Catch:{ SecurityException -> 0x00bd }
            r3 = r1
            goto L_0x00e0
        L_0x00bb:
            r1 = move-exception
            goto L_0x00e4
        L_0x00bd:
            r4 = move-exception
            java.lang.String r5 = "DynamiteLoaderV2CL"
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x00bb }
            java.lang.String r6 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00bb }
            int r6 = r6.length()     // Catch:{ all -> 0x00bb }
            int r6 = r6 + 41
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bb }
            r7.<init>(r6)     // Catch:{ all -> 0x00bb }
            r7.append(r1)     // Catch:{ all -> 0x00bb }
            r7.append(r4)     // Catch:{ all -> 0x00bb }
            java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x00bb }
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x00bb }
        L_0x00e0:
            monitor-exit(r2)     // Catch:{ all -> 0x00bb }
        L_0x00e1:
            zza = r3     // Catch:{ all -> 0x00ea }
            goto L_0x00e6
        L_0x00e4:
            monitor-exit(r2)     // Catch:{ all -> 0x00bb }
            throw r1     // Catch:{ all -> 0x00ea }
        L_0x00e6:
            java.lang.ClassLoader r1 = zza     // Catch:{ all -> 0x00ea }
            monitor-exit(r0)
            return r1
        L_0x00ea:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ea }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.zzb.zza():java.lang.ClassLoader");
    }
}
